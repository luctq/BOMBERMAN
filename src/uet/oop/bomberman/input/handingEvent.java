package uet.oop.bomberman.input;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import uet.oop.bomberman.Game;
import uet.oop.bomberman.HandingCollision.canExplosion;
import uet.oop.bomberman.HandingCollision.canMove;
import uet.oop.bomberman.Map.Level;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.entities.bomb.Bomb;
import uet.oop.bomberman.entities.sound.SoundEffect;
import uet.oop.bomberman.graphics.Sprite;

import java.io.FileNotFoundException;
import java.util.List;

public class handingEvent extends load {
    public static boolean goUp, goDown, goLeft, goRight;
    public static int index;
    public static int BombAlive = 0;


    public handingEvent(List<Entity> entities, Scene scene, Bomber bomber, List<Bomb> bombs, List<Entity> stillObjects, List<Entity> background) {
        this.scene = scene;
        this.bomber = bomber;
        this.entities = entities;
        this.stillObjects = stillObjects;
        this.background = background;
        this.bombs = bombs;
    }
    public static void clearBomb() {
        bombs.remove(index);
    }
    public void handing() {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (bomber.alive) {
                    switch (event.getCode()) {
                        case UP: case W: {
//                        imageView1.relocate(imageView1.getLayoutX(),
//                                imageView1.getLayoutY()-5);
                            goUp = true;
                            //  ((Bomber) bomberman).moveUp();
                            break;
                        }
                        case DOWN: case S: {
//                        imageView1.relocate(imageView1.getLayoutX(),
//                                imageView1.getLayoutY()+5);
                            //((Bomber) bomberman).moveDown();
                            goDown = true;
                            break;
                        }
                        case LEFT: case A: {
//                        imageView1.relocate(imageView1.getLayoutX()-5,
//                                imageView1.getLayoutY());
                            // ((Bomber) bomberman).moveLeft()
                            goLeft = true;
                            break;
                        }
                        case RIGHT: case D:{
                            goRight = true;
                            break;
                        }
                        case SPACE: {
                            if (Bomb.numberOfBomb > 0) {
                                Bomb.removed = false;
                                Bomber.inBomb = true;
                                canMove.posXBomb = (bomber.getX() + 16) / Sprite.SCALED_SIZE;
                                canMove.posYBomb = (bomber.getY() + 16) / Sprite.SCALED_SIZE;
                                SoundEffect.sound(SoundEffect.mediaPlayerPlaceBomb);
                                Bomb bomb = new Bomb(canMove.posXBomb, canMove.posYBomb, Sprite.bomb.getFxImage());
                                BombAlive++;
                                bombs.add(bomb);
                                index = bombs.size() - BombAlive;
                                Bomb.numberOfBomb--;
                                break;
                            }
                        }
                    }
                }
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(bomber.alive) {
                    switch (event.getCode()) {
                        case UP: case W:{
//                        imageView1.relocate(imageView1.getLayoutX(),
//                                imageView1.getLayoutY()-5);
                            ((Bomber) bomber).backUp();
                            goUp = false;
                            break;
                        }
                        case DOWN: case S: {
//                        imageView1.relocate(imageView1.getLayoutX(),
//                                imageView1.getLayoutY()+5);
                            ((Bomber) bomber).backDown();
                            goDown = false;
                            break;
                        }
                        case LEFT: case A: {
//                        imageView1.relocate(imageView1.getLayoutX()-5,
//                                imageView1.getLayoutY());
                            ((Bomber) bomber).backLeft();
                            goLeft = false;
                            break;
                        }
                        case RIGHT: case D: {
//                        imageView1.relocate(imageView1.getLayoutX()+5,
//                                imageView1.getLayoutY());
                            ((Bomber) bomber).backRight();
                            goRight = false;
                            break;
                        }
                    }
                } else {
                    if (event.getCode() == KeyCode.ENTER){
                        changeLevel();
                    } else if (event.getCode() == KeyCode.DIGIT1) {
                        Bomber.level = 1;
                        changeLevel();
                    }
                    goLeft = false;
                    goRight = false;
                    goDown = false;
                    goUp = false;
                }
            }
        });
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (bomber.alive) {
                    if (goUp) ((Bomber) bomber).moveUp();
                    if (goDown) ((Bomber) bomber).moveDown();
                    if (goLeft) ((Bomber) bomber).moveLeft();
                    if (goRight) ((Bomber) bomber).moveRight();
                }
            }
        };
        timer.start();
    }
    public static void changeLevel() {
        Game.TIME = 200;
        bomber.reset();
        stillObjects.clear();
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i) instanceof Balloon) {
                Balloon balloon = (Balloon) entities.get(i);
                balloon.alive = false;
            } else if (entities.get(i) instanceof Oneal) {
                Oneal oneal = (Oneal) entities.get(i);
                oneal.alive = false;
            } else if (entities.get(i) instanceof Doll) {
                Doll doll = (Doll) entities.get(i);
                doll.alive = false;
            }
        }
        entities.clear();
        background.clear();
        entities.add(bomber);
        Level level = new Level(Bomber.level);
        try {
            Game.start = false;
            Level.timeToStart = 60;
            level.creatMap(stillObjects, background, entities);
            canMove.map = Level.map;
            canExplosion.map = Level.map;
            Balloon.map = Level.map;
            for (int i = 0; i < entities.size(); i++) {
                if (entities.get(i) instanceof Balloon) {
                    Balloon balloon = (Balloon) entities.get(i);
                    balloon.move();
                } else if (entities.get(i) instanceof Oneal) {
                    Oneal oneal = (Oneal) entities.get(i);
                    oneal.move();
                }else if (entities.get(i) instanceof Doll) {
                    Doll doll = (Doll) entities.get(i);
                    doll.move();
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
