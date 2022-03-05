package miniproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.*;

public class IpFinder extends JFrame implements ActionListener {

    JLabel l,l1;
    JTextField tf;
    JButton b,b1;

    IpFinder() {
        super("IP Finder Tool");
        l = new JLabel("Enter URL:");
        l.setBounds(40, 50, 150, 20);
        l.setFont(new Font("Times New Roman", Font.BOLD, 22));
        add(l);
        
        l1 = new JLabel("Example: www.facebook.com");
        l1.setBounds(40, 65, 250, 20);;
        l1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        add(l1);
        
        tf = new JTextField();
        tf.setBounds(40, 90, 200, 20);
        add(tf);

        b = new JButton("Find IP");
        b.setBounds(60, 130, 80, 30);
        b.addActionListener(this);
        add(b);
        
        b1 = new JButton("EXIT");
        b1.setBounds(100, 200, 100,50);
        b1.setForeground(Color.red);
        add(b1);
        b1.addActionListener(this);
        
        setSize(300, 300);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== b){
        String url = tf.getText();
        try {
            InetAddress ia = InetAddress.getByName(url);
            String ip = ia.getHostAddress();
            JOptionPane.showMessageDialog(this, ip);
        } 
        catch (UnknownHostException e1) {
            JOptionPane.showMessageDialog(this, e1.toString());
        }}
        else if (e.getSource() == b1) {
            this.setVisible(false);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }

}
