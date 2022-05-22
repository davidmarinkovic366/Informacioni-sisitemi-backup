package servicesimpl;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import entities.Osoblje;
import services.OsobljeService;

@Stateless
public class OsobljeServiceImpl implements OsobljeService {
	
	@PersistenceContext(name = "PrimerTest")
	private EntityManager em;

	//Kreiramo EntityManager:
	public OsobljeServiceImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HitnaPU");
		this.em = emf.createEntityManager();
	}
	
	//Cuvamo vec kreiranu osobu:
	public void dodajOsoblje(Osoblje o) {
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}

	//Kreiramo na osnovu prosledjenih parametara:
	public void kreirajOsoblje(String ime, String prezime, String pozicija) {
		Osoblje o = new Osoblje(ime, prezime, pozicija);
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}

	//Brisemo na osnovu id-ja:
	public void obrisiOsoblje(int id) {
		Osoblje o = em.find(Osoblje.class, id);
		em.getTransaction().begin();
		em.remove(o);
		em.getTransaction().commit();
	}

	//Vracamo listu objekta tipa osoblje:
	public List<Osoblje> svoOsoblje() {
		List<Osoblje> osoblje = em.createQuery("SELECT o FROM Osoblje o", Osoblje.class).getResultList();
		return osoblje;
	}
	

}
