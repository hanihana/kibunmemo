package com.example.demo.form;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class MemoForm {
	
	@NotBlank
	private String feeling;
	
	@NotBlank
	@Length(min = 1, max = 100)
	private String text;
	
	@NotNull
	private Date datetime;

}
