package member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
	
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired MemberDAO dao;
	
	@Override
	public MemberVO member_login(HashMap<String, String> map) {

		return dao.member_login(map);
	}

	@Override
	public int member_join(MemberVO vo) {
		return dao.member_join(vo);

	}

	@Override
	public void member_delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void member_update(MemberVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<MemberVO> member_list() {
		// TODO Auto-generated method stub
		return dao.member_list();
	}

	@Override
	public int member_id_chk(String id) {
		
		return dao.member_id_chk(id);
	}

}
