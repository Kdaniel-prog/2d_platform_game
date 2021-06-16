package kiszel.daniel.graphic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
/**
 * Ez az osztály azért volt fontoos, hogy az esetleges nem létező fájl hibát lekezeljem
 * és ne legyen olyan hosszú a Asssetsnél a képbetöltése
 * */
public class ImageLoader {
    /**
     *
     * @param path ez a fájl elérés útja
     * @return visszaadja a képet
     * ha nincs kép lekezelem a hibát és nullt adja vissza
     */
    public static  BufferedImage loadImage (String path){
        try{

            return ImageIO.read(ImageLoader.class.getResource(path));

        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
