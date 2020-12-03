package uet.oop.bomberman;

import javafx.scene.canvas.GraphicsContext;
import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.input.handingEvent;

import java.util.List;


public class Game {
    private static GraphicsContext gc;
    public static Bomber bomber = handingEvent.bomber;
    public static List<Entity> entities = handingEvent.entities;
    public static List<Entity> stillObjects = handingEvent.stillObjects;
    public static List<Entity> background = handingEvent.background;

    public static int TIME = 200;
    public static int POINTS = 0;
    public static int LIVES = 5;
    public static boolean stop = false;
    public static boolean start = false;
    public static int aSecondInGame = 60;
    public static boolean gameover = false;
    public static boolean win = false;
    public static boolean winLevel = false;
    public Game (GraphicsContext gc) {
        this.gc = gc;
    }
    public static void changeLevel(int level) {
    }
}
