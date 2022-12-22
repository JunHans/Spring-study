package kosa.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;

import kosa.vo.Employee;

@Controller
public class AjaxController {

   //org.springframework.web.servlet.view.json.MappingJackson2JsonView
   //View 인터페이스 부모타입
   @Autowired
   public View jsonview;
   
   //command=AjaxTest&name=java&arr="+array
   @RequestMapping("json.kosa")
   public View jsonkosa(String command, String name, String [] arr, ModelMap map) {
      
      System.out.println("command: " + command);
      System.out.println("name: " + name);
      System.out.println("arr: " + arr);
      System.out.println("Arrays.toString(): " + Arrays.toString(arr));


      ArrayList<String> list = new ArrayList<String>();
      list.add("치킨");
      list.add("맥주");
      list.add("피자");
      
      map.addAttribute("menu", list); // View단에 전달
      //{:}
      //{"menu":Array}
      
      return jsonview;
      //<bean name="jsonview" 객체와 동일한 이름)
      //map.addAttribute("menu", list); 자원을 자동으로 json객체로 변환해서 클라이언트에게 비동기 전달
   }
   
//   @RequestMapping("json2.kosa")
//   public View jsonkosa(String command, String name, ModelMap map) {
//      System.out.println("command: " + command);
//      System.out.println("name: " + name);
//      
//      List<TestVO> list = new ArrayList<TestVO>(); //객체배열
//      
//      TestVO vo = new TestVO();
//      vo.setBeer("라거");
//      vo.setFood("골뱅이");
//      
//      list.add(vo);
//      
//      TestVO vo2 = new TestVO();
//      vo2.setBeer("카스");
//      vo2.setFood("치킨");
//      
//      list.add(vo2);
//      
//      map.addAttribute("menu", list);
//      //{"menu":{"beer":라거},{"food":"골뱅이"}}
//      
//      return jsonview;
//   }
   
   //Employee 객체 2개 만들어서 List 형태로 반환하는 비도익 처리 함수 생성해서 테스트
   @RequestMapping("json3.kosa")
   public View jsonkosa(HttpServletRequest request, HttpServletResponse response, ModelMap map) {

      List<Employee> list = new ArrayList<Employee>(); //객체배열
      
      Employee emp = new Employee();
      emp.setFirstname("ko");
      emp.setLastname("beomjong");
      emp.setEmail("qjawhd100@naver.com");
      
      list.add(emp);
      
      
      Employee emp2 = new Employee();
      emp2.setFirstname("haha");
      emp2.setLastname("hohohoho");
      emp2.setEmail("ebune123@naver.com");
      
      list.add(emp2);
      
      
      map.addAttribute("data", list);
      //{"menu":{"beer":라거},{"food":"골뱅이"}}
      
      return jsonview;
   }
   
   @RequestMapping("json4.kosa")
   public void typeFunction(@RequestParam(value="aaa[]", required=false) String[] aaa,
		   																	@RequestParam(value="bbb[]", required=false) String[] bbb,
		   																		String ccc) {
	   
	   for(String str : aaa) {
		   System.out.println(str);
	   }
	   System.out.println(bbb);
	   System.out.println(ccc);  //문자열 (객체 형태) > 다시 객체로 받고 싶으면? jsonlib 등 라이브러리 사용한다
   }
}