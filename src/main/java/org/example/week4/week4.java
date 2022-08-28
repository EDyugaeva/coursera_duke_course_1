package org.example.week4;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class week4 {

    public static void main(String[] args) {

        System.out.println(getTotalBirthsRankedHigher(2012, "Ethan", "M"));
    }

    public static void totalBirth(FileResource fr) {
        int totalBirth = 0;
        int totalGirls = 0;
        int totalBoys = 0;
        for (CSVRecord csvRecord : fr.getCSVParser(false)
        ) {
            int numBirth = Integer.parseInt(csvRecord.get(2));
            totalBirth += numBirth;
            if (csvRecord.get(1).equals("F")) {
                totalGirls += numBirth;
            } else {
                totalBoys += numBirth;
            }

            System.out.println("Total birth = " + totalBirth);
            System.out.println("Total girls birth = " + totalGirls);
            System.out.println("Total boys birth = " + totalBoys);

        }

    }

    public static int getRank(int year, String name, String gender) {
        String fileName = "C:\\Users\\ekate\\IdeaProjects\\coursera_duke_course_1\\testing\\us_babynames_by_year\\" + "yob" + year + ".csv";

        FileResource fileResource = new FileResource(fileName);
        return getRankFromFileResourse(fileResource, name, gender);
    }

    public static int getRankFromFileResourse(FileResource fileResource, String name, String gender) {
        int rank = 0;
        for (CSVRecord csvRecord :
                fileResource.getCSVParser(false)) {
            if (csvRecord.get(1).equalsIgnoreCase(gender)) {
                rank++;
                if (csvRecord.get(0).equals(name)) {
                    return rank;
                }
            }
        }
        return -1;
    }

    public static String getName(int year, int rank, String gender) {
        String fileName = "C:\\Users\\ekate\\IdeaProjects\\coursera_duke_course_1\\testing\\us_babynames_by_year\\" + "yob" + year + ".csv";
        FileResource fileResource = new FileResource(fileName);
        return getNameFromFileResource(fileResource, rank, gender);
    }

    public static String getNameFromFileResource(FileResource fileResource, int rank, String gender) {
        int num = 0;
        for (CSVRecord csvRecord :
                fileResource.getCSVParser(false)) {
            if (gender.equals(csvRecord.get(1))) {
                num++;
                if (num == rank) {
                    return csvRecord.get(0);
                }
            }
        }
        return "NO NAME";
    }

    public static void whatIsNameInYear(String name, int year, int newYear, String gender) {
        int rank = getRank(year, name, gender);
        String newName = getName(newYear, rank, gender);
        System.out.println(name + " was born in " + year + " would be " + newName + " if she(he) was born in " + newYear);

    }

    public static int yearOfHighestRank(String name, String gender) {
        DirectoryResource directoryResource = new DirectoryResource();
        int rank = Integer.MAX_VALUE;
        String fileName = " ";
        for (File f :
                directoryResource.selectedFiles()) {
            FileResource fileResource = new FileResource(f);
            int currentRank = getRankFromFileResourse(fileResource, name, gender);
            if (currentRank < rank) {
                rank = currentRank;
                fileName = f.getName();
            }
        }
        if (fileName.isBlank()) {
            return -1;
        }
        return Integer.parseInt(fileName.substring(3, 7));
    }

    public static double getAverageRank(String name, String gender) {
        DirectoryResource directoryResource = new DirectoryResource();
        int sum = 0;
        int size = 0;
        for (File f :
                directoryResource.selectedFiles()) {
            FileResource fileResource = new FileResource(f);
            int currentRank = getRankFromFileResourse(fileResource, name, gender);
            if (currentRank != -1) {
                sum = sum + currentRank;
            }
            size++;
        }
        if (sum == 0) {
            return -1;
        }
        return (double) sum / size;
    }

    public static int getTotalBirthsRankedHigher(int year, String name, String gender) {
        String fileName = "C:\\Users\\ekate\\IdeaProjects\\coursera_duke_course_1\\testing\\" + "yob" + year + "short.csv";
        FileResource fileResource = new FileResource(fileName);
        int rank = getRankFromFileResourse(fileResource, name, gender);
        int totalBirths = 0;
        int currentLine = 1;
        for (CSVRecord csvRecord :
                fileResource.getCSVParser(false)) {
            if (gender.equals(csvRecord.get(1)) && currentLine < rank) {
                totalBirths = Integer.parseInt(csvRecord.get(2)) + totalBirths;
                currentLine++;
            }
        }
        return totalBirths;

    }
}

