import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertDataWindow {
    public static void createGUI()
    {
        JFrame frame = new JFrame("QuizPlusSPb");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label0 = new JLabel("Введите количество команд:");
        JTextField textField0 = new JTextField(4);
        JLabel label1 = new JLabel("Введите количество раундов:");
        JTextField textField1 = new JTextField(4);
        JButton button = new JButton("Далее");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int teams = Integer.parseInt(textField0.getText());
                int rounds = Integer.parseInt(textField1.getText());
                InsertPointsWindow.createGUI(teams, rounds);
            }
        });
        JPanel grid = new JPanel();
        GridLayout layout = new GridLayout(3, 2);
        grid.setLayout(layout);
        grid.add(label0);
        grid.add(textField0);
        grid.add(label1);
        grid.add(textField1);
        grid.add(button);
//        frame.getContentPane().add(label);

        frame.getContentPane().add(grid);
        frame.pack();
        frame.setSize(400,300);

        frame.setResizable(false);

        frame.setVisible(true);
    }
}
