
package model;
import java.io.Serializable;
import java.util.GregorianCalendar;



/**
 * @author Josue Rodriguez
 * @version 1.0
 * lab2
 * college Icesi (Cali-Colombia)
 * github: https://github.com/Josue2535
 */
public class Pet implements Serializable {
	
	

	public final static int DOG = 1;
	public final static int CAT = 2;
	public final static int BIRD = 3;
	public final static int HAMSTER = 4;
	public final static int FERRET = 5;
	public final static char MALE = 'M';
	public final static char FEMALE = 'F';
	
	
	
	private String id;
	private String name;
	private GregorianCalendar birthDate;
	private char gender;
	private int type;
	
	
	private Client owner;
	
	
	
	public Pet(String id, String name, GregorianCalendar birthDate, char gender, int type, Client owner) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.gender = gender;
		this.type = type;
		this.owner = owner;
	}

	//getters and setters

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



	public GregorianCalendar getBirthDate() {
		return birthDate;
	}



	public void setBirthDate(GregorianCalendar birthDate) {
		this.birthDate = birthDate;
	}



	public char getGender() {
		return gender;
	}



	public void setGender(char gender) {
		this.gender = gender;
	}



	public int getType() {
		return type;
	}



	public void setType(int type) {
		this.type = type;
	}



	public Client getOwner() {
		return owner;
	}



	public void setOwner(Client owner) {
		this.owner = owner;
	}
	//fin getters and setters

	

} 
