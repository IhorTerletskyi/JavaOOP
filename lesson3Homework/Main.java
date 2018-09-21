package lesson3Homework;

import java.util.Arrays;

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
		
		best.addStudentFromHuman(vaska);
		System.out.println(best.studentList());
		best.addStudentFromHuman(nobody);
		best.addStudentFromHuman(sidor);
		best.addStudentFromHuman(olya);
		System.out.println(best.studentList());
		
		best.addStudentFromHuman(petya);
		best.addStudentFromHuman(petya);
		System.out.println(best.studentList());
		
		best.deleteStudent(2);
		System.out.println(best.studentList());
		best.addStudentFromHuman(ivan);
		System.out.println(best.studentList());
		
		best.addStudentInteract();
		System.out.println(best.studentList());
		
		best.sortByLastname();
		System.out.println(best.studentList());
		System.out.println(best.recrutCount());
		Student[] recruts = best.recruts();
		for (int i = 0; i < recruts.length; i++) {
			System.out.println("recrut " + i + ": " + recruts[i]);
		}
		
		best.sortByAge();
		System.out.println(best.studentList());
		best.sortByName();
		System.out.println(best.studentList());

	}

}
