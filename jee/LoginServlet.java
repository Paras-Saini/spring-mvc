package com.in28Minutes.jee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/login.do")
public class LoginServlet extends HttpServlet {
	
	private UserValidationService service=new UserValidationService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
		
		/*PrintWriter writer=response.getWriter();
		

		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>Yahoo!!!!!!!!</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("My First Servlet");
		writer.println("</body>");
		writer.println("</html>");*/
		
		//System.out.println(request.getParameter("name"));
		String name=request.getParameter("name");
		
		request.setAttribute("name",name);
		request.setAttribute("password",request.getParameter("password"));
		
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
		boolean isUserValid=service.isUserValid(name, password);
		
		if(isUserValid) {
			request.setAttribute("name", name);
			request.setAttribute("password",password);
			request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request,response);
		}
		
		else {
			request.setAttribute("errorMessage", "Invalid Credentials");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}
		
	}

}
