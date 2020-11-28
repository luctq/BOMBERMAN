package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.HandingCollision.canMove;
import uet.oop.bomberman.graphics.Sprite;

public class Bomber extends AnimatedEntitiy {
        public boolean alive = true;
        public static int speed = 2;
        boolean up, down, right, left;
        Sprite _sprite;
        public Bomber(int x, int y, Image img) {
            super( x, y, img);
        }
        @Override
        public void update() {
            animate();

        }
        public void moveDown() {
            _sprite = Sprite.player_down;
            _sprite = Sprite.movingSprite(Sprite.player_down_1, Sprite.player_down_2, _animate, 20);
            this.img = _sprite.getFxImage();
            if (canMove.canMoveDown(this.x, this.y+2)) this.y = this.y + speed;
        }

        public void moveUp() {
            _sprite = Sprite.player_up;
            _sprite = Sprite.movingSprite(Sprite.player_up_1, Sprite.player_up_2, _animate, 20);
            this.img = _sprite.getFxImage();
            if (canMove.canMoveUp(this.x, this.y-2)) this.y = this.y - speed;
        }

        public void moveLeft() {
            _sprite = Sprite.player_left;
            _sprite = Sprite.movingSprite(Sprite.player_left_1, Sprite.player_left_2, _animate, 20);
            this.img = _sprite.getFxImage();
            if (canMove.canMoveLeft(this.x - 2, this.y)) this.x = this.x - speed;
        }

        public void moveRight() {
            _sprite = Sprite.player_right;
            _sprite = Sprite.movingSprite(Sprite.player_right_1, Sprite.player_right_2, _animate, 20);
            this.img = _sprite.getFxImage();
            if (canMove.canMoveRight(this.x+2, this.y)) this.x = this.x + speed;
        }

        public void dead() {
            alive = false;
            this.img = Sprite.movingSprite(Sprite.player_dead1, Sprite.player_dead2, Sprite.player_dead3, _animate, 20).getFxImage();
        }
        public void backUp() {
            this.img = Sprite.player_up.getFxImage();
        }
        public void backDown() {
            this.img = Sprite.player_down.getFxImage();
        }
        public void backLeft() {
            this.img = Sprite.player_left.getFxImage();
        }
        public void backRight() {
            this.img = Sprite.player_right.getFxImage();
        }

        public void reset() {
            alive = true;
            this.x = Sprite.SCALED_SIZE;
            this.y = Sprite.SCALED_SIZE;
            this.img = Sprite.player_right.getFxImage();
        }
}
