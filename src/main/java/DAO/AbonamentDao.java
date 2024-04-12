    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import pojo.Abonament;
import java.util.Date;
import pojo.Abonati;
import pojo.Services;

/**
 *
 * @author vali
 */
public interface AbonamentDao {
    public void adaugaAbonament (Abonament abonament);
    public List<Abonament> afiseazaAbonament();
    public void modificaAbonament (long idabonament, Abonati abonat, Services services, String tip_abonament, String data_inceput, String data_expirare, float taxa);
    public void stergeAbonament (Abonament abonament);
}

    
