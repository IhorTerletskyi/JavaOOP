package lesson6HomeworkTask1;

import java.math.BigInteger;

public class Factorial implements Runnable {
	private int n;

	public Factorial(int n) {
		super();
		this.n = n;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public BigInteger calculateFactorial(int number) {
		BigInteger fact = new BigInteger("1");
		for (int i = 1; i <= number; i++) {
			fact = fact.multiply(new BigInteger("" + i));
		}
		return fact;
	}

	@Override
	public void run() {
		Thread thr = Thread.currentThread();
		System.out.println(thr.getName() + " -> 0! = " + calculateFactorial(0));
		for (int i = 1; i <= this.n; i++) {
			System.out.println(thr.getName() + " -> " + i + "! = " + calculateFactorial(i));

			if (thr.isInterrupted()) {
				System.out.println(thr.getName() + "interrupted");
				return;
			}
		}

	}

}