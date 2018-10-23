package lesson10HomeworkASCII;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Letters {
	private Map<Character, Letter> letters = new HashMap<>();

	public Letters() {
		super();
	}

	public void add(Character key, String[] strings) {
		this.letters.put(key, new Letter(strings));
	}

	public void addFromFile(int letterSize, File fileFrrom) {
		String[] tempLetter = new String[letterSize];
		try {
			Scanner scan = new Scanner(fileFrrom);
			for (; scan.hasNextLine();) {
				Character tempChar = scan.nextLine().charAt(0);
				for (int i = 0; i < letterSize; i++) {
					if (scan.hasNextLine()) {
						tempLetter[i] = scan.nextLine();
					}
				}
				add(tempChar,tempLetter);
				printLetter(tempChar);
				printLetter('A');
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void printLetter(Character chr) {
		letters.get(chr).print();
	}
	
	public void printText(String text) {
		char[] chr = text.toCharArray();
		int letterSize = 8;
		for (int i = 0; i < letterSize; i++) {
			for (int j=0;j<chr.length;j++) {
				Letter temp = letters.get(chr[j]);
				String[] temptemp = temp.getStrings();
				System.out.print(temptemp[i] + " ");
			}
			System.out.println();
		}
	}

}
