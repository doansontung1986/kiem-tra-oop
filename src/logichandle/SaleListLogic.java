package logichandle;

import entity.Item;
import entity.SaleDetail;
import entity.SaleList;
import entity.Staff;
import utilities.CheckValidInput;

import java.util.Scanner;

public class SaleListLogic {
    private StaffLogic staffLogic;
    private ItemLogic itemLogic;
    private SaleList[] saleLists = new SaleList[100];

    public SaleListLogic(StaffLogic staffLogic, ItemLogic itemLogic) {
        this.staffLogic = staffLogic;
        this.itemLogic = itemLogic;
    }

    public SaleList[] getSaleLists() {
        return saleLists;
    }

    public void inputSaleLists() {
        System.out.print("Nhập số bảng danh sách bán hàng: ");
        int numberOfSaleList = new Scanner(System.in).nextInt();
        for (int i = 0; i < numberOfSaleList; i++) {
            Staff staff = inputStaffInfo();
            SaleDetail[] saleDetails = inputSaleDetails();
            SaleList saleList = new SaleList(staff, saleDetails);
            saveSaleList(saleList);
        }
    }

    public void displaySaleLists() {
        for (int i = 0; i < saleLists.length; i++) {
            if (saleLists[i] != null) {
                System.out.println(saleLists[i]);
            }
        }
    }

    private void saveSaleList(SaleList saleList) {
        for (int i = 0; i < saleLists.length; i++) {
            if (saleLists[i] == null) {
                saleLists[i] = saleList;
                break;
            }
        }
    }

    private SaleDetail[] inputSaleDetails() {
        System.out.print("Nhập số mặt hàng: ");
        int numberOfItem;
        do {
            numberOfItem = CheckValidInput.inputValidNumber();

            if (numberOfItem > 0 && numberOfItem < 6) {
                break;
            }

            System.out.println("Mỗi nhân viên chỉ bán tối đa 5 mặt hàng");
        } while (true);

        SaleDetail[] saleDetails = new SaleDetail[numberOfItem];
        int count = 0;

        for (int i = 0; i < numberOfItem; i++) {
            System.out.println("Nhập thông tin mặt hàng thứ " + (i + 1));
            int itemId;
            Item item;

            do {
                itemId = CheckValidInput.inputValidNumber();
                item = itemLogic.searchItemById(itemId);

                if (item != null) {
                    break;
                }

                System.out.print("Không tồn tại hàng hóa mang mã " + itemId + ", vui lòng nhập lại: ");

            } while (true);

            System.out.print("Nhập số lượng hàng hóa: ");
            int quantity = new Scanner(System.in).nextInt();

            SaleDetail saleDetail = new SaleDetail(item, quantity);
            saleDetails[count] = saleDetail;
            count++;
        }

        return saleDetails;
    }

    private Staff inputStaffInfo() {
        System.out.print("Nhập mã nhân viên: ");
        int staffId;
        Staff staff;

        do {
            staffId = CheckValidInput.inputValidNumber();
            staff = staffLogic.searchStaffById(staffId);

            if (staff != null) {
                break;
            }

            System.out.print("Không tồn tại nhân viên mang mã " + staffId + ", vui lòng nhập lại: ");

        } while (true);

        return staff;
    }

    private SaleList[] copySaleList(SaleList[] saleLists) {
        SaleList[] copySaleList = new SaleList[saleLists.length];
        for (int i = 0; i < saleLists.length; i++) {
            if (copySaleList[i] == null) {
                copySaleList[i] = saleLists[i];
            }
        }
        return copySaleList;
    }

    public void sortSaleListByStaffName() {
        SaleList[] copySaleList = copySaleList(saleLists);

        for (int i = 0; i < copySaleList.length - 1; i++) {
            boolean isSwap = false;
            for (int j = i; j < copySaleList.length; j++) {
                if (copySaleList[i] != null && copySaleList[j] != null && copySaleList[i].getStaff().getName().compareTo(copySaleList[j].getStaff().getName()) > 0) {
                    swap(copySaleList, i, j);
                    isSwap = true;
                }
            }

            if (!isSwap) {
                break;
            }
        }
    }

    private void swap(SaleList[] saleLists, int i, int j) {
        SaleList tempSaleList = saleLists[i];
        saleLists[i] = saleLists[j];
        saleLists[j] = tempSaleList;
    }

    public void sortSaleListByItemGroup() {
        SaleList[] copySaleLists = copySaleList(saleLists);

        for (int i = 0; i < copySaleLists.length - 1; i++) {
            boolean isSwap = false;
            SaleList copySaleList = null;
            SaleDetail[] copySaleDetails;
            if (copySaleLists[i] != null) {
                copySaleList = copySaleLists[i];
            }
            copySaleDetails = copySaleList.getSaleDetails();
            for (int j = i; j < copySaleDetails.length; j++) {
                SaleList nextCopySaleList = null;
                SaleDetail[] nextCopySaleDetails;
                if (copySaleLists[j] != null) {
                    nextCopySaleList = copySaleLists[j];
                }
                nextCopySaleDetails = nextCopySaleList.getSaleDetails();

                if (copySaleDetails[j].getItem().getItemGroup().compareTo(nextCopySaleDetails[j].getItem().getItemGroup()) > 0) {
                    swap(copySaleLists, i, j);
                }
            }

            if (!isSwap) {
                break;
            }
        }
    }

    public void displaySaleListEachStaff() {
        Staff staff = inputStaffInfo();
        System.out.printf("%-12s | %-16s | %-16s | %-12s | %-12s |\n", "Mã nhân viên", "Tên nhân viên", "Tên hàng hóa", "Nhóm hàng", "Số lượng");
        for (int i = 0; i < saleLists.length; i++) {
            if (saleLists[i] != null && saleLists[i].getStaff().getId() == staff.getId()) {
                SaleList saleList = saleLists[i];
                SaleDetail[] saleDetails = saleList.getSaleDetails();
                for (int j = 0; j < saleDetails.length; j++) {
                    System.out.printf("%-12s | %-16s | %-16s | %-12s | %-12s |\n", staff.getId(), staff.getName(), saleDetails[j].getItem().getItemName(), saleDetails[j].getItem().getItemGroup(), saleDetails[j].getItem().getQuantity());
                }
            }
        }
    }
}
