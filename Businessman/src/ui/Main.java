

package ui;

import java.io.IOException;
import java.util.*;
import model.*;

public class Main {

	private Scanner reader;
	private Businessman bu;

	public Main() {
		reader = new Scanner(System.in);
	}

	public static void main(String[] args) {
		Main execute = new Main();
		execute.menu();

	}

	public void showMenuOptions() {
		System.out.println("--------------------------------------- \n");
		System.out.println("1. Register a new club.");
		System.out.println("2. Register a new client.");
		System.out.println("3. Add a pet to an existing client.");
		System.out.println("4. Delate a club.");
		System.out.println("5. Delate a client from a club.");
		System.out.println("6. Delate a pet from a client.");
		System.out.println("7. Order the lab.");
		System.out.println("8. Find");
		System.out.println("9. CHAU ");
		System.out.println("----------------------------------------- \n");
	}

	public void menu() {
		int userInput = 0;

		bu = new Businessman("Josue Rodriguez");

		System.out.println("");
		System.out.println("");

		// WELCOME
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Welcome to the best lab in the world");
		System.out.println("enjoy your stay :3");
		System.out.println("-----------------------------------------------------------------");
		while (userInput != 4) {

			showMenuOptions();

			System.out.println("------------------------------------------");
			System.out.print("| Type the number of your selection: ");
			try {
				userInput = reader.nextInt();
				reader.nextLine();
				System.out.println("--------------------------------------");

				switch (userInput) {

				
				case 1:
					registerANewClub();
					break;

				
				case 2:
					registerANewClient();
					break;

				
				case 3:
					addPet();
					break;

				
				case 4:
					delateAClub();
					break;

				
				case 5:
					delateAClient();
					break;

				
				case 6:
					delateAPet();
					break;

				
				case 7:
					orderTheLab();
					break;
				case 8:
					find();
					break;
				case 9:
					theGoodbye();
					break;

				default:
					System.out.println();
					System.out.println("Please type a number between 1 and 7");
					System.out.println();
					break;

				}
			} catch (InputMismatchException e) {
				System.out.println();
				System.out.print("ERROR: Invalid option");
				reader.nextLine();
				System.out.println();
			}

		}

	}

	private void find() {
		int ele = 0;
		int ele1 = 0;
		String id = "";
		Pet p;
		long p1;
		long p2;
		System.out.println("1. find a pet");
		System.out.println("2. find a client");
		System.out.println("3. find a club");
		try {
		ele = reader.nextInt();
		reader.nextLine();
		
		if(ele == 1) {
			System.out.println("1. find a pet by id");
			System.out.println("2. find a pet by name");
			System.out.println("3. find a pet by gender");
			System.out.println("4. find a pet by date");
			System.out.println("5. find a pet by type");
			ele1 = reader.nextInt();
			reader.nextLine();
			if(ele1 == 1) {
				System.out.println("please enter the pet id");
				id = reader.nextLine();
				p = new Pet(id,null,null,null,null);
				
				if(bu.existPetIdBi(p)) {
					System.out.println("the pet exist");
				}
			}
		
		}
		}catch (Exception e) {
			System.out.println("please enter a correct data");
		}
		
	}

	private void orderTheLab() {
		int ele = 0;
		System.out.println("1. sort everything by name");
		System.out.println("2. sort everything by id");
		System.out.println("3. sort everything by Date");
		System.out.println("4. sort everything by type");
		System.out.println("5. sort everything by number");
		System.out.println("6. sort clients by last name");
		System.out.println("7. sort pets by gender");
		try {
			ele = reader.nextInt();
			reader.nextLine();
		} catch (Exception e) {
			System.out.println("please enter a correct data");
		}
		if (ele == 1) {
			bu.ordeningAllByName();
		} else if (ele == 2) {
			bu.ordeningAllById();
		} else if (ele == 3) {
			bu.ordeningAllByDate();
		} else if (ele == 4) {
			bu.ordeningAllByType();
		} else if (ele == 5) {
			bu.ordeningAllByNu();
		} else if (ele == 6) {
			bu.ordeningClientByLast();
		} else if (ele == 7) {
			bu.ordeningPetsByGender();
		} else {
			System.out.println("please enter a correct data");
		}

	}

	private void delateAPet() {
		String id = "";
		System.out.println("please enter the pet id or name ");
		id = reader.nextLine();
		if(bu.delateAPetById(id)) {
			System.out.println("the pets has been eliminated ");
		}else {
			System.out.println("the pets no found ");
		}

	}

