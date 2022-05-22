package com.mouse.controller.subcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mouse.controller.Controller;
import com.mouse.model.Mouse;
import com.mouse.service.MouseService;
import com.mouse.util.HttpUtil;

public class MouseUpdateController implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("update Controller입니다.");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String country = request.getParameter("country");
		String address = request.getParameter("address");
		
		Mouse mouse = new Mouse();
		mouse.setId(Integer.parseInt(id));
		mouse.setName(name);
		mouse.setCountry(country);
		mouse.setAddress(address);
		
		MouseService service = MouseService.getInstance();
		
		service.mouseUpdate(mouse);
		
		String path = "board?command=list";	
		
		HttpUtil.redirect(response, path);
	}

}
