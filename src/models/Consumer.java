package models;

import java.io.Serializable;

public class Consumer implements Serializable  {
    private String name;
    private int consumerId;
    private String address;
    private String category;
    private double phase;
    private double load;

    public Consumer(String name, int consumerId, String address, String category, double phase, double load){
        this.name=name;
        this.consumerId=consumerId;
        this.address=address;
        this.category=category;
        this.phase=phase;
        this.load=load;

    }

    public void displayDetails(){
        System.out.println("name:"+name);
        System.out.println("consumer Id :"+consumerId);
        System.out.println("address: "+address);
        System.out.println("category:"+category);
        System.out.println("phase:"+phase);
        System.out.println("load"+load);
    }
    public String getCategory(){
        return category;
    }
    public int getConsumerId(){
        return consumerId;
    }
}