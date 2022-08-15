package org.example.week2.finding_a_gene;

public class Part1 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        testSimpleGene();

    }

    public static String findSimpleGene(String str) {
        String result = "";
        if (!str.contains("ATG") || !str.contains("TAA"))
        {
            return "";
        }
        else {
            int indexStart = str.indexOf("ATG");
            int indexEnd = str.lastIndexOf("TAA");
            if ((indexEnd - indexStart) %3 ==0) {
                return str.substring(indexStart, indexEnd+3);
            }
            return result;

        }


    }

    public static void testSimpleGene() {
        String DNA = "ATGHHGEGFWHJEFJHDALDLA";
        System.out.println("dna:  " + DNA);
        System.out.println("Result :" + findSimpleGene(DNA));

        DNA = "ATGHHGEGFWHJETAADA";
        System.out.println("dna:  " + DNA);
        System.out.println("Result :" + findSimpleGene(DNA));

        DNA = "dATGHGFRJEFJTTAALDLA";
        System.out.println("dna:  " + DNA);
        System.out.println("Result :" + findSimpleGene(DNA));

        DNA = "FTYHATGHGEGFWHJETAAFJHDALDLA";
        System.out.println("dna:  " + DNA);
        System.out.println("Result :" + findSimpleGene(DNA));

        DNA = "AAATGCCCTAACTAGATTAAGAAACC";
        System.out.println("dna:  " + DNA);
        System.out.println("Result :" + findSimpleGene(DNA));
    }


}
