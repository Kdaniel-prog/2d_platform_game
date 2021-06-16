package kiszel.daniel.graphic;

import java.awt.image.BufferedImage;

public class Animation  {
    private int speed, index;
    private long timer,lastTime;
    private BufferedImage [] frames;
   /** ez az osztály azért volt fontos mert animációkat használok a player és a bat entitásnál
    * Az animációk egy BufferedImage tömbök és ahhoz, hogy egy animáticót létre hozhassunk meg kell adni a képek váltakozó sebbeségét és a kép tömböt átkell adni a animációnak
     * @param speed ez a sebbesége a képek váltakozásának
     * @param frames ez a  kép tömb
     */
    public Animation(int speed, BufferedImage[] frames ){
        this.speed = speed;
        this. frames = frames;
        index = 0;
        timer  = 0;
        lastTime = System.currentTimeMillis();
    }
    /**
     * Itt nézzem, hogy frissíteni kell e a képet ha igen akkor a következő animációt küldöm vissza ha a index végére érünk akkor a 0 elemet küldöm vissza
     * */
    public void update(){
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        if(timer > speed){
            index++;
            timer = 0;
            if(index >= frames.length){
                index = 0;
            }
        }
    }

    /**
     * @return vissza adja az aktuális képet a tömböl
     */
    public BufferedImage getCurrentFrame(){
        return frames[index];
    }
}
