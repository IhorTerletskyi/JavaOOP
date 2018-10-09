package lesson6HomeworkTask2;

public class Main {

	public static void main(String[] args) {
		// Array sum calculate
		Thread trd = Thread.currentThread();

		RandomIntArray currentArray = new RandomIntArray(10000000, 100);
		currentArray.fill();
		long timeStart = System.currentTimeMillis();
		System.out.println(currentArray.elementsSumm());
		long timeFinish = System.currentTimeMillis();
		System.out.println("Classic calculate time = " + (timeFinish - timeStart));

//		System.out.println(currentArray);

		timeStart = System.currentTimeMillis();
		Thread[] threads = new Thread[currentArray.howMuchThreads()];
		int start = 0;
		for (int i = 0; i < threads.length; i++) {
			CalculateSummMultiThread calc = new CalculateSummMultiThread(currentArray, start, start + 99);
			threads[i] = new Thread(calc);
			start += 100;
		}

		try {
			for (Thread thread : threads) {
				thread.start();
				thread.join();
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		timeFinish = System.currentTimeMillis();
		System.out.println("calculate time = " + (timeFinish - timeStart));

		System.out.println(currentArray.getSummMultiThread());

	}

}
