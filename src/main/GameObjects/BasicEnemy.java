package main.GameObjects;

import java.awt.*;

import main.Game;

public class BasicEnemy extends GameObject {

    public BasicEnemy(int x, int y, ID id) {
        super(x, y, id);
        speedX = 5;
        speedY = 5;
    }

    @Override
    public void tick() {
        x += speedX;
        y += speedY;

        if(y <= 0 || y >= Game.HEIGHT - 65) speedY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 25) speedX *= -1;
    }
    
    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 16, 16);        
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 16, 16);
    }   
}
