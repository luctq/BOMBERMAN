package uet.oop.bomberman.HandingCollision;

import uet.oop.bomberman.entities.Balloon;
import uet.oop.bomberman.entities.bomb.DirectionalExplosion;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.input.handingEvent;

public class EnemyCollision {
    public static boolean withExplosion(int x, int y, int BombX, int BombY) {
        BombX = BombX - DirectionalExplosion.radius * Sprite.SCALED_SIZE;
        int Ox = (x + (Sprite.SCALED_SIZE)/2) - (BombX - 1 + (2 * DirectionalExplosion.radius * Sprite.SCALED_SIZE + Sprite.SCALED_SIZE - 2)/2);
        int Oy = (y + Sprite.SCALED_SIZE/2) - 2 - (BombY - 1 +  (Sprite.SCALED_SIZE - 2)/2);
        if (Ox < 0) Ox = -Ox;
        if (Oy < 0) Oy = -Oy;
        if (Ox <= (Sprite.SCALED_SIZE+ (2 * DirectionalExplosion.radius * Sprite.SCALED_SIZE + Sprite.SCALED_SIZE - 2))/2 && Oy <= Sprite.SCALED_SIZE - 1) return true;
        BombX = BombX + DirectionalExplosion.radius * Sprite.SCALED_SIZE;
        BombY = BombY - DirectionalExplosion.radius * Sprite.SCALED_SIZE;
        Ox = (x + Sprite.SCALED_SIZE/2) - (BombX - 1 + (Sprite.SCALED_SIZE - 2)/2);
        Oy = (y + Sprite.SCALED_SIZE/2) - (BombY - 1 +  (2 * DirectionalExplosion.radius * Sprite.SCALED_SIZE + Sprite.SCALED_SIZE - 2)/2);
        if (Ox < 0) Ox = -Ox;
        if (Oy < 0) Oy = -Oy;
        if (Ox <= (Sprite.SCALED_SIZE - 1) && Oy <= (Sprite.SCALED_SIZE + (2 * DirectionalExplosion.radius * Sprite.SCALED_SIZE + Sprite.SCALED_SIZE - 2))/2) return true;
        return false;
//        BombX = BombX - Sprite.SCALED_SIZE;
//        int Ox = (x + Sprite.SCALED_SIZE/2) - (BombX + Sprite.SCALED_SIZE/2);
//        int Oy = (y + Sprite.SCALED_SIZE/2) - (BombY + Sprite.SCALED_SIZE/2);
//        if (Ox < 0) Ox = -Ox;
//        if (Oy < 0) Oy = -Oy;
//        if (Ox <= Sprite.SCALED_SIZE && Oy <= Sprite.SCALED_SIZE) return true;
//        return false;
//        BombX = BombX - DirectionalExplosion.radius * Sprite.SCALED_SIZE;
//        int Ox = (handingEvent.bomber.getX() + Sprite.SCALED_SIZE/2) - (BombX + (2 * DirectionalExplosion.radius * Sprite.SCALED_SIZE + Sprite.SCALED_SIZE)/2);
//        int Oy = (handingEvent.bomber.getY() + Sprite.SCALED_SIZE/2) - (BombY +  Sprite.SCALED_SIZE/2);
//        if (Ox < 0) Ox = -Ox;
//        if (Oy < 0) Oy = -Oy;
//        if (Ox <= (Sprite.SCALED_SIZE + (2 * DirectionalExplosion.radius * Sprite.SCALED_SIZE + Sprite.SCALED_SIZE))/2 && Oy <= Sprite.SCALED_SIZE) return true;
//        BombX = BombX + DirectionalExplosion.radius * Sprite.SCALED_SIZE;
//        BombY = BombY - DirectionalExplosion.radius * Sprite.SCALED_SIZE;
//        Ox = (handingEvent.bomber.getX() + Sprite.SCALED_SIZE/2) - (BombX + Sprite.SCALED_SIZE/2);
//        Oy = (handingEvent.bomber.getY() + Sprite.SCALED_SIZE/2) - (BombY +  (2 * DirectionalExplosion.radius * Sprite.SCALED_SIZE + Sprite.SCALED_SIZE)/2);
//        if (Ox < 0) Ox = -Ox;
//        if (Oy < 0) Oy = -Oy;
//        if (Ox <= Sprite.SCALED_SIZE && Oy <= (Sprite.SCALED_SIZE + (2 * DirectionalExplosion.radius * Sprite.SCALED_SIZE + Sprite.SCALED_SIZE))/2) return true;
//        return false;
    }
}
