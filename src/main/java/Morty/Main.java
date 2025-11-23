package Morty;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Country[] countries = new Country[5];
        Scanner scanner = new Scanner(System.in);

        String exit = "exit";
        String create = "create";
        String print = "print";

        int index = 0;

        while (true) {

            System.out.println("Введите команду:");
            String command = scanner.nextLine().toLowerCase();

            if(command.equals(exit)){

                System.out.println("Программа завершена.");
                break;

            }else if (command.equals("create")) {

                String name;
                while (true) {
                    System.out.println("Введите название страны:");
                    name = scanner.nextLine();

                    try {
                        Country.validateName(name);
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }

                System.out.println("Введите площадь (км²):");

                double area;
                while (true) {
                    String line = scanner.nextLine();
                    try {
                        area = Double.parseDouble(line);
                        if (area > 0) {
                            break;
                        }else  {
                            System.out.println("Значение должно быть больше нуля.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Введите число.");
                        }
                }

                System.out.println("Введите население:");
                long population;
                while (true) {
                    String line = scanner.nextLine();
                    try {
                        population = Long.parseLong(line);
                        if (population )
                    }
                }
                //Long population = Long.parseLong(scanner.nextLine());//

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
                    String capitalName = scanner.nextLine();
                    System.out.println("Введите население столицы:");
                    Long capitalpopulation = Long.parseLong(scanner.nextLine());

                    newCountry = new Country(name, area, population, capitalName, capitalpopulation);

                } else {
                    newCountry = new Country(name, area, population);

                }

                countries[index] = newCountry;

                System.out.println("Страна добавлена: " + name);
                index++;

            }else if(command.equals("print")) {
                printAll(countries);

            }else {
                System.out.println("Неизвестная команда. Доступные: create, print, exit.");
            }
        }
    }

    public static void printAll(Country[] countries) {

        for(int i=0; i<countries.length; i++){
            if(countries[i]!=null) {
                System.out.println(countries[i].toString());
            }
        }

    }

}
