package mook;

import java.util.List;

public interface MBoardService {
	
	List<MBoardVO> board_all(); //(select)
	
	List<MBoardVO> board_musical(); //(m_select)
	
	List<MBoardVO> board_opera(); //(o_select)
	
	List<MBoardVO> board_play(); //(p_select)
	
	List<MBoardVO> board_exhibition(); //(e_select)
	
	List<MBoardVO> board_concert(); //(c_select)
	
	void board_insert(MBoardVO vo);//(insert)
	
	void board_delete(int id);
	
	void board_update(MBoardVO vo);
	
	MBoardVO board_detail(MBoardVO vo);
	
}
