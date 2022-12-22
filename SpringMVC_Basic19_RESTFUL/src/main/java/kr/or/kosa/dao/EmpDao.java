package kr.or.kosa.dao;

import java.util.List;

import kr.or.kosa.dto.Emp;

//CRUD 함수
public interface EmpDao {
	
	// 삽입
	int insert(Emp emp);

	// 전체 조회
	List<Emp> select();

	// 조건 조회
	Emp selectByEmpno(int empno);

	// 수정
	int update(Emp empno);

	// 삭제
	int delete(int empno);
}
