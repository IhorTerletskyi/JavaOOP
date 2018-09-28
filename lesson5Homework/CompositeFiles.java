package lesson5Homework;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CompositeFiles {
	private File fileOne;
	private File fileTwo;
	private File fileNew;

	public CompositeFiles(File fileOne, File fileTwo, File fileNew) {
		super();
		this.fileOne = fileOne;
		this.fileTwo = fileTwo;
		this.fileNew = fileNew;
	}

	public String[] fileToStringArray(File file) throws IOException {
		StringBuilder sb = new StringBuilder();
		try (Scanner scan = new Scanner(file)) {
			for (; scan.hasNextLine();) {
				sb.append(scan.nextLine());
				sb.append(" ");
			}
		} catch (IOException e) {
			System.out.println("Error!");
		}
		return sb.toString().split(" ");
	}

	public void composite() {
		String[] wordsFileOne;
		String[] wordsFileTwo;

		try (PrintWriter write = new PrintWriter(fileNew)) {
			wordsFileOne = fileToStringArray(fileOne);
			wordsFileTwo = fileToStringArray(fileTwo);

			for (int i = 0; i < wordsFileOne.length; i++) {
				for (int j = 0; j < wordsFileTwo.length; j++) {
					if (wordsFileOne[i].equalsIgnoreCase(wordsFileTwo[j])) {
						write.println(wordsFileOne[i] + " ");
					}
				}
			}
		} catch (IOException e) {
			System.out.println("Error!");
		}

	}

}
