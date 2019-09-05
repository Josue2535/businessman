
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Client implements Serializable {
	
	private String id;
	private String name;
	private String lastName;
	private GregorianCalendar birthDate;
	private ArrayList<Pet> pets;
	private String favTypePet;
	
	
	
	
	
	public Client(String id, String name, String lastName, GregorianCalendar birthDate, String favTypePet) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.favTypePet = favTypePet;
		pets = new ArrayList<Pet>();
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public GregorianCalendar getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(GregorianCalendar birthDate) {
		this.birthDate = birthDate;
	}


	public ArrayList<Pet> getPets() {
		return pets;
	}


	public void setPets(ArrayList<Pet> pets) {
		this.pets = pets;
	}


	public String getFavTypePet() {
		return favTypePet;
	}


	public void setFavTypePet(String favTypePet) {
		this.favTypePet = favTypePet;
	}
	
	public void addPet(Pet pet) {
		pets.add(pet);
	}
	
	
	

} //end of class
