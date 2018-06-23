/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson07_GUI;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ComboDemo extends JFrame {

    static final long serialVersionUID = 1L;
    private JTextField _text;
    private JComboBox _combo;

    public ComboDemo() {
        super("ComboBox Demo");
//	Moves and resizes this component.
//	The new location of the top-left corner is  specified by x and y,
//	and the new size is specified by width and height
//	setBounds(x,y,width,height)
        this.setBounds(0, 0, 300, 200);
//	Exit on close
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createGui() {
        this.setLayout(new FlowLayout());
//	A GUI component that holds a line of text - either for display or input
        _text = new JTextField(15);
        this.add(_text);
// A combo box is a drop-down list of options, rather like a menu.
// The user can select one item (but only one).
// When the user clicks on an item an event created.
// The event handler can determine the index number or the string
// that was clicked on. Index values start at 0.
        _combo = new JComboBox();
        _combo.addItem("red");
        _combo.addItem("blue");
        _combo.addItem("green");
        _combo.addItem("orange");
        _combo.setBackground(Color.white);

        _combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand());
                int index = _combo.getSelectedIndex();
                String item = (String) _combo.getSelectedItem();
                switch (index) {
                    case (0): {
                        _text.setForeground(Color.red);
                        break;
                    }
                    case (1): {
                        _text.setForeground(Color.blue);
                        break;
                    }
                    case (2): {
                        _text.setForeground(Color.green);
                        break;
                    }
                    case (3): {
                        _text.setForeground(Color.orange);
                        break;
                    }
                }
                _text.setText("item " + Integer.toString(index) + ", " + item + " selected");
            }
        });
        this.add(_combo);
    }

    public static void main(String[] args) {
        ComboDemo frame = new ComboDemo();
        frame.createGui();
        frame.setVisible(true);
    }
}
