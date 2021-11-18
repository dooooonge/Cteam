package com.hanul.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import board.BoardServiceImpl;
import board.BoardVO;

@Controller
public class BoardController {
	
	@Autowired BoardServiceImpl service;
	
	@Scheduled(cron = "* * * 14 * *")
	@RequestMapping("/DB_Update")
	public String Board_DB_Update() {
		 
		service.board_clear();
		// json = key, value로 나누어진 데이터 자료 구조
		// { , } 중괄호 안에서 표현되고, 대괄호 [ , ]는 하나의 value
		// 중괄호는 우리가 사용하는 객체(DTO)같은 개념으로 이해를 하고
		// []대괄호는 List, Array의 개념으로 이해를 하면 된다.
		// 1.연결
		Calendar cal = Calendar.getInstance();
		String url = "http://api.data.go.kr/openapi/tn_pubr_public_pblprfr_event_info_api";
		// ?=&perPage=10&serviceKey=
		//?pageNo=1&numOfRows=100&type=json&ServiceKey=
		ArrayList<BoardVO> list = new ArrayList<>();
		String jsonData ="";

		try {
			long miliseconds = System.currentTimeMillis();
			Date date = new Date(miliseconds);
			System.out.println(date);
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM");
			String today = transFormat.format(date);
			date.setMonth(date.getMonth()+1);
			String nextDay = transFormat.format(date);
			
			//이번달부터 한달동안 공연정보 업데이트
				for(int k = 1; k <31; k++) {
					if(k<10) {
						jsonData = Jsoup.connect(url).data("pageNo", "1").data("numOfRows", "100").data("type","json").data("eventStartDate", today+"-0"+k)
					.data("ServiceKey",
							"IwgVDDGsxRFdLU7/Xc2DwJj23SLeFr9/UXRabzTddhiV7yUXBC2h3i95Gj+osLiKCHmkdo6882vlR28h2L6QUw==")
					.timeout(100000).userAgent("Chrome").ignoreContentType(true).execute().body();
					}
					if(k>9) {
						jsonData = Jsoup.connect(url).data("pageNo", "1").data("numOfRows", "100").data("type","json").data("eventStartDate", today+"-"+k)
								.data("ServiceKey",
										"IwgVDDGsxRFdLU7/Xc2DwJj23SLeFr9/UXRabzTddhiV7yUXBC2h3i95Gj+osLiKCHmkdo6882vlR28h2L6QUw==")
								.timeout(100000).userAgent("Chrome").ignoreContentType(true).execute().body();
					}
					
			System.out.println(jsonData);
			JSONParser jsonParser = new JSONParser();// JSONDATA 파싱을 위한 객체
			JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonData);
			System.out.println(jsonObject);
			jsonObject = (JSONObject) jsonObject.get("response");
			jsonObject = (JSONObject) jsonObject.get("body");
			JSONArray ArrayJson = (JSONArray) jsonObject.get("items");
			for (int i = 0; i < ArrayJson.size(); i++) {
				
				JSONObject jsonDTO = (JSONObject) ArrayJson.get(i);
				
				BoardVO BoardVO = new BoardVO(
						jsonDTO.get("eventNm").toString(),
						jsonDTO.get("opar").toString(),
						jsonDTO.get("eventCo").toString(),
						jsonDTO.get("eventStartDate").toString(),
						jsonDTO.get("eventEndDate").toString(),
						jsonDTO.get("eventStartTime").toString(),
						jsonDTO.get("eventEndTime").toString(),
						jsonDTO.get("chrgeInfo").toString(),
						jsonDTO.get("mnnst").toString(),
						jsonDTO.get("auspcInstt").toString(),
						jsonDTO.get("phoneNumber").toString(),
						jsonDTO.get("suprtInstt").toString(),
						jsonDTO.get("seatNumber").toString(),
						jsonDTO.get("admfee").toString(),
						jsonDTO.get("entncAge").toString(),
						jsonDTO.get("dscntInfo").toString(),
						jsonDTO.get("atpn").toString(),
						jsonDTO.get("homepageUrl").toString(),
						jsonDTO.get("advantkInfo").toString(),
						jsonDTO.get("prkplceYn").toString(),
						jsonDTO.get("rdnmadr").toString(),
						jsonDTO.get("lnmadr").toString(),
						jsonDTO.get("latitude").toString(),
						jsonDTO.get("longitude").toString(),
						jsonDTO.get("referenceDate").toString()
						);
				
				service.board_insert(BoardVO);
				System.out.println(BoardVO.getEventStartDate()+"일 시작하는" +BoardVO.getEventNm()+" DB저장 완료");
				Thread.sleep(200);
				// ArrayList<memberDTO>list 쓰는거랑 똑같음
			}}
				
				for(int k = 1; k <31; k++) {
					if(k<10) {
						jsonData = Jsoup.connect(url).data("pageNo", "1").data("numOfRows", "100").data("type","json").data("eventStartDate", nextDay+"-0"+k)
								.data("ServiceKey",
										"IwgVDDGsxRFdLU7/Xc2DwJj23SLeFr9/UXRabzTddhiV7yUXBC2h3i95Gj+osLiKCHmkdo6882vlR28h2L6QUw==")
								.timeout(100000).userAgent("Chrome").ignoreContentType(true).execute().body();
					}
					if(k>9) {
						jsonData = Jsoup.connect(url).data("pageNo", "1").data("numOfRows", "100").data("type","json").data("eventStartDate", nextDay+"-"+k)
								.data("ServiceKey",
										"IwgVDDGsxRFdLU7/Xc2DwJj23SLeFr9/UXRabzTddhiV7yUXBC2h3i95Gj+osLiKCHmkdo6882vlR28h2L6QUw==")
								.timeout(100000).userAgent("Chrome").ignoreContentType(true).execute().body();
					}
					
					System.out.println(jsonData);
					JSONParser jsonParser = new JSONParser();// JSONDATA 파싱을 위한 객체
					JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonData);
					System.out.println(jsonObject);
					jsonObject = (JSONObject) jsonObject.get("response");
					jsonObject = (JSONObject) jsonObject.get("body");
					JSONArray ArrayJson = (JSONArray) jsonObject.get("items");
					for (int i = 0; i < ArrayJson.size(); i++) {
						
						JSONObject jsonDTO = (JSONObject) ArrayJson.get(i);
						
						BoardVO BoardVO = new BoardVO(
								jsonDTO.get("eventNm").toString(),
								jsonDTO.get("opar").toString(),
								jsonDTO.get("eventCo").toString(),
								jsonDTO.get("eventStartDate").toString(),
								jsonDTO.get("eventEndDate").toString(),
								jsonDTO.get("eventStartTime").toString(),
								jsonDTO.get("eventEndTime").toString(),
								jsonDTO.get("chrgeInfo").toString(),
								jsonDTO.get("mnnst").toString(),
								jsonDTO.get("auspcInstt").toString(),
								jsonDTO.get("phoneNumber").toString(),
								jsonDTO.get("suprtInstt").toString(),
								jsonDTO.get("seatNumber").toString(),
								jsonDTO.get("admfee").toString(),
								jsonDTO.get("entncAge").toString(),
								jsonDTO.get("dscntInfo").toString(),
								jsonDTO.get("atpn").toString(),
								jsonDTO.get("homepageUrl").toString(),
								jsonDTO.get("advantkInfo").toString(),
								jsonDTO.get("prkplceYn").toString(),
								jsonDTO.get("rdnmadr").toString(),
								jsonDTO.get("lnmadr").toString(),
								jsonDTO.get("latitude").toString(),
								jsonDTO.get("longitude").toString(),
								jsonDTO.get("referenceDate").toString()
								);
						
						service.board_insert(BoardVO);
						System.out.println(BoardVO.getEventStartDate()+"일 시작하는" +BoardVO.getEventNm()+" DB저장 완료");
						Thread.sleep(200);
						// ArrayList<memberDTO>list 쓰는거랑 똑같음
					}}
			}catch (Exception e) {
			System.out.println("JSON에러");
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
			}
		
			System.out.println("DB업데이트완료");		
			return "/";
	}
	
	
	
}
