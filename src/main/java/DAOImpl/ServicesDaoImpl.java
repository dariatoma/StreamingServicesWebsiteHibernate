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
import pojo.Services;
import DAO.ServicesDao;

/**
 *
 * @author vali
 */
public class ServicesDaoImpl implements ServicesDao{

    public void adaugaServices(Services services) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(services);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Services> afiseazaServices() {
        List<Services> listaServices = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Query query = session.createQuery("From Services");
        listaServices = query.list();
        return listaServices;
    }

    public void modificaServices(long idservices, String nume_serv, float taxa_serv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Services detaliiservices = (Services) session.load(Services.class, idservices);
        detaliiservices.setNume_serv(nume_serv);
        detaliiservices.setTaxa_serv(taxa_serv);
        session.update(detaliiservices);
        transaction.commit();
        session.close();
    }

    public void stergeServices(Services services) {
    	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(services);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
