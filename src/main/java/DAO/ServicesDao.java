    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import pojo.Services;

/**
 *
 * @author vali
 */
public interface ServicesDao {
    public void adaugaServices (Services services);
    public List<Services> afiseazaServices();
    public void modificaServices (long idservices, String nume_serv, float taxa_serv);
    public void stergeServices (Services services);
}

    
