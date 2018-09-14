package Lesson2HomeWork;

public class Point {
	private double coordinateX;
	private double coordinateY;
	
	public Point(double coordinateX, double coordinateY) {
		super();
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
	}

	public Point() {
		super();
	}
	
	public double toPointDistance(Point pointB) {		
		double temp1 = Math.pow((pointB.getCoordinateX() - coordinateX), 2);
		double temp2 = Math.pow((pointB.getCoordinateY() - coordinateY), 2);		
		return Math.sqrt(temp1 + temp2);
	}

	public double getCoordinateX() {
		return coordinateX;
	}

	public void setCoordinateX(double coordinateX) {
		this.coordinateX = coordinateX;
	}

	public double getCoordinateY() {
		return coordinateY;
	}

	public void setCoordinateY(double coordinateY) {
		this.coordinateY = coordinateY;
	}

	@Override
	public String toString() {
		return "Point [coordinateX=" + coordinateX + ", coordinateY=" + coordinateY + "]";
	}
	
	

}
