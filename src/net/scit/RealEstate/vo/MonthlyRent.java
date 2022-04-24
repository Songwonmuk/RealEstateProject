package net.scit.RealEstate.vo;

import java.util.Scanner;

public class MonthlyRent extends RealEstate {
	private int monthlyRent;

	public MonthlyRent(String address, String houseType, int size, int monthlyRent) { //monthlyRent �� �Ӵ��
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
		return super.toString() + ", �� �Ӵ��: " + this.monthlyRent;
	}

	@Override
	public int updateMoney(Scanner scanner) {
		System.out.println("|�� �Ӵ��|");
		int money = scanner.nextInt();
		return this.monthlyRent = money;
	}
}
