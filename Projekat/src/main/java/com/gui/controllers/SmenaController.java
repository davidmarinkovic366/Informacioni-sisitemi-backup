package com.gui.controllers;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;

import com.ejb.services.SmenaService;

import com.jpa.entities.Smena;
import java.util.List;

@ManagedBean
public class SmenaController {
	
	@EJB
	private SmenaService service;
	private int id;
	private int osobljeId;
	private String pocetak;
	private String kraj;
	
	
	//Kreiramo smenu:
	public void dodajSmenu(int osobljeId, String pocetak, String kraj) {
		service.dodajSmenu(osobljeId, pocetak, kraj);
	}
	
	//Vracamo listu svih smena jednog zaposlenog:
	public List<Smena> vratiSmeneZaposlenog(int osobljeId) {
		return service.vratiSmeneOsoblja(osobljeId);
	}
	
	//Vracamo sve smene koje su pocele dana i sata(22.05.2021/07:00h => 220520210700):
	public List<Smena> vratiSmeneZaDan(String pocetak) {
		return service.vratiSmenePocete(pocetak);
	}

	public SmenaService getService() {
		return service;
	}

	public void setService(SmenaService service) {
		this.service = service;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOsobljeId() {
		return osobljeId;
	}

	public void setOsobljeId(int osobljeId) {
		this.osobljeId = osobljeId;
	}

	public String getPocetak() {
		return pocetak;
	}

	public void setPocetak(String pocetak) {
		this.pocetak = pocetak;
	}

	public String getKraj() {
		return kraj;
	}

	public void setKraj(String kraj) {
		this.kraj = kraj;
	}
	
}
