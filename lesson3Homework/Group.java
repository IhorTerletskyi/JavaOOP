package lesson3Homework;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Group implements Voenkom {
	private String name;
	private Student[] students = new Student[10];

	public Group(String name) {
		super();
		this.name = name;
	}

	public Group() {
		super();
	}

	public boolean isGroupFull() {
		boolean full = true;
		for (int i = 0; i < students.length; i++) {
			if (this.students[i] == null) {
				full = false;
				break;
			}
		}
		return full;
	}

	public int freePlace() {
		int free = 0;
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				free = i;
				break;
			}
		}
		return free;
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
		int studentPlace = freePlace();
		students[studentPlace] = new Student(name, lastName, age, recordBookNumber, groupNumber);
	}

	public void addStudentInteract() {
		String lastname = null;
		String name = null;
		int age = 0;

		try {
			if (isGroupFull()) {
				throw new MoreTenStudensException();
			} else {
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
			}
			int studentPlace = freePlace();
			students[studentPlace] = new Student(name, lastname, age, this.getName(), this.getName());
			String recordBook = students[studentPlace].getRecordBookNumber() + "-" + students[studentPlace].hashCode();
			students[studentPlace].setRecordBookNumber(recordBook);

		} catch (MoreTenStudensException e) {
			System.out.println(e.toString());
		}
	}

	public void addStudentFromHuman(Human human) {
		try {
			if (isGroupFull()) {
				throw new MoreTenStudensException();
			}
			if (human.getName() == null || human.getLastName() == null) {
				throw new NoHumanNameException();
			}
			if (human.getAge() < 16) {
				throw new SoYoungException();
			}
			String recordBook = this.name + "-" + human.hashCode();
			students[freePlace()] = new Student(human, recordBook, this.name);

		} catch (MoreTenStudensException e) {
			System.out.println(e.toString());
		} catch (NoHumanNameException e) {
			System.out.println(e.toString());
		} catch (SoYoungException e) {
			System.out.println(e.toString());
		}

	}

	public void deleteStudent(int number) {
		if (number < 0 || number > (students.length - 1)) {
			System.out.println("Number error");
		} else {
			if (students[number] == null) {
				System.out.println("this place already free");
			} else {
				students[number] = null;
			}
		}
	}

	public String searchStudent(String lastname) {
		String searchResult = "No student found";
		for (int i = 0; i < students.length; i++) {
			if (lastname.equalsIgnoreCase(students[i].getLastName())) {
				searchResult = students[i].toString();
				break;
			}
		}
		return searchResult;
	}

	private int lastNoNullNumber() {
		int last = 0;
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				last = i;
			}
		}
		return last;
	}

	private int nullCounter() {
		int nullCounter = 0;
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				nullCounter++;
			}
		}
		return nullCounter;
	}

	public void nullToEnd() {
		for (int i = 0; i < students.length; i++) {
			if ((nullCounter() != students.length) && (lastNoNullNumber() != (students.length - 1 - nullCounter()))) {
				if (students[i] == null) {
					students[i] = students[lastNoNullNumber()];
					students[lastNoNullNumber()] = null;
				}
			} else {
				break;
			}
		}
	}

	public void sortByLastname() {
		nullToEnd();
		Arrays.sort(students, 0, lastNoNullNumber() + 1);
	}

	public void sortByAge() {
		Arrays.sort(students,
				(first, second) -> NullCheck.check(first, second) != NullCheck.NOT_NULL ? NullCheck.check(first, second)
						: first.getAge() - second.getAge());
	}

	public void sortByName() {
		Arrays.sort(students,
				(first, second) -> NullCheck.check(first, second) != NullCheck.NOT_NULL ? NullCheck.check(first, second)
						: first.getName().compareTo(second.getName()));
	}

	public String studentList() {
		StringBuilder sb = new StringBuilder();

		if (nullCounter() == students.length) {
			sb.append("Group is empty");
		} else {
			for (int i = 0; i <= lastNoNullNumber(); i++) {
				if (students[i] != null) {
					sb.append(i + ".");
					sb.append(students[i].toString());
					sb.append(System.lineSeparator());
				}
			}
			sb.append("free places = " + nullCounter());
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
		if (nullCounter() == students.length) {
			return total;
		}
		for (int i = 0; i < students.length; i++) {
			if (isRecrut(students[i])) {
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
			for (int i = 0; i < students.length; i++) {
				if (isRecrut(students[i])) {
					recruts[counter] = students[i];
					counter++;
				}
			}
			return recruts;
		}
		return null;
	}
	
	public File saveToFile (String pathToSave) {
		File file = new File(pathToSave + "/" + this.name + ".txt");		
		try (PrintWriter write = new PrintWriter(file)) {
//			write.println(students.length + ",");
			if (nullCounter() != students.length) {
				for (Student student:students) {
					if (student != null) {
						write.println(student.getName() + "," + student.getLastName() + "," + student.getAge() + "," + student.getRecordBookNumber());
					}
				}
			} else {
				System.out.println("Group is empty!");
			}
			
		} catch (IOException e) {
			System.out.println(e);
		}
		
		return file;
	}
	
	public static Group groupFromFile (File fileFrom, String newGroupName) {
		Group newGrope = new Group(newGroupName);
		try {
			Scanner scan = new Scanner(fileFrom);
			for (;scan.hasNextLine();) {
				if (!newGrope.isGroupFull()) {
					String [] studentInfo = scan.nextLine().split(",");
					newGrope.addStudent(studentInfo[0], studentInfo[1], Integer.parseInt(studentInfo[2]), studentInfo[3], newGroupName);
				} else {
					System.out.println("Groupe is full!");
				}
			}
			
		} catch (IOException e) {
			System.out.println(e);
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
