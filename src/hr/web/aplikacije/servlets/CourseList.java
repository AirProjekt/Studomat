package hr.web.aplikacije.servlets;

import hr.web.aplikacije.domain.DatabaseUtils;
import hr.web.aplikacije.domain.Kolegij;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CourseEnrollment
 */
@WebServlet("/CourseList")
public class CourseList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession(false).getAttribute("listaKolegija") == null && request.getSession(false).getAttribute("KorisnikId") == null) {
			try {
				request.getSession(false).setAttribute("listaKolegija",DatabaseUtils.fetchAllKolegijList());
				request.getSession(false).setAttribute("KorisnikId", DatabaseUtils.retriveKorisnikId(request.getUserPrincipal().getName()));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setCharacterEncoding("UTF-8");
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/enrollment.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer idOdabranogKolegija = Integer.parseInt((String)request.getParameter("idOdabrKolegija"));
		@SuppressWarnings("unchecked")
		List<Kolegij> listaKolegija = (ArrayList<Kolegij>)request.getSession().getAttribute("listaKolegija");
		for (Kolegij kolegij : listaKolegija) {
			if (kolegij.getId() == idOdabranogKolegija) {
				kolegij.setOdabran(true);
			}
		}
		doGet(request, response);
	}

}
