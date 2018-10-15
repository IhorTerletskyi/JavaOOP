package lesson8Homework;

public class ClassesBlackList {
	private Class[] classes;
	private int maxSize;
	private int classesQuntity;

	public ClassesBlackList(int maxSize) {
		super();
		this.maxSize = maxSize;
		classes = new Class[maxSize];
		classesQuntity = 0;
	}

	public ClassesBlackList() {
		super();
	}
	
	public boolean isFull() {
		boolean isFull = true;
		if (classesQuntity <= classes.length) {
			return false;
		}
		return isFull;
	}

	public boolean isEmpty() {
		boolean isEmpty = true;
		if (classesQuntity > 0) {
			return false;
		}
		return isEmpty;
	}

	public void add (Class cls) {
		if (isFull()) {
			System.out.println("List is full");
			return;
		}
		classes[classesQuntity] = cls;
		this.classesQuntity++;
	}
	
	public boolean isInBlackList(Class cls) {
		boolean isInBlackList = false;
		for(int i = 0;i<classesQuntity;i++) {
			if (classes[i] == cls) {
				return true;
			}
		}
		return isInBlackList;
	}

}
