package fr.eni_ecole.jee.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni_ecole.jee.beans.Ville;
import fr.eni_ecole.jee.manip.xml.TraiterXML;

/**
 * Servlet implementation class ServletVille
 */
public class ServletVille extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletVille() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ville.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("UTF-8");		
		String paysChoisi = request.getParameter("country");
		request.setAttribute("paysChoisi", paysChoisi);
		System.out.println(paysChoisi);
		listerVilles(request, response);
	}

	/**
	 * Méthode en charge de retourner la liste des villes
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void listerVilles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paysChoisi = request.getParameter("country");
		List<Ville> listeVilles = new TraiterXML().listerFromXml(paysChoisi);
/*		System.out.println("Entrée dans la servlet");
		System.out.println(listeVilles.size());
		for (Ville ville : listeVilles) {
			System.out.println(ville.getNom());
		}*/
		if (listeVilles != null && listeVilles.size()>0) {
			request.setAttribute("listeVilles", listeVilles);
			request.setAttribute("country", paysChoisi);

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ville.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("erreur", "Les villes sont inaccessibles pour le moment");
			RequestDispatcher rd = request.getRequestDispatcher("/erreur.jsp");
			rd.forward(request, response);
		}
		response.setCharacterEncoding("UTF-8");
	}
}
