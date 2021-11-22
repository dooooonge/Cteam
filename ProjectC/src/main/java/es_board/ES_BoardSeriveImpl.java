package es_board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ES_BoardSeriveImpl implements ES_BoardService {
	@Autowired ES_BoardDAO dao;
	
	@Override
	public List<ES_BoardVO> es_board_list() {
		return dao.es_board_list();
	}

	@Override
	public void es_board_insert(ES_BoardVO vo) {
	
	}

	@Override
	public void es_board_update(ES_BoardVO vo) {
		dao.es_board_update(vo);
	}

	@Override
	public void es_board_delete(int id) {

	}

	@Override
	public ES_BoardVO es_board_detail(int id) {
		return dao.es_board_detail(id);
	}

}
