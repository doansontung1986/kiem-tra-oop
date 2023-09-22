package logichandle;

import utilities.CheckValidInput;

public class MenuManagement {
    private final StaffLogic staffLogic = new StaffLogic();
    private final ItemLogic itemLogic = new ItemLogic();
    private final SaleListLogic saleListLogic = new SaleListLogic(staffLogic, itemLogic);

    public void run() {
        while (true) {
            printMenu();
            int functionChoice = chooseFunction();
            switch (functionChoice) {
                case 1:
                    itemLogic.inputItemList();
                    break;
                case 2:
                    itemLogic.displayItemList();
                    break;
                case 3:
                    staffLogic.inputStaffList();
                    break;
                case 4:
                    staffLogic.displayStaffList();
                    break;
                case 5:
                    saleListLogic.inputSaleLists();
                    break;
                case 6:
                    saleListLogic.displaySaleLists();
                    break;
                case 7:
                    printSubmenu();
                    int subMenuChoice = chooseSubmenuChoice();
                    switch (subMenuChoice) {
                        case 1:
                            saleListLogic.sortSaleListByStaffName();
                            break;
                        case 2:
                            saleListLogic.sortSaleListByItemGroup();
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ");
                            break;
                    }
                    break;
                case 8: saleListLogic.displaySaleListEachStaff();
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
            }

        }
    }

    private int chooseFunction() {
        System.out.print("Xin mời lựa chọn chức năng (1-9): ");
        int functionChoice;
        do {
            functionChoice = CheckValidInput.inputValidNumber();
            if (functionChoice > 0 && functionChoice < 10) {
                break;
            }
            System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại");
        } while (true);

        return functionChoice;
    }

    private int chooseSubmenuChoice() {
        int choice;

        do {
            System.out.print("Xin mời lựa chọn chức năng (1 hoặc 2): ");

            choice = CheckValidInput.inputValidNumber();

            if (choice > 0 && choice < 3) {
                break;
            }

            System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại");
        } while (true);

        return choice;
    }

    private void printMenu() {
        System.out.println("------PHẦN MỀM QUẢN LÝ HÀNG HÓA");
        System.out.println("1. Nhập danh sách mặt hàng mới");
        System.out.println("2. In ra danh sách các mặt hàng đã có");
        System.out.println("3. Nhập danh sách nhân viên");
        System.out.println("4. In ra danh sách nhân viên đã có");
        System.out.println("5. Lập bảng danh sách bán hàng cho từng nhân viên");
        System.out.println("6. In bảng danh sách bán hàng");
        System.out.println("7. Sắp xếp danh sách bảng danh sách bán hàng");
        System.out.println("8. Lập bảng kê doanh thu cho mỗi nhân viên.");
        System.out.println("9. Thoát");
    }

    private void printSubmenu() {
        System.out.println("1. Theo tên nhân viên");
        System.out.println("2. Theo nhóm mặt hàng");
    }
}
