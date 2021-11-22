package gm_community;

import java.util.List;

public interface CommunityService {
	
	int community_insert(CommunityVO vo);
	
	CommunityPage community_list(CommunityPage page);
	
	CommunityVO community_detail(int id);
	
	int community_read(int id);
	
	int community_update(CommunityVO vo);
	
	int community_delete(int id);
	
	int comment_insert(CommunityCommentVO vo);
	
	int comment_update(CommunityCommentVO vo);
	
	int comment_delete(int id);
	
	List<CommunityCommentVO> comment_list(int pid);
}
