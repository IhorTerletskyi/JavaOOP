package lesson10HomeworkASCII;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File fileFrom = new File("D:/java_work/Test_folder_from/letters.txt");
		Letters lets = new Letters();
		
		lets.addFromFile(8, fileFrom);
		
		
		
		lets.printLetter('C');

	}

}
