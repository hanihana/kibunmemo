package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Memo;
import com.example.demo.repository.MemoMapper;

@Service
public class MemoService {
	
	@Autowired
	MemoMapper mapper;
	
	/** メモ登録 */
	public void inputOne(Memo memo) {
		mapper.insertOne(memo);
	}
	
	/** メモを全件表示 */
	public List<Memo> getAll() {
		return mapper.findAll();
	}
	
	/** メモを1件取得 */
	public Memo getOne(String id) {
		return mapper.findOne(id);
	}
	
	/** メモを1件更新 */
	public void updateMemoOne(String id, String feeling,
			String text) {
		mapper.updateOne(id, feeling, text);
	}
	
	/** メモを1件削除 */
	public void deleteMemoOne(String id) {
		mapper.deleteOne(id);
	}
}
