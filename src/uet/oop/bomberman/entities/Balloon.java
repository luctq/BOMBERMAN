package uet.oop.bomberman.entities;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import uet.oop.bomberman.HandingCollision.BombCollsion;
import uet.oop.bomberman.HandingCollision.canMove;
import uet.oop.bomberman.Map.Level;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.input.handingEvent;

import java.util.Random;

public class Balloon extends AnimatedEntitiy {
    public boolean alive = true;
    int m = 90;
    Random rd = new Random();
    int pos;
    int timeDead = 30;
    public static String[] map = Level.map;
    boolean removed = false;
    Sprite _sprite;
    int speed = 1;
    public Balloon(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    @Override
    public void update() {
        animate();
        if (alive == false) {
            if (timeDead > 0) timeDead--;
            if (timeDead == 0) {
                handingEvent.entities.remove(this);
                timeDead = 30;
            }
        }

    }
    public void moveDown() {
        kill();
        _sprite = Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2,
                Sprite.balloom_right3, _animate, 20);
        this.img = _sprite.getFxImage();
        if(!BombCollsion.withEntities(x, y + speed, canMove.posXBomb, canMove.posYBomb) && canMove.canMoveDown(x, y + speed)) this.y = this.y + speed;
        else m = 0;
    }

    public void moveUp() {
        kill();
        _sprite = Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2,
                Sprite.balloom_left3, _animate, 20);
        this.img = _sprite.getFxImage();
        if (!BombCollsion.withEntities(x, y, canMove.posXBomb, canMove.posYBomb) && canMove.canMoveUp(x, y - speed)) this.y = this.y - speed;
        else m = 0;
    }

    public void moveLeft() {
        kill();
        _sprite = Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2,
                Sprite.balloom_left3, _animate, 20);
        this.img = _sprite.getFxImage();
        if (!BombCollsion.withEntities(x, y, canMove.posXBomb, canMove.posYBomb) && canMove.canMoveLeft(x - speed, y)) this.x = this.x - speed;
        else m = 0;
    }

    public void moveRight() {
        kill();
        _sprite = Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2,
                Sprite.balloom_right3, _animate, 20);
        this.img = _sprite.getFxImage();
        if (!BombCollsion.withEntities(x, y, canMove.posXBomb, canMove.posYBomb) && canMove.canMoveRight(x + 10 + speed, y)) this.x = this.x + speed;
        else m = 0;
    }
    public void dead() {
        alive = false;
        this.img = Sprite.balloom_dead.getFxImage();
        this.img = Sprite.movingSprite(Sprite.mob_dead1, Sprite.mob_dead2, Sprite.mob_dead3, _animate, 20).getFxImage();
    }

    public void kill() {
        if (handingEvent.bomber.alive) {
            int Ox = (handingEvent.bomber.getX() + 20/2) - (x + Sprite.SCALED_SIZE/2);
            int Oy = (handingEvent.bomber.getY() + Sprite.SCALED_SIZE/2) - (y + Sprite.SCALED_SIZE/2);
            if (Ox < 0) Ox = -Ox;
            if (Oy < 0) Oy = -Oy;
            if (Ox <= (Sprite.SCALED_SIZE + 20) / 2 && Oy <= Sprite.SCALED_SIZE) handingEvent.bomber.dead();
        }
    }

    public boolean withExplosion( int BombX, int BombY) {
        BombX = BombX - Sprite.SCALED_SIZE;
        int Ox = (x + Sprite.SCALED_SIZE/2) - (BombX + Sprite.SCALED_SIZE/2);
        int Oy = (y + Sprite.SCALED_SIZE/2) - (BombY + Sprite.SCALED_SIZE/2);
        if (Ox < 0) Ox = -Ox;
        if (Oy < 0) Oy = -Oy;
        if (Ox <= Sprite.SCALED_SIZE && Oy <= Sprite.SCALED_SIZE) return true;
        return false;
    }

    public boolean collisionWithOtherBalloon() {
        for (int i = 0; i < handingEvent.entities.size(); i++) {
            if (handingEvent.entities.get(i) instanceof Balloon) {
                if (!this.equals(handingEvent.entities.get(i))) {
                    Balloon otherBalloon = (Balloon) handingEvent.entities.get(i);
                    int Ox = (x + (Sprite.SCALED_SIZE + 5)/2) - (otherBalloon.getX() + (Sprite.SCALED_SIZE + 5)/2);
                    int Oy = (y + (Sprite.SCALED_SIZE + 5)/2) - (otherBalloon.getY() + (Sprite.SCALED_SIZE + 5)/2);
                    if (Ox < 0) Ox = -Ox;
                    if (Oy < 0) Oy = -Oy;
                    if (Ox <= Sprite.SCALED_SIZE + 5 && Oy <= Sprite.SCALED_SIZE + 5) return true;
                }
            }
        }
        return false;
    }
    public boolean testDirection(int pos) {
        switch (pos) {
            case 0: {
                if (canMove.canMoveUp(x, y - speed)) return true;
                return false;
            }
            case 1: {
                if (canMove.canMoveRight(x + 10 + speed, y)) return true;
                return false;
            }
            case 2: {
                if (canMove.canMoveDown(x, y + speed)) return true;
                return false;
            }
            case 3: {
                if (canMove.canMoveLeft(x - speed, y)) return true;
                else return false;
            }
            default: {
                return false;
            }
        }
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
                        while (!testDirection(pos)) {
                            pos = rd.nextInt(4);
                        }
                        m = rd.nextInt(60);
                    }
                }

            }
        };
        timer.start();
    }
}