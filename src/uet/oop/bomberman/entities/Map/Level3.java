package uet.oop.bomberman.entities.Map;

import uet.oop.bomberman.entities.Brick;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.Grass;
import uet.oop.bomberman.entities.Wall;
import uet.oop.bomberman.graphics.Sprite;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Level3 extends loadMap{
    private static int width;
    String path = generalPath + "Level3.txt";
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
    public void creatMap(List<Entity> stillObjects) throws FileNotFoundException {
        this.map = loadFile(this.path);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Entity object;
                switch (map[j].charAt(i)) {
                    case '#': {
                        object = new Wall(i, j, Sprite.wall.getFxImage());
                        break;
                    }
                    case '*': {
                        object = new Brick(i, j, Sprite.brick.getFxImage());
                        break;
                    }
//                   case 'x': {
//                       object = new Portal(i, j, Sprite.portal.getFxImage());
//                       break;
//                   }
                    default: {
                        object = new Grass(i, j, Sprite.grass.getFxImage());
                        break;
                    }
                }
                stillObjects.add(object);
            }
        }
    }
}
