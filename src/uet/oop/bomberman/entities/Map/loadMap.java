package uet.oop.bomberman.entities.Map;

import uet.oop.bomberman.entities.Entity;

import java.io.FileNotFoundException;
import java.util.List;

public abstract class loadMap {
    String generalPath = "D:\\bomberman-starter\\res\\levels\\";
    public abstract String[] loadFile(String path) throws FileNotFoundException;
    public abstract void creatMap(List<Entity> stillObjects) throws FileNotFoundException;
}
