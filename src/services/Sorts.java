package services;

public class Sorts {

    public static void lexicographicSort() {
        Print.printListofCities(new DAO.extraServices.Sorts().lexicographicSort());
    }
    public static void lexicographicSortInSQL() {
        Print.printListOfStrings(new DAO.extraServices.Sorts().lexicographicSortInSQL());
    }

    public static void districtAndNameSort() {
        Print.printListofCities(new DAO.extraServices.Sorts().districtAndNameSort());
    }

    public static void districtAndNameSortInSQL() {
        Print.printListOfStrings(new DAO.extraServices.Sorts().districtAndNameSortInSQL());

    }
}