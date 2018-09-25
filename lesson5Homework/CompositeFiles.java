package lesson5Homework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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

	public String fileToString(File file) throws IOException {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader read = new BufferedReader(new FileReader(fileOne))) {
			String readString;
			for (; (readString = read.readLine()) != null;) {
				sb.append(readString);
			}
		} catch (IOException e) {
			System.out.println("Error!");
		}
		return sb.toString();
	}

	public static void composite() {
		String[] wordsFileOne = new String(fileToString(fileOne)).split(" ");
		String[] wordsFileTwo = new String(fileToString(fileTwo)).split(" ");

		for (int i = 0; i < wordsFileOne.length; i++) {
			for (int j = 0; j < wordsFileTwo.length; j++) {
				try (BufferedWriter write = new BufferedWriter(new FileWriter(fileNew), true)) {
					if (wordsFileOne[i].equalsIgnoreCase(wordsFileTwo[j])) {
						write.write(wordsFileOne[j]);
					}

				} catch (IOException e) {
					System.out.println("Error!");
				}
			}
		}

	}

}
