package uet.oop.bomberman.entities;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import uet.oop.bomberman.HandingCollision.canMove;
import uet.oop.bomberman.entities.Map.Level1;
import uet.oop.bomberman.graphics.Sprite;

import java.util.Random;

import static uet.oop.bomberman.graphics.Sprite.SCALED_SIZE;

public class Balloon extends AnimatedEntitiy {
    int m = 30;
    int[] arr = {0, -30, -60, -90};
    Random rd = new Random();
    int pos;
    String[] map = Level1.map;
    boolean removed = false;
    Sprite _sprite;
    public boolean goUp, goLeft, goRight, goDown = false;
    int speed = 1;
    public Balloon(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    @Override
    public void update() {
        animate();
    }

    public void  direction() {
        System.out.println(pos);
        if(canMove.canMoveUp(x, y - speed)) goUp = true;
        else goUp = false;

        if (canMove.canMoveRight(x + speed, y)) goRight = true;
        else goRight = false;
        if (canMove.canMoveDown(x, y + speed)) goDown = true;
        else goDown = false;
        if (canMove.canMoveLeft(x - speed, y)) goLeft = true;
        else goLeft = false;
    }
    public void moveDown() { ;
        if(canMove.canMoveDown(x, y + speed)) this.y = this.y + speed;
        else m = arr[pos];
    }

    public void moveUp() {
        if (canMove.canMoveUp(x, y - speed)) this.y = this.y - speed;
        else m = arr[pos];
    }

    public void moveLeft() {
        _sprite = Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2,
                Sprite.balloom_left3, _animate, 20);
        this.img = _sprite.getFxImage();
        if (canMove.canMoveLeft(x - speed, y)) this.x = this.x - speed;
        else m = arr[pos];
    }

    public void moveRight() {
        _sprite = Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2,
                Sprite.balloom_right3, _animate, 20);
        this.img = _sprite.getFxImage();
        if (canMove.canMoveRight(x + 10 + speed, y)) this.x = this.x + speed;
        else m = arr[pos];
    }
    public void move() {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                pos = rd.nextInt(4);
                if (m > 0){
                    m--;
                    moveUp();
                } else if (m > -30) {
                    m--;
                    moveLeft();
                } else if (m > -60) {
                    m--;
                    moveDown();
                } else if (m > -90) {
                    m--;
                    moveRight();
                } else {
                    m = 30;
                }
            }
        };
        timer.start();
    }
}
