package jy_notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired private NoticeDAO dao;
	
	@Override
	public int notice_insert(NoticeVO vo) {
		return dao.notice_insert(vo);
	}

	@Override
	public NoticePage notice_list(NoticePage page) {
		return dao.notice_list(page);
	}

	@Override
	public NoticeVO notice_detail(int id) {
		return dao.notice_detail(id);
	}

	@Override
	public int notice_read(int id) {
		return dao.notice_read(id);
	}

	@Override
	public int notice_update(NoticeVO vo) {
		return dao.notice_update(vo);
	}

	@Override
	public int notice_delete(int id) {
		return dao.notice_delete(id);
	}

}
