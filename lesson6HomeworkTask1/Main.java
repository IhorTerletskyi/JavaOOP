package lesson6HomeworkTask1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread currentThread = Thread.currentThread();
		int threadFactorialQuantity = 100;
		Factorial[] factorials = new Factorial[threadFactorialQuantity];
		Thread[] threads = new Thread[threadFactorialQuantity];

		for (int i = 0; i < threads.length; i++) {
			factorials[i] = new Factorial(i);
			threads[i] = new Thread(factorials[i]);
		}
		
		for (Thread thread:threads) {
			thread.start();			
		}
		
	}

}
