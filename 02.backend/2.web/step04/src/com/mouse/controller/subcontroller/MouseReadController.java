package com.mouse.controller.subcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mouse.controller.Controller;
import com.mouse.model.Mouse;
import com.mouse.service.MouseService;
import com.mouse.util.HttpUtil;

public class MouseReadController implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("read Controller입니다.");
		
		String path = null;
		
		String id = request.getParameter("id");
		
		System.out.println("id는 "+id);
		
		MouseService service = MouseService.getInstance();
		
		try {
			Mouse mouse = service.mouseRead(id);
			
			request.setAttribute("mouse", mouse);
			
			path = "mouseUpdate.jsp";
			
			
		} catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			path = "error.jsp";
		}
		
		HttpUtil.forward(request, response, path);
		
	}

}
