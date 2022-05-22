package services;

import entities.*;

public interface PacijentService {
	public void dodajPacijenta(Pacijent p);
	public void dodajPacijenta(String ime, String prezime, String adresa);
	public Pacijent vratiPacijenta(int id);
	public void obrisiPacijenta(int id);
	public String vratiDijagnoze(int id);
}
