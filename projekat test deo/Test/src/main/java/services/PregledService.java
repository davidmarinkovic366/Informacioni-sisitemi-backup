package services;

import entities.*;
import java.util.List;

public interface PregledService {
	public void dodajPregled(Pregled p);
	public void dodajPregled(int idPacijenta, int idZaposenog, int idSmene, String dijagnoza, String terapija);
	public Pregled vratiPregled(int id);
	public void obrisiPregled(int id);
	public String vratiIstorijuPregleda(int id);
	public List<Pregled> vratiPregledePacijenta(int id);
	public List<Pregled> vratiPregledeZaposlenog(int id);
}
