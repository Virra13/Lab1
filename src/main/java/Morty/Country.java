package Morty;

public class Country {

    private String name;
    private double area;
    private long population;
    private String capitalName;
    private long capitalPopulation;

    // --------- валидаторы ----------
    public static void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название страны не может быть пустым");
        }
    }

    public static void validateArea(double area) {
        if (area <= 0) {
            throw new IllegalArgumentException("Площадь должна быть строго больше нуля.");
        }
    }

    public static void validatePopulation(long population) {
        if (population < 0) {
            throw new IllegalArgumentException("Население не может быть отрицательным.");
        }
    }

    public static void validateCapitalName(String capitalName) {
        if (capitalName == null || capitalName.trim().isEmpty()) {
            throw new IllegalArgumentException("Название столицы не может быть пустым");
        }
    }

    public static void validateCapitalPopulation(long capitalPopulation) {
        if (capitalPopulation < 0) {
            throw new IllegalArgumentException("Население столицы не может быть отрицательным.");
        }
    }

    // Конструктор со столицей
    public Country(String name, double area, long population,
                   String capitalName, long capitalPopulation) {

        setName(name);
        setArea(area);
        setPopulation(population);
        setCapital(capitalName, capitalPopulation);
    }

    // Конструктор без столицы (страна-город)
    public Country(String name, double area, long population) {
        setName(name);
        setArea(area);
        setPopulation(population);
    }

    // --------- геттеры ----------
    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    public long getPopulation() {
        return population;
    }

    public String getCapitalName() {
        return capitalName;
    }

    public long getCapitalPopulation() {
        return capitalPopulation;
    }

    // --------- сеттеры  ----------
    public void setName(String name) {
        validateName(name);
        this.name = name;
    }

    public void setArea(double area) {
        validateArea(area);
        this.area = area;
    }

    public void setPopulation(long population) {
        validatePopulation(population);
        this.population = population;
    }

    // Управление столицей
    public void setCapital(String capitalName, long capitalPopulation) {
        if (capitalName == null) {
            this.capitalName = null;
            this.capitalPopulation = 0;
            return;
        }

        validateCapitalName(capitalName);
        validateCapitalPopulation(capitalPopulation);

        this.capitalName = capitalName;
        this.capitalPopulation = capitalPopulation;
    }

    // Плотность населения
    public double getPopulationDensity() {

        if (area <= 0 || population <= 0) {
            throw new IllegalStateException("Невозможно вычислить плотность: некорректные данные.");

        }
        return population / area;
    }

    // toString
    @Override
    public String toString() {
        String p = "";
        if (population > 0) {
            p = ", население: " + population;
        }

        String c = "";
        if (capitalName != null && capitalPopulation > 0) {
            c = "\nСтолица: " + capitalName + ", население: " + capitalPopulation;
        }

        return name + ": " + String.format("%.0f", area) + " км²" + p + c;
    }

}