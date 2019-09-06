
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

				if (p1.comparePetName(p2) > 0) {
					pets.set(j, p2);
					pets.set(j + 1, p1);
				}
			}
		}
	}
	//----------------insercion------------------------
	public void ordenationBirth() {
		 for( int i = 1; i < pets.size( ); i++ )
	        {
	            Pet in = pets.get( i );
	            boolean termino = false;
	            for( int j = i; j > 0 && !termino; j-- )
	            {
	                Pet actual = pets.get( j - 1 );
	                if( actual.comparePetBirth(in) > 0 )
	                {
	                    pets.set( j, actual );
	                    pets.set( j - 1, in );
	                }
	                else
	                    termino = true;
	            }
	        }
	}

	public void ordenationName() {

	}

	public void ordenationGender() {

	}

	public void ordenationType() {

	}
	// ----------------comparison methods------------------------------

	

}
