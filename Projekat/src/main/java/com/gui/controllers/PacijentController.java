package com.gui.controllers;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;

import com.ejb.services.PacijentService;
import com.jpa.entities.Pacijent;

@ManagedBean
public class PacijentController {

	@EJB
	private PacijentService service;
	
	private int id;
	private String ime;
	private String prezime;
	private String adresa;
	
	//Kreiramo novog pacijenta:
	public void kreirajPacijenta(String ime, String prezime, String adresa) {
		service.dodajPacijenta(ime, prezime, adresa);
	}
	
	//Vracamo objekat Pacijenta:
	public Pacijent vratiPacijenta(int idPacijenta) {
		return service.vratiPacijenta(idPacijenta);
	}
	
	//Brisemo pacijenta:
	public void obrisiPacijenta(int idPacijenta) {
		service.obrisiPacijenta(idPacijenta);
	}
	
	//Vracamo sve postavljene dijagnoze pacijenta iz baze podataka:
	public String vratiDijagnoze(int idPacijenta) {
		return service.vratiDijagnoze(idPacijenta);
	}

	public PacijentService getService() {
		return service;
	}

	public void setService(PacijentService service) {
		this.service = service;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	
}
