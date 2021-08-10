package com.example.demo.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.MemoDetailForm;
import com.example.demo.model.Memo;
import com.example.demo.service.MemoService;

@Controller
@RequestMapping("/kibunmemo")
public class MemoDetailController {
	
	@Autowired
	private MemoService service;
	
	@Autowired
	private ModelMapper modelMapper;
	
	/** メモ詳細画面を表示 */
	@GetMapping("/detail/{id}")
	public String getMemo(MemoDetailForm form, Model model,
			@PathVariable("id") String id) {
		Memo memo = service.getOne(id);
		form = modelMapper.map(memo, MemoDetailForm.class);
		
		model.addAttribute("memo", form);
		
		return "kibunmemo/detail";
	}

}
