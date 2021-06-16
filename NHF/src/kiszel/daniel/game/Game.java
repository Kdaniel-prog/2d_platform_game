package kiszel.daniel.game;

import kiszel.daniel.entities.Player;
import kiszel.daniel.graphic.Assets;
import kiszel.daniel.graphic.GameCamera;
import kiszel.daniel.input.KeyManager;
import kiszel.daniel.input.MouseManager;
import kiszel.daniel.save.Save;
import kiszel.daniel.state.*;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * ez a "main" class a játékunkhoz itt fogjuk minden osztályt frissíteni (updatelni) és megrajzolni (renderelni)
 */

public class Game implements Runnable, Serializable {

    private Display display;
    private int width, height;
    public String title;
    /**
     *      Thread az engedélyezi, hogy külön futtassuk az adot osztályt a kódunktól.
     *      Thread csinálásához szükségünk lesz engedélyezni, hogy az adott osztály Threaden fusson
     *      (implementálnunk kell a runnable) miután ez megtörtént szükségünk lesz az adott class alján vagy a class belsejében
     *      egy  ( public void run metódusra), kelleni fog egy privát attribútumú Thread (típusú) objektum amit én threadnek neveztem el.
     *      Ezt két metódusba fogom implamentálni: 1.(public synchronized void start) 2.(public synchronized void stop).
     *      A szinkronizálást akkor használjk amikor Threadel dolgozunk ezzel elérjük, hogy semmise rontodjon el.
     */

    private Thread thread;
    private boolean running = false;
    /**
     *  Buffere rajzolunk előszőr ("láthatatlan képernyő") nem a rendes képernyőre így sokkal simább lesz a játék.
     *  A régebi játékoknál képernyöre rajzoltak ami sokkal pislákolósabbá tette a játékokat
     */
    private BufferStrategy bs;
    /**
     * Grapics g ez lesz a varázslatos ceruzánk és ezzel fogunk rajzolni
     */
    private Graphics g;


    static boolean saved = false;



    //States
    public State gameState;
    public State menuState;
    public State winState;
    public State loseState;

    //Input
    private KeyManager keyManager;
    private MouseManager mouseManager;

    //Camera
    private GameCamera gameCamera;

    //Handler
    private Handler handler;

     /**
     * ez a game konstruktora
     * @param ti Ez a ablak címe
     * @param wi  Ez a ablak szélességre
     * @param he  Ez a ablak hosszúságra
      * itt hozzunk létre a Keymanagert ami a billentyűzetért felel és a mouseManager ami az egérért felel.
     */

    public Game(String ti,int wi, int he){
        this.width = wi;
        this. height = he;
        this.title = ti;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
    }

    /**
     * init() metódusnak adjuk meg a displaynak a paramétereket cím, szélesség, hosszúság
     * hozzáadjuk a keyManagert a displayhez
     * Assets.init() metódusával betöltjük a képeket.
     * handler hozzá adjuk a game osztályt
     * létre hozzunk egy új gameCamerát neki kell a játék de mivel a handler hozzá tud férni ezért azt adjuk át neki és a kezdő x,y pozicióját
     * game osztályhoz beállítjuk a camerát
     * létre hozzunk egy új gameStatet és menuStatet, winState, loseState
     *  (MenuState)menuState).isLoadable() ha van mentés akkor a load gomb megjelenik ha nincs akkor Exit gomb lesz a helyén
     *  State.setState(menuState) menuStatra állítjuk a Statet ezért majd kezdéskor a menüből fogjuk látni.
     */

    private void init(){
        display = new Display (title, width, height);
        display.getFrame().addKeyListener(keyManager);

        Assets.init();
        handler = new Handler(this);
        gameCamera = new GameCamera(handler,0,0);
        this.setGameCamera(gameCamera);
        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        if( ((MenuState)menuState).isLoadable()){
            ((MenuState)menuState).refreshButtons();

        }
        winState = new WinState(handler);
        loseState = new LoseState(handler);
        State.setState(menuState);

    }
    /**  Ez a fő update frissíti a képernyőt. A további update az osztályokon belül közvetlenül vagy közvetetten ide tartoznak.
     *   A display itt initcializáljuk a mouse listenert és a mouse motion listenert,
     *   de ezt elég megtenni Canvas objektumukra mert mindig azt szeretnék nézni hogy mikor is van fokuszba a canvas objektumunk.
     *   Itt nézem azt is, hogy a játékos mentett e,
     *   ha igen akkor vissza térünk a menuStateben.
     *   */
    private void update(){
        keyManager.update();

        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);

