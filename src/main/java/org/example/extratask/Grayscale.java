package org.example.extratask;

import edu.duke.DirectoryResource;
import edu.duke.ImageResource;
import edu.duke.Pixel;

import java.io.File;

public class Grayscale {

    public static void main(String[] args) {
        testGray();
    }

    public static ImageResource makeGray(ImageResource imageResource) {
        ImageResource outImage = new ImageResource(imageResource.getWidth(), imageResource.getHeight());
        outImage.setFileName(imageResource.getFileName());
        for (Pixel pixel :
                outImage.pixels()) {
            Pixel inPixel = imageResource.getPixel(pixel.getX(), pixel.getY());
            int average = (inPixel.getBlue() + inPixel.getGreen() + inPixel.getRed()) / 3;
            pixel.setBlue(average);
            pixel.setRed(average);
            pixel.setGreen(average);
        }

        return outImage;
    }

    public static void testGray() {
        DirectoryResource dr = new DirectoryResource();
        for (File fr :
                dr.selectedFiles()) {
            ImageResource gray = makeGray(new ImageResource(fr));
            saveImage(gray);
        }

    }

    public static void saveImage(ImageResource imageResource) {
        String fName = imageResource.getFileName();
        System.out.println(fName);
        String newName = "gray-" + fName;
        System.out.println(newName);

        imageResource.setFileName(newName);
        imageResource.save();
    }



}
