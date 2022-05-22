
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import entities.*;
import org.junit.*;
import services.*;
import servicesimpl.*;

public class InitialTest {

	private static PacijentServiceImpl service;
	
	@BeforeClass
	public static void BeforeClass() {
		service = new PacijentServiceImpl();
		assertNotNull(service);	//Prolazi ako ovo nije null:
		System.out.println("Test inicijalizovan.");
	}
	
	
	@Before
	public void Before() {
		Pacijent p = service.vratiPacijenta(6);
		assertNull(p);
		System.out.println("Korisnik nije nadjen u bazi podakata!");
	}
	
	
	@Test
	public void Test() {
		service.dodajPacijenta("David", "Marinkovic", "Topolska 18");
		Pacijent p  = service.vratiPacijenta(6);
		assertNotNull(p);
		System.out.println("Korinsnik je dodat.");
	}
	
	
	@After
	public void After() {
		Pacijent p = service.vratiPacijenta(6);
		service.obrisiPacijenta(p.getId());
		
		p = service.vratiPacijenta(6);
		assertNull(p);
		System.out.println("Korisnik namenjen za testiranje je uspesno obrisan iz baze!");
	}
}
