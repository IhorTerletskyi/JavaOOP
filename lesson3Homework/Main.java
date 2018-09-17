package lesson3Homework;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human vaska = new Human("Vasya", "Vasilev", 15);
		Human ivan = new Human("Ivan", "Ivanov", 23);
		Human petya = new Human("Petr", "Petrov", 32);
		Human olya = new Human("Olga", "Olgova", 18);
		Human sidor = new Human("Sidor", "Sidorov", 26);
		Human nobody = new Human();
		
		Group best = new Group("best");
		
		best.addStudent(vaska);
		System.out.println(best.studentList());
		best.addStudent(nobody);
		best.addStudent(sidor);
		best.addStudent(olya);
		System.out.println(best.studentList());
		
		best.addStudent(petya);
		best.addStudent(petya);
		System.out.println(best.studentList());
		
		best.deleteStudent(2);
		System.out.println(best.studentList());
		best.addStudent(ivan);
		System.out.println(best.studentList());

	}

}
