package kiszel.daniel.UI;
/**
 * Erre az osztályra azért volt szükség, hogy tudjuk figyelni ha a player lenyomja a gombot.
 * ez a click hallgatozó
 * */
public interface ClickListener {
    /**
     * onClick metódust fogjuk a gomboknál alkalmazni.
     */
     default void onClick() {

    }

}
