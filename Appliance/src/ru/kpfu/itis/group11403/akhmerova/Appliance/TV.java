package ru.kpfu.itis.group11403.akhmerova.Appliance;

/**
 * Created by Adelya on 14.02.2015.
 */
public class TV extends Appliance {

    private double diag;

    public TV(double price, double weight, double power, double diag, String model) {
        super(price, weight, power, model);
        this.diag = diag;
    }

    public double getDiag() {
        return diag;
    }

    public double setDiag(double diag) {
        return diag;
    }

    public double getRating() {
        double rating = (price * 1000 + 1000 / weight + power * 100) * diag / 100;
        return rating;
    }
}

