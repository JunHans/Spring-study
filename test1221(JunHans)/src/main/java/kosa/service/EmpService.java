package kosa.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosa.dao.EmpDao;
import kosa.vo.Emp;

@Service
public class EmpService {

	// Mybatis 작업
	private SqlSession sqlsession;

	@Autowired
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}

	
	// Emp 전체 조회
	public List<Emp> allList() {

		// DAO 작업
		List<Emp> list = null;
		try {
			// 동기화/////////////////////////////////////////////////////
			EmpDao empdao = sqlsession.getMapper(EmpDao.class);
			/////////////////////////////////////////////////////////////
			list = empdao.allList();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//상세보기 서비스
		public Emp empDetail(int empno) {
			Emp emp = null;
			try {
					//동기화/////////////////////////////////////////////////////
				EmpDao empdao = sqlsession.getMapper(EmpDao.class);
					///////////////////////////////////////////////////////////	
				    emp = empdao.getEmp(empno);
			} catch (ClassNotFoundException e) {
							e.printStackTrace();
			} catch (SQLException e) {
							e.printStackTrace();
			}
			return emp;		
		}

	
	// Emp 조건 조회
	public List<Emp> searchList(int keyword) {

		// DAO 작업
		List<Emp> list = null;
		try {
			// 동기화/////////////////////////////////////////////////////
			EmpDao empdao = sqlsession.getMapper(EmpDao.class);
			/////////////////////////////////////////////////////////////
			list = empdao.searchList(keyword);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	
	// 삽입
	public void insert(Emp emp) {

		try {
			EmpDao empdao = sqlsession.getMapper(EmpDao.class);
			empdao.insert(emp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	// 수정
	public void empEdit(Emp emp) {
		try {
			// 동기화/////////////////////////////////////////////////////
			EmpDao empdao = sqlsession.getMapper(EmpDao.class);
			///////////////////////////////////////////////////////////
			empdao.update(emp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	// 삭제
	public void empDel(int empno) {
		EmpDao empdao = sqlsession.getMapper(EmpDao.class);
		try {
			empdao.delete(empno);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
