package ls11.aufgaben.mitarbeitergui.util.swing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ImageHandler {
    public static ImageHandler INSTANCE;

    Map<String, Image> imageMap = new HashMap<>();

    private ImageHandler() {
        readImages();
    }

    public static ImageHandler getInstance() {
        if (INSTANCE == null) INSTANCE = new ImageHandler();
        return INSTANCE;
    }

    private void readImages() {
        File f = new File(getClass().getResource("images").getFile());
        File[] files = f.listFiles();
        if(files == null)return;
        Image img;
        for(int i = 0; i < files.length; i++){
            try {
                img = ImageIO.read(files[i]);
                imageMap.put(files[i].getName(), img);
            } catch (IOException e) {
                continue;
            }
        }
    }

    public Image getImage(String imgKey) {
        return imageMap.get(imgKey);
    }

    public Icon getIcon(String imgKey) {
        return new ImageIcon(getImage(imgKey));
    }
}
