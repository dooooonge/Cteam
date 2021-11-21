package gw_member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
public class MemberDAO_GW implements MemberService_GW{
	
		@Autowired @Qualifier("cteam") SqlSession sql;
	
		
		//8. 로그인 : anLoginCommand에서 값을 넘겨받는다
		public MemberVO_GW member_login(HashMap<String, String> map) {
			
			return sql.selectOne("member.mapper.login_app", map);
		}
		
		
		//회원전체 정보 가져오기
		public ArrayList<MemberVO_GW> member_list() {
			List<MemberVO_GW> list =  sql.selectList("member.mapper.memberList_app");
			
			ArrayList<MemberVO_GW> dtos = new ArrayList<MemberVO_GW>();
			for(int i = 0; i < list.size(); i++){
			dtos.add(new MemberVO_GW(list.get(i).getNickname()
					,list.get(i).getPassword()
					,list.get(i).getAddress()
					,list.get(i).getEmail()
					,list.get(i).getIdnumber()
					,list.get(i).getFilepath()
					,list.get(i).getFilename()
					,list.get(i).getName()
					,list.get(i).getKind()
					,list.get(i).getJoindate()
					
					));
			}
			return dtos;
		}
		
		//9.로그인 정보 가져오기
		public List<MemberVO_GW> anSelectMember() {
			
			// 데이터베이스와 연동하여 원하는 결과물을 얻는다.
			List<MemberVO_GW> dtos = sql.selectList("member.mapper.memberList");
			return dtos;
			
		}

		@Override
		public int member_join(MemberVO_GW vo) {
			System.out.println(vo.getEmail());
			return sql.insert("member.mapper.member_join_app", vo);
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
		public int member_id_chk(String email) {
			// TODO Auto-generated method stub
			return sql.selectOne("member.mapper.id_check_app", email);
		}

		

}












