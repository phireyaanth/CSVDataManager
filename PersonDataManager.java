import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PersonDataManager {
	private Person[] people;
	private static int ppl;

	
	public static void main(String[] args) {
		/*
		System.out.println("Enter the file path: ");
		Scanner input = new Scanner(System.in);
		String loco = input.nextLine();
		buildFromFile(loco);
		*/
    
        	
	}
	
	public void setPeople(Person[] people) {
		this.people = people;
	}
	
	public Person[] getPeople() {
		return this.people;
	}

	public static Person[] buildFromFile(String location) {
		String path = "/Users/poobalarp/Downloads/";
		path += location;
		String line = "";
		int count = 0;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			while((line = br.readLine()) != null) {
				String[] values = line.split(",");
				count++;
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Person[] pc_holder = new Person[count-1];
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			int counter = 0;
			while((line = br.readLine()) != null) {
				if (counter>0){
					String[] values = line.split(",");
					//System.out.println(values[0]);
					values[1] = values[1].replace(" ", "");
					values[1] = values[1].replace("\"", "");
					
					pc_holder[counter-1] = new Person(Integer.parseInt(values[2]), Double.parseDouble(values[3]), Double.parseDouble(values[4]), values[0], values[1]);
				}
				counter++;
				
				
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		ppl = count - 1;
		return pc_holder;
	
	}
	
	public void addPerson(Person newPerson) throws PersonAlreadyExistsException {
		if(people[people.length - 1] != null) {
			Person[] BiggerArray = new Person[people.length*2];
			System.arraycopy(people, 0, BiggerArray, 0, people.length-1);
			people = BiggerArray;
		
		}
		for(int i = 0; i < people.length; i++) {
			
			if(people[i] != null && people[i].getName().equals(newPerson.getName())) {
				if(people[i].getAge() == newPerson.getAge() && people[i].getGender().equals(newPerson.getGender()) 
						&& people[i].getHeight() == newPerson.getHeight()
						&& people[i].getWeight() == newPerson.getWeight()) {
					System.out.println("This Person Already Exists");
					throw new PersonAlreadyExistsException("This Person Already Exists");
					}
				
				}	
			}
		int counter = 0;
		for(int i = 0; i < people.length; i++) {
			if(people[i] == null && counter == 0) {
				people[i] = newPerson;
				counter++;
			}
		}	
	}
	
	public void getPerson(String name) throws PersonAlreadyExistsException {
			for(int i = 0; i < people.length; i++) {
				if(people[i].getName() == name) {
					System.out.println(people[i].toString());
				}
				else {
					throw new PersonAlreadyExistsException("This Person Does Not Exist");
				}
			}
		}
	
	public void removePerson(String name) {
		for(int i = 0; i< people.length; i++) {
			if(people[i] != null && people[i].getName().equals(name)) {
				people[i] = null;
			}
		}
	}
		
		

	
	public void printTable() {
		System.out.println(String.format("%20s %20s %20s %20s %20s %20s %20s %20s %20s","Name", "|", "Age", "|", "Gender", "|", "Height", "|", "Weight"));
        System.out.println(String.format("%s", "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"));
        
        for(int i = 0; i < people.length; i++) {
        	if(people[i] != null) {
        		String height = (int) people[i].getHeight()/12 + " feet " + (int) people[i].getHeight()%12 + " inches";
        		String weight = people[i].getWeight() + " pounds";
    		System.out.println(String.format("%20s %20s %20s %20s %20s %20s %20s %20s %20s", people[i].getName(), "|", people[i].getAge(), "|", people[i].getGender(), "|", height, "|", weight));
        	}
        }
	}
	
}


