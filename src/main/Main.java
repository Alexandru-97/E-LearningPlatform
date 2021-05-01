package main;

import model.*;
import service.*;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {




        NotificationService notificationService =  NotificationService.getInstance();
        PlatformService platformService = PlatformService.getInstance();
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

        QuizService quizService = QuizService.getInstance();
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

        //citesc utilizatori din csv
        platformService.readUsers(platform);
        System.out.println("\nUtilizatorii cititi din fisier:");
        platformService.printUsers(platform);

        //citesc profesori din csv
        platformService.readTeachers(platform);
        System.out.println("\nProfesorii cititi din fisier:");
        platformService.printTeachers(platform);



        /*//adaug utilizatori noi in aplicatie
        User user = new User();
        user.setName("Gigel");
        user.setPremium(true);

        User user2 = new User();
        user2.setName("Dorel");
        user2.setPremium(false);

        User user3 = new User();
        user3.setName("Andrei");
        user3.setPremium(false);



        platformService.addUser(platform, user);
        platformService.addUser(platform, user2);
        platformService.addUser(platform, user3);*/

        List<User> users = platform.getUsers();


        //Afisez toti utilizatorii din aplicatie
        //platformService.printUsers(platform);
        //notificationService.viewNotifications("resources/notifications/notifications.csv");

        Collections.sort(users);
        System.out.println("\nUsers sorted by name:");
        users.forEach(u-> System.out.println(u.getName()));

    }
}
