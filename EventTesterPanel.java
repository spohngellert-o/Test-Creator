//test
// EventTesterPanel.java              Author: Zinn
//
// Demonstrates the use of different listeners in a GUI

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class EventTesterPanel extends JFrame
{
    //necessary instance variables for the class
    private JButton myButton;
    private JTextField myTextField;
    private JTextField myTextField2, versions;
    private JLabel myLabel;
    private int returnable;
    private Question [] qs;
    private JPanel title;
    private JPanel fields;
    private JPanel finalButton;
    /*EventTesterPanel()
     * constructor*/
    public EventTesterPanel()
    {
        //sets the instance variables, sets their fonts to Calibri size 18
        myButton = new JButton("Apply");
        myButton.setFont(new Font("Calibri", Font.PLAIN, 18));
        myTextField = new JTextField(18);
        myTextField2 = new JTextField(18);
        versions = new JTextField(18);
        title = new JPanel();
        myLabel = new JLabel("<html>This is Olie's test maker! Start by entering the file name, along with<br> the extension"
                + "(.doc, .txt), and the number of versions below.</html>");
        myLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
        JLabel label1 = new JLabel("File Name: ");
        label1.setFont(new Font("Calibri", Font.PLAIN, 18));
        JLabel label2 = new JLabel("Extension: ");
        label2.setFont(new Font("Calibri", Font.PLAIN, 18));
        JLabel label3 = new JLabel("Number of Versions: ");
        label3.setFont(new Font("Calibri", Font.PLAIN, 18));
        //adds them
        title.add(myLabel);
        GridLayout grid = new GridLayout(3, 2);
        grid.setVgap(5);
        fields = new JPanel(grid);
        fields.add(label1);
        fields.add(myTextField);
        fields.add(label2);
        fields.add(myTextField2);
        fields.add(label3);
        fields.add(versions);
        finalButton = new JPanel(); 
        finalButton.add(myButton);
        add(title, BorderLayout.NORTH);
        add(fields, BorderLayout.CENTER);
        add(finalButton, BorderLayout.SOUTH);
        //adds an action listener
        myButton.addActionListener(new AListener());
    }
    //getQuestions
    //gets the question array
    public Question[] getQuestions()
    {
        return qs;
    }
    //createCard(JFrame frame, int i)
    //Creates a card
    public Card createCard(JFrame frame, String name, String extension, int versions)
    {
        return 
                new Card(frame.getContentPane(), "", this, name, extension, versions);
    }

    private class AListener implements ActionListener
    {
        //public void actionPerformed
        //tests if the button is pressed, sets the card based upon the information in the text fields
        //gui
        public void actionPerformed(ActionEvent e)
        {
            //if the button is pressed
            if (e.getSource().equals(myButton))
            {
                boolean cond1 = isInt(versions.getText()) && !versions.getText().equals("");
                boolean cond2 = isExtension(myTextField2.getText());
                boolean cond3 = !(myTextField.getText().equals(""));
                //checks whether all input is valid
                if(cond1 && cond2 && cond3) {
                    //sets the question
                    qs = new Question[0];
                    //creates a frame for the card
                    JFrame frame2 = new JFrame("Enter Questions");
                    //sets this frame's visibility to false
                    setVisible(false);
                    //makes the next frame of 500X600 and makes it visible
                    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame2.setPreferredSize(new Dimension(500, 600));
                    frame2.pack();
                    frame2.setVisible(true);
                    //creates the card with all the info
                    Card card = createCard(frame2, myTextField.getText(), myTextField2.getText(), 
                            Integer.parseInt(versions.getText()));
                    //creates all of the frames and displays them!
                }
                else {
                    //Displays the correct error based upon which test failed
                    String error = "";
                    if(!cond1) {
                        error += "Put a number for the number of versions.\n";
                    }
                    if(!cond2) {
                        error += "Enter a valid extension.\n";
                    }
                    if(!cond3) {
                        error += "Enter a name.";
                    }
                    JOptionPane.showMessageDialog(null, error);
                }
            }
        }
        //Checks whether or not string input is a valid int to be converted
        public boolean isInt(String input) {
            //Basecase: string of length 0, is a number
            if(input.length() == 0) {
                return true;
            }
            //Checks if the ascii value of the first character is between the values for numbers, and does
            //the method on the rest of the string
            else {
                int ascii = (int) input.charAt(0);
                return ascii >= 48 && ascii <= 57 && isInt(input.substring(1, input.length()));
            }
        }
        //Checks if input string is a valid extension
        public boolean isExtension(String input) {
            //checks if it's empty, and also checks whether or not the first character is a .
            return !(input.equals("")) && ((int) input.charAt(0) == 46);
        }
    }
}