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
@WebServlet("/CourseEnrollment")
public class CourseEnrollment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseEnrollment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		List<Kolegij> listaKolegija = (ArrayList<Kolegij>)request.getSession().getAttribute("listaKolegija");
		for (Kolegij kolegij : listaKolegija) {
			if (kolegij.isOdabran()) {
				try {
					DatabaseUtils.insertKolegijResults((Integer)request.getSession().getAttribute("KorisnikId"),kolegij.getId());
				} catch (SQLException | NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		try {
			request.setAttribute("listaKolegijaUpisani", DatabaseUtils.fetchAllKolegijListUpisani((Integer)request.getSession().getAttribute("KorisnikId")));
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/enroll.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
