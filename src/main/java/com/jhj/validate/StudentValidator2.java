package com.jhj.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidator2 implements Validator {

	@Override
	public boolean supports(Class<?> clazz) { // 검증할 객체(StudentDto)의 클래스 타입 정보
		// TODO Auto-generated method stub
		return StudentDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		StudentDto studentDto = (StudentDto) target;
		
		String id = studentDto.getId(); // 입력한 ID
		
		if(id.strip().isEmpty() || id == null) { // 두 조건 중 하나라도 걸리면 error
			System.out.println("입력한 아이디 : " + id);
			errors.rejectValue("id", "ID trouble"); // errors.rejectValue((에러가 발생한 필드이름), 에러코드(메세지))
		}
		
		String pw = studentDto.getPw(); // 입력한 PW
//		
//		if(pw.strip().isEmpty() || pw == null) { // 두 조건 중 하나라도 걸리면 error
//			System.out.println("입력한 비밀번호 : " + pw);
//			errors.rejectValue("pw", "PW trouble"); // errors.rejectValue((에러가 발생한 필드이름), 에러코드(메세지))
//		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pw", "PW trouble");
		
		String name = studentDto.getName(); // 입력한 이름
		
		if(name.strip().isEmpty() || name == null) { // 두 조건 중 하나라도 걸리면 error
			System.out.println("입력한 이름 : " + name);
			errors.rejectValue("name", "NAME trouble"); // errors.rejectValue((에러가 발생한 필드이름), 에러코드(메세지))
		}
		
		int age = studentDto.getAge(); // 입력한 나이
		
		if(age >= 20 || age < 0) { // 나이가 20세 이상일 경우 자격없음, 음수 입력시 error
			System.out.println("입력한 나이 : " + age);
			errors.rejectValue("age", "AGE trouble"); // errors.rejectValue((에러가 발생한 필드이름), 에러코드(메세지))
		}
	}

}
