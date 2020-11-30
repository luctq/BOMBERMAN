<<<<<<< Updated upstream
package uet.oop.bomberman.entities.enemy;

=======

package uet.oop.bomberman.entities.enemy;

import uet.oop.bomberman.BombermanGame;
>>>>>>> Stashed changes
import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.entities.Enemy;

import java.util.Random;

<<<<<<< Updated upstream
public class AI {
    protected Random random = new Random();
    public Bomber bomber;
    public Enemy enemy;
//    public int calculateDirection(){
//        return random.nextInt(4);
//    }
    public AI(){

    }
    public AI(Bomber bomber, Enemy enemy){
        this.bomber = bomber;
        this.enemy = enemy;
    }
    public int calculateDirection() {

        if(bomber == null)
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
        if(bomber.getXTile() < enemy.getXTile())
            return 3;
        else if(bomber.getXTile() > enemy.getXTile())
            return 1;

        return -1;
    }

    protected int calculateRowDirection() {
        if(bomber.getYTile() < enemy.getYTile())
            return 0;
        else if(bomber.getYTile() > enemy.getYTile())
            return 2;
        return -1;
    }

}
=======
    public class AI {
        protected Random random = new Random();
        public Bomber bomber;
        public Enemy enemy;
        //    public int calculateDirection(){
//        return random.nextInt(4);
//    }
        public AI(){

        }
        public AI(Bomber bomber, Enemy enemy){
            this.bomber = bomber;
            this.enemy = enemy;
        }
        public int calculateDirection() {

            if(bomber == null)
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
            if(bomber.getXTile() < enemy.getXTile())
                return 3;
            else if(bomber.getXTile() > enemy.getXTile())
                return 1;

            return -1;
        }

        protected int calculateRowDirection() {
            if(bomber.getYTile() < enemy.getYTile())
                return 0;
            else if(bomber.getYTile() > enemy.getYTile())
                return 2;
            return -1;
        }

    }

>>>>>>> Stashed changes
