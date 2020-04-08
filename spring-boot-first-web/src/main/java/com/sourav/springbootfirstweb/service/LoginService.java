package com.sourav.springbootfirstweb.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	 private Pattern pattern;
	    private Matcher matcher;
	 
	    private static final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{10})";
	 
	    
	 
	    public boolean validate(final String password) {
	 
	    	pattern = Pattern.compile(PASSWORD_PATTERN);
	        matcher = pattern.matcher(password);
	        return matcher.matches();
	 
	    }

	}


