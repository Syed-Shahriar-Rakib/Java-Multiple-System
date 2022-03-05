package miniproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Window extends JFrame implements ActionListener {
        JFrame f;
        JButton b1,b2,b3,b4,b5,b6,b7;
        JLabel l1,l2;
        JPanel contentPane;
    void Window() {
        setTitle("Java Application World");
        contentPane = new JPanel();
        contentPane.setBackground(Color.GREEN);
        Border border = BorderFactory.createEtchedBorder(100, Color.WHITE, Color.BLACK);
        setContentPane(contentPane);
        contentPane.setBorder(border);
        
        l1= new JLabel(" WELCOME");
        l1.setFont(new Font("Times New Roman",Font.BOLD, 26));
        l1.setBorder(border);
        l1.setBounds(250, 15, 200, 30);
        add(l1);
        
        //for word count
        b1=new JButton(new ImageIcon("wordcount.jpg")); 
        b1.setBounds(25,75,200, 200);  
        b1.addActionListener(this);
        add(b1);
        
        //for age calculator
        b2=new JButton(new ImageIcon("agecalculator.jpg")); 
        b2.setBounds(250,75,200, 200); 
        b2.addActionListener(this);
        add(b2);
               
        //for simple claculator
        b3=new JButton(new ImageIcon("calculator.png")); 
        b3.setBounds(475,75,200, 200);   
        b3.addActionListener(this);
        add(b3);
        
        //for ip founder
        b4=new JButton(new ImageIcon("ip.jpg")); 
        b4.setBounds(25,300,200, 200); 
        b4.addActionListener(this);
        add(b4);
        
        //for quiz
        b5=new JButton(new ImageIcon("quiz.jpg")); 
        b5.setBounds(250,300,200, 200); 
        b5.addActionListener(this);
        add(b5);
        
        //for gcd and lcd
        b6=new JButton(new ImageIcon("gcd.jpg")); 
        b6.setBounds(475,300,200, 200); 
        b6.addActionListener(this);
        add(b6);
        
        l2=new JLabel("   SELECT A MENU BUTTON   ");
        l2.setFont(new Font("Times New Roman",Font.BOLD, 26));
        l2.setBorder(border);
        l2.setForeground(Color.red);
        l2.setBounds(150, 520, 400, 40);
        add(l2);
        
        b7=new JButton(new ImageIcon("exit.jpg")); 
        b7.setBounds(250,570,200, 140); 
        b7.addActionListener(this);
        add(b7);

        setSize(710, 771);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== b1){
            WordCount count= new WordCount();
            count.setVisible(true);
            }
        
        else if(e.getSource()==b2){
        AgeCalculator age = new AgeCalculator();
        age.setVisible(true);
        }
        
        
        else if(e.getSource()==b3){
            new Calculator("Calculator");
        
        }
        
        
        else if(e.getSource()==b4){
            IpFinder ip= new IpFinder();
        
        }
        
        else if(e.getSource()==b5){
            new Quiz(" Online Test Of CSE110 ");  
        }
        
        
         else if(e.getSource()==b6){
            Lcm lg = new Lcm ();  
        }
        else if(e.getSource()==b7){
            System.exit(0);
        }
    }
}
