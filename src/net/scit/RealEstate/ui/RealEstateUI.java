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
                            System.out.println("주소를 입력하세요 : ");
                            String searchingaddress = scanner.next();
                            RealEstate realEstate = estateService.getRealEstate(searchingaddress);
                            if (realEstate == null) {
                                System.out.println("찾으시는 주소의 매물이 없습니다.");
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
                            System.out.println("없는 메뉴입니다.");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("|수정 물건의 주소|");
                    String updatingaddress = scanner.next();
                    RealEstate estate = estateService.getRealEstate(updatingaddress);
                    if (estate == null) {
                        System.out.println("찾으시는 주소의 매물이 없습니다.");
                        break;
                    }
                    System.out.println("등록된 정보");
                    System.out.println("====================");
                    System.out.println(estate);
                    System.out.println("====================");
                    estate.updateMoney(scanner);
                    break;
                case 4:
                    System.out.println("|삭제 물건의 주소|");
                    int deleted = estateService.delete(scanner.next());
                    if (deleted == 1) {
                        System.out.println("삭제되었습니다.");
                    } else {
                        System.out.println("삭제 실패하였습니다.");
                    }
                    break;
                case 5:
                    estateService.printAll();
                    break;
                case 9:
                    System.out.println("종료");
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }
    }

    private void printEstatesByType(String type) {
        List<RealEstate> estates = estateService.getRealEstatesByType(type);
        if (estates.isEmpty()) {
            System.out.println("등록된 매물이 없습니다.");
            return;
        }
        for (RealEstate estate : estates) {
            System.out.println(estate);
        }
    }

    private int getSearchMenu() {
        System.out.println("------------------");
        System.out.println("부동산 중계 관리 시스템");
        System.out.println("------------------");
        System.out.println("0. 주소로 검색");
        System.out.println("1. 매매 물건 검색");
        System.out.println("2. 전세 물건 검색");
        System.out.println("3. 월세 물건 검색");
        System.out.println("------------------");
        System.out.println("메뉴 번호를 입력하세요. => ");
        return scanner.nextInt();
    }

    private int registerMenu() {
        System.out.println("------------------");
        System.out.println("부동산 매물 정보 등록");
        System.out.println("------------------");
        System.out.println("1. 매매");
        System.out.println("2. 전세");
        System.out.println("3. 월세");
        System.out.println("4. 상위 메뉴");
        System.out.println("------------------");
        System.out.println("메뉴 번호를 입력하세요. => ");
        return scanner.nextInt();
    }

    /**
     * 메인 메뉴 입력
     *
     * @return menu
     */
    private int getMainMenu() {
        System.out.println("------------------");
        System.out.println("부동산 중계 관리 시스템");
        System.out.println("------------------");
        System.out.println("1. 등록");
        System.out.println("2. 검색");
        System.out.println("3. 수정");
        System.out.println("4. 삭제(거래 완료)");
        System.out.println("5. 전체 출력");
        System.out.println("9. 종료");
        System.out.println("------------------");
        System.out.println("메뉴 번호를 입력하세요. => ");
        return scanner.nextInt();
    }
}
