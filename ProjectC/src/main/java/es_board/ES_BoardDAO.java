package es_board;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import gw_member.MemberVO_GW;

@Repository
public class ES_BoardDAO implements ES_BoardService {
	@Autowired @Qualifier("cteam")SqlSession sql;

	@Override
	public List<ES_BoardVO> es_board_list() {
		List<ES_BoardVO> list =  sql.selectList("es.board.mapper.es_board_list");
		
		ArrayList<ES_BoardVO> dtos = new ArrayList<ES_BoardVO>();
		
		for(int i = 0; i < list.size(); i++){
		dtos.add(new ES_BoardVO(
				list.get(i).getEventnm(),list.get(i).getOpar(), list.get(i).getEventco(), list.get(i).getEventstartdate(), list.get(i).getEventenddate(), list.get(i).getEventstarttime(), 
				list.get(i).getEventendtime(), list.get(i).getChrgeinfo(),list.get(i).getMnnst(), list.get(i).getAuspcinstt(), list.get(i).getPhonenumber(), list.get(i).getSuprtinstt(),
				list.get(i).getSeatnumber(), list.get(i).getAdmfee(), list.get(i).getEntncage(), list.get(i).getDscntinfo(), list.get(i).getAtpn(),
				list.get(i).getHomepageurl(), list.get(i).getAdvantkinfo(), list.get(i).getPrkplceyn(), list.get(i).getRdnmadr(), list.get(i).getLnmadr(), list.get(i).getAtitude(),
				list.get(i).getLongitude(), list.get(i).getReferencedate(), list.get(i).getNo(), list.get(i).getFilename(), list.get(i).getFilepath(), list.get(i).getWriter(), list.get(i).getOn_offline()));
		} 
		return dtos;
	}

	@Override
	public void es_board_insert(ES_BoardVO vo) {
		
	}

	@Override
	public void es_board_update(ES_BoardVO vo) {
		sql.update("es.board.mapper.es_board_update", vo);
	}

	@Override
	public void es_board_delete(int id) {

	}

	@Override
	public ES_BoardVO es_board_detail(int id) {
		return sql.selectOne("es.board.mapper.es_board_detail", id);
	}

}
