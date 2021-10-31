package main.GameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import main.Game;
import main.Handler;

public class BossEnemy1 extends GameObject {
    private Handler handler;
    private Random random = new Random();

    private int timer1 = 50;
    private int timer2 = 50;

    public BossEnemy1(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        speedX = 0;
        speedY = 2;
    }

    @Override
    public void tick() {
        x += speedX;
        y += speedY;

        if (timer1 <= 0) {
            speedY = 0;
        } else {
            timer1--;
        }

        if (timer1 <= 0) {
            timer2--;
        }
        if (timer2 <= 0) {
            if (speedX == 0) {
                speedX = 2;
            }

            // if(speedX > 0){
            // speedX += 1;
            // }
            // if(speedX < 0) {
            // speedX -= 1;
            // }

            int spawn = random.nextInt(10);
            if (spawn == 0) {
                handler.addObject(new BossEnemy1Bullet((x + 48), (y + 48), ID.BasicEnemy, handler));
            }
        }

        // if(y <= 0 || y >= Game.HEIGHT - 65) speedY *= -1;
        if (x <= 0 || x >= Game.WIDTH - 70)
            speedX *= -1;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(x, y, 64, 64);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 64, 64);
    }
}
