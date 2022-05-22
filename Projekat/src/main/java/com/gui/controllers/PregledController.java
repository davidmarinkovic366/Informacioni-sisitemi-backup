package com.gui.controllers;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;

import com.ejb.services.PregledService;
import com.jpa.entities.Pregled;

@ManagedBean
public class PregledController {
	
	@EJB
	private PregledService service;
	
	private int id;
	private int idPacijenta;
	private int idZaposlenog;
	private int idSmene;
	private String dijagnoza;
	private String terapija;
	
	//Kreiramo novi pregled:
	public void dodajPregled(int idPacijenta, int idZaposlenog, int idSmene, String dijagnoza, String terapija) {
		service.dodajPregled(idPacijenta, idZaposlenog, idSmene, dijagnoza, terapija);
	}
	
	//Vracamo pregled:
	public Pregled vratiPregled(int idPregleda) {
		return service.vratiPregled(idPregleda);
	}
	
	//Brisemo pregled:
	public void obrisiPregled(int idPregleda) {
		service.obrisiPregled(idPregleda);
	}
	
	//Vracamo istoriju pregleda jednog pacijenta(String):
	public String istorijaPregleda(int idPacijenta) {
		return service.vratiIstorijuPregleda(idPacijenta);
	}
	
	//Vracamo preglede pacijenta:
	public List<Pregled> vratiPregledePacijenta(int idPacijenta) {
		return service.vratiPregledePacijenta(idPacijenta);
	}
	
	//Vracamo sve preglede koje je izvrsio neki zaposleni:
	public List<Pregled> vratiPregledeOsoblja(int idZaposlenog) {
		return service.vratiPregledeZaposlenog(idZaposlenog);
	}

	public PregledService getService() {
		return service;
	}

	public void setService(PregledService service) {
		this.service = service;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPacijenta() {
		return idPacijenta;
	}

	public void setIdPacijenta(int idPacijenta) {
		this.idPacijenta = idPacijenta;
	}

	public int getIdZaposlenog() {
		return idZaposlenog;
	}

	public void setIdZaposlenog(int idZaposlenog) {
		this.idZaposlenog = idZaposlenog;
	}

	public int getIdSmene() {
		return idSmene;
	}

	public void setIdSmene(int idSmene) {
		this.idSmene = idSmene;
	}

	public String getDijagnoza() {
		return dijagnoza;
	}

	public void setDijagnoza(String dijagnoza) {
		this.dijagnoza = dijagnoza;
	}

	public String getTerapija() {
		return terapija;
	}

	public void setTerapija(String terapija) {
		this.terapija = terapija;
	}
	
	
}
