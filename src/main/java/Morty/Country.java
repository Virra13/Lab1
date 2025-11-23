package Morty;

public class Country {

    private String name;
    private double area;
    private long population;
    private String capitalName;
    private long capitalPopulation;

    Country(String name, double area, long population, String capitalName, long
            capitalPopulation) {
        this.name = name;
        this.area = area;
        this.population = population;
        this.capitalName = capitalName;
        this.capitalPopulation = capitalPopulation;
    }

    Country(String name, double area, long population) {
        this.name = name;
        this.area = area;
        this.population = population;
        this.capitalName = null;
        this.capitalPopulation = 0;
    }


    public String getName(){

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public double getArea() {

        return area;
    }

    public void setArea(double area) {

        this.area = area;
    }

    public long getPopulation() {
        return
                population;
    }

    public void setPopulation(long population) {

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

  /*
        public double getPopulationDensity() {
        if (area = double =<0) {
        }else {
           double v;
           v = population / area;
           return v;
        }
        }
      */

    public void setCapitalPopulation(Long capitalPopulation) {

        this.capitalPopulation = capitalPopulation;
    }

    void setCapital(String capitalName, long capitalPopulation) {

    }

   public String toString(){

        return name + ": " + area + " км², население: " + population + "\nСтолица: " + capitalName + ", население: " + capitalPopulation;
    }
}

