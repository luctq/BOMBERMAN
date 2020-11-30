package uet.oop.bomberman.entities.enemy;

import javafx.scene.image.Image;
<<<<<<< Updated upstream
import uet.oop.bomberman.entities.Bomber;
=======
>>>>>>> Stashed changes
import uet.oop.bomberman.entities.Enemy;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.input.handingEvent;

public class Balloon extends Enemy {

    public Balloon(int xUnit, int yUnit, Image img) {
<<<<<<< Updated upstream
        super(xUnit, yUnit, img, Sprite.balloom_left1, Bomber.speed/2);
        _sprite = Sprite.balloom_left1;
        ai = new AI(handingEvent.bomber, this);
    }



    protected void chooseSprite(int i) {
        switch(i) {
            case 0:
                _sprite = Sprite.movingSprite(Sprite.balloom_dead, Sprite.mob_dead1, Sprite.mob_dead2, _animate, 60);
=======
        super(xUnit, yUnit, img);
        _sprite = Sprite.balloom_left1;
        ai =new AI(handingEvent.bomber, this);
        _direction = ai.calculateDirection();
    }
    protected void chooseSprite(int i){
        switch(i) {
            case 0:
                this.img = Sprite.balloom_dead.getFxImage();
                this.img = Sprite.movingSprite(Sprite.mob_dead1, Sprite.mob_dead2, Sprite.mob_dead3, _animate, 20).getFxImage();
 //               _sprite = Sprite.movingSprite(Sprite.balloom_dead, Sprite.mob_dead1, Sprite.mob_dead2, _animate, 60);
>>>>>>> Stashed changes
                break;
            case 1:
                _sprite = Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2, Sprite.balloom_right3, _animate, 60);
                break;
            case 2:
                _sprite = Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2, Sprite.balloom_left3, _animate, 60);
                break;
        }
    }
<<<<<<< Updated upstream
}
=======
    protected void chooseSprite() {
        switch(_direction) {
            case 0:
//                _sprite = Sprite.movingSprite(Sprite.balloom_dead, Sprite.mob_dead1, Sprite.mob_dead2, _animate, 60);
//                break;
            case 1:
                _sprite = Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2, Sprite.balloom_right3, _animate, 60);
                break;
            case 2: case 3:
                _sprite = Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2, Sprite.balloom_left3, _animate, 60);
                break;
        }
    }

}
>>>>>>> Stashed changes
