package com.mouse.controller.subcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mouse.controller.Controller;
import com.mouse.model.Mouse;
import com.mouse.service.MouseService;
import com.mouse.util.HttpUtil;

public class MouseListController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("list Controller입니다.");
		response.setContentType("text/html;charset=UTF-8");
		
		String url = null;
		
		// Controller -> Service
		MouseService service = MouseService.getInstance();
		try {
			ArrayList<Mouse> mouseList = service.mouseList();
			request.setAttribute("list", mouseList);
			
			url = "mouseListView.jsp";
			
			
		} catch (Exception e) {
			request.setAttribute("errorMessage", e.getMessage());
			url = "error.jsp";
		}
		
		// 실제 페이지 이동

		HttpUtil.forward(request, response, url);
	}

}
