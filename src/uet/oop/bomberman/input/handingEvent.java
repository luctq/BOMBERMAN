package uet.oop.bomberman.input;

import com.sun.deploy.config.JREInfo;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import uet.oop.bomberman.HandingCollision.canMove;
import uet.oop.bomberman.entities.Bomb;
import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class handingEvent extends load {
    public static boolean goUp, goDown, goLeft, goRight;
    public static int index;
    

    public handingEvent(List<Entity> entities, Scene scene, Bomber bomber) {
        this.scene = scene;
        this.bomber = bomber;
        this.entities = entities;
    }
    public static void clearBomb() {
        entities.remove(index);
    }
    public void handing() {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP: {
//                        imageView1.relocate(imageView1.getLayoutX(),
//                                imageView1.getLayoutY()-5);
                        goUp = true;
                        //  ((Bomber) bomberman).moveUp();
                        break;
                    }
                    case DOWN: {
//                        imageView1.relocate(imageView1.getLayoutX(),
//                                imageView1.getLayoutY()+5);
                        //((Bomber) bomberman).moveDown();
                        goDown = true;
                        break;
                    }
                    case LEFT: {
//                        imageView1.relocate(imageView1.getLayoutX()-5,
//                                imageView1.getLayoutY());
                        // ((Bomber) bomberman).moveLeft()
                        goLeft = true;
                        break;
                    }
                    case RIGHT: {
                        goRight = true;
                        break;
                    }
                    case SPACE: {
                        if (Bomb.removed) {
                            Bomb.removed = false;
                            int posXBomb = (bomber.getX() + 16) / Sprite.SCALED_SIZE;
                            int posYBomb = (bomber.getY() + 16) / Sprite.SCALED_SIZE;
                            Entity bomb = new Bomb(posXBomb, posYBomb, Sprite.bomb.getFxImage());
                            entities.add(bomb);
                            index = entities.size() - 1;
                            break;
                        }
                    }
                }
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP: {
//                        imageView1.relocate(imageView1.getLayoutX(),
//                                imageView1.getLayoutY()-5);
                        ((Bomber) bomber).backUp();
                        goUp = false;
                        break;
                    }
                    case DOWN: {
//                        imageView1.relocate(imageView1.getLayoutX(),
//                                imageView1.getLayoutY()+5);
                        ((Bomber) bomber).backDown();
                        goDown = false;
                        break;
                    }
                    case LEFT: {
//                        imageView1.relocate(imageView1.getLayoutX()-5,
//                                imageView1.getLayoutY());
                        ((Bomber) bomber).backLeft();
                        goLeft = false;
                        break;
                    }
                    case RIGHT: {
//                        imageView1.relocate(imageView1.getLayoutX()+5,
//                                imageView1.getLayoutY());
                        ((Bomber) bomber).backRight();
                        goRight = false;
                        break;
                    }
                }
            }
        });
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (goUp) ((Bomber) bomber).moveUp();
                if (goDown) ((Bomber) bomber).moveDown();
                if (goLeft) ((Bomber) bomber).moveLeft();
                if (goRight) ((Bomber) bomber).moveRight();
            }
        };
        timer.start();
    }
}
