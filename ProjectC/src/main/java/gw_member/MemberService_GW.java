package gw_member;

import java.util.HashMap;
import java.util.List;

public interface MemberService_GW {
	
	MemberVO_GW member_login(HashMap<String, String> map); //(select)
	
	int member_join(MemberVO_GW vo);//(insert)
	
	void member_delete(int id);
	
	void member_update(MemberVO_GW vo);
	
	List<MemberVO_GW> member_list();
	
	int member_id_chk(String id);
	
}
