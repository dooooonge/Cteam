package jy_notice;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO implements NoticeService{
	
	@Autowired @Qualifier("cteam") private SqlSession sql;

	@Override
	public int notice_insert(NoticeVO vo) {
		return sql.insert("notice.mapper.insert", vo);
	}

	@Override
	public NoticePage notice_list(NoticePage page) {
		//전체 게시글 수 조회
		page.setTotalList(sql.selectOne("notice.mapper.totalList", page));
		
		//페이징 처리된 전체 게시글 조회
		page.setList(sql.selectList("notice.mapper.list", page));
		return page;
	}

	@Override
	public NoticeVO notice_detail(int id) {
		return sql.selectOne("notice.mapper.detail", id);
	}

	@Override
	public int notice_read(int id) {
		return sql.update("notice.mapper.read", id);
	}

	@Override
	public int notice_update(NoticeVO vo) {
		return sql.update("notice.mapper.update", vo);
	}

	@Override
	public int notice_delete(int id) {
		return sql.delete("notice.mapper.delete", id);
	}

}
