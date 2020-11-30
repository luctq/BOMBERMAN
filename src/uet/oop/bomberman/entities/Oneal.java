package uet.oop.bomberman.entities;

import com.sun.scenario.effect.impl.prism.ps.PPSBlend_ADDPeer;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import uet.oop.bomberman.HandingCollision.BombCollsion;
import uet.oop.bomberman.HandingCollision.canMove;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.input.handingEvent;

public class Oneal extends AnimatedEntitiy {
    int timeDead = 30;
    int speed = 2;
    public boolean alive = true;
    public Oneal(int xUnit, int yUnit, Image img) {
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
    public void caculateDirection() {
        if (x > handingEvent.bomber.getX()) {
            if (!BombCollsion.withEntities(x, y, canMove.posXBomb, canMove.posYBomb) && canMove.canMoveLeft(x - speed, y)) x = x - speed;
        }
        if (!BombCollsion.withEntities(x, y, canMove.posXBomb, canMove.posYBomb) && x < handingEvent.bomber.getX())
            if (canMove.canMoveRight(x + speed, y)) x = x + speed;
        if (!BombCollsion.withEntities(x, y, canMove.posXBomb, canMove.posYBomb) && y > handingEvent.bomber.getY())
            if(canMove.canMoveUp(x, y - speed)) y = y - speed;
        if (!BombCollsion.withEntities(x, y, canMove.posXBomb, canMove.posYBomb) && y < handingEvent.bomber.getY())
            if (canMove.canMoveDown(x, y + speed)) y = y + speed;
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
    public void dead() {
        alive = false;
        this.img = Sprite.balloom_dead.getFxImage();
        this.img = Sprite.movingSprite(Sprite.mob_dead1, Sprite.mob_dead2, Sprite.mob_dead3, _animate, 20).getFxImage();
    }
     public void move() {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (alive) {
                    kill();
                    caculateDirection();
                }
            }
        };
        timer.start();
    }
}
