package jy_notice;

public interface NoticeService {
	
	int notice_insert(NoticeVO vo);
	NoticePage notice_list(NoticePage page);
	NoticeVO notice_detail(int id);
	int notice_read(int id);
	int notice_update(NoticeVO vo);
	int notice_delete(int id);
}