	private void delateAClient() {
		String id = "";
		System.out.println("please enter the client id or name ");
		id = reader.nextLine();
		if(bu.delateAClientNameOrId(id)) {
			System.out.println("the client has been eliminated ");
		}else {
			System.out.println("the client no found ");
		}

	}

	private void delateAClub() {
		String id = "";
		System.out.println("please enter the club id or name ");
		id = reader.nextLine();
		if(bu.delateAClub(id)) {
			System.out.println("the club has been eliminated ");
		}else {
			System.out.println("the club no found ");
		}

	}

	private void addPet() {
		try {
		String name = "";
		String id = "";
		String gender;
		String type;
		Club c;
		Client c1;
		int year;
		int m;
		int d;
		boolean cl = false;
		while (!cl) {
			id = reader.nextLine();
			c = new Club(id, null, null, null);
			if (bu.findClubByIdBi(c) == -1) {
				System.out.println("please enter the club id ");
			} else {
				cl = true;
			}
		}
		cl = false;
		c = new Club(id, null, null, null);
		while (!cl) {
			id = reader.nextLine();
			c1 = new Client(id, null, null, null, null);
			if (!bu.costumerExistIdBi(c1) ) {
				System.out.println("please enter the club id ");
			} else {
				cl = true;
			}
		}
		c1 = new Client(id, null, null, null, null);
		System.out.println("please enter the pet id ");
		id = reader.nextLine();
		System.out.println("please enter the PET name ");
		name = reader.nextLine();
		System.out.println("please enter the pet birth year ");
		year = reader.nextInt();
		reader.nextLine();
		System.out.println("please enter the pet birth mounth ");
		m = reader.nextInt();
		reader.nextLine();
		System.out.println("please enter the pet birth day ");
		d = reader.nextInt();
		reader.nextLine();
		
		Date d2 = new Date(year, m, d);
		System.out.println("please enter the pet gender ");
		gender = reader.nextLine();
		System.out.println("please enter the pet type ");
		type = reader.nextLine();
		Pet p = new Pet(id, name, d2, gender, type);
		bu.addPet(c, c1, p);
		}catch (Exception e) {
			System.out.println("please enter the correct data and try again");
		}
		
	}

	private void registerANewClient() {
		
		try {
		String id = "";
		String name = "";
		String lasNa = "";
		String pet = "";
		int year;
		int m;
		int d;
		System.out.println("please enter the club id ");
		boolean cl = false;
		Club c;
		while (!cl) {
			id = reader.nextLine();
			c = new Club(id, null, null, null);
			
			if (bu.findClubByIdBi(c) == -1) {
				System.out.println("please enter the club id ");
			} else {
				cl = true;
			}
		}
		c = new Club(id, null, null, null);
		System.out.println("please enter the customer id ");
		id = reader.nextLine();
		System.out.println("please enter the customer name ");
		name = reader.nextLine();
		System.out.println("please enter the customer last name ");
		lasNa = reader.nextLine();
		System.out.println("please enter the customer큦 birth year ");
		year = reader.nextInt();
		reader.nextLine();
		System.out.println("please enter the customer큦 birth mounth ");
		m = reader.nextInt();
		reader.nextLine();
		System.out.println("please enter the customer큦 birth day ");
		d = reader.nextInt();
		reader.nextLine();
		System.out.println("please enter the costumer큦 favorite type pet ");
		pet = reader.nextLine();
		Date d1 = new Date(year, m, d);
		Client s = new Client(id, name, lasNa, d1, pet);
		bu.registerANewClient(c, s);
		}catch (Exception e) {
			System.out.println("please enter the correct data and try again");
		}
		
	}

	private void registerANewClub() {
		try {
			String id = "";
			String name = "";
			int year = 0;
			int m = 0;
			int d = 0;
			String typePet = "";
			System.out.println("please enter the club id ");
			id = reader.nextLine();
			System.out.println("please enter the club name ");
			name = reader.nextLine();
			System.out.println("please enter the club's founding year ");
			year = reader.nextInt();
			reader.nextLine();
			System.out.println("please enter the club's founding mounth ");
			m = reader.nextInt();
			reader.nextLine();
			System.out.println("please enter the club's founding day ");
			d = reader.nextInt();
			reader.nextLine();
			System.out.println("please enter the type of club mascot ");
			typePet = reader.nextLine();
			Date da = new Date(year, m, d);

			Club c = new Club(id, name, da, typePet);

			if (bu.registerANewClub(c)) {
				System.out.println("the club has been added");
			}

		} catch (Exception e) {
			System.out.println("please enter the correct data and try again");
		}
	}

	public void theGoodbye() {
		System.out.print("see you later");
		System.out.flush();
		System.out.println("");
		System.out.println("");
	}

}
