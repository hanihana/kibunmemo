package com.example.demo.form;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MemoForm {
	
	@NotBlank
	private String feeling;
	
	@NotBlank
	@Length(min = 1, max = 100)
	private String text;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;

}
