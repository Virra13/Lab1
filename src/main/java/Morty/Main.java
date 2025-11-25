package Morty;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Country[] countries = new Country[10];
        Scanner scanner = new Scanner(System.in);

        // Иницилизация тестовых данных
        countries[0] = new Country("Russia", 17100000, 146700000, "Moscow", 12600000);
        countries[1] = new Country("Finland", 338000, 5500000, "Helsinki", 655000);
        countries[2] = new Country("France", 643800, 67800000, "Paris", 2100000);
        countries[3] = new Country("Andorra", 467, 85400, "Andorra la Vella", 22600);
        countries[4] = new Country("Singapore", 2, 5700000);

        String exit = "exit";
        String create = "create";
        String print = "print";

        int index = 5;

        while (true) {

            System.out.println("Введите команду:");
            String command = scanner.nextLine().trim().toLowerCase();

            if(command.equals(exit)){

                System.out.println("Программа завершена.");
                break;

            }else if (command.equals(create)) {

                String name;
                while (true) {
                    System.out.println("Введите название страны:");
                    name = scanner.nextLine().trim();

                    try {
                        Country.validateName(name);
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }

                double area;
                while (true) {
                    System.out.println("Введите площадь (км²):");
                    String input = scanner.nextLine().trim();

                    try {
                        area = Double.parseDouble(input);
                        Country.validateArea(area);
                            break;
                    }catch (NumberFormatException e) {
                        System.out.println("Введите число.");
                    }catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }

                long population;
                while (true) {
                    System.out.println("Введите население:");
                    String input = scanner.nextLine().trim();

                    try {
                        population = Long.parseLong(input);
                        Country.validatePopulation(population);
                        break;
                    }catch (NumberFormatException e) {
                        System.out.println("Введите число.");
                    }catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }

                String answer;
                while (true) {
                    System.out.println("Есть ли столица? (y/n):");
                    answer = scanner.nextLine().trim().toLowerCase();

                    if (answer.equals("y") || answer.equals("n")) {
                        break;
                    }else {
                        System.out.println("Некорректный ввод. Введите 'y' или 'n'.");
                    }
                }

                Country newCountry;
                if (answer.equals("y")) {

                    System.out.println("Введите название столицы");
                    String capitalName = scanner.nextLine().trim();

                    long capitalPopulation;
                    while (true) {
                        System.out.println("Введите население столицы:");
                        String input = scanner.nextLine().trim();

                        try {
                            capitalPopulation = Long.parseLong(input);
                            break;
                        }catch (NumberFormatException e) {
                            System.out.println("Введите число.");
                        }
                    }

                    newCountry = new Country(name, area, population, capitalName, capitalPopulation);

                } else {
                    newCountry = new Country(name, area, population);

                }

                if (index >= countries.length) {
                    countries = extendArray(countries);
                }

                countries[index] = newCountry;

                System.out.println("Страна добавлена: " + newCountry.getName());
                index++;

            }else if(command.equals(print)) {
                printAll(countries);

            }else {
                System.out.println("Неизвестная команда. Доступные: create, print, exit.");
            }
        }
    }

    public static void printAll(Country[] countries) {

        for(Country c : countries){
            if(c != null) {
                System.out.println(c);
            }
        }

    }

    @org.jetbrains.annotations.NotNull
    private static Country[] extendArray(Country[] oldArray) {
        Country[] newArray = new Country[oldArray.length * 2];
        System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
        return newArray;
    }

}
