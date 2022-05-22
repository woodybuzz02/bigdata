package com.mouse.controller.subcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mouse.controller.Controller;
import com.mouse.model.Mouse;
import com.mouse.service.MouseService;
import com.mouse.util.HttpUtil;

public class MouseDeleteController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("delete Controller입니다.");
		String id = request.getParameter("id");
		
		Mouse mouse = new Mouse();
		mouse.setId(Integer.parseInt(id));
		
		MouseService service = MouseService.getInstance();
		
		service.mouseDelete(mouse);
		
		String path = "board?command=list";	
		
		HttpUtil.redirect(response, path);
	}

}


