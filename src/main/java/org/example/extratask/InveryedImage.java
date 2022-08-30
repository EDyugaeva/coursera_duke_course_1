package org.example.extratask;

import edu.duke.DirectoryResource;
import edu.duke.ImageResource;
import edu.duke.Pixel;

import java.io.File;

public class InveryedImage {
    public static void main(String[] args) {
        testNegativeImage();
    }

    public static ImageResource makeInverted(ImageResource imageResource) {
        ImageResource outImage = new ImageResource(imageResource.getWidth(), imageResource.getHeight());
        outImage.setFileName("inverted-" + imageResource.getFileName());

        for (Pixel pixel :
                outImage.pixels()) {
            Pixel inPixel = imageResource.getPixel(pixel.getX(), pixel.getY());

            pixel.setGreen(255-inPixel.getGreen());
            pixel.setRed(255-inPixel.getRed());
            pixel.setBlue(255-inPixel.getBlue());


        }
        outImage.save();
        outImage.draw();
        return outImage;

    }

    public static void testNegativeImage() {
        DirectoryResource dr = new DirectoryResource();
        for (File f:
             dr.selectedFiles()) {
            ImageResource ir = makeInverted(new ImageResource(f));

        }
    }

}
