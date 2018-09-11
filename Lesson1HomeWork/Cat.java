package Lesson1HomeWork;

public class Cat {
	private String color;
	private int age;
	private double weight;
	
	public Cat(String color, int age, double weight) {
		super();
		this.color = color;
		this.age = age;
		this.weight = weight;
	}

	public Cat() {
		super();
		// TODO Auto-generated constructor stub
	}

		
	public void speak() {
		System.out.println("Mrrr-Meow");
	}
	
	public void eat(double foodWeight) {
		weight += foodWeight;
	}
	
	public void doCrap() {
		System.out.println();
		System.out.println("  @  ");
		System.out.println(" @@@ ");
		System.out.println("@@@@@");
		System.out.println();
		if (age < 2) {
		    weight -= 0.01;
		} else {
			weight -= 0.03;
		}
	}
	
	public void running() {
		weight *= 0.999;
	}
	
	public Cat love(Cat friend) {
		return new Cat(this.color + "-" + friend.color, 0, 0.3);
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Cat [color=" + color + ", age=" + age + ", weight=" + weight + "]";
	}
	

}
