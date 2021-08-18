package com.example.demo.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.MemoDetailForm;
import com.example.demo.model.Memo;
import com.example.demo.service.MemoService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/kibunmemo")
@Slf4j
public class MemoDetailController {
	
	@Autowired
	private MemoService memoService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	/** メモ詳細画面を表示 */
	@GetMapping("/detail/{id}")
	public String getMemo(MemoDetailForm form, Model model,
			@PathVariable("id") String id) {
		Memo memo = memoService.getOne(id);
		form = modelMapper.map(memo, MemoDetailForm.class);
		
		model.addAttribute("memoDetailForm", form);
		
		return "detail";
	}

	/** メモ更新処理 */
	@PostMapping(value = "/detail", params = "update")
	public String updateMemo(MemoDetailForm form, Model model) {
		
		try {
			memoService.updateMemoOne(form.getId(), form.getFeeling(), form.getText());
		} catch(Exception e) {
			log.error("メモ更新でエラー", e);
		}
		
		return "redirect:/kibunmemo/list";
	}
	
	/** メモ削除処理 */
	@PostMapping(value = "/detail", params = "delete")
	public String deleteMemo(MemoDetailForm form, Model model) {
		memoService.deleteMemoOne(form.getId());
		return "redirect:/kibunmemo/list";
	}
}
