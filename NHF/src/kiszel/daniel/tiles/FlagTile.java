package kiszel.daniel.tiles;

import kiszel.daniel.graphic.Assets;

public class FlagTile extends Tile{
    /** ez az osztály azért fontos mert kellet egy egyedi osztály a zászlónak hogy tudjuk hol a pálya vége
     * Ez a zászlónak az osztálya
     * @param id ha létre hozzunk egy FlagTile kell neki egy egyedi id
     */
    public FlagTile(int id){
        super(Assets.flag,id);
    }
    /**
     * ez a metódús felül írja az ős isSolid metódusát és ez egy nem solid elem lesz
     * */
    @Override
	public boolean isSolid(){
        return false;
    }


}