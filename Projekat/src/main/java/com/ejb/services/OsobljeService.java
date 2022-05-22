package com.ejb.services;

import java.util.List;
import com.jpa.entities.Osoblje;

public interface OsobljeService {
	public void dodajOsoblje(Osoblje o);
	public void kreirajOsoblje(String ime, String prezime, String pozicija);
	public void obrisiOsoblje(int id);
	public Osoblje vratiOsobu(int id);
	public List<Osoblje> svoOsoblje();
}
