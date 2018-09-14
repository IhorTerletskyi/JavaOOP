package Lesson2HomeWork;

public class Triangle extends Shape {
	private Point pointA;
	private Point pointB;
	private Point pointC;
	
		public Triangle(Point pointA, Point pointB, Point pointC) {
		super();
		this.pointA = pointA;
		this.pointB = pointB;
		this.pointC = pointC;
	}
	
	public Triangle() {
		super();
	}
	
	private double sideAB() {
	    return pointA.toPointDistance(pointB);
	}
	private double sideBC() {
		return pointB.toPointDistance(pointC);
	}
	private double sideCA() {
		return pointC.toPointDistance(pointA);
	}
	
	@Override
	public double getPerimeter() {
		return sideAB() + sideBC() + sideCA();
	}

	@Override
	public double getArea() {		
		double halfPerimeter = (sideAB() + sideBC() + sideCA()) / 2;
		return Math.sqrt(halfPerimeter * (halfPerimeter - sideAB()) * (halfPerimeter - sideBC()) * (halfPerimeter - sideCA()));		
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

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	@Override
	public String toString() {
		return "Triangle [pointA=" + pointA + ", pointB=" + pointB + ", pointC=" + pointC + "]";
	}

	
	

}
