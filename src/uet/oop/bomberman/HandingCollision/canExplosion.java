package uet.oop.bomberman.HandingCollision;

import uet.oop.bomberman.entities.DirectionalExplosion;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.Grass;
import uet.oop.bomberman.entities.Map.Level1;
import uet.oop.bomberman.entities.Wall;
import uet.oop.bomberman.graphics.Sprite;

import java.util.List;

public class canExplosion {
    static List<Entity> stillObjects = DirectionalExplosion.stillObjects;
    public static String[] map = Level1.map;
    public static boolean explosionLeft(int posX, int posY) {
        int temp1 = posX / Sprite.SCALED_SIZE;
        int temp2 = posY / Sprite.SCALED_SIZE;
        if (map[temp2].charAt(temp1) == '#') {
            return false;
        }
        return true;
    }
    public static boolean explosionUp(int posX, int posY) {
        int temp1 = posX / Sprite.SCALED_SIZE;
        int temp2 = posY / Sprite.SCALED_SIZE;
        if (map[temp2].charAt(temp1) == '#') {
            return false;
        }
        return true;
    }
    public static boolean explosionRight(int posX, int posY) {
        int temp1 = posX / Sprite.SCALED_SIZE;
        int temp2 = posY / Sprite.SCALED_SIZE;
        if (map[temp2].charAt(temp1) == '#') {
            return false;
        }
        return true;
    }
    public static boolean explosionDown(int posX, int posY) {
        int temp1 = posX / Sprite.SCALED_SIZE;
        int temp2 = posY / Sprite.SCALED_SIZE;
        if (map[temp2].charAt(temp1) == '#') {
            return false;
        }
        return true;
    }
}
