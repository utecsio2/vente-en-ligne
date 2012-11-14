package code.source.site;

import java.io.IOException;
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
		if (Req == "1"){
			try{
				request.setAttribute("name", Req);
				getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
			}catch(ServletException e){
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idEtat = 0;
		int IdCommande;
		String nom = request.getParameter("thelist");
		//IdCommande = request.getParameter()
		switch (nom)
		{
		  case "En attente de paiement" : idEtat = 0;
		  case "Validé" : idEtat = 1;
		  case "En préparation" : idEtat = 2;
		  case "Envoyé" : idEtat = 3;
		}			
		String query = "UPDATE Etat SET idEtat =" + idEtat + " WHERE IdCommande =";// + IdCommande;

		ResultSet results;

		try {
			//Statement stmt = connexion.createStatement();

			//results = stmt.executeQuery(query);
			System.out.println(query);
		}catch(Exception e){
			System.out.println("exception due a la requete");

		}
	}
	
}
