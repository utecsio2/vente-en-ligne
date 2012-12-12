package com.utec.commandes;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class formulaire
 */
public class formulaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public formulaire() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Req = request.getParameter("Action");
		//System.out.println(Req);
		if (Req.equals("1")){
			try{
				request.setAttribute("name", Req);
				getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
			}catch(ServletException e){
				
			}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idEtat = 0;
		int IdCommande = 1;
		String nom = request.getParameter("thelist");
		if(nom.equals("En attente de paiement")){
			idEtat = 0;
		}else if(nom.equals("Valide")){
			idEtat = 1;
		}else if(nom.equals("En preparation")){
			idEtat = 2;
		}else if(nom.equals("Envoye")){
			idEtat = 3;
		}
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost", "sa", null);
			String req = "INSERT INTO Commande (IdCommande, idEtat) VALUES (?, ?)";
			PreparedStatement prepStmt = connection.prepareStatement( req );
			prepStmt.setInt(1, IdCommande);
			prepStmt.setInt(2, idEtat);
			prepStmt.executeUpdate();
			System.out.println("Requete effectuee");
			try{
				request.setAttribute("IDCom", IdCommande);
				request.setAttribute("IDEtat", idEtat);
				getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
			}catch(ServletException e){
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
