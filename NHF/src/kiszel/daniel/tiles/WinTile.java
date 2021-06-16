package kiszel.daniel.tiles;

import kiszel.daniel.graphic.Assets;
/**ez az osztály grass kép kockát adja vissza de ez külön id fog menni és ha ezzel érintkezik a player akkor nyert */
public class WinTile extends Tile{
    public WinTile(int id){
        super(Assets.grass,id);
    }
    @Override
	public boolean isWin(){
        return true;
    }
}