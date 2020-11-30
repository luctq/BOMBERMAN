package uet.oop.bomberman.entities;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
<<<<<<< Updated upstream
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
=======
import uet.oop.bomberman.HandingCollision.BombCollsion;
import uet.oop.bomberman.HandingCollision.canMove;
import uet.oop.bomberman.Map.Level;
import uet.oop.bomberman.entities.AnimatedEntitiy;
import uet.oop.bomberman.entities.enemy.AI;
import uet.oop.bomberman.entities.enemy.Balloon;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.input.handingEvent;

import java.util.Random;

public abstract class Enemy extends AnimatedEntitiy {
    public boolean alive = true;
    public int m = 90;
    //Random rd = new Random();
    //public int pos;
    public int timeDead = 30;
    public static String[] map = Level.map;
    public boolean removed = false;
    public int speed = 1;
    public int _direction;
    public AI ai;
    protected  double MAX_STEPS;
    protected  double rest;
    protected double _steps;
    public Enemy(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
        MAX_STEPS = Sprite.DEFAULT_SIZE / speed;
        rest = (MAX_STEPS - (int) MAX_STEPS) / MAX_STEPS;
        _steps = MAX_STEPS;
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream

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
=======
>>>>>>> Stashed changes
    }
    public void moveDown() {
        kill();
        chooseSprite(1);
<<<<<<< Updated upstream
        this.img = _sprite.getFxImage();
        if(canMove.canMoveDown(x, y + speed)) this.y = this.y + speed;
=======
//        _sprite = Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2,
//                Sprite.balloom_right3, _animate, 20);
        this.img = _sprite.getFxImage();
        if(!BombCollsion.withEntities(x, y + speed, canMove.posXBomb, canMove.posYBomb) && canMove.canMoveDown(x, y + speed)) this.y = this.y + speed;
>>>>>>> Stashed changes
        else m = 0;
    }

    public void moveUp() {
        kill();
<<<<<<< Updated upstream
        chooseSprite(2);
        this.img = _sprite.getFxImage();
        if (canMove.canMoveUp(x, y - speed)) this.y = this.y - speed;
=======
//        _sprite = Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2,
//                Sprite.balloom_left3, _animate, 20);
        chooseSprite(2);
        this.img = _sprite.getFxImage();
        if (!BombCollsion.withEntities(x, y, canMove.posXBomb, canMove.posYBomb) && canMove.canMoveUp(x, y - speed)) this.y = this.y - speed;
>>>>>>> Stashed changes
        else m = 0;
    }

    public void moveLeft() {
        kill();
<<<<<<< Updated upstream
        chooseSprite(2);
        this.img = _sprite.getFxImage();
        if (canMove.canMoveLeft(x - speed, y)) this.x = this.x - speed;
=======
//        _sprite = Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2,
//                Sprite.balloom_left3, _animate, 20);
        chooseSprite(2);
        this.img = _sprite.getFxImage();
        if (!BombCollsion.withEntities(x, y, canMove.posXBomb, canMove.posYBomb) && canMove.canMoveLeft(x - speed, y)) this.x = this.x - speed;
>>>>>>> Stashed changes
        else m = 0;
    }

    public void moveRight() {
        kill();
        chooseSprite(1);
        this.img = _sprite.getFxImage();
<<<<<<< Updated upstream
        if (canMove.canMoveRight(x + 10 + speed, y)) this.x = this.x + speed;
        else m = 0;
    }
    public boolean testDirection(int _direction) {
        switch (_direction) {
=======
        if (!BombCollsion.withEntities(x, y, canMove.posXBomb, canMove.posYBomb) && canMove.canMoveRight(x + 10 + speed, y)) this.x = this.x + speed;
        else m = 0;
    }
    public void dead() {
        alive = false;
        chooseSprite(0);
//        this.img = Sprite.balloom_dead.getFxImage();
//        this.img = Sprite.movingSprite(Sprite.mob_dead1, Sprite.mob_dead2, Sprite.mob_dead3, _animate, 20).getFxImage();
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
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
//        _direction = ai.calculateDirection();
=======
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
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
=======
                    if (_steps <= 0){
                        _direction = ai.calculateDirection();
                        _steps = MAX_STEPS;
                    }
                    if (testDirection(_direction)){
                        _steps -= 1+rest;
                        caculateDirection();
                    }else{
                        _steps = 0;
                    }
>>>>>>> Stashed changes
                }

            }
        };
        timer.start();
    }
    protected abstract void chooseSprite(int i);
<<<<<<< Updated upstream
=======
    protected abstract void chooseSprite();
>>>>>>> Stashed changes
}
