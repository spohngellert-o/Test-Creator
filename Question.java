//test
import java.lang.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;

import javax.swing.*;
public class Question
{
    private String question;
    private ArrayList <String> answers;
    private int correctAnswer;
    /*Question()
     * constructor
     * Olie Spohngellert*/
    public Question()
    {
        //sets the question
        question = "";
        //creates the array list
        answers = new ArrayList<String>(0);
        for(int i = 0; i<5; i++)
            answers.add(i, new String());
        //creates the correctAnswer
        correctAnswer = -1;
    }
    //getAnswers()
    //gets the answer array list
    public ArrayList<String> getAnswers()
    {
        return answers;
    }
    /*public void setAnswers
     * Sets the answers*/
    public void setAnswers(ArrayList<String> answers2)
    {
        answers = answers2;
        stripEmpty();
    }
    /*public String getCorrectAnswer
     * gets the correct answer*/
    public int getCorrectAnswer()
    {
        return correctAnswer;
    }
    /*setCorrectAnswer
     * sets the correct answer*/
    public void setCorrectAnswer(int answer)
    {
        correctAnswer = answer;
    }
    /*getQuestion
     * gets the question*/
    public String getQuestion()
    {
        return question;
    }
    //Question(String question1, ArrayList<String> answers1, String answerIndex1)
    //alternate constructor
    public Question(String question1, ArrayList<String> answers1, int answerIndex1)
    {
        question = question1;
        answers=answers1;
        correctAnswer=answerIndex1;
    }
    /*setQuestion2
     * sets the question*/
    public void setQuestion2(String question2)
    {
        question = question2;
    }
    /*setAnswer(int i, String answer1
     * sets a specific answer
     * i-index of answer(-1), answer-answer to be set to*/
    public void setAnswer(int i, String answer1)
    {
        answers.set(i, answer1);
    }
    /*toString
     * makes the answer into a string*/
    public String toString()
    {
        //strips out the empty answers from the arraylist
        stripEmpty();
        //Creates a string, adds the question and a new line
        String returnable = question + "\r\n";
        for(int i = 0; i<answers.size(); i++)
            //adds all the answers and a new line each time
            returnable+= i+1 + ")" + answers.get(i) + "\r\n";
        //returns
        return returnable + "\r\n";
    }
    /*toString2
     * alternate toString formulator*/
    public String toString2()
    {
        //strips out empty answers
        stripEmpty();
        //adds the question
        String returnable = question + "\r\n";
        for(int i = 0; i<answers.size(); i++) {
            //adds the answers
            returnable+= "\t" + (i+1) + ")" + answers.get(i) + "\r\n";
        }
        //returns
        return returnable + "\r\n";
    }
    //scrambles the answers within the code
    public void scrambleAnswers() {
        //creates a random
        Random random = new Random();
        for(int i = 0; i<(answers.size()*2); i++)
        {
            //random indecies
            int r1 = random.nextInt(10000)%answers.size();
            int r2 = random.nextInt(10000)%answers.size();
            int ans = correctAnswer;
            //checks if the correct answer is or isn't one of the others, if it is it resets it
            if(ans == r1) {
                correctAnswer = r2 + 1;
            }
            if(ans == r2) {
                correctAnswer = r1 + 1;
            }
            //switches the answers
            String temp = answers.get(r1);
            answers.set(r1, answers.get(r2));
            answers.set(r2, temp);
        }
    }
    //strips out all empty answers
    public void stripEmpty() {
        ArrayList<String> temp = new ArrayList<String>(0);
        for(int i = 0; i<answers.size(); i++) {
            if(answers.get(i).equals("")) {
            }
            else {
                temp.add(answers.get(i));
            }
        }
        answers = temp;
    }
}