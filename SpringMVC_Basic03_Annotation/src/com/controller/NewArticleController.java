package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.NewArticleCommand;
import com.service.ArticleService;


/*
-클라이언트 요청
1. 화면 보여줘(글쓰기화면, 로그인 화면 등) : login.do
2. 처리해 주세요(글쓰기 입력 처리, 로그인 완료 처리): writeok.do

요청주소가 : write.do >>화면
				: writeok.do>>처리
				
-클라이언트 요청
-1개의 주소를 가지고 판단
-요청주소 하나로 화면인지 처리인지 판단 -> 근거는 전송 방식(GET(화면방식) , POST(처리방식)) 
>> http://;ocalhost:8090/SpringMVC_Basic03_Annotation/article/newArticle.do
같은 주소인데
GET이라면 -> 화면 뷰 제공
POST라면  -> insert, update 등 하고 처리, 화면제공
 */

@Controller
@RequestMapping("/article/newArticle.do")
public class NewArticleController {
	private ArticleService articleservice;

	@Autowired
	public void setArticleservice(ArticleService articleservice) {
		this.articleservice = articleservice;
	}

	//@RequestMapping(method = RequestMethod.GET)  //화면보여주세요
	@GetMapping
	public String form() { 
		//****** spring 함수의 return 타입이 String view의 주소를 의미 ......
		System.out.println("GET");
		return "article/newArticleForm";
		//   /WEB-INF/views/  + article/newArticleForm + .jsp
	}
	
	//1. 데이터 받는 가장 전통적인 방법 >> HttpServletRequest request >> 코드량 증가 >> spring 음...
	//@RequestMapping(method = RequestMethod.POST) //처리해 주세요
	
	/*
	 구시대 코드
	 @PostMapping
	public ModelAndView submit(HttpServletRequest request) {
		System.out.println("POST");
		
		NewArticleCommand article = new NewArticleCommand();
		article.setParentId( Integer.parseInt(request.getParameter("parentId")));
		article.setTitle(request.getParameter("title"));
		article.setContent(request.getParameter("content"));
		
		//NewArticleController 가 service 필요해 
		this.articleservice.writeAreicle(article);
		//처리완료
		
		ModelAndView mv = new  ModelAndView();
		mv.addObject("newArticleCommand", article);
		mv.setViewName("article/newArticleSubmitted");
		
		return mv;
	}
	*/
	
	//2. Spring 에서 parameter를 DTO객체로 받기
	//2.1 자동화 >> 전제조건 >> input name="" 값이 DTO 객체의 member field 명과 동일
	/*
	근데 이거보다 더 줄일 수 있어
	@PostMapping //5.x.x 버전 부터
	public ModelAndView submit(NewArticleCommand command) {
		//1. 자동으로 DTO객체 생성
		//2. 넘어온 parameter 값을 DTO에 setter 함수를 사용해서 자동주입
		//3. NewArticleCommand command 객체 IOC 컨테이너 안에 자동생성 id="NewArticleCommand"
		
		ModelAndView mv = new  ModelAndView();
		mv.addObject("newArticleCommand", command);  == @ModelAttribute("Articledata")
		mv.setViewName("article/newArticleSubmitted");
		
		return mv;
	}*/
	
	@PostMapping //5.x.x 버전 부터
	public String submit(@ModelAttribute("Articledata") NewArticleCommand command) {
		/*
		ModelAndView mv = new  ModelAndView();
		mv.addObject("newArticleCommand", command); 
		위 코드가 아래 한줄로 대체
		->  @ModelAttribute("Articledata")
		
		mv.setViewName("article/newArticleSubmitted");
		->   Stirng submit   ->   return "article/newArticleSubmitted"
		
		view까지 자동 forward ....
		 */
		this.articleservice.writeAreicle(command);
		
		return "article/newArticleSubmitted";
	}
}