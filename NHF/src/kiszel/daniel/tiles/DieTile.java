package kiszel.daniel.tiles;


import kiszel.daniel.graphic.Assets;
/**
 * Ez az osztály azért volt fontos mert kellet egy block amivel ha a játékos érintkezik akkor meghal
 * */
public class DieTile extends Tile{
    public DieTile(int id){
        super(Assets.hole,id);
    }
    @Override
    /**
     * ez a metódus felül írja az ős metódusát és ha player ezzel érintkezik keresztül tud rajta menni
     */
	public boolean isSolid(){
        return false;
    }
    /**
     * ez a metódus felül írja az ős metódusát és ha ezzel érintkezik a player az megöli
     * */
    @Override
	public boolean isKill() {return true;}
}

