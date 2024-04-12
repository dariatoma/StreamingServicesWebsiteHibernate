package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.Services;
import pojo.Abonati;
import pojo.Abonament;
import DAOImpl.AbonamentDaoImpl;
import DAOImpl.HibernateUtil;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.hibernate.Session;

/**
 *
 * @author vali
 */
public class AbonamentController extends HttpServlet {

	Abonament abonament = new Abonament();
	AbonamentDaoImpl abonamentDaoImpl = new AbonamentDaoImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("adaugaAbonament") != null) {
			// preluarea parametrilor de interes
			long idabonati = java.lang.Long.parseLong(request.getParameter("idabonati"));
			long idservices = java.lang.Long.parseLong(request.getParameter("idservices"));
			Session session = HibernateUtil.getSessionFactory().openSession();
			Abonati abonat = (Abonati) session.get(Abonati.class, idabonati);
			Services services = (Services) session.get(Services.class, idservices);
			String tip_abonament = request.getParameter("tip_abonament");
			/*DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date data_inceput = null;
			try {
				data_inceput = df.parse(request.getParameter("data_inceput"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Date data_expirare = null;
			try {
				data_expirare = df.parse(request.getParameter("data_expirare"));
			} catch (ParseException e) {
				e.printStackTrace();
			} */
			String data_inceput = request.getParameter("data_inceput");
			String data_expirare = request.getParameter("data_expirare");
			float taxa = Float.parseFloat(request.getParameter("taxa"));
			abonament.setAbonati(abonat);
			abonament.setServices(services);
			abonament.setTip_abonament(tip_abonament);
			abonament.setData_inceput(data_inceput);
			abonament.setData_expirare(data_expirare);
			abonament.setTaxa(taxa);

			abonamentDaoImpl.adaugaAbonament(abonament);
			RequestDispatcher rd = request.getRequestDispatcher("adauga_Abonament.jsp");
			rd.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("afiseazaAbonament") != null) {
			List<Abonament> listaAbonament = new ArrayList();
			listaAbonament = abonamentDaoImpl.afiseazaAbonament();
			request.setAttribute("listaAbonament", listaAbonament);
			RequestDispatcher rd = request.getRequestDispatcher("tabela_Abonament.jsp");
			rd.forward(request, response);
		}

		if (request.getParameter("modificaAbonament") != null) {
			long id1 = Long.parseLong(request.getParameter("idabonament"));
			// preluarea parametrilor de interes
			long idabonati = java.lang.Long.parseLong(request.getParameter("idabonati"));
			long idservices = java.lang.Long.parseLong(request.getParameter("idservices"));
			Session session = HibernateUtil.getSessionFactory().openSession();
			Abonati abonat = (Abonati) session.get(Abonati.class, idabonati);
			Services services = (Services) session.get(Services.class, idservices);
			String tip_abonament = request.getParameter("tip_abonament");
			String data_inceput = request.getParameter("data_inceput");
			String data_expirare = request.getParameter("data_expirare");
			float taxa = Float.parseFloat(request.getParameter("taxa"));

			abonamentDaoImpl.modificaAbonament(id1, abonat, services, tip_abonament, data_inceput, data_expirare, taxa);
			RequestDispatcher rd = request.getRequestDispatcher("adauga_Abonament.jsp");
			rd.forward(request, response);

		}

		if (request.getParameter("stergeAbonament") != null) {
			long id2 = Long.parseLong(request.getParameter("idabonament"));
			abonament.setIdabonament(id2);
			abonamentDaoImpl.stergeAbonament(abonament);
			RequestDispatcher rd = request.getRequestDispatcher("adauga_Abonament.jsp");
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


