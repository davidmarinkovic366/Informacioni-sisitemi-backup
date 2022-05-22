package com.ejb.services;

import com.jpa.entities.Smena;
import java.util.List;

public interface SmenaService {
	public void dodajSmenu(Smena s);
	public void dodajSmenu(int osobljeId, String pocetak, String kraj);
	public List<Smena> vratiSmeneOsoblja(int korisnikId);
	public List<Smena> vratiSmenePocete(String pocetak);
}
