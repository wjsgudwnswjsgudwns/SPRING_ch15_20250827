package com.jhj.validate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
			model.addAttribute("error", "error");
			return "join"; // 가입실패 -> 회원가입 페이지
		}
		
		model.addAttribute("studentDto", studentDto);
		
		return "joinOk"; // 가입 성공
	}
}
