import java.util.*;

import javax.swing.*;
public class MultiPart implements JQuestion {

    String base;
    ArrayList<Question> questions;
    MultiPart() {
        base = JOptionPane.showInputDialog(null, "What is your base information?");
        questions = new ArrayList<Question>();
    }
    public void addQuestion(JQuestion q) {
        questions.add((Question) q);
    }
    public String getBase() {
        return this.base;
    }
    public void setBase(String base) {
        this.base = base;
    }
    public ArrayList<Question> getQuestions() {
        return this.questions;
    }
    public String toString2(int qNumber) {
        String returnable = "Utilize the following information to answer questions " +
                qNumber + "-" + (qNumber + questions.size() - 1) + ":\r\n" + this.base + "\r\n\r\n";
        for(int i = 0; i < questions.size(); i++) {
            returnable += questions.get(i).toString2(qNumber);
            qNumber++;
        }
        return returnable;
    }
    public void setAnswer(int i, String answer) {
        questions.get(questions.size() - 1).setAnswer(i, answer);
    }
    public int getCorrectAnswer() {
        return questions.get(questions.size() - 1).getCorrectAnswer();
    }
    public void scrambleAnswers() {
        for(int i = 0; i < questions.size(); i++) {
            questions.get(i).scrambleAnswers();
        }
    }
    public void setCorrectAnswer(int i) {
        questions.get(questions.size() - 1).setCorrectAnswer(i);
    }
    public void setQuestion2(String question) {
        questions.get(questions.size() - 1).setQuestion2(question);
    }
    public String makeKey(int qNumber) {
        String returnable = "";
        for(int i = 0; i < questions.size(); i++) {
            returnable += questions.get(i).makeKey(qNumber);
            qNumber++;
        }
        return returnable;
    }
    public int incQNumber(int qNumber) {
        return qNumber + questions.size();
    }
}
