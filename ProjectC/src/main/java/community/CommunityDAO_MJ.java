package community;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class CommunityDAO_MJ{

	@Autowired @Qualifier("cteam") private SqlSession sql;
	
	public int community_insert(CommunityVO vo) {
		return sql.insert("community.mapper.insert", vo);
	}

	public CommunityPage community_list(CommunityPage page) {
		//전체 게시글 수 조회
		page.setTotalList(sql.selectOne("community.mapper.totalList", page));
		
		//페이징 처리된 전체 게시글 조회
		page.setList(sql.selectList("community.mapper.list", page));
		return page;
	}

	public CommunityVO community_detail(int id) {
		return sql.selectOne("community.mapper.detail", id);
	}

	public int community_read(int id) {
		return sql.update("community.mapper.read", id);
	}

	public int community_update(CommunityVO vo) {
		return sql.update("community.mapper.update", vo);
	}

	public int community_delete(int id) {
		return sql.delete("community.mapper.delete", id);
	}

	public int comment_insert(CommentVO vo) {
		return sql.insert("community.mapper.comment_insert", vo);
	}

	public int comment_update(CommentVO vo) {
		return sql.update("community.mapper.comment_update", vo);
	}

	public int comment_delete(int id) {
		return sql.update("community.mapper.comment_delete", id);
	}

	public List<CommentVO> comment_list(int pno) {
		return sql.selectList("community.mapper.comment_list", pno);
	}

}
