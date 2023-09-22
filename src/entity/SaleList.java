package entity;

import java.util.Arrays;

public class SaleList {
    private Staff staff;
    private SaleDetail[] saleDetails;

    public SaleList(Staff staff, SaleDetail[] saleDetails) {
        this.staff = staff;
        this.saleDetails = saleDetails;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public SaleDetail[] getSaleDetails() {
        return saleDetails;
    }

    public void setSaleDetails(SaleDetail[] saleDetails) {
        this.saleDetails = saleDetails;
    }

    @Override
    public String toString() {
        return "SaleList{" + "staff=" + staff.getName() + ", saleDetails=" + Arrays.toString(saleDetails) + '}';
    }
}
