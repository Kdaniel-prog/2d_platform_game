package kiszel.daniel.game;

/**
 * Main osztály azért fontos mert itt indutjuk el a játékot
 */
public class Main {
    /**
     *
     * @param args mainen belül hozzunk létre egy új Game osztályt és a game metódussal inditjuk el a játékkot.
     */
    public static void main (String[] args) {

        Game game = new Game("Palika - adventures",1600,800);
        game.start();

    }
}