package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

public class Bomb extends AnimatedEntitiy {
    public static int timeToExplode;
    public static int explode = 0;
    Sprite _sprite;
    public Bomb(int x, int y, Image img) {
        super(x, y, img);
    }
    @Override
    public void update() {
        if (timeToExplode > 0) timeToExplode--;
        if(timeToExplode != 0) {
            _sprite = Sprite.movingSprite(Sprite.bomb, Sprite.bomb_1, Sprite.bomb_2, _animate, 60);
        } else {
            _sprite = Sprite.bomb_exploded;
            explode = 10;
        }
        this.img = _sprite.getFxImage();
        animate();
    }

    public void change() {
        _sprite = Sprite.movingSprite(Sprite.bomb, Sprite.bomb_1, Sprite.bomb_2, _animate, 60);
        this.img = _sprite.getFxImage();
    }

}