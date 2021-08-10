package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Memo;

@Mapper
public interface MemoMapper {

	/** メモ登録 */
	public void insertOne(Memo memo);
	
	/** メモを全件取得 */
	public List<Memo> findAll();
	
	/** メモ1件取得 */
	public Memo findOne(String id);
	
}
