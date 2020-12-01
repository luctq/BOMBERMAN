package uet.oop.bomberman.entities.bomb;

import javafx.scene.image.Image;
import javafx.scene.media.MediaPlayer;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.HandingCollision.BomberCollision;
import uet.oop.bomberman.HandingCollision.EnemyCollision;
import uet.oop.bomberman.HandingCollision.canMove;
import uet.oop.bomberman.entities.AnimatedEntitiy;
import uet.oop.bomberman.entities.enemy.Balloon;
import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.entities.enemy.Oneal;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.input.handingEvent;
import uet.oop.bomberman.sound.MusicLoader;

public class Bomb extends AnimatedEntitiy {
    public static int numberOfBomb = 1;
    public int timeToExplode;
    public int timeAfter;
    Sprite _sprite;
    MediaPlayer bomb;

    public Bomb(int x, int y, Image img) {
        super(x, y, img);
        timeToExplode = 120;
        timeAfter = 10;
        bomb = MusicLoader.getInstance().getSound("bomb");
    }
    @Override
    public void update() {
        if (timeToExplode > 0) {
            timeToExplode--;
        }
        if(timeToExplode != 0) {
            change();
            bomb.stop();
            bomb.play();
        } else if (timeAfter != 0){
            timeAfter--;
            DirectionalExplosion.explosion(x, y);
            explode();
            for(int i = 0; i < handingEvent.entities.size(); i++) {
                if (handingEvent.entities.get(i) instanceof Bomber) {
                    if(BomberCollision.withExplosion(x, y)) BomberCollision.bomber.dead();
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