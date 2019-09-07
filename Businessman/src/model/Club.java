

package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
/**
 * @author Josue Rodriguez
 * @version 1.0
 * lab2
 * college Icesi (Cali-Colombia)
 * github: https://github.com/Josue2535
 */

public class Club implements Comparable<Club>, Comparator<Club> {
	
	private String id;
	private String name;
	private ArrayList<Client> clients;
	private Date issueDate;
	private String typeOfPet;
	
	
	public Club(String id, String name, Date issueDate, String typeOfPet) {
		this.id = id;
		this.name = name;
		this.issueDate = issueDate;
		typeOfPet = typeOfPet;
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
	public String getTypeOfPet() {
		return typeOfPet;
	}
	public void setTypeOfPet(String typeOfPet) {
		this.typeOfPet = typeOfPet;
	}
	
	
	public void addPetClient(String id, Pet p) {
		
	}
	
	
	
	
	
	
	
	
	//-------------------comparison methods----------------------------
	@Override
	public int compare(Club o1, Club o2) {
		int com = o1.getId().compareToIgnoreCase(o2.getId());
		if(com < 0) {
			com = -1;
		}
		if(com >0) {
			com = 1;
		}
		return com;
	}


	@Override
	public int compareTo(Club o) {
		int com = name.compareToIgnoreCase(o.getName());
		if(com<0) {
			com =-1;
		}
		if(com> 0) {
			com = 1;
		}
		return com;
	}
	public int compareIssueDate(Club o) {
		int com = issueDate.compareTo(o.getIssueDate());
		if(com<0) {
			com = -1;
		}
		if(com>0) {
			com = 1;
		}
		return com;
	}
	
	public int compareTypePet(Club o, Club o1) {
		int com = o.getTypeOfPet().compareToIgnoreCase(o1.getTypeOfPet());
		if(com<0) {
			com = -1;
		}
		if(com > 0) {
			com = 1;
		}
		return com;
	}
	public int compareClient(Club o) {
		int com = 0;
		if(clients.size()<o.getClients().size()) {
			com = -1;
		}
		if(clients.size()>o.getClients().size()) {
			com = 1;
		}
		return com;
	}
	//-------------methods for ordering customers-------------------
	//burbuja
	public void ordenaringClientId() {
		for (int i = clients.size(); i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				Client p1 = clients.get(j);
				Client p2 = clients.get(j + 1);

				if (p1.compareTo(p2) > 0) {
					clients.set(j, p2);
					clients.set(j + 1, p1);
				}
			}
		}
	}
	//insercion
	public void ordenaringClientName() {
		for (int i = 1; i < clients.size(); i++) {
			Client in = clients.get(i);
			boolean termino = false;
			for (int j = i; j > 0 && !termino; j--) {
				Client actual = clients.get(j - 1);
				if (actual.compare(actual, in) > 0) {
					clients.set(j, actual);
					clients.set(j - 1, in);
				} else
					termino = true;
			}
		}
	}
	//selecion
	public void ordenaringClientLastName() {
		int inicial;
		for (inicial = 0; inicial < clients.size(); inicial++) {
			int mP = inicial;
			Client mClient = clients.get(inicial);

			for (int i = inicial + 1; i < clients.size(); i++) {
				Client pClient = clients.get(i);
				if (pClient.compareLastName(pClient,mClient) < 0) {
					mClient = pClient;
					mP = i;
				}
			}

			if (mP != inicial) {
				Client temp = clients.get(inicial);
				clients.set(inicial, mClient);
				clients.set(mP, temp);
			}

		}
	}
	
	//-----search methods------------------------------------------
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
