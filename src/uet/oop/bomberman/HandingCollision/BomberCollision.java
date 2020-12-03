package uet.oop.bomberman.HandingCollision;

import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.entities.bomb.DirectionalExplosion;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.input.handingEvent;

public class BomberCollision {
    public static Bomber bomber = handingEvent.bomber;
    public static boolean withExplosion(int x, int y) {
        int width = 0;
        int height = 0;
        int temp1 = x / Sprite.SCALED_SIZE;
        int temp2 = y / Sprite.SCALED_SIZE;
        if (canMove.map[temp2].charAt(temp1 - 1) != '#' && canMove.map[temp2].charAt(temp1 + 1) != '#') {
            width = 2 * DirectionalExplosion.radius * Sprite.SCALED_SIZE + Sprite.SCALED_SIZE;
        } else if (canMove.map[temp2].charAt(temp1 - 1) != '#' && canMove.map[temp2].charAt(temp1 + 1) == '#') {
            width = DirectionalExplosion.radius * Sprite.SCALED_SIZE + Sprite.SCALED_SIZE;
        } else if (canMove.map[temp2].charAt(temp1 - 1) == '#' && canMove.map[temp2].charAt(temp1 + 1) != '#') {
            width = DirectionalExplosion.radius * Sprite.SCALED_SIZE + Sprite.SCALED_SIZE;
        } else if (canMove.map[temp2].charAt(temp1 - 1) == '#' && canMove.map[temp2].charAt(temp1 + 1) == '#') {
            width = Sprite.SCALED_SIZE;
        }
        if (canMove.map[temp2].charAt(temp1 - 1) != '#') x = x - DirectionalExplosion.radius * Sprite.SCALED_SIZE;
        int Ox = (handingEvent.bomber.getX() + 20/2) - (x + width/2);
        int Oy = (handingEvent.bomber.getY() + 2 + (Sprite.SCALED_SIZE - 4)/2) - (y +  Sprite.SCALED_SIZE/2);
        if (Ox < 0) Ox = -Ox;
        if (Oy < 0) Oy = -Oy;
        if (Ox <= (20 + width)/2 && Oy <= (Sprite.SCALED_SIZE - 2)) return true;
        if (canMove.map[temp2 - 1].charAt(temp1) != '#' && canMove.map[temp2 - 1].charAt(temp1) != '#') {
            height = 2 * DirectionalExplosion.radius * Sprite.SCALED_SIZE + Sprite.SCALED_SIZE;
        } else if (canMove.map[temp2 - 1].charAt(temp1) != '#' && canMove.map[temp2 - 1].charAt(temp1) == '#') {
            height = DirectionalExplosion.radius * Sprite.SCALED_SIZE + Sprite.SCALED_SIZE;
        } else if (canMove.map[temp2 - 1].charAt(temp1) == '#' && canMove.map[temp2 - 1].charAt(temp1) != '#') {
            height = DirectionalExplosion.radius * Sprite.SCALED_SIZE + Sprite.SCALED_SIZE;
        } else if (canMove.map[temp2 - 1].charAt(temp1) == '#' && canMove.map[temp2 - 1].charAt(temp1) == '#') {
            height = Sprite.SCALED_SIZE;
        }
        if (canMove.map[temp2].charAt(temp1 - 1) != '#') x = x + DirectionalExplosion.radius * Sprite.SCALED_SIZE;
        if (canMove.map[temp2 - 1].charAt(temp1) != '#') y = y - DirectionalExplosion.radius * Sprite.SCALED_SIZE;
        Ox = (handingEvent.bomber.getX() + 20/2) - (x + Sprite.SCALED_SIZE/2);
        Oy = (handingEvent.bomber.getY() + 2 + (Sprite.SCALED_SIZE - 4)/2) - (y +  height/2);
        if (Ox < 0) Ox = -Ox;
        if (Oy < 0) Oy = -Oy;
        if (Ox <= (20 + Sprite.SCALED_SIZE)/2 && Oy <= (Sprite.SCALED_SIZE - 4 + height)/2) return true;
        return false;
    }
}
