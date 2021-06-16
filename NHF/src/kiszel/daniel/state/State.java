package kiszel.daniel.state;

import kiszel.daniel.game.Handler;

import java.awt.*;

/**
 * Ez az osztály azért fontos mert több féle "State van" pl: menustate, gamestate ezek között szeretnénk lépkedni.
 */
public abstract class State{
    /**
     * currentstate nullt adja vissza ha nincs state beállítva
     */
    private static State currentState = null;
    protected Handler handler;
    /**
     *
     * @param state visszaadja melyik statebe vagyunk
     */
    public static void setState (State state){
        currentState = state;
    }

    /**
     *
     * @return visszaadja a currentStatet.
     */

    public static State getState(){
        return currentState;
    }

    /**
     *
     * @param handler visszaadja a handlert
     */
    public State (Handler handler){
        this.handler = handler;
    }

    /**
     * minden statenek van updatje frissítése
     */
    public abstract void update();

    /**
     *
     * @param g minden osztálynak van grapicsa amire fogunk rajzolni.
     */
    public abstract void render(Graphics g);

}
