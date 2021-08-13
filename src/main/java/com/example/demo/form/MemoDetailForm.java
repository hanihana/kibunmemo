package com.example.demo.form;

import java.time.LocalDate;

import lombok.Data;

@Data
public class MemoDetailForm {

	private String id;
	private String feeling;
	private String text;
	private LocalDate date;
	
}