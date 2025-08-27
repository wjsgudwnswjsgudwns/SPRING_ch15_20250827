package com.jhj.validate;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/join")
	public String join() {
		return "join";
	}
	
	@RequestMapping(value = "/joinOk") // 유저가 입력한 값이 유효한지 체크 -> validation(유효성체크)
	public String joinOk(StudentDto studentDto,Model model, BindingResult result) {
		//아이디가 공란 error
		//비밀번호가 공란 error
		//나이가 20세 이상 error
		StudentValidator validator = new StudentValidator();
		validator.validate(studentDto, result);
		if(result.hasErrors()) {
			System.out.println("에러 발생 갯수 : " + result.getFieldErrorCount()); // 에러 발생 갯수
			
			//FieldError fieldError = result.getFieldError("id");
			//System.out.println(fieldError.getCode()); // ID trouble -> 써놓은 에러 코드 출력
			String errorMsg = null;
			List<FieldError> fieldErrors = result.getFieldErrors(); // 모든 에러를 List로 반환
			for(FieldError error : fieldErrors) {
				System.out.println("에러 발생 필드 : " + error.getField()); // 에러가 발생한 필드
				System.out.println("에러 발생 코드 : " + error.getCode()); // 에러가 발생한 코드
				errorMsg = error.getCode();
			}
			
			model.addAttribute("error", errorMsg);
			return "join"; // 가입실패 -> 회원가입 페이지
		}
		
		model.addAttribute("studentDto", studentDto);
		
		return "joinOk"; // 가입 성공
	}
}
