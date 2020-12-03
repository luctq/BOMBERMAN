package uet.oop.bomberman.entities.bomb;

import javafx.scene.image.Image;
import uet.oop.bomberman.HandingCollision.BomberCollision;
import uet.oop.bomberman.HandingCollision.EnemyCollision;
import uet.oop.bomberman.HandingCollision.canMove;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.entities.enemy.*;
import uet.oop.bomberman.entities.sound.SoundEffect;
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
        timeAfter = 10;
    }
    @Override
    public void update() {
        if (!handingEvent.bomber.alive) {
            timeToExplode = 0;
        }
        if (timeToExplode > 0) {
            timeToExplode--;
        }
        if(timeToExplode != 0) {
            change();
        } else if (timeAfter != 0) {
            SoundEffect.sound(SoundEffect.mediaPlayerBombExploded);
            timeAfter--;
            DirectionalExplosion.explosion(x, y);
            explode();
            if (timeAfter == 1) {
                for(int i = 0; i < handingEvent.entities.size(); i++) {
                    if (handingEvent.entities.get(i) instanceof Bomber) {
                        if (BomberCollision.withExplosion(x, y)) BomberCollision.bomber.dead();
                    } else if (handingEvent.entities.get(i) instanceof Balloon) {
                        Balloon balloon = (Balloon) handingEvent.entities.get(i);
                        if (EnemyCollision.withExplosion(balloon.getX(), balloon.getY(), x, y)) {
                            balloon.dead();
                        }
                    } else if (handingEvent.entities.get(i) instanceof Oneal) {
                        Oneal oneal = (Oneal) handingEvent.entities.get(i);
                        if (EnemyCollision.withExplosion(oneal.getX(), oneal.getY(), x, y)) {
                            oneal.dead();
                        }
                    } else if (handingEvent.entities.get(i) instanceof Doll) {
                        Doll doll = (Doll) handingEvent.entities.get(i);
                        if (EnemyCollision.withExplosion(doll.getX(), doll.getY(), x, y)) {
                            doll.dead();
                        }
                    } else if (handingEvent.entities.get(i) instanceof Minvo) {
                        Minvo minvo = (Minvo) handingEvent.entities.get(i);
                        if (EnemyCollision.withExplosion(minvo.getX(), minvo.getY(), x, y)) {
                            minvo.dead();
                        }
                    } else if (handingEvent.entities.get(i) instanceof Kondoria) {
                        Kondoria kondoria = (Kondoria) handingEvent.entities.get(i);
                        if (EnemyCollision.withExplosion(kondoria.getX(), kondoria.getY(), x, y)) {
                            kondoria.dead();
                        }
                    } else if (handingEvent.entities.get(i) instanceof Ghost) {
                        Ghost ghost = (Ghost) handingEvent.entities.get(i);
                        if (EnemyCollision.withExplosion(ghost.getX(), ghost.getY(), x, y)) {
                            ghost.dead();
                        }
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