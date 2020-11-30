package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.Map.Level;
<<<<<<< Updated upstream
=======
import uet.oop.bomberman.entities.bomb.Bomb;
import uet.oop.bomberman.entities.bomb.DirectionalExplosion;
import uet.oop.bomberman.entities.bomb.Explosion;
import uet.oop.bomberman.entities.enemy.Balloon;
import uet.oop.bomberman.entities.enemy.Oneal;
>>>>>>> Stashed changes
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.input.handingEvent;
import uet.oop.bomberman.entities.enemy.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class BombermanGame extends Application {
    public static int countUp = 0;
    public static int countRight = 0;
    public static boolean goUp, goDown, goLeft, goRight;
    public static final int WIDTH = 31;
    public static final int HEIGHT = 13;

    private GraphicsContext gc;
    private Canvas canvas;

    private List<Bomb> bombs = new ArrayList<>();
    private List<Entity> entities = new ArrayList<>();
    private List<Entity> stillObjects = new ArrayList<>();
    private List<Explosion> explosions = new ArrayList<>();
    private List<Entity> background = new ArrayList<>();

    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        // Tao Canvas
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();
        // Tao root container
        Group root = new Group();
        root.getChildren().add(canvas);

        // Tao scene
        Scene scene = new Scene(root);

        // Them scene vao stage
        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                render();
                update();
            }
        };
        timer.start();
        Level level = new Level(1);
        level.creatMap(stillObjects, background, entities);
        Entity bomberman = new Bomber(1, 1, Sprite.player_right.getFxImage());
        entities.add(bomberman);
        handingEvent event = new handingEvent(entities, scene, (Bomber) bomberman, bombs, stillObjects, background);
        event.handing();
        DirectionalExplosion de = new DirectionalExplosion(entities, stillObjects, explosions);
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i) instanceof Balloon) {
                Balloon balloon = (Balloon) entities.get(i);
                balloon.move();
            }
        }
    }

    public void update() {
        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).update();
        }
        for (int i = 0; i < explosions.size(); i++) {
            explosions.get(i).update();
        }
        for (int i = 0; i < stillObjects.size(); i++) {
            stillObjects.get(i).update();
        }
        for (int i = 0; i < bombs.size(); i++) {
            bombs.get(i).update();
        }
        for (int i = 0; i < background.size(); i++) {
            background.get(i).update();
        }
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for(Entity e : background) {
            e.render(gc);
        }
        for(Entity e : stillObjects) {
            e.render(gc);
        }
        for(Entity e : entities) {
            e.render(gc);
        }
        for(Explosion e : explosions) {
            e.render(gc);
        }
        for(Bomb b : bombs) {
            b.render(gc);
        }
    }
}