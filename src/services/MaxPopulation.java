package services;

public class MaxPopulation {
    public static void getMaxPopulation() {
        Print.printString(new DAO.extraServices.MaxPopulation().getMaxPopulation());
    }
}