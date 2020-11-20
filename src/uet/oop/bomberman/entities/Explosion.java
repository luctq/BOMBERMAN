package uet.oop.bomberman.entities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

public class Explosion extends AnimatedEntitiy {
    static Sprite _sprite;
    public int direction;
    public Explosion(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    @Override
    public void update() {
        animate();
//        if (direction == 0) {
//                _sprite = Sprite.movingSprite(Sprite.explosion_horizontal_left_last2, Sprite.explosion_horizontal_left_last, Sprite.explosion_horizontal_left_last1, _animate, 10);
//                this.img = _sprite.getFxImage();
//        } else if (direction == 1) {
//            _sprite = Sprite.movingSprite(Sprite.explosion_horizontal_right_last2, Sprite.explosion_horizontal_right_last, Sprite.explosion_horizontal_right_last1, _animate, 10);
//            this.img = _sprite.getFxImage();
//        }
//        else if (direction == 2) {
//            _sprite = Sprite.movingSprite(Sprite.explosion_vertical_down_last2, Sprite.explosion_vertical_down_last, Sprite.explosion_vertical_down_last1, _animate, 10);
//            this.img = _sprite.getFxImage();
//        }
//        else if (direction == 3) {
//            _sprite = Sprite.movingSprite(Sprite.explosion_vertical_top_last2, Sprite.explosion_vertical_top_last, Sprite.explosion_vertical_top_last1, _animate, 10);
//            this.img = _sprite.getFxImage();
//        }
    }
}
