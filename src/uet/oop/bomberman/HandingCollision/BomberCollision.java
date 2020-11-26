package uet.oop.bomberman.HandingCollision;

import sun.java2d.pipe.SpanClipRenderer;
import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.entities.DirectionalExplosion;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.input.handingEvent;

public class BomberCollision {
    public static Bomber bomber = handingEvent.bomber;
    public static boolean withExplosion(int x, int y) {
        x = x - Sprite.SCALED_SIZE;
        int Ox = (handingEvent.bomber.getX() + 20/2) - (x + (2 * DirectionalExplosion.radius * Sprite.SCALED_SIZE + Sprite.SCALED_SIZE)/2);
        int Oy = (handingEvent.bomber.getY() + Sprite.SCALED_SIZE/2) - (y +  Sprite.SCALED_SIZE/2);
        if (Ox < 0) Ox = -Ox;
        if (Oy < 0) Oy = -Oy;
        if (Ox <= (20 + (2 * DirectionalExplosion.radius * Sprite.SCALED_SIZE + Sprite.SCALED_SIZE))/2 && Oy <= Sprite.SCALED_SIZE) return true;
        x = x + Sprite.SCALED_SIZE;
        y = y - Sprite.SCALED_SIZE;
        Ox = (handingEvent.bomber.getX() + 20/2) - (x + Sprite.SCALED_SIZE/2);
        Oy = (handingEvent.bomber.getY() + Sprite.SCALED_SIZE/2) - (y +  (2 * DirectionalExplosion.radius * Sprite.SCALED_SIZE + Sprite.SCALED_SIZE)/2);
        if (Ox < 0) Ox = -Ox;
        if (Oy < 0) Oy = -Oy;
        if (Ox <= (20 + Sprite.SCALED_SIZE)/2 && Oy <= (Sprite.SCALED_SIZE + (2 * DirectionalExplosion.radius * Sprite.SCALED_SIZE + Sprite.SCALED_SIZE))/2) return true;
        return false;
    }
}
