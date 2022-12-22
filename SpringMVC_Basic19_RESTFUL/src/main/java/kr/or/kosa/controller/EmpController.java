package kr.or.kosa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.kosa.dto.Emp;
import kr.or.kosa.service.EmpService;

// @Controller + 함수 (@ResponseBody)
@RestController
@RequestMapping("/emp.ajax")
public class EmpController {

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
	@RequestMapping(value="",method=RequestMethod.GET)
	public ResponseEntity<List<Emp>> empList() {
		List<Emp> list = new ArrayList<Emp>();
		try {
			list = empservice.selectAllEmpList();
			System.out.println("정상실행");
			return new ResponseEntity<List<Emp>>(list,HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("잘못됨");
			return new ResponseEntity<List<Emp>>(list,HttpStatus.BAD_REQUEST);
		}
	}

	// 검색 보기
	//postman -> http://localhost:8090/kosa/emp/1
	@RequestMapping(value="{empno}") //뒤에 들어오는 parameter값을 empno라는 이름으로 쓰겠다는 의미이다
	public Emp emplistByempno(@PathVariable("empno") int empno) {

		return empservice.selectEmpByEmpno(empno);

	}
	
	// 사원 삽입 처리
	//postman -> http://localhost:8090/kosa/emp >> data (insert 내용)
	@RequestMapping(value = "", method = RequestMethod.POST)						//수정 처리 부분과 마찬가지로 
	public ResponseEntity<String> insert(@RequestBody Emp emp) {
		try {
			System.out.println("insert 실행");
			empservice.insert(emp);
			return new ResponseEntity<String>("insert success",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("insert fail",HttpStatus.BAD_REQUEST);

		}
	}
	
	   // 수정 처리
	@RequestMapping(value = "", method = RequestMethod.PUT)	
	public ResponseEntity<String> update(@RequestBody Emp emp) {
		   try {
				System.out.println("insert 실행");
				empservice.update(emp);	
				return new ResponseEntity<String>("update success",HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<String>("update fail",HttpStatus.BAD_REQUEST);
			}
		}
	
	// 삭제
	@RequestMapping(value="{empno}",method = RequestMethod.DELETE) //뒤에 들어오는 parameter값을 empno라는 이름으로 쓰겠다는 의미이다
	public ResponseEntity<String> delete(@PathVariable("empno") int empno) {  //수정 처리와 마찬가지로 삭제처리가 완료 된 이후 다시 완료된 이후의 리스트를 뽑아준다
		   try {
				System.out.println("insert 실행");
				empservice.delete(empno);	
				return new ResponseEntity<String>("delete success",HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<String>("delete fail",HttpStatus.BAD_REQUEST);
			}
	}

	// 상세 보기
//	@RequestMapping("empDetail.ajax")
//	public String empDetail(int empno, Model model) {
//
//		Emp emp = empservice.empDetail(empno);
//		model.addAttribute("emp", emp);
//		return "empDetail";
//	}
//

//
//	//수정
//	   @GetMapping("update.ajax")
//	   public Emp updateEmp(Emp emp) {   //수정부분이 두개 인 이유는 수정버튼을 눌렀을 떄 해당 empno에 (넘어온 DATA)
//		   															//맞는 사원데이터를 뽑아서 수정 input 란에 적어놓아야 하기 때문
//	      Emp data = empservice.empDetail(emp.getEmpno());
//	      return data;
//	   }
//
//	   // 수정 처리
//	   @PostMapping("update.ajax")
//	   public List<Emp> updateEmpok(Emp myemp) {
//		   empservice.empEdit(myemp);						//수정은 별도의 결과 값이 필요한 함수가 아니기 때문에 void로 처리하여 수정을 처리하고
//	      List<Emp> list = new ArrayList<Emp>();   // Emp객체 타입의 List를 선언하여 사원리스트를 담아온 뒤 그 리스트를 리턴하여 수정이 완료된
//	      list = empservice.allList();							//사원 목록을 비동기로 즉각적으로 나타내 준다
//	      return list;
//	   }
//
//


//	// 검색 보기
//	@RequestMapping("search.ajax")
//	public List<Emp> search(@RequestParam("keyword") String keyword, Model model) {  //스프링에서 Ajax로 보낸 파라미터를 받는 형식
//		System.out.println("keyword : " + keyword);																 //브라우저에서 받아온 모든 형식은 문자이기에 형변환 필수
//		
//		int searchword = Integer.parseInt(keyword);
//		List<Emp> list = empservice.searchList(searchword);
//		model.addAttribute("list", list);  //모델에 담아버리고
//		return list;									//list를 return 해준다
//	}

}