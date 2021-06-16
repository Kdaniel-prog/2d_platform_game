package kiszel.daniel.UI;

import kiszel.daniel.game.Handler;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UIManager {
    /**
     * Ez az osztály azért fontos mert egy tömbbe lesznek majd tárolva a gombok.
     * erre azért volt szükség mert pl: menübe több gomb is van
     * Ebbe a classba található az Uiobjectek egy arraylistában
     * */
    private Handler handler;
    private ArrayList<UIObject> objects;

    /**
     *
     * @param handler megkapja a handlert
     *        létre hozzunk egy új arraylistet és UIonjectet állítombe osztálynak, hogy olyat vár majd
     */
    public UIManager(Handler handler){
        this.handler = handler;
        objects = new ArrayList<UIObject>();
    }
    /**
     * Minden uiobjectet egy for each ciklusba frisstítek le
     * */
    public void update(){
        for(UIObject o : objects)
            o.update();
    }
    /**
     * Minden uiobjectet egy for each ciklusba renderelek
     * */

    public void render(Graphics g){
        for(UIObject o : objects)
            o.render(g);
    }
    /**
     * Minden uiobjectet egy for each ciklusba nézzem meg, hogy az egér rajta van
     * object lehet null is ilyenkor tovább megyek
     * */

    public void onMouseMove(MouseEvent e) {
        try{
            for (UIObject o : objects) {
            if (objects != null) {
                o.onMouseMove(e);

            } else {
                continue;
                }
            }
        }catch(Exception  a){
            System.out.println(a);
        }
    }
    /**
     * Minden uiobjectet egy for each ciklusba nézzem meg, hogy az egér rajta lett e realeselve
     * object lehet null is ilyenkor tovább megyek
     * */

    public void onMouseRelease(MouseEvent e) {
        try {
            for (UIObject o : objects) {
                if (objects != null) {
                    o.onMouseRelease(e);

                } else {
                    continue;
                }
            }
        }catch(Exception a){
            System.out.println(a);
        }
    }

    /**
     *
     * @param o addObject metódussal lehet Uiobjectet hozzá adni az arraylisthez
     */

    public void addObject(UIObject o){
        objects.add(o);
    }

    /**
     *
     * @return visszaadja a handlert
     */
    public Handler getHandler() {
        return handler;
    }

    /**
     *
     * @param handler setteli a handlert
     */
    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
