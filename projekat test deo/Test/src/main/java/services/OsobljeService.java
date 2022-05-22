package services;
import entities.Osoblje;
import java.util.List;

public interface OsobljeService {
	public void dodajOsoblje(Osoblje o);
	public void kreirajOsoblje(String ime, String prezime, String pozicija);
	public void obrisiOsoblje(int id);
	public List<Osoblje> svoOsoblje();
}
