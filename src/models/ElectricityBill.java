package models;

import java.io.Serializable;

public class ElectricityBill implements Serializable,BillOperations {
    private double unitsConsumed;
    private double billAmount;
    private double tax;
    private Consumer consumer;
    private double totalAmount;

    ElectricityBill(double unitsConsumed, double billAmount, double tax, Consumer consumer){
        this.unitsConsumed=unitsConsumed;
        this.billAmount=billAmount;
        this.tax=tax;
        this.consumer=consumer;
    }
    public double calculateBill(){
        totalAmount=unitsConsumed*billAmount;
        totalAmount=totalAmount+totalAmount*(tax/100);
        return totalAmount;
    }
    public void displaybill(){
        consumer.displayDetails();
        System.out.println("unitsConsumed:"+unitsConsumed);
        System.out.println("bill Per Unit:"+billAmount);
        System.out.println("tax:(in %)"+tax);
        System.out.println("tax:(in %)"+tax);
        System.out.println("Total amount without tariff:"+totalAmount);
    }

}
