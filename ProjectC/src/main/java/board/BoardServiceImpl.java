package board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired BoardDAO dao;
	
	@Override
	public int board_insert(BoardVO dto) {
		return dao.board_insert(dto);
	}

	@Override
	public void board_clear() {
		dao.board_clear();
		
	}

}
