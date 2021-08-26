'use strict'

/** 画面ロード時の処理. */
jQuery(function($) {
	
	/** 登録ボタンを押したときの処理. */
	$('#btn-input').click(function(event) {
		// ユーザー登録
		inputMemo();
	});
});

/** ユーザー登録処理 */
function inputMemo() {
	
	// バリデーション結果をクリア
	removeValidResult();
	
	// フォームの値を取得
	var formData = $('#input-form').serializeArray();
	
	// ajax通信
	$.ajax({
		type : "POST",
		cache : false,
		url : '/kibunmemo/input/rest',
		data : formData,
		dataType : 'json',
	}).done(function(data) {
		// ajax成功時の処理
		console.log(data);
		
		if(data.result === 90) {
			// validationエラー時の処理
			$.each(data.errors, function(key, value) {
				reflectValidResult(key, value)
			});
		} else if(data.result === 0) {
			alert('メモを登録しました');
			// ログイン画面にリダイレクト
			window.location.href = '/kibunmemo/list';
		}
	}).fail(function(jqXHR, textStatus, errorThrown) {
		// ajax失敗時の処理
		alert('メモの登録に失敗しました');
	
	}).always(function() {
		// 常に実行する処理
	});
}

/** バリデーション結果をクリア */
function removeValidResult() {
	$('.is-invalid').removeClass('is-invalid');
	$('.invalid-feedback').remove();
	$('.text-danger').remove();
}

/** バリデーション結果の反映 */
function reflectValidResult(key, value) {
	if(key === 'text') {
		
		$('#err_textarea').append('<p style="color:red"><i class=\"fa fa-exclamation-triangle\"></i>' + value + '</p>');
		$('<span th:if="${#fields.hasErrors(' + key + ')}" th:errors="*{' + key + '}" style="color: red"></span>')
			.after('<div class="invalid-feedback">' + value + '</div>');
	} else {
	
		// CSS
		$('input[id=' + key + ']').addClass('is-invalid');
	
		// エラーメッセージ追加
		$('input[id=' + key + ']')
			.after('<div class="invalid-feedback">' + value + '</div>');
	}
}