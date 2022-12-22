package kosa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kosa.service.EmpService;
import kosa.vo.Emp;

// @Controller + 함수 (@ResponseBody)
@RestController
@RequestMapping("/emp.ajax")
public class AjaxController {

	private EmpService empservice;

	@Autowired
	public void setEmpService(EmpService empservice) {
		this.empservice = empservice;
	}

	/*
	Restful 방식의 annotation 존재
	@GetMapping
	@PostMapping
	@DeleteMapping
	@PutMapping
	@PatchMapping
	 */
	// 전체 보기
	@GetMapping("")
	public ResponseEntity<List<Emp>> emp() {
		List<Emp> list = new ArrayList<Emp>();
		try {
			list = empservice.allList();
			System.out.println("정상싱행");
			return new ResponseEntity<List<Emp>>(list,HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("실행 실패");
			return new ResponseEntity<List<Emp>>(list,HttpStatus.BAD_REQUEST);		
			}
	}


	// 검색 보기
	@GetMapping("/{keyword}")//뒤에 들어오는 parameter값을 empno라는 이름으로 쓰겠다는 의미이다
		public ResponseEntity<List<Emp>> search(@PathVariable("keyword") String keyword) {  //스프링에서 Ajax로 보낸 파라미터를 받는 형식
			System.out.println("keyword : " + keyword);																 //브라우저에서 받아온 모든 형식은 문자이기에 형변환 필수
			
			List<Emp> list = new ArrayList<Emp>();
			try {
			 int searchword = Integer.parseInt(keyword); 
				list = empservice.searchList(searchword);
				
				System.out.println("검색 : 정상실행");
				return new ResponseEntity<List<Emp>>(list,HttpStatus.OK);
			} catch (Exception e) {
				System.out.println("실행 실패");
				return new ResponseEntity<List<Emp>>(list,HttpStatus.BAD_REQUEST);		
			}					
		}

//	// 상세 보기
//	@PostMapping("empDetail.ajax/{empno}")
//	public String empDetail(@PathVariable("empno") int empno, Model model) {
//
//		Emp emp = empservice.empDetail(empno);
//		model.addAttribute("emp", emp);
//		return "empDetail";
//	}

	// 사원 삽입 처리
	@PostMapping("")						//수정 처리 부분과 마찬가지로 
	public  ResponseEntity<List<Emp>> insert(@RequestBody Emp emp) {
		List<Emp> list = new ArrayList<Emp>();
		try {
			System.out.println("insert 실행");
			empservice.insert(emp);
			list = empservice.allList();
			return new ResponseEntity<List<Emp>>(list,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Emp>>(list,HttpStatus.BAD_REQUEST);
		}
	}

	//수정
	   @GetMapping("edit/{empno}")
	   public ResponseEntity<Emp> updateEmp(@PathVariable("empno") String empno) {   //수정부분이 두개 인 이유는 수정버튼을 눌렀을 떄 해당 empno에 (넘어온 DATA)
		   							//맞는 사원데이터를 뽑아서 수정 input 란에 적어놓아야 하기 때문
		   Emp data = null;
		   int searchempno = Integer.parseInt(empno); 
		   try {
				System.out.println("edit 실행");
				data = empservice.empDetail(searchempno);
				return new ResponseEntity<Emp>(data,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Emp>(data,HttpStatus.BAD_REQUEST);
			}
	   }

	   
	   /*
	   public  ResponseEntity<List<Emp>> insert(@RequestBody Emp emp) {
		List<Emp> list = new ArrayList<Emp>();
		try {
			System.out.println("insert 실행");
			empservice.insert(emp);
			list = empservice.allList();
			return new ResponseEntity<List<Emp>>(list,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Emp>>(list,HttpStatus.BAD_REQUEST);
		}
	}
	    */
	   // 수정 처리
	   @PutMapping("")
	   public ResponseEntity<List<Emp>> updateEmpok(@RequestBody Emp emp) {
		   List<Emp> list = new ArrayList<Emp>();
			try {
				System.out.println("insert 실행");
				empservice.empEdit(emp);		
				list = empservice.allList();
				return new ResponseEntity<List<Emp>>(list,HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<List<Emp>>(list,HttpStatus.BAD_REQUEST);
			}
	   }


	// 삭제
	@DeleteMapping("{empno}")
	public ResponseEntity<List<Emp>> noticeDel(@PathVariable("empno") String empno) {  //수정 처리와 마찬가지로 삭제처리가 완료 된 이후 다시 완료된 이후의 리스트를 뽑아준다
		List<Emp> list = new ArrayList<Emp>();
		int searchempno = Integer.parseInt(empno); 
		try {
			empservice.empDel(searchempno);
			list = empservice.allList();
			return new ResponseEntity<List<Emp>>(list,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Emp>>(list,HttpStatus.BAD_REQUEST);
		}
	}

	

}