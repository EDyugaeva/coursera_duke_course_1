package org.example.week2.finding_all_gene;

public class Part3 {

    public static void main(String args[]) {
        System.out.println(countGenes("ATGTAAGATGCCCTAGT"));

    }


    public static int findStopCodon(String name, int startIndex, String stopCodon) {
        int stopIndex = name.indexOf(stopCodon, startIndex);
        while (stopIndex > 0) {
            if ((stopIndex - startIndex) % 3 == 0) {
                return stopIndex;
            }
            int currIndex = stopIndex + 1;
            stopIndex = name.indexOf(stopCodon, currIndex);
        }

        return name.length();
    }

    public static String findGene(String dna) {
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) {
            return "";
        }

        int stopIndexTAA = findStopCodon(dna, startIndex, "TAA");
        int stopIndexTAG = findStopCodon(dna, startIndex, "TAG");
        int stopIndexTGA = findStopCodon(dna, startIndex, "TGA");


        if (stopIndexTAA < stopIndexTAG && stopIndexTAA < stopIndexTGA) {
            return dna.substring(startIndex, stopIndexTAA + 3);
        }

        if (stopIndexTAG < stopIndexTAA && stopIndexTAG < stopIndexTGA) {
            return dna.substring(startIndex, stopIndexTAG + 3);
        }
        if (stopIndexTGA < stopIndexTAA && stopIndexTGA < stopIndexTAG) {
            return dna.substring(startIndex, stopIndexTGA + 3);
        }

        return "";

    }

    public static void printAllGenes(String dna) {
        int currIndex = 0;
        while (true) {
            String result = findGene(dna.substring(currIndex));
            if (result.isEmpty()) {
                break;
            }

            currIndex = result.length() + currIndex;
            System.out.println(result);
        }

    }

    public static int countGenes(String dna) {
        int currIndex = 0;
        int sum = 0;
        while (true) {
            String result = findGene(dna.substring(currIndex));
            currIndex = result.length() + currIndex;
            if (result.isEmpty()) {
                return sum;
            }
            sum++;
        }

    }


}
