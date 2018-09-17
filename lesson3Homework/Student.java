package lesson3Homework;

public class Student extends Human {
	private String recordBookNumber;
	private String groupNumber;
	
	public Student(Human human, String recordBookNumber, String groupNumber) {
		super(human.getName(), human.getLastName(), human.getAge());
		this.recordBookNumber = recordBookNumber;
		this.groupNumber = groupNumber;
	}

	public Student() {
		super ();
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
