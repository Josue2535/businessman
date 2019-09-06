

package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
/**
 * @author Josue Rodriguez
 * @version 1.0
 * lab2
 * college Icesi (Cali-Colombia)
 * github: https://github.com/Josue2535
 */

public class Club {
	
	private String id;
	private String name;
	private ArrayList<Client> clients;
	private Date issueDate;
	private String typeOfPet;
	
	
	public Club(String id, String name, Date issueDate) {
		this.id = id;
		this.name = name;
		this.issueDate = issueDate;
		typeOfPet = "";
		clients = new ArrayList<Client>();
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
	public ArrayList<Client> getClients() {
		return clients;
	}
	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	
	public void addClient(Client person) {
		clients.add(person);
	}
	
	
	public void addPetClient(String id, Pet p) {
		
	}
	//-----Metodos de busqueda------------------------------------------
	public int foundClientNameBi() {
		int f = 0;
		return f;
	}
	public int foundClientNameNo() {
		int f = 0;
		return f;
	}
	public int foundClienIdBi() {
		int f = 0;
		return f;
	} 
	public int foundClienIdNo() {
		int f = 0;
		return f;
	} 
	public int foundClienLastBi() {
		int f = 0;
		return f;
	} 
	public int foundClienLastNO() {
		int f = 0;
		return f;
	}
	public int foundClienBirthNO() {
		int f = 0;
		return f;
	}
	public int foundClienBirthBi() {
		int f = 0;
		return f;
	}
	public int foundClienPetsNO() {
		int f = 0;
		return f;
	}
	public int foundClienPetsBi() {
		int f = 0;
		return f;
	}
	public int foundClientFvPeNo() {
		int f =0;
		return f;
	}
	public int foundClientFvPeBi() {
		int f =0;
		return f;
	}
	//---------------------------------END FOUND CLIENT-----------------
	//---------------------------------START FOUND PET----------------------------
	public int foundPetNameBi() {
		int f = 0;
		return f;
	}
	public int foundPetNameNo() {
		int f = 0;
		return f;
	}
	public int foundPetIdBi() {
		int f = 0;
		return f;
	} 
	public int foundPetIdNo() {
		int f = 0;
		return f;
	} 
	
	public int foundPetBirthNO() {
		int f = 0;
		return f;
	}
	public int foundPetBirthBi() {
		int f = 0;
		return f;
	}
	
	public int foundPetTypeNo() {
		int f =0;
		return f;
	}
	public int foundPetTypeBi() {
		int f =0;
		return f;
	}
	public int foundPetGenderNo() {
		int f =0;
		return f;
	}
	public int foundPetGenderBi() {
		int f =0;
		return f;
	}
	
	


} //end of class
