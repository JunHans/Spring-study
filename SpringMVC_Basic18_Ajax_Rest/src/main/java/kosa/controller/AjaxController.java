package kosa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kosa.vo.Emp;



@RestController   //얘가 가진 모든 함수는 비동기 ResponseBody인 거야
public class AjaxController {

	@RequestMapping("restcon.ajax")
	public List<Emp> ajaxResponseBody(){
		
		List<Emp> list = new ArrayList<Emp>();
		
		Emp e = new Emp();
		e.setEmpno(9999);
		e.setEname("고현종");
		e.setJob("IT");
		e.setSal(10000);
		list.add(e);
		
		return list;
	}
	
	@RequestMapping("view.ajax")
	public String ViewPage() {
		System.out.println("view.ajax");
		return "view.ajax 문자열의 반환";
	}

  
 
} 