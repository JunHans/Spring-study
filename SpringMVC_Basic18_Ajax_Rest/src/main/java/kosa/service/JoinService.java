package kosa.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import koas.dao.EmpDao;
import kosa.vo.Emp;




@Service
public class JoinService {

	@Autowired
	private SqlSession sqlsession;
	
	public int insertMember(Emp emp){
		int result = 0;
		EmpDao dao = sqlsession.getMapper(EmpDao.class);
		result = dao.insertMember(emp);
		return result;
	}
	
	public int delete(int empno){
		EmpDao dao = sqlsession.getMapper(EmpDao.class);
		int result = dao.delete(empno);
		return result;
	}
	
	public Emp getMember(int empno){
		EmpDao dao = sqlsession.getMapper(EmpDao.class);
		Emp member = dao.getMember(empno);
		return member;
	}
	
	public void updateMember(int empno){
		EmpDao dao = sqlsession.getMapper(EmpDao.class);
		int result = dao.updateMember(empno);
		if(result > 0){
			System.out.println("업데이트 성공");
		}else{
			System.out.println("업데이트 실패");
		}
	}
}
