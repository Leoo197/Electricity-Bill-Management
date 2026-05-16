package models;
import models.Tariff;

import java.io.Serializable;


public class BillingSystem implements Serializable {
    private double totalAmount;
    private Consumer consumer;
    private ElectricityBill bill;
    private Tariff tariff;
    public BillingSystem(Consumer consumer,Tariff tariff){
        this.consumer = consumer;
        this.tariff=tariff;
    }

    public void calculateBill(double unitsConsumed){
        tariff.setTariff(consumer.getCategory());
        bill=new ElectricityBill(unitsConsumed,Tariff.getBillPerUnit(),Tariff.getTaxPercentage(),consumer);
        this.totalAmount=tariff.calculateTariff(unitsConsumed)+bill.calculateBill();
    }


    public void generateBill(){
        bill.displaybill();
        System.out.println("total bill="+totalAmount);
    }
    public Consumer getConsumer(){
        return consumer;
    }
    public double getTotalAmount() {

        return totalAmount;
    }
}
