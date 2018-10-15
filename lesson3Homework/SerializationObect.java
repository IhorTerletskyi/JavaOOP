package lesson3Homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class SerializationObect {

	public static void serializableToFile(Object obj, File file) throws IOException {

		try (ObjectOutput oos = new ObjectOutputStream(new FileOutputStream(file))) {

			oos.writeObject(obj);

		} catch (IOException e) {
			throw e;
		}

	}

	public static Object deserializationFromFile(File file) throws IOException, ClassNotFoundException {

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
			return ois.readObject();
		} catch (IOException e) {
			throw e;
		}
	}

}
