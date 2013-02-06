package com.utec;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GestionFormServlet
 */
public class GestionFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionFormServlet() {
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
		String name = request.getParameter("nom");
		System.out.println(name);
		
		try {
		Class.forName("org.hsqldb.jdbcDriver") ;	// chargement du pilote
		Connection connexion = DriverManager.getConnection( "jdbc:hsqldb:hsql://localhost", "sa", null );
		
		System.out.println(connexion);
		
		String req= "INSERT INTO essai (nom) VALUES(?)";
		PreparedStatement prepStmt = connexion.prepareStatement(req);
		prepStmt.setString(1, name);
		prepStmt.executeUpdate();
		
		}	catch( Exception e ){
				e.printStackTrace();
		} 
	
			
	}

}
