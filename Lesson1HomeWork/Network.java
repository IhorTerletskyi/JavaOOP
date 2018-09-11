package Lesson1HomeWork;

import java.util.Arrays;

public class Network {
	/*Создаем класс Network, его свойствами являются:
	 * код сети
	 * массив зарегистрированных номеров (максимум 9)
	 * текущая позиция для регистрации нового номера
	 * тариф (для звонков на другие сети он в пять раз больше базового)
	 */
	private int networkCode;	
	private int registratedNumbers[] = new int[10];
	private int currentNewNumber = 0;
	private double price;

	//Конструктор, задаем изначально код сети и тариф
	public Network(int networkCode, double price) {
		super();
		this.networkCode = networkCode;
		this.price = price;
	}

	public Network() {
		super();
	}

	//методы isRegistered проверяют зарегистрированы ли в сети номера телефонов
	public boolean isRegistered(Phone phone) {
		boolean isAlreadyRegistered = false;
		if (phone.getNetworkCode() == networkCode) {
			for (int counter = 0; counter < currentNewNumber; counter++) {
				if (registratedNumbers[counter] == phone.getNumber()) {
					isAlreadyRegistered = true;
				}
			}
		}
		return isAlreadyRegistered;
	}
	
	public boolean isRegistered(int networkCode, int phoneNumber) {
		boolean isAlreadyRegistered = false;
		if (this.networkCode == networkCode) {
			for (int counter = 0; counter < currentNewNumber; counter++) {
				if (registratedNumbers[counter] == phoneNumber) {
					isAlreadyRegistered = true;
				}
			}
		}
		return isAlreadyRegistered;
	}
	
	//метод, добавляющий номер в массив номеров
	public void addNewNumber(int newPhoneNumber) {
		registratedNumbers[currentNewNumber] = newPhoneNumber;
		currentNewNumber ++;		
	}

	public int getNetworkCode() {
		return networkCode;
	}

	public void setNetworkCode(int networkCode) {
		this.networkCode = networkCode;
	}

	public int[] getRegistratedNumbers() {
		return registratedNumbers;
	}

	public void setRegistratedNumbers(int[] registratedNumbers) {
		this.registratedNumbers = registratedNumbers;
	}

	public int getCorrentNewNumber() {
		return currentNewNumber;
	}

	public void setCorrentNewNumber(int correntNewNumber) {
		this.currentNewNumber = correntNewNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Network [networkCode=" + networkCode +  ", registratedNumbers="
				+ Arrays.toString(registratedNumbers) + ", currentNewNumber=" + currentNewNumber + ", price=" + price
				+ "]";
	}
	
	

}
