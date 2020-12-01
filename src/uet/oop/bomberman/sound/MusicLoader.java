package uet.oop.bomberman.sound;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class MusicLoader {
    public static MusicLoader instance;

    private String soundFile ="res/music/sound.txt";
    private Hashtable<String, MediaPlayer> sounds;

    private MusicLoader(){
    }

    public static MusicLoader getInstance() {
        if (instance == null) {
            instance = new MusicLoader();
        }
        return instance;
    }
    public void LoadData() throws IOException {
        loadSounds();
    }

    public MediaPlayer getSound(String name) {
        return instance.sounds.get(name);
    }

    public void loadSounds() throws IOException {
        sounds = new Hashtable<>();

        FileReader fr = new FileReader(soundFile);
        BufferedReader br = new BufferedReader(fr);

        String line;

        if (br.readLine() == null) {
            System.out.println("No data :<");
            throw new IOException();

        } else {
            fr = new FileReader(soundFile);
            br = new BufferedReader(fr);

            while ((line = br.readLine()).equals(""));

            int n = Integer.parseInt(line);

            for (int i = 0; i < n; i++) {
                while ((line = br.readLine()).equals(""));

                String[] str = line.split(" ");
                String name = str[0];
                String path = str[1];

                Media media = new Media(new File(path).toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(media);

                instance.sounds.put(name, mediaPlayer);
            }
        }
        br.close();

    }
}
