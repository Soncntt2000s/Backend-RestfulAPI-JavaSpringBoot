//package com.hybrid.api;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.hybrid.service.impl.UserService;
//import com.hybrid.utils.TokenJwtUtil;
//
//@RestController
//public class LoginAPI {
//
//	@Autowired
//	private UserService userService;
//	
//	@PostMapping(value = "/api/login")
//	public String login(String username, String password) {
//		// Kiểm tra user/pass trong CSDL
//		// Nếu hợp lệ thì sinh JWT theo userId hoặc username và trả về cho client
//		{
//			String token = TokenJwtUtil.generateJwt(userId);
//			return jwt;
//		}
//		// User/pass không hợp lệ thì đăng nhập không thành công
//		return null;
//	}
//}
