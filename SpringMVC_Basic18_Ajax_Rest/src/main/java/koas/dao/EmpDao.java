package koas.dao;

import kosa.vo.Emp;

public interface EmpDao {

	//회원가입
	public int insertMember(Emp emp); 
	
	public int delete(int empno);
		
	public Emp getMember(int empno);
	
	//회원수정
	public int updateMember(int empno);  

}
