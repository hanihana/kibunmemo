package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Memo;
import com.example.demo.model.User;
import com.example.demo.repository.MemoMapper;

@Service
public class MemoService {
	
	@Autowired
	private MemoMapper mapper;
	
	@Autowired
	private PasswordEncoder encoder;
	
	/** メモ登録 */
	public void inputOne(Memo memo) {
		mapper.insertOne(memo);
	}
	
	/** メモを全件取得 */
	public List<Memo> getAll() {
		return mapper.findAll();
	}
	
	/** メモを1件取得 */
	public Memo getOne(String id) {
		return mapper.findOne(id);
	}
	
	/** メモを1件更新 */
	@Transactional
	public void updateMemoOne(String id, String feeling,
			String text) {
		mapper.updateOne(id, feeling, text);
	}
	
	/** メモを1件削除 */
	public void deleteMemoOne(String id) {
		mapper.deleteOne(id);
	}
	
	/** ユーザー登録 */
	public void inputUser(User user) {
		user.setRole("ROLE_GENERAL");
		
		String rawPassword = user.getPassword();
		user.setPassword(encoder.encode(rawPassword));
		
		mapper.insertUser(user);
	}
	
	/** ログインユーザー情報取得 */
	public User getLoginUser(String userId) {
		return mapper.findLoginUser(userId);
	}
}
