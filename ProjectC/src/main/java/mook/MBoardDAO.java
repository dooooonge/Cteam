package mook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class MBoardDAO implements MBoardService {
	
	@Autowired @Qualifier("cteam") private SqlSession sql;
	
	@Override
	public List<MBoardVO> board_all() {
		List<MBoardVO> dtos = sql.selectList("mook.mapper.all");
		return dtos;
	}

	@Override
	public List<MBoardVO> board_musical() {
		List<MBoardVO> dtos = sql.selectList("mook.mapper.musical");
		return dtos;
	}
	
	@Override
	public List<MBoardVO> board_opera() {
		List<MBoardVO> dtos = sql.selectList("mook.mapper.opera");
		return dtos;
	}
	
	@Override
	public List<MBoardVO> board_play() {
		List<MBoardVO> dtos = sql.selectList("mook.mapper.play");
		return dtos;
	}
	
	@Override
	public List<MBoardVO> board_exhibition() {
		List<MBoardVO> dtos = sql.selectList("mook.mapper.exhibition");
		return dtos;
	}
	
	@Override
	public List<MBoardVO> board_concert() {
		List<MBoardVO> dtos = sql.selectList("mook.mapper.concert");
		return dtos;
	}
	
	@Override
	public void board_insert(MBoardVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void board_delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void board_update(MBoardVO vo) {
		// TODO Auto-generated method stub

	}


	@Override
	public MBoardVO board_detail(MBoardVO vo) {
		// TODO Auto-generated method stub
		return null;
	}


}
