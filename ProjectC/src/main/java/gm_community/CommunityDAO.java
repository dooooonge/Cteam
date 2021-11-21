package gm_community;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class CommunityDAO implements CommunityService{

	@Autowired @Qualifier("cteam") private SqlSession sql;
	
	@Override
	public int community_insert(CommunityVO vo) {
		return sql.insert("community.mapper.insert", vo);
	}

	@Override
	public CommunityPage community_list(CommunityPage page) {
		//전체 게시글 수 조회
		page.setTotalList(sql.selectOne("community.mapper.totalList", page));
		
		//페이징 처리된 전체 게시글 조회
		page.setList(sql.selectList("community.mapper.list", page));
		return page;
	}

	@Override
	public CommunityVO community_detail(int id) {
		return sql.selectOne("community.mapper.detail", id);
	}

	@Override
	public int community_read(int id) {
		return sql.update("community.mapper.read", id);
	}

	@Override
	public int community_update(CommunityVO vo) {
		return sql.update("community.mapper.update", vo);
	}

	@Override
	public int community_delete(int id) {
		return sql.delete("community.mapper.delete", id);
	}

	@Override
	public int comment_insert(CommunityCommentVO vo) {
		return sql.insert("community.mapper.comment_insert", vo);
	}

	@Override
	public int comment_update(CommunityCommentVO vo) {
		return sql.update("community.mapper.comment_update", vo);
	}

	@Override
	public int comment_delete(int id) {
		return sql.update("community.mapper.comment_delete", id);
	}

	@Override
	public List<CommunityCommentVO> comment_list(int pno) {
		return sql.selectList("community.mapper.comment_list", pno);
	}

}
