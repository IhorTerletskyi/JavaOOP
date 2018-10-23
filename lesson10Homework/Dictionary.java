package lesson10Homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dictionary implements Serializable {
	private Map<String, String> dictionary = new HashMap<>();

	public Dictionary() {
		super();
	}

	public void add(String key, String value) {
		this.dictionary.put(key, value);
	}

	public void addInteract() {
		String word = stringParametrEnter("foregin word");
		String translation = stringParametrEnter("this word translation");
		this.dictionary.put(word, translation);
	}

	private String stringParametrEnter(String parameterName) {
		String stringParameter = null;
		Scanner scan = new Scanner(System.in);

		for (;;) {
			System.out.printf("Enter %s:", parameterName);
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

	public void translateFile(File fileFrom, File fileTo) {
		try (PrintWriter write = new PrintWriter(fileTo)){
			Scanner scan = new Scanner(fileFrom);
			;
			for (; scan.hasNextLine();) {
				String[] words = scan.nextLine().split(" ");
				String[] translatedWords = tranclateArray(words);
				for (String word : translatedWords) {
					write.print(word + " ");
				}
				write.println();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String[] tranclateArray(String[] words) {
		String[] translatedWords = new String[words.length];
		for (int i = 0; i < words.length; i++) {
			if (this.dictionary.get(words[i]) != null) {
				translatedWords[i] = this.dictionary.get(words[i]);
			} else {
				translatedWords[i] = words[i];
			}
		}
		return translatedWords;
	}

	public void saveDictionaryToFile(File file) throws IOException {
		try (ObjectOutput oos = new ObjectOutputStream(new FileOutputStream(file))) {
			oos.writeObject(this);
		} catch (IOException e) {
			throw e;
		}
	}

	public static Dictionary readFromFile(File file) throws IOException, ClassNotFoundException {
		Dictionary dict = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
			dict = (Dictionary) ois.readObject();
		} catch (IOException e) {
			throw e;
		}
		return dict;
	}

	@Override
	public String toString() {
		return "Dictionary [dictionary=" + dictionary + "]";
	}

}
