package com.example.demo.form;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MemoForm {
	
	private Integer id;
	
	@NotBlank(groups = ValidGroup1.class)
	private String feeling;
	
	@NotBlank(groups = ValidGroup1.class)
	@Length(min = 1, max = 100, groups = ValidGroup2.class)
	private String text;
	
	@NotNull(groups = ValidGroup1.class)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate day;

}
