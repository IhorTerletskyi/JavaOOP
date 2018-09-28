package lesson5Homework;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		File folderCopyFrom = new File("D:/java_work/Test_folder_from/");
		String folderCopyTo = "D:/java_work/Test_folder_to/";

		MyFileFilter filter = new MyFileFilter("txt");

		File[] filelist = folderCopyFrom.listFiles(filter);

		if (filelist != null) {
			for (File file : filelist) {
				try {
					File fileNew = new File(folderCopyTo + file.getName());
					FileCopy.fileToFileCopy(file, fileNew);
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		} else {
			System.out.println("Not files found");
		}
		
		File fileOne = new File("D:/java_work/Test_folder_from/Test1.txt");
		File fileTwo = new File("D:/java_work/Test_folder_from/Test2.txt");
		File fileNew = new File(folderCopyTo + "TestNew.txt");
		
		CompositeFiles compose = new CompositeFiles(fileOne, fileTwo, fileNew);
		compose.composite();

	}

}
