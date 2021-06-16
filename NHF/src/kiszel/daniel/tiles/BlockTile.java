package kiszel.daniel.tiles;

import kiszel.daniel.graphic.Assets;
/**
 * Ez az osztály azért volt fontos mert kell egy block amivel ha a játékos érintkezik akkor nem tud tovább menni mint egy láthatatlan akadály
 * */
public class BlockTile extends Tile{
    /**
     *
     * @param id ha létre hozzunk egy BlockTilet kell neki egy egyedi id
     */

    public BlockTile(int id){
        super(Assets.hole,id);
    }


}
