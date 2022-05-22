package servicesimpl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import entities.*;
import services.IntervencijaService;

@Stateless
public class IntervencijaServiceImpl implements IntervencijaService {

	@PersistenceContext(name = "PrimerTest")
	private EntityManager em;
	
	public IntervencijaServiceImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HitnaPU");
		this.em = emf.createEntityManager();
	}
	
	//Dodajemo u bazu vec postojecu intervenciju:
	public void dodajIntervenciju(Intervencija i) {
		em.getTransaction().begin();
		em.persist(i);
		em.getTransaction().commit();
	}

	//Kreiramo intervenciju na osnovu prosledjenih parametara i cuvamo je u bazu podataka:
	public void dodajIntervenciju(int lekarId, int pacijentId, int vremePutovanja) {
		// TODO Auto-generated method stub
		Intervencija i = new Intervencija(lekarId, pacijentId, vremePutovanja);
		em.getTransaction().begin();
		em.persist(i);
		em.getTransaction().commit();
	}

	
	//Brisemo slucajno kreiramo intervenciju na osnovu prosledjenog id-ja:
	public void obrisiIntervenciju(int id) {
		// TODO Auto-generated method stub
		Intervencija i = em.find(Intervencija.class, id);
		em.getTransaction().begin();
		em.remove(i);
		em.getTransaction().commit();
	}

	//Vracamo intervenciju na osnovu zadatog id-ja:
	public Intervencija vratiIntervenciju(int id) {
		// TODO Auto-generated method stub
		Intervencija i = em.find(Intervencija.class, id);
		return i;
	}

	//Vracamo sve intervencije na kojima je ucestvovao ovaj lekar:
	public List<Intervencija> vratiIntervencijeZaposlenog(int lekarId) {
		// TODO Auto-generated method stub
		List<Intervencija> intervencije = em.createQuery("SELECT i FROM Intervencija i WHERE i.lekarId == " + lekarId, Intervencija.class).getResultList();
		return intervencije;
	}

	public List<Intervencija> vratiIntervencijePacijenta(int pacijentId) {
		// TODO Auto-generated method stub
		List<Intervencija> intervencije = em.createQuery("SELECT i FROM Intervencija i WHERE i.pacijentId == " + pacijentId, Intervencija.class).getResultList();
		return intervencije;
	}
	
}
