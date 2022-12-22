package kosa.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.Member;
import koas.dao.MemberDao;

@Service
public class EditService {

	@Autowired
	private SqlSession sqlsession;
	
	public Member getMember(String userid){
		MemberDao dao = sqlsession.getMapper(MemberDao.class);
		Member member = dao.getMember(userid);
		return member;
	}
	
	public void updateMember(Member member){
		MemberDao dao = sqlsession.getMapper(MemberDao.class);
		int result = dao.updateMember(member);
		if(result > 0){
			System.out.println("업데이트 성고");
		}else{
			System.out.println("업데이트 실패");
		}
	}
}
