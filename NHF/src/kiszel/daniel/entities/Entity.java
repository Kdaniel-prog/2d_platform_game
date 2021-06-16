package kiszel.daniel.entities;

import kiszel.daniel.game.Handler;

import java.awt.*;
import java.io.Serializable;

public abstract class Entity implements Serializable {

    protected float x, y;
    protected int width, height;
    protected int live;
    protected Rectangle bounds;
    protected boolean active = true;
    protected Handler handler;

    /** Ez az  ős osztály és leszármazotjai azért fontos mert legjobban itt mutatkozik majd meg a OOP gondolkodás  entitásnak lesz -> Creature leszármozatja mivel akkár lehetne Item leszármazotja
     * és a creaturenek lesz player és az esetleges többi lény pl: bat, wolf
     * @param handler megkapja a handlert ami kezeli a gamet
     * @param x minden entitásnak lesz egy x pozíciója
     * @param y minden entitásnak lesz egy x pozíciója
     * @param width minden entitásnak lesz egy szélessége
     * @param height minden entitásnak lesz egy hosszúsága
     * 1 élete van minden entitásnak
     * minden entitásnak van egy téglalapja ezt fogom a playernél a coilsonél felhasználni
     */
    public Entity(Handler handler, float x, float y, int width, int height){
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        live = 1;
        bounds = new Rectangle(0,0,width,height);

    }
    //x

    /**
     *
     * @param x beállítjuk az entitás x paraméterét
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     *
     * @param y beállítjuk  az entitás y paraméterét
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     *
     * @return vissza adja az entitás x értékét
     */

    public float getX(){
        return x;
    }
    //y

    /**
     *
     * @return vissza adja az entitás y értékét
     */

    public float getY(){
        return y;
    }

    /**
     *
     * @return visszadja hogy az entitás él e
     */

    public boolean isActive() {
        return active;
    }


    //height width

    /**
     *
     * @return vissza adja az entitás szélesség értékét
     */
    public int getWidth(){
        return width;
    }

    /**
     *
     * @param width Beállítja az entitás szélesség értékét
     */
    public void setWidth(int width){
        this.width= width;
    }

    /**
     *
     * @return Beállítja az entitás hosszúságát
     */

    public int getHeight(){
        return height;
    }

    /**
     * minden entitásnak lesz egy update metódusa itt fogjuk frissíteni
     */
    public abstract void update();

    /**
     *
     * @param g minden entitásnak lesz egy render metódusa itt fogjuk az entitást rajzolni
     */

    public abstract void render(Graphics g);

    /**
     * ez a metódus megöli az entitást
     */
    public void entityDie(){
        live -= 1;
        active = false;
    }
}
