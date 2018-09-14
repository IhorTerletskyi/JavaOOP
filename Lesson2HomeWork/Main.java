package Lesson2HomeWork;

public class Main {

	public static void main(String[] args) {
		
    Point pointA = new Point(1, 1);
    Point pointB = new Point(1, 3);
    Point pointC = new Point(4, 1);
    
    Triangle trian = new Triangle(pointA, pointB, pointC);
    Square square = new Square(pointA, pointC);
    Rectangle rect = new Rectangle(pointB, pointC);
    Circle circ = new Circle(pointA, pointC);
    
    System.out.println(trian);
    System.out.println("Perimeter =" + trian.getPerimeter());
    System.out.println("Area =" + trian.getArea());
    System.out.println();
    
    System.out.println(square);
    System.out.println("Perimeter =" + square.getPerimeter());
    System.out.println("Area =" + square.getArea());
    System.out.println();
    
    System.out.println(rect);
    System.out.println("Perimeter =" + rect.getPerimeter());
    System.out.println("Area =" + rect.getArea());
    System.out.println();
    
    System.out.println(circ);
    System.out.println("Perimeter =" + circ.getPerimeter());
    System.out.println("Area =" + circ.getArea());
    System.out.println();
    
    Blackboard board = new Blackboard();
    board.addFigure(trian, 0);
    board.addFigure(rect, 1);
    board.addFigure(circ, 2);
    board.changeFigure(square, 1);
    board.addFigure(rect, 3);
    board.status();
    board.deleteFigure(2);
    board.status();
    board.addFigure(circ, 0);
    
    
	}

}
