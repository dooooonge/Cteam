package qna;

import java.util.List;

public interface QnaService {
	
	void qna_insert(QnaVO vo);
	void qna_reply_insert(QnaVO vo);
	List<QnaVO> qna_list();
	QnaPage qna_list(QnaPage page);
	
	QnaVO qna_detail(int id);
	void qna_update(QnaVO vo);
	void qna_delete(int id);
	void qna_read(int id);

}
