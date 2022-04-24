package net.scit.RealEstate.vo;

import java.util.Scanner;

public class Charter extends RealEstate {
	private int depositMoney;
	
	public Charter(String address, String houseType, int size , int depositMoney) {//depositMoney �Ӵ� ������
		super(address, houseType, size);
		this.depositMoney = depositMoney;
	}

	public int getDepositMoney() {
		return depositMoney;
	}
		
	@Override
	public String getinfo() {
		// TODO Auto-generated method stub
		return "Charter";
	}

	@Override
	public int updateMoney(Scanner scanner) {
		System.out.println("|�Ӵ� ������|");
		int money = scanner.nextInt();
		return this.depositMoney = money;
	}

	@Override
	public String toString() {
		return super.toString() + ", �Ӵ� ������: " + this.depositMoney;
	}
	
	
	
}
