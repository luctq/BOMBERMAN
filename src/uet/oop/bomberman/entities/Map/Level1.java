package uet.oop.bomberman.entities.Map;

import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.entities.enemy.Balloon;
import uet.oop.bomberman.graphics.Sprite;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Level1 extends loadMap{
    private static int width;
    String path = generalPath + "Level1.txt";
    private static int height;
    private int level;
    public static String[] map;
    @Override
    public String[] loadFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner scan = new Scanner(file);
        this.level = scan.nextInt();
        this.height = scan.nextInt();
        this.width = scan.nextInt();
        scan.nextLine();
        String[] map = new String[height];
        for (int i = 0; i < height; i++) {
            map[i] = scan.nextLine();
        }
        return map;
    }

    @Override
    public void creatMap(List<Entity> stillObjects, List<Entity> background, List<Entity> entities) throws FileNotFoundException {
        this.map = loadFile(this.path);
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                switch (map[j].charAt(i)) {
                    case '#': {
                        Entity object = new Wall(i, j, Sprite.wall.getFxImage());
                        stillObjects.add(object);
                        break;
                    }
                    case '*': case 'f': case 's': case 'b': case 'x': {
                        Entity object = new Brick(i, j, Sprite.brick.getFxImage());
                        stillObjects.add(object);
                        break;
                    }
                    case '1': {
                        Entity object = new Grass(i, j, Sprite.grass.getFxImage());
                        stillObjects.add(object);
                        Entity balloon = new Balloon(i, j, Sprite.balloom_right1.getFxImage());
                        entities.add(balloon);
                        break;
                    }
                    case '2': {
                        Entity object = new Grass(i, j, Sprite.grass.getFxImage());
                        stillObjects.add(object);
                        Entity oneal = new Oneal(i, j, Sprite.oneal_right1.getFxImage());
                        entities.add(oneal);
                        break;
                    }
                    default: {
                        Entity object = new Grass(i, j, Sprite.grass.getFxImage());
                        stillObjects.add(object);
                        break;
                    }
                }
            }
        }
    }
}
