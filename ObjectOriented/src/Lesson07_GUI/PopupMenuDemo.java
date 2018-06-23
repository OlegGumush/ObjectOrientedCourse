package Lesson07_GUI;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

// Define PopupMenuListener
class MyPopupMenuListener implements PopupMenuListener {

    public void popupMenuCanceled(PopupMenuEvent popupMenuEvent) {
        System.out.println("Canceled");
    }

    public void popupMenuWillBecomeInvisible(PopupMenuEvent popupMenuEvent) {
        System.out.println("Becoming Invisible");
    }

    public void popupMenuWillBecomeVisible(PopupMenuEvent popupMenuEvent) {
        System.out.println("Becoming Visible");
    }
}

public class PopupMenuDemo extends JFrame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JFrame frame;
    JPopupMenu popupMenu;
    PopupMenuListener popupMenuListener;
    private JTextField textField;
    JMenuItem cutMenuItem;
    JMenuItem copyMenuItem;
    JMenuItem pasteMenuItem;
    JMenuItem findMenuItem;

    public PopupMenuDemo() {
        frame = new JFrame("PopupSample Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Create popup menu, attach popup menu listener
        popupMenu = new JPopupMenu("Title");
        popupMenuListener = new MyPopupMenuListener();
        popupMenu.addPopupMenuListener(popupMenuListener);
        textField = new JTextField(25);
    }

    public void createGUI() {
        // Cut
        cutMenuItem = new JMenuItem("Cut");
        popupMenu.add(cutMenuItem);
        cutMenuItem.addActionListener(this);
        // Copy
        copyMenuItem = new JMenuItem("Copy");
        popupMenu.add(copyMenuItem);
        copyMenuItem.addActionListener(this);
        // Paste
        pasteMenuItem = new JMenuItem("Paste");
        pasteMenuItem.addActionListener(this);
        pasteMenuItem.setEnabled(false);
        popupMenu.add(pasteMenuItem);

        // Separator
        popupMenu.addSeparator();

        // Find
        findMenuItem = new JMenuItem("Find");
        findMenuItem.setEnabled(false);
        findMenuItem.addActionListener(this);
        popupMenu.add(findMenuItem);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setComponentPopupMenu(popupMenu);
        panel.add(textField);

        frame.setSize(350, 250);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("Cut")) {
            textField.setText("Cut");
            pasteMenuItem.setEnabled(true);
        } else if (command.equals("Copy")) {
            textField.setText("Copy");
            pasteMenuItem.setEnabled(true);
        } else if (command.equals("Paste")) {
            textField.setText("Paste");
            pasteMenuItem.setEnabled(false);
        }
    }

    public static void main(final String args[]) {
        PopupMenuDemo frame = new PopupMenuDemo();
        frame.createGUI();
    }
}