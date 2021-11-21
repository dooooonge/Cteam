package board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl_GW implements BoardService_GW {

	@Autowired BoardDAO_GW dao;
	
	@Override
	public int board_insert(BoardVO_GW dto) {
		return dao.board_insert(dto);
	}

	@Override
	public void board_clear() {
		dao.board_clear();
		
	}

}
