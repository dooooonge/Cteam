package gm_board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO_GM implements BoardService_GM {
	
	@Autowired @Qualifier("cteam") private SqlSession sql;
	
	@Override
	public List<BoardVO_GM> board_all() {
		List<BoardVO_GM> dtos = sql.selectList("mook.mapper.all");
		return dtos;
	}

	@Override
	public List<BoardVO_GM> board_musical() {
		List<BoardVO_GM> dtos = sql.selectList("mook.mapper.musical");
		return dtos;
	}
	
	@Override
	public List<BoardVO_GM> board_opera() {
		List<BoardVO_GM> dtos = sql.selectList("mook.mapper.opera");
		return dtos;
	}
	
	@Override
	public List<BoardVO_GM> board_play() {
		List<BoardVO_GM> dtos = sql.selectList("mook.mapper.play");
		return dtos;
	}
	
	@Override
	public List<BoardVO_GM> board_exhibition() {
		List<BoardVO_GM> dtos = sql.selectList("mook.mapper.exhibition");
		return dtos;
	}
	
	@Override
	public List<BoardVO_GM> board_concert() {
		List<BoardVO_GM> dtos = sql.selectList("mook.mapper.concert");
		return dtos;
	}
	
	@Override
	public void board_insert(BoardVO_GM vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void board_delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void board_update(BoardVO_GM vo) {
		// TODO Auto-generated method stub

	}


	@Override
	public BoardVO_GM board_detail(BoardVO_GM vo) {
		// TODO Auto-generated method stub
		return null;
	}


}
