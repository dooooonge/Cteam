package gm_board;

import java.util.List;

public interface BoardService_GM {
	
	List<BoardVO_GM> board_all(); //(select)
	
	List<BoardVO_GM> board_musical(); //(m_select)
	
	List<BoardVO_GM> board_opera(); //(o_select)
	
	List<BoardVO_GM> board_play(); //(p_select)
	
	List<BoardVO_GM> board_exhibition(); //(e_select)
	
	List<BoardVO_GM> board_concert(); //(c_select)
	
	void board_insert(BoardVO_GM vo);//(insert)
	
	void board_delete(int id);
	
	void board_update(BoardVO_GM vo);
	
	BoardVO_GM board_detail(BoardVO_GM vo);
	
}
