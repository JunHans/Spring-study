package kosa.dao;

import java.sql.SQLException;
import java.util.List;

import kosa.vo.Emp;

//CRUD
public interface EmpDao {

	// 전체 조회
	List<Emp> allList() throws ClassNotFoundException, SQLException;

	// 조건 조회
	List<Emp> searchList(int keyword) throws ClassNotFoundException, SQLException;

	// 상세
	Emp getEmp(int empno) throws ClassNotFoundException, SQLException;

	// 삽입
	String insert(Emp emp) throws ClassNotFoundException, SQLException;

	// 수정
	int update(Emp emp) throws ClassNotFoundException, SQLException;

	// 삭제
	int delete(int empno) throws ClassNotFoundException, SQLException;
}
