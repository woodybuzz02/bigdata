package step01.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SetCookie")
public class SetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서버가 클라이언트한테 응답 메시지로 보낼 데이터에 대한 부가정보(문서의 타입, 문자셋 지정)
		response.setContentType("text/html;charset=UTF-8");
		// 쿠키 객체 생성, constructs a cookie with the specified name and value.
		Cookie cookie1 = new Cookie("id","guest");
		// 쿠키는?  클라이언트 측(브라우저)에 저장, 클라이언트 측에 보내기 위해서는 응답 객체에 쿠키를 저장해야함.
		response.addCookie(cookie1);
		
		Cookie cookie2 = new Cookie("nickName","Spiderman");
		cookie2.setMaxAge(60 * 60 * 3);
		response.addCookie(cookie2);
		
		PrintWriter out = response.getWriter();
		out.print("서버에 생성한 쿠키가 클라이언트로 전송되었음");
		
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
