package kiszel.daniel.graphic;

import java.awt.image.BufferedImage;
import java.io.Serializable;

/**
 * Ez az osztály felel azért hogy a "Sprite sheetjeimet" (játékok fejlesztésénél a karakter mozgásait egy nagy képbe rakják össze mert
 * így sok erőforrást megspórolnak vele) kezelje.
  */

public class SpriteSheet  implements Serializable {
    private BufferedImage sheet;

    /**
     *
     * @param sheet egy képet kap
     */
    public  SpriteSheet (BufferedImage sheet){
        this.sheet = sheet;
    }

    /**
     * crop: kivágjuk a kép darabokat. és returnoli
     * */
    public BufferedImage crop(int x, int y, int width, int lenght){
        return sheet.getSubimage(x, y, width, lenght);
    }

}
