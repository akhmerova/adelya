package ru.kpfu.itis.group11403.akhmerova.Appliance;

/**
 * Created by Adelya on 14.02.2015.
 */
public class VacuumCleaner extends Appliance {

    private double volume;

    public VacuumCleaner(double price, double weight, double power, double volume, String model) {
        super(price, weight, power, model);
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    public double setVolume(double volume) {
        return volume;
    }

    public double getRating() {
        double rating = (price * 1000 + 1000 / weight + power * 100) * volume / 22;
        return rating;
    }
}
