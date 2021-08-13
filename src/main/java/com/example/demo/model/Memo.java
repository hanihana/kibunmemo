package com.example.demo.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Memo {
	
	private Integer id;
	
	private String feeling;
	
	private String text;
	
	private LocalDate date;

}
