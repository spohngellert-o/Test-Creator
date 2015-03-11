//Test
import java.lang.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
public class QuestionsDriver
{
    public static void main(String [] args)
    {
        //makes an etp where the original data will be taken in
        EventTesterPanel etp = new EventTesterPanel();
        //makes the etp close when the x button is pressed
        etp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //sets the size
        etp.setPreferredSize(new Dimension(550, 300));
        //packs and displays it
        etp.pack();
        etp.setVisible(true);
    }
}