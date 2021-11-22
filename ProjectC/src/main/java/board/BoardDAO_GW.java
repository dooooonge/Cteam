package board;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO_GW implements BoardService_GW{
	
	@Autowired @Qualifier("cteam")SqlSession sql;

	public int board_insert(BoardVO_GW dto) {
		
		
		return sql.insert("gw_board.mapper.board_insert", dto);
	}

	@Override
	public void board_clear() {
		sql.delete("gw_board.mapper.board_clear");		
	}
	
	@Override
	public List<BoardVO_GW> board_list() {
		
		return sql.selectList("gw_board.mapper.board_list_gw");
		
	}
	
}
