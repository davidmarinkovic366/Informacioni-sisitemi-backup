package com.ejb.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import com.jpa.entities.Osoblje;
import com.jpa.entities.Pacijent;
import com.jpa.entities.Pregled;

import com.ejb.services.PregledService;

@Stateless
public class PregledServiceImpl implements PregledService {
	@PersistenceContext(name = "Projekat")
	private EntityManager em;


	public void dodajPregled(Pregled p) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}

	public void dodajPregled(int idPacijenta, int idZaposlenog, int idSmene, String dijagnoza, String terapija) {
		// TODO Auto-generated method stub
			Osoblje o = em.find(Osoblje.class, idZaposlenog);
			Pacijent pa = em.find(Pacijent.class, idPacijenta);
			if(o == null || pa == null || o.getPozicija() != "doktor")	//Proveravamo da li je osoblje koje izvrsava pregled doktor:
			{
				System.out.println("Ne postoji osoblje sa ovim id-jem ili osoba nije lekar!");
			}
			else {				
				Pregled p = new Pregled(idPacijenta, idZaposlenog, idSmene, dijagnoza, terapija);
				em.getTransaction().begin();
				em.persist(p);
				em.getTransaction().commit();
			}
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
		List<Pregled> pregledi = em.createQuery("SELECT p FROM Pregled p WHERE p.idPacijenta = " + id, Pregled.class).getResultList();
		String res = "";
		for(Pregled p: pregledi) {
			res += p.getDijagnoza() + " | ";
		}
		return res;
	}

	public List<Pregled> vratiPregledePacijenta(int id) {
		// TODO Auto-generated method stub
		List<Pregled> pregledi = em.createQuery("SELECT p FROM Pregled p WHERE p.idPacijenta = " + id, Pregled.class).getResultList();
		return pregledi;
	}

	public List<Pregled> vratiPregledeZaposlenog(int id) {
		// TODO Auto-generated method stub
		List<Pregled> pregledi = em.createQuery("SELECT p FROM Pregled p WHERE p.idZaposlenog = " + id, Pregled.class).getResultList();
		return pregledi;
	}
}