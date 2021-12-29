package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

import main.GameObjects.BasicEnemy;
import main.GameObjects.ID;
import main.GameObjects.Player;

public class Game extends Canvas implements Runnable {
    private static final long serialVersionUID = 1;
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private Thread mainThread;
    private boolean isRunning = false;

    private Random random;
    private Handler handler;
    private HUD hud;
    private Spawn spawn;
    private Menu menu;

    public enum STATE {
        Menu, Game,
    };

    public STATE gameState = STATE.Menu;

    public Game() {
        hud = new HUD();
        handler = new Handler(hud, this);
        this.addKeyListener(new KeyInput(handler));
        menu = new Menu(this, handler);
        this.addMouseListener(menu);
        spawn = new Spawn(handler, hud);
        new Window(this, WIDTH, HEIGHT, "My Game");
        random = new Random();

        if (gameState == STATE.Game) {
            handler.addObject(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player, handler));
            handler.addObject(new BasicEnemy(random.nextInt(WIDTH / 2), random.nextInt(HEIGHT / 2), ID.BasicEnemy));
        }

    }

    public synchronized void start() {
        mainThread = new Thread(this);
        mainThread.start();
        isRunning = true;
    }

    public synchronized void stop() {
        try {
            mainThread.join();
            isRunning = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void tick() {
        handler.tick();
        if (gameState == STATE.Game) {
            hud.tick();
            spawn.tick();
        } else if (gameState == STATE.Menu) {
            menu.tick();
        }
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);

        if (gameState == STATE.Game) {
            hud.render(g);
        } else if (gameState == STATE.Menu) {
            g.setColor(Color.white);
            menu.render(g);
        }

        g.dispose();
        bs.show();
    }

    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (isRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (isRunning)
                render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                // System.out.println("FPS = " + frames);
                frames = 0;
            }
        }
        stop();
    }

    public static int clamp(int var, int min, int max) {
        if (var >= max) {
            return var = max;
        } else if (var <= min) {
            return var = min;
        } else {
            return var;
        }
    }

    public static void main(String[] args) throws Exception {
        new Game();
    }
}
