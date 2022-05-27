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

// index.jsp에서 보낸 요청을 처음으로 받는 컨트롤러(Servlet)

// @Controller // @Component의 직관적인 네이밍
// @Controller가 유효한 범위는 ex1 ~ ex3
@RestController
public class BookController {
	// 1. String으로 해당 페이지를 반환하는 방식
	
	@RequestMapping("/add")
	
//	@GetMapping(path)
	public String ex1(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		System.out.println(name);
		System.out.println(author);
		
		return "result1.jsp";
	}
	
	// 2. ModelAndView 활용 방식
	@RequestMapping("/add2")
	public ModelAndView ex2(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		// 이동할 페이지 및 페이지에 전달할 객체를 담을 ModelAndView 객체 생성
		// Model : 페이지에 전달할 객체
		// View : 이동할 페이지 담당
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("result2.jsp"); // 이동시킬 페이지 파일명 입력
		
		modelAndView.addObject("bookName", name);
		
		return modelAndView;
	}
	
	// 3. RequestParam 활용 방식, 기존에 사용하던 HttpServletRequest, response를 사용하지 않는 방식
	@RequestMapping("/add3")
	public ModelAndView ex3(@RequestParam("name") String name) {
		
		// Service 로직 및 DB 접근 코드 작성 부분

		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("result2.jsp");
		
		modelAndView.addObject("bookName", name);
		
		return modelAndView;
	}
	
	// 4. JSON 객체 반환 방식
	@RequestMapping("/add4")
	public Book ex4(@RequestParam("name") String name, @RequestParam("author") String author) {
		// DB 처리 코드 Book 엔티티 반환
		Book book = new Book();
		book.setName(name);
		book.setAuthor(author);
		
		return book;
	}
}
