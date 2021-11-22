package board;

import java.util.List;

public interface BoardService_GW {
	
	public int board_insert(BoardVO_GW dto);
	
	public void board_clear();
	
	public List<BoardVO_GW> board_list();
}
