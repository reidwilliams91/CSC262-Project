import javax.swing.JFrame;

import javax.swing.*;
import java.awt.Color;
import javax.swing.border.Border;

public class ROBOT_GUI extends JFrame{

    private static final long serialVersionUID = 1L;

    ROBOT_GUI()
    {
        JFrame f1 = new JFrame("Robot Simulator");

        Color green = new Color(0, 102, 0);
        Color lightblue = new Color(51, 187, 255);
        Color labelcolor = new Color(193, 215, 215);
        Color darkorange = new Color(204, 122, 0);

        JLabel l1;
        l1 = new JLabel("Display Screen", SwingConstants.CENTER);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        l1.setBorder(border);
        l1.setBounds(200, 30, 350, 300);
        l1.setOpaque(true);
        l1.setBackground(labelcolor);

        JButton b1, b2, b3, b4, b5, b6;
        b1 = new JButton("Pick Up");
        b2 = new JButton("Drop Off");
        b3 = new JButton("Move Up");
        b4 = new JButton("Move Left");
        b5 = new JButton("Move Right");
        b6 = new JButton("Move Down");

        b1.setBounds(200, 390, 140, 50);
        b1.setBackground(green);
        b1.setForeground(Color.white);

        b2.setBounds(360, 390, 140, 50);
        b2.setBackground(darkorange);
        b2.setForeground(Color.white);

        b3.setBounds(280, 450, 140, 50);
        b3.setBackground(lightblue);
        b3.setForeground(Color.white);

        b4.setBounds(200, 510, 140, 50);
        b4.setBackground(lightblue);
        b4.setForeground(Color.white);

        b5.setBounds(360, 510, 140, 50);
        b5.setBackground(lightblue);
        b5.setForeground(Color.white);

        b6.setBounds(280, 570, 140, 50);
        b6.setBackground(lightblue);
        b6.setForeground(Color.white);

        f1.add(b1);
        f1.add(b2);
        f1.add(b3);
        f1.add(b4);
        f1.add(b5);
        f1.add(b6);
        f1.add(l1);

        f1.setSize(700, 700);
        f1.setLayout(null);
        f1.setVisible(true);
    }

    public static void main(String args[])
    {
        ROBOT_GUI try1 = new ROBOT_GUI();

        try1.setVisible(true);
    }

}