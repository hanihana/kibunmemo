package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Memo;
import com.example.demo.service.MemoService;

@Controller
@RequestMapping("/kibunmemo")
public class MemoListController {
	
	@Autowired
	MemoService memoService;

	/** メモ一覧表示 */
	@GetMapping("/list")
	public String getMemoList(Model model) {
		List<Memo> memoList = memoService.getAll();
		model.addAttribute("memoList", memoList);
		return "list";
	}
}
