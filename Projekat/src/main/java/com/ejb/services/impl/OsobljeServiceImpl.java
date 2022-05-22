package com.ejb.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import com.jpa.entities.Osoblje;
import com.ejb.services.OsobljeService;

@Stateless
public class OsobljeServiceImpl implements OsobljeService {
	
	@PersistenceContext(name = "Projekat")
	private EntityManager em;
	
	//Cuvamo vec kreiranu osobu:
	public void dodajOsoblje(Osoblje o) {
		try {
//			em.getTransaction().begin();
			em.persist(o);
//			em.getTransaction().commit();			
		} catch(Exception ex) {
			System.out.println("Greska prilikom rada sa bazom podataka!");
		}
	}

	//Kreiramo na osnovu prosledjenih parametara:
	public void kreirajOsoblje(String ime, String prezime, String pozicija) {
		try {
			Osoblje o = new Osoblje(ime, prezime, pozicija);
//			em.getTransaction().begin();
			em.persist(o);
//			em.getTransaction().commit();			
		} catch(Exception ex) {
			System.out.println("Greska prilikom rada sa bazom podataka!");
		}
	}

	//Brisemo na osnovu id-ja:
	public void obrisiOsoblje(int id) {
		try {
			Osoblje o = em.find(Osoblje.class, id);
//			em.getTransaction().begin();
			em.remove(o);
//			em.getTransaction().commit();			
		} catch(Exception ex) {
			System.out.println("Greska prilikom rada sa bazom podataka!");
		}
	}

	//Vracamo listu objekta tipa osoblje:
	public List<Osoblje> svoOsoblje() {
		try {
			List<Osoblje> osoblje = em.createQuery("SELECT o FROM Osoblje o", Osoblje.class).getResultList();
			return osoblje;			
		} catch(Exception ex) {
			System.out.println("Greska prilikom rada sa bazom podataka!");
			return null;
		}
	}

	@Override
	public Osoblje vratiOsobu(int id) {
		try {
			Osoblje o = em.find(Osoblje.class, id);
			return o;			
		} catch(Exception ex) {
			System.out.println("Greska prilikom rada sa bazom podataka!");
			return null;
		}
	}
	

}
