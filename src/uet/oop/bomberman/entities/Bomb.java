package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.HandingCollision.BomberCollision;
import uet.oop.bomberman.HandingCollision.canMove;
<<<<<<< Updated upstream:src/uet/oop/bomberman/entities/Bomb.java
import uet.oop.bomberman.entities.enemy.Balloon;
=======
import uet.oop.bomberman.entities.AnimatedEntitiy;
import uet.oop.bomberman.entities.enemy.Balloon;
import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.entities.enemy.Oneal;
>>>>>>> Stashed changes:src/uet/oop/bomberman/entities/bomb/Bomb.java
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.input.handingEvent;

public class Bomb extends AnimatedEntitiy {
    public static int numberOfBomb = 1;
    public int timeToExplode;
    public int timeAfter;
    Sprite _sprite;

    public Bomb(int x, int y, Image img) {
        super(x, y, img);
        timeToExplode = 120;
        timeAfter = 20;
    }
    @Override
    public void update() {
        if (timeToExplode > 0) timeToExplode--;
        if(timeToExplode != 0) {
            change();
        } else if (timeAfter != 0){
            timeAfter--;
            DirectionalExplosion.explosion(x, y);
            explode();
            for(int i = 0; i < handingEvent.entities.size(); i++) {
                if (handingEvent.entities.get(i) instanceof Bomber) {
                    if(BomberCollision.withExplosion(x, y)) BomberCollision.bomber.dead();
                } else if (handingEvent.entities.get(i) instanceof Balloon) {
                    Balloon balloon = (Balloon) handingEvent.entities.get(i);
                    if (balloon.withExplosion(x, y)) {
                        balloon.dead();
                        handingEvent.entities.remove(balloon);
                    }
                }
            }
        } else {
            numberOfBomb++;
            handingEvent.BombAlive--;
            canMove.posXBomb = -1;
            canMove.posYBomb = -1;
            handingEvent.clearBomb();
            DirectionalExplosion.explosions.clear();
        }
        animate();
    }
    public void change() {
        _sprite = Sprite.movingSprite(Sprite.bomb, Sprite.bomb_1, Sprite.bomb_2, _animate, 60);
        this.img = _sprite.getFxImage();
    }
    public void explode() {
        _sprite = Sprite.bomb_exploded2;
       // _sprite = Sprite.movingSprite(Sprite.bomb_exploded, Sprite.bomb_exploded1, Sprite.bomb_exploded2, _animate, 10);
        this.img = _sprite.getFxImage();
    }
}