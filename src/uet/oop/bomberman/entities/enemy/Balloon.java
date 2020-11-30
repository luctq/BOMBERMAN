package uet.oop.bomberman.entities.enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.entities.Enemy;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.input.handingEvent;

public class Balloon extends Enemy {

    public Balloon(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img, Sprite.balloom_left1, Bomber.speed/2);
        _sprite = Sprite.balloom_left1;
        ai = new AI(handingEvent.bomber, this);
    }



    protected void chooseSprite(int i) {
        switch(i) {
            case 0:
                _sprite = Sprite.movingSprite(Sprite.balloom_dead, Sprite.mob_dead1, Sprite.mob_dead2, _animate, 60);
                break;
            case 1:
                _sprite = Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2, Sprite.balloom_right3, _animate, 60);
                break;
            case 2:
                _sprite = Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2, Sprite.balloom_left3, _animate, 60);
                break;
        }
    }
}
