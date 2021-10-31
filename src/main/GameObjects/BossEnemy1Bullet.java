package main.GameObjects;

import java.awt.*;
import java.util.Random;

import main.*;

public class BossEnemy1Bullet extends GameObject {
    private Handler handler;
    private Random random = new Random();

    public BossEnemy1Bullet(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        speedX = random.nextInt((5 - -5) + (-5));
        speedY = 5;
    }

    @Override
    public void tick() {
        x += speedX;
        y += speedY;

        if(y >= Game.HEIGHT) {
            handler.removeObject(this);
        }
    }
    
    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, 10, 10);        
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 10, 10);
    }   
}
