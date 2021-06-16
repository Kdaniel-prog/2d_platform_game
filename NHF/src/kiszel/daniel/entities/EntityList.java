package kiszel.daniel.entities;

import kiszel.daniel.game.Handler;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;

import java.util.Iterator;

public class EntityList implements Serializable {
    private int timer;
    private Handler handler;
    private Player player;
    private ArrayList<Entity> entities;

   /**Ebbe a classba van az összes entitás egy arraylistben */

    public EntityList(Handler handler, Player player){
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<Entity>();
        addEntity(player);
    }
    /**itt updételem az összes entititást ha nem aktív és 40 egység eltelt akkor removolom az arraylistából */
    public void update(){
        Iterator<Entity> it = entities.iterator();
        while(it.hasNext()){
            Entity e = it.next();
            e.update();

            if (timer >= 40 && !e.isActive()){
                it.remove();
                timer = 0;
            }
            if (!e.isActive()){
                timer++;
            }
        }
    }
    /**kirajzolom minden egyes entitést */
    public void render(Graphics g){
        for(Entity e : entities){
            e.render(g);
        }
    }

    /**hozzá lehet adni egy entitást */

    public void addEntity(Entity e){
        entities.add(e);
    }

    //GETTERS SETTERS

    public Handler getHandler() {
        return handler;
    }
    public void setHandler(Handler handler) {
        this.handler = handler;
    }
    public ArrayList<Entity> getEntities() {
        return entities;
    }
    /**0 elem a player és így lehet hozzá férni */
    public Player getPlayer() {
        return (Player) entities.get(0);
    }
}