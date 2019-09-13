package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import model.*;

class BusinessmanTest {
	Businessman bu;
	Client c1;
	Client c2;
	Client c3;
	Club club1;
	Club club2;

	public void setupStage() {
		Date d1 = new Date(2016 - 06 - 5);
		Date d2 = new Date(2018 - 06 - 5);
		Date cd2 = new Date(2001 - 06 - 5);
		c1 = new Client("1005969243", "josue", "rodriguez", cd2, "cat");
		c2 = new Client("1029374933", "borrero", "felipe", d1, "dog");
		c3 = new Client("1029382819", "marco", "Polo", d2, "bird");
		bu = new Businessman("josue");
		try {
			club1 = new Club("192", "Felipe", d2, "caballo");
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
		try {
			club2 = new Club("192832312", "arroz", d1, "Lion");
		} catch (NumberFormatException | ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		club1.addClient(c1);
		club1.addClient(c2);
		club2.addClient(c3);
		bu.addClub(club1);
		bu.addClub(club2);
	}

	public void setupStage1() {
		bu = new Businessman("josue");
		Date d3 = new Date(2003 - 06 - 7);
		try {
			club1 = new Club("192", "Felipe", d3, "caballo");
		} catch (NumberFormatException | ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			club2 = new Club("192832312", "arroz", d3, "Lion");
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
		bu.addClub(club1);
		bu.addClub(club2);
	}

	@Test
	void ordeningClubByIdtest() {
		setupStage1();
		bu.ordeningClubById();
		ArrayList<Club> ordening = new ArrayList<Club>();
		ordening.add(club1);
		ordening.add(club2);
		assertTrue(ordening.equals(bu.getClubs()));
	}
	@Test
	void ordeningClubByNameTest() {
		setupStage();
		bu.ordeningClubByName();
		ArrayList<Club> ordening = new ArrayList<Club>();
		ordening.add(club2);
		ordening.add(club1);
		assertTrue(ordening.equals(bu.getClubs()));
	}
	@Test
	void ordeningClubByClients() {
		setupStage();
		bu.ordeningClubByClients();
		ArrayList<Club> ordening = new ArrayList<Club>();
		ordening.add(club2);
		ordening.add(club1);
		assertTrue(ordening.equals(bu.getClubs()));
	}

}
