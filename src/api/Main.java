package api;

import services.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.println("Выберите требуемое действие:\n1 - Список городов\n2 - Сортировка списка городов по наименованию в алфавитном порядке по убыванию без учета регистра\n21 - Сортировка списка городов по наименованию в алфавитном порядке по убыванию без учета регистра (Средствами SQL)\n3 - Сортировка списка городов по федеральному округу и наименованию города внутри каждого федерального округа в алфавитном порядке по убыванию с учетом регистра\n31 - Сортировка списка городов по федеральному округу и наименованию города внутри каждого федерального округа в алфавитном порядке по убыванию с учетом регистра (средствами SQL)\n4 - Поиск города с наибольшим количеством жителей\n5 - Поиск количества городов в разрезе регионов\n6 - Добавить города из файла в БД\n7 - Выход");
                int menu = Integer.parseInt(br.readLine());
                switch (menu) {
                    case 1:
                        Print.printCities(); break;
                    case 2:
                        Sorts.lexicographicSort(); break;
                    case 21:
                        Sorts.lexicographicSortInSQL(); break;
                    case 3:
                        Sorts.districtAndNameSort(); break;
                    case 31:
                        Sorts.districtAndNameSortInSQL(); break;
                    case 4:
                        MaxPopulation.getMaxPopulation(); break;
                    case 5:
                        CitiesByRegion.getNumberOfCities(); break;
                    case 6:
                        System.out.println("Введите путь к файлу: ");
                        AddDataFromFile.add(br.readLine());
                        System.out.println("Данные успешно добавлены");
                        break;
                    case 7:
                        CloseConnection.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid input data, try again...");
                }
            }
            catch (NumberFormatException ex) {
                System.out.println("Invalid input data, try again...");
            }
            catch(IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}