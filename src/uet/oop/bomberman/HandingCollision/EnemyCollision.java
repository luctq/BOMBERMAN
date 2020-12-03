package uet.oop.bomberman.HandingCollision;

import uet.oop.bomberman.entities.bomb.DirectionalExplosion;
import uet.oop.bomberman.graphics.Sprite;

public class EnemyCollision {
    public static boolean withExplosion(int x, int y, int BombX, int BombY) {
        int width = 0;
        int height = 0;
        int temp1 = BombX / Sprite.SCALED_SIZE;
        int temp2 = BombY / Sprite.SCALED_SIZE;
        if (canMove.map[temp2].charAt(temp1 - 1) != '#' && canMove.map[temp2].charAt(temp1 + 1) != '#') {
            width = 2 * DirectionalExplosion.radius * Sprite.SCALED_SIZE + Sprite.SCALED_SIZE;
        } else if (canMove.map[temp2].charAt(temp1 - 1) != '#' && canMove.map[temp2].charAt(temp1 + 1) == '#') {
            width = DirectionalExplosion.radius * Sprite.SCALED_SIZE + Sprite.SCALED_SIZE;
        } else if (canMove.map[temp2].charAt(temp1 - 1) == '#' && canMove.map[temp2].charAt(temp1 + 1) != '#') {
            width = DirectionalExplosion.radius * Sprite.SCALED_SIZE + Sprite.SCALED_SIZE;
        } else if (canMove.map[temp2].charAt(temp1 - 1) == '#' && canMove.map[temp2].charAt(temp1 + 1) == '#') {
            width = Sprite.SCALED_SIZE;
        }
        if (canMove.map[temp2].charAt(temp1 - 1) != '#') BombX = BombX - DirectionalExplosion.radius * Sprite.SCALED_SIZE;
        int Ox = (x + 2 + (Sprite.SCALED_SIZE - 2)/2) - (BombX + (width - 8)/2);
        int Oy = (y + 2 + (Sprite.SCALED_SIZE - 2)/2) - (BombY + 2 +  (Sprite.SCALED_SIZE - 2)/2);
        if (Ox < 0) Ox = -Ox;
        if (Oy < 0) Oy = -Oy;
        if (Ox <= (Sprite.SCALED_SIZE - 4 + (width - 8))/2 && Oy <= Sprite.SCALED_SIZE - 4) return true;
        if (canMove.map[temp2 - 1].charAt(temp1) != '#' && canMove.map[temp2 - 1].charAt(temp1) != '#') {
            height = 2 * DirectionalExplosion.radius * Sprite.SCALED_SIZE + Sprite.SCALED_SIZE;
        } else if (canMove.map[temp2 - 1].charAt(temp1) != '#' && canMove.map[temp2 - 1].charAt(temp1) == '#') {
            height = DirectionalExplosion.radius * Sprite.SCALED_SIZE + Sprite.SCALED_SIZE;
        } else if (canMove.map[temp2 - 1].charAt(temp1) == '#' && canMove.map[temp2 - 1].charAt(temp1) != '#') {
            height = DirectionalExplosion.radius * Sprite.SCALED_SIZE + Sprite.SCALED_SIZE;
        } else if (canMove.map[temp2 - 1].charAt(temp1) == '#' && canMove.map[temp2 - 1].charAt(temp1) == '#') {
            height = Sprite.SCALED_SIZE;
        }
        if (canMove.map[temp2].charAt(temp1 - 1) != '#') BombX = BombX + DirectionalExplosion.radius * Sprite.SCALED_SIZE;
        if (canMove.map[temp2 - 1].charAt(temp1) != '#') BombY = BombY - DirectionalExplosion.radius * Sprite.SCALED_SIZE;
        Ox = (x + 2 + (Sprite.SCALED_SIZE - 2)/2) - (BombX + 2 + (Sprite.SCALED_SIZE - 2)/2);
        Oy = (y + 2 + (Sprite.SCALED_SIZE - 2)/2) - (BombY + 8 +  (height - 8)/2);
        if (Ox < 0) Ox = -Ox;
        if (Oy < 0) Oy = -Oy;
        if (Ox <= (Sprite.SCALED_SIZE - 4) && Oy <= (Sprite.SCALED_SIZE - 2 + (height - 16))/2) return true;
        return false;
    }
}
