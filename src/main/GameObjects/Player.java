package main.GameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import main.Game;
import main.HUD;
import main.Handler;

public class Player extends GameObject {

    // Random random = new Random();
    private Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    @Override
    public void tick() {
        x += speedX;
        y += speedY;

        x = Game.clamp(x, 0, Game.WIDTH - 42);
        y = Game.clamp(y, 0, Game.HEIGHT - 72);
        collision();
        if (HUD.HEALTH == 0) {
            handler.backToMenu();
        }
    }

    private void collision() {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tmpObject = handler.object.get(i);
            // Collision code
            if (tmpObject.getID() == ID.BasicEnemy) {
                if (getBounds().intersects(tmpObject.getBounds())) {
                    HUD.HEALTH -= 1;
                }
            }
            if (tmpObject.getID() == ID.FastEnemy) {
                if (getBounds().intersects(tmpObject.getBounds())) {
                    HUD.HEALTH -= 2;
                }
            }
            if (tmpObject.getID() == ID.SmartEnemy) {
                if (getBounds().intersects(tmpObject.getBounds())) {
                    HUD.HEALTH -= 1;
                }
            }
            if (tmpObject.getID() == ID.BossEnemy1) {
                if (getBounds().intersects(tmpObject.getBounds())) {
                    HUD.HEALTH -= 2;
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {

        // Hitbox:
        // Graphics2D g2d = (Graphics2D) g;
        // g2d.setColor(Color.green);
        // g2d.draw(getBounds());

        g.setColor(Color.CYAN);
        g.fillRect(x, y, 32, 32);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }
}
