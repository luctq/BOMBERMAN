package uet.oop.bomberman.entities.ai;

import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.entities.enemy.Enemy;

public class AIMedium extends AI{
    public AIMedium(Bomber bomber, Enemy enemy){
        this.bomber = bomber;
        this.enemy = enemy;
    }

    @Override
    public int calculateDirection() {
//        if (bomber == null) {
//            return random.nextInt(4);
//        }
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
        if(bomber.getX() < enemy.getX())
            return 3;
        else if(bomber.getX() > enemy.getX())
            return 1;

        return -1;
    }

    protected int calculateRowDirection() {
        if(bomber.getY() < enemy.getY())
            return 0;
        else if(bomber.getY() > enemy.getY())
            return 2;
        return -1;
    }
}
