package com.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "smena")
public class Smena {
	
	@TableGenerator(name = "smena_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1, pkColumnValue = "smena_gen")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "smena_gen")
	private int id;
	
	@Column(name = "osobljeId")
	private int osobljeId;
	
	@Column(name = "pocetak")
	private String pocetak;
	
	@Column(name = "kraj")
	private String kraj;
	
	public Smena() {
		
	}
	
	public Smena(int osobljeId, String pocetak, String kraj) {
		this.setOsobljeId(osobljeId);
		this.setPocetak(pocetak);
		this.setKraj(kraj);
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
