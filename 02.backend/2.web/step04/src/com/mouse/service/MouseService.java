package com.mouse.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mouse.dao.MouseDAO;
import com.mouse.model.Mouse;

public class MouseService {

	// singleton 패턴, 해당 프로그램에서 인스턴스(객체)가 하나만 생성됨을 보장
	private static MouseService service = new MouseService();
	
	// 기본 생성자
	private MouseService() {}
	
	// 별도의 메서드를 통해서 이미 생성된 인스턴스를 반환
	public static MouseService getInstance(){
		return service;
	}

	public MouseDAO dao = MouseDAO.getInstance();
	
	// service -> dao(Data Access Object)	
	public ArrayList<Mouse> mouseList() throws SQLException{
		ArrayList<Mouse> mouseList = dao.mouseList();
		return mouseList;
	}

	public int mouseInsert(Mouse mouse) {
		int result = dao.mouseInsert(mouse);
		return result;
	}

	public Mouse mouseRead(String id) {
		Mouse result = dao.mouseRead(id);
		return result;
	}

	public int mouseUpdate(Mouse mouse) {
		int result = dao.mouseUpdate(mouse);
		return result;
	}

	public int mouseDelete(Mouse mouse) {
		int result = dao.mouseDelete(mouse);
		return result;
		
	}
}
