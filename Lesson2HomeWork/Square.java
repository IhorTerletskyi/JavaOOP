package Lesson2HomeWork;

public class Square extends Shape {
	private Point pointA;
	private Point pointB;
	
	public Square(Point pointA, Point pointB) {
		super();
		this.pointA = pointA;
		this.pointB = pointB;
	}	

	public Square() {
			super();
		}
	
	private double side() {
		return pointA.toPointDistance(pointB);
	}
	
	@Override
	public double getPerimeter() {		
		return 4 * side();
	}

	@Override
	public double getArea() {		
		return Math.pow(side(), 2);
	}

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	@Override
	public String toString() {
		return "Square [pointA=" + pointA + ", pointB=" + pointB + "]";
	}

	

}
