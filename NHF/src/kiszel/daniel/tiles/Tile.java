package kiszel.daniel.tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Tile {
    /**
     * Ez az osztály azért fontos mert tilokkal fogom a pályát megjeleníteni
     *
     * Minden Tilenak van egy egyedi idja ami reprezentálja az adott tilet
     * ezeket az egyedi tileokat itt hozzom létre
     * */

    public static Tile[] tiles = new Tile[256];
    public static Tile  grassTile = new GrassTile(2);
    public static Tile  dirtTile = new DirtTile(1);
    public static Tile  holeTile = new HoleTile(0);
    public static Tile dieTile = new DieTile(8);
    public static Tile  blockTile = new BlockTile(3);
    public static Tile winTile = new WinTile(9);
    public static Tile flagTile = new FlagTile(5);
    /**
     * Minden tile 64*64 pixel
     * */
    public static final int TILEWIDTH = 64, TILEHEIGHT = 64;

    protected BufferedImage texture;
    protected final int id;

    /**
     *
     * @param texture minden tilenak van egy bufferimage képe
     * @param id és egy egyedi idja
     */
    public Tile(BufferedImage texture,int id){
        this.texture = texture;
        this.id = id;
        tiles[id] = this;
    }

    /**
     *
     * @return visszaadja a idját a tilenak
     */
    public int getId(){
        return id;
    }
    /**
     *
     * @param g Grapics g vel rajzoljuk ki a képet az ablakban
     * @param x ez a x koordináta hova kell
     * @param y ez a y koordináta hova kell
     * observer null azt írta java hivatalos oldala ez általában mindig null értéket kell beírni
     */
    public void render(Graphics g, int x, int y){
        g.drawImage(texture,x,y,TILEWIDTH,TILEHEIGHT,null);
    }

    /**
     *
     * @return minden tile alapvetően kemény (solid)
     */
    public boolean isSolid(){
        return true;
    }

    /**
     *
     * @return minden tile alapvetően nem őli meg a playert
     */
    public boolean isKill() { return false;}

    /**
     *
     * @return minden tile alapvetően nem egy "nyerő" tile
     * ha egy nyerő tilal érintkezik a player akkor megynerte a játékot
     */
    public boolean isWin() {return false;}


}
