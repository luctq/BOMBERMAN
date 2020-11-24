package uet.oop.bomberman.entities;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import uet.oop.bomberman.HandingCollision.canExplosion;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.input.handingEvent;

import java.util.List;

public class DirectionalExplosion {
    public static List<Entity> stillObjects;
    public static List<Entity> entities;
    public static List<Explosion> explosions;
    public Bomber bomber;
    public static int radius = 1;
    public DirectionalExplosion(List<Entity> entities, List<Entity> stillObjects, List<Explosion> explosions) {
        this.explosions = explosions;
        this.stillObjects = stillObjects;
        this.entities = entities;
    }

    public static void explosion(int posX, int posY) {
        if (canExplosion.explosionLeft(posX - 32, posY)) {
            Left(posX - 32, posY);
            canExplosion.destroy(posX - 32, posY);
        }
        if (canExplosion.explosionRight(posX + 32, posY)){
            Right(posX + 32, posY);
            canExplosion.destroy(posX + 32, posY);
        }
        if (canExplosion.explosionUp(posX, posY - 32)) {
            Down(posX, posY - 32);
            canExplosion.destroy(posX, posY - 32);
        }
        if (canExplosion.explosionDown(posX, posY + 32)) {
            Up(posX, posY + 32);
            canExplosion.destroy(posX, posY + 32);
        }

    }
    public static void Left(int x, int y) {
        int temp = radius;
        while (temp > 1) {
            Explosion explosion = new Explosion(x/ Sprite.SCALED_SIZE, y/ Sprite.SCALED_SIZE, Sprite.explosion_horizontal2.getFxImage());
            explosions.add(explosion);
            x = x - 32;
            temp--;
        }
        if (handingEvent.bomber.getX() > x) handingEvent.bomber.dead();
        Explosion left = new Explosion(x/ Sprite.SCALED_SIZE, y/ Sprite.SCALED_SIZE, Sprite.explosion_horizontal_left_last2.getFxImage());
        explosions.add(left);
        left.direction = 0;
    }
    public static void Right(int x, int y) {
        int temp = radius;
        while (temp > 1) {
            Explosion explosion = new Explosion(x/ Sprite.SCALED_SIZE, y/ Sprite.SCALED_SIZE, Sprite.explosion_horizontal2.getFxImage());
            explosions.add(explosion);
            x = x + 32;
            temp--;
        }
        Explosion right = new Explosion(x/ Sprite.SCALED_SIZE, y/ Sprite.SCALED_SIZE, Sprite.explosion_horizontal_right_last2.getFxImage());
        explosions.add(right);
        right.direction = 1;
    }
    public static void Up(int x, int y) {
        int temp = radius;
        while (temp > 1) {
            Explosion explosion = new Explosion(x/ Sprite.SCALED_SIZE, y/ Sprite.SCALED_SIZE, Sprite.explosion_vertical2.getFxImage());
            explosions.add(explosion);
            y = y + 32;
            temp--;
        }
        Explosion up = new Explosion(x/ Sprite.SCALED_SIZE, y/ Sprite.SCALED_SIZE, Sprite.explosion_vertical_down_last2.getFxImage());
        explosions.add(up);
        up.direction = 2;
    }
    public static void Down(int x, int y) {
        int temp = radius;
        while (temp > 1) {
            Explosion explosion = new Explosion(x/ Sprite.SCALED_SIZE, y/ Sprite.SCALED_SIZE, Sprite.explosion_vertical2.getFxImage());
            explosions.add(explosion);
            explosion.direction = 3;
            y = y - 32;
            temp--;
        }
        Explosion down = new Explosion(x/ Sprite.SCALED_SIZE, y/ Sprite.SCALED_SIZE, Sprite.explosion_vertical_top_last2.getFxImage());
        explosions.add(down);
        down.direction = 3;
    }

}
