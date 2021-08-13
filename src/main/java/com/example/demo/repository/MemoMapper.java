package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.model.Memo;

@Mapper
public interface MemoMapper {

	/** メモ登録 */
	public void insertOne(Memo memo);
	
	/** メモを全件取得 */
	public List<Memo> findAll();
	
	/** メモ1件取得 */
	public Memo findOne(String id);
	
	/** メモ1件更新 */
	public void updateOne(@Param("id") String id,
			@Param("feeling") String feeling,
			@Param("text") String text);
	
	/** メモ1件削除 */
	public void deleteOne(@Param("id") String id);
	
}
