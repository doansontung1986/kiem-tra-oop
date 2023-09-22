package logichandle;

import entity.Staff;
import utilities.CheckValidInput;

import java.util.Scanner;

public class StaffLogic {
    private final Staff[] staffList = new Staff[100];

    public void inputStaffList() {
        System.out.print("Nhập số lượng nhân viên cần thêm: ");
        int numberOfStaff = CheckValidInput.inputValidNumber();
        for (int i = 0; i < numberOfStaff; i++) {
            System.out.println("Nhập thông tin nhân viên thứ " + (i + 1));
            Staff staff = new Staff();
            staff.inputInfo();
            saveStaff(staff);
        }
    }

    private void saveStaff(Staff staff) {
        for (int i = 0; i < staffList.length; i++) {
            if (staffList[i] == null) {
                staffList[i] = staff;
                break;
            }
        }
    }

    public void displayStaffList() {
        System.out.printf("%-12s | %-16s | %-16s | %-12s | %-16s |\n", "Mã nhân viên", "Tên nhân viên", "Địa chỉ", "Số điện thoại", "Ngày ký hợp đồng");
        for (Staff staff : staffList) {
            if (staff != null) {
                staff.displayInfo();
            }
        }
    }

    public Staff searchStaffById(int staffId) {
        for (Staff staff : staffList) {
            if (staff != null && staff.getId() == staffId) {
                return staff;
            }
        }
        return null;
    }
}
