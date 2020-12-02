package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.ai.AILow;
import uet.oop.bomberman.entities.ai.AIMedium;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.input.handingEvent;

public class Minvo extends Enemy {
    public Minvo(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
        _sprite = Sprite.minvo_left1;
        aiMedium = new AIMedium(this);
        _direction = aiMedium.calculateDirection();
    }

    protected void chooseSprite(int i) {
        switch (i) {
            case 0:
                this.img = Sprite.minvo_dead.getFxImage();
                this.img = Sprite.movingSprite(Sprite.mob_dead1, Sprite.mob_dead2, Sprite.mob_dead3, _animate, 60).getFxImage();
                //               _sprite = Sprite.movingSprite(Sprite.balloom_dead, Sprite.mob_dead1, Sprite.mob_dead2, _animate, 60);
                break;
            case 1:
                _sprite = Sprite.movingSprite(Sprite.minvo_right1, Sprite.minvo_right2, Sprite.minvo_right3, _animate, 60);
                break;
            case 2:
                _sprite = Sprite.movingSprite(Sprite.minvo_left1, Sprite.minvo_left2, Sprite.minvo_left3, _animate, 60);
                break;
        }
    }

    @Override
    public void move() {

    }
}