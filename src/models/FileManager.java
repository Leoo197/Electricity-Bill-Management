package models;

import java.io.*;
import java.util.ArrayList;

public class FileManager {
    private static final String CONSUMER_FILE = "consumers.dat";
    private static final String BILL_FILE = "bills.dat";

    public void saveConsumer(Consumer consumer) {
        ArrayList<Consumer> consumers = loadConsumers();
        consumers.add(consumer);
        try {
            ObjectOutputStream oos =new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(CONSUMER_FILE)));
            oos.writeObject(consumers);
            oos.close();
            System.out.println("Consumer Saved Successfully");
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList<Consumer> loadConsumers() {
        ArrayList<Consumer> consumers = new ArrayList<>();
        try {
            File file = new File(CONSUMER_FILE);
            if(!file.exists() || file.length() == 0) {
                return consumers;
            }
            ObjectInputStream ois =new ObjectInputStream(new BufferedInputStream(new FileInputStream(CONSUMER_FILE)));
            consumers = (ArrayList<Consumer>) ois.readObject();
            ois.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return consumers;
    }
    public void saveBill(BillingSystem bill) {
        ArrayList<BillingSystem> bills = loadBills();
        bills.add(bill);
        try {
            ObjectOutputStream oos =new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(BILL_FILE)));
            oos.writeObject(bills);
            oos.close();
            System.out.println("Bill Saved Successfully");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<BillingSystem> loadBills() {
        ArrayList<BillingSystem> bills = new ArrayList<>();
        try {
            File file = new File(BILL_FILE);
            if(!file.exists() || file.length() == 0) {
                return bills;
            }
            ObjectInputStream ois =new ObjectInputStream(new BufferedInputStream(new FileInputStream(BILL_FILE)));
            bills = (ArrayList<BillingSystem>) ois.readObject();
            ois.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return bills;
    }
    public void displayAllConsumers() {
        ArrayList<Consumer> consumers = loadConsumers();
        for(Consumer c : consumers) {
            c.displayDetails();
            System.out.println("-------------------");
        }
    }
    public void displayBillHistory(int consumerId) {
        ArrayList<BillingSystem> bills = loadBills();
        boolean found = false;
        for(BillingSystem bill : bills) {
            if(bill.getConsumer().getConsumerId() == consumerId) {
                bill.generateBill();
                System.out.println("-------------------");
                found = true;
            }
        }
        if(!found) {
            System.out.println("No Bills Found");
        }
    }
}
