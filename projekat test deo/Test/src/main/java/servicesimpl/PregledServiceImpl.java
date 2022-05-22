package servicesimpl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import entities.*;
import services.PregledService;

@Stateless
public class PregledServiceImpl implements PregledService {
	@PersistenceContext(name = "PrimerTest")
	private EntityManager em;

	//Kreiramo EntityManager:
	public PregledServiceImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HitnaPU");
		this.em = emf.createEntityManager();
	}

	public void dodajPregled(Pregled p) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}

	public void dodajPregled(int idPacijenta, int idZaposlenog, int idSmene, String dijagnoza, String terapija) {
		// TODO Auto-generated method stub
		Pregled p = new Pregled(idPacijenta, idZaposlenog, idSmene, dijagnoza, terapija);
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}

	public Pregled vratiPregled(int id) {
		// TODO Auto-generated method stub
		Pregled p = em.find(Pregled.class, id);
		return p;
	}

	public void obrisiPregled(int id) {
		// TODO Auto-generated method stub
		Pregled p = em.find(Pregled.class, id);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
	}

	public String vratiIstorijuPregleda(int id) {
		// TODO Auto-generated method stub
		List<Pregled> pregledi = em.createQuery("SELECT p FROM Pregled p WHERE p.idPacijenta == " + id, Pregled.class).getResultList();
		String res = "";
		for(Pregled p: pregledi) {
			res += p.getDijagnoza() + " | ";
		}
		return res;
	}

	public List<Pregled> vratiPregledePacijenta(int id) {
		// TODO Auto-generated method stub
		List<Pregled> pregledi = em.createQuery("SELECT p FROM Pregled p WHERE p.idPacijenta == " + id, Pregled.class).getResultList();
		return pregledi;
	}

	public List<Pregled> vratiPregledeZaposlenog(int id) {
		// TODO Auto-generated method stub
		List<Pregled> pregledi = em.createQuery("SELECT p FROM Pregled p WHERE p.idZaposlenog == " + id, Pregled.class).getResultList();
		return pregledi;
	}
	
	
}
