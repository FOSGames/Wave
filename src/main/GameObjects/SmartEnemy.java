package main.GameObjects;

import java.awt.*;

import main.*;

public class SmartEnemy extends GameObject {
    // private Handler handler;
    private GameObject player;

    public SmartEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        // this.handler = handler;

        for (int i = 0; i < handler.object.size(); i++) {
            if (handler.object.get(i).getID() == ID.Player) {
                this.player = handler.object.get(i);
            }
        }
        
    }

    @Override
    public void tick() {
        x += speedX;
        y += speedY;

        float diffX = (x - player.getX()) - 8;
        float diffY = (y - player.getY()) - 8;
        float distance = (float) Math.sqrt(((x - player.getX()) * (x - player.getX())) + ((y - player.getY()) * (y - player.getY())));

        speedX = (int) ((-1.0/distance) * diffX);
        speedY = (int) ((-1.0/distance) * diffY);


        if(y <= 0 || y >= Game.HEIGHT - 65) speedY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 25) speedX *= -1;
    }
    
    @Override
    public void render(Graphics g) {
        g.setColor(Color.magenta);
        g.fillRect((int) x, (int) y, 16, 16);        
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }   
}
