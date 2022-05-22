package com.ejb.services.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import java.util.List;

import com.jpa.entities.*;
import com.ejb.services.PacijentService;

@Stateless
public class PacijentServiceImpl implements PacijentService {
	@PersistenceContext(name = "Projekat")
	private EntityManager em;

	//Dodajemo vec kreiranog pacijenta u bazu podataka:
	public void dodajPacijenta(Pacijent p) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}

	public void dodajPacijenta(String ime, String prezime, String adresa) {
		// TODO Auto-generated method stub
		try {
			Pacijent p = new Pacijent(ime, prezime, adresa);
//			em.getTransaction().begin();
			em.persist(p);
//			em.getTransaction().commit();			
		} catch(Exception ex) {
			System.out.println("Greska prilikom rada sa bazom podataka!");
		}
	}

	public Pacijent vratiPacijenta(int id) {
		try {
			Pacijent p = em.find(Pacijent.class, id);
			return p;			
		} catch(Exception ex) {
			System.out.println("Greska prilikom rada sa bazom podataka!");
			return null;
		}
	}

	public String vratiDijagnoze(int id) {
		// TODO Auto-generated method stub
		try {
			String pocetak = "";
			List<Pregled> pregledi = em.createQuery("SELECT p FROM Pregled p WHERE p.idPacijenta = " + id, Pregled.class).getResultList();
			for(Pregled p: pregledi) {
				pocetak += p.getDijagnoza() + " | ";
			}
			
			return pocetak;			
		} catch(Exception ex) {
			System.out.println("Greska prilikom rada sa bazom podataka!");
			return "";
		}
	}

	public void obrisiPacijenta(int id) {
		// TODO Auto-generated method stub
		try {			
			Pacijent p = em.find(Pacijent.class, id);
//			em.getTransaction().begin();
			em.remove(p);
//			em.getTransaction().commit();
		} catch(Exception ex) {
			System.out.println("Greska prilikom rada sa bazom podataka!");
		}
	}
}