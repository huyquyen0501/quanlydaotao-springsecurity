package com.service;

public interface SecurityService {
	void autologin(String username, String password);

	String findLoggedInUsername();
}
