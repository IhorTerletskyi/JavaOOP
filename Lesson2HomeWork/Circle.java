package Lesson2HomeWork;

public class Circle extends Shape {
	private Point pointA;
	private Point pointB;	

	public Circle(Point pointA, Point pointB) {
		super();
		this.pointA = pointA;
		this.pointB = pointB;
	}

	public Circle() {
		super();
	}
	
	private double radius() {
		return pointA.toPointDistance(pointB);
	}
	
	@Override
	public double getPerimeter() {		
		return 2 * Math.PI * radius();
	}

	@Override
	public double getArea() {		
		return Math.PI * Math.pow(radius(), 2);
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
		return "Circle [pointA=" + pointA + ", pointB=" + pointB + "]";
	}

	

}
