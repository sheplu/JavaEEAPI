package com.oromys.sheplu.API.servlet.open;

import java.io.Console;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext()
		.getRequestDispatcher("/WEB-INF/login.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mail = request.getParameter("mail");
		String pwd = request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		System.out.println("mail" + session.getAttribute("mail"));
		System.out.println("pwd" + session.getAttribute("password"));
		if(mail.equals(session.getAttribute("mail")) &&
				pwd.equals(session.getAttribute("password"))) {
			session.setAttribute("isLogged", "logged");
			response.sendRedirect("dashboard");
		}
		else {
			response.sendRedirect("login");
		}
	}

}
