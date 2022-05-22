package com.gui.controllers;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;

import com.ejb.services.*;
import com.jpa.entities.Intervencija;
import java.util.List;

@ManagedBean
public class IntervencijaController {
	
	private int id = 0;
	private int idLekara = 0;
	private int idPacijenta = 0;
	private int vremePutovanja = 0;
	
	@EJB
	private IntervencijaService service;
	
	//Dodavanje nove intervencije:
	public void dodajIntervenciju(int idLekara, int idPacijenta, int vremePutovanja) {
		service.dodajIntervenciju(idLekara, idPacijenta, vremePutovanja);
	}
	
	//Brisemo intervenciju iz baze podataka:
	public void obrisiIntervenciju(int id) {
		service.obrisiIntervenciju(id);
	}
	
	//Vrati intervenciju sa datim id-jem:
	public Intervencija vratiIntervencije(int id) {
		return service.vratiIntervenciju(id);
	}
	
	public List<Intervencija> vratiIntervencijeZaposlenog(int idZaposlenog) {
		return service.vratiIntervencijeZaposlenog(idZaposlenog);
	}
	
	public List<Intervencija> vratiIntervencijePacijenta(int idPacijenta) {
		return service.vratiIntervencijePacijenta(idPacijenta);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdLekara() {
		return idLekara;
	}

	public void setIdLekara(int idLekara) {
		this.idLekara = idLekara;
	}

	public int getIdPacijenta() {
		return idPacijenta;
	}

	public void setIdPacijenta(int idPacijenta) {
		this.idPacijenta = idPacijenta;
	}

	public int getVremePutovanja() {
		return vremePutovanja;
	}

	public void setVremePutovanja(int vremePutovanja) {
		this.vremePutovanja = vremePutovanja;
	}

	public IntervencijaService getService() {
		return service;
	}

	public void setService(IntervencijaService service) {
		this.service = service;
	}
	
}
