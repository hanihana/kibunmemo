package com.example.demo.model;

import java.util.Date;

import lombok.Data;

@Data
public class Memo {
	
	private Integer id;
	
	private String feeling;
	
	private String text;
	
	private Date datetime;

}
