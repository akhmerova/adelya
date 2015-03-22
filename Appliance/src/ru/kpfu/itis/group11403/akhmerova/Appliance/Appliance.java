package ru.kpfu.itis.group11403.akhmerova.Appliance;

/**
 * Created by Adelya on 14.02.2015.
 */
public class Appliance implements Comparable {

    double price, weight, power;
    String model;
    public static final double E = 0.00000001;

    public Appliance(double price, double weight, double power, String model) {
        this.price = price;
        this.weight = weight;
        this.power = power;
        this.model = model;
    }

    public double getRating() {
        double rating = price * 1000 + 1000 / weight + power * 100;
        return rating;
    }

    @Override
    public int compareTo(Object obj) {
        if (obj instanceof Appliance) {
            if (this.getRating() > ((Appliance) obj).getRating()) {
                return 1;
            } else if (this.getRating() < ((Appliance) obj).getRating()) {
                return -1;
            } else {
                return 0;
            }
        }
        return -100;
    }
}


