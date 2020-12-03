package uet.oop.bomberman.entities.enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.ai.AIMedium;
import uet.oop.bomberman.entities.enemy.Enemy;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.input.handingEvent;

public class Ghost extends Enemy {
    public int life = 2;
    public Ghost(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
        _sprite = Sprite.ghost_left1;
        ai = new AIMedium(handingEvent.bomber, this);
        _direction = ai.calculateDirection();
        speed = 3;
        point = 1000;
    }
    public void reset() {
        alive = true;
        this.x = 29 * Sprite.SCALED_SIZE;
        this.y = 11 * Sprite.SCALED_SIZE;
    }
    public void dead() {
        if (life > 0) {
            reset();
            life--;
        } else {
            alive = false;
            chooseSprite(0);
        }

    }
    protected void chooseSprite(int i) {
        switch (i) {
            case 0:
                this.img = Sprite.ghost_dead.getFxImage();
                this.img = Sprite.movingSprite(Sprite.mob_dead1, Sprite.mob_dead2, Sprite.mob_dead3, _animate, 60).getFxImage();
                //               _sprite = Sprite.movingSprite(Sprite.balloom_dead, Sprite.mob_dead1, Sprite.mob_dead2, _animate, 60);
                break;
            case 1:
                _sprite = Sprite.movingSprite(Sprite.ghost_right1, Sprite.ghost_right2, Sprite.ghost_right3, _animate, 60);
                break;
            case 2:
                _sprite = Sprite.movingSprite(Sprite.ghost_left1, Sprite.ghost_left2, Sprite.ghost_left3, _animate, 60);
                break;
        }
    }
}
