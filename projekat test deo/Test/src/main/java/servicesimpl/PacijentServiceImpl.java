package servicesimpl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import java.util.List;

import entities.*;
import services.PacijentService;

@Stateless
public class PacijentServiceImpl implements PacijentService {
	@PersistenceContext(name = "PrimerTest")
	private EntityManager em;

	//Kreiramo EntityManager:
	public PacijentServiceImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HitnaPU");
		this.em = emf.createEntityManager();
	}

	//Dodajemo vec kreiranog pacijenta u bazu podataka:
	public void dodajPacijenta(Pacijent p) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}

	public void dodajPacijenta(String ime, String prezime, String adresa) {
		// TODO Auto-generated method stub
		Pacijent p = new Pacijent(ime, prezime, adresa);
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}

	public Pacijent vratiPacijenta(int id) {
		Pacijent p = em.find(Pacijent.class, id);
		return p;
	}

	public String vratiDijagnoze(int id) {
		// TODO Auto-generated method stub
		String pocetak = "";
		List<Pregled> pregledi = em.createQuery("SELECT p FROM Pregled p WHERE p.idPacijenta == " + id, Pregled.class).getResultList();
		for(Pregled p: pregledi) {
			pocetak += p.getDijagnoza() + " | ";
		}
		
		return pocetak;
	}

	public void obrisiPacijenta(int id) {
		// TODO Auto-generated method stub
		Pacijent p = em.find(Pacijent.class, id);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
	}
}
