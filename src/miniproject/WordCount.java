package miniproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.System.exit;
import javax.swing.*;

public class WordCount extends JFrame implements ActionListener {

    JLabel l1, l2;
    JButton b1, b2;
    JTextArea area;

    WordCount() {
        setTitle("Word Counter");
        JFrame f = new JFrame();
        l1 = new JLabel();
        l1.setBounds(50, 25, 100, 30);
        add(l1);

        l2 = new JLabel();
        l2.setBounds(160, 25, 100, 30);
        add(l2);

        area = new JTextArea();
        area.setBounds(100, 75, 250, 200);
        add(area);

        b1 = new JButton("Count Words");
        b1.setBounds(165, 290, 120, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Exit");
        b2.setBounds(175, 340, 100, 40);
        b2.addActionListener(this);
        add(b2);

        setSize(450, 450);
        setLayout(null);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String text = area.getText();
            String words[] = text.split("\\s");
            l1.setText("Words: " + words.length);
            l2.setText("Characters: " + text.length());
        }
        else if (e.getSource() == b2) {
            this.setVisible(false);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }

}
