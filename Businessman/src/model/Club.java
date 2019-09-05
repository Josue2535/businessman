

package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Club {
	
	private String id;
	private String name;
	private ArrayList<Client> clients;
	private GregorianCalendar issueDate;
	private String typeOfPet;
	
	
	public Club(String id, String name, GregorianCalendar issueDate) {
		super();
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
	public GregorianCalendar getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(GregorianCalendar issueDate) {
		this.issueDate = issueDate;
	}
	
	public void addClient(Client person) {
		clients.add(person);
	}
	
	
	
	


} //end of class
