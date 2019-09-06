
package model;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;



/**
 * @author Josue Rodriguez
 * @version 1.0
 * lab2
 * college Icesi (Cali-Colombia)
 * github: https://github.com/Josue2535
 */
public class Pet implements Serializable, Comparable<Pet>{
	
	


	public final static String MALE = "MALE";
	public final static String FEMALE = "FEMALE";

	
	
	private String id;
	private String name;
	private Date birthDate;
	private String gender;
	private String type;
	
	
	
	
	
	public Pet(String id, String name, Date birthDate, String gender, String type) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.gender = gender;
		this.type = type;
		
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



	public Date getBirthDate() {
		return birthDate;
	}



	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	
	//end getters and setters----------------------------------------------
	public int compareTo(Pet o) {
		int valorComparacion = id.compareToIgnoreCase( o.getId() );
    	if(valorComparacion < 0){
    		valorComparacion = -1;
    	}else if(valorComparacion == 0){
    		valorComparacion = 0;
    	}else{
    		valorComparacion = 1;
    	}
        return valorComparacion;
		
	}
	
	public int comparePetBirth(Pet p) {
		int com = 0;
		 if( birthDate.compareTo(p.getBirthDate())>0)
	           com = 1;
	        else if( birthDate.compareTo(p.getBirthDate())<0 )
	            com = -1;
		return com;
	}
	
	public int comparePetName(Pet p) {
		int com = name.compareToIgnoreCase(p.getName());
		if(com < 0) {
			com = -1;
		}
		if(com > 0) {
			com= 1;
		}
		
		return com;
	}

	public int comparePetGender(Pet p) {
		int com = gender.compareToIgnoreCase(p.getGender());
		if(com < 0) {
			com = -1;
		}
		if(com > 0) {
			com= 1;
		}
		return com;
	}
	public int comparePetType(Pet p) {
		int com = type.compareToIgnoreCase(p.getType());
		if(com < 0) {
			com = -1;
		}
		if(com > 0) {
			com= 1;
		}
		return com;
	}
	

	

} 
