package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import model.*;
class ClientTest {
	Pet p1;
	Pet p2;
	Pet p3;
	Client c1;
	Client c2;
	
	public void setupStage() {
		Date d = new Date(2012-06-2);
		Date d1 = new Date(2016-06-5);
		Date d2 = new Date(2018-06-5);
		Date cd2 = new Date(2001-06-5);
		 p1 = new Pet("111", "pepa", d, "FEMALE", "dog" );
		 p2 = new Pet("112", "k", d1, "MALE", "cat");
		 p3 = new Pet("1144", "kaka", d2, "MALE", "bird");
		 c1 = new Client("1005969243", "josue", "rodriguez", cd2, "cat");
		 c1.addPet(p1);
		 c1.addPet(p2);
		 c1.addPet(p3);
	}
	public void setupStage1() {
		Date d = new Date(2012-06-2);
		Date d1 = new Date(2016-06-5);
		Date d2 = new Date(2018-06-5);
		Date cd = new Date(2001-06-5);
		 p1 = new Pet("111", "panda", d, "FEMALE", "dog" );
		 p2 = new Pet("112", "k", d1, "MALE", "cat");
		 p3 = new Pet("1144", "kaka", d2, "MALE", "bird");
		 c2 = new Client("10235958", "Triste", "perez", cd, "bird");
		 c2.addPet(p1);
		 c2.addPet(p2);
		 c2.addPet(p3);
	}
	@Test
	void ordenaringIdPetTest() {
		setupStage();
		c1.ordenationId();
		ArrayList<Pet> ordening = new ArrayList<>();
		ordening.add(p1);
		ordening.add(p2);
		ordening.add(p3);
		assertTrue(ordening.equals(c1.getPets()));
		
	}
	@Test
	void ordenaringNamePetTest() {
		setupStage();
		c1.ordenationName();
		ArrayList<Pet> ordening = new ArrayList<>();
		ordening.add(p2);
		ordening.add(p3);
		ordening.add(p1);
		assertTrue(ordening.equals(c1.getPets()));
		
	}
	@Test
	void ordenaringDatePetTest() {
		setupStage();
		c1.ordenationDate();
		ArrayList<Pet> ordening = new ArrayList<>();
		ordening.add(p1);
		ordening.add(p2);
		ordening.add(p3);
		assertTrue(ordening.equals(c1.getPets()));
		
	}
	@Test
	void ordenaringGenderPetTest() {
		setupStage1();
		c2.ordenationGender();
		ArrayList<Pet> ordening = new ArrayList<>();
		ordening.add(p1);
		ordening.add(p2);
		ordening.add(p3);
		assertTrue(ordening.equals(c2.getPets()));
		
	}
	@Test
	void ordenaringTypePetTest() {
		setupStage();
		c1.ordenationType();
		ArrayList<Pet> ordening = new ArrayList<>();
		ordening.add(p3);
		ordening.add(p2);
		ordening.add(p1);
		assertTrue(ordening.equals(c1.getPets()));
		
	}

}
