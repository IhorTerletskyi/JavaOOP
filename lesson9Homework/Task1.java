package lesson9Homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> array = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			array.add(i * 5);
		}
		array.remove(0);
		array.remove(0);
		array.remove(array.size() - 1);
		
		System.out.println(Arrays.toString(array.toArray()));
		
	}

}
