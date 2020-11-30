package uet.oop.bomberman.HandingCollision;

import uet.oop.bomberman.graphics.Sprite;

public class BombCollsion {
    public static boolean withEntities(int entityX, int entityY, int BombX, int BombY) {
        int Ox = (entityX + Sprite.SCALED_SIZE/2) - (BombX * 32 + Sprite.SCALED_SIZE/2);
        int Oy = (entityY + Sprite.SCALED_SIZE/2) - (BombY * 32 + Sprite.SCALED_SIZE/2);
        if (Ox < 0) Ox = -Ox;
        if (Oy < 0) Oy = -Oy;
        if (Ox <= Sprite.SCALED_SIZE && Oy <= Sprite.SCALED_SIZE) return true;
        return false;
    }
}
