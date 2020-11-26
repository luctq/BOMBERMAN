package uet.oop.bomberman.entities;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import uet.oop.bomberman.HandingCollision.BomberCollision;
import uet.oop.bomberman.HandingCollision.canMove;
import uet.oop.bomberman.entities.Map.Level1;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.input.handingEvent;

import java.util.Random;

import static uet.oop.bomberman.graphics.Sprite.SCALED_SIZE;

public class Balloon extends AnimatedEntitiy {
    boolean alive = true;
    int m = 90;
    Random rd = new Random();
    int pos;
    String[] map = Level1.map;
    boolean removed = false;
    Sprite _sprite;
    int speed = 1;
    public Balloon(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    @Override
    public void update() {
        animate();
    }
    public void moveDown() {
        kill();
        _sprite = Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2,
                Sprite.balloom_right3, _animate, 20);
        this.img = _sprite.getFxImage();
        if(canMove.canMoveDown(x, y + speed)) this.y = this.y + speed;
        else m = 0;
    }

    public void moveUp() {
        kill();
        _sprite = Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2,
                Sprite.balloom_left3, _animate, 20);
        this.img = _sprite.getFxImage();
        if (canMove.canMoveUp(x, y - speed)) this.y = this.y - speed;
        else m = 0;
    }

    public void moveLeft() {
        kill();
        _sprite = Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2,
                Sprite.balloom_left3, _animate, 20);
        this.img = _sprite.getFxImage();
        if (canMove.canMoveLeft(x - speed, y)) this.x = this.x - speed;
        else m = 0;
    }

    public void moveRight() {
        kill();
        _sprite = Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2,
                Sprite.balloom_right3, _animate, 20);
        this.img = _sprite.getFxImage();
        if (canMove.canMoveRight(x + 10 + speed, y)) this.x = this.x + speed;
        else m = 0;
    }
    public void dead() {
        alive = false;
        this.img = Sprite.balloom_dead.getFxImage();
        this.img = Sprite.movingSprite(Sprite.mob_dead1, Sprite.mob_dead2, Sprite.mob_dead3, _animate, 20).getFxImage();
    }

    public void kill() {
        if (handingEvent.bomber.alive) {
            int Ox = (handingEvent.bomber.getX() + Sprite.SCALED_SIZE/2) - (x + Sprite.SCALED_SIZE/2);
            int Oy = (handingEvent.bomber.getY() + Sprite.SCALED_SIZE/2) - (y + Sprite.SCALED_SIZE/2);
            if (Ox < 0) Ox = -Ox;
            if (Oy < 0) Oy = -Oy;
            if (Ox <= Sprite.SCALED_SIZE && Oy <= Sprite.SCALED_SIZE) handingEvent.bomber.dead();
        }
    }

    public boolean withExplosion( int BombX, int BombY) {
        int Ox = (x + Sprite.SCALED_SIZE/2) - (BombX + Sprite.SCALED_SIZE/2);
        int Oy = (y + Sprite.SCALED_SIZE/2) - (BombY + Sprite.SCALED_SIZE/2);
        if (Ox < 0) Ox = -Ox;
        if (Oy < 0) Oy = -Oy;
        if (Ox <= Sprite.SCALED_SIZE && Oy <= Sprite.SCALED_SIZE) return true;
        return false;
    }

    public void caculateDirection(int pos) {
        switch (pos) {
            case 0: {
                moveUp();
                return;
            }
            case 1: {
                moveRight();
                return;
            }
            case 2: {
                moveDown();
                return;
            }
            case 3: {
                moveLeft();
                return;
            }
        }
    }
    public void move() {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (alive) {
                    if (m > 0) {
                        m--;
                        caculateDirection(pos);
                    } else {
                        pos = rd.nextInt(4);
                        m = 50;
                    }
//                    if (m > 0){
//                        m--;
//                        moveLeft();
//                    } else if (m > -45) {
//                        m--;
//                        moveUp();
//                    } else if (m > -90) {
//                        m--;
//                        moveDown();
//                    } else if (m > -135) {
//                        m--;
//                        moveRight();
//                    } else {
//                        m = 45;
//                    }
                }

            }
        };
        timer.start();
    }
}
