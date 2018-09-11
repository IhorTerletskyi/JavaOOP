package Lesson1HomeWork;

public class Phone {
	/*метод Phone обладает такими свойствами:
	 * бренд телефона
	 * номер телефона
	 * количество денег на счету
	 * код сети, который присваивается при регистрации в сети
	 */
	
	private String brand;
	private int number;
	private double money;
	private int networkCode;
	
	//Для сосздания объекта класса Phone нужно указать модель телефона, номер и количество денег на счету
	public Phone(String brand, int number, double money) {
		super();
		this.brand = brand;
		this.number = number;
		this.money = money;
	}

	public Phone() {
		super();
	}
	
	/*Метод регистрации в сети.
	 *  - проверяем зарегистрирован ли номер в этой сети
	 *  - проверяет заергистрирован ли номер в другой сети
	 *  - если первые два условия не выполнены регистрирует номер в сети 
	 */
	public void registration(Network network) {
		if (network.isRegistered(networkCode, number)) {
			System.out.println("Your phone is alredy registered!");
		} else {
			if ((networkCode != network.getNetworkCode()) && (networkCode > 0)) {
				System.out.println("Your phone is alredy registered in another network!");
			} else {
				networkCode = network.getNetworkCode();
				network.addNewNumber(number);			
				System.out.println("Your phone registered! Thank You for choosing us!");
			}
		}
	}
	
	/*Метод звонка. Для совершения звонка нужно указать из какой сети звоним, в какую сеть звоним 
	 * и номер абонента кому звоним
	 * Логика такая:
	 * - Проверяем в своей сети звонок или нет и устанавливаем соответствующий тариф
	 * - проверяем зарегистрирован ли номер в этой сети
	 * - проверяем зарегистрирован ли номер принимающего абонента в его сети
	 * - проверяем наличие денег на счету
	 * - если все ок, снимаем деньги со счета и совершаем звонок
	 */
	public void call (Network myNetwork, Network friendNetwork, Phone friendPhone) {		
		double tarif;
		if (networkCode == friendNetwork.getNetworkCode()) {
			tarif = myNetwork.getPrice();
		} else {
			tarif = 5 * myNetwork.getPrice();
		}
		
		if (!myNetwork.isRegistered(networkCode, number)) {
			System.out.println("You not registered in this network");			
		} else {
			if (!friendNetwork.isRegistered(friendPhone)) {
				System.out.println("Dialed number does not exist");
			} else {				
				if (tarif > money) {
					System.out.println("You have not enouth money");
				} else {
					money -= tarif;
					speach();
				}
			}
			
			} 
		}
		
	//метод показывающий разговор:)
	public void speach() {
		System.out.printf("Hi! I speak from my new %s smartphon", brand);
		System.out.println();
		System.out.println("Cool, I'm happy! Bye!");
	}


	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public int getNetworkCode() {
		return networkCode;
	}

	public void setNetworkCode(int networkCode) {
		this.networkCode = networkCode;
	}

	@Override
	public String toString() {
		return "Phone [brand=" + brand + ", number=" + number + ", money=" + money + ", networkCode=" + networkCode
				+ "]";
	}

	
	
}
