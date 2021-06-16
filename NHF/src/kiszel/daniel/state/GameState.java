package kiszel.daniel.state;

import kiszel.daniel.game.Handler;
import kiszel.daniel.graphic.Assets;
import kiszel.daniel.worlds.World;

import java.awt.*;
/**
 *  ez az osztály azért votl fontos mert a GameStateben hozzom létre a világot  és  itt updatelem és renderelem mindent ami a worldbe van.
 * */
public class GameState extends State{
    private World world;

    /**
     *
     * @param handler egy handler kell hogy egy Gamestate obj létre hozzunk
     * itt hozzuk létre az új viláhot és itt adjuk meg a világnak azt a fájlt ahonnan beolvassa a tile idjét
     */
    public GameState(Handler handler){
        super(handler);
        world = new World(handler,"res/worlds/world1.txt");
        handler.setWorld(world);

    }
    /**
     * Itt frissítem a world classt.
     * */
    @Override
	public void update(){
        world.update();
    }
    /**
     * itt rendelem a hátteret és a worldot
     * */
    @Override
	public void render (Graphics g){
        g.drawImage(Assets.bg,0,0,1600,800,null);
        world.render(g);
    }


}
