package uet.oop.bomberman.entities;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Enemy;
import uet.oop.bomberman.entities.ai.AI;
import uet.oop.bomberman.entities.ai.AILow;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.input.handingEvent;

public class Balloon extends Enemy {

    public Balloon(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
        _sprite = Sprite.balloom_left1;
        aiLow = new AILow();
        _direction = aiLow.calculateDirection();
        speed = 1;
    }
    protected void chooseSprite(int i){
        switch(i) {
            case 0:
                this.img = Sprite.balloom_dead.getFxImage();
                this.img = Sprite.movingSprite(Sprite.mob_dead1, Sprite.mob_dead2, Sprite.mob_dead3, _animate, 60).getFxImage();
                //               _sprite = Sprite.movingSprite(Sprite.balloom_dead, Sprite.mob_dead1, Sprite.mob_dead2, _animate, 60);
                break;
            case 1:
                _sprite = Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2, Sprite.balloom_right3, _animate, 60);
                break;
            case 2:
                _sprite = Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2, Sprite.balloom_left3, _animate, 60);
                break;
        }
    }

    @Override
    public void move() {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (alive && handingEvent.bomber.alive) {
                    if (_steps <= 0){
                        _direction = aiLow.calculateDirection();
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