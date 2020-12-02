package uet.oop.bomberman.entities.ai;

import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.entities.Enemy;

public class AILow extends AI {
    public AILow(){
    }
    @Override
    public int calculateDirection() {
        return random.nextInt(4);

//        int vertical = random.nextInt(2);
//
//        if(vertical == 1) {
//            int v = calculateRowDirection();
//            if(v != -1)
//                return v;
//            else
//                return calculateColDirection();
//
//        } else {
//            int h = calculateColDirection();
//
//            if(h != -1)
//                return h;
//            else
//                return calculateRowDirection();
//        }

    }

}
