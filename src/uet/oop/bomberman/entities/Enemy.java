package uet.oop.bomberman.entities;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import uet.oop.bomberman.HandingCollision.canMove;
import uet.oop.bomberman.Map.Level;
import uet.oop.bomberman.entities.enemy.AI;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.input.handingEvent;

public abstract class Enemy extends AnimatedEntitiy{
    public boolean alive = true;
 //   protected boolean move = false;
    public AI ai;
    public int timeDead = 30;
    public int m = 90;
//    public Random random;
    public int _direction;
    public int speed ;
    public Sprite _deadSprite;
    String[] map = Level.map;
    boolean removed = false;
    public Enemy(int x, int y, Image img, Sprite dead, int _speed){
        super(x, y, img);
        _deadSprite = dead;
        speed = _speed;
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
    public void dead() {
        alive = false;
        chooseSprite(0);
        this.img = _sprite.getFxImage();
//        this.img = Sprite.movingSprite(Sprite.mob_dead1, Sprite.mob_dead2, Sprite.mob_dead3, _animate, 60).getFxImage();
    }
    public void moveDown() {
        kill();
        chooseSprite(1);
        this.img = _sprite.getFxImage();
        if(canMove.canMoveDown(x, y + speed)) this.y = this.y + speed;
        else m = 0;
    }

    public void moveUp() {
        kill();
        chooseSprite(2);
        this.img = _sprite.getFxImage();
        if (canMove.canMoveUp(x, y - speed)) this.y = this.y - speed;
        else m = 0;
    }

    public void moveLeft() {
        kill();
        chooseSprite(2);
        this.img = _sprite.getFxImage();
        if (canMove.canMoveLeft(x - speed, y)) this.x = this.x - speed;
        else m = 0;
    }

    public void moveRight() {
        kill();
        chooseSprite(1);
        this.img = _sprite.getFxImage();
        if (canMove.canMoveRight(x + 10 + speed, y)) this.x = this.x + speed;
        else m = 0;
    }
    public boolean testDirection(int _direction) {
        switch (_direction) {
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
    public void caculateDirection() {
//        _direction = ai.calculateDirection();
        switch (_direction) {
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
                        caculateDirection();
                    } else {
                        _direction = ai.calculateDirection();
                        while (!testDirection(_direction)) {
                            _direction = ai.calculateDirection();
                        }
                        m = _direction*_direction;
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
    protected abstract void chooseSprite(int i);
}
