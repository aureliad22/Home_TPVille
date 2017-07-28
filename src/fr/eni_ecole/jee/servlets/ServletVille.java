package fr.eni_ecole.jee.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni_ecole.jee.beans.Ville;
import fr.eni_ecole.jee.dao.VilleDAO;

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
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/villes.jsp");		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		processRequest(request, response);
	}

	/**
	 * Méthode en charge de traiter une requête et fournir une réponse.
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paysChoisi = request.getParameter("country");

		try {
			List<Ville> listeVilles = new VilleDAO().listerFromXml(paysChoisi);
			request.setAttribute("listeVilles", listeVilles);
			request.setAttribute("country", paysChoisi);
		} catch (Exception e) {
			request.setAttribute("erreur", e.getMessage());
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/villes.jsp");		
		rd.forward(request, response);
	}
}
