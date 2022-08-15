package org.example.week2.finding_all_gene;

import edu.duke.StorageResource;

public class Part2 {
    public static void main(String[] args) {
        testHowMany();
        test();
        StorageResource st = new StorageResource();
    }

    public static int howMany(String stringA, String stringB) {
        int sum = 0;
        int currIndex = 0;
        int startIndex = stringB.indexOf(stringA);
        while (startIndex >-1) {
            sum++;
            currIndex = currIndex + startIndex+1;
            startIndex = stringB.indexOf(stringA, currIndex);
        }
        return sum;
    }

    public static void testHowMany() {
        String test1="abc";
        int a1 = howMany(test1, "abcudhgkdjhfkgjdhk");
        int a2 = howMany(test1, "sdfdgdgdfgdfgdfg");
        int a3 = howMany(test1, "abcudhgkdjabcgjdhk");
        int a4 = howMany(test1, "abcabcgkdjhfkgjdabc");

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);



    }

    public static void findAbc(String input) {
        int index = input.indexOf("abc");
        while (true) {
            if (index == -1 || index >= input.length() - 3) {
                break;
            }
            String found = input.substring(index+1, index+4);
            System.out.println(found);
            index = input.indexOf("abc", index+3);
        }
    }
    public static void test() {
        findAbc("abcabcabcabca");


    }
}
