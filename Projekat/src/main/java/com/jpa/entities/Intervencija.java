package com.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "intervencija")
public class Intervencija {
	
	@TableGenerator(name = "intervencija_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1, pkColumnValue = "intervencija_gen")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "intervencija_gen")
	private int id;
	
	@Column(name = "lekarId")
	private int lekarId;
	
	@Column(name = "pacijentId")
	private int pacijentId;
	
	@Column(name = "vremePutovanja")
	private int vremePutovanja;
	
	public Intervencija() {
		
	}
	
	public Intervencija(int lekarId, int pacijentId, int vremePutovanja) {
		this.setLekarId(lekarId);
		this.setPacijentId(pacijentId);
		this.setVremePutovanja(vremePutovanja);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLekarId() {
		return lekarId;
	}

	public void setLekarId(int lekarId) {
		this.lekarId = lekarId;
	}

	public int getPacijentId() {
		return pacijentId;
	}

	public void setPacijentId(int pacijentId) {
		this.pacijentId = pacijentId;
	}

	public int getVremePutovanja() {
		return vremePutovanja;
	}

	public void setVremePutovanja(int vremePutovanja) {
		this.vremePutovanja = vremePutovanja;
	}
	
	
}
