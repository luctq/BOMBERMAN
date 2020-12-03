package uet.oop.bomberman.HandingCollision;

import uet.oop.bomberman.Game;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.Map.Level;
import uet.oop.bomberman.entities.bomb.Bomb;
import uet.oop.bomberman.entities.bomb.DirectionalExplosion;
import uet.oop.bomberman.entities.sound.SoundEffect;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.input.handingEvent;

import java.util.List;

public class canMove {
    public static List<Entity> stillObjects = DirectionalExplosion.stillObjects;
    public static String[] map = Level.map;
    public static int posXBomb = -1;
    public static int posYBomb = -1;

    public static boolean canMoveLeft(int posX, int posY) {
        int temp1 = posX;
        int temp2 = posY;
        //posY = posY + _sprite.get_realHeight();
        temp1 = temp1 / Sprite.SCALED_SIZE;
        temp2 = temp2 / Sprite.SCALED_SIZE;
        if (map[temp2].charAt(temp1) == '#'|| map[temp2].charAt(temp1) == '*') return false;
        if (map[temp2].charAt(temp1) == 'f'|| map[temp2].charAt(temp1) == 'b'
                || map[temp2].charAt(temp1) == 's' || map[temp2].charAt(temp1) == 'a') {
            return false;
        }
        if (map[temp2].charAt(temp1) == 'x') {
            if (handingEvent.entities.size() > 1) {
                return false;
            } else if (handingEvent.entities.size() == 1) {
                Game.winLevel = true;
                return true;
            }
        }
        temp2 = posY + 29;
        temp2 = temp2 / Sprite.SCALED_SIZE;
        return chooseItem(temp1, temp2);
    }
    public static boolean canMoveRight(int posX, int posY) {
        int temp1 = posX + 22;
        int temp2 = posY;
        //posY = posY + _sprite.get_realHeight();
        temp1 = temp1 / Sprite.SCALED_SIZE;
        temp2 = temp2 / Sprite.SCALED_SIZE;
        if (map[temp2].charAt(temp1) == '#'|| map[temp2].charAt(temp1) == '*') return false;
        if (map[temp2].charAt(temp1) == 'f'|| map[temp2].charAt(temp1) == 'b'
                || map[temp2].charAt(temp1) == 's' || map[temp2].charAt(temp1) == 'a') {
            return false;
        }
        if (map[temp2].charAt(temp1) == 'x') {
            if (handingEvent.entities.size() > 1) {
                return false;
            } else if (handingEvent.entities.size() == 1) {
                Game.winLevel = true;
                return true;
            }
        }
        temp2 = posY + 29;
        temp2 = temp2 / Sprite.SCALED_SIZE;
        return chooseItem(temp1, temp2);
    }
    public static boolean canMoveUp(int posX, int posY) {
        int temp1 = posX;
        int temp2 = posY;
        temp1 = temp1 / Sprite.SCALED_SIZE;
        temp2 = temp2 / Sprite.SCALED_SIZE;
        if (map[temp2].charAt(temp1) == '#' || map[temp2].charAt(temp1) == '*') return false;
        if (map[temp2].charAt(temp1) == 'f'|| map[temp2].charAt(temp1) == 'b' || map[temp2].charAt(temp1) == 's' || map[temp2].charAt(temp1) == 'a') {
            return false;
        }
        if (map[temp2].charAt(temp1) == 'x') {
            if (handingEvent.entities.size() > 1) {
                return false;
            } else if (handingEvent.entities.size() == 1) {
                Game.winLevel = true;
                return true;
            }
        }
        temp1 = posX + 22;
        temp1 = temp1 / Sprite.SCALED_SIZE;
        return chooseItem(temp1, temp2);
    }
    public static boolean canMoveDown(int posX, int posY) {
        int temp1 = posX;
        int temp2 = posY + 30;
        temp1 = temp1 / Sprite.SCALED_SIZE;
        temp2 = temp2 / Sprite.SCALED_SIZE;
        if (map[temp2].charAt(temp1) == '#' || map[temp2].charAt(temp1) == '*') return false;
        if (map[temp2].charAt(temp1) == 'f'|| map[temp2].charAt(temp1) == 'b'
                || map[temp2].charAt(temp1) == 's' || map[temp2].charAt(temp1) == 'a') {
            return false;
        }
        if (map[temp2].charAt(temp1) == 'x') {
            if (handingEvent.entities.size() > 1) {
                return false;
            } else if (handingEvent.entities.size() == 1) {
                Game.winLevel = true;
                return true;
            }
        }
        temp1 = posX + 20;
        temp1 = temp1 / Sprite.SCALED_SIZE;
        return chooseItem(temp1, temp2);
    }
    public static boolean chooseItem(int temp1, int temp2) {
        switch (map[temp2].charAt(temp1)) {
            case '#': case '*': case 'f': case 's': case 'b': case 'a': {
                return false;
            }
            case 'x': {
                if (map[temp2].charAt(temp1) == 'x') {
                    if (handingEvent.entities.size() > 1) {
                        return false;
                    } else if (handingEvent.entities.size() == 1) {
                        Game.winLevel = true;
                        return true;
                    }
                }
            }
            case 'F': {
                map[temp2] = map[temp2].substring(0, temp1) + ' ' + map[temp2].substring(temp1 + 1);
                SoundEffect.sound(SoundEffect.mediaPlayerEatItem);
                Entity grass = new Grass(temp1, temp2, Sprite.grass.getFxImage());
                stillObjects.set(temp1 + temp2 * 31, grass);
                DirectionalExplosion.radius = 2;
                return true;
            }
            case 'S': {
                map[temp2] = map[temp2].substring(0, temp1) + ' ' + map[temp2].substring(temp1 + 1);
                SoundEffect.sound(SoundEffect.mediaPlayerEatItem);
                Entity grass = new Grass(temp1, temp2, Sprite.grass.getFxImage());
                stillObjects.set(temp1 + temp2 * 31, grass);
                Bomber.speed = 3;
                return true;
            }
            case 'B': {
                map[temp2] = map[temp2].substring(0, temp1) + ' ' + map[temp2].substring(temp1 + 1);
                SoundEffect.sound(SoundEffect.mediaPlayerEatItem);
                Entity grass = new Grass(temp1, temp2, Sprite.grass.getFxImage());
                stillObjects.set(temp1 + temp2 * 31, grass);
                Bomb.numberOfBomb = 2;
                return true;
            }
            case 'A': {
                map[temp2] = map[temp2].substring(0, temp1) + ' ' + map[temp2].substring(temp1 + 1);
                SoundEffect.sound(SoundEffect.mediaPlayerEatItem);
                Entity grass = new Grass(temp1, temp2, Sprite.grass.getFxImage());
                stillObjects.set(temp1 + temp2 * 31, grass);
                Game.LIVES++;
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
