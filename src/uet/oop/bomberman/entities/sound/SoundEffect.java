package uet.oop.bomberman.entities.sound;


import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class SoundEffect{
    //backsoundsrc\Sound\backSound.mp3
    public static Media mediaBackSound = new Media(new File("res\\sound\\backSound.mp3")
            .toURI().toString());
    public static MediaPlayer mediaPlayerbacksound = new MediaPlayer(mediaBackSound);

    //EatItem
    public static Media mediaEatItem = new Media(new File("res\\sound\\item.wav")
            .toURI().toString());
    public static MediaPlayer mediaPlayerEatItem = new MediaPlayer(mediaEatItem);

    //Die
    public static Media mediaCollisionEnemy = new Media(new File("res\\sound\\monster_die.wav")
            .toURI().toString());
    public static MediaPlayer mediaPlayerCollisionEnemy = new MediaPlayer(mediaCollisionEnemy);

    //BombExploded
    public static Media mediaBombExploded = new Media(new File("res\\sound\\bombExplode.wav")
            .toURI().toString());
    public static MediaPlayer mediaPlayerBombExploded = new MediaPlayer(mediaBombExploded);

    public static Media mediaPlaceBomb = new Media(new File("res\\sound\\newbomb.wav")
            .toURI().toString());
    public static MediaPlayer mediaPlayerPlaceBomb = new MediaPlayer(mediaPlaceBomb);

    public static Media mediaBomberDie = new Media(new File("res\\sound\\bomber_die.wav")
            .toURI().toString());
    public static MediaPlayer mediaPlayerDie = new MediaPlayer(mediaBomberDie);

    public static Media mediaPlayerWin = new Media(new File("res\\sound\\backSound.mp3")
            .toURI().toString());
    public static MediaPlayer mediaWin = new MediaPlayer(mediaPlayerWin);

    public static void sound(MediaPlayer mp) {
        mp.play();
        mp.seek(mp.getStartTime());
        //mp.stop();
    }

    public static void stop(MediaPlayer mp) {
        mp.stop();
        //mp.stop();
    }
}
