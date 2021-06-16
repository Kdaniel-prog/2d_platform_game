package kiszel.daniel.tiles;


import kiszel.daniel.graphic.Assets;
/**
 * Ez az osztály  azért kellet, hogy az üres teret töltse ki
 * */
public class HoleTile extends Tile{
    /**
     *
     * @param id ha létre hozzunk egy HoleTile kell neki egy egyedi id
     */
    public HoleTile(int id){
        super(Assets.hole,id);
    }
    @Override
    /**
     * Ha ezzel érintkezik a player akkor keresztül tud rajta menni
     */
	public boolean isSolid(){
        return false;
    }
}
