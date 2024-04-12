
package Controller;

import DAO.ServicesDao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.Services;
import DAOImpl.ServicesDaoImpl;

/**
 *
 * @author vali
 */
public class ServicesController extends HttpServlet {

	Services services = new Services();
	ServicesDaoImpl servicesDaoImpl = new ServicesDaoImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("adaugaServices") != null) {
			String nume_serv = request.getParameter("nume_serv");
			float taxa_serv = Float.parseFloat(request.getParameter("taxa_serv"));
			services.setNume_serv(nume_serv);
			services.setTaxa_serv(taxa_serv);
			servicesDaoImpl.adaugaServices(services);
			RequestDispatcher rd = request.getRequestDispatcher("adauga_Services.jsp");
			rd.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("afiseazaServices") != null) {
			List<Services> listaServices = new ArrayList();
			listaServices = servicesDaoImpl.afiseazaServices();
			request.setAttribute("listaServices", listaServices);
			RequestDispatcher rd = request.getRequestDispatcher("tabela_Services.jsp");
			rd.forward(request, response);
		}

		if (request.getParameter("modificaServices") != null) {
			long id1 = Long.parseLong(request.getParameter("idservices"));
			String nume_serv = request.getParameter("nume_serv");
			float taxa_serv = Float.parseFloat(request.getParameter("taxa_serv"));
			servicesDaoImpl.modificaServices(id1, nume_serv, taxa_serv);
			RequestDispatcher rd = request.getRequestDispatcher("adauga_Services.jsp");
			rd.forward(request, response);

		}

		if (request.getParameter("stergeServices") != null) {
			long id2 = Long.parseLong(request.getParameter("idservices"));
			services.setIdservices(id2);
			servicesDaoImpl.stergeServices(services);
			RequestDispatcher rd = request.getRequestDispatcher("adauga_Services.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>
}
