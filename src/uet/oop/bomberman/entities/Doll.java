package uet.oop.bomberman.entities;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import uet.oop.bomberman.entities.ai.AILow;
import uet.oop.bomberman.entities.ai.AIMedium;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.input.handingEvent;

import java.util.Random;

public class Doll extends Enemy {

    Random random = new Random();
    //Bomber _bomber = handingEvent.bomber;

    public Doll(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
        _sprite = Sprite.doll_left1;
        aiLow = new AILow();
        aiMedium = new AIMedium(this);
        _direction = aiMedium.calculateDirection();
        speed = 2;
    }
    protected void chooseSprite(int i){
        switch(i) {
            case 0:
                this.img = Sprite.doll_dead.getFxImage();
                this.img = Sprite.movingSprite(Sprite.mob_dead1, Sprite.mob_dead2, Sprite.mob_dead3, _animate, 20).getFxImage();
                //               _sprite = Sprite.movingSprite(Sprite.balloom_dead, Sprite.mob_dead1, Sprite.mob_dead2, _animate, 60);
                break;
            case 1:
                _sprite = Sprite.movingSprite(Sprite.doll_right1, Sprite.doll_right2, Sprite.doll_right3, _animate, 60);
                break;
            case 2:
                _sprite = Sprite.movingSprite(Sprite.doll_left1, Sprite.doll_left2, Sprite.doll_left3, _animate, 60);
                break;
        }
    }


    @Override
    public void move() {
//        AnimationTimer timer = new AnimationTimer() {
//            @Override
//            public void handle(long now) {
//                if (alive && handingEvent.bomber.alive) {
//                    kill();
//                    _direction = ai.calculateDirection();
//                    caculateDirection();
//                }
//
//            }
//        };
//        timer.start();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (alive && handingEvent.bomber.alive) {
                    if (_steps <= 0){
                        _direction = aiMedium.calculateDirection();
                        _steps = MAX_STEPS;
                    }

                    if (testDirection(_direction)){
                        _steps -= 1+rest;
                        caculateDirection();
                    }else{
                        _steps = 0;
                    }
                }

            }
        };
        timer.start();
    }

}
