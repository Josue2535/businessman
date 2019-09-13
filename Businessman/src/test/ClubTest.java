package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import model.*;
class ClubTest {
	Client c1;
	Client c2;
	Client c3;
	Club club1;
	Pet p1;
	Pet p2;
	Pet p3;
	public void setupStage() {
		Date d1 = new Date(2016-06-5);
		Date d2 = new Date(2018-06-5);
		Date cd2 = new Date(2001-06-5);
		Date d3 = new Date(2003-06-7);
		p1 = new Pet("111", "pepa", d1, "FEMALE", "dog" );
		 p2 = new Pet("112", "k", d1, "MALE", "cat");
		 p3 = new Pet("1144", "kaka", d2, "MALE", "bird");
		 c1 = new Client("1005969243", "josue", "rodriguez", cd2, "cat");
		 c2 = new Client("1029374933", "borrero", "felipe",d1, "dog" );
		 c3 = new Client("1029382819", "marco", "Polo", d2, "bird");
		 try {
			club1 = new Club("192837273", "Felipe", d3, "caballo");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 club1.addClient(c1);
		 club1.addClient(c2);
		 club1.addClient(c3);
		 c1.addPet(p1);
		 c1.addPet(p2);
		 c2.addPet(p3);
	}

	@Test
	void ordeningTestName() {
		setupStage();
		club1.ordenaringClientName();
		ArrayList<Client> ordening = new ArrayList<>();
		ordening.add(c2);
		ordening.add(c1);
		ordening.add(c3);
		assertTrue(ordening.equals(club1.getClients()));
	}
	@Test
	void ordeningTesLastName() {
		setupStage();
		club1.ordenaringClientLastName();
		ArrayList<Client> ordening = new ArrayList<>();
		ordening.add(c2);
		ordening.add(c3);
		ordening.add(c1);
		assertTrue(ordening.equals(club1.getClients()));
	}
	@Test
	void ordeningTestDate() {
		setupStage();
		club1.ordenaringClientBirthDate();
		ArrayList<Client> ordening = new ArrayList<>();
		ordening.add(c1);
		ordening.add(c2);
		ordening.add(c3);
		assertTrue(ordening.equals(club1.getClients()));
	}
	@Test
	void ordeningTestId() {
		setupStage();
		club1.ordenaringClientId();
		
		ArrayList<Client> ordening = new ArrayList<>();
		ordening.add(c1);
		ordening.add(c2);
		ordening.add(c3);
		assertTrue(ordening.equals(club1.getClients()));
		
	}

	@Test
	void ordeningTestNuPets() {
		setupStage();
		club1.ordenaringClientNuPets();
		ArrayList<Client> ordening = new ArrayList<>();
		ordening.add(c3);
		ordening.add(c2);
		ordening.add(c1);
		assertTrue(ordening.equals(club1.getClients()));
	}
	@Test
	void ordeningTestClientsFavTypePet() {
		setupStage();
		club1.ordearingClientsFavTypePet();
		ArrayList<Client> ordening = new ArrayList<>();
		ordening.add(c3);
		ordening.add(c1);
		ordening.add(c2);
		assertTrue(ordening.equals(club1.getClients()));
	}
	
}
