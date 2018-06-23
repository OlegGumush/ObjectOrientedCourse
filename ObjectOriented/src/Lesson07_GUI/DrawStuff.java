package Lesson07_GUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class DrawStuff extends JFrame{

    int i = 0;
    JPanel _panel;
    public int _width, _height;
    int x, y;

    public DrawStuff() {
        _width = 400;
        _height = 400;
        _panel = new JPanel();
        _panel.setPreferredSize(new Dimension(_width, _height));
        this.setLayout(new FlowLayout());
        _panel.setBackground(Color.white);
        this.add(_panel);
        _panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent event) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                x = event.getX();
                y = event.getY();
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent me) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    public void init(DrawStuff frame) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("    My GUI Example");
        frame.setSize(frame._width, frame._height);
        frame.setBackground(Color.white);
        frame.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {

// The origin (0,0) is at the upper left corner.
// x increases to the right, and y increases downward.
//	The method getGraphics is called to obtain a Fraphics object
        if (i == 0) {
            g = _panel.getGraphics();
            g.setColor(Color.red);
            g.drawRect(10, 20, 100, 15);
            g.setColor(Color.pink);
            g.fillRect(240, 160, 40, 110);

            g.setColor(Color.blue);
            g.drawOval(50, 225, 100, 50);
            g.setColor(Color.orange);
            g.fillOval(225, 37, 50, 25);

            g.setColor(Color.magenta);
            g.drawArc(10, 110, 80, 80, 90, 180);
            g.setColor(Color.cyan);
            g.fillArc(140, 40, 120, 120, 90, 45);

            g.setColor(Color.black);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("HELLO!", 50, 150);
        }
        i++;
        g.setColor(Color.black);
        g.fillOval(x, y, 15, 15);
        g.setColor(Color.blue);
        g.fillRect(x + 20, y + 20, 20, 20);
    }

    public static void main(String[] a) {
        System.out.println("My GUI example");
        DrawStuff frame = new DrawStuff();
        frame.init(frame);
    }
}
