

package ui;
import java.io.IOException;
import java.util.*;
import model.*;

public class Main {
	
	private Scanner reader;
	private Busnessman bu;
	
	public Main() {
		reader = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		Main execute = new Main();
		execute.menu();
		
		
		
	}
	
	public void showMenuOptions(){
		System.out.println("--------------------------------------- \n");
		System.out.println("1. Register a new club.");
		System.out.println("2. Register a new client.");
		System.out.println("3. Add a pet to an existing client.");
		System.out.println("4. Delate a club.");
		System.out.println("5. Delate a client from a club.");
		System.out.println("6. Delate a pet from a client.");
		System.out.println("7. Delate a pet from a client.");
		System.out.println("7. CHAU ");
		System.out.println("----------------------------------------- \n");
	}
	
	public void menu(){
		int userInput = 0;
		
		//DEPENDENCE
		bu = new Busnessman("Josue Rodriguez");
		
		System.out.println("");
		System.out.println("");

		//WELCOME 	
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Welcome to the best lab in the world");
		System.out.println("enjoy your stay :3");
		System.out.println("-----------------------------------------------------------------");
		while (userInput != 4){

			showMenuOptions();

			System.out.println("------------------------------------------");
			System.out.print("| Type the number of your selection: ");
			try {
				userInput = reader.nextInt();
				reader.nextLine();
				System.out.println("--------------------------------------");
	
				switch (userInput) {
	
					//REGISTER A NEW CLUB
					case 1: 
						registerANewClub();
						break;
	
					//REGISTER A NEW CLIENT
					case 2: 
						registerANewClient();
						break; 
	
	
					//ADD A PET TO AN EXISTING CLIENT
					case 3: 
						addPet(); 
						break;
						
					//ERASE A CLUB FROM THE PROGRAM
					case 4: 
						delateAClub(); 
						break;
						
					//ERASE A CLIENT FROM THE PROGRAM
					case 5: 
						delateAClient(); 
						break;
						
					//ERASE A PET FROM THE PROGRAM
					case 6: 
						delateAPet(); 
						break;
	
					//QUIT PROGRAM
					case 7: 
						theGoodbye();
						break;
	
					default:
						System.out.println();
						System.out.println("Please type a number between 1 and 7");
						System.out.println();
						break;
					
				}
			} catch(InputMismatchException e){
				System.out.println();
				System.out.print("ERROR: Invalid option");
				reader.nextLine();
				System.out.println();
			}

		}
		
	}
		
		private void delateAPet() {
		// TODO Auto-generated method stub
		
	}

		private void delateAClient() {
		// TODO Auto-generated method stub
		
		}

		private void delateAClub() {
		// TODO Auto-generated method stub
		
		}

		private void addPet() {
		// TODO Auto-generated method stub
		
		}

		private void registerANewClient() {
		// TODO Auto-generated method stub
		
		}

		 private void registerANewClub() {
		// TODO Auto-generated method stub
		
		 }

		

		public void theGoodbye() {
			System.out.print("see you later");  
			System.out.flush(); 
			System.out.println("");
			System.out.println("");
		}
		
	

}
