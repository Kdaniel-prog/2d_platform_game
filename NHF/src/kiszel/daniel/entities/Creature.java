package kiszel.daniel.entities;


import kiszel.daniel.game.Handler;
import kiszel.daniel.tiles.Tile;

import java.io.Serializable;

public abstract class Creature extends Entity implements Serializable {

    public static final float DEFAULT_SPEED = 3.0f;
    public static boolean isPlatform;
    protected float speed;
    protected float xMove, yMove;
    /**Azért esett erre az osztályra a választás mivel tovább fejlesztés esetén úgy képzelném el hogy
     * Entity osztálynak lenne egy item leszármozatja és annak a külömböző specifikus itemek lennének a gyerekei
     *
     * @param handler minden creaturenek átkell adni a gamet amti a handler kezel
     * @param x ez a x koordinátája a creaturnak
     * @param y ez a y koordinátája a creaturnak
     * @param width ez a szélessége a creaturnak
     * @param height ez a hosszúsága a creaturnak
     */
    public Creature (Handler handler, float x, float y, int width, int height) {
        super(handler,x, y, width, height);
        speed = DEFAULT_SPEED;
    }
        /**Move metódusok nagyon fontosak mivel a player csak akkor mozoghat ha nem ütközik solid tileba itt hívom meg a moveY és moveX metódusokat.*/
    public void move(){
        moveY();
        moveX();
    }
    /** itt nézzem, hogy a player ütközik e solid tileba ha nem akkor hozzá adom az x-hez a  xMove elmozdulást */
    public void moveX(){
        if(xMove > 0){
            int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEHEIGHT;
            if(!collisionWithTile(tx,(int)(y + bounds.y) / Tile.TILEHEIGHT) && !collisionWithTile(tx, (int) (y + bounds.y +bounds.height) /Tile.TILEHEIGHT)) {
                x += xMove;

            }
        }else if (xMove < 0){
            int tx = (int) (x + xMove + bounds.x) / Tile.TILEHEIGHT;

            if(!collisionWithTile(tx,(int)(y + bounds.y) / Tile.TILEHEIGHT) && !collisionWithTile(tx, (int) (y + bounds.y +bounds.height) /Tile.TILEHEIGHT)){
                x +=xMove;
            }
        }
    }
    /**
     * itt nézzem, hogy a player pályán van e ha nem akkor  a gravitáció aktiválódni fog amit player osztályon belül nézzek
     * és hogy y koordinátán van e ütközés solid tileal ha nincs akkor y-hez hozzá addom yMovet
     * */

    public void moveY(){ //fel
        if (yMove < 0){
            int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
            if(!collisionWithTile((int) (x + bounds.x) /Tile.TILEWIDTH, ty) &&
                    !collisionWithTile((int) (x + bounds.x + bounds.width) /Tile.TILEWIDTH, ty)){
                y += yMove;
                isPlatform = false;
            }else{
                isPlatform = true;

            }
        }else if(yMove > 0){ //le
            int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
            if(!collisionWithTile((int) (x + bounds.x) /Tile.TILEWIDTH, ty)&&
                    !collisionWithTile((int) (x + bounds.x + bounds.width) /Tile.TILEWIDTH, ty)){
                isPlatform = false;
                y += yMove;
            }else{
                isPlatform = true;

            }

        }
    }
    /**megnézem hogy a tile solid e ha igen true értéket add vissza*/
    protected boolean collisionWithTile(int x, int y){
        return handler.getWorld().getTile(x,y).isSolid();
    }
}
