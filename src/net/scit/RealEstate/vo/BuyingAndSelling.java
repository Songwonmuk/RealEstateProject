package net.scit.RealEstate.vo;

import java.util.Scanner;

public class BuyingAndSelling extends RealEstate {
	private int price;
	
	public BuyingAndSelling(String address, String houseType, int size, int price) {//price 매매가격
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
		return super.toString() + ", 매매 가격: " + this.price;
	}

	@Override
	public int updateMoney(Scanner scanner) {
		System.out.println("|매매 가격|");
		int money = scanner.nextInt();
		return this.price = money;
	}
}
