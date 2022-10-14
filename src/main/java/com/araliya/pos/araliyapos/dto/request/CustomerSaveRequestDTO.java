package com.araliya.pos.araliyapos.dto.request;

import java.util.ArrayList;

public class CustomerSaveRequestDTO {
    private String customerName;
    private String customerAddress;
    private double salary;
    private ArrayList contactNumbers;
    private boolean activeState;

    public CustomerSaveRequestDTO() {
    }

    public CustomerSaveRequestDTO(String customerName, String customerAddress, double salary, ArrayList contactNumbers, boolean activeState) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.salary = salary;
        this.contactNumbers = contactNumbers;
        this.activeState = activeState;
    }


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public ArrayList getContactNumbers() {
        return contactNumbers;
    }

    public void setContactNumbers(ArrayList contactNumbers) {
        this.contactNumbers = contactNumbers;
    }

    public boolean isActiveState() {
        return activeState;
    }

    public void setActiveState(boolean activeState) {
        this.activeState = activeState;
    }

    @Override
    public String toString() {
        return "CustomerSaveRequestDTO{" +
                "customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", salary=" + salary +
                ", contactNumbers=" + contactNumbers +
                ", activeState=" + activeState +
                '}';
    }
}
