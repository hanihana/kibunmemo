package rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.form.MemoDetailForm;
import com.example.demo.service.MemoService;

@RestController
@RequestMapping("/kibunmemo")
public class UserRestController {
	
	@Autowired
	private MemoService memoService;
	
	/** ユーザーを更新 */
	@PutMapping("/update")
	public int updateMemo(MemoDetailForm form) {
		
		// ユーザーを更新
		memoService.updateMemoOne(form.getId(), form.getFeeling(), form.getText());
		
		return 0;
	}
	
	/** ユーザーを削除 */
	@DeleteMapping("/delete")
	public int deleteMemo(MemoDetailForm form) {
		
		 // ユーザーを削除
		memoService.deleteMemoOne(form.getId());
		
		return 0;
	}

}
