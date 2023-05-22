package librarymanagementsystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class LibraryManagementSystem {

    public static void main(String[] args) {

        Splash s = new Splash();
        s.setVisible(true);

        LibraryManagement library = new LibraryManagement();

        try {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(40);
                s.jLabel4.setText(Integer.toString(i) + "%");
                s.jProgressBar1.setValue(i);

                if (i == 100) {
                    s.setVisible(false);

                    InputStream in;
                    try {
                        in = new FileInputStream(new File("src\\voice\\computer.wav"));

//                            AudioStream ad = new AudioStream(in);
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\voice\\computer.wav"));
//                        AudioPlayer.player.start(ad);
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);

                        // Play the audio clip
                        clip.start();
                    } catch (Exception e) {
                    }

                    library.setVisible(true);

                }
            }
        } catch (Exception e) {
        }

    }

}
