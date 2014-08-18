package hr.web.aplikacije.domain;

import java.io.Serializable;

public class Kolegij implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7420820532969121713L;
	public static final int VRSTA_KOLEGIJA_OBVEZNI_ID = 1;
	public static final int VRSTA_KOLEGIJA_IZBORNI_ID = 2;
	private int id;
	private String nazivKolegija;
	private VrstaKolegija vrstaKolegija;
	private int ects;
	private boolean odabran;
	
	
	public Kolegij(){
		
	}
	
	
	public Kolegij(int id, String nazivKolegija, VrstaKolegija vrstaKolegija, int ects) {
		this.id = id;
		this.nazivKolegija = nazivKolegija;
		this.vrstaKolegija = vrstaKolegija;
		this.ects = ects;
	}
	public VrstaKolegija getVrstaKolegija() {
		return vrstaKolegija;
	}


	public void setVrstaKolegija(VrstaKolegija vrstaKolegija) {
		this.vrstaKolegija = vrstaKolegija;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNazivKolegija() {
		return nazivKolegija;
	}
	public void setNazivKolegija(String nazivKolegija) {
		this.nazivKolegija = nazivKolegija;
	}
	public int getEcts() {
		return ects;
	}
	public void setEcts(int ects) {
		this.ects = ects;
	}
	public boolean isOdabran() {
		return odabran;
	}
	public void setOdabran(boolean odabran) {
		this.odabran = odabran;
	}
	
	
	

}
