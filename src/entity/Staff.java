package entity;

import java.util.Scanner;

public class Staff extends Person {
    private static int AUTO_ID = 1000;
    private int id;
    private String contractDate;

    public Staff() {
        this.id = AUTO_ID;
        AUTO_ID++;
    }

    public int getId() {
        return id;
    }

    public String getContractDate() {
        return contractDate;
    }

    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
    }

    @Override
    public void inputInfo() {
        super.inputInfo();
        System.out.print("Nhập ngày ký hợp đồng: ");
        this.contractDate = new Scanner(System.in).nextLine();
    }

    @Override
    public void displayInfo() {
        System.out.printf("%-12s | %-16s | %-16s | %-12s | %-16s |\n", this.id, this.name, this.address, this.phoneNumber, this.contractDate);
    }
}
