package org.example.week2.finding_a_gene;

public class Part2 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        testSimpleGene();

    }

    public static String findSimpleGene(String str, String startCodon, String stopCodon ) {
        if (str.contains(startCodon) && str.contains(stopCodon)) {
            int indexStart = str.indexOf(startCodon);
            int indexEnd = str.indexOf(stopCodon);
            if ((indexEnd - indexStart) % 3 == 0) {
                return str.substring(indexStart, indexEnd+3);
            }
        }
        return "";


    }

    public static void testSimpleGene() {
        String DNA = "ATGHHGEGFWHJEFJHDALDLA";
        System.out.println("dna:  " + DNA);
        System.out.println("Result :" + findSimpleGene(DNA, "ATG", "TAA"));

        DNA = "ATGHHGEGFWHJETAADA";
        System.out.println("dna:  " + DNA);
        System.out.println("Result :" + findSimpleGene(DNA, "ATG", "TAA"));

        DNA = "dATGHGFRJEFJTTAALDLA";
        System.out.println("dna:  " + DNA);
        System.out.println("Result :" + findSimpleGene(DNA, "ATG", "TAA"));

        DNA = "FTYHATGHGEGFWHJETAAFJHDALDLA";
        System.out.println("dna:  " + DNA);
        System.out.println("Result :" + findSimpleGene(DNA, "ATG", "TAA"));

        DNA = "ATGHHGEGFWHJEFJHDALDLA";
        System.out.println("dna:  " + DNA);
        System.out.println("Result :" + findSimpleGene(DNA, "ATG", "TAA"));
    }


}
