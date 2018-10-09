package lesson6HomeworkTask2;

public class CalculateSummMultiThread implements Runnable{
	private RandomIntArray array;
	private int start;
	private int finish;
	
	public CalculateSummMultiThread(RandomIntArray array, int start, int finish) {
		super();
		this.array = array;
		this.start = start;
		this.finish = finish;
	}

	public CalculateSummMultiThread() {
		super();
	}
	
	private int partOfArraySumm(int start, int end) {
		int summ = 0;
		for (int i = start; i <= end; i++) {
			summ += array.getArray()[i];
		}
		return summ;
	}
	
	@Override
	public void run() {
        int summ = partOfArraySumm(start, finish);
        array.setSummMultiThread(array.getSummMultiThread() + summ);
	}

}
