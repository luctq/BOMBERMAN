package uet.oop.bomberman.HandingCollision;

import uet.oop.bomberman.entities.Enemy;
import uet.oop.bomberman.entities.enemy.Balloon;
import uet.oop.bomberman.entities.DirectionalExplosion;
import uet.oop.bomberman.graphics.Sprite;

public class EnemyCollision {
    public static boolean withExplosion(Enemy enemy, int x, int y) {
        if (enemy.getY() >= y && enemy.getY() <= y + Sprite.SCALED_SIZE ||
                enemy.getY() + 32 >= y && enemy.getY() + 32 <= y + Sprite.SCALED_SIZE) {
            if (enemy.getX() > x - Sprite.SCALED_SIZE * DirectionalExplosion.radius
                    && enemy.getX() < x + Sprite.SCALED_SIZE * (DirectionalExplosion.radius + 1)) {
                return true;
            } else if (enemy.getX() + 32 > x - Sprite.SCALED_SIZE * DirectionalExplosion.radius
                    && enemy.getX() + 32 < x + Sprite.SCALED_SIZE * (DirectionalExplosion.radius+1)) {
                return true;
            }
        } else if ((enemy.getX() >= x && enemy.getX() <= x + Sprite.SCALED_SIZE) ||
                (enemy.getX() + 32 <= x && enemy.getX() + 32 <= x + Sprite.SCALED_SIZE)) {
            if (enemy.getY() > y - Sprite.SCALED_SIZE * DirectionalExplosion.radius
                    && enemy.getY() < y + Sprite.SCALED_SIZE * (DirectionalExplosion.radius + 1)) {
                return true;
            } else if (enemy.getY() + 32 > y - Sprite.SCALED_SIZE * DirectionalExplosion.radius
                    && enemy.getY() + 32 < y + Sprite.SCALED_SIZE * (DirectionalExplosion.radius + 1)) {
                return true;
            }
        }
        return false;
    }
}
