package Lesson2HomeWork;

import java.util.Arrays;

public class Blackboard {
	private Shape[] areas = new Shape[4];

	public Blackboard() {
		super();
	}
	
	public void addFigure(Shape figure, int placeNumber) {
		if (areas[placeNumber] == null) {
			areas[placeNumber] = figure;
		} else {
			System.out.println("This area already ocupate");
		}
		
	}
	
	public void deleteFigure(int placeNumber) {
		areas[placeNumber] = null;
	}
	
	public void changeFigure(Shape figure, int placeNumber) {
		areas[placeNumber] = figure;
	}
	
	public void status() {
		double areaAll = 0;
		for (int i = 0; i < 4; i ++) {
			System.out.println("In field " + i + " is " + areas[i]);
			if (areas[i] != null) {
				areaAll += areas[i].getArea();
			}
		}
		System.out.println("Area of all figures = " + areaAll);
	}

	@Override
	public String toString() {
		return "Blackboard [areas=" + Arrays.toString(areas) + "]";
	}
	
	

}
