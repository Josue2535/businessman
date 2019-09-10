
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Businessman {

	private String name;
	private ArrayList<Club> clubs;

	public Businessman(String name) {
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

	// --------------------ORDERING METHODS BEGIN-------------------
	public void ordeningClubById() {
		for (int i = clubs.size(); i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				Club p1 = clubs.get(j);
				Club p2 = clubs.get(j + 1);

				if (p1.compare(p1,p2) > 0) {
					clubs.set(j, p2);
					clubs.set(j + 1, p1);
				}
			}
		}
	}
	public void ordeningClubByName() {
		for (int i = 1; i < clubs.size(); i++) {
			Club in = clubs.get(i);
			boolean termino = false;
			for (int j = i; j > 0 && !termino; j--) {
				Club actual = clubs.get(j - 1);
				if (actual.compareTo(in) > 0) {
					clubs.set(j, actual);
					clubs.set(j - 1, in);
				} else
					termino = true;
			}
		}
	}
	public void ordeningClubByClients() {
		int inicial;
		for (inicial = 0; inicial < clubs.size(); inicial++) {
			int mP = inicial;
			Club mClub = clubs.get(inicial);

			for (int i = inicial + 1; i < clubs.size(); i++) {
				Club pClub = clubs.get(i);
				if (pClub.compareClient(mClub) < 0) {
					mClub = pClub;
					mP = i;
				}
			}

			if (mP != inicial) {
				Club temp = clubs.get(inicial);
				clubs.set(inicial, mClub);
				clubs.set(mP, temp);
			}

		}
	}
	public void ordeningClubByIssueDate() {
		for (int i = clubs.size(); i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				Club p1 = clubs.get(j);
				Club p2 = clubs.get(j + 1);

				if (p1.compareIssueDate(p2) > 0) {
					clubs.set(j, p2);
					clubs.set(j + 1, p1);
				}
			}
		}
	}
	public void ordeningClubByTypeOfPet() {
		for (int i = clubs.size(); i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				Club p1 = clubs.get(j);
				Club p2 = clubs.get(j + 1);

				if (p1.compareTypePet(p1,p2) > 0) {
					clubs.set(j, p2);
					clubs.set(j + 1, p1);
				}
			}
		}
	}
	//-------------END METHODS ORDENAORDERING---------------
	//-------------START METHODS TO FIND--------------------
	public int findClubByIdBi(Club c) {
		ordeningClubById();
		int position = -1;
		int start = 0;
		int end = clubs.size() - 1;

		while (start <= end && position == -1) {
			int mid = (start + end) / 2;
			Club half = clubs.get(mid);
			if (half.compare(half, c) == 0) {
				position = mid;
			} else if (half.compare(half, c) > 0) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return position;
	}
	public int findClubByIdNo(Club c) {
		ordeningClubById();
		int position = -1;
		boolean close = false;
		for(int i = 0; i<clubs.size() && !false; i++) {
			Club c1 = clubs.get(i);
			if(c.compare(c,c1)==0) {
				position = i;
				close = true;
			}
		}
		
		return position;
	}
	
	
	public int findClubByNameBi(Club c) {
		ordeningClubByName();
		int position = -1;
		int start = 0;
		int end = clubs.size() - 1;

		while (start <= end && position == -1) {
			int mid = (start + end) / 2;
			Club half = clubs.get(mid);
			if (half.compareTo( c) == 0) {
				position = mid;
			} else if (half.compareTo( c) > 0) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return position;
	}
	
	public int findClubByNameNo(Club c) {
		ordeningClubByName();
		int position = -1;
		boolean close = false;
		for(int i = 0; i<clubs.size() && !false; i++) {
			Club c1 = clubs.get(i);
			if(c.compareTo(c1)==0) {
				position = i;
				close = true;
			}
		}
		
		return position;
	}
	
	
	public ArrayList<Club> findClubByClientsBi(Club c) {
		ordeningClubByClients();
		ArrayList<Club> mi = new ArrayList<Club>();
		int position = -1;
		int start = 0;
		int end = clubs.size() - 1;

		while (start <= end && position == -1) {
			int mid = (start + end) / 2;
			Club half = clubs.get(mid);
			if (half.compareClient ( c) == 0) {
				position = mid;
			} else if (half.compareClient( c) > 0) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		mi.add(clubs.get(position));

		boolean found = false;
		for (int i = position+1; i < clubs.size() && !found; i++) {
			if(c.compareClient( clubs.get(i))== 0) {
				mi.add(clubs.get(i));
			}
			else {
				found = true;
			}
		}
		found = false;
		for(int q = position-1; q>=0 && !found; q--) {
			if(c.compareClient( clubs.get(q))== 0) {
				mi.add(clubs.get(q));
			}
			else {
				found = true;
			}
		}
		return mi;
	}
	public ArrayList<Club> findClubByClientsNo(Club c){
		ordeningClubByClients();
		ArrayList<Club> mi = new ArrayList<Club>();
		int f = -1;
		for (int i = 0; i < clubs.size() && f == -1;) {
			if (clubs.get(i).compareClient(c) == 0) {
				f = i;
			}
		}
		mi.add(clubs.get(f));
		boolean close = false;
		if(f == -1) {
			close = true;
		}
		for (int j = f; j < clubs.size() && !close; j++) {
			if (clubs.get(j).compareClient(c) == 0) {
				mi.add(clubs.get(j));
			}
			else {
				close = true;
			}
		}
		return mi;
	}
	
	public ArrayList<Club> findClubByIssueDateBi(Club c){
		ordeningClubByIssueDate();
		ArrayList<Club> mi = new ArrayList<Club>();
		int position = -1;
		int start = 0;
		int end = clubs.size() - 1;

		while (start <= end && position == -1) {
			int mid = (start + end) / 2;
			Club half = clubs.get(mid);
			if (half.compareIssueDate( c) == 0) {
				position = mid;
			} else if (half.compareIssueDate( c) > 0) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		mi.add(clubs.get(position));

		boolean found = false;
		for (int i = position+1; i < clubs.size() && !found; i++) {
			if(c.compareIssueDate( clubs.get(i))== 0) {
				mi.add(clubs.get(i));
			}
			else {
				found = true;
			}
		}
		found = false;
		for(int q = position-1; q>=0 && !found; q--) {
			if(c.compareIssueDate( clubs.get(q))== 0) {
				mi.add(clubs.get(q));
			}
			else {
				found = true;
			}
		}
		return mi;
	}
	public ArrayList<Club> findClubByIssueDateNo(Club c){
		ordeningClubByIssueDate();
		ArrayList<Club> mi = new ArrayList<Club>();
		int f = -1;
		for (int i = 0; i < clubs.size() && f == -1;) {
			if (clubs.get(i).compareIssueDate(c) == 0) {
				f = i;
			}
		}
		mi.add(clubs.get(f));
		boolean close = false;
		if(f == -1) {
			close = true;
		}
		for (int j = f; j < clubs.size() && !close; j++) {
			if (clubs.get(j).compareIssueDate(c) == 0) {
				mi.add(clubs.get(j));
			}
			else {
				close = true;
			}
		}
		return mi;
	}
	public ArrayList<Club> findClubByTypeOfPetBi(Club c){
		ordeningClubByTypeOfPet();
		ArrayList<Club> mi = new ArrayList<Club>();
		int position = -1;
		int start = 0;
		int end = clubs.size() - 1;

		while (start <= end && position == -1) {
			int mid = (start + end) / 2;
			Club half = clubs.get(mid);
			if (half.compareTypePet(half, c) == 0) {
				position = mid;
			} else if (half.compareTypePet(half, c) > 0) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		mi.add(clubs.get(position));

		boolean found = false;
		for (int i = position+1; i < clubs.size() && !found; i++) {
			if(c.compareTypePet(c, clubs.get(i))== 0) {
				mi.add(clubs.get(i));
			}
			else {
				found = true;
			}
		}
		found = false;
		for(int q = position-1; q>=0 && !found; q--) {
			if(c.compareTypePet(c,clubs.get(q))== 0) {
				mi.add(clubs.get(q));
			}
			else {
				found = true;
			}
		}
		return mi;
	}
	public ArrayList<Club> findClubByTypeOfPetNo(Club c){
		ordeningClubByTypeOfPet();
		ArrayList<Club> mi = new ArrayList<Club>();
		int f = -1;
		for (int i = 0; i < clubs.size() && f == -1;) {
			if (clubs.get(i).compareTypePet(clubs.get(i),c) == 0) {
				f = i;
			}
		}
		mi.add(clubs.get(f));
		boolean close = false;
		if(f == -1) {
			close = true;
		}
		for (int j = f; j < clubs.size() && !close; j++) {
			if (clubs.get(j).compareTypePet(clubs.get(j),c) == 0) {
				mi.add(clubs.get(j));
			}
			else {
				close = true;
			}
		}
		return mi;
	}
	//-------------START METHODS TO ELIMINATE-------------
	public boolean delateAPetById(Club club, String p) {
		boolean de = false;
		if(findClubByIdBi(club)!= -1) {
			if(clubs.get(findClubByIdBi(club)).deletePetClientNo(p)) {
				de = true;
			}
		}
		return de;
	}

	public boolean delateAClientNameOrId(Club c, String msj) {
		boolean de = false;
		if(findClubByIdBi(c)!= -1) {
			de = clubs.get(findClubByIdBi(c)).delateClientByName(msj);
			
		}
		return de;

	}
	
	public boolean delateAClub() {
		

	}

	public void addPet() {
		// TODO Auto-generated method stub

	}

	public void registerANewClient(Club c, Client s) {
		

	}

	public void registerANewClub() {
		// TODO Auto-generated method stub

	}
	

}