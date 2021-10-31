package main;

import java.util.Random;

import main.GameObjects.BasicEnemy;
import main.GameObjects.BossEnemy1;
import main.GameObjects.FastEnemy;
import main.GameObjects.ID;
import main.GameObjects.SmartEnemy;

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
        if (scoreKeep >= 250) {
            scoreKeep = 0;
            // hud.setScore(0);
            hud.setLevel(hud.getLevel() + 1);

            if (hud.getLevel() == 2) {
                handler.addObject(
                        new BasicEnemy(random.nextInt(Game.WIDTH / 2), random.nextInt(Game.HEIGHT / 2), ID.BasicEnemy));
            } else if (hud.getLevel() == 3) {
                handler.addObject(
                        new BasicEnemy(random.nextInt(Game.WIDTH / 2), random.nextInt(Game.HEIGHT / 2), ID.BasicEnemy));
            } else if (hud.getLevel() == 4) {
                handler.addObject(
                        new FastEnemy(random.nextInt(Game.WIDTH / 2), random.nextInt(Game.HEIGHT / 2), ID.FastEnemy));
            } else if (hud.getLevel() == 5) {
                handler.addObject(new SmartEnemy(random.nextInt(Game.WIDTH / 2), random.nextInt(Game.HEIGHT / 2),
                        ID.SmartEnemy, handler));
            } else if (hud.getLevel() == 6) {
                handler.addObject(
                        new BasicEnemy(random.nextInt(Game.WIDTH / 2), random.nextInt(Game.HEIGHT / 2), ID.BasicEnemy));
            } else if (hud.getLevel() == 7) {
                handler.addObject(
                        new BasicEnemy(random.nextInt(Game.WIDTH / 2), random.nextInt(Game.HEIGHT / 2), ID.BasicEnemy));
            } else if (hud.getLevel() == 8) {
                handler.addObject(
                        new FastEnemy(random.nextInt(Game.WIDTH / 2), random.nextInt(Game.HEIGHT / 2), ID.FastEnemy));
            } else if (hud.getLevel() == 9) {
                handler.addObject(new SmartEnemy(random.nextInt(Game.WIDTH / 2), random.nextInt(Game.HEIGHT / 2),
                        ID.SmartEnemy, handler));
            } else if (hud.getLevel() == 10) {
                handler.clearEnemies();
                handler.addObject(new BossEnemy1((Game.WIDTH / 2) - 48, -100, ID.BossEnemy1, handler));
            }
        }
    }
}
