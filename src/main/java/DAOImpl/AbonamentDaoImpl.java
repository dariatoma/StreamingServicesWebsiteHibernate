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
import pojo.Abonament;
import DAO.AbonamentDao;
import java.util.Date;
import pojo.Abonati;
import pojo.Services;

/**
 *
 * @author vali
 */
public class AbonamentDaoImpl implements AbonamentDao{

    public void adaugaAbonament(Abonament abonament) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(abonament);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Abonament> afiseazaAbonament() {
        List<Abonament> listaAbonament = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Query query = session.createQuery("From Abonament");
        listaAbonament = query.list();
        return listaAbonament;
    }

    public void modificaAbonament(long idabonament, Abonati abonat, Services services, String tip_abonament, String data_inceput, String data_expirare, float taxa) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Abonament detaliiabonament;
        detaliiabonament = (Abonament) session.load(Abonament.class, idabonament);
        detaliiabonament.setAbonati(abonat);
        detaliiabonament.setServices(services);
        detaliiabonament.setTip_abonament(tip_abonament);
        detaliiabonament.setData_inceput(data_inceput);
        detaliiabonament.setData_expirare(data_expirare);
        detaliiabonament.setTaxa(taxa);
        session.update(detaliiabonament);
        transaction.commit();
        session.close();
    }

    public void stergeAbonament(Abonament abonament) {
    	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(abonament);
            transaction.commit();
        } 
    	catch (Exception e) {
            e.printStackTrace();
        }
    }
}
