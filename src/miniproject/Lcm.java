package miniproject;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Lcm extends JFrame implements ActionListener {

    JTextField tf1, tf2, tf3;
    JButton b1, b2,b3;
    JLabel l1,l2;

    Lcm() {
        setTitle("LCM & GCD");
        JFrame f = new JFrame();
        
        l1= new JLabel("Enter your 1st number:");
        l1.setBounds(50, 10, 150, 20);
        tf1 = new JTextField();
        tf1.setBounds(50,35 , 150, 20);
        
        l2= new JLabel("Enter your 2nd number:");
        l2.setBounds(50, 60, 150, 20);
        tf2 = new JTextField();
        tf2.setBounds(50, 85, 150, 20);
        
        tf3 = new JTextField("Result");
        tf3.setBounds(50, 115, 150, 20);
        tf3.setEditable(false);
        
        b1 = new JButton("LCM");
        b1.setBounds(50, 140, 70, 50);
        
        b2 = new JButton("GCD");
        b2.setBounds(120, 140, 70, 50);
        
        b3 = new JButton("EXIT");
        b3.setForeground(Color.red);
        b3.setBounds(85, 200, 70, 50);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        add(tf1);
        add(tf2);
        add(tf3);
        add(b1);
        add(b2);
        add(b3);
        add(l1);
        add(l2);
        setSize(300, 300);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String s1 = tf1.getText();
        String s2 = tf2.getText();
        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        int l, g = 1;

        //for lcm
        if (e.getSource() == b1) {
            // maximum number between n1 and n2 is stored in lcm
            l = (a > b) ? a : b;

            // Always true
            while (true) {
                if (l % a == 0 && l % b == 0) {
                    break;
                }
                ++l;
            }
            String lcm = String.valueOf(l);
            tf3.setText(lcm);
        }

        //for gcd
        else if (e.getSource() == b2) {
            for (int i = 1; i <= a && i <= b; ++i) {
                // Checks if i is factor of both integers
                if (a % i == 0 && b % i == 0) {
                    g = i;
                }
            }
            String gcd = String.valueOf(g);
            tf3.setText(gcd);

        }
        else if (e.getSource() == b3){
            this.setVisible(false);
        }

    }

}
