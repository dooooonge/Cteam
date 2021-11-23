package com.hanul.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import board.BoardDAO_ES;
import board.BoardVO;

@Controller
public class ES_BoardController {
	@Autowired BoardDAO_ES dao_es;
	
	@RequestMapping("/esDetail")
	public String es_detail(int id) {
		dao_es.es_board_detail(id);
		
		return "";
	}
	
	@RequestMapping("/esUpdate")
	public String es_update(BoardVO vo, Model model, HttpSession session, MultipartFile file, String attach) {
		dao_es.es_board_update(vo);
		
		// 원 글에 첨부 파일이 있는지...
				BoardVO board = dao_es.es_board_detail(vo.getNo());
				String uuid = session.getServletContext().getRealPath("resources") + "/" + board.getFilepath();
				
				// 파일을 첨부하지 않은 경우
				if ( file.isEmpty() ) {
					// 원래부터 첨부된 파일이 없는 경우
					// 원래 첨부된 파일이 있었는데 삭제한 경우
					if ( attach.isEmpty() ) {
						// 원래 첨부되어 있는 파일이 있다면 서버의 물리적 영역에서 삭제
						if ( board.getFilename() != null) {
							File f = new File(uuid);
							if ( f.exists() ) f.delete();	// 파일이 존재하면 파일 삭제
						}
					} else {
						// 원래 첨부된 파일을 그대로 사용하는 경우
						vo.setFilename( board.getFilename() );
						vo.setFilepath( board.getFilepath() );
					}
				} else {
					// 파일을 첨부한 경우
					vo.setFilename( board.getFilename() );
					vo.setFilepath( board.getFilepath() );
					
					// 원래 첨부 되어 있는 파일이 있다면 서버의 물리적 영역에서 삭제
					if ( board.getFilename() != null) {
						File f = new File(uuid);
						if ( f.exists() ) f.delete();	// 파일이 존재하면 파일 삭제
					}
				}
				// 화면에서 수정한 정보들을 DB에서 저장한 후 상세화면 연결
				dao_es.es_board_update(vo);
				model.addAttribute("uri", "esUpdate");
				model.addAttribute("id", vo.getNo());
		
		return "esUpdate";
	}
	
	@RequestMapping("/esList")
	public void es_detail_list(HttpServletRequest req, Model model, HttpServletResponse res) {
		List<BoardVO> dtos = dao_es.es_board_list();
		Gson gson = new Gson();
		String json = gson.toJson(dtos);
		PrintWriter out;
		// 클라이언트에게 응답
		try {
			out = res.getWriter();
			out.println(json);	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
