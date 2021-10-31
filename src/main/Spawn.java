package main;

import java.util.Random;

import main.GameObjects.*;

public class Spawn {
    private Handler handler;
    private HUD hud;
    private int scoreKeep = 0;
    private Random random = new Random();
    

    public Spawn(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    public void tick() {
        scoreKeep++;
        if(scoreKeep >= 100) {
            scoreKeep = 0;
            // hud.setScore(0);
            hud.setLevel(hud.getLevel() + 1);

            if(hud.getLevel() == 2) {
                handler.addObject(new BasicEnemy(random.nextInt(Game.WIDTH/2), random.nextInt(Game.HEIGHT/2), ID.BasicEnemy));
            }
            if(hud.getLevel() == 3) {
                handler.addObject(new FastEnemy(random.nextInt(Game.WIDTH/2), random.nextInt(Game.HEIGHT/2), ID.FastEnemy));
            }
            if(hud.getLevel() == 4) {
                handler.addObject(new BasicEnemy(random.nextInt(Game.WIDTH/2), random.nextInt(Game.HEIGHT/2), ID.BasicEnemy));
            }
            if(hud.getLevel() == 5) {
                handler.addObject(new SmartEnemy(random.nextInt(Game.WIDTH/2), random.nextInt(Game.HEIGHT/2), ID.SmartEnemy, handler));
            }

        }
    }
}
