package com.utec;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class gestionFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gestionFormServlet() {
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
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy",Locale.FRANCE);
		//try{
			String d =  request.getParameter("DateDeNaissance");
			System.out.print(d);			
		/*}catch(ParseException e){
			e.printStackTrace();
		}*/
		String login = request.getParameter("login");
		String MotDePasse = request.getParameter("MotDePasse");
		String ConfirmPassword = request.getParameter("ConfirmPassword");
		String email = request.getParameter("email");
		String ConfirmEmail = request.getParameter("ConfirmEmail");
		System.out.println(nom);
		
		
		
		}
	}

