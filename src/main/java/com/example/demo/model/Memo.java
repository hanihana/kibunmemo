package com.example.demo.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Memo {
	
	private Integer id;
		
	private String feeling;
	
	private String text;
	
	private LocalDate day;

}
