/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImpl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Abonati;
import DAO.AbonatiDao;

/**
 *
 * @author vali
 */
public class AbonatiDaoImpl implements AbonatiDao{

	public void adaugaAbonat(Abonati abonat) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(abonat);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Abonati> afiseazaAbonat() {
        List<Abonati> listaAbonati = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Query query = session.createQuery("From Abonati");
        listaAbonati = query.list();
        return listaAbonati;
    }

    public void modificaAbonat(long idabonati, String nume, String prenume, int varsta, String data_nasterii, String tara, String adresa_mail) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Abonati detaliiabonati = (Abonati) session.load(Abonati.class, idabonati);
        detaliiabonati.setNume(nume);
        detaliiabonati.setPrenume(prenume);
        detaliiabonati.setVarsta(varsta);
        detaliiabonati.setData_nasterii(data_nasterii);
        detaliiabonati.setTara(tara);
		detaliiabonati.setAdresa_mail(adresa_mail);
        session.update(detaliiabonati);
        transaction.commit();
        session.close();
    }

    public void stergeAbonat(Abonati abonat) {
    	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(abonat);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        };
    }
}
