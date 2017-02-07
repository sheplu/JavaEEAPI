package com.oromys.sheplu.API.servlet.open;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Statement;
import com.oromys.sheplu.API.bean.*;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext()
		.getRequestDispatcher("/WEB-INF/public/register.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName( "com.mysql.jdbc.Driver" );

		} catch ( ClassNotFoundException e ) {
	
		    /* Gérer les éventuelles erreurs ici. */
		}
		
		User user = new User();
		
		String mail = request.getParameter("mail");
		String pwd = request.getParameter("password");
		
		HttpSession session = request.getSession();
		session.setAttribute("mail", mail);
		session.setAttribute("password", pwd);
		java.sql.Statement statement = null;
		
		try {
			Connection connexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/JavaAPI",
					"root",
					"password");
			statement = connexion.createStatement();
			int statut = statement.executeUpdate( "INSERT INTO User (mail, password) VALUES ('bbb', MD5('bbb'));" );
		} 
		
		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			System.out.println("finally");
		}
		
		response.sendRedirect("login");
	}

}
