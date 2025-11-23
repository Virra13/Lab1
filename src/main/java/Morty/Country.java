package Morty;

public class Country {

    private String name;
    private double area;
    private long population;
    private String capitalName;
    private long capitalPopulation;

    public Country(String name, double area, long population,
                   String capitalName, long capitalPopulation) {

        setName(name);
        setArea(area);
        setPopulation(population);
        setCapital(capitalName, capitalPopulation);
    }

   public Country(String name, double area, long population) {
        setName(name);
        setArea(area);
        setPopulation(population);
        this.capitalName = null;
        this.capitalPopulation = 0;
    }

    public String getName(){

        return name;
    }

    public void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название страны не может быть пустым");
        }
        this.name = name;
    }

    public double getArea() {

        return area;
    }

    public void setArea(double area) {

        if (area <= 0) {
            throw new IllegalArgumentException("Площадь должна быть строго больше нуля.");
        }
        this.area = area;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {

        if (population < 0) {
            throw new IllegalArgumentException("Население не может быть отрицательным.");
        }
        this.population = population;
    }

    public String getCapitalName() {

        return capitalName;
    }

    public void setCapitalName(String capitalName) {

        this.capitalName = capitalName;
    }

    public long getCapitalPopulation() {

        return capitalPopulation;
    }

    public double getPopulationDensity() {

        if (area <=0 || population <= 0) {
            throw new IllegalStateException("Невозможно вычислить плотность: некорректные данные.");

        }
        return population / area;

    }
}

    void setCapital(String capitalName, long capitalPopulation) {

    }

   public String toString(){

        return name + ": " + area + " км², население: " + population + "\nСтолица: " + capitalName + ", население: " + capitalPopulation;
    }
}

