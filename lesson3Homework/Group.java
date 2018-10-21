package lesson3Homework;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Group implements Voenkom, Serializable {
	private String name;
	private List<Student> students = new ArrayList<>();

	public Group(String name) {
		super();
		this.name = name;
	}

	public Group() {
		super();
	}

	public String stringParametrEnter(String parameterName) {
		String stringParameter = null;
		Scanner scan = new Scanner(System.in);

		for (;;) {
			System.out.printf("Enter new student %s:", parameterName);
			stringParameter = scan.nextLine();
			if (stringParameter.isEmpty()) {
				System.out.printf("Wrong %c!", parameterName);
				System.out.println();
			} else {
				break;
			}
		}
		return stringParameter;
	}

	public int intParametrEnter(String parameterName) {
		int intParameter = 0;
		Scanner scan = new Scanner(System.in);

		for (;;) {
			try {
				System.out.printf("Enter new student %s:", parameterName);
				intParameter = scan.nextInt();
			} catch (InputMismatchException e) {
				System.out.printf("Wrong %c!", parameterName);
				scan.nextLine();
				continue;
			}
			break;
		}
		return intParameter;
	}

	public void addStudent(String name, String lastName, int age, String recordBookNumber, String groupNumber) {
		students.add(new Student(name, lastName, age, recordBookNumber, groupNumber));
	}

	public void addStudentInteract() {
		String lastname = null;
		String name = null;
		int age = 0;

		try {
			name = stringParametrEnter("name");
			lastname = stringParametrEnter("lastname");
			age = intParametrEnter("age");
			if (age < 16) {
				throw new SoYoungException();
			}
		} catch (SoYoungException e) {
			System.out.println(e.toString());
			return;
		}
		Student stud = new Student(name, lastname, age, this.getName(), this.getName());
		String recordBook = stud.getRecordBookNumber() + "-" + stud.hashCode();
		students.add(stud);
	}

	public void addStudentFromHuman(Human human) {
		try {
			if (human.getName() == null || human.getLastName() == null) {
				throw new NoHumanNameException();
			}
			if (human.getAge() < 16) {
				throw new SoYoungException();
			}
			String recordBook = this.name + "-" + human.hashCode();
			Student stud = new Student(human, recordBook, this.name);
			students.add(stud);

		} catch (NoHumanNameException e) {
			System.out.println(e.toString());
		} catch (SoYoungException e) {
			System.out.println(e.toString());
		}

	}

	public void deleteStudent(int number) {
		if (number < 0 || number > (students.size() - 1)) {
			System.out.println("Number error");
			return;
		}
		students.remove(number);
	}

	public String searchStudent(String lastname) {
		String searchResult = "No student found";
		for (int i = 0; i < students.size(); i++) {
			if (lastname.equalsIgnoreCase(students.get(i).getLastName())) {
				searchResult = students.get(i).toString();
				break;
			}
		}
		return searchResult;
	}

//	public void sortByLastname() {
//		Arrays.sort(students);
//	}
//
//	public void sortByAge() {
//		Arrays.sort(students,
//				(first, second) -> NullCheck.check(first, second) != NullCheck.NOT_NULL ? NullCheck.check(first, second)
//						: first.getAge() - second.getAge());
//	}
//
//	public void sortByName() {
//		Arrays.sort(students,
//				(first, second) -> NullCheck.check(first, second) != NullCheck.NOT_NULL ? NullCheck.check(first, second)
//						: first.getName().compareTo(second.getName()));
//	}

	public String studentList() {
		StringBuilder sb = new StringBuilder();

		if (students.size() == 0) {
			sb.append("Group is empty");
		} else {
			for (int i = 0; i < students.size(); i++) {
				sb.append(i + ".");
				sb.append(students.get(i).toString());
				sb.append(System.lineSeparator());
				
			}
		}
		return sb.toString();
	}

	@Override
	public boolean isRecrut(Student student) {
		if (student != null && student.getAge() > 19 && student.getAge() < 29) {
			return true;
		}
		return false;
	}

	@Override
	public int recrutCount() {
		int total = 0;
		for (int i = 0; i < students.size(); i++) {
			if (isRecrut(students.get(i))) {
				total++;
			}
		}
		return total;
	}

	@Override
	public Student[] recruts() {
		if (recrutCount() != 0) {
			Student[] recruts = new Student[recrutCount()];
			int counter = 0;
			for (int i = 0; i < students.size(); i++) {
				if (isRecrut(students.get(i))) {
					recruts[counter] = students.get(i);
					counter++;
				}
			}
			return recruts;
		}
		return null;
	}

	public File saveToFile(String pathToSave) {
		File file = new File(pathToSave + "/" + this.name + ".txt");
		SerializationObect so = new SerializationObect();
		try {
			so.serializableToFile(this, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return file;
	}

	public static Group groupFromFile(File fileFrom) {
		Group newGrope = null;
		SerializationObect so = new SerializationObect();
		try {
			newGrope = (Group) so.deserializationFromFile(fileFrom);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newGrope;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
