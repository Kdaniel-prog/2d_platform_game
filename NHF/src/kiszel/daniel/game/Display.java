package kiszel.daniel.game;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import java.awt.*;
import java.io.Serializable;

/**
 * A Display osztály azért fontos mert itt hozom létre a képernyőt
 */
public class Display implements Serializable {
    private JFrame frame;
    private Canvas canvas; /** Canvas lehetővé teszi, hogy grafikát rajzoljuk rá*/

    private String title;
    private int width, height;

    /**
     *
     * @param ti Ez a ablak neve
     * @param wi Ez a ablak szélessége
     * @param hei EZ a ablak hosszúsága
     */
    public Display ( String ti, int wi, int hei) {
        this.title = ti;
        this.width = wi;
        this.height = hei;
        createDisplay();
    }

    /**
     * creatDisplay metódus hozza létra kijelzőt
     * Amikor egy új JFramet létre hozzunk meg kell adni neki a címét.
     * setSize-al a szélessége és hosszúsága adtam meg a kijelzőnek
     * setDefaultCloseOp.... Jobb felső sarokba lévő X gombbal így kitudunk belőle lépzni
     * setLocationRelativeTo  null értékel a kijelző közepén jelenik meg az ablak.
     * setVisible true így látható az ablak
     * canvassal beállítottam, hogy ne lehesen módositani az ablakot
     * canvasünk, hogy müködjön hozzá kell adni a JFramehez.
     * A Jframe packje re-sizeolja az ablakukat de biztosítja hogy lássuk a canvast teljesen
     */
    private void createDisplay() {
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();
    }

    /**
     *
     * @return visszaadja a canvast
     */
    public Canvas getCanvas(){
        return canvas;
    }

    /**
     *
     * @return vissza adja a framet
     */
    public JFrame getFrame(){
        return frame;
    }

}
