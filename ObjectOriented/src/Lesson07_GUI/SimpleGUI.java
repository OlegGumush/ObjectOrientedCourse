package Lesson07_GUI;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//This class implements the ActionListener interface.
//this requires us to write a method named actionPerformed
public class SimpleGUI extends JFrame{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
//	static final long serialVersionUID=1L;
    private JButton _buttonPress = new JButton("Press");
    private JTextField _inputText = new JTextField("", 5);
    private JLabel _label = new JLabel("  Input:");
    private JRadioButton _radio1 = new JRadioButton("Select this");
    private JRadioButton _radio2 = new JRadioButton("Select that");
    private JCheckBox _check = new JCheckBox("Check1", false);
    private JCheckBox _check1 = new JCheckBox("Check2", true);

    public SimpleGUI() {
        super("Simple Example");

// Moves and resizes this component. 
// The new location of the top-left corner is  specified by x and y, 
// and the new size is specified by width and height
// setBounds(x,y,width,height)
        this.setBounds(200, 200, 450, 350);
// Exit on close
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Returns the contentPane object for this frame
        //Container window = this.getContentPane();
// Sets the layout manager for this container
        this.setLayout(new GridLayout(4, 2));//,2,2));
        //this.setLayout(new FlowLayout()); 
// Appends the specified component to the end of this container. 
        this.add(_label);
        this.add(_inputText);
// ButtonGroup - this class is used to create a multiple-exclusion scope 
// for a set of buttons. 
// Creating a set of buttons with the same ButtonGroup object 
// means that turning "on" one of those buttons 
// turns off all other buttons in the group. 
        ButtonGroup group = new ButtonGroup();
        group.add(_radio1);
        group.add(_radio2);
        this.add(_radio1);
        _radio1.setSelected(true);
        this.add(_radio2);
        ButtonGroup group1 = new ButtonGroup();
        group1.add(_check);
        group1.add(_check1);
        this.add(_check);
        this.add(_check1);
// Then we register the program as a listener for action events
// from the button buttonPress
        _buttonPress.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//		System.out.println(e.getActionCommand());
                String message = "";
                message += "Button was pressed\n";
                message += "Text is " + _inputText.getText() + "\n";
                message += (_radio1.isSelected() ? "Radio #this" : "Radio #that") + " is selected\n";
                message += ((_check.isSelected() ? "Check #1" : "Chek #2") + " is selected\n");
//	public static void showMessageDialog(Component parentComponent,
//                Object message, String title, int messageType)
//         throws HeadlessException
// Brings up a dialog that displays a message using a default icon 
// determined by the messageType parameter. 
// Parameters:
// parentComponent - determines the Frame in which the dialog is displayed; 
// if null, or if the parentComponent has no Frame, a default Frame is used
// message - the Object to display
// title - the title string for the dialog
// messageType - the type of message to be displayed: 
// ERROR_MESSAGE, INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE, or PLAIN_MESSAGE 
// Throws: 
// HeadlessException - if GraphicsEnvironment.isHeadless returns true
                JOptionPane.showMessageDialog(null, message, "Output Message",
                        JOptionPane.PLAIN_MESSAGE);
            }
        });
//	    _buttonPress.addActionListener(new ButtonEventListener());
        this.add(_buttonPress);
    }

    public static void main(String[] args) {
        SimpleGUI app = new SimpleGUI();
// Shows or hides this component depending on the value of parameter b
        app.setVisible(true);
    }
}
