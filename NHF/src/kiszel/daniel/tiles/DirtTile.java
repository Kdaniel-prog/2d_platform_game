package kiszel.daniel.tiles;

import kiszel.daniel.graphic.Assets;
/**
 * Ezt az osztály azért kellet hogy a föld elemű pálya darabot megjelenítse
 **/
public class DirtTile extends Tile{
    /**
     *
     * @param id ha létre hozzunk egy DirtTile kell neki egy egyedi id
     */
    public DirtTile(int id){
        super(Assets.dirt,id);
    }

}