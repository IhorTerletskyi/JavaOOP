package lesson10HomeworkASCII;

import java.util.Arrays;

public class Letter {
	private String[] strings;

	public Letter(String[] strings) {
		super();
		this.strings = strings;
	}

	public Letter() {
		super();
	}
	
	public void print() {
		for(int i=0; i<this.strings.length;i++) {
			System.out.println(strings[i]);
		}
	}
	
	@Override
	public String toString() {
		return "Letter [strings=" + Arrays.toString(strings) + "]";
	}

	public String[] getStrings() {
		return strings;
	}

	public void setStrings(String[] strings) {
		this.strings = strings;
	}
	
	

}
