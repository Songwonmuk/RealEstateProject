package net.scit.RealEstate.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import net.scit.RealEstate.vo.BuyingAndSelling;
import net.scit.RealEstate.vo.Charter;
import net.scit.RealEstate.vo.MonthlyRent;
import net.scit.RealEstate.vo.RealEstate;

public class RealEstateServiceImpl implements RealEstateService {
	private List<RealEstate> realEstateList = new ArrayList<>();
	private Scanner scanner = new Scanner(System.in);

	@Override
	public int register(int registerMenu) {
		switch (registerMenu) {
		case 1:
			// �Ÿ� ���
			BuyingAndSelling buyingAndSelling = createBuyingAndSelling();
			realEstateList.add(buyingAndSelling);
			return 1;
		case 2:
			// ���� ���
			Charter charter = createCharter();
			realEstateList.add(charter);
			return 1;
		case 3:
			// ���� ���
			MonthlyRent monthlyRent = createMonthlyRent();
			realEstateList.add(monthlyRent);
			return 1;
		case 4:
			// ���� �޴�
			return 0;

		default:
			System.out.println("�޴��� �߸� �Է��ϼ̽��ϴ�.");
			return 0;
		}
	}

	@Override
	public RealEstate getRealEstate(String address) {
		for (RealEstate estate : realEstateList) {
			if (estate.getAddress().equals(address)) {
				return estate;
			}
		}
		return null;
	}

	@Override
	public List<RealEstate> getRealEstatesByType(String type) {
		List<RealEstate> estateList = new ArrayList<>();
		for (RealEstate estate : realEstateList) {
			if (estate.getinfo().equals(type)) {
				estateList.add(estate);
			}
		}
		return estateList;
	}

	@Override
	public void printAll() {
		for (RealEstate estate : realEstateList) {
			System.out.println(estate);
		}
	}

	@Override
	public int delete(String address) {
		RealEstate realEstate = getRealEstate(address);
		if (realEstate == null) {
			System.out.println("ã���ô� ������ �����ϴ�.");
			return 0;
		}
		realEstateList.remove(realEstate);
		return 1;
	}

	private MonthlyRent createMonthlyRent() {
		System.out.println("�ּ�: ");
		String address = scanner.next();
		System.out.println("�ְ�����: ");
		String houseType = scanner.next();
		System.out.println("ũ��: ");
		int size = scanner.nextInt();
		System.out.println("�� �Ӵ��: ");
		int monthlyRent = scanner.nextInt();
		return new MonthlyRent(address, houseType, size, monthlyRent);
	}

	private Charter createCharter() {
		System.out.println("�ּ�: ");
		String address = scanner.next();
		System.out.println("�ְ�����: ");
		String houseType = scanner.next();
		System.out.println("ũ��: ");
		int size = scanner.nextInt();
		System.out.println("�Ӵ� ������: ");
		int depositMoney = scanner.nextInt();
		return new Charter(address, houseType, size, depositMoney);
	}

	private BuyingAndSelling createBuyingAndSelling() {
		System.out.println("�ּ�: ");
		String address = scanner.next();
		System.out.println("�ְ�����: ");
		String houseType = scanner.next();
		System.out.println("ũ��: ");
		int size = scanner.nextInt();
		System.out.println("�ŸŰ�: ");
		int price = scanner.nextInt();
		return new BuyingAndSelling(address, houseType, size, price);
	}
}
