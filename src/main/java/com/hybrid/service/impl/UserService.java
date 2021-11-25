package com.hybrid.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.hybrid.common.ERole;
import com.hybrid.entity.RoleEntity;
import com.hybrid.repository.RoleRepository;
import com.hybrid.request.UserRequest;
import com.hybrid.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hybrid.entity.BaseEntity;
import com.hybrid.entity.ForgotPasswordEntity;
import com.hybrid.entity.UserEntity;
import com.hybrid.repository.ForgotPasswordRepository;
import com.hybrid.repository.UserRepository;
import com.hybrid.request.ChangePasswordRequest;
import com.hybrid.request.ResetPasswordRequest;
import com.hybrid.response.BaseResponse;

@Service
public class UserService implements IUserService {
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private ForgotPasswordRepository forgotRepo;

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public BaseResponse forgotPassword(String token, String email) {
		BaseResponse baseResponse = new BaseResponse();
		UserEntity userEntity = userRepo.findOneByEmail(email);
		if (userEntity != null) {
			ForgotPasswordEntity forgotPass = new ForgotPasswordEntity();
			forgotPass.setEmail(email);
			forgotPass.setToken(token);
			forgotRepo.save(forgotPass);
			try {
				sendEmail(email, "/reset_password?token=" + token);
			} catch (UnsupportedEncodingException | MessagingException e) {
				//logger
				baseResponse.setReponseCode(500);
				baseResponse.setMessage("Server error");
				return baseResponse;
			}
			baseResponse.setReponseCode(200);
			baseResponse.setMessage("Confirmation successfully");
		} else {
			baseResponse.setReponseCode(400);
			baseResponse.setMessage("Email does not exists");
		}
		return baseResponse;
	}

	public ForgotPasswordEntity getResetPasswordToken(String token) {

		return forgotRepo.findOneByToken(token);// do token lưu riêng trong bảng forgotPassword

	}

	public UserEntity getUser(String email) {
		return userRepo.findOneByEmail(email);
	}
	
	public UserEntity getUser(Integer id) {
		return userRepo.findOneById(id);
	}

	public BaseResponse resetPassword(ResetPasswordRequest passRequest) {
		BaseResponse baseResponse = new BaseResponse();
		String password = passRequest.getPassword();
		String confirmPassword = passRequest.getConfirmPassword();
		if (password.equals(confirmPassword)) // đã valid password anh cofirm not null
		{
			String token = passRequest.getToken();
			ForgotPasswordEntity forgotPasswordEntity = getResetPasswordToken(token);
			if (forgotPasswordEntity == null) {
				baseResponse.setReponseCode(400);
				baseResponse.setMessage("Token does not exists");
			} else {
				UserEntity userEntity = getUser(forgotPasswordEntity.getEmail());
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				String encodedPassword = passwordEncoder.encode(password);
				userEntity.setPassword(encodedPassword);
				forgotRepo.deleteById(forgotPasswordEntity.getId());
				userRepo.save(userEntity);
				baseResponse.setReponseCode(200);
				baseResponse.setMessage("Reset password successfully!");
			}
		} else {
			baseResponse.setReponseCode(401);
			baseResponse.setMessage("Confirm new password doesn't not match new password!");
		}
		return baseResponse;

	}

	public void sendEmail(String recipientEmail, String link) throws MessagingException, UnsupportedEncodingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		helper.setFrom("contact@shopme.com", "HyLift support");
		helper.setTo(recipientEmail);

		String subject = "Here's the link to reset your password";

		String content = "<p>Hello,</p>" + "<p>You have requested to reset your password.</p>"
				+ "<p>Click the link below to change your password:</p>" + "<p><a href=\"" + link
				+ "\">Change my password</a></p>" + "<br>" + "<p>Ignore this email if you do remember your password, "
				+ "or you have not made the request.</p>";

		helper.setSubject(subject);

		helper.setText(content, true);

		mailSender.send(message);
	}

	public BaseResponse changePassword(ChangePasswordRequest changePasswordRequest) {
    	BaseResponse baseResponse = new BaseResponse();
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	if (passwordEncoder.matches( changePasswordRequest.getCurrentPassword(), userRepo.findOneById(userDetail.getId()).getPassword())) {
    		if (changePasswordRequest.getNewPassword().equals(changePasswordRequest.getConfirmNewPassword())) // đã valid password anh cofirm not null
    		{
    				UserEntity userEntity = getUser(userDetail.getId());
    				String encodedPassword = passwordEncoder.encode(changePasswordRequest.getNewPassword());
    				userEntity.setPassword(encodedPassword);
    				userRepo.save(userEntity);
    				baseResponse.setReponseCode(200);
    				baseResponse.setMessage("Change password successfully!");
    		} else {
    			baseResponse.setReponseCode(401);
    			baseResponse.setMessage("Confirm new password doesn't not match new password!");
    		}
    	} else {
    		baseResponse.setReponseCode(400);
    		baseResponse.setMessage("Current password is incorrect");
    	}
    	return baseResponse;
    }

	@Override
	public Boolean checkExistEmail(String email){
		return userRepo.existsByEmail(email);
	}

	@Override
	public UserEntity createUser(UserRequest userRequest) {
		Set<String> stringRole = userRequest.getRole();
		List<RoleEntity> roles = new ArrayList<>();

		if(stringRole == null){
			RoleEntity userRole = roleRepository.findOneByName(ERole.ROLE_USER).orElseThrow(() -> new RuntimeException(" Role is not found."));
			roles.add(userRole);
		} else {
			stringRole.forEach(role -> {
				switch (role){
					case "ROLE_ADMIN" :
						RoleEntity adminRole = roleRepository.findOneByName(ERole.ROLE_ADMIN).orElseThrow(() -> new RuntimeException(" Role is not found."));
						roles.add(adminRole);
						break;
					case "ROLE_USER" :
						RoleEntity userRole = roleRepository.findOneByName(ERole.ROLE_USER).orElseThrow(() -> new RuntimeException(" Role is not found."));
						roles.add(userRole);
						break;
					default:
						break;
				}
			});
		}
		UserEntity users = new UserEntity(roles,
				userRequest.getStatus(),
				userRequest.getEmail(),
				passwordEncoder.encode(userRequest.getPassword()),
				userRequest.getLoginToken(),
				userRequest.getCreatedAt(),
				userRequest.getUpdatedAt());
		users.setRoles(roles);
		return userRepo.save(users);
	}

}
