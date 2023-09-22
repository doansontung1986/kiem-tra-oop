package entity;

import statics.ItemGroup;
import utilities.CheckValidInput;

import java.util.Scanner;

public class Item implements Inputable, Displayable {
    private static int AUTO_ID = 1000;
    private int id;
    private String itemName;
    private ItemGroup itemGroup;
    private int quantity;

    public Item() {
        this.id = AUTO_ID;
        AUTO_ID++;
    }

    public int getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public ItemGroup getItemGroup() {
        return itemGroup;
    }

    public void setItemGroup(ItemGroup itemGroup) {
        this.itemGroup = itemGroup;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void inputInfo() {
        System.out.print("Nhập tên hàng hóa: ");
        this.itemName = new Scanner(System.in).nextLine();

        System.out.println("Nhập nhóm hàng, chọn 1 trong các loại sau đây: ");
        System.out.println("1. Điện tử");
        System.out.println("2. Điện lạnh");
        System.out.println("3. Máy tính");
        System.out.println("4. Thiết bị văn phòng");

        int type;

        do {
            type = CheckValidInput.inputValidNumber();

            switch (type) {
                case 1:
                    this.setItemGroup(ItemGroup.DIEN_TU);
                    break;
                case 2:
                    this.setItemGroup(ItemGroup.DIEN_LANH);
                    break;
                case 3:
                    this.setItemGroup(ItemGroup.MAY_TINH);
                    break;
                case 4:
                    this.setItemGroup(ItemGroup.THIET_BI_VAN_PHONG);
                    break;
            }

            if (type > 0 && type < 5) {
                break;
            }

            System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại");
        } while (true);

        System.out.print("Nhập số lượng: ");
        this.quantity = CheckValidInput.inputValidNumber();
    }

    @Override
    public void displayInfo() {
        System.out.printf("%-12s | %-16s | %-20s | %-12s |\n", this.id, this.itemName, this.itemGroup.value, this.quantity);
    }
}
