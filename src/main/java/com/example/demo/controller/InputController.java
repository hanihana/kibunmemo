package com.example.demo.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.GroupOrder;
import com.example.demo.form.MemoForm;
import com.example.demo.model.Memo;
import com.example.demo.service.MemoService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/kibunmemo")
public class InputController {

	@Autowired
	private MemoService memoService;

	@Autowired
	private ModelMapper modelMapper;

	/** メモ作成画面表示 */
	@GetMapping("/insert")
	public String getInsert(@ModelAttribute MemoForm form) {

		return "insert";

	}

	/** メモ登録処理 */
	@PostMapping("/insert")
	public String postInsert(@ModelAttribute @Validated(GroupOrder.class) MemoForm form,
			BindingResult bindingResult) {

		if(bindingResult.hasErrors()) {
			return getInsert(form);
		}

		log.info(form.toString());

		Memo memo = modelMapper.map(form, Memo.class);

		memoService.inputOne(memo);

		return "redirect:/kibunmemo/list";
	}

}
