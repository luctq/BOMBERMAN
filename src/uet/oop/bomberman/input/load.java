package uet.oop.bomberman.input;

import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import uet.oop.bomberman.entities.Bomb;
import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.entities.Entity;

import java.util.List;

public abstract class load {
    Scene scene;
    public static Bomber bomber;
    public static List <Entity> entities;
    public static List <Bomb> bombs;
    public static List<Entity> stillObjects;
    public static List<Entity> background;
}
