package dev.sample.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import dev.sample.model.Book;

// index.jsp���� ���� ��û�� ó������ �޴� ��Ʈ�ѷ�(Servlet)

// @Controller // @Component�� �������� ���̹�
// @Controller�� ��ȿ�� ������ ex1 ~ ex3
@RestController
public class BookController {
	// 1. String���� �ش� �������� ��ȯ�ϴ� ���
	
	@RequestMapping("/add")
	
//	@GetMapping(path)
	public String ex1(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		System.out.println(name);
		System.out.println(author);
		
		return "result1.jsp";
	}
	
	// 2. ModelAndView Ȱ�� ���
	@RequestMapping("/add2")
	public ModelAndView ex2(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		// �̵��� ������ �� �������� ������ ��ü�� ���� ModelAndView ��ü ����
		// Model : �������� ������ ��ü
		// View : �̵��� ������ ���
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("result2.jsp"); // �̵���ų ������ ���ϸ� �Է�
		
		modelAndView.addObject("bookName", name);
		
		return modelAndView;
	}
	
	// 3. RequestParam Ȱ�� ���, ������ ����ϴ� HttpServletRequest, response�� ������� �ʴ� ���
	@RequestMapping("/add3")
	public ModelAndView ex3(@RequestParam("name") String name) {
		
		// Service ���� �� DB ���� �ڵ� �ۼ� �κ�

		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("result2.jsp");
		
		modelAndView.addObject("bookName", name);
		
		return modelAndView;
	}
	
	// 4. JSON ��ü ��ȯ ���
	@RequestMapping("/add4")
	public Book ex4(@RequestParam("name") String name, @RequestParam("author") String author) {
		// DB ó�� �ڵ� Book ��ƼƼ ��ȯ
		Book book = new Book();
		book.setName(name);
		book.setAuthor(author);
		
		return book;
	}
}
