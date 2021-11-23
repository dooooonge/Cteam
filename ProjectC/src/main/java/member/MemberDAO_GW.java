package member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
public class MemberDAO_GW{
	
		@Autowired @Qualifier("cteam") SqlSession sql;
	
		
		//8. 로그인 : anLoginCommand에서 값을 넘겨받는다
		public MemberVO member_login(HashMap<String, String> map) {
			
			return sql.selectOne("member.mapper.login_app_gw", map);
		}
		
		
		//회원전체 정보 가져오기
		public ArrayList<MemberVO> member_list() {
			List<MemberVO> list =  sql.selectList("member.mapper.memberList_app_gw");
			
			ArrayList<MemberVO> dtos = new ArrayList<MemberVO>();
			for(int i = 0; i < list.size(); i++){
			dtos.add(new MemberVO(list.get(i).getNickname()
					,list.get(i).getPassword()
					,list.get(i).getAddress()
					,list.get(i).getEmail()
					,list.get(i).getIdnumber()
					,list.get(i).getFilepath()
					,list.get(i).getName()
					,list.get(i).getType()
					,list.get(i).getJoindate()
					,list.get(i).getNaver()
					,list.get(i).getKakao()
					,list.get(i).getGoogle()
					
					));
			}
			return dtos;
		}
		
		//9.로그인 정보 가져오기
		public List<MemberVO> anSelectMember() {
			
			// 데이터베이스와 연동하여 원하는 결과물을 얻는다.
			List<MemberVO> dtos = sql.selectList("member.mapper.memberList_gw");
			return dtos;
			
		}



		public int member_join(MemberVO vo) {
			System.out.println(vo.getEmail());
			return sql.insert("member.mapper.member_join_app_gw", vo);
		}

		
		public void member_delete(int id) {
			// TODO Auto-generated method stub
			
		}

		
		public void member_update(MemberVO vo) {
			// TODO Auto-generated method stub
			
		}

	
		public int member_id_chk(String email) {
			// TODO Auto-generated method stub
			return sql.selectOne("member_gw.mapper.id_check_app_gw", email);
		}

		

}












