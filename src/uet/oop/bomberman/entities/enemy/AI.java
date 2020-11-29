package uet.oop.bomberman.entities.enemy;

import java.util.Random;

public class AI {
    protected Random random = new Random();

    public int calculateDirection(){
        return random.nextInt(4);
    }
}
