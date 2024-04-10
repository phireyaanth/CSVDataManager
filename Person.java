
public class Person {
	private int age;
	private double height;
	private double weight;
	private String name;
	private String gender;
	
	public Person(int age, double height, double weight, String name, String gender) {
		this.age = age;
		this.height = height; 
		this.weight = weight;
		this.name = name;
		this.gender = gender; 
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public double getWeight() {
		return this.weight;
	}
	
	public String getName() {
		return this.name;
	}
	public String getGender() {
		return this.gender;
	}
	
	public String toString() {
		return "Name: " + name + " Age: " + age + " Height: " + height + " Weight: " + weight + 
	" Gender: " + gender;
	}
	
	public String[] toCommas() {
		String[] str = {this.name, String.valueOf(this.age), String.valueOf(this.height), String.valueOf(this.height), this.gender};
		return str;
	}
	
	

}
