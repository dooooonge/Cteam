package board;

import org.springframework.stereotype.Service;

@Service
public interface BoardService_GW {
	
	public int board_insert(BoardVO_GW dto);
	
	public void board_clear();
}
