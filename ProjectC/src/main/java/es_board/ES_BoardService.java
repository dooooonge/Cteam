package es_board;

import java.util.List;

public interface ES_BoardService {
	List<ES_BoardVO> es_board_list(); 
	
	void es_board_insert(ES_BoardVO vo);
	
	void es_board_update(ES_BoardVO vo);
	
	void es_board_delete(int id);
	
	ES_BoardVO es_board_detail(int id);
	

}
