package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.input.handingEvent;

public class Bomb extends AnimatedEntitiy {
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
        if (timeToExplode > 0) timeToExplode--;
        if(timeToExplode != 0) {
            change();
        } else if (timeAfter != 0){
            timeAfter--;
            explode();
        } else {
            removed = true;
            handingEvent.clearBomb();
        }
        animate();
    }
    public void change() {
        _sprite = Sprite.movingSprite(Sprite.bomb, Sprite.bomb_1, Sprite.bomb_2, _animate, 60);
        this.img = _sprite.getFxImage();
    }
    public void explode() {
        _sprite = Sprite.bomb_exploded;
        this.img = _sprite.getFxImage();
    }
}