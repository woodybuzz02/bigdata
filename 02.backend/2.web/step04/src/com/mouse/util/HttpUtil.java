package com.mouse.util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpUtil {
	public static void forward(HttpServletRequest request, HttpServletResponse response, String path) {
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
		
	public static void redirect(HttpServletResponse response, String path) {
		try {
			response.sendRedirect(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
