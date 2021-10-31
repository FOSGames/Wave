package main;

import java.awt.Graphics;
import java.util.LinkedList;

import main.Game.STATE;
import main.GameObjects.GameObject;
import main.GameObjects.ID;
import main.GameObjects.Player;

public class Handler {
    public LinkedList<GameObject> object = new LinkedList<GameObject>();
    private HUD hud;
    private Game game;

    public Handler(HUD hud, Game game) {
        this.hud = hud;
        this.game = game;
    }

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
        this.object.clear();
        addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, this));
    }

    public void backToMenu() {
        game.gameState = STATE.Menu;
        this.object.clear();
        HUD.HEALTH = 100;
        hud.setLevel(0);
        hud.setScore(0);
        return;
    }
}
