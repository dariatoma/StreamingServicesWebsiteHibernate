package pojo;


import java.util.HashSet;
import java.util.Set;

public class Services  implements java.io.Serializable {

	private long idservices;
	private String nume_serv;
	private float taxa_serv;
	private Set abonament = new HashSet(0);

	public Services() {
	}

	public Services(long idservices, String nume_serv, float taxa_serv, Set abonament) {
		this.idservices = idservices;
		this.nume_serv = nume_serv;
		this.taxa_serv = taxa_serv;
		this.abonament = abonament;
	}

	public long getIdservices() {
		return this.idservices;
	}

	public void setIdservices(long idservices) {
		this.idservices = idservices;
	}
	public String getNume_serv() {
		return this.nume_serv;
	}

	public void setNume_serv(String nume_serv) {
		this.nume_serv = nume_serv;
	}
	public float getTaxa_serv() {
		return this.taxa_serv;
	}

	public void setTaxa_serv(float taxa_serv) {
		this.taxa_serv = taxa_serv;
	}
	
	public Set getAbonament() {
		return this.abonament;
	}

	public void setAbonament(Set abonament) {
		this.abonament = abonament;
	}
}
