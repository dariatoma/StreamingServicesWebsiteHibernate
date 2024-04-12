package pojo;



import java.util.Date;

public class Abonament  implements java.io.Serializable {

	private long idabonament;	
	private Abonati abonati;
	private Services services;
	private String tip_abonament;
	private String data_inceput;
	private String data_expirare;
	private float taxa;

	public Abonament() {
	}

	public Abonament(Abonati abonati, Services services, String tip_abonament, String data_inceput, String data_expirare, float taxa) {
		this.abonati = abonati;
		this.services = services;
		this.tip_abonament = tip_abonament;
		this.data_inceput = data_inceput;
		this.data_expirare = data_expirare;
		this.taxa = taxa;
	}

	public long getIdabonament() {
		return this.idabonament;
	}

	public void setIdabonament(long idabonament) {
		this.idabonament = idabonament;
	}
	public Abonati getAbonati() {
		return this.abonati;
	}

	public void setAbonati(Abonati abonati) {
		this.abonati = abonati;
	}
	public Services getServices() {
		return this.services;
	}

	public void setServices(Services services) {
		this.services = services;
	}
	
	public String getTip_abonament() {
		return this.tip_abonament;
	}

	public void setTip_abonament(String tip_abonament) {
		this.tip_abonament = tip_abonament;
	}
	
	public String getData_inceput() {
		return this.data_inceput;
	}

	public void setData_inceput(String data_inceput) {
		this.data_inceput = data_inceput;
	}
	
	public String getData_expirare() {
		return this.data_expirare;
	}
	
	public void setData_expirare(String data_expirare) {
		this.data_expirare = data_expirare;
	}
	
	public float getTaxa() {
		return this.taxa;
	}

	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}
	
}




