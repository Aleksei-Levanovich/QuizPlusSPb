import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class InsertPointsWindow {
    public static void createGUI(int teams, int rounds){
        JFrame frame = new JFrame("QuizPlusSPb");
        JPanel grid = new JPanel();
        GridLayout layout = new GridLayout(teams+1, rounds+1);
        grid.setLayout(layout);
        grid.add(new JLabel("Названия команд"));
        for (int i=1;i<=rounds;i++){
            grid.add(new JLabel("           Р"+i));
        }
        JTextField textFields[] = new JTextField[teams*(rounds+1)];
        int current = 0;
        for (int i=0; i<teams; i++){
            for (int j=0; j<rounds+1; j++){
                String text = String.valueOf(j);
                JTextField titleText = new JTextField(text,5);
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
                try {
                    TableWindow.createGUI(team,rounds,last,teams);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(button);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(grid);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
