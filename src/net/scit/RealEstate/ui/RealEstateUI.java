package net.scit.RealEstate.ui;

import net.scit.RealEstate.service.RealEstateService;
import net.scit.RealEstate.service.RealEstateServiceImpl;
import net.scit.RealEstate.vo.RealEstate;

import java.util.List;
import java.util.Scanner;

public class RealEstateUI {
    private Scanner scanner = new Scanner(System.in);

    private RealEstateService estateService = new RealEstateServiceImpl();

    public void start() {

        while (true) {
            int menu = getMainMenu();
            switch (menu) {
                case 1:
                    int registerMenu = registerMenu();
                    estateService.register(registerMenu);
                    break;
                case 2:
                    int searchMenu = getSearchMenu();
                    switch (searchMenu) {
                        case 0:
                            System.out.println("�ּҸ� �Է��ϼ��� : ");
                            String searchingaddress = scanner.next();
                            RealEstate realEstate = estateService.getRealEstate(searchingaddress);
                            if (realEstate == null) {
                                System.out.println("ã���ô� �ּ��� �Ź��� �����ϴ�.");
                                break;
                            }
                            System.out.println(realEstate);
                            break;
                        case 1:
                            String buyingAndSellingType = "BuyingAndSelling";
                            printEstatesByType(buyingAndSellingType);
                            break;
                        case 2:
                            String charterType = "Charter";
                            printEstatesByType(charterType);
                            break;
                        case 3:
                            String monthlyRentType = "MonthlyRent";
                            printEstatesByType(monthlyRentType);
                            break;
                        default:
                            System.out.println("���� �޴��Դϴ�.");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("|���� ������ �ּ�|");
                    String updatingaddress = scanner.next();
                    RealEstate estate = estateService.getRealEstate(updatingaddress);
                    if (estate == null) {
                        System.out.println("ã���ô� �ּ��� �Ź��� �����ϴ�.");
                        break;
                    }
                    System.out.println("��ϵ� ����");
                    System.out.println("====================");
                    System.out.println(estate);
                    System.out.println("====================");
                    estate.updateMoney(scanner);
                    break;
                case 4:
                    System.out.println("|���� ������ �ּ�|");
                    int deleted = estateService.delete(scanner.next());
                    if (deleted == 1) {
                        System.out.println("�����Ǿ����ϴ�.");
                    } else {
                        System.out.println("���� �����Ͽ����ϴ�.");
                    }
                    break;
                case 5:
                    estateService.printAll();
                    break;
                case 9:
                    System.out.println("����");
                    return;
                default:
                    System.out.println("�߸� �Է��ϼ̽��ϴ�.");
            }
        }
    }

    private void printEstatesByType(String type) {
        List<RealEstate> estates = estateService.getRealEstatesByType(type);
        if (estates.isEmpty()) {
            System.out.println("��ϵ� �Ź��� �����ϴ�.");
            return;
        }
        for (RealEstate estate : estates) {
            System.out.println(estate);
        }
    }

    private int getSearchMenu() {
        System.out.println("------------------");
        System.out.println("�ε��� �߰� ���� �ý���");
        System.out.println("------------------");
        System.out.println("0. �ּҷ� �˻�");
        System.out.println("1. �Ÿ� ���� �˻�");
        System.out.println("2. ���� ���� �˻�");
        System.out.println("3. ���� ���� �˻�");
        System.out.println("------------------");
        System.out.println("�޴� ��ȣ�� �Է��ϼ���. => ");
        return scanner.nextInt();
    }

    private int registerMenu() {
        System.out.println("------------------");
        System.out.println("�ε��� �Ź� ���� ���");
        System.out.println("------------------");
        System.out.println("1. �Ÿ�");
        System.out.println("2. ����");
        System.out.println("3. ����");
        System.out.println("4. ���� �޴�");
        System.out.println("------------------");
        System.out.println("�޴� ��ȣ�� �Է��ϼ���. => ");
        return scanner.nextInt();
    }

    /**
     * ���� �޴� �Է�
     *
     * @return menu
     */
    private int getMainMenu() {
        System.out.println("------------------");
        System.out.println("�ε��� �߰� ���� �ý���");
        System.out.println("------------------");
        System.out.println("1. ���");
        System.out.println("2. �˻�");
        System.out.println("3. ����");
        System.out.println("4. ����(�ŷ� �Ϸ�)");
        System.out.println("5. ��ü ���");
        System.out.println("9. ����");
        System.out.println("------------------");
        System.out.println("�޴� ��ȣ�� �Է��ϼ���. => ");
        return scanner.nextInt();
    }
}
