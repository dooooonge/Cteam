package board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
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
	
	@Override
	public List<BoardVO_GW> board_list() {
		return dao.board_list();
	}
	

}
