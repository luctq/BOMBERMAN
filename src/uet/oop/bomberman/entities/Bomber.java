package uet.oop.bomberman.entities;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import uet.oop.bomberman.HandingCollision.canMove;
import uet.oop.bomberman.entities.Map.Level1;
import uet.oop.bomberman.graphics.Sprite;

public class Bomber extends AnimatedEntitiy {
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
            if (canMove.canMoveDown(this.x, this.y+2)) this.y = this.y + 2;
        }

        public void moveUp() {
            _sprite = Sprite.player_up;
            _sprite = Sprite.movingSprite(Sprite.player_up_1, Sprite.player_up_2, _animate, 20);
            this.img = _sprite.getFxImage();
            if (canMove.canMoveUp(this.x, this.y-2)) this.y = this.y - 2;
        }

        public void moveLeft() {
            _sprite = Sprite.player_left;
            _sprite = Sprite.movingSprite(Sprite.player_left_1, Sprite.player_left_2, _animate, 20);
            this.img = _sprite.getFxImage();
            if (canMove.canMoveLeft(this.x - 2, this.y)) this.x = this.x - 2;
        }

        public void moveRight() {
            _sprite = Sprite.player_right;
            _sprite = Sprite.movingSprite(Sprite.player_right_1, Sprite.player_right_2, _animate, 20);
            this.img = _sprite.getFxImage();
            if (canMove.canMoveRight(this.x+2, this.y)) this.x = this.x + 2;
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
        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
}
