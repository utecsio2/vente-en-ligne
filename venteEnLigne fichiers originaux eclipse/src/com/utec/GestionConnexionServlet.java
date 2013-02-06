package com.utec;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GestionFormServlet
 */
public class GestionConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionConnexionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String passwd = request.getParameter("passwd");
		System.out.println(login);
		System.out.println(passwd);
		
		try {
		Class.forName("org.hsqldb.jdbcDriver") ;	// chargement du pilote
		Connection connexion = DriverManager.getConnection( "jdbc:hsqldb:hsql://localhost", "sa", null );
		System.out.println(connexion);
		
		// La requête pour insérer dans la base
		String req = "SELECT * from personne where login='" + login + "'" ;
		Statement prepSmt = connexion.createStatement();
		ResultSet result = prepSmt.executeQuery(req);
		if(result.next()){
			if (result.getString("password").equals(passwd))
			{
				String nom = result.getString("login");
				request.setAttribute("login", login);
				HttpSession session = request.getSession();
				session.setAttribute("login", login);
			}
			else{}
		}else{}

		getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
		
		}	catch( Exception e ){
				e.printStackTrace();
		} 
	
			
	}

}
