package com.example.demo.rest;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.form.GroupOrder;
import com.example.demo.form.MemoDetailForm;
import com.example.demo.form.MemoForm;
import com.example.demo.form.SignupForm;
import com.example.demo.model.Memo;
import com.example.demo.model.User;
import com.example.demo.service.MemoService;

@RestController
@RequestMapping("/kibunmemo")
public class MemoRestController {

	@Autowired
	private MemoService memoService;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private MessageSource messageSource;

	/** ユーザーを登録 */
	@PostMapping("/signup/rest")
	public RestResult postSignup(@Validated(GroupOrder.class) SignupForm form,
			BindingResult bindingResult, Locale locale) {

		// 入力チェック
		if(bindingResult.hasErrors()) {
			// チェック結果:NG
			Map<String, String> errors = new HashMap<String, String>();

			// エラーメッセージ取得
			for(FieldError error : bindingResult.getFieldErrors()) {
				String message = messageSource.getMessage(error, locale);
				errors.put(error.getField(), message);
			}
			// エラー結果の返却
			return new RestResult(90, errors);
		}

		// formをUserクラスに変換
		User user = modelMapper.map(form, User.class);

		// ユーザー登録
		memoService.inputUser(user);

		// 結果の返却
		return new RestResult(0, null);

	}
	
	/** メモを登録 */
	@PostMapping("/input/rest")
	public RestResult postInput(@Validated(GroupOrder.class) MemoForm form,
			BindingResult bindingResult, Locale locale) {

		// 入力チェック
		if(bindingResult.hasErrors()) {
			// チェック結果:NG
			Map<String, String> errors = new HashMap<String, String>();

			// エラーメッセージ取得
			for(FieldError error : bindingResult.getFieldErrors()) {
				String message = messageSource.getMessage(error, locale);
				errors.put(error.getField(), message);
			}
			// エラー結果の返却
			return new RestResult(90, errors);
		}

		// formをUserクラスに変換
		Memo memo = modelMapper.map(form, Memo.class);

		// ユーザー登録
		memoService.inputOne(memo);

		// 結果の返却
		return new RestResult(0, null);

	}

	/** メモを更新 */
	@PutMapping("/update")
	public int updateMemo(MemoDetailForm form) {

		// ユーザーを更新
		memoService.updateMemoOne(form.getId(), form.getFeeling(), form.getText());

		return 0;
	}

	/** メモを削除 */
	@DeleteMapping("/delete")
	public int deleteMemo(MemoDetailForm form) {

		// ユーザーを削除
		memoService.deleteMemoOne(form.getId());

		return 0;
	}

}
