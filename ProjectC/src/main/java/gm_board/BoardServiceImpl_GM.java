package gm_board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gm_board.BoardDAO_GM;
	
@Service
public class BoardServiceImpl_GM implements BoardService_GM {

	@Autowired private BoardDAO_GM dao;

	@Override
	public List<BoardVO_GM> board_all() {
		return dao.board_all();
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

	@Override
	public List<BoardVO_GM> board_musical() {
		return dao.board_musical();
	}

	@Override
	public List<BoardVO_GM> board_opera() {
		return dao.board_opera();
	}

	@Override
	public List<BoardVO_GM> board_play() {
		return dao.board_play();
	}

	@Override
	public List<BoardVO_GM> board_exhibition() {
		return dao.board_exhibition();
	}

	@Override
	public List<BoardVO_GM> board_concert() {
		return dao.board_concert();
	}



}
