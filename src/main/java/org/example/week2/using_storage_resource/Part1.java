package org.example.week2.using_storage_resource;

import edu.duke.StorageResource;

public class Part1 {

    public static void main(String args[]) {

    }

    public int findStopCodon(String name, int startIndex, String stopCodon) {
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

    public String findGene(String dna) {
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

    public void printAllGenes(String dna) {
        int currIndex = 0;
        while (true) {
            String result = findGene(dna.substring(currIndex));
            currIndex = result.length() + currIndex;

            if (result.isEmpty()) {
                break;
            }

            System.out.println(result);
        }
    }

    public StorageResource getAllGenes(String dna) {
        StorageResource sr = new StorageResource();
        int currIndex = 0;
        while (true) {
            String result = findGene(dna.substring(currIndex));
            currIndex = result.length() + currIndex;

            if (result.isEmpty()) {
                break;
            }
            sr.add(result);
        }
        return sr;
    }


}
