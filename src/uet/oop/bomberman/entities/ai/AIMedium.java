package uet.oop.bomberman.entities.ai;

import uet.oop.bomberman.HandingCollision.BombCollsion;
import uet.oop.bomberman.HandingCollision.canMove;
import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.entities.Enemy;
import uet.oop.bomberman.entities.Oneal;
import uet.oop.bomberman.input.handingEvent;

import static uet.oop.bomberman.entities.Bomber.speed;

public class AIMedium extends AI{
    public AIMedium(Enemy e){
        enemy = e;

    }
    @Override
    public int calculateDirection() {

        if(handingEvent.bomber == null)
            return random.nextInt(4);

        int vertical = random.nextInt(2);

        if(vertical == 1) {
            int v = calculateRowDirection();
            if(v != -1)
                return v;
            else
                return calculateColDirection();

        } else {
            int h = calculateColDirection();

            if(h != -1)
                return h;
            else
                return calculateRowDirection();
        }

    }

    protected int calculateColDirection() {
        if(handingEvent.bomber.getX() < enemy.getX())
            return 3;
        else if(handingEvent.bomber.getX() > enemy.getX())
            return 1;

        return -1;
    }

    protected int calculateRowDirection() {
        if(handingEvent.bomber.getY() < enemy.getY())
            return 0;
        else if(handingEvent.bomber.getY() > enemy.getY())
            return 2;
        return -1;
    }
}
