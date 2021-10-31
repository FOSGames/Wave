package main;

import java.awt.*;
import java.util.LinkedList;

import main.GameObjects.GameObject;
import main.GameObjects.ID;
import main.GameObjects.Player;

public class Handler {
    public LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void tick() {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.tick();
        }
    }
    public void render(Graphics g) {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.render(g);
        }
    }

    public void addObject(GameObject object) {
        this.object.add(object);
    }
    public void removeObject(GameObject object) {
        this.object.remove(object);
    }
    public void clearEnemies() {
        object.clear();
        addObject(new Player(Game.WIDTH / 2- 32, Game.HEIGHT / 2 - 32, ID.Player, this));
    }
}
