package uet.oop.bomberman.HandingCollision;

import uet.oop.bomberman.entities.Map.Level1;
import uet.oop.bomberman.graphics.Sprite;

public class canMove {
    public static String[] map = Level1.map;
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
        temp2 = posY + 29;
        temp2 = temp2 / Sprite.SCALED_SIZE;
        if (map[temp2].charAt(temp1) == '#'|| map[temp2].charAt(temp1) == '*') return false;
        return true;
    }
    public static boolean canMoveRight(int posX, int posY) {
        int temp1 = posX + 22;
        int temp2 = posY;
        if (temp1 > posXBomb && posXBomb > 0 && temp1 < posXBomb + Sprite.SCALED_SIZE) return false;
        //posY = posY + _sprite.get_realHeight();
        temp1 = temp1 / Sprite.SCALED_SIZE;
        temp2 = temp2 / Sprite.SCALED_SIZE;
        if (map[temp2].charAt(temp1) == '#'|| map[temp2].charAt(temp1) == '*') return false;
        temp2 = posY + 29;
        temp2 = temp2 / Sprite.SCALED_SIZE;
        if (map[temp2].charAt(temp1) == '#'|| map[temp2].charAt(temp1) == '*') return false;
        return true;
    }
    public static boolean canMoveUp(int posX, int posY) {
        int temp1 = posX;
        int temp2 = posY;
        if (temp2 < posYBomb + Sprite.SCALED_SIZE && temp2 > posYBomb) return false;
        temp1 = temp1 / Sprite.SCALED_SIZE;
        temp2 = temp2 / Sprite.SCALED_SIZE;
        if (map[temp2].charAt(temp1) == '#' || map[temp2].charAt(temp1) == '*') return false;
        temp1 = posX + 22;
        temp1 = temp1 / Sprite.SCALED_SIZE;
        if (map[temp2].charAt(temp1) == '#' || map[temp2].charAt(temp1) == '*') return false;

        return true;
    }
    public static boolean canMoveDown(int posX, int posY) {
        int temp1 = posX;
        int temp2 = posY + 30;
        if (temp2 > posYBomb && posYBomb > 0 && temp2 < posYBomb + 32) return false;
        temp1 = temp1 / Sprite.SCALED_SIZE;
        temp2 = temp2 / Sprite.SCALED_SIZE;
        if (map[temp2].charAt(temp1) == '#' || map[temp2].charAt(temp1) == '*') return false;
        temp1 = posX + 20;
        temp1 = temp1 / Sprite.SCALED_SIZE;
        if (map[temp2].charAt(temp1) == '#' || map[temp2].charAt(temp1) == '*') return false;

        return true;
    }
}
