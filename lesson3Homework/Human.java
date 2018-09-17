package lesson3Homework;

public class Human {
	private String name;
	private String lastName;
	private int age;
	
	public Human(String name, String lastName, int age) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.age = age;
	}

	public Human() {
		super();
	}

	@Override
	public String toString() {
		return lastName + " " + name + ", " +  age + " years old";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	

}
