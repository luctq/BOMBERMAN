package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

import java.util.Scanner;

public class Brick  extends AnimatedEntitiy {
    public boolean alive = true;
    int timeDead = 30;
    public Brick(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {
        animate();
        if (!alive) {
            if (timeDead > 0) timeDead--;
            if (timeDead == 0) {
                this.img = Sprite.grass.getFxImage();
                timeDead = 30;
            }
        }
    }

    public void dead() {
        alive = false;
        this.img = Sprite.movingSprite(Sprite.brick_exploded, Sprite.brick_exploded1, Sprite.brick_exploded2, _animate, 60).getFxImage();
    }
}
