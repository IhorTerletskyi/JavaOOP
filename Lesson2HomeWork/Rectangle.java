package Lesson2HomeWork;

public class Rectangle extends Shape {
	private Point pointA;
	private Point pointB;
   		
	public Rectangle(Point pointA, Point pointB) {
		super();
		this.pointA = pointA;
		this.pointB = pointB;
	}

	public Rectangle() {
		super();
	}
	
	private Point pointC() {
		return new Point(pointA.getCoordinateX(), pointB.getCoordinateY());
	}
	
	private double sideA() {
		return pointA.toPointDistance(pointC());
	}
	
	private double sideB() {
		return pointC().toPointDistance(pointB);
	}
	
	
	@Override
	public double getPerimeter() {		
		return (2 * sideA()) + (2 * sideB());
	}

	@Override
	public double getArea() {		
		return sideA() * sideB();
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
		return "Rectangle [pointA=" + pointA + ", pointB=" + pointB + "]";
	}

	

}
