package lesson3Homework;

public class Group {
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
		for (int i = 0; i < 10; i++) {
			if (this.students[i] == null) {
				full = false;
				break;
			}
		}
		return full;
	}
	
	public int freePlace() {
		int free = 0;
		for (int i = 0; i < 10; i ++) {
			if (students[i] == null) {
				free = i;
				break;
			}
		}
		return free;
	}

	public void addStudent(Human human) {
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
			String recordBook = this.name + "-" + freePlace();
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
		if (number < 0 || number > 9) {
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
		for (int i = 0; i < 10; i ++) {
			if (lastname.equalsIgnoreCase(students[i].getLastName())) {
				searchResult = students[i].toString();
				break;
			}
		}
		return searchResult;
	}
	
	private int lastNoNullNumber() {
		int last = 0;
		for (int i = 0; i < 10; i++) {
			if (students[i] != null) {
				last = i;
			}
		}
		return last;
	}
	
	private int nullCounter() {
		int nullCounter = 0;
		for (int i = 0; i < 10; i++) {
			if (students[i] == null) {
				nullCounter++;
			}			
		}
		return nullCounter;
	}
	
	public void sortByLastname() {		
		for (int i = 0; i < 10; i++) {
			 if ((nullCounter() != 10) && (lastNoNullNumber() != 9 - nullCounter())) {
				if (students[i] == null) {
					students[i] = students[lastNoNullNumber()];
					students[lastNoNullNumber()] = null;
				}
			} else {
				break;
			}
		}
		
		if (nullCounter() != 10) {
			for (int i = 0; i <= lastNoNullNumber(); i++) {
				for (int j = i + 1; j <= lastNoNullNumber(); j++) {
					if (students[j].getLastName().compareTo(students[i].getLastName()) < 0) {
						Student temp = students[j];
						students[j] = students[i];
						students[i] = temp;
					}
				}
			}
		}
	}
	
	public String studentList() {
		StringBuilder sb = new StringBuilder();
		sortByLastname();
		
		if (nullCounter() == 10) {
			sb.append("Group is empty");
		} else {
			for (int i = 0; i <= lastNoNullNumber(); i++) {
				sb.append(i);
				sb.append(students[i].toString());
				sb.append(System.lineSeparator());
			}
			sb.append("free places = " + nullCounter());
		}
		return sb.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
