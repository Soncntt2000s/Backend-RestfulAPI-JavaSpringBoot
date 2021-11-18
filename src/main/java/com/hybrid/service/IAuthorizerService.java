package com.hybrid.service;

import org.springframework.security.core.Authentication;

public interface IAuthorizerService {
	
	 boolean authorize(Authentication authentication, String action, Object callerObj);

}
