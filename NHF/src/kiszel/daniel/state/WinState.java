package kiszel.daniel.state;

import kiszel.daniel.UI.ClickListener;
import kiszel.daniel.UI.UIManager;
import kiszel.daniel.UI.UIObject;
import kiszel.daniel.game.Handler;
import kiszel.daniel.graphic.Assets;

import java.awt.*;
import java.io.Serializable;
/**Ez az osztály azért fontos mert ha nyerünk akkor ebbe statebe váltunk */
public class WinState extends State implements Serializable {
    private UIManager uiManagerwin;

    /**
     *
     * @param handler megkapja a handler objectumot
     *        létre hozzok egy UImanagert kontstruktoron belül és refresbutton() metúdussal hozzá addom a gombok/gombokat
     */

    public WinState(Handler handler) {
            super(handler);
            uiManagerwin = new UIManager(handler);
            refreshButton();
        }
    /**
     * frissítem a Uimanagert és hozzáadom az egeret
     * */
        @Override
        public void update() {
            uiManagerwin.update();
            handler.getMouseManager().setUIManager(uiManagerwin);

        }

    /**
     *
     * @param g minden osztálynak van grapicsa amire fogunk rajzolni.
     */
    @Override
        public void render(Graphics g) {
            g.drawImage(Assets.wingbg,0,0,1600,800,null);
            g.drawImage(Assets.Rattack2,350,300,200,200,null);
            uiManagerwin.render(g);

        }

    /**
     * refreshButtonbe található a menube váltó gomb ha rákkatintunk akkor átváltunk abba a statebe
      */
        public void refreshButton(){
            uiManagerwin.addObject(new UIObject(670, 600, 200, 100, Assets.menu, new ClickListener() {
                @Override
                public void onClick() {
                    handler.getMouseManager().setUIManager(null);
                    State.setState(handler.getGame().menuState);

                }
            }));
        }
    }