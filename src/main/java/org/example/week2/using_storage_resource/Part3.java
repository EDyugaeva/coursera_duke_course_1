package org.example.week2.using_storage_resource;

import edu.duke.StorageResource;

public class Part3 {
    Part2 part2 = new Part2();

    public static void main(String[] args) {

    }

    public void processGenes(StorageResource sr) {
        for (String string:
                sr.data()) {

            if (string.length() >= 9) {
                System.out.println(string);
                System.out.println("Длина ДНК = " + string.length());

            }
        }
        int count = 0;
        for (String string:
                sr.data()) {
            count++;
            if (part2.cgRatio(string) > 0.35f) {
                System.out.println(string);
                System.out.println("Номер строки, где cgRatio > 0.35 " + count);

            }
        }

        int max = Integer.MIN_VALUE;
        for (String string :
                sr.data()) {
            if (string.length() > max) {
                max = string.length();
            }
        }

        System.out.println("Максимальная длина: " + max);

    }
}
