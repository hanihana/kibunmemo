'use strict';

/** 画面ロード時の処理. */
jQuery(function($) {
	
	/** 更新ボタンを押したときの処理. */
	$('#btn-update').click(function(event) {
		// ユーザー更新
		updateMemo();
	});
	
	/** 削除ボタンを押したときの処理. */
	$('#btn-delete').click(function(event) {
		// ユーザー削除
		deleteMemo();
	});
});

/** ユーザー更新処理. */
function updateMemo() {
	// フォームの値を取得
	var formData = $('#memo-detail-form').serializeArray();
	
	// ajax通信
	$.ajax({
		type : "PUT",
		cache : false,
		url : '/kibunmemo/update',
		data : formData,
		dataType : 'json',
	}).done(function(data) {
		// ajax成功時の処理
		alert('メモを更新しました');
		// ユーザー一覧画面にリダイレクト
		window.location.href = '/kibunmemo/list';
		
	}).fail(function(jqXHR, textStatus, errorThrown) {
		// ajax失敗時の処理
		alert('メモの更新に失敗しました');
	}).always(function() {
		// 常に実行する処理
	});
}

/** ユーザー削除処理. */
function deleteMemo() {
	// フォームの値を取得
	var formData = $('#memo-detail-form').serializeArray();
	
	// ajax通信
	$.ajax({
		type : "DELETE",
		cache : false,
		url : '/kibunmemo/delete',
		data : formData,
		dataType : 'json',
	}).done(function(data) {
		// ajax成功時の処理
		alert('メモを削除しました');
		// ユーザー一覧画面にリダイレクト
		window.location.href = '/kibunmemo/list';
		
	}).fail(function(jqXHR, textStatus, errorthrown) {
		// ajax失敗時の処理
		alert('メモの削除に失敗しました');
		
	}).always(function() {
		// 常に実行する処理
	});
}