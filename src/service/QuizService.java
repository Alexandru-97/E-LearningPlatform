package service;
import model.*;

public class QuizService
{

    public void addQuestion(Quiz quiz, String question)
    {
        int len = quiz.getQuestions().length;
        String [] aux = new String [len + 1];
        for (int i = 0; i < len; i++)
            aux[i] = quiz.getQuestions()[i];
        aux[len] = question;
        quiz.setQuestions(aux);
    }

    public void addAnswers(Quiz quiz, String answer)
    {
        int len = quiz.getAnswers().length;
        String [] aux = new String [len + 1];
        for (int i = 0; i < len; i++)
            aux[i] = quiz.getAnswers()[i];
        aux[len] = answer;
        quiz.setAnswers(aux);
    }

}
