
package model;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

/**
 * @author Josue Rodriguez
 * @version 1.0 lab2 college Icesi (Cali-Colombia) github:
 *          https://github.com/Josue2535
 */

public class Club implements Comparable<Club>, Comparator<Club> {

	private String id;
	private String name;
	private ArrayList<Client> clients;
	private Date issueDate;
	private String typeOfPet;

	public Club(String id, String name, Date issueDate, String typeOfPet)
			throws IOException, NumberFormatException, ClassNotFoundException {
		this.id = id;
		this.name = name;
		this.issueDate = issueDate;
		typeOfPet = typeOfPet;
		clients = new ArrayList<Client>();
		if (!new File(id).exists()) {
			new File(id).createNewFile();
		}
		loadData();
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

	// -------------------comparison methods----------------------------
	@Override
	public int compare(Club o1, Club o2) {
		int com = o1.getId().compareToIgnoreCase(o2.getId());
		if (com < 0) {
			com = -1;
		}
		if (com > 0) {
			com = 1;
		}
		return com;
	}

	@Override
	public int compareTo(Club o) {
		int com = name.compareToIgnoreCase(o.getName());
		if (com < 0) {
			com = -1;
		}
		if (com > 0) {
			com = 1;
		}
		return com;
	}

	public int compareIssueDate(Club o) {
		int com = issueDate.compareTo(o.getIssueDate());
		if (com < 0) {
			com = -1;
		}
		if (com > 0) {
			com = 1;
		}
		return com;
	}

	public int compareTypePet(Club o, Club o1) {
		int com = o.getTypeOfPet().compareToIgnoreCase(o1.getTypeOfPet());
		if (com < 0) {
			com = -1;
		}
		if (com > 0) {
			com = 1;
		}
		return com;
	}

	public int compareClient(Club o) {
		int com = 0;
		if (clients.size() < o.getClients().size()) {
			com = -1;
		}
		if (clients.size() > o.getClients().size()) {
			com = 1;
		}
		return com;
	}

	// -------------methods for ordering customers-------------------
	// burbuja
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

	// insercion
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

	// selecion
	public void ordenaringClientLastName() {
		int inicial;
		for (inicial = 0; inicial < clients.size(); inicial++) {
			int mP = inicial;
			Client mClient = clients.get(inicial);

			for (int i = inicial + 1; i < clients.size(); i++) {
				Client pClient = clients.get(i);
				if (pClient.compareLastName(pClient, mClient) < 0) {
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

	// ---------------------------------------
	public void ordenaringClientBirthDate() {
		for (int i = clients.size(); i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				Client p1 = clients.get(j);
				Client p2 = clients.get(j + 1);

				if (p1.compareBirth(p2) > 0) {
					clients.set(j, p2);
					clients.set(j + 1, p1);
				}
			}
		}
	}

	// -------------------------------------------
	public void ordenaringClientNuPets() {
		for (int i = clients.size(); i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				Client p1 = clients.get(j);
				Client p2 = clients.get(j + 1);

				if (p1.comparePets(p2) > 0) {
					clients.set(j, p2);
					clients.set(j + 1, p1);
				}
			}
		}
	}

	// ---------------------------------------------
	public void ordearingClientsFavTypePet() {
		for (int i = clients.size(); i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				Client p1 = clients.get(j);
				Client p2 = clients.get(j + 1);

				if (p1.compareFavTyPet(p1, p2) > 0) {
					clients.set(j, p2);
					clients.set(j + 1, p1);
				}
			}
		}
	}

	// -----search methods------------------------------------------
	public int foundClientNameBi(Client c1) {
		ordenaringClientName();
		int position = -1;
		int start = 0;
		int end = clients.size() - 1;

		while (start <= end && position == -1) {
			int mid = (start + end) / 2;
			Client half = clients.get(mid);
			if (half.compare(half, c1) == 0) {
				position = mid;
			} else if (half.compare(half, c1) > 0) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return position;
	}

	public int foundClientNameNo(Client c) {
		ordenaringClientName();
		int position = -1;
		boolean close = false;
		for (int i = 0; i < clients.size() && !false; i++) {
			Client c1 = clients.get(i);
			if (c.compare(c, c1) == 0) {
				position = i;
				close = true;
			}
		}
		return position;
	}

	// ------------find client by id-----------
	public int foundClienIdNo(Client c) {
		ordenaringClientId();
		int position = -1;
		boolean close = false;
		for (int i = 0; i < clients.size() && !false; i++) {
			Client c1 = clients.get(i);
			if (c.compareTo(c1) == 0) {
				position = i;
				close = true;
			}
		}

		return position;
	}

	public int foundClienIdBi(Client c1) {
		ordenaringClientId();
		int position = -1;
		int start = 0;
		int end = clients.size() - 1;

		while (start <= end && position == -1) {
			int mid = (start + end) / 2;
			Client half = clients.get(mid);
			if (half.compareTo(c1) == 0) {
				position = mid;
			} else if (half.compareTo(c1) > 0) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return position;
	}

	// -----------------find client by last name-------------------
	public int foundClienLastBi(Client c1) {
		ordenaringClientLastName();
		int position = -1;
		int start = 0;
		int end = clients.size() - 1;

		while (start <= end && position == -1) {
			int mid = (start + end) / 2;
			Client half = clients.get(mid);
			if (half.compareLastName(half, c1) == 0) {
				position = mid;
			} else if (half.compareLastName(half, c1) > 0) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return position;
	}

	public int foundClienLastNO(Client c) {
		ordenaringClientLastName();
		int position = -1;
		boolean close = false;
		for (int i = 0; i < clients.size() && !false; i++) {
			Client c1 = clients.get(i);
			if (c.compareLastName(c, c1) == 0) {
				position = i;
				close = true;
			}
		}

		return position;
	}

	// ---------find client by birthDate
	public ArrayList<Client> foundClienBirthNO(Client c) {
		ordenaringClientBirthDate();
		ArrayList<Client> mi = new ArrayList<Client>();
		int f = -1;
		for (int i = 0; i < clients.size() && f == -1;) {
			if (clients.get(i).compareBirth(c) == 0) {
				f = i;
			}
		}
		mi.add(clients.get(f));
		boolean close = false;
		if (f == -1) {
			close = true;
		}
		for (int j = f; j < clients.size() && !close; j++) {
			if (clients.get(j).compareBirth(c) == 0) {
				mi.add(clients.get(j));
			} else {
				close = true;
			}
		}
		return mi;
	}

	public ArrayList<Client> foundClienBirthBi(Client c) {
		ordenaringClientBirthDate();
		ArrayList<Client> mi = new ArrayList<Client>();
		int position = -1;
		int start = 0;
		int end = clients.size() - 1;

		while (start <= end && position == -1) {
			int mid = (start + end) / 2;
			Client half = clients.get(mid);
			if (half.compareBirth(c) == 0) {
				position = mid;
			} else if (half.compareBirth(c) > 0) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		mi.add(clients.get(position));

		boolean found = false;
		for (int i = position + 1; i < clients.size() && !found; i++) {
			if (c.compareBirth(clients.get(i)) == 0) {
				mi.add(clients.get(i));
			} else {
				found = true;
			}
		}
		found = false;
		for (int q = position - 1; q >= 0 && !found; q--) {
			if (c.compareBirth(clients.get(q)) == 0) {
				mi.add(clients.get(q));
			} else {
				found = true;
			}
		}
		return mi;
	}

	// ----------- find clients by number of pets--------
	public ArrayList<Client> foundClienPetsNO(Client c) {
		ordenaringClientNuPets();
		ArrayList<Client> mi = new ArrayList<Client>();
		int f = -1;
		for (int i = 0; i < clients.size() && f == -1;) {
			if (clients.get(i).comparePets(c) == 0) {
				f = i;
			}
		}
		mi.add(clients.get(f));
		boolean close = false;
		if (f == -1) {
			close = true;
		}
		for (int j = f; j < clients.size() && !close; j++) {
			if (clients.get(j).comparePets(c) == 0) {
				mi.add(clients.get(j));
			} else {
				close = true;
			}
		}
		return mi;
	}

	public ArrayList<Client> foundClienPetsBi(Client c) {
		ordenaringClientNuPets();
		ArrayList<Client> mi = new ArrayList<Client>();
		int position = -1;
		int start = 0;
		int end = clients.size() - 1;

		while (start <= end && position == -1) {
			int mid = (start + end) / 2;
			Client half = clients.get(mid);
			if (half.comparePets(c) == 0) {
				position = mid;
			} else if (half.comparePets(c) > 0) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		mi.add(clients.get(position));

		boolean found = false;
		for (int i = position + 1; i < clients.size() && !found; i++) {
			if (c.comparePets(clients.get(i)) == 0) {
				mi.add(clients.get(i));
			} else {
				found = true;
			}
		}
		found = false;
		for (int q = position - 1; q >= 0 && !found; q--) {
			if (c.comparePets(clients.get(q)) == 0) {
				mi.add(clients.get(q));
			} else {
				found = true;
			}
		}
		return mi;
	}

	// ---- Find clients by favorite pet---------
	public ArrayList<Client> foundClientFvPeNo(Client c) {
		ordearingClientsFavTypePet();
		ArrayList<Client> mi = new ArrayList<Client>();
		int f = -1;
		for (int i = 0; i < clients.size() && f == -1;) {
			if (clients.get(i).compareFavTyPet(clients.get(i), c) == 0) {
				f = i;
			}
		}
		mi.add(clients.get(f));
		boolean close = false;
		if (f == -1) {
			close = true;
		}
		for (int j = f; j < clients.size() && !close; j++) {
			if (clients.get(j).compareFavTyPet(clients.get(j), c) == 0) {
				mi.add(clients.get(j));
			} else {
				close = true;
			}
		}
		return mi;
	}

	public ArrayList<Client> foundClientFvPeBi(Client c) {
		ordearingClientsFavTypePet();
		ArrayList<Client> mi = new ArrayList<Client>();
		int position = -1;
		int start = 0;
		int end = clients.size() - 1;

		while (start <= end && position == -1) {
			int mid = (start + end) / 2;
			Client half = clients.get(mid);
			if (half.compareFavTyPet(half, c) == 0) {
				position = mid;
			} else if (half.compareFavTyPet(half, c) > 0) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		mi.add(clients.get(position));

		boolean found = false;
		for (int i = position + 1; i < clients.size() && !found; i++) {
			if (c.compare(c, clients.get(i)) == 0) {
				mi.add(clients.get(i));
			} else {
				found = true;
			}
		}
		found = false;
		for (int q = position - 1; q >= 0 && !found; q--) {
			if (c.compareFavTyPet(c, clients.get(q)) == 0) {
				mi.add(clients.get(q));
			} else {
				found = true;
			}
		}
		return mi;
	}

	// ---------------------------------END FOUND CLIENT-----------------
	// ---------------------------------START FOUND PET------------------
	public int foundPetNameBi(Client c, Pet p) {
		int com = c.findPetNameBi(p);
		return com;
	}

	public int foundPetNameNo(Client c, Pet p) {
		int com = c.findPetNameNo(p);
		return com;
	}

	// ------------------find pet by id-------------------------------
	public int foundPetIdBi(Client c, Pet p) {
		int f = c.findIdPetBi(p);
		return f;
	}

	public int foundPetIdNo(Client c, Pet p) {
		int f = c.findIdPetNo(p);
		return f;
	}

	public ArrayList<Pet> foundPetBirthNO(Client c, Pet p) {
		ArrayList<Pet> f = c.findPetDateNo(p);
		return f;
	}

	public ArrayList<Pet> foundPetBirthBi(Client c, Pet p) {
		ArrayList<Pet> f = c.findPetDateBi(p);
		return f;
	}

	public ArrayList<Pet> foundPetTypeNo(Client c, Pet p) {
		ArrayList<Pet> f = c.findTypePetNo(p);
		return f;
	}

	public ArrayList<Pet> foundPetTypeBi(Client c, Pet p) {
		ArrayList<Pet> f = c.findTypePetBi(p);
		return f;
	}

	public ArrayList<Pet> foundPetGenderNo(Client c, Pet p) {
		ArrayList<Pet> f = c.findPetGenderNo(p);
		return f;
	}

	public ArrayList<Pet> foundPetGenderBi(Client c, Pet p) {
		ArrayList<Pet> f = c.findPetGenderBi(p);
		return f;
	}

	public ArrayList<Pet> findPetDateNo(Client c, Pet p) {
		ArrayList<Pet> f = c.findPetDateNo(p);
		return f;
	}

	public ArrayList<Pet> findPetDateBi(Client c, Pet p) {
		ArrayList<Pet> f = c.findPetDateBi(p);
		return f;
	}

	// --------THE METHODS OF DISPOSAL BEGIN------------
	// -------DELATE CLIENT-----------------------------
	public boolean delateClientByName(String msj) {

		boolean delate = false;
		for (int i = 0; i < clients.size() && !delate; i++) {
			if (clients.get(i).getId().equals(msj) || (clients.get(i).getName().equals(msj))) {
				clients.remove(i);
				delate = true;
			}
		}
		return delate;

	}

	// ----DELATE PET-----------------------------------
	public boolean deletePetClientNo(String msj) {
		boolean delete = false;
		for (int i = 0; i < clients.size(); i++) {
			if (clients.get(i).deletePet(msj)) {
				delete = true;
			}

		}
		return delete;
	}

	// -----------ADD PET--------------------------
	public boolean petIdClients(Pet p) {
		boolean find = false;
		for (int i = 0; i < clients.size(); i++) {
			if (clients.get(i).findIdPetBi(p) != -1) {
				find = true;
			}
		}
		return find;
	}

	public boolean addPetClient(Pet p, Client c) {
		boolean add = false;
		if (!petIdClients(p)) {
			add = clients.get(foundClienIdBi(c)).addPetSpecial(p);
		}
		return add;
	}

	// -------ADD CLIENT---------------------------
	public boolean addClientSpecial(Client c) {
		boolean add = false;
		if (foundClienIdBi(c) == -1 && foundClientNameBi(c) == -1) {
			addClient(c);
			add = true;
		}
		return add;
	}

	// toString
	public String toString() {
		return id + "," + name + "," + issueDate.toString() + "," + typeOfPet;
	}

	public void loadData() throws NumberFormatException, IOException, ClassNotFoundException {

		File f = new File("./data/"+id + ".csv");
		BufferedReader br = new BufferedReader(new FileReader(f));
		String line;
		File f1 = new File(id);
		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(f1));
		
		try {
			while ((line = br.readLine()) != null) {
				if (!line.equals("ID,name,last name,birthDate,favTypePet,idPet,pet name,datePet,gender,typePet")) {
					String[] s = line.split(",");
					Date d3 = new Date(s[3]);
					Client e = new Client(s[0], s[1], s[2], d3, s[4]);
					d3 = new Date(s[7]);
					Pet e1 = new Pet(s[5], s[6], d3, s[8], s[9]);
					e.addPet(e1);
					clients.add(e);
					o.writeObject(e);
				}

			}

		} catch (Exception e) {

		}
		o.close();
		br.close();

	}
}
