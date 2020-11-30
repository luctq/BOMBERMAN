package uet.oop.bomberman.entities;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import uet.oop.bomberman.graphics.Sprite;

public abstract class Entity {
    public static boolean removed = true;
    //Tọa độ X tính từ góc trái trên trong Canvas
    protected int x;

    //Tọa độ Y tính từ góc trái trên trong Canvas
    protected int y;

    protected Image img;
<<<<<<< Updated upstream

    protected Sprite _sprite;
=======
    public Sprite _sprite;
>>>>>>> Stashed changes
    //Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
    public Entity(int xUnit, int yUnit, Image img) {
        this.x = xUnit * Sprite.SCALED_SIZE;
        this.y = yUnit * Sprite.SCALED_SIZE;
        this.img = img;
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
    }

    public abstract void update();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x * Sprite.SCALED_SIZE;
    }

    public void setY(int y) {
        this.y = y * Sprite.SCALED_SIZE;
    }

    public void setImg(Image img) {
        this.img = img;
    }
    public int getXTile(){
        return (int) (x + _sprite.SIZE/2) / Sprite.DEFAULT_SIZE;
    }

    public int getYTile(){
        return (int) (y + _sprite.SIZE/2) / Sprite.DEFAULT_SIZE;
    }
<<<<<<< Updated upstream
}
=======
}
>>>>>>> Stashed changes
