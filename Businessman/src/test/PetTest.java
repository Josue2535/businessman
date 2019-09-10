package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import model.Pet;
class PetTest {
	Pet p1;
	Pet p2;

	public void setupStage() {
		Date d = new Date(2012-06-2);
		Date d1 = new Date(2016-06-5);
		 p1 = new Pet("111", "pepa", d, "FEMALE", "dog" );
		 p2 = new Pet("112", "k", d1, "MALE", "cat");
	}
	public void setupStage1() {
		Date d = new Date(2016-06-16);
		Date d1 = new Date(2019-06-16);
		 p1 = new Pet("111", "kevin", d, "MALE", "dog" );
		 p2 = new Pet("112", "KEVIN", d1, "male", "cat");
	}
	@Test
	void testComparePetById() {
		setupStage();
		assertTrue(p1.compareTo(p2)== -1);
	}
	@Test
	void testComparePetByName() {
		setupStage();
		assertTrue(p1.comparePetName(p2) == 1);
	}
	@Test
	void testComparePetByName1() {
		setupStage1();
		assertTrue(p2.comparePetName(p1) == 0);
	}
	@Test
	void testComaperPetByDate() {
		setupStage();
		assertTrue(p1.comparePetBirth(p2) == -1);
	}
	@Test
	void testComparePetByGender() {
		setupStage1();
		assertTrue(p1.compare(p1,p2) == 0);
	}
	@Test
	void testComparePetByType() {
		setupStage1();
		assertTrue(p1.comparePetType(p1, p2) == 1);
	}
	
}
