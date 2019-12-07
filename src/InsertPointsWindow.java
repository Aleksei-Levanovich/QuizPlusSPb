import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertPointsWindow {
    public static void createGUI(int teams, int rounds){
        JFrame frame = new JFrame("QuizPlusSPb");
        JPanel grid = new JPanel();
        GridLayout layout = new GridLayout(teams+2, rounds+1);
        grid.setLayout(layout);
        grid.add(new JLabel("Названия команд"));
        for (int i=0;i<rounds;i++){
            grid.add(new JLabel("           Р"+(i+1)));
        }
        JTextField textFields[] = new JTextField[teams*(rounds+1)];
        int current = 0;
        for (int i=0; i<teams; i++){
            for (int j=0; j<rounds+1; j++){
                JTextField titleText = new JTextField();
                titleText.setPreferredSize( new Dimension( 200, 24 ) );
                textFields[current] = titleText;
                grid.add(textFields[current]);
                current++;
            }
        }
        JButton button = new JButton("Сгенерировать таблицу");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Team team[] = new Team[teams];
                int last = rounds;
                for (int i=0; i<teams; i++){
                    for (int j=1; j<=rounds; j++){
                        String text = textFields[(rounds + 1) * i + j].getText();
                        if (text.length() == 0){
                            if (j-1<last) last=j-1;
                        }
                    }
                }
                for (int i = 0; i<teams; i++){
                    int start = i*(rounds+1);
                    String teamName = textFields[start].getText();
                    float sum=0;
                    float points[] = new float[last];
                    for (int j=1; j<=last; j++){
                            points[j-1]=Float.parseFloat(textFields[start+j].getText());
                            sum+=points[j-1];
                    }
                    Team teamCurrent = new Team();
                    teamCurrent.setRounds(rounds);
                    teamCurrent.setTeamName(teamName);
                    teamCurrent.setPoints(points);
                    teamCurrent.setSum(sum);
                    team[i]=teamCurrent;
                }
                TableWindow.createGUI(team,rounds,last,teams);
            }
        });
        grid.add(button);
        frame.getContentPane().add(grid);
        frame.setSize(1600,900);
        frame.setVisible(true);
    }
}
