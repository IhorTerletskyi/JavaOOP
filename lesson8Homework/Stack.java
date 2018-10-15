package lesson8Homework;

import java.util.Arrays;

public class Stack {
	private Object[] objects;
	private int maxSize;
	private int nextNewElement;

	public Stack(int maxSize) {
		super();
		this.maxSize = maxSize;
		objects = new Object[maxSize];
		nextNewElement = 0;
	}

	public Stack() {
		super();
	}

	public boolean isFull() {
		boolean isFull = true;
		if (nextNewElement < objects.length) {
			return false;
		}
		return isFull;
	}

	public boolean isEmpty() {
		boolean isEmpty = true;
		if (nextNewElement > 0) {
			return false;
		}
		return isEmpty;
	}

	public void add(Object obj) {
		if (isFull()) {
			System.out.println("Stack is full");
			return;
		}
		objects[nextNewElement] = obj;
		this.nextNewElement++;
	}
	
	public void add(Object obj, ClassesBlackList cbl) {
		if (cbl.isInBlackList(obj.getClass())) {
			System.out.println("Wrong Class");
			return;
		}
		if (isFull()) {
			System.out.println("Stack is full");
			return;
		}
		objects[nextNewElement] = obj;
		this.nextNewElement++;
	}

	public Object read() {
		Object current;
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return null;
		}
		current = objects[nextNewElement - 1];
		return current;
	}

	public void delete() {
		if (isEmpty()) {
			return;
		}
		objects[nextNewElement - 1] = null;
		nextNewElement--;
	}
	
	public Object take() {
		Object current;
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return null;
		}
		current = objects[nextNewElement - 1];
		delete();
		return current;
	}

	@Override
	public String toString() {
		return "Stack [objects=" + Arrays.toString(objects) + ", maxSize=" + maxSize + ", currentElementNumber="
				+ nextNewElement + "]";
	}

	public int getMaxSize() {
		return maxSize;
	}

	public int getNextNewElement() {
		return nextNewElement;
	}
	
	

}
