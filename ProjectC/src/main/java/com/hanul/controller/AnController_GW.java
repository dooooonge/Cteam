package com.hanul.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.google.gson.Gson;

import board.BoardDAO_GW;
import board.BoardVO;
import member.MemberDAO_GW;
import member.MemberVO;

@Controller
public class AnController_GW {
	
	@Autowired MemberDAO_GW member_gw;
	@Autowired BoardDAO_GW board_gw;
	
	@RequestMapping("/anIdCheck")
	public void anIdCheck(String email, HttpServletResponse response) {
		System.out.println("emailCheck");
		int chk = member_gw.member_id_chk(email);
		
		
		PrintWriter out;
		
		try {
			out = response.getWriter();
			out.println(chk+"");	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@RequestMapping(value="/anJoin", method = {RequestMethod.GET, RequestMethod.POST})
	public void anJoin(HttpServletRequest req, Model model, HttpServletResponse response) {
		System.out.println("anJoin");
		
		// 1. 안드로이드에서 보낸 데이터를 req로 받아서 변수에 저장
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		String filename = req.getParameter("filename");
		String nickname = req.getParameter("nickname");
		String idnumber = req.getParameter("idnumber");
		String address = req.getParameter("address");		
		// 2. 찍어봅시다
		System.out.println(email + ", " + password + ", " + name + ", " 
				+ nickname + ", " + idnumber + ", " + address );
		//MultipartRequest multi1 = (MultipartRequest)req;
		//MultipartFile file1 = multi1.getFile("filename");
		MemberVO vo = new MemberVO();
		vo.setEmail(email);
		vo.setPassword(password);
		vo.setAddress(address);
		vo.setIdnumber(idnumber);
		vo.setName(name);
		vo.setNickname(nickname);
		
		// 3. 안드로이드에서 보낸 파일 받기 : 파일을 보낸 경우에만 실행
		// 파일이름만 저장해 놓고 안드로이드에서 받아서 전체 경로를 완성한다   
		String realImgPath = "";
		if(filename==null || filename.equals("") ) {
		MultipartRequest multi = (MultipartRequest)req;
		MultipartFile file = multi.getFile("filename");
		if(file != null) {
			filename = file.getOriginalFilename();
			System.out.println("fileName : " + filename);
			
			if(file.getSize() > 0) {
				realImgPath = req.getSession().getServletContext()
						.getRealPath("/resources/");
				System.out.println("realpath : " + realImgPath);
				System.out.println("fileSize : " + file.getSize());
				// 이미지 파일을 서버에 저장
				try {
					file.transferTo(new File(realImgPath, filename));
				} catch (Exception e) {
					e.getMessage();
				} 	
			}
		}}
		vo.setFilepath(realImgPath+filename);
		int succ = member_gw.member_join(vo);
		
		PrintWriter out;
		
		try {
			out = response.getWriter();
			out.println(succ+"");	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	@ResponseBody
	@RequestMapping(value="/anLogin", method = {RequestMethod.GET, RequestMethod.POST})
	public void anLogin(String email, String pw, Model model, HttpServletResponse response) {
		
		System.out.println("anLogin");
		
		// 1. 안드로이드에서 보낸 데이터를 req로 받아서 변수에 저장
		/*
		 * String id = req.getParameter("ID"); String password =
		 * req.getParameter("PASSWORD");
		 */
		
		// 2. 찍어봅시다
		System.out.println(email + ", " + pw );
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		map.put("pw", pw);
		
		MemberVO vo =  member_gw.member_login(map);
		System.out.println(vo.getEmail()+"조회 완료");
		
		Gson gson = new Gson();
		String json = gson.toJson(vo);
		PrintWriter out;
		// 클라이언트에게 응답
		try {
			out = response.getWriter();
			out.println(json);	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * PrintWriter out = res.getWriter(); Gson gson = new Gson(); String data =
		 * gson.toJson(list); out.println(data);
		 */		
		
	}
	

	@RequestMapping(value="/anSelectMember", method = {RequestMethod.GET, RequestMethod.POST})
	public void anSelectMember(HttpServletRequest req, Model model, HttpServletResponse response) {
		System.out.println("anSelectMember");
		List<MemberVO> dtos = member_gw.member_list();
		
		Gson gson = new Gson();
		String json = gson.toJson(dtos);
		PrintWriter out;
		// 클라이언트에게 응답
		try {
			out = response.getWriter();
			out.println(json);	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("/anBoardList")
	public void anSelectBoardList(HttpServletResponse response) {
		System.out.println("anBoardList");
		List<BoardVO> list = board_gw.board_list();
		
		Gson gson = new Gson();
		String json = gson.toJson(list);
		PrintWriter out;
		// 클라이언트에게 응답
		try {
			out = response.getWriter();
			out.println(json);	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
