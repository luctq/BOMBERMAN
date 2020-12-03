package uet.oop.bomberman.entities.enemy;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import uet.oop.bomberman.HandingCollision.BombCollsion;
import uet.oop.bomberman.HandingCollision.canMove;
import uet.oop.bomberman.entities.Brick;
import uet.oop.bomberman.entities.ai.AIMedium;
import uet.oop.bomberman.entities.enemy.Enemy;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.input.handingEvent;

public class Kondoria extends Enemy {
    public Kondoria(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
        _sprite = Sprite.kondoria_left1;
        ai = new AIMedium(handingEvent.bomber, this);
        _direction = ai.calculateDirection();
        speed = 3;
        point = 800;
    }

    protected void chooseSprite(int i) {
        switch (i) {
            case 0:
                this.img = Sprite.kondoria_dead.getFxImage();
                this.img = Sprite.movingSprite(Sprite.mob_dead1, Sprite.mob_dead2, Sprite.mob_dead3, _animate, 60).getFxImage();
                //               _sprite = Sprite.movingSprite(Sprite.balloom_dead, Sprite.mob_dead1, Sprite.mob_dead2, _animate, 60);
                break;
            case 1:
                _sprite = Sprite.movingSprite(Sprite.kondoria_right1, Sprite.kondoria_right2, Sprite.kondoria_right3, _animate, 60);
                break;
            case 2:
                _sprite = Sprite.movingSprite(Sprite.kondoria_left1, Sprite.kondoria_left2, Sprite.kondoria_left3, _animate, 60);
                break;
        }
    }
    public void destroyMap() {
        int temp1 = x / Sprite.SCALED_SIZE;
        int temp2 = y / Sprite.SCALED_SIZE;
        if (map[temp2].charAt(temp1) == '*') {
            Brick brick = (Brick) handingEvent.stillObjects.get(temp1 + 31 * temp2);
            map[temp2] = map[temp2].substring(0, temp1) + ' ' + map[temp2].substring(temp1+1);
            brick.dead();
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
                    _steps -= 1+rest;
                    switch (_direction) {
                        case 0: {
                            destroyMap();
                            chooseSprite(1);
                            img = _sprite.getFxImage();
                            kill();
                            if (!BombCollsion.withEntities(x, y, canMove.posXBomb, canMove.posYBomb)) y--;
                            break;
                        }
                        case 1: {
                            destroyMap();
                            chooseSprite(1);
                            img = _sprite.getFxImage();
                            if (!BombCollsion.withEntities(x, y, canMove.posXBomb, canMove.posYBomb)) x++;
                            break;
                        }
                        case 2: {
                            destroyMap();
                            chooseSprite(2);
                            img = _sprite.getFxImage();
                            kill();
                            if (!BombCollsion.withEntities(x, y, canMove.posXBomb, canMove.posYBomb)) y++;
                            break;
                        }
                        case 3: {
                            destroyMap();
                            chooseSprite(2);
                            img = _sprite.getFxImage();
                            kill();
                            if (!BombCollsion.withEntities(x, y, canMove.posXBomb, canMove.posYBomb)) x--;
                            break;
                        }
                    }
                }
            }
        };
        timer.start();
    }
}
