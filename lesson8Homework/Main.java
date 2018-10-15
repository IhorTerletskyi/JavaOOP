package lesson8Homework;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String str = "String";
		BigInteger bi = new BigInteger("2364");
		Scanner scan = new Scanner(System.in);
		
		Stack stk = new Stack(10);
		
		System.out.println(stk.isEmpty());
		System.out.println(stk.isFull());
		System.out.println(stk.read());
		stk.add(str);
		stk.add(bi);
		stk.add(scan);
		
		System.out.println(stk);
		
		stk.delete();
		
		System.out.println(stk.read().getClass());
		
		ClassesBlackList cbl = new ClassesBlackList(3);
		cbl.add(Scanner.class);
		
		stk.add(scan, cbl);
		stk.add(str,cbl);
		System.out.println(stk);
		

	}

}
