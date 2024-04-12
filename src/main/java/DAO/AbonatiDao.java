    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import pojo.Abonati;

/**
 *
 * @author vali
 */
public interface AbonatiDao{
    public void adaugaAbonat(Abonati abonat);
    public List<Abonati> afiseazaAbonat();
    public void modificaAbonat(long idabonati, String nume, String prenume, int varsta, String data_nasterii, String tara, String adresa_mail);
    public void stergeAbonat(Abonati abonat);
}

    
