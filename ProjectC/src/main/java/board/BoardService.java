package board;

import org.springframework.stereotype.Service;

@Service
public interface BoardService {
	
	public int board_insert(BoardVO dto);
	
	public void board_clear();
}
