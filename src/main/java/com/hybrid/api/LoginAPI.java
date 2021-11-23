package com.hybrid.api;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hybrid.common.JwtUtils;
import com.hybrid.repository.RoleRepository;
import com.hybrid.repository.UserRepository;
import com.hybrid.request.LoginRequest;
import com.hybrid.response.BaseResponse;
import com.hybrid.service.impl.UserDetail;
import com.hybrid.service.impl.UserDetailsServiceImpl;

@RestController
public class LoginAPI {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@PostMapping(value = "/api/login")
	public String login(@Valid @RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
//        Users users = new Users(loginRequest.getEmail(),
//                passwordEncoder.encode(loginRequest.getPassword()));
		UserDetail userDetails = (UserDetail) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.collect(Collectors.toList());
		roles.forEach((element) -> {
			System.out.println("day la gi ? " + element);
		});
		// users.setLogin_token(jwt);
		return jwt;
//        ResponseEntity.ok(new JwtResponse(
//                jwt,
//                200L,
//                "Login successfully",
//                userDetails.getId(),
//                userDetails.getEmail(),
//                roles
//       ));
	}

	//@PreAuthorize("hasRole('admin')")
	@GetMapping(value = "/api/testbaomat")
	public UserDetail testabc() {
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return userDetail;
	}
	

//	@ExceptionHandler
//	@ResponseBody
//	@ResponseStatus(HttpStatus.FORBIDDEN)
//	public BaseResponse handleValidationExceptions(MethodArgumentNotValidException ex) {
//		BaseResponse baseDTO = new BaseResponse();
//		baseDTO.setReponseCode(403);
//		baseDTO.setMessage("không có quyền");
//		return baseDTO;
//	}
}
