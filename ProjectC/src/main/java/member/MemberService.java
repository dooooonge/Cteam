package member;

import java.util.HashMap;
import java.util.List;

public interface MemberService {
	
	MemberVO member_login(HashMap<String, String> map); //(select)
	
	int member_join(MemberVO vo);//(insert)
	
	void member_delete(int id);
	
	void member_update(MemberVO vo);
	
	List<MemberVO> member_list();
	
	int member_id_chk(String id);
	
}
