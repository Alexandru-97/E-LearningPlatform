package main;

import model.*;
import service.*;

public class Main
{
    public static void main(String[] args)
    {
        PlatformService platformService = new PlatformService();
        ELearningPlatform platform = new ELearningPlatform();

        //adaugare categorie
        Category category = new Category();
        category.setName("Computer Science");
        platformService.addCategory(platform, category);

        //printare categorie
        platformService.printCategories(platform);

        //adaugare curs
        Course course = new Course();
        course.setName("PAO");
        course.setDuration(8);
        platformService.addCourse(platform, course);

        //printare curs
        platformService.printCourses(platform);

        QuizService quizService = new QuizService();
        Quiz quiz = new Quiz();
        quiz.setSubject("Sorting Alghoritms");

        String question = "Ce complexitate are quicksort? ";
        String answer = "O(nlogn).";
        String question2 = "Ce complexitate are bubble sort? ";
        String answer2 = "O(n^2).";
        String question3 = "Ce complexitate are selectia unui element din hash table? ";
        String answer3 = "O(1).";

        String [] answers = new String[] {};
        String [] questions = new String [] {};

        quiz.setAnswers(answers);
        quiz.setQuestions(questions);

        //adaug intrebari si raspunsuri in quiz
        quizService.addQuestion(quiz, question);
        quizService.addAnswers(quiz, answer);
        quizService.addQuestion(quiz, question2);
        quizService.addAnswers(quiz, answer2);
        quizService.addQuestion(quiz, question3);
        quizService.addAnswers(quiz, answer3);

        Course course2 = new Course();
        course.setName("Data Structures");
        course.setDuration(5);
        platformService.addCourse(platform, course2);

        //printez toate quizz - urile cursului de structuri de date
        platformService.addQuiz(course2, quiz);
        platformService.printQuizzes(course2);


        //adaug utilizatori noi in aplicatie
        User user = new User();
        user.setName("Gigel");
        user.setPremium(true);

        User user2 = new User();
        user2.setName("Dorel");
        user2.setPremium(false);


        platformService.addUser(platform, user);
        platformService.addUser(platform, user2);

        //Afisez toti utilizatorii din aplicatie
        platformService.printUsers(platform);



    }
}
