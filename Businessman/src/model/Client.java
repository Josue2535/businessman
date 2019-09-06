
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

/**
 * @author Josue Rodriguez
 * @version 1.0 lab2 college Icesi (Cali-Colombia) github:
 *          https://github.com/Josue2535
 */
public class Client implements Serializable {

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

	// ----------------insercion------------------------
	public void ordenationBirth() {
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

	// ---------seleccion--------------------------
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

				if (p1.comparePetGender(p2) > 0) {
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

				if (p1.comparePetType(p2) > 0) {
					pets.set(j, p2);
					pets.set(j + 1, p1);
				}
			}
		}
	}

	public void ordenationDate() {
		for (int i = pets.size(); i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				Pet p1 = pets.get(j);
				Pet p2 = pets.get(j + 1);

				if (p1.comparePetBirth(p2) > 0) {
					pets.set(j, p2);
					pets.set(j + 1, p1);
				}
			}
		}
	}

	// ----------------comparison methods------------------------------
	public ArrayList<Pet> findTypePetBi(Pet p) {
		ArrayList<Pet> mi = new ArrayList<Pet>();
		int position = -1;
		int start = 0;
		int end = pets.size() - 1;

		while (start <= end && position == -1) {
			int mid = (start + end) / 2;
			Pet half = pets.get(mid);
			if (half.comparePetType(p) == 0) {
				position = mid;
			} else if (half.comparePetType(p) > 0) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		mi.add(pets.get(position));

		boolean found = false;
		for (int i = 0; i < pets.size() && !found; i++) {

		}
		return mi;
	}

	public ArrayList<Pet> findTypePetNo(Pet p) {
		ArrayList<Pet> mi = new ArrayList<Pet>();
		int f = -1;
		for (int i = 0; i < pets.size() && f == -1;) {
			if (pets.get(i).comparePetType(p) == 0) {
				f = i;
			}
		}
		mi.add(pets.get(f));
		boolean close = false;
		for (int j = f; j < pets.size() && !close; j++) {
			if (pets.get(j).comparePetType(p) == 0) {
				mi.add(pets.get(j));
			}
		}
		return mi;
	}

}
