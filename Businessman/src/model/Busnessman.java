
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Busnessman {

	private String name;
	private ArrayList<Club> clubs;
	private Client C;

	public Busnessman(String name) {
		this.name = name;
		clubs = new ArrayList<Club>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Club> getClubs() {
		return clubs;
	}

	public void setClubs(ArrayList<Club> clubs) {
		this.clubs = clubs;
	}

	public void addClub(Club club) {
		clubs.add(club);
	}

	// -------------------------------- metodos
	public boolean delateAPet(int c, int p, String id, String idPET) {
		boolean de = false;
		Client f= null;
		
		if(c == 1) {
			
		}
		return de;
	}

	public void delateAClient() {
		// TODO Auto-generated method stub

	}

	public void delateAClub() {
		// TODO Auto-generated method stub

	}

	public void addPet() {
		// TODO Auto-generated method stub

	}

	public void registerANewClient() {
		// TODO Auto-generated method stub

	}

	public void registerANewClub() {
		// TODO Auto-generated method stub

	}
	

}