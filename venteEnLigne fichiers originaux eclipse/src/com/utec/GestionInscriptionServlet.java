package com.utec;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GestionInscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionInscriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Mail = request.getParameter("email");
		
		String MotDePasse = request.getParameter("MotDePasse");
		
		String ConfirmeMotDePasse = request.getParameter("ConfirmeMotDePasse");
		
		String Nom = request.getParameter("nom");
		
		String Prenom = request.getParameter("prenom");
		
		String NumTel = request.getParameter("numTel");
		
		String DateDeNaissance =  request.getParameter("DateDeNaissance");				
		
		
		

		
		try {
			System.out.println("ok");
			Class.forName("com.mysql.jdbc.Driver") ;	// chargement du pilote
			Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost", "root", null );
			System.out.println("Connecté");
			
			String req_select = "SELECT * FROM inscrits WHERE Mail = (?)";
			PreparedStatement prepSmt_select = connexion.prepareStatement(req_select);
			prepSmt_select.setString(1, Mail);
			ResultSet r = prepSmt_select.executeQuery();
			int nbEnr = r.getFetchSize();
			if(nbEnr == 0){
				String req_insert = "INSERT INTO inscrits (Mail,MotDePasse,Nom,Prenom,NumTel,DateDeNaissance) VALUES (?,?,?,?,?,?)";
				PreparedStatement prepSmt_insert = connexion.prepareStatement(req_insert);
				prepSmt_insert.setString(1,Mail);
				prepSmt_insert.setString(2,MotDePasse);
				prepSmt_insert.setString(3, Nom);
				prepSmt_insert.setString(4,Prenom);
				prepSmt_insert.setString(5,NumTel);
				prepSmt_insert.setString(6, DateDeNaissance);
				prepSmt_insert.executeUpdate();
				
				
				 
				request.setAttribute("prenom", Prenom);
				getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
				
			}
			else{
				System.out.println("deja inscrit");
			}
			
					
			
			
			
			}	catch( Exception e ){
					e.printStackTrace();
			} 
		
		
		}
	}

