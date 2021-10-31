package main;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.util.Random;

import main.Game.STATE;
import main.GameObjects.BasicEnemy;
import main.GameObjects.ID;
import main.GameObjects.Player;

public class Menu extends MouseAdapter {
    private Game game;
    private Handler handler;
    private Random random = new Random();

    public Menu(Game game, Handler handler) {
        this.game = game;
        this.handler = handler;
    }

    public void mousePressed(MouseEvent me) {
        int mx = me.getX();
        int my = me.getY();

        // Play Button
        if (mouseOver((Game.WIDTH / 2) - 100, (Game.HEIGHT / 2) - 100, mx, my, 200, 64)) {
            game.gameState = STATE.Game;
            handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
            handler.addObject(
                    new BasicEnemy(random.nextInt(Game.WIDTH / 2), random.nextInt(Game.HEIGHT / 2), ID.BasicEnemy));
        }
        // Quit Button
        if (mouseOver((Game.WIDTH / 2) - 100, (Game.HEIGHT / 2), mx, my, 200, 64)) {
            System.exit(0);
        }
        // Quit Button
        if (mouseOver((Game.WIDTH / 2) - 100, (Game.HEIGHT / 2) + 100, mx, my, 200, 64)) {
            try {
                Desktop desktop = java.awt.Desktop.getDesktop();
                URI oURL = new URI("http://jaynakum.github.io");
                desktop.browse(oURL);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void mouseReleased(MouseEvent me) {

    }

    private boolean mouseOver(int x, int y, int mx, int my, int width, int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void tick() {

    }

    public void render(Graphics g) {
        Font fnt1 = new Font("arial", 1, 50);
        Font fnt2 = new Font("arial", 1, 30);
        g.setFont(fnt1);
        g.setColor(Color.cyan);
        g.drawString("Wave", (Game.WIDTH / 2) - 65, (Game.HEIGHT / 2) - 150);

        g.setColor(Color.white);
        g.setFont(fnt2);
        g.drawString("Play", (Game.WIDTH / 2) - 40, (Game.HEIGHT / 2) - 60);
        g.drawRect((Game.WIDTH / 2) - 100, (Game.HEIGHT / 2) - 100, 200, 64);

        g.drawString("Quit", (Game.WIDTH / 2) - 40, (Game.HEIGHT / 2) + 40);
        g.drawRect((Game.WIDTH / 2) - 100, (Game.HEIGHT / 2), 200, 64);

        g.drawString("Help", (Game.WIDTH / 2) - 40, (Game.HEIGHT / 2) + 140);
        g.drawRect((Game.WIDTH / 2) - 100, (Game.HEIGHT / 2) + 100, 200, 64);
    }
}
