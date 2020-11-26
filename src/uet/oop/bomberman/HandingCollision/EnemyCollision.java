package uet.oop.bomberman.HandingCollision;

import uet.oop.bomberman.entities.Balloon;
import uet.oop.bomberman.entities.DirectionalExplosion;
import uet.oop.bomberman.graphics.Sprite;

public class EnemyCollision {
    public static boolean withExplosion(Balloon balloon, int x, int y) {
        if (balloon.getY() >= y && balloon.getY() <= y + Sprite.SCALED_SIZE ||
                balloon.getY() + 32 >= y && balloon.getY() + 32 <= y + Sprite.SCALED_SIZE) {
            if (balloon.getX() > x - Sprite.SCALED_SIZE * DirectionalExplosion.radius
                    && balloon.getX() < x + Sprite.SCALED_SIZE * (DirectionalExplosion.radius + 1)) {
                return true;
            } else if (balloon.getX() + 32 > x - Sprite.SCALED_SIZE * DirectionalExplosion.radius
                    && balloon.getX() + 32 < x + Sprite.SCALED_SIZE * (DirectionalExplosion.radius+1)) {
                return true;
            }
        } else if ((balloon.getX() >= x && balloon.getX() <= x + Sprite.SCALED_SIZE) ||
                (balloon.getX() + 32 <= x && balloon.getX() + 32 <= x + Sprite.SCALED_SIZE)) {
            if (balloon.getY() > y - Sprite.SCALED_SIZE * DirectionalExplosion.radius
                    && balloon.getY() < y + Sprite.SCALED_SIZE * (DirectionalExplosion.radius + 1)) {
                return true;
            } else if (balloon.getY() + 32 > y - Sprite.SCALED_SIZE * DirectionalExplosion.radius
                    && balloon.getY() + 32 < y + Sprite.SCALED_SIZE * (DirectionalExplosion.radius + 1)) {
                return true;
            }
        }
        return false;
    }
}
