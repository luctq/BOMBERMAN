package uet.oop.bomberman.entities.ai;

import uet.oop.bomberman.HandingCollision.BombCollsion;
import uet.oop.bomberman.HandingCollision.canMove;
import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.entities.Enemy;
import uet.oop.bomberman.entities.Oneal;
import uet.oop.bomberman.input.handingEvent;

import static uet.oop.bomberman.entities.Bomber.speed;

public class AIMedium extends AI{
    public AIMedium(Bomber bomber, Enemy enemy){
        this.bomber = bomber;
        this.enemy = enemy;
    }
    @Override
    public int calculateDirection() {
        if (enemy == null) System.out.println("luc");
        return 1;
    }
}
