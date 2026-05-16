package models;

import java.io.Serializable;

public class Tariff implements Serializable {
    private  double agriculturalTariff;
    private  double domesticTariff;
    private  double commercialTariff;
    private  double basePrice;
    private static double billPerUnit;
    public Tariff(double agriculturalTariff,double domesticTariff,double commercialTariff){
        this.agriculturalTariff=agriculturalTariff;
        this.domesticTariff=domesticTariff;
        this.commercialTariff=commercialTariff;
    }
    private static double taxPercentage;
    public  double getAgriculturalTariff() {
        return agriculturalTariff;
    }
    public   void setAgriculturalTariff(double price ){
        agriculturalTariff=price;
    }
    public  double getDomesticTariff() {
        return domesticTariff;
    }
     public  void setDomesticTariff(double price ){
        domesticTariff=price;
    }
    public  double getCommercialTariff() {
        return commercialTariff;
    }
     public  void setCommercialTariff(double price ){
        commercialTariff=price;
    }
    public  double getBasePrice() {
        return basePrice;
    }
    public  void setTariff(String category){
        if(category.equals("domestic")){
            this.basePrice=this.domesticTariff;
        }else if(category.equals("commercial")){
            basePrice=commercialTariff;
        }else{
            basePrice=agriculturalTariff;
        }
    }
    //0-150
    //150-250
    //250+
    public  double calculateTariff(double unitsConsumed){
        if(unitsConsumed<=150){
            return unitsConsumed*basePrice;
        }else if(unitsConsumed<=250){
            return (150*basePrice)+(unitsConsumed-150)*basePrice*1.5;
        }else{
            return (150*basePrice)+(100*basePrice*1.5)+(unitsConsumed-250)*basePrice*1.8;
        }

    }
    public static void setBillPerUnit(double value) {
        billPerUnit = value;
    }
    public static void setTaxPercentage(double tax) {
        taxPercentage = tax;
    }
    public static double getBillPerUnit() {

        return billPerUnit; 
    }

    public static double getTaxPercentage() {

        return taxPercentage;
    }


}