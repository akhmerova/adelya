package ru.kpfu.itis.group11403.akhmerova.Appliance;

import java.util.Arrays;

/**
 * Created by Adelya on 15.03.2015.
 */
public class Main {
    public static void main(String[] args) {
        Appliance[] appliance = new Appliance[4];
        appliance[0] = new VacuumCleaner(3000, 50, 220, 70, "Vacuum Cleaner Bio");
        appliance[1] = new TV(5000, 70, 300, 30, "TV 300");
        appliance[2] = new Blender(2250, 5, 120, "Blender Turbo");
        appliance[3] = new Toster(1000, 77.7, 90, "Toster 90");
        Arrays.sort(appliance);

        for (int i = 0; i < appliance.length; i++) {
            System.out.println(appliance[i].getRating() + " " + appliance[i].model);
        }
    }
}
