package uet.oop.bomberman.HandingCollision;

import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.Map.Level;
import uet.oop.bomberman.entities.bomb.DirectionalExplosion;
import uet.oop.bomberman.entities.item.BombItem;
import uet.oop.bomberman.entities.item.FlameItem;
import uet.oop.bomberman.entities.item.SpeedItem;
import uet.oop.bomberman.graphics.Sprite;

import java.util.List;

public class canExplosion {
    static List<Entity> stillObjects = DirectionalExplosion.stillObjects;
    public static String[] map = Level.map;
    public static boolean explosionLeft(int posX, int posY) {
            int temp1 = posX / Sprite.SCALED_SIZE;
            int temp2 = posY / Sprite.SCALED_SIZE;
            if (map[temp2].charAt(temp1) != '#') return true;
            return false;
    }
    public static boolean explosionUp(int posX, int posY) {
        int temp1 = posX / Sprite.SCALED_SIZE;
        int temp2 = posY / Sprite.SCALED_SIZE;
        if (map[temp2].charAt(temp1) != '#') return true;
        return false;
    }
    public static boolean explosionRight(int posX, int posY) {
        int temp1 = posX / Sprite.SCALED_SIZE;
        int temp2 = posY / Sprite.SCALED_SIZE;
        if (map[temp2].charAt(temp1) != '#') return true;
        return false;
    }
    public static boolean explosionDown(int posX, int posY) {
        int temp1 = posX / Sprite.SCALED_SIZE;
        int temp2 = posY / Sprite.SCALED_SIZE;
        if (map[temp2].charAt(temp1) != '#') return true;
        return false;
    }

    public static void destroy(int posX, int posY) {
            int temp1 = posX / Sprite.SCALED_SIZE;
            int temp2 = posY / Sprite.SCALED_SIZE;
            switch (map[temp2].charAt(temp1)) {
                case '*': {
                    Brick brick = (Brick) stillObjects.get(temp1 + 31 * temp2);
                    map[temp2] = map[temp2].substring(0, temp1) + ' ' + map[temp2].substring(temp1+1);
                    brick.dead();
                    //stillObjects.set(temp1 + 31 * temp2, new Brick(temp1, temp2, Sprite.grass.getFxImage()));
                   return;
                }
                case 'f': {
                    map[temp2] = map[temp2].substring(0, temp1) + 'F' + map[temp2].substring(temp1 + 1);
                    Entity flameItem = new FlameItem(temp1, temp2, Sprite.powerup_flames.getFxImage());
                    stillObjects.set(temp1 + 31 * temp2, flameItem);
                    return;
                }
                case 'b': {
                    map[temp2] = map[temp2].substring(0, temp1) + 'B' + map[temp2].substring(temp1 + 1);
                    Entity bombItem = new BombItem(temp1, temp2, Sprite.powerup_bombs.getFxImage());
                    stillObjects.set(temp1 + 31 * temp2, bombItem);
                    return;
                }
                case 's': {
                    map[temp2] = map[temp2].substring(0, temp1) + 'S' + map[temp2].substring(temp1 + 1);
                    Entity speedItem = new SpeedItem(temp1, temp2, Sprite.powerup_speed.getFxImage());
                    stillObjects.set(temp1 + 31 * temp2, speedItem);
                    return;
                }
                case 'x': {
                    map[temp2] = map[temp2].substring(0, temp1) + 'x' + map[temp2].substring(temp1 + 1);
                    Entity portal = new Portal(temp1, temp2, Sprite.portal.getFxImage());
                    stillObjects.set(temp1 + 31 * temp2, portal);
                    return;
                }
        }
//        if (map[temp2].charAt(temp1) == '#') {
//            return false;
//        }
//        else if (map[temp2].charAt(temp1) == '*') {
//            map[temp2] = map[temp2].substring(0, temp1) + ' ' + map[temp2].substring(temp1+1);
//            Brick brick = (Brick) stillObjects.get(temp1 + 31 * temp2);
//            brick.change();
//            Entity grass = new Grass(temp1, temp2, Sprite.grass.getFxImage());
//            stillObjects.set(temp1 + 31 * temp2, grass);
//        }
//        if (map[temp2].charAt(temp1) == 'f') {
//            System.out.println(1);
//            map[temp2] = map[temp2].substring(0, temp1) + 'F' + map[temp2].substring(temp1+1);
//            Entity flameItem = new FlameItem(temp1, temp2, Sprite.powerup_flames.getFxImage());
//            stillObjects.set(temp1 + 31 * temp2, flameItem);
//        }
//        if (map[temp2].charAt(temp1) == 'b') {
//            map[temp2] = map[temp2].substring(0, temp1) + 'B' + map[temp2].substring(temp1+1);
//            Entity bombItem = new BombItem(temp1, temp2, Sprite.powerup_bombs.getFxImage());
//            stillObjects.set(temp1 + 31 * temp2, bombItem);
//        }
//        if (map[temp2].charAt(temp1) == 's') {
//            map[temp2] = map[temp2].substring(0, temp1) + 'S' + map[temp2].substring(temp1+1);
//            Entity speedItem = new SpeedItem(temp1, temp2, Sprite.powerup_speed.getFxImage());
//            stillObjects.set(temp1 + 31 * temp2, speedItem);
//        }
//        if (map[temp2].charAt(temp1) == 'x') {
//            System.out.println(1);
//           //map[temp2] = map[temp2].substring(0, temp1) + 'x' + map[temp2].substring(temp1+1);
//            Entity portal = new Portal(temp1, temp2, Sprite.portal.getFxImage());
//            stillObjects.set(temp1 + 31 * temp2, portal);
//        }
//        return true;
//    }
    }
}
