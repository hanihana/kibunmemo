package com.example.demo.model;

import lombok.Data;

@Data
public class User {

	private Integer id;
	
	private String userId;
	
	private String password;
	
	private String role;
}
