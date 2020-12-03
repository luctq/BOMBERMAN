package uet.oop.bomberman.entities.enemy;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import uet.oop.bomberman.HandingCollision.BombCollsion;
import uet.oop.bomberman.HandingCollision.canMove;
import uet.oop.bomberman.entities.enemy.Enemy;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.input.handingEvent;

public class Oneal extends Enemy {
    public Oneal(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
        speed = 1;
        point = 200;
    }
    public void caculateDirection() {
        if (!BombCollsion.withEntities(x, y, canMove.posXBomb, canMove.posYBomb) && x > handingEvent.bomber.getX())
            if (canMove.canMoveLeft(x - speed, y)) {
                x = x - speed;
                chooseSprite(2);
                this.img = _sprite.getFxImage();
            }
        if (!BombCollsion.withEntities(x, y, canMove.posXBomb, canMove.posYBomb) && x < handingEvent.bomber.getX())
            if (canMove.canMoveRight(x + 8 + speed, y)) {
                x = x + speed;
                chooseSprite(1);
                this.img = _sprite.getFxImage();
            }
        if (!BombCollsion.withEntities(x, y, canMove.posXBomb, canMove.posYBomb) && y > handingEvent.bomber.getY())
            if(canMove.canMoveUp(x, y - speed)) {
                y = y - speed;
                chooseSprite(2);
                this.img = _sprite.getFxImage();
            }
        if (!BombCollsion.withEntities(x, y, canMove.posXBomb, canMove.posYBomb) && y < handingEvent.bomber.getY())
            if (canMove.canMoveDown(x, y + speed)) {
                y = y + speed;
                chooseSprite(1);
                this.img = _sprite.getFxImage();
            }
    }
    public void move() {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (alive && handingEvent.bomber.alive) {
                    kill();
                    caculateDirection();
                }
            }
        };
        timer.start();
    }

    @Override
    protected void chooseSprite(int i) {
        switch (i) {
            case 0:
                this.img = Sprite.oneal_dead.getFxImage();
                this.img = Sprite.movingSprite(Sprite.mob_dead1, Sprite.mob_dead2, Sprite.mob_dead3, _animate, 60).getFxImage();
                //               _sprite = Sprite.movingSprite(Sprite.balloom_dead, Sprite.mob_dead1, Sprite.mob_dead2, _animate, 60);
                break;
            case 1:
                _sprite = Sprite.movingSprite(Sprite.oneal_right1, Sprite.oneal_right2, Sprite.oneal_right3, _animate, 60);
                break;
            case 2:
                _sprite = Sprite.movingSprite(Sprite.oneal_left1, Sprite.oneal_left2, Sprite.oneal_left3, _animate, 60);
                break;
        }
    }
}
