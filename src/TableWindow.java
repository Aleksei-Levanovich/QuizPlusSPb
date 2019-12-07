import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class TableWindow {
    public static void createGUI(Team[] team, int rounds,int last, int teams){
        JFrame frame = new JFrame("Таблица с результатами");
        JPanel grid = new JPanel();
        GridLayout layout = new GridLayout(teams+1, last+2);
        grid.setLayout(layout);
        grid.add(new JLabel("Названия команд"));
        for (int i=0;i<last;i++){
            grid.add(new JLabel("Р"+(i+1)));
        }
        grid.add(new JLabel("Сумма"));
        Arrays.sort(team);
        for (int i=0;i<teams;i++){
            grid.add(new JLabel(team[i].getTeamName()));
            for (int j=0; j<last; j++){
                grid.add(new JLabel(String.valueOf(team[i].getPoints()[j])));
            }
            grid.add(new JLabel(String.valueOf(team[i].getSum())));
        }
        frame.getContentPane().add(grid);
        frame.pack();
        frame.setVisible(true);
    }
}
