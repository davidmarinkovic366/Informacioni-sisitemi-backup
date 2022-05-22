package servicesimpl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import entities.*;
import services.SmenaService;

@Stateless
public class SmenaServiceImpl implements SmenaService {
	
	@PersistenceContext(name = "PrimerTest")
	private EntityManager em;
	
	public SmenaServiceImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HitnaPU");
		this.em = emf.createEntityManager();
	}
	
	
	//Metoda za dodavanje vec implementirane smene:
	public void dodajSmenu(Smena s) {
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
	}

	//Metoda za cuvanje i kreiranje objekta tipa smena na osnovu prosledjenih parametara:
	public void dodajSmenu(int osobljeId, String pocetak, String kraj) {
		// TODO Auto-generated method stub
		Smena s = new Smena(osobljeId, pocetak, kraj);
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
	}

	//Vracamo sve smene ove osobe na osnovu id-ja korisnika:
	public List<Smena> vratiSmeneOsoblja(int korisnikId) {
		List<Smena> smene = em.createQuery("SELECT s FROM Smena s WHERE s.osobljeId == " + korisnikId, Smena.class).getResultList();
		return smene;
	}

	//Vracamo sve smene koje su pocele ovog trenutka:
	public List<Smena> vratiSmenePocete(String pocetak) {
		List<Smena> smene = em.createQuery("SELECT s FROM Smena s WHERE s.pocetak == " + pocetak, Smena.class).getResultList();
		return smene;
	}
	
}
