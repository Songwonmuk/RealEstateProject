package net.scit.RealEstate.vo;

import java.util.Scanner;

public class Charter extends RealEstate {
	private int depositMoney;
	
	public Charter(String address, String houseType, int size , int depositMoney) {//depositMoney 임대 보증금
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
		System.out.println("|임대 보증금|");
		int money = scanner.nextInt();
		return this.depositMoney = money;
	}

	@Override
	public String toString() {
		return super.toString() + ", 임대 보증금: " + this.depositMoney;
	}
	
	
	
}
