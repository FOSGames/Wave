package main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import main.GameObjects.GameObject;
import main.GameObjects.ID;

public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        // System.out.println(key);
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tmpObject = handler.object.get(i);
            if (tmpObject.getID() == ID.Player) {
                // Key events for the player
                if (key == KeyEvent.VK_UP)
                    tmpObject.setSpeedY(-7);
                if (key == KeyEvent.VK_LEFT)
                    tmpObject.setSpeedX(-7);
                if (key == KeyEvent.VK_DOWN)
                    tmpObject.setSpeedY(7);
                if (key == KeyEvent.VK_RIGHT)
                    tmpObject.setSpeedX(7);
            }
        }
        if (key == KeyEvent.VK_ESCAPE) {
            // System.exit(0);
            handler.backToMenu();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        // System.out.println(key);
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tmpObject = handler.object.get(i);
            if (tmpObject.getID() == ID.Player) {
                // Key events for the player
                if (key == KeyEvent.VK_UP)
                    tmpObject.setSpeedY(0);
                if (key == KeyEvent.VK_LEFT)
                    tmpObject.setSpeedX(0);
                if (key == KeyEvent.VK_DOWN)
                    tmpObject.setSpeedY(0);
                if (key == KeyEvent.VK_RIGHT)
                    tmpObject.setSpeedX(0);
            }
        }
    }

}
