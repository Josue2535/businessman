
package model;
import excptions.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

/**
 * @author Josue Rodriguez
 * @version 1.0 lab2 college Icesi (Cali-Colombia) github:
 *          https://github.com/Josue2535
 */
public class Client implements Serializable, Comparator<Client>, Comparable<Client> {

	private String id;
	private String name;
	private String lastName;
	private Date birthDate;
	private ArrayList<Pet> pets;
	private String favTypePet;

	public Client(String id, String name, String lastName, Date birthDate, String favTypePet) {
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
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
	// ----- end GETS AND SETS-------------------------------

	// ------------------START ORDENATIONS-----------------------
	// burbuja
	public void ordenationId() {
		for (int i = pets.size(); i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				Pet p1 = pets.get(j);
				Pet p2 = pets.get(j + 1);

				if (p1.compareTo(p2) > 0) {
					pets.set(j, p2);
					pets.set(j + 1, p1);
				}
			}
		}
	}

	// ----------------insercion----------
	public void ordenationDate() {
		for (int i = 1; i < pets.size(); i++) {
			Pet in = pets.get(i);
			boolean termino = false;
			for (int j = i; j > 0 && !termino; j--) {
				Pet actual = pets.get(j - 1);
				if (actual.comparePetBirth(in) > 0) {
					pets.set(j, actual);
					pets.set(j - 1, in);
				} else
					termino = true;
			}
		}
	}

	// ---------seleccion-----------------
	public void ordenationName() {
		int inicial;
		for (inicial = 0; inicial < pets.size(); inicial++) {
			int mP = inicial;
			Pet mPet = pets.get(inicial);

			for (int i = inicial + 1; i < pets.size(); i++) {
				Pet pPet = pets.get(i);
				if (pPet.comparePetName(mPet) < 0) {
					mPet = pPet;
					mP = i;
				}
			}

			if (mP != inicial) {
				Pet temp = pets.get(inicial);
				pets.set(inicial, mPet);
				pets.set(mP, temp);
			}

		}
	}

