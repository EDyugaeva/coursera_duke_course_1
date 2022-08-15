package org.example.week2.finding_a_gene;

import edu.duke.URLResource;

public class Part4 {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        URLResource file = new  URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
        for (String item : file.words()) {
            String itemLower = item.toLowerCase();
            int pos = itemLower.indexOf("youtube.com");

            if (pos != -1) {
                System.out.println(item);
                System.out.println("pos = " + pos);

                int beg = item.lastIndexOf("\"", pos);
                int end = item.indexOf("\"", pos + 1);

                System.out.println("beg = " + beg );
                System.out.println("end = " + end );

                System.out.println(item.substring(beg + 1, end));
            }
        }

    }




}
