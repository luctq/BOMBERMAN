package uet.oop.bomberman.Map;

import uet.oop.bomberman.entities.Entity;

import java.io.FileNotFoundException;
import java.util.List;

public abstract class loadMap {
    String generalPath = "C:\\Users\\Dell\\Documents\\GitHub\\BOMBERMAN\\res\\levels\\";
    public abstract String[] loadFile(String path) throws FileNotFoundException;
    public abstract void creatMap(List<Entity> stillObjects, List<Entity> background, List<Entity> entities) throws FileNotFoundException;
}