	public void ordenationGender() {
		for (int i = pets.size(); i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				Pet p1 = pets.get(j);
				Pet p2 = pets.get(j + 1);

				if (p1.compare(p1,p2) > 0) {
					pets.set(j, p2);
					pets.set(j + 1, p1);
				}
			}
		}
	}

	public void ordenationType() {
		for (int i = pets.size(); i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				Pet p1 = pets.get(j);
				Pet p2 = pets.get(j + 1);

				if (p1.comparePetType(p1, p2) > 0) {
					pets.set(j, p2);
					pets.set(j + 1, p1);
				}
			}
		}
	}

	

	// ---------comparison methods---------
	// ----------comparison by id----------
	@Override
	public int compareTo(Client o) {
		int valorComparacion = id.compareToIgnoreCase(o.getId());
		if (valorComparacion < 0) {
			valorComparacion = -1;
		} else if (valorComparacion == 0) {
			valorComparacion = 0;
		} else {
			valorComparacion = 1;
		}
		return valorComparacion;
	}

	// -------comparison by name------------
	
	
	
	@Override
	public int compare(Client o1, Client o2) {
		int com = o1.getName().compareToIgnoreCase(o2.getName());
		if (com < 0) {
			com = -1;
		}
		if (com > 0) {
			com = 1;
		}

		return com;
	}

	
	
	
	// -------comparison by last name----------
	public int compareLastName(Client o1, Client o2) {
		int com = o1.getLastName().compareToIgnoreCase(o2.getLastName());
		if (com < 0) {
			com = -1;
		}
		if (com > 0) {
			com = 1;
		}
		return com;
	}
	
	
	
	
	
	//----------comparison by birthDate--------------------
	public int compareBirth(Client o) {
		int com = 0;
		 if( birthDate.compareTo(o.getBirthDate())>0)
	           com = 1;
	        else if( birthDate.compareTo(o.getBirthDate())<0 )
	            com = -1;
		return com;
	}
	
	
	
	
	
	
	
	
	//----------comparison by pets-------------------------
	public int comparePets(Client o1) {
		int com = 0;
		if(pets.size() > o1.getPets().size()) {
			com = 1;
		}
		if(pets.size() < o1.getPets().size()) {
			com = -1;
		}
		return com;
	}
	
	
	
	
	
	
	//----------comparison by favorite type pet------------
	public int compareFavTyPet(Client o1, Client o2) {
		int com = o1.getFavTypePet().compareToIgnoreCase(o2.getFavTypePet());
		if(com<0) {
			com = -1;
		}
		if(com>0) {
			com = 1;
		}
		return com;
	}
	
	
	
	
	
	
	
	
	//----------------- methods to find----------------------
	
	
	public ArrayList<Pet> findTypePetBi(Pet p) {
		ordenationType();
		ArrayList<Pet> mi = new ArrayList<Pet>();
		int position = -1;
		int start = 0;
		int end = pets.size() - 1;

		while (start <= end && position == -1) {
			int mid = (start + end) / 2;
			Pet half = pets.get(mid);
			if (half.comparePetType(half, p) == 0) {
				position = mid;
			} else if (half.comparePetType(half, p) > 0) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		mi.add(pets.get(position));

		boolean found = false;
		for (int i = position+1; i < pets.size() && !found; i++) {
			if(p.comparePetType(p, pets.get(i))== 0) {
				mi.add(pets.get(i));
			}
			else {
				found = true;
			}
		}
		found = false;
		for(int q = position-1; q>=0 && !found; q--) {
			if(p.comparePetType(p, pets.get(q))== 0) {
				mi.add(pets.get(q));
			}
			else {
				found = true;
			}
		}
		return mi;
	}
	
	
	
	
	

	public ArrayList<Pet> findTypePetNo(Pet p) {
		ordenationType();
		ArrayList<Pet> mi = new ArrayList<Pet>();
		int f = -1;
		for (int i = 0; i < pets.size() && f == -1;) {
			if (pets.get(i).comparePetType(pets.get(i), p) == 0) {
				f = i;
			}
		}
		mi.add(pets.get(f));
		boolean close = false;
		if(f == -1) {
			close = true;
		}
		for (int j = f; j < pets.size() && !close; j++) {
			if (pets.get(j).comparePetType(pets.get(j), p) == 0) {
				mi.add(pets.get(j));
			}
			else {
				close = true;
			}
		}
		return mi;
	}
	//---------------------find by id pet--------
	public int findIdPetNo(Pet p) {
		ordenationId();
		int position = -1;
		boolean close = false;
		for(int i = 0; i<pets.size() && !false; i++) {
			Pet p1 = pets.get(i);
			if(p.compareTo(p1)==0) {
				position = i;
				close = true;
			}
		}
		
		return position;
	}
	public int findIdPetBi(Pet p1) {
		ordenationId();
		int position = -1;
		int start = 0;
		int end = pets.size() - 1;

		while (start <= end && position == -1) {
			int mid = (start + end) / 2;
			Pet half = pets.get(mid);
			if (half.compareTo(p1) == 0) {
				position = mid;
			} else if (half.compareTo(p1) > 0) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return position;
	}
	//----------------find pet by name------------------
	public int findPetNameNo(Pet p) {
		ordenationName();
		int position = -1;
		boolean close = false;
		for(int i = 0; i<pets.size() && !false; i++) {
			Pet p1 = pets.get(i);
			if(p.comparePetName(p1)==0) {
				position = i;
				close = true;
			}
		}
		return position;
	}
	public int findPetNameBi(Pet p1) {
		ordenationName();
		int position = -1;
		int start = 0;
		int end = pets.size() - 1;

		while (start <= end && position == -1) {
			int mid = (start + end) / 2;
			Pet half = pets.get(mid);
			if (half.comparePetName(p1) == 0) {
				position = mid;
			} else if (half.comparePetName(p1) > 0) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return position;
	}
	//----------------find pet by date-----
	public ArrayList<Pet> findPetDateBi(Pet p) {
		ordenationDate();
		ArrayList<Pet> mi = new ArrayList<Pet>();
		int position = -1;
		int start = 0;
		int end = pets.size() - 1;

		while (start <= end && position == -1) {
			int mid = (start + end) / 2;
			Pet half = pets.get(mid);
			if (half.comparePetBirth( p) == 0) {
				position = mid;
			} else if (half.comparePetBirth( p) > 0) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		mi.add(pets.get(position));

		boolean found = false;
		for (int i = position+1; i < pets.size() && !found; i++) {
			if(p.comparePetBirth( pets.get(i))== 0) {
				mi.add(pets.get(i));
			}
			else {
				found = true;
			}
		}
		found = false;
		for(int q = position-1; q>=0 && !found; q--) {
			if(p.comparePetBirth( pets.get(q))== 0) {
				mi.add(pets.get(q));
			}
			else {
				found = true;
			}
		}
		return mi;
	}
	
	
	
	
	

	public ArrayList<Pet> findPetDateNo(Pet p) {
		ordenationDate();
		ArrayList<Pet> mi = new ArrayList<Pet>();
		int f = -1;
		for (int i = 0; i < pets.size() && f == -1;) {
			if (pets.get(i).comparePetBirth(p) == 0) {
				f = i;
			}
		}
		mi.add(pets.get(f));
		boolean close = false;
		if(f == -1) {
			close = true;
		}
		for (int j = f; j < pets.size() && !close; j++) {
			if (pets.get(j).comparePetBirth(p) == 0) {
				mi.add(pets.get(j));
			}
			else {
				close = true;
			}
		}
		return mi;
	}
	//-------------find pet by gender-----
	public ArrayList<Pet> findPetGenderBi(Pet p) {
		ordenationGender();
		ArrayList<Pet> mi = new ArrayList<Pet>();
		int position = -1;
		int start = 0;
		int end = pets.size() - 1;

		while (start <= end && position == -1) {
			int mid = (start + end) / 2;
			Pet half = pets.get(mid);
			if (half.compare(half, p) == 0) {
				position = mid;
			} else if (half.compare(half, p) > 0) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		mi.add(pets.get(position));

		boolean found = false;
		for (int i = position+1; i < pets.size() && !found; i++) {
			if(p.compare(p, pets.get(i))== 0) {
				mi.add(pets.get(i));
			}
			else {
				found = true;
			}
		}
		found = false;
		for(int q = position-1; q>=0 && !found; q--) {
			if(p.compare(p, pets.get(q))== 0) {
				mi.add(pets.get(q));
			}
			else {
				found = true;
			}
		}
		return mi;
	}
	
	
	
	
	

	public ArrayList<Pet> findPetGenderNo(Pet p) {
		ordenationGender();
		ArrayList<Pet> mi = new ArrayList<Pet>();
		int f = -1;
		for (int i = 0; i < pets.size() && f == -1;) {
			if (pets.get(i).compare(pets.get(i),p) == 0) {
				f = i;
			}
		}
		mi.add(pets.get(f));
		boolean close = false;
		if(f == -1) {
			close = true;
		}
		for (int j = f; j < pets.size() && !close; j++) {
			if (pets.get(j).compare(pets.get(j),p) == 0) {
				mi.add(pets.get(j));
			}
			else {
				close = true;
			}
		}
		return mi;
	}
	//-----------END METHODS FIND---------------------------
	//-----------START METHODS DELATE-----------------------
	public boolean deletePet(String msg) {
		boolean delate = false;
		for (int i = 0; i < pets.size() && !delate; i++) {
			if(pets.get(i).getId().equals(msg) || (pets.get(i).getName().equals(msg))){
				pets.remove(i);
			}
		}
		return delate;
	}
	public boolean delatePetById(Pet p) {
		boolean delate = false;
		if(findIdPetBi(p) != -1) {
			pets.remove(findIdPetBi(p));
			delate = true;
		}
		return delate;
	}
	//----------START METHODS ADD---------------------------
	public boolean addPetSpecial(Pet p) {
		boolean add = false;
		if( findPetNameBi(p)==-1) {
			addPet(p);
			add = true;
		}
		return add;
	}
	

}
