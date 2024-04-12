package Controller;

import DAO.AbonatiDao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.Abonati;
import DAOImpl.AbonatiDaoImpl;

/**
 *
 * @author vali
 */
public class AbonatiController extends HttpServlet {

	Abonati abonat = new Abonati();
	AbonatiDaoImpl abonatDaoImpl = new AbonatiDaoImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("adaugaAbonat") != null) {
			String nume = request.getParameter("nume");
			String prenume = request.getParameter("prenume");
			int varsta = Integer.parseInt(request.getParameter("varsta"));
			String data_nasterii = request.getParameter("data_nasterii");
			String tara = request.getParameter("tara");
			String adresa_mail = request.getParameter("adresa_mail");
			abonat.setNume(nume);
			abonat.setPrenume(prenume);
			abonat.setVarsta(varsta);
			abonat.setData_nasterii(data_nasterii);
			abonat.setTara(tara);
			abonat.setAdresa_mail(adresa_mail);
			abonatDaoImpl.adaugaAbonat(abonat);
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("afiseazaAbonat") != null) {
			List<Abonati> listaAbonati = new ArrayList();
			listaAbonati = abonatDaoImpl.afiseazaAbonat();
			request.setAttribute("listaAbonati", listaAbonati);
			RequestDispatcher rd = request.getRequestDispatcher("tabela_Abonati.jsp");
			rd.forward(request, response);
		}

		if (request.getParameter("modificaAbonat") != null) {
			long id1 = Long.parseLong(request.getParameter("idabonati"));
			String nume = request.getParameter("nume");
			String prenume = request.getParameter("prenume");
			int varsta = Integer.parseInt(request.getParameter("varsta"));
			String data_nasterii = request.getParameter("data_nasterii");
			String tara = request.getParameter("tara");
			String adresa_mail = request.getParameter("adresa_mail");
			abonatDaoImpl.modificaAbonat(id1, nume, prenume, varsta, data_nasterii, tara, adresa_mail);
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.forward(request, response);

		}

		if (request.getParameter("stergeAbonat") != null) {
			long id2 = Long.parseLong(request.getParameter("idabonati"));
			abonat.setIdabonati(id2);
			abonatDaoImpl.stergeAbonat(abonat);
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
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


