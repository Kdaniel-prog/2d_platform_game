package kiszel.daniel.graphic;

import kiszel.daniel.entities.Entity;
import kiszel.daniel.game.Handler;
/**Ez az osztály azért fontos, hogy mindig a player legyen a kamera fókuszában az osztály lényege,
 *  hogy a playerhez képest milyen távolságról kell megrajzolni a tilokat eredeti helyükhöz képest mivel mindig azt szeretnénk, hogy csak az látszódjon ami a képernyőn van */
public class GameCamera  {
    private Handler handler;
    private float xOffset, yOffset;

    /**
     *
     * @param handler megkapja handlert
     * @param xOffset ez a x kezdő  koordinátája
     * @param yOffset ez a y kezdő koordinátája
     */
    public GameCamera(Handler handler,float xOffset, float yOffset){
        this.handler = handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }
    /**Az xOffset: A képernyő széleségének a fele és a player magassága
     * Az yOffset: A képernyő a hosszúságának a fele és a player szélessége
     * */
    public void centerOnEntity(Entity e){
        xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth();
        yOffset = e.getY() - (handler.getHeight() / 2) + e.getHeight();
    }

    /**
     *
     * @return visszaadja x értékét
     */
    public float getxOffset(){
        return xOffset;
    }

    /**
     *
     * @return visszaadja a y értékét
     */
    public float getyOffset(){
        return yOffset;
    }

}