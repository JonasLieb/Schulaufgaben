package ls13.aufgaben.rollenspiel.util;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class ImageHandler {
    public static final int STANDARD_WIDTH = 12;
    public static final int STANDARD_HEIGHT = 12;
    private static HashMap<String, BufferedImage> imageMap;
    public static final String MAIN_ICON = "icon.png";
    public static final String TUNNEL_IMAGE = "tunnel.png";
    public static final String[] imageNames = new String[]{
            MAIN_ICON,
            TUNNEL_IMAGE
    };

    private static void initializeMap() {
        imageMap = new HashMap<>();
        Arrays.stream(imageNames).forEach(name -> imageMap.put(name, getImageFromFileSystem(name)));
    }

    public static BufferedImage getBufferedImage(String key) {
        if (imageMap == null) {
            initializeMap();
        }
        return imageMap.get(key);
    }


    private static BufferedImage getImageFromFileSystem(String filename) {
        try {
            return ImageIO.read(Objects.requireNonNull(ImageHandler.class.getResource(filename)));
        } catch (Exception e) {
            System.err.println("Image konnte nicht ermittelt werden. FehlerMeldung: " + e.getMessage());
            return null;
        }
    }

    public static ImageIcon getImageIcon(String key, Color c) {
        return getImageIcon(getBufferedImage(key), c, STANDARD_WIDTH, STANDARD_HEIGHT);
    }

    public static ImageIcon getImageIcon(String key, Color c, int width, int height) {
        return getImageIcon(getBufferedImage(key), c, width, height);
    }

    public static ImageIcon getImageIcon(BufferedImage bufferedImage, Color color, int width, int height) {
        try {
            bufferedImage = getChangedColorImage(bufferedImage, color); // set color
            ImageIcon img = new ImageIcon(bufferedImage); // load the image to a imageIcon
            Image image = img.getImage(); // transform it
            Image newimg = image.getScaledInstance(width, height, Image.SCALE_SMOOTH); // it
            return new ImageIcon(newimg); // transform it back
        } catch (Exception e) {
            return null;
        }
    }

    public static ImageIcon getImageIcon(BufferedImage bufferedImage, Color color) {
        return getImageIcon(bufferedImage, color, bufferedImage.getWidth(), bufferedImage.getHeight());
    }

    public static BufferedImage getChangedColorImage(BufferedImage image, Color c) {
        if (image == null) return null;
        int width = image.getWidth();
        int height = image.getHeight();
        WritableRaster raster = image.getRaster();

        for (int xx = 0; xx < width; xx++) {
            for (int yy = 0; yy < height; yy++) {
                int[] pixels = raster.getPixel(xx, yy, (int[]) null);
                pixels[0] = c.getRed();
                pixels[1] = c.getGreen();
                pixels[2] = c.getBlue();
                raster.setPixel(xx, yy, pixels);
            }
        }
        return image;
    }
}