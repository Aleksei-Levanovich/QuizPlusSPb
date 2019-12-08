import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class TableWindow {
    public static void createGUI(Team[] team, int rounds,int last, int teams) throws IOException {
        JFrame frame = new JFrame("Таблица с результатами");
        JLabel backLabel;
        try {
            backLabel=new JLabel(new ImageIcon(ImageIO.read(new File("./images/background.png"))));
            frame.setContentPane(backLabel);
            backLabel.setLayout(new GridLayout(teams+1, last+2));
            backLabel.add(new JLabel(""));
            Color[] colors = new Color[7];
            colors[0]=Color.GREEN;
            colors[1]=Color.BLUE;
            colors[2]=Color.MAGENTA;
            colors[3]=Color.PINK;
            colors[4]=Color.CYAN;
            colors[5]=Color.RED;
            colors[6]=Color.BLACK;
            for (int i=0;i<last;i++){
                JLabel label = new JLabel("Р"+(i+1));
                label.setForeground(colors[i]);
                label.setFont(new Font("Serif",Font.PLAIN,30));
                backLabel.add(label);
            }
            JLabel sum = new JLabel("СУММА");
            sum.setFont(new Font("Serif",Font.PLAIN,30));
            backLabel.add(sum);
            Arrays.sort(team);
            for (int i=0;i<teams;i++){
                JLabel lab0 = new JLabel(team[i].getTeamName());
                lab0.setFont(new Font("Serif",Font.PLAIN,15));
                backLabel.add(lab0);
                for (int j=0; j<last; j++){
                    JLabel lab = new JLabel(String.valueOf(team[i].getPoints()[j]));
                    lab.setFont(new Font("Serif",Font.PLAIN,30));
                    backLabel.add(lab);
                }
                JLabel lab = new JLabel(String.valueOf(team[i].getSum()));
                lab.setFont(new Font("Serif",Font.PLAIN,30));
                backLabel.add(lab);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame.setSize(1920,1080);
        frame.pack();
        frame.setVisible(true);
    }
}
