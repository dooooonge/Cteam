package mook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
	
@Service
public class MBoardServiceImpl implements MBoardService {

	@Autowired private MBoardDAO dao;

	@Override
	public List<MBoardVO> board_all() {
		return dao.board_all();
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

	@Override
	public List<MBoardVO> board_musical() {
		return dao.board_musical();
	}

	@Override
	public List<MBoardVO> board_opera() {
		return dao.board_opera();
	}

	@Override
	public List<MBoardVO> board_play() {
		return dao.board_play();
	}

	@Override
	public List<MBoardVO> board_exhibition() {
		return dao.board_exhibition();
	}

	@Override
	public List<MBoardVO> board_concert() {
		return dao.board_concert();
	}



}
