package uet.oop.bomberman.entities.enemy;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.Game;
import uet.oop.bomberman.HandingCollision.BombCollsion;
import uet.oop.bomberman.HandingCollision.canMove;
import uet.oop.bomberman.Map.Level;
import uet.oop.bomberman.entities.AnimatedEntitiy;
import uet.oop.bomberman.entities.ai.AI;
import uet.oop.bomberman.entities.sound.SoundEffect;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.input.handingEvent;

public abstract class Enemy extends AnimatedEntitiy {
    public int point;
    public boolean alive = true;
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
        MAX_STEPS = Sprite.SCALED_SIZE / speed;
        rest = (MAX_STEPS - (int) MAX_STEPS) / MAX_STEPS;
        _steps = MAX_STEPS;
    }
    @Override
    public void update() {
        animate();
        if (alive == false) {
            BombermanGame.gc1.fillText("+" + point, x, y + 64);
            SoundEffect.sound(SoundEffect.mediaPlayerCollisionEnemy);
            if (timeDead > 0) timeDead--;
            if (timeDead == 0) {
                handingEvent.entities.remove(this);
                Game.POINTS += point;
                timeDead = 30;
            }
        }
    }
    public void moveDown() {
        kill();
        chooseSprite(1);
//        _sprite = Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2,
//                Sprite.balloom_right3, _animate, 20);
        this.img = _sprite.getFxImage();
        if(!BombCollsion.withEntities(x, y + speed, canMove.posXBomb, canMove.posYBomb) && canMove.canMoveDown(x, y + speed)) this.y = this.y + speed;
        else _steps = 0;
    }

    public void moveUp() {
        kill();
//        _sprite = Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2,
//                Sprite.balloom_left3, _animate, 20);
        chooseSprite(2);
        this.img = _sprite.getFxImage();
        if (canMove.canMoveUp(x, y - speed)) this.y = this.y - speed;
        else _steps = 0;
    }

    public void moveLeft() {
        kill();

//        _sprite = Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2,
//                Sprite.balloom_left3, _animate, 20);
        chooseSprite(2);
        this.img = _sprite.getFxImage();
        if (canMove.canMoveLeft(x - speed, y)) this.x = this.x - speed;
        else _steps = 0;
    }

    public void moveRight() {
        kill();
        chooseSprite(1);
        this.img = _sprite.getFxImage();
        if (canMove.canMoveRight(x + 10 + speed, y)) this.x = this.x + speed;
        else _steps = 0;
    }
    public void dead() {
        alive = false;
        chooseSprite(0);
//        killing.stop();
//        killing.play();
//        this.img = Sprite.balloom_dead.getFxImage();
//        this.img = Sprite.movingSprite(Sprite.mob_dead1, Sprite.mob_dead2, Sprite.mob_dead3, _animate, 20).getFxImage();
    }

    public void kill() {
        if (handingEvent.bomber.alive) {
            int Ox = (handingEvent.bomber.getX() + 20/2) - (x + Sprite.SCALED_SIZE/2);
            int Oy = (handingEvent.bomber.getY() + Sprite.SCALED_SIZE/2) - (y + Sprite.SCALED_SIZE/2);
            if (Ox < 0) Ox = -Ox;
            if (Oy < 0) Oy = -Oy;
            if (Ox <= (Sprite.SCALED_SIZE + 20) / 2 && Oy <= Sprite.SCALED_SIZE) {
                handingEvent.bomber.dead();
            }
        }
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
    public void caculateDirection() {
        if(BombCollsion.withEntities(x, y, canMove.posXBomb, canMove.posYBomb)) {
            _direction = (_direction + 2) % 4;
        }
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
                if (alive && handingEvent.bomber.alive) {
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
                }

            }
        };
        timer.start();
    }
    protected abstract void chooseSprite(int i);
}