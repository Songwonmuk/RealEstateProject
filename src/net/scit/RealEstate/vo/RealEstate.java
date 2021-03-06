package net.scit.RealEstate.vo;

import java.util.Scanner;

public abstract class RealEstate {
	private String address;
	private String houseType;
	private int size;
	
	public RealEstate(String address, String houseType, int size) {
		this.address = address;
		this.houseType = houseType;
		this.size = size;
		
	}
	
	public String getAddress() {
		return address;
	}
	public String getHouseType() {
		return houseType;
	}
	public int getSize() {
		return size;
	}
	
	@Override
	public String toString() {
		return "주소: "+ this.address +", 주거형태: " + this.houseType + ", 크기: " + this.size;
	}
	
	public abstract String getinfo();

	public abstract int updateMoney(Scanner scanner);
}



