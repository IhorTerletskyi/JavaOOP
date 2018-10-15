package lesson3Homework;

import java.io.Serializable;

public class Student extends Human implements Comparable, Serializable {
	private String recordBookNumber;
	private String groupNumber;
	
	public Student(String name, String lastName, int age, String recordBookNumber, String groupNumber) {
		super(name, lastName, age);
		this.recordBookNumber = recordBookNumber;
		this.groupNumber = groupNumber;
	}

	public Student(Human human, String recordBookNumber, String groupNumber) {
		super(human.getName(), human.getLastName(), human.getAge());
		this.recordBookNumber = recordBookNumber;
		this.groupNumber = groupNumber;
	}

	public Student() {
		super ();
	}
	

	@Override
	public int compareTo(Object another) {
		Student anotherStudent = (Student) another;
		if (this.getLastName().compareTo(anotherStudent.getLastName()) > 0) {
			return 1;
		}
		if (this.getLastName().compareTo(anotherStudent.getLastName()) < 0) {
			return -1;
		}
		
		return 0;
	}

	@Override
	public String toString() {
		return super.toString() + ", study in " + groupNumber + ", record-book N " + recordBookNumber ;
	}

	public String getRecordBookNumber() {
		return recordBookNumber;
	}

	public void setRecordBookNumber(String recordBookNumber) {
		this.recordBookNumber = recordBookNumber;
	}

	public String getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(String groupNumber) {
		this.groupNumber = groupNumber;
	}
	
	
	
	

}
