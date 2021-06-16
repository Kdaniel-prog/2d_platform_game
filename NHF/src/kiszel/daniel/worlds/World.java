package kiszel.daniel.worlds;


import kiszel.daniel.entities.Bat;
import kiszel.daniel.entities.EntityList;
import kiszel.daniel.entities.Player;
import kiszel.daniel.game.Handler;
import kiszel.daniel.tiles.Tile;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

public class World implements Serializable {
    private Handler handler;
    private EntityList entityList;

    private int width, height;
    private int[][] tiles;

    /**
     *Ez az osztály azért fontos mert itt hozzuk létre a világot és az entitásokat
     * megkapja a handlert
     * entytylistet hogy létre hozzunk megkapja a handlert és a player mindig az első elemének kell, hogy legyne
     * utána többi entitás amit bele akkarunk rakni a entitylistbe
     * setteljük az entitylistet
     * @param handler megkapja a handlert
     * @param path megkapja a world.txt elérési útját
     */

    public World(Handler handler,String path){
        this.handler = handler;
        entityList = new EntityList(handler, new Player(handler , 100, 100));
        entityList.addEntity(new Bat(handler, 800,430));
        entityList.addEntity(new Bat(handler, 520,400));
        entityList.addEntity(new Bat(handler, 1500,400));
        entityList.addEntity(new Bat(handler, 1220,350));
        entityList.addEntity(new Bat(handler, 1700,430));
        entityList.addEntity(new Bat(handler, 2100,390));
        entityList.addEntity(new Bat(handler, 3220,400));
        entityList.addEntity(new Bat(handler, 3700,420));
        entityList.addEntity(new Bat(handler, 3500,420));
        handler.setEntityList(entityList);
        loadWorld(path);
    }

    /**
    * itt frissítem az összes entitást az Entitylistbe egy for each ciklusba végig
    * megyek az összes entitáson
    * */
    public void update(){
        entityList.update();

    }

    /**itt rendelem a pályát de csak azt jelenitem meg ami a Gamecamerába
     * látszódni fog így sok erőforrást megspórolunk
     * xStart és ystartal a kezdetét és a yEnd és xEnd meghatározom a végét a megjelenítésnek
     * majd rendelenem a entitylistet természetesn itt is egy for each ciklusal megyek végig
     * getTile.render megadja milyen toválságra kell rendelelni a tileokat az eredeti pózicijukhoz képest
     * */

    public void render(Graphics g){
        int Xstart = (int) Math.max(0,handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
        int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1 );
        int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
        int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
        for(int y = yStart; y < yEnd; y++){
            for(int x = Xstart; x < xEnd; x++){
                getTile(x,y).render(g,(int) (x*Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),(int) (y*Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));

            }
        }
        entityList.render(g);
    }

    /**
     * @param x ez a x koordinátája tilenak
     * @param y z a y koordinátája tilenak
     * @return vissza adjda x,y  koordinátán lévő tilet
     */

    public Tile getTile(int x, int y){
        Tile t = Tile.tiles[tiles[x][y]];
        return t;
    }

    /**
     * Ez a metódus tölti be a pályát az első 2 sor adja mega széleségét és
     * hosszúságát amit az egymásba ágyazot for ciklusba
     * használok fel regex:\\s+ egy vagy több szóköz karakterének a sorrendjét adja meg
     * */

    private void loadWorld(String path){
        String file = World.loadFileAsString(path);
        String [] tokens;
        tokens = file.split("\\s");
        width = Integer.parseInt(tokens[0]);
        height = Integer.parseInt(tokens[1]);
        tiles = new int[width][height];
        for( int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                tiles[x][y] = Integer.parseInt(tokens[(x + y *width) + 2]);
            }
        }
    }

    /**
     * itt olvasombe a páylát stringként
     * ez a metódus nem adhat nullt vissza
     * */
    public static String loadFileAsString(String path){
        StringBuilder builder = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while((line=br.readLine()) != null){
                builder.append(line + "\n");
            }

            br.close();

        }catch(IOException e){
            e.printStackTrace();
        }
        return builder.toString();
    }

    /**
     *
     * @return visszaadja a entityListet
     */
    public EntityList getEntityList() {
        return entityList;
    }

    /**
     *
     * @return visszsaadja a handlert
     */
    public Handler getHandler() {
        return handler;
    }

    /**
     *
     * @param handler setteli a handlert
     */
    public void setHandler(Handler handler) {
        this.handler = handler;
    }

}
