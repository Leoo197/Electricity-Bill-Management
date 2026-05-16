package models;

public class AppData {

    public static Consumer currentConsumer;

    public static FileManager fileManager =
            new FileManager();

    public static Tariff tariff = new Tariff(5, 7, 10);
}