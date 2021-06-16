package kiszel.daniel.input;

import kiszel.daniel.UI.UIManager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener {
    /**
     * Ez az osztály azért volt fontos mivel a menüben az egér irányitásával lehet lépkedni
     * itt implamentálom a mouselistenert és a mousemotionlistenert az egyik az egér mozgásával míg a másik a egér gomb lenyomásaival
     * */
    private boolean leftPressed, rightPressed;
    private int mouseX, mouseY;
    private UIManager uiManager;

    public MouseManager() {

    }
    /**
     * setUiManagerel tudjuk settelni az uimanageret magyarrul hozzáadjuk a mouselistenert és a mousemotionlistenert a uimanagerhez
     * */
    public void setUIManager(UIManager uiManager) {
        this.uiManager = uiManager;
    }
    // Implemented methods
    @Override

    /**
     * bal és jobb egér gombot használjuk fel a középsőt ami a görgő azt nem itt állítom truera az egér gombok értékeit amikor a felhasználó lenyomja az egér gombot
     * */

    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1){
            leftPressed = true;
    }
        if(e.getButton()==MouseEvent.BUTTON3){

        rightPressed = true;
    }
        if(e.getButton()==MouseEvent.BUTTON2) {

        }
    }


    @Override
    /**
     * bal és jobb egér gombot használjuk fel a középsőt ami a görgő azt nem itt állítom falsera az egér gombok értékeit amikor a felhasználó elengedi az egér gombot
     * */
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            leftPressed = false;
        }
        if(e.getButton() == MouseEvent.BUTTON3){
            rightPressed = false;
        }
        if(e.getButton() == MouseEvent.BUTTON2){

        }
        if(this.uiManager != null){
            uiManager.onMouseRelease(e);
        }
    }

    @Override
    /**
     * ez a metódus adja vissza az egér x,y koordinátáját
     * */
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        if(uiManager != null)
            uiManager.onMouseMove(e);
    }
    /**
     * Mivel a mouselistener ős osztálynak ezek a metódusai abstrackok ezért ezeknek is szerepelnie kell még ha nem is tervezel velük semmit
     * */
    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}