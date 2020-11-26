package uet.oop.bomberman.HandingCollision;

import sun.java2d.pipe.SpanClipRenderer;
import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.entities.DirectionalExplosion;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.input.handingEvent;

public class BomberCollision {
    public static Bomber bomber = handingEvent.bomber;
    public static boolean withExplosion(int x, int y) {
        int Ox = (handingEvent.bomber.getX() + 20/2) - (x + Sprite.SCALED_SIZE/2);
        int Oy = (handingEvent.bomber.getY() + Sprite.SCALED_SIZE/2) - (y + Sprite.SCALED_SIZE/2);
        if (Ox < 0) Ox = -Ox;
        if (Oy < 0) Oy = -Oy;
        if (Ox <= (20 + Sprite.SCALED_SIZE) && Oy <= Sprite.SCALED_SIZE) return true;
        return false;
    }
}
