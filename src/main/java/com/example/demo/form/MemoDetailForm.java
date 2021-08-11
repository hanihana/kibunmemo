package com.example.demo.form;

import java.util.Date;

import lombok.Data;

@Data
public class MemoDetailForm {

	private String id;
	private String feeling;
	private String text;
	private Date date;
	
}
