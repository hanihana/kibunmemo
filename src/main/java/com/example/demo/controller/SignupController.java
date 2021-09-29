package com.example.demo.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.GroupOrder;
import com.example.demo.form.SignupForm;
import com.example.demo.model.User;
import com.example.demo.service.MemoService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/kibunmemo")
@Slf4j
public class SignupController {
	
	@Autowired
	private MemoService memoService;
	
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/signup")
	public String getSignup(Model model, @ModelAttribute SignupForm form) {
		return "signup";
	}

	@PostMapping("/signup")
	public String postSignup(Model model,
			@ModelAttribute @Validated(GroupOrder.class) SignupForm form,
			BindingResult bindingResult) {

		if(bindingResult.hasErrors()) {
			return getSignup(model, form);
		}

		log.info(form.toString());
		
		User user = modelMapper.map(form, User.class);
		
		memoService.inputUser(user);
		
		return "redirect:/login";
	}
	
	/** データベース関連の例外処理 */
	@ExceptionHandler(DataAccessException.class)
	public String dataAccessExceptionHandler(DataAccessException e,
			Model model) {
		
		// 空文字をセット
		model.addAttribute("error", "");
		
		// メッセージをModelに登録
		model.addAttribute("message", "SignupControllerで例外が発生しました");
		
		// HTTPのエラーコード(500)をModelに登録
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);
		
		return "error";
	}
	
	/** その他の例外処理 */
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e, Model model) {
		
		// 空文字をセット
		model.addAttribute("error", "");
		
		// メッセージをModelに登録
		model.addAttribute("message", "SignupControllerで例外が発生しました");
		
		// HTTPのエラーコード(500)をModelに登録
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);
		
		return "error";
	}
}
