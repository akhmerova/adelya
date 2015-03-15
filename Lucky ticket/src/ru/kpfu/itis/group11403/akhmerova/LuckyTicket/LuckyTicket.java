package ru.kpfu.itis.group11403.akhmerova.LuckyTicket;

/**
 * Created by Adelya on 20.02.2015.
 */
public class LuckyTicket {


    public static void main(String[] args) {
        long numberOfLuckyTickets = 0;

        for (long a1 = 0; a1 <= 9; a1++) {
            for (long a2 = 0; a2 <= 9; a2++) {
                for (long a3 = 0; a3 <= 9; a3++) {
                    for (long a4 = 0; a4 <= 9; a4++) {
                        for (long a5 = 0; a5 <= 9; a5++) {
                            long a6 = (a1 + a2 + a3) - (a4 + a5);
                            if (a6 >= 0 && a6 <= 9) {
                                numberOfLuckyTickets = numberOfLuckyTickets + 1;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Количество счастливых билетов " + numberOfLuckyTickets);
        System.out.println("Вероятность счастливого билета " + (numberOfLuckyTickets / Math.pow(10, 6)));
    }
}
