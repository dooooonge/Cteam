package mj_member;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO implements MemberService {

	@Autowired @Qualifier("cteam") private SqlSession sql;
	
	@Override
	public boolean member_join(MemberVO vo) {
		return sql.insert("member.mapper.join", vo) == 1 ? true : false;	
	}

	@Override
	public int member_update(MemberVO vo) {
		return sql.update("member.mapper.update", vo);
	}

	@Override
	public boolean member_delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean member_id_check(String id) {
		return (Integer) sql.selectOne("member.mapper.id_check", id) == 0 ? true : false;
	}

	@Override
	public MemberVO member_login(HashMap<String, String> map) {
		System.out.println(map.get("email"));
		return sql.selectOne("member.mapper.member_login", map);
	}

	@Override
	public boolean member_social_email(MemberVO vo) {
		return (Integer) sql.selectOne("member.mapper.social_email", vo) == 0 ? false : true;
	}

	@Override
	public boolean member_social_insert(MemberVO vo) {
		return sql.insert("member.mapper.social_insert", vo) == 0 ? false : true;
	}

	@Override
	public boolean member_social_update(MemberVO vo) {
		return sql.update("member.mapper.social_update", vo) == 0 ? false : true;
	}

	@Override
	public MemberVO member_detail(String email) {
		return sql.selectOne("member.mapper.detail", email);
	}
	

}
