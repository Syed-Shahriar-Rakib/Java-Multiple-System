package miniproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import javax.swing.border.Border;

public class AgeCalculator extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6;
    JTextField tf1, tf2, tf3;
    JButton b1, b2;
    JPanel contentPane;

    AgeCalculator() {
        //for frame
        setTitle("AGECALCULATOR");
        contentPane = new JPanel();
        contentPane.setBackground(Color.GREEN);
        Border border = BorderFactory.createEtchedBorder(100, Color.WHITE, Color.BLACK);
        setContentPane(contentPane);
        contentPane.setBorder(border);
        setSize(450, 450);
        setLayout(null);
        setVisible(true);

        l1 = new JLabel();
        l1.setBounds(85, 25, 300, 50);
        l1.setFont(new Font("Times New Roman", Font.BOLD, 26));
        add(l1);

        l2 = new JLabel("Enter Your Birth Date: ");
        l2.setBounds(15, 85, 250, 30);
        l2.setFont(new Font("Times New Roman", Font.BOLD, 22));
        add(l2);

        //for input day
        l3 = new JLabel("Day    : ");
        l3.setBounds(180, 130, 80, 30);
        l3.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(l3);
        tf1 = new JTextField();
        tf1.setForeground(Color.red);
        tf1.setBounds(260, 135, 60, 30);
        tf1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tf1);

        //for input day
        l4 = new JLabel("Month: ");
        l4.setBounds(180, 173, 80, 50);
        l4.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(l4);
        tf2 = new JTextField();
        tf2.setBounds(260, 185, 60, 30);
        tf2.setForeground(Color.red);
        tf2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tf2);

        //calculate age button
        b1 = new JButton("Calculate Age");
        b1.setBounds(125, 280, 200, 40);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setFont(new Font("Times New Roman", Font.BOLD, 24));
        b1.addActionListener(this);
        add(b1);

        //for input day
        l5 = new JLabel("Year   : ");
        l5.setBounds(180, 220, 80, 50);
        l5.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(l5);
        tf3 = new JTextField();
        tf3.setBounds(260, 235, 60, 30);
        tf3.setForeground(Color.red);
        tf3.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tf3);

        //show calculate age
        l6 = new JLabel();
        l6.setBounds(10, 20, 400, 40);
        add(l6);
        b2 = new JButton("Exit");
        b2.setBounds(175, 340, 100, 40);
        b2.addActionListener(this);
        add(b2);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {

            String bd = tf1.getText();
            String bm = tf2.getText();
            String by = tf3.getText();
            int birth_date = Integer.parseInt(bd);
            int birth_month = Integer.parseInt(bm);
            int birth_year = Integer.parseInt(by);

            //for today date
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MM dd");
            LocalDateTime now = LocalDateTime.now();
            String today = dtf.format(now);
            String date[] = today.split(" ");
            int current_date = Integer.parseInt(date[2]);
            int current_month = Integer.parseInt(date[1]);
            int current_year = Integer.parseInt(date[0]);

            if ((birth_date > 0 && birth_date < 32) && (birth_month > 0 && birth_month < 13) && birth_year <= current_year) {
                if ((birth_month == 2 && birth_date > 0 && birth_date < 30) || (birth_month == 1 && birth_date > 0 && birth_date < 32) || (birth_month == 3 && birth_date > 0 && birth_date < 32) || (birth_month == 4 && birth_date > 0 && birth_date < 31) || (birth_month == 5 && birth_date > 0 && birth_date < 32) || (birth_month == 6 && birth_date > 0 && birth_date < 31) || (birth_month == 7 && birth_date > 0 && birth_date <= 31) || (birth_month == 8 && birth_date > 0 && birth_date <= 31) || (birth_month == 9 && birth_date > 0 && birth_date < 31) || (birth_month == 10 && birth_date > 0 && birth_date <= 31) || (birth_month == 11 && birth_date > 0 && birth_date < 31) || (birth_month == 12 && birth_date > 0 && birth_date <= 31)) {
                    int month[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

                    // if birth date is greater then current  
                    // birth_month, then donot count this month 
                    // and add 30 to the date so as to subtract  
                    // the date and get the remaining days 
                    {
                        if (birth_date > current_date) {
                            current_month = current_month - 1;
                            current_date = current_date + month[birth_month - 1];
                        }

                        // if birth month exceeds current month,  
                        // then do not count this year and add  
                        // 12 to the month so that we can subtract 
                        // and find out the difference 
                        if (birth_month > current_month) {
                            current_year = current_year - 1;
                            current_month = current_month + 12;
                        }

                        // calculate date, month, year 
                        int calculated_date = current_date - birth_date;
                        int calculated_month = current_month - birth_month;
                        int calculated_year = current_year - birth_year;

                        if (birth_month == 2 && birth_date == 29) {
                            int leap4 = birth_year % 4;
                            int leap100 = birth_year % 100;
                            int leap400 = birth_year % 400;

                            if ((leap4 == 0 && leap100 != 0) || leap400 == 0) {
                                calculated_date = calculated_date + 1;

                            }
                            if (calculated_year < 0) {
                                JOptionPane.showMessageDialog(this, "Your input Date of Birth is incorrect.\nIt should be below in current date.\nPlease try again.\nThank you!");
                            } else {
                                // print the present age 
                                JOptionPane.showMessageDialog(this, "Present Age: \n " + calculated_year + "Years \n" + calculated_month + "Months\n" + calculated_date + "Days");
                                this.setVisible(false);
                            }
                        } else {

                            if (calculated_year < 0) {
                                JOptionPane.showMessageDialog(this, "Your input Date of Birth is incorrect.\nIt should be below in current date.\nPlease try again.\nThank you!");
                            } else {
                                // print the present age 
                                JOptionPane.showMessageDialog(this, "Present Age: \n " + calculated_year + "Years \n" + calculated_month + "Months\n" + calculated_date + "Days");
                                this.setVisible(false);
                            }
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Your input Date of Birth is incorrect.\nPlease try again.\nThank you!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Your input Date of Birth is incorrect.\nPlease try again.\nThank you!");

            }

        }
        if (e.getSource() == b2) {
            this.setVisible(false);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }
}
