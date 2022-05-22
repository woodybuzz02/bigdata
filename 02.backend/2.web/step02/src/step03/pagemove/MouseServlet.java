package step03.pagemove;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mouseInsert")
public class MouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("UTF-8");
		
		// form에서 입력된 값 받기
		String name = request.getParameter("name");
		String country = request.getParameter("country");
		String address = request.getParameter("address");
		
		Mouse mouse = new Mouse();
		mouse.setName(name);
		mouse.setCountry(country);
		mouse.setAddress(address);
		System.out.println("DB 등록 처리 진행");
		
		request.setAttribute("mouse", mouse); //mouse라는 이름의 key값으로 mouse 인스턴스를 담았음.
		
		RequestDispatcher rd = request.getRequestDispatcher("mouseResult");
		
		rd.forward(request, response);
		
		out.close();
	}

}
