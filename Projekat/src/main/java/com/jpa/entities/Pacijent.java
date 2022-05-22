package com.jpa.entities;

import javax.persistence.*;

@Entity
@Table(name = "pacijent")
public class Pacijent {
	
	@TableGenerator(name = "pacijent_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1, pkColumnValue = "pacijent_gen")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "pacijent_gen")
	private int id;
	
	@Column(name = "ime")
	private String ime;
	
	@Column(name = "prezime")
	private String prezime;
	
	@Column(name = "adresa")
	private String adresa;
	
	public Pacijent() {
		
	}
	
	public Pacijent(String ime, String prezime, String adresa) {
		this.setIme(ime);
		this.setPrezime(prezime);
		this.setAdresa(adresa);
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
