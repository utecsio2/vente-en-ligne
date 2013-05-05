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
		
		String mail = request.getParameter("mail");
		
		String motDePasse = request.getParameter("motDePasse");
		
		String confirmeMotDePasse = request.getParameter("confirmeMotDePasse");
		
		String nom = request.getParameter("nom");
		
		String prenom = request.getParameter("prenom");
		
		String numTel = request.getParameter("numTel");
		
		String dateDeNaissance =  request.getParameter("dateDeNaissance");				
		
		
		

		
		try {
			System.out.println("ok");
			Class.forName("com.mysql.jdbc.Driver") ;	// chargement du pilote
			Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost", "root", null );
			System.out.println("Connecté");
			
			String req_select = "SELECT * FROM inscrits WHERE Mail = (?)";
			PreparedStatement prepSmt_select = connexion.prepareStatement(req_select);
			prepSmt_select.setString(1, mail);
			ResultSet r = prepSmt_select.executeQuery();
			int nbEnr = r.getFetchSize();
			if(nbEnr == 0){
				String req_insert = "INSERT INTO inscrits (mail,motDePasse,nom,prenom,numTel,dateDeNaissance) VALUES (?,?,?,?,?,?)";
				PreparedStatement prepSmt_insert = connexion.prepareStatement(req_insert);
				prepSmt_insert.setString(1,mail);
				prepSmt_insert.setString(2,motDePasse);
				prepSmt_insert.setString(3, nom);
				prepSmt_insert.setString(4,prenom);
				prepSmt_insert.setString(5,numTel);
				prepSmt_insert.setString(6, dateDeNaissance);
				prepSmt_insert.executeUpdate();
				
				
				 
				request.setAttribute("prenom", prenom);
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

