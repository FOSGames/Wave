package main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
    public static int HEALTH = 100;
    private int greenValue = 255;

    private int score = 0, level = 1;

    public void tick() {
        HEALTH = Game.clamp(HEALTH, 0, 100);
        greenValue = Game.clamp(greenValue, 0, 255);
        greenValue = (HEALTH * 2);
        score++;
    }

    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(10, 10, 200, 2);
        g.setColor(new Color(100, greenValue, 0));
        g.fillRect(10, 10, (HEALTH * 2), 2);
        // g.setColor(Color.white);
        // g.drawRect(15, 15, 200, 2);

        g.setColor(Color.white);
        g.drawString("Score - " + score, 10, 30);
        g.drawString("Level - " + level, Game.WIDTH - 75, 30);
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
