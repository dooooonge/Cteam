package gw_member;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
	
@Service
public class MemberServiceImpl_GW implements MemberService_GW {

	@Autowired MemberDAO_GW dao;
	
	@Override
	public MemberVO_GW member_login(HashMap<String, String> map) {

		return dao.member_login(map);
	}

	@Override
	public int member_join(MemberVO_GW vo) {
		return dao.member_join(vo);

	}

	@Override
	public void member_delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void member_update(MemberVO_GW vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<MemberVO_GW> member_list() {
		// TODO Auto-generated method stub
		return dao.member_list();
	}

	@Override
	public int member_id_chk(String id) {
		
		return dao.member_id_chk(id);
	}

}
