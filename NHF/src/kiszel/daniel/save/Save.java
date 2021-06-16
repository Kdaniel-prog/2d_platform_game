package kiszel.daniel.save;

import java.io.Serializable;
/**
 * Ez az osztályt azért hoztam létre mivel a grafika és a motor egybe lett rakva ezért külön osztályból nyerem és olvasom be az adatokat
 * */
public class Save implements Serializable {
    private float x;
    private float y;
    private int health;

    public int getHealth() {
        return health;
    }
    public float getSaveY() {
        return y;
    }
    public float getSaveX() {
        return x;
    }
    public void setSaveX(float x) {
        this.x = x;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setSaveY(float y) {
        this.y = y;
    }
}
