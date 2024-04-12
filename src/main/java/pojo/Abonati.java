package pojo;



import java.util.HashSet;
import java.util.Set;

public class Abonati  implements java.io.Serializable {


	private long idabonati;
	private String nume;
	private String prenume;
	private Integer varsta;
	private String data_nasterii;
	private String tara;
	private String adresa_mail;
	private Set abonament = new HashSet(0);

	public Abonati() {
	}

	public Abonati(long idabonati, String nume, String prenume, Integer varsta, String data_nasterii, String tara, String adresa_mail, Set abonament) {
		this.idabonati = idabonati;
		this.nume = nume;
		this.prenume = prenume;
		this.varsta = varsta;
		this.data_nasterii = data_nasterii;
		this.tara = tara;
		this.adresa_mail = adresa_mail; 
		this.abonament = abonament;
	}

	public long getIdabonati() {
		return this.idabonati;
	}

	public void setIdabonati(long idabonati) {
		this.idabonati = idabonati;
	}
	public String getNume() {
		return this.nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getPrenume() {
		return this.prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
	
	public Integer getVarsta() {
		return this.varsta;
	}

	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}
	
	public String getData_nasterii() {
		return this.data_nasterii;
	}

	public void setData_nasterii(String data_nasterii) {
		this.data_nasterii = data_nasterii;
	}
	
	public String getTara() {
		return this.tara;
	}

	public void setTara(String tara) {
		this.tara = tara;
	}
	
	public String getAdresa_mail() {
		return this.adresa_mail;
	}

	public void setAdresa_mail(String adresa_mail) {
		this.adresa_mail = adresa_mail;
	}
	
	public Set getAbonament() {
		return this.abonament;
	}

	public void setAbonament(Set abonament) {
		this.abonament = abonament;
	}
}




