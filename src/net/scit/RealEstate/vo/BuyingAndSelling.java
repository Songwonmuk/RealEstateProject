package net.scit.RealEstate.vo;

import java.util.Scanner;

public class BuyingAndSelling extends RealEstate {
	private int price;
	
	public BuyingAndSelling(String address, String houseType, int size, int price) {//price �ŸŰ���
		super(address, houseType, size);
		this.price = price;
		
	}
	
	public int getPrice() {
		return price;
	}
	
	@Override
	public String getinfo() {
		// TODO Auto-generated method stub
		return "BuyingAndSelling";
	}

	@Override
	public String toString() {
		return super.toString() + ", �Ÿ� ����: " + this.price;
	}

	@Override
	public int updateMoney(Scanner scanner) {
		System.out.println("|�Ÿ� ����|");
		int money = scanner.nextInt();
		return this.price = money;
	}
}
