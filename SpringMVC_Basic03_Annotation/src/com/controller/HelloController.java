package com.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
이렇게 처리하면 요청 하나당 컨트롤러 하나 필요
public class HelloController implements Controller{

이 방식 단점 : 서비스 갯수 만큼 컨트롤러 생성
게시판 : 목록 보기    >> listcontroller
			글쓰기	     >>  writecontroller
			수정하기     >> editcontroller

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
*/
/*
아래방식 장점
method 단위로 매핑
하나의 컨트롤러 안에 여러개의 함수 만들어서 생성, 각각 매핑
게시판 : 목록 보기    >> public void list()
			글쓰기	     >>  public void write()
			수정하기     >> public void edit()
*/

@Controller
public class HelloController {
	public HelloController() {
		System.out.println("Hello컨트롤러 생성자 호출");
	}
	
	@RequestMapping("/hello.do")  //<a href="hello.do"></a>  요청이 오면 함수 실행
	public ModelAndView hello() {
		System.out.println("[hello.do method call]");
		ModelAndView mv = new ModelAndView();
		mv.addObject("greeting",getGreeting());
		mv.setViewName("Hello");
		return mv;
	}
	
	private String getGreeting() {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		String data="";
		if(hour >= 6 && hour<=10) {
			data="학습시간";
		}else if(hour >= 11 && hour<=13) {
			data="배고픈 시간";
		}else if(hour >= 14 && hour<=18) {
			data="졸린 시간";
		}else {
			data="go Home";
		}
		return data;
	}
	
}