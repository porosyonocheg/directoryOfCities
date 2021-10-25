package services;

public class CitiesByRegion {
    public static void getNumberOfCities() {
        Print.printListOfStrings(new DAO.extraServices.CitiesByRegion().getNumberOfCities());
    }
}