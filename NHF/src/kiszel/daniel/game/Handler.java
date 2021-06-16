package kiszel.daniel.game;

import kiszel.daniel.entities.EntityList;
import kiszel.daniel.graphic.GameCamera;
import kiszel.daniel.input.KeyManager;
import kiszel.daniel.input.MouseManager;
import kiszel.daniel.worlds.World;

import java.io.Serializable;

/**
 * A handler osztály azért felel, hogy a legtöbb settert és gettert kezelje így nem a gamet kell mindenkinek átadni
 */

public class Handler implements Serializable {
    private Game game;
    private World world;
    private EntityList entityList;

    /**
     *
     * @param game Handler konstruktorában beálltjuk neki a game osztályt.
     */
    public Handler(Game game){
        this.game = game;
    }

    /**
     *
     * @param entityList beállítja az EntityList osztályhoz az entytyListet
     */

    public void setEntityList(EntityList entityList) {
        this.entityList = entityList;
    }

    /**
     *
     * @return vissza adja a World osztály entityListáját mivel a World osztályon belül hozzuk létre az entitásokat és rakjuk őket egy arraylistába
     */

    public EntityList getEntityList() {
        return this.getWorld().getEntityList();
    }


    /**
     *
     * @return visszaadja a gamecamerat
     */

    public GameCamera getGameCamera(){
        return game.getGameCamera();
    }

    /**
     *
     * @return visszaadja a keymanagert
     */

    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }

    /**
     *
     * @return visszaadja az ablak szélességét
     */

    public int getWidth(){
        return game.getWidth();
    }

    /**
     *
     * @return visszaadja az ablak hosszúságát
     */
    public int getHeight(){
        return game.getHeight();
    }

    /**
     *
     * @return visszaadja a gamet
     */

    public Game getGame(){
        return  game;
    }

    /**
     *
     * @param game Game osztályhoz beállítja az adot game létrehozott osztályt
     */

    public void setGame(Game game){
        this.game = game;
    }

    /**
     *
     * @return visszaadja a worldot
     */
    public World getWorld(){
        return world;
    }

    /**
     *
     * @param world World osztályhoz beállítja az adott world létrehozott osztályt
     */
    public void setWorld(World world){
        this.world = world;
    }

    /**
     *
     * @return visszadja a gamebe létrehozott Mousemanagerét
     */

    public MouseManager getMouseManager(){
        return game.getMouseManager();
    }


}
