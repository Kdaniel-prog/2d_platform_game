package kiszel.daniel.UI;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class UIObject {

    protected float x, y;
    protected int width, height;
    protected Rectangle bounds;
    protected boolean hovering = false;
    private BufferedImage[] images;
    private ClickListener clicker;

    /**
     * EZ az osztál azért fontos mert gombokkal tuudunk lépkedni a menübe
     *
     *
     * @param x minden gombnak van egy x koordinátája
     * @param y minden gombnak van egy y koordinátája
     * @param width minden gombnak van egy szélessége
     * @param height minden gombnak van egy hosszúsága
     * @param images minden gombnak van egy kép tömbe amibe 2 db kép van
     * @param clicker minden gombra lehet kattintani
     * Minden gombnak van egy téglalap teste
     */
    public UIObject(float x, float y, int width, int height, BufferedImage[] images, ClickListener clicker){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        bounds = new Rectangle((int) x, (int) y, width, height);
        this.images = images;
        this.clicker = clicker;
    }
    /**
     * majd az UImanagerbe fogom for each ciklusba frissíteni az elemeket
     * */
    public void update() {

    }
    /**
     * ha az egeret ráviszük a képre akkor a tömb második elemét kell, hogy visszaadja
     * */
    public void render(Graphics g){
        if(hovering){
            g.drawImage(images[1], (int) x, (int) y, width, height, null);
        }else{
            g.drawImage(images[0], (int) x, (int) y, width, height, null);
        }
    }
    /**
     * ha képre kattintunk meghívjuk a clicklistenert
     * */
    public void onClick() {
        clicker.onClick();
    }

    /**
     * ha az egér x és y koordinátája érintkezik a téglalap koordinátáival akkor a hovering true lesz ha nem akkor falset adja vissza
     * */
    public void onMouseMove(MouseEvent e){
        if(bounds.contains(e.getX(), e.getY())){
            hovering = true;
        }else{
            hovering = false;
        }

    }
    /**
     * ha a hovering igaz akkor onClick metódust haasználhatjuk
     * */
    public void onMouseRelease(MouseEvent e){
        if(hovering)
            onClick();
    }



}