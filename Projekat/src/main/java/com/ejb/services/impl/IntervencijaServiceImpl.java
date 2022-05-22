package com.ejb.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import com.jpa.entities.*;

import com.jpa.entities.Intervencija;
import com.jpa.entities.Osoblje;
import com.jpa.entities.Pacijent;

import com.ejb.services.IntervencijaService;

@Stateless
public class IntervencijaServiceImpl implements IntervencijaService {

	@PersistenceContext(name = "Projekat")
	private EntityManager em;
	
	//Dodajemo u bazu vec postojecu intervenciju:
	public void dodajIntervenciju(Intervencija i) {
		try {
//			em.getTransaction().begin();
			em.persist(i);
//			em.getTransaction().commit();
			
		} catch(Exception ex) {
			System.out.println("Greska prilikom rada sa bazom podataka!");
		}
	}

	//Kreiramo intervenciju na osnovu prosledjenih parametara i cuvamo je u bazu podataka:
	public void dodajIntervenciju(int lekarId, int pacijentId, int vremePutovanja) {
		// TODO Auto-generated method stub
		try {
			Osoblje o = em.find(Osoblje.class, lekarId);
			Pacijent p = em.find(Pacijent.class, pacijentId);
			
			if(o == null || p == null) {
				System.out.println("Osoblje ili pacijent ne postoje u bazi podataka!");
			} else {
				if(vremePutovanja <= 0) {
					System.out.println("Vreme putovanja ne moze da bude manje od 1min!");
				}
				else {
					Intervencija i = new Intervencija(lekarId, pacijentId, vremePutovanja);
//					em.getTransaction().begin();
					em.persist(i);
//					em.getTransaction().commit();
				}
			}
		} catch(Exception ex) {
			System.out.println("Greska prilikom rada sa bazom podataka!");
		}
		
	}

	
	//Brisemo slucajno kreiranu intervenciju na osnovu prosledjenog id-ja:
	public void obrisiIntervenciju(int id) {
		// TODO Auto-generated method stub
		try {
			Intervencija i = em.find(Intervencija.class, id);
//			em.getTransaction().begin();
			em.remove(i);
//			em.getTransaction().commit();
		} catch(Exception ex) {
			System.out.println("Greska prilikom rada sa bazom podataka!");
		}
	}

	//Vracamo intervenciju na osnovu zadatog id-ja:
	public Intervencija vratiIntervenciju(int id) {
		// TODO Auto-generated method stub
		try {			
			Intervencija i = em.find(Intervencija.class, id);
			return i;
		} catch(Exception ex) {
			System.out.println("Greska prilikom rada sa bazom podataka!");
			return null;
		}
	}

	//Vracamo sve intervencije na kojima je ucestvovao ovaj lekar:
	public List<Intervencija> vratiIntervencijeZaposlenog(int lekarId) {
		// TODO Auto-generated method stub
		try {
			List<Intervencija> intervencije = em.createQuery("SELECT i FROM Intervencija i WHERE i.lekarId = " + lekarId, Intervencija.class).getResultList();
			return intervencije;			
		} catch(Exception ex) {
			System.out.println("Greska prilikom rada sa bazom podataka!");
			return null;
		}
	}

	public List<Intervencija> vratiIntervencijePacijenta(int pacijentId) {
		// TODO Auto-generated method stub
		try {
			List<Intervencija> intervencije = em.createQuery("SELECT i FROM Intervencija i WHERE i.pacijentId = " + pacijentId, Intervencija.class).getResultList();
			return intervencije;
		} catch(Exception ex) {
			System.out.println("Greska prilikom rada sa bazom podataka!");
			return null;
		}
	}
	
}