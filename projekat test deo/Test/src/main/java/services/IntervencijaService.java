package services;

import java.util.List;

import entities.*;

public interface IntervencijaService  {
	public void dodajIntervenciju(Intervencija i);
	public void dodajIntervenciju(int lekarId, int pacijentId, int vremePutovanja);
	public void obrisiIntervenciju(int id);
	public Intervencija vratiIntervenciju(int id);
	public List<Intervencija> vratiIntervencijeZaposlenog(int lekarId);
	public List<Intervencija> vratiIntervencijePacijenta(int pacijentId);
}
