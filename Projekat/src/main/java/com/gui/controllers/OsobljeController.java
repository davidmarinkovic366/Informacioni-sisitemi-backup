package com.gui.controllers;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;

import com.ejb.services.OsobljeService;
import com.jpa.entities.Osoblje;

@ManagedBean
public class OsobljeController {
	private int id;
	private String ime;
	private String prezime;
	private String pozicija;
	
	@EJB
	private OsobljeService service;
	
	//Kreiramo osobu:
	public void dodajOsoblje(String ime, String prezime, String pozicija) {
		service.kreirajOsoblje(ime, prezime, pozicija);
	}
	
	//Brisemo osoblje:
	public void obrisiOsoblje(int idOsoblja) {
		service.obrisiOsoblje(idOsoblja);
	}
	
	//Vrati objekat osoblja:
	public Osoblje vratiOsoblje(int idOsoblja) {
		return service.vratiOsobu(idOsoblja);
	}
	
	//Vrati listu svog osoblja iz baze podataka:
	public List<Osoblje> vratiOsoblje() {
		return service.svoOsoblje();
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

	public String getPozicija() {
		return pozicija;
	}

	public void setPozicija(String pozicija) {
		this.pozicija = pozicija;
	}

	public OsobljeService getService() {
		return service;
	}

	public void setService(OsobljeService service) {
		this.service = service;
	}
	
}
