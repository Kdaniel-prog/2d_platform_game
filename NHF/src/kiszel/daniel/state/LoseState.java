package kiszel.daniel.state;

import kiszel.daniel.UI.ClickListener;
import kiszel.daniel.UI.UIManager;
import kiszel.daniel.UI.UIObject;
import kiszel.daniel.game.Handler;
import kiszel.daniel.graphic.Assets;

import java.awt.*;
/**
 * Ezt az osztályt azért hoztam létre hogy ha játékos nem nyert és meghalt akkor ebbe a statebe lépünk
 * */
public class LoseState extends State {
    private UIManager uiManagerLose;
    /**
     * létre hozzok egy UImanagert kontstruktoron belül és gombok/gombokat hozzá adom
     * */
    public LoseState(Handler handler) {
        super(handler);
        uiManagerLose = new UIManager (handler);
        refreshButton();
    }
    /**
     * frissítem a Uimanagert és hozzáadom az egeret
     * */
    @Override
    public void update() {
        uiManagerLose.update();
        handler.getMouseManager().setUIManager(uiManagerLose);

    }

    @Override
    /**
     * beállítom a hátteret + hozzáadom a player figura képét és az uimanagert rendelem
     * */
    public void render(Graphics g) {
        g.drawImage(Assets.losebg,0,0,1600,800,null);
        g.drawImage(Assets.Rattack1,400,300,200,200,null);
        uiManagerLose.render(g);

    }
    /**
     * Ebbe a metódusban található az a gomb amit ha megnyomunk a menustatebe vált minket
     * */
    public void refreshButton(){
        uiManagerLose.addObject(new UIObject(670, 600, 200, 100, Assets.menu, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUIManager(null);
                State.setState(handler.getGame().menuState);

            }
        }));
    }

}