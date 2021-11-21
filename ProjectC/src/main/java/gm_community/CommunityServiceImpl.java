package gm_community;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunityServiceImpl implements CommunityService {

	@Autowired private CommunityDAO dao;
	
	@Override
	public int community_insert(CommunityVO vo) {
		return dao.community_insert(vo);
	}

	@Override
	public CommunityPage community_list(CommunityPage page) {
		return dao.community_list(page);
	}

	@Override
	public CommunityVO community_detail(int id) {
		return dao.community_detail(id);
	}

	@Override
	public int community_read(int id) {
		return dao.community_read(id);
	}

	@Override
	public int community_update(CommunityVO vo) {
		return dao.community_update(vo);
	}

	@Override
	public int community_delete(int id) {
		return dao.community_delete(id);
	}

	@Override
	public int comment_insert(CommunityCommentVO vo) {
		return dao.comment_insert(vo);
	}

	@Override
	public int comment_update(CommunityCommentVO vo) {
		return dao.comment_update(vo);
	}

	@Override
	public int comment_delete(int id) {
		return dao.comment_delete(id);
	}

	@Override
	public List<CommunityCommentVO> comment_list(int pno) {
		return dao.comment_list(pno);
	}

}