        if (State.getState() != null){
            State.getState().update();
        }
        if(keyManager.ctrl && keyManager.down){
            ((MenuState)menuState).refreshButtons();
            menuState = new MenuState(handler);
            save();
            State.setState(menuState);
            saved = true;
        }
        if (saved){
            saved = false;
            return;
        }
    }

    /**
     * render metódusba rajzolunk
     * getBufferStrategy nullt adja vissza ha nincs bufferStrategy létre hozva
     * createBufferstrategy létre hozza a buffert és 3 db buffert fogunk használni nem hiszem, hogy 3-nál többel müködne ezután returnoljük
     *   bs.getDrawGraphics() így tudunk a canvasra rajzolni
     * bs.show() metódussal  kérjük el a buffertől a rajzot
     * g.dispose() ez a metódus biztositja, hogy a grapics object végzet rendesen.
     */
    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();
        g.clearRect(0,0,width,height);

        if (State.getState() != null){
            State.getState().render(g);
        }

        bs.show();
        g.dispose();
    }

    /** Az init metódust a legelején hívom meg ennél a metódusnál mert azt nem kell felül írni.
     * A run metódus felel azért, hogy a játék fusson.
     *  SI alapegységben a nano az 10^-9 ezért ha 60 fpsn szeretnénk futtatni a játkunkat akkor a nanot osztani kell a fpsel így kapjuk mert a számot ami
     *  ahhoz kell majd, hogy deltát megtudjuk határozni. A neten sok helyen futottam bele ebbe megoldásban. A mai játék motorokba alapból meg van ez írva.
     *  Ha a delta 1-nél nagyobb akkor fogom updatelni és renderelni a játékot és utána nullázom a deltát.
     *  Erre az egészre azért van szükség mert azt szeretnénk, hogy minden számítógépen egységes gyorsasággal fusson a játék ha egy while ciklusba lenne az egész akkor egyes
     *  számítógépeken gyorsabban míg más gépeken lassabban menne a játék és ezt nagyon nem szeretnénk.
     * */

    @Override
	public void run(){
        init();
        int fps = 60;
        double timePerUpdate = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();

        while (running){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerUpdate;
            lastTime = now;
            if(delta >= 1){
                update();
                render();
                delta = 0;
            }
        }
    }

    /**
     *
     * @return visszadja a keyManagert objectumot
     */

    public KeyManager getKeyManager(){
        return keyManager;
    }

    /**
     *
     * @return visszadja a gameCamera objectumot
     */
    public GameCamera getGameCamera(){
        return gameCamera;
    }

    /**
     *
     * @param gameCamera Beállítjuk a gameCamera objectumot  a GameCamera osztályhoz
     */

    public void setGameCamera(GameCamera gameCamera) {
        this.gameCamera = gameCamera;
    }

    /**
     *
     * @return visszadja a canvas szélességét
     */
    public int getWidth(){
        return width;
    }

    /**
     *
     * @return visszadja a hosszúságát az ablaknak
     */
    public int getHeight(){
        return height;
    }

    /**
     *  Mivel a játék szálon fut ezért a synchronized használnunk kell hogy nehogy a játékon belül elromoljon.
     *  ha running igaz akkor kilépünk a metódusból
     *  létre hozzunk egy új szálat (Threadet) és elínditjuk a start metódusal
     *
     */
    public synchronized void start(){
        if(running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    /**
     * @return Ez a getterel tudunk hozzá férni a mouseManagerhez
     */

    public MouseManager getMouseManager(){
        return mouseManager;
    }

    /**
     * A save metódusunk szolgál arra, hogy elmentsük a játékot jatákos x,y és életerejét mentjük el
     */
    public void save() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Save.txt"));
            Save save = new Save();
            save.setSaveX(handler.getEntityList().getPlayer().getX());
            save.setSaveY(handler.getEntityList().getPlayer().getY());
            handler.getEntityList().getPlayer();
			save.setHealth(Player.PlayerHealth);
            out.writeObject(save);
            out.close();

        } catch (Exception a) {
            System.out.println(a);
        }
    }


}
