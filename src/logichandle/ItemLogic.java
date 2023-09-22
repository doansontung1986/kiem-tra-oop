package logichandle;

import entity.Item;
import entity.Staff;
import utilities.CheckValidInput;

import java.util.Scanner;

public class ItemLogic {
    private Item[] items = new Item[100];

    public Item[] getItems() {
        return items;
    }

    public void inputItemList() {
        System.out.print("Nhập số lượng hàng hóa cần thêm: ");
        int numberOfItem = CheckValidInput.inputValidNumber();
        for (int i = 0; i < numberOfItem; i++) {
            System.out.println("Nhập thông tin hàng hóa thứ " + (i + 1));
            Item item = new Item();
            item.inputInfo();
            saveStaff(item);
        }
    }

    private void saveStaff(Item item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                break;
            }
        }
    }

    public void displayItemList() {
        System.out.printf("%-12s | %-16s | %-20s | %-12s |\n", "Mã hàng hóa", "Tên hàng hóa", "Nhóm hàng", "Số lượng");
        for (Item item : items) {
            if (item != null) {
                item.displayInfo();
            }
        }
    }

    public Item searchItemById(int itemId) {
        for (Item item : items) {
            if (item != null && item.getId() == itemId) {
                return item;
            }
        }
        return null;
    }
}
