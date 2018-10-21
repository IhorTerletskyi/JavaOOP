package lesson9Homework;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Task4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque<String> deq = new ArrayDeque<>();
		int colaQuantity = 7;
		deq.addLast("Sheldon");
		deq.addLast("Leonard");
		deq.addLast("Volovitc");
		deq.addLast("Kutrapalli");
		deq.addLast("Penny");

		for (int i = 0; i < colaQuantity; i++) {
			String temp = deq.pop();
			deq.addLast(temp);
			deq.addLast(temp);
		}
		
		System.out.println(Arrays.toString(deq.toArray()));

	}

}
