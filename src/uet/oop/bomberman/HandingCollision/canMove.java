package uet.oop.bomberman.HandingCollision;

import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.Map.Level;
import uet.oop.bomberman.graphics.Sprite;

import java.util.List;

public class canMove {
    public static List<Entity> stillObjects = DirectionalExplosion.stillObjects;
    public static String[] map = Level.map;
    public static int posXBomb = -1;
    public static int posYBomb = -1;

    public static boolean canMoveLeft(int posX, int posY) {
        int temp1 = posX;
        int temp2 = posY;
        if (temp1 < posXBomb + Sprite.SCALED_SIZE && temp1 > posXBomb) return false;
        //posY = posY + _sprite.get_realHeight();
        temp1 = temp1 / Sprite.SCALED_SIZE;
        temp2 = temp2 / Sprite.SCALED_SIZE;
        if (map[temp2].charAt(temp1) == '#'|| map[temp2].charAt(temp1) == '*') return false;
        if (map[temp2].charAt(temp1) == 'f'|| map[temp2].charAt(temp1) == 'b'
                || map[temp2].charAt(temp1) == 's' || map[temp2].charAt(temp1) == 'x') {
            return false;
        }
        temp2 = posY + 29;
        temp2 = temp2 / Sprite.SCALED_SIZE;
        return chooseItem(temp1, temp2);
    }
    public static boolean canMoveRight(int posX, int posY) {
        int temp1 = posX + 22;
        int temp2 = posY;
        if (temp1 > posXBomb && posXBomb > 0 && temp1 < posXBomb + Sprite.SCALED_SIZE) return false;
        //posY = posY + _sprite.get_realHeight();
        temp1 = temp1 / Sprite.SCALED_SIZE;
        temp2 = temp2 / Sprite.SCALED_SIZE;
        if (map[temp2].charAt(temp1) == '#'|| map[temp2].charAt(temp1) == '*') return false;
        if (map[temp2].charAt(temp1) == 'f'|| map[temp2].charAt(temp1) == 'b'
                || map[temp2].charAt(temp1) == 's' || map[temp2].charAt(temp1) == 'x') {
            return false;
        }
        temp2 = posY + 29;
        temp2 = temp2 / Sprite.SCALED_SIZE;
        return chooseItem(temp1, temp2);
    }
    public static boolean canMoveUp(int posX, int posY) {
        int temp1 = posX;
        int temp2 = posY;
        if (temp2 < posYBomb + Sprite.SCALED_SIZE && temp2 > posYBomb) return false;
        temp1 = temp1 / Sprite.SCALED_SIZE;
        temp2 = temp2 / Sprite.SCALED_SIZE;
        if (map[temp2].charAt(temp1) == '#' || map[temp2].charAt(temp1) == '*') return false;
        if (map[temp2].charAt(temp1) == 'f'|| map[temp2].charAt(temp1) == 'b'
                || map[temp2].charAt(temp1) == 's' || map[temp2].charAt(temp1) == 'x') {
            return false;
        }
        temp1 = posX + 22;
        temp1 = temp1 / Sprite.SCALED_SIZE;
        return chooseItem(temp1, temp2);
    }
    public static boolean canMoveDown(int posX, int posY) {
        int temp1 = posX;
        int temp2 = posY + 30;
        if (temp2 > posYBomb && posYBomb > 0 && temp2 < posYBomb + 32) return false;
        temp1 = temp1 / Sprite.SCALED_SIZE;
        temp2 = temp2 / Sprite.SCALED_SIZE;
        switch (map[temp2].charAt(temp1)) {
            case '#': case '*': case 'f': case 's': case 'b': case 'x':{
                return false;
            }
            case 'F': {
                Entity grass = new Grass(temp1, temp2, Sprite.grass.getFxImage());
                stillObjects.set(temp1 + temp2 * 31, grass);
                DirectionalExplosion.radius = 2;
                break;
            }
            case 'S': {
                Entity grass = new Grass(temp1, temp2, Sprite.grass.getFxImage());
                stillObjects.set(temp1 + temp2 * 31, grass);
                Bomber.speed = 4;
                break;
            }
            case 'B': {
                Entity grass = new Grass(temp1, temp2, Sprite.grass.getFxImage());
                stillObjects.set(temp1 + temp2 * 31, grass);
                Bomb.numberOfBomb = 2;
                break;
            }
        }
        temp1 = posX + 20;
        temp1 = temp1 / Sprite.SCALED_SIZE;
        return chooseItem(temp1, temp2);
    }
    public static boolean chooseItem(int temp1, int temp2) {
        switch (map[temp2].charAt(temp1)) {
            case '#': case '*': case 'f': case 's': case 'b': case 'x':{
                return false;
            }
            case 'F': {
                Entity grass = new Grass(temp1, temp2, Sprite.grass.getFxImage());
                stillObjects.set(temp1 + temp2 * 31, grass);
                DirectionalExplosion.radius = 2;
                return true;
            }
            case 'S': {
                Entity grass = new Grass(temp1, temp2, Sprite.grass.getFxImage());
                stillObjects.set(temp1 + temp2 * 31, grass);
                Bomber.speed = 4;
                return true;
            }
            case 'B': {
                Entity grass = new Grass(temp1, temp2, Sprite.grass.getFxImage());
                stillObjects.set(temp1 + temp2 * 31, grass);
                Bomb.numberOfBomb = 2;
                return true;
            }
        }
        return true;
    }
    public boolean testCanMove(int temp1, int temp2) {
        switch (map[temp2].charAt(temp1)) {
            case '#': case '*': case 'f': case 's': case 'b': case 'x':{
                return false;
            }
            case 'F': {
                Entity grass = new Grass(temp1, temp2, Sprite.grass.getFxImage());
                stillObjects.set(temp1 + temp2 * 31, grass);
                DirectionalExplosion.radius = 2;
            }
            case 'S': {
                Entity grass = new Grass(temp1, temp2, Sprite.grass.getFxImage());
                stillObjects.set(temp1 + temp2 * 31, grass);
                Bomber.speed = 4;
            }
            case 'B': {
                Entity grass = new Grass(temp1, temp2, Sprite.grass.getFxImage());
                stillObjects.set(temp1 + temp2 * 31, grass);
                Bomb.numberOfBomb = 2;
            }
        }
        return true;
    }
}
