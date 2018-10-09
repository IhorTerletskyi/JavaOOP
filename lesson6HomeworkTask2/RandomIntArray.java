package lesson6HomeworkTask2;

import java.util.Arrays;
import java.util.Random;

public class RandomIntArray {
	private int size;
	private int maxValue;
	private int[] array;
	private int summMultiThread;

	public RandomIntArray(int size, int maxValue) {
		super();
		this.size = size;
		this.maxValue = maxValue;
		this.array = new int[size];
		this.summMultiThread = 0;
	}

	public RandomIntArray() {
		super();
	}

	public void fill() {
		Random rand = new Random();
		for (int i = 0; i < this.size; i++) {
			this.array[i] = rand.nextInt(this.maxValue);
		}
	}

	public int elementsSumm() {
		int summ = 0;
		for (int i = 0; i < this.size; i++) {
			summ += this.array[i];
		}
		return summ;
	}

	public int howMuchThreads() {
		int threadsQuantity = 0;
		if (this.size % 100 == 0) {
			threadsQuantity = this.size / 100;
		} else {
			threadsQuantity = this.size / 100 + 1;
		}
		return threadsQuantity;
	}

	

	public int getSize() {
		return size;
	}

	public int getMaxValue() {
		return maxValue;
	}

	public int[] getArray() {
		return array;
	}

	public int getSummMultiThread() {
		return summMultiThread;
	}

	public void setSummMultiThread(int summMultiThread) {
		this.summMultiThread = summMultiThread;
	}

	@Override
	public String toString() {
		return "RandomIntArray [size=" + size + ", maxValue=" + maxValue + ", array=" + Arrays.toString(array) + "]";
	}

}
