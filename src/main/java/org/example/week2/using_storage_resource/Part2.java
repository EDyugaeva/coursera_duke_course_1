package org.example.week2.using_storage_resource;

public class Part2 {

    public static void main(String args[]) {

    }

    public  float cgRatio(String dna) {
        int sum = 0;
        char[] arr = dna.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'C' || arr[i] == 'G') {
                sum++;
            }

        }
        float result = (float) sum/dna.length();
        return result;

    }

    public int countCTG(String dna) {
        int startIndex = dna.indexOf("CTG");
        int sum = 0;
        while (startIndex > -1) {
            sum++;
            startIndex =dna.indexOf("CTG", startIndex + 3);

        }
        return sum;
    }
}
