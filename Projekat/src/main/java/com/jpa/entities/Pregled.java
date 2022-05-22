package com.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "pregled")
public class Pregled {

	@TableGenerator(name = "pregled_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1, pkColumnValue = "pregled_gen")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "pregled_gen")
	private int id;
	
	@Column(name = "idPacijenta")
	private int idPacijenta;
	
	@Column(name = "idZaposlenog")
	private int idZaposlenog;
	
	@Column(name = "idSmene")
	private int idSmene;
	
	@Column(name = "dijagnoza")
	private String dijagnoza;
	
	@Column(name = "terapija")
	private String terapija;
	
	public Pregled() {
		
	}
	
	public Pregled(int idPacijenta, int idZaposlenog, int idSmene, String dijagnoza, String terapija) {
		this.setIdPacijenta(idPacijenta);
		this.setIdZaposlenog(idZaposlenog);
		this.setIdSmene(idSmene);
		this.setDijagnoza(dijagnoza);
		this.setTerapija(terapija);
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
