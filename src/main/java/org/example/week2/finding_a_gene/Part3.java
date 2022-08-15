package org.example.week2.finding_a_gene;

public class Part3 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
//        testSimpleGene();
        testTwoOccurences();

    }

    public static String findSimpleGene(String str, String startCodon, String stopCodon) {
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

    public static boolean twoOccurrences(String stringa, String stringb) {
        int aLength = stringa.length();
        int bLength = stringb.length();
        if (aLength >= bLength) {
            return false;
        }
        if (stringb.contains(stringa)) {
            int index = stringb.indexOf(stringa);
            if (stringb.substring(index + aLength).contains(stringa)) {
                return true;
            }
        }
        return false;

    }

    public static void testTwoOccurences() {
        System.out.println(twoOccurrences("by", "A story by Abby Long"));
        System.out.println(twoOccurrences("a", "banana"));
        System.out.println(twoOccurrences("atg", "ctgtatgta"));

        System.out.println(lastPart("an", "banana"));
        System.out.println(lastPart("forest", "zoo"));



    }

    public static String lastPart(String stringa, String stringb) {
        int aLength = stringa.length();
        int bLength = stringb.length();
        if (aLength >= bLength || !stringb.contains(stringa)) {
            return stringb;
        }
        int index = stringb.indexOf(stringa);
        return stringb.substring(index + aLength);

    }


}
