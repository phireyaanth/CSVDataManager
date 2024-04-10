import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonManager extends PersonDataManager{

	public static void main(String[] args) {
		PersonDataManager persons = new PersonDataManager();

		System.out.printf("(I) - Import from File" + "\n" + "(A) - Add Person" + "\n" + "(R) - Remove Person" + "\n" + "(G) - Get Info on Person" + 
				"\n" + "(P) - Print Table" + "\n" + "(S) - Save Table" + "\n" + "(Q) - Quit");
		System.out.println("");
		System.out.println("");

		Scanner input = new Scanner(System.in);
		String user = input.nextLine();
		
		while(user != "Q") {
		
			switch(user) {
				case ("I"):
					System.out.println("Enter the file Below: ");
					String loco = input.nextLine();
					persons.setPeople(buildFromFile(loco));
					System.out.println("File Imported Successfully");

					
					System.out.printf("(I) - Import from File" + "\n" + "(A) - Add Person" + "\n" + "(R) - Remove Person" + "\n" + "(G) - Get Info on Person" + 
							"\n" + "(P) - Print Table" + "\n" + "(S) - Save Table" + "\n" + "(Q) - Quit");
					System.out.println("");
					System.out.println("");
					user = input.nextLine();
					break;
				case ("A"):
					System.out.println("Enter Name of Person: ");
					String name = input.nextLine();
					System.out.println("Enter Gender of Person: ");
					String gender = input.nextLine();
					System.out.println("Enter Age of Person: ");
					int age = input.nextInt();
					System.out.println("Enter Height of Person: ");
					double height = input.nextDouble();
					System.out.println("Enter Weight of Person: ");
					double weight = input.nextDouble();
					
				

			
					Person newPerson = new Person(age, height, weight, name, gender);
					try {
						persons.addPerson(newPerson);
						System.out.println("Person Added Successfully");
					} catch (PersonAlreadyExistsException e) {
						e.getMessage("This Person Already Exists");
					}
					
					
					System.out.printf("(I) - Import from File" + "\n" + "(A) - Add Person" + "\n" + "(R) - Remove Person" + "\n" + "(G) - Get Info on Person" + 
							"\n" + "(P) - Print Table" + "\n" + "(S) - Save Table" + "\n" + "(Q) - Quit");
					System.out.println("");
					System.out.println("");

					user = input.nextLine();
					
					break;
			
				case ("R"):
					
					
					System.out.println ("Which Person do you want to remove: ");
					String name_to_remove = input.nextLine();
					
					Person delete = null;
					for(int i = 0; i < persons.getPeople().length; i++) {
						
						if(persons.getPeople()[i] != null && name_to_remove.equals(persons.getPeople()[i].getName())) {
							delete = persons.getPeople()[i];
						}
						
					}
					
					
				if(delete == null) {
					throw new PersonDoesNotExistsException("This Person Does Not Exist");

				}
					persons.removePerson(delete.getName());
				
					
					
					System.out.printf("(I) - Import from File" + "\n" + "(A) - Add Person" + "\n" + "(R) - Remove Person" + "\n" + "(G) - Get Info on Person" + 
							"\n" + "(P) - Print Table" + "\n" + "(S) - Save Table" + "\n" + "(Q) - Quit");
					System.out.println("");
					System.out.println("");

					user = input.nextLine();
					
					break;
			
				case ("G"):
					System.out.println("Enter the Name of Person:");
					String info = input.nextLine();
					Person getinfo = null;
					for(int i = 0; i < persons.getPeople().length; i++) {
						if(persons.getPeople()[i] != null && info.equals(persons.getPeople()[i].getName())) {
						getinfo = persons.getPeople()[i];
						}
					}
					System.out.println(getinfo.toString());
					
					System.out.printf("(I) - Import from File" + "\n" + "(A) - Add Person" + "\n" + "(R) - Remove Person" + "\n" + "(G) - Get Info on Person" + 
							"\n" + "(P) - Print Table" + "\n" + "(S) - Save Table" + "\n" + "(Q) - Quit");
					System.out.println("");
					System.out.println("");

					user = input.nextLine();
					
					break;
				
				case ("P"):
					persons.printTable();
					System.out.printf("(I) - Import from File" + "\n" + "(A) - Add Person" + "\n" + "(R) - Remove Person" + "\n" + "(G) - Get Info on Person" + 
							"\n" + "(P) - Print Table" + "\n" + "(S) - Save Table" + "\n" + "(Q) - Quit");
					System.out.println("");
					System.out.println("");

					user = input.nextLine();	
				
					break;
				case ("S"):
					System.out.println("Enter the new File name: ");
					String csvFilePath = input.nextLine();

				try (FileWriter fileWriter = new FileWriter(csvFilePath);
				     BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

				    // Iterate through the data and write each row to the CSV file
				    for (int i = 0; i < persons.getPeople().length;i++ ) {
				    	if(persons.getPeople()[i] != null) {
				    		String rowString = String.join(",", persons.getPeople()[i].toCommas());
				    		bufferedWriter.write(rowString);
				    		bufferedWriter.newLine(); // Move to the next line
				    	}
				    }

				    System.out.println("CSV file created successfully.");
				} catch (IOException e) {
				    e.printStackTrace();
				}
					
					System.out.printf("(I) - Import from File" + "\n" + "(A) - Add Person" + "\n" + "(R) - Remove Person" + "\n" + "(G) - Get Info on Person" + 
							"\n" + "(P) - Print Table" + "\n" + "(S) - Save Table" + "\n" + "(Q) - Quit");
					System.out.println("");
					System.out.println("");

					user = input.nextLine();
					break;
				case("Q"):
					System.out.println("Sorry to see you go, Goodbye!");
					System.out.println("");
					user = input.nextLine();

					input.close();
					break;
				
				default: 
					System.out.printf("(I) - Import from File" + "\n" + "(A) - Add Person" + "\n" + "(R) - Remove Person" + "\n" + "(G) - Get Info on Person" + 
							"\n" + "(P) - Print Table" + "\n" + "(S) - Save Table" + "\n" + "(Q) - Quit");
					System.out.println("");
					
					user = input.nextLine();
					break;
			}	
			
			
			
		
		}
		
		
		
    
        	
	}

}
