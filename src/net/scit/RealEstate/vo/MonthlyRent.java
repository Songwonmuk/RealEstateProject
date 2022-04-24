package net.scit.RealEstate.vo;

import java.util.Scanner;

public class MonthlyRent extends RealEstate {
	private int monthlyRent;

	public MonthlyRent(String address, String houseType, int size, int monthlyRent) { //monthlyRent 월 임대료
		super(address, houseType, size);
		this.monthlyRent = monthlyRent;
	}

	public int getMonthlyRent() {
		return monthlyRent;
	}

	@Override
	public String getinfo() {
		// TODO Auto-generated method stub
		return "MonthlyRent";
	}

	@Override
	public String toString() {
		return super.toString() + ", 월 임대료: " + this.monthlyRent;
	}

	@Override
	public int updateMoney(Scanner scanner) {
		System.out.println("|월 임대료|");
		int money = scanner.nextInt();
		return this.monthlyRent = money;
	}
}
