package com.jpa.entities;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "osoblje")
public class Osoblje {

	@TableGenerator(name = "osoblje_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1, pkColumnValue = "osoblje_gen")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "osoblje_gen")
	private int id;
	
//	@Column(name = "ime")
	private String ime;
//	@Column(name = "prezime")
	private String prezime;
//	@Column(name = "pozicija")
	private String pozicija;
	
	public Osoblje() {
		
	}
	
	public Osoblje(String ime, String prezime, String pozicija) {
		this.setIme(ime);
		this.setPrezime(prezime);
		this.setPozicija(pozicija);
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
	

}
