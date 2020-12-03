package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.Map.Level;
import uet.oop.bomberman.entities.bomb.Bomb;
import uet.oop.bomberman.entities.bomb.DirectionalExplosion;
import uet.oop.bomberman.entities.bomb.Explosion;
import uet.oop.bomberman.entities.enemy.*;
import uet.oop.bomberman.entities.sound.SoundEffect;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.input.handingEvent;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class BombermanGame extends Application {
    public static final int WIDTH = 31;
    public static final int HEIGHT = 13;
    
    public static GraphicsContext gc;
    public static GraphicsContext gc1;
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
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT + 50);
        gc = canvas.getGraphicsContext2D();
        gc1 = canvas.getGraphicsContext2D();
        Game game = new Game(gc);
        // Tao root container
        Group root = new Group();
        root.getChildren().add(canvas);

        // Tao scene
        Scene scene = new Scene(root);

        // Them scene vao stage
        stage.setScene(scene);
        stage.show();
        SoundEffect.sound(SoundEffect.mediaPlayerbacksound);
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                render();
                update();
            }
        };
        timer.start();
        Entity bomberman = new Bomber(1, 1, Sprite.player_right.getFxImage());
        entities.add(bomberman);
        handingEvent event = new handingEvent(entities, scene, (Bomber) bomberman, bombs, stillObjects, background);
        event.handing();
        Level level = new Level(Bomber.level);
        level.creatMap(stillObjects, background, entities);
        DirectionalExplosion de = new DirectionalExplosion(entities, stillObjects, explosions);
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i) instanceof Balloon) {
                Balloon balloon = (Balloon) entities.get(i);
                balloon.move();
            } else if (entities.get(i) instanceof Oneal) {
                Oneal oneal = (Oneal) entities.get(i);
                oneal.move();
            }
            else if (entities.get(i) instanceof Doll) {
                Doll doll = (Doll) entities.get(i);
                doll.move();
            } else if (entities.get(i) instanceof Minvo) {
                Minvo minvo = (Minvo) entities.get(i);
                minvo.move();
            } else if (entities.get(i) instanceof Kondoria) {
                Kondoria kondoria = (Kondoria) entities.get(i);
                kondoria.move();
            } else if (entities.get(i) instanceof Ghost) {
                Ghost ghost = (Ghost) entities.get(i);
                ghost.move();
            }
        }
    }

    public void update() {
        if(Game.start == true) {
            if (Game.aSecondInGame > 0) {
                Game.aSecondInGame--;
            } else if (Game.TIME > 0){
                Game.TIME--;
                Game.aSecondInGame = 60;
                if (Game.TIME == 0) {
                    Game.LIVES--;
                    Game.TIME = 10;
                }
                if (Game.LIVES == 0) Game.gameover = true;
            }
            if (entities.size() == 1 && Bomber.changeLevel == false && Game.winLevel == true) {
                Bomber.level++;
                if (Bomber.level > 6)
                {
                    SoundEffect.sound(SoundEffect.mediaPlayerBombExploded);
                    Game.win = true;
                }
                handingEvent.changeLevel();
                Bomber.changeLevel = true;
            }
            if (entities.size() > 1) {
                Bomber.changeLevel = false;
            }
            if (!handingEvent.bomber.alive && Game.stop == false) {
                Game.stop = true;
                Game.LIVES--;
                if (Game.LIVES == 0) Game.gameover = true;
            }
            if (handingEvent.bomber.alive) Game.stop = false;
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

    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        if(Game.gameover == true) {
            SoundEffect.stop(SoundEffect.mediaPlayerbacksound);
            gc.setFont(new Font(100));
            gc.fillText("GAME OVER" , 32 * WIDTH/2 - 300, 32 * HEIGHT/2);
            gc.setFont(new Font(50));
            gc.fillText("POINTS: " + Game.POINTS, 32 * WIDTH/2 - 150, 32 * HEIGHT/2 + 120);
        } else if (Game.win == true){
            SoundEffect.stop(SoundEffect.mediaPlayerbacksound);
            gc.setFont(new Font(100));
            gc.fillText("VICTORY" , 32 * WIDTH/2 - 200, 32 * HEIGHT/2);
            gc.setFont(new Font(50));
            gc.fillText("POINTS: " + Game.POINTS, 32 * WIDTH/2 - 100, 32 * HEIGHT/2 + 120);
        } else {
            if (Level.timeToStart > 0) {
                Level.timeToStart--;
                gc.fillText("LEVEL" + Bomber.level, 32 * WIDTH/2 - 150, 32 * HEIGHT/2 + 30);
                gc.setFont(new Font(100));
            } else {
                Game.start = true;
                gc.fillText("Time: " + Game.TIME, 32 , 32);
                gc.fillText("Point: " + Game.POINTS, 32 + 32 * WIDTH/3, 32);
                gc.fillText("Lives: " + Game.LIVES, 32 + 64 * WIDTH/3, 32);
                gc.setFont(new Font(30));
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
    }
}
