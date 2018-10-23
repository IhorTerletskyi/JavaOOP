package lesson10Homework;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath = "D:/java_work/Test_folder_to/";
		File fileFrom = new File(filePath + "test1.txt");
		File fileTo = new File(filePath + "translate.txt");
		File fileDict = new File(filePath + "Rus-Eng.dct");
		
		Dictionary dict = new Dictionary();
		Dictionary dictTwo = new Dictionary();
		dict.add("I", "Я");
		dict.add("school", "школа");
		dict.add("go", "идти");
		dict.add("cat", "кот");
		dict.add("dog", "собака");
		
		dict.addInteract();
		
		try {
			dict.saveDictionaryToFile(fileDict);
			dictTwo = Dictionary.readFromFile(fileDict);
			dictTwo.translateFile(fileFrom, fileTo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
