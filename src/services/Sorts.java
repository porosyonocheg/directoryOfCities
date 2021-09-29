package services;

public class Sorts {

    public static void lexicographicSort() {
        new DAO.extraServices.Sorts().lexicographicSort();
    }
    public static void lexicographicSortInSQL() {
        new DAO.extraServices.Sorts().lexicographicSortInSQL();
    }

    public static void districtAndNameSort() {
        new DAO.extraServices.Sorts().districtAndNameSort();
    }

    public static void districtAndNameSortInSQL() {
        new DAO.extraServices.Sorts().districtAndNameSortInSQL();
    }
}