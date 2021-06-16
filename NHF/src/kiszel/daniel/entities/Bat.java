package kiszel.daniel.entities;

import kiszel.daniel.game.Handler;
import kiszel.daniel.graphic.Animation;
import kiszel.daniel.graphic.Assets;

import java.awt.*;
/**
 * ez az osztály azért fontos hogy legyen egy elllenség aki akadályoza playert.
 * A bat osztály a Creature leszármazotja és az x tengelyen mozog 80 egységet amíg active (él)
 * */
public class Bat extends Creature{
    private Animation bat_move, die_effect;
    private float x = super.x;
    private int movingx;
    private boolean maxLeft =  true;
    private boolean maxRight = false;
    public static final int BatWidth = 60;
    public static final int BatHeight = 60;

    /**
     *
     * @param handler bat megkapja handlert
     * @param x van x kezdő koordninátája
     * @param y van y kezdő koordinátája
     */
    public Bat(Handler handler, float x, float y) {
        super(handler, x, y, BatWidth,BatHeight);
        bat_move = new Animation(200, Assets.bat_move);
        die_effect = new Animation(300,Assets.die_effect);
    }
    /** itt updatelem (frissítem) a bat osztály mozgását a dieeffectet ha meghalt a bat és a mozgását.
     *
     * */
    @Override
    public void update() {
        bat_move.update();
        if(!this.isActive()){
            die_effect.update();
        }

        getMove();

    }
    /**
     *  itt mozgatom a batet x tengelyen odéb 80 pixelel balra elsőnek ha elérte a 80 akkor jobbra mozgatom addig ameddig megnem hal
     * */
    private void getMove() {
        if (movingx <= 80 && !maxRight){
            movingx += 1;
            x += 1;
        }

        if (movingx == 80) {
            maxRight = true;
            maxLeft = false;
            movingx = 0;
        }

        if ( movingx >= -80 && !maxLeft){
            movingx -= 1;
            x -= 1;
        }
        if ( movingx == -80){
            maxRight = false;
            maxLeft = true;
            movingx = 0;

        }
    }
    /**
     * Itt rendelem a bat osztályt ha él akkor mozgás animációt rajzolom ha meghal akkor a die animációt.
     * */
    @Override
    public void render(Graphics g) {
        if (super.isActive()){
            g.drawImage(bat_move.getCurrentFrame(),(int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()),width,height,null);
        }

        if (!super.isActive()){
            g.drawImage(die_effect.getCurrentFrame(),(int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()),width,height,null);
        }
    }
}


