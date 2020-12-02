package uet.oop.bomberman.entities.ai;

import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.entities.Enemy;

import java.util.Random;

public abstract class AI {
    protected Random random = new Random();
    public Bomber bomber;
    public Enemy enemy;
    //    public int calculateDirection(){
//        return random.nextInt(4);
//    }
    public AI(){

    }
    public abstract int calculateDirection();

}