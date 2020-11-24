package uet.oop.bomberman.entities.Map;

import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.graphics.Sprite;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Level5 extends loadMap{
    private static int width;
    String path = generalPath + "Level5.txt";
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
                Entity grass = new Grass(i, j, Sprite.grass.getFxImage());
                background.add(grass);
                Entity object;
                switch (map[j].charAt(i)) {
                    case '#': {
                        object = new Wall(i, j, Sprite.wall.getFxImage());
                        break;
                    }
                    case '*': case 'f': case 's': case 'b': case 'x': {
                        object = new Brick(i, j, Sprite.brick.getFxImage());
                        break;
                    }
                    case '1': {
                        Entity balloon = new Balloon(i, j, Sprite.balloom_right1.getFxImage());
                        entities.add(balloon);
                    }
                    case '2': {
                        Entity oneal = new Oneal(i, j, Sprite.oneal_right1.getFxImage());
                        entities.add(oneal);
                    }
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
