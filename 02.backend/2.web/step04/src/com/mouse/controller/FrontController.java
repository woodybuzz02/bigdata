package com.mouse.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mouse.controller.subcontroller.MouseDeleteController;
import com.mouse.controller.subcontroller.MouseInsertController;
import com.mouse.controller.subcontroller.MouseListController;
import com.mouse.controller.subcontroller.MouseReadController;
import com.mouse.controller.subcontroller.MouseUpdateController;

@WebServlet("/board")
public class FrontController extends HttpServlet{
	
	HashMap<String, Controller> list = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException { // 서블릿 초기화 기능 담당
		list = new HashMap<String, Controller>(); // < key, value >
		// 값을 맵핑 Controller는 상위, MouseListController,MouseInsertController는 하위
		list.put("list", new MouseListController());
		list.put("insert", new MouseInsertController());
		list.put("read", new MouseReadController());
		list.put("update", new MouseUpdateController());
		list.put("delete", new MouseDeleteController());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// localhost:8080/step04/board?command=값
		String command = request.getParameter("command");
		System.out.println("command는" + command);
		
		if (command == null) {
			command = "list";
		}
		
		Controller subController = list.get(command);
		subController.execute(request, response); // execute구하도록 강제함.
	} 
	

	
}
