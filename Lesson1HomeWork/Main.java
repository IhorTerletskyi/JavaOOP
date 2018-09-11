package Lesson1HomeWork;

public class Main {

	public static void main(String[] args) {
		/*1) Описать класс «Cat» (в качестве образца можно взять домашнего питомца).
		 * Наделить его свойствами и методами. Создать несколько экземпляров объектов
		 * этого класса. Использовать эти объекты.
		 */
		Cat vasya = new Cat("Black", 5, 8.5);
		Cat murka = new Cat("Gray", 4, 6);
		Cat baby = murka.love(vasya);
		System.out.println(baby);
		
		baby.speak();
		murka.running();
		baby.eat(0.015);
		vasya.doCrap();
		vasya.eat(0.2);
		murka.running();
		murka.eat(0.1);
		baby.doCrap();
		
		System.out.println("baby: " + baby);
		System.out.println("murka: " + murka);
		System.out.println("vasya: " + vasya);
		
		/*2) Описать класс «Triangle». В качестве свойств возьмите длины сторон
		 * треугольника. Реализуйте метод, который будет возвращать площадь этого
		 * треугольника. Создайте несколько объектов этого класса и протестируйте их.
		 */
		
		Triangle firstTriangle = new Triangle(3, 4, 5);
		Triangle secondTriangle = new Triangle(2, 2, 2);
		Triangle thirdTriangle = new Triangle(15, 10, 10);
		
		System.out.println();
		System.out.println(firstTriangle.square());
		System.out.println(secondTriangle.square());
		System.out.println(thirdTriangle.square());
		System.out.println();
		
		/*4) Опишите класс Phone (одним из свойств должен быть его номер). Также опишите
		 * класс Network (сеть мобильного оператора). Телефон должен иметь метод
		 * регистрации в сети мобильного оператора. Также у телефона должен быть метод call
		 * (номер другого телефона), который переберет все телефоны, зарегистрированные в
		 * сети. Если такой номер будет найден, то осуществить вызов, если нет - вывести
		 * сообщение об ошибочности набранного номера.
		 */
		Network megaNet = new Network(55, 0.1);
		Network garage = new Network(23, 0.05);
		
		Phone userOne = new Phone("Sumsung", 6873489, 40);
		Phone userTwo = new Phone("Nokia", 665889, 1);
		Phone userThird = new Phone("Sumsung", 1234489, 0.01);
		Phone userFourth = new Phone("Kiano", 6777489, 0.5);
		Phone userFifth = new Phone("Sumsung", 7777777, 120);
		Phone usersixth = new Phone("Sumsung", 4545489, 1.6);
		
		userOne.registration(megaNet);
		userTwo.registration(garage);
		userThird.registration(garage);
		userFourth.registration(garage);
		userFifth.registration(megaNet);
		
		userOne.call(megaNet, garage, userFourth);
		userFifth.call(megaNet, megaNet, userOne);
		userThird.call(garage, garage, userTwo);
		userOne.call(garage, garage, userTwo);
		userOne.call(megaNet, megaNet, userTwo);
		
		System.out.println(userOne);
		

	}

}
