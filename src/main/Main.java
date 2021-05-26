package main;

import model.*;
import service.*;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        NotificationService notificationService =  NotificationService.getInstance();
        PlatformService platformService = PlatformService.getInstance();
        CategoryService categoryService = new CategoryService();
        UserService userService = new UserService();

        Scanner scanner = new Scanner(System.in);


        ELearningPlatform platform = new ELearningPlatform();

/*
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



        //adaug utilizatori noi in aplicatie
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
        platformService.addUser(platform, user3);

        List<User> users = platform.getUsers();


        //Afisez toti utilizatorii din aplicatie
        //platformService.printUsers(platform);
        //notificationService.viewNotifications("resources/notifications/notifications.csv");

        Collections.sort(users);
        System.out.println("\nUsers sorted by name:");
        users.forEach(u-> System.out.println(u.getName()));
        */

//etapa 3 proiect


        while(true) {
            System.out.println("Please type one of the following commands: add, delete,  get, get total amount, exit");
            String line = scanner.nextLine();
            switch (line) {
                case "add user" -> {
                    addUser(userService, scanner);
                    break;
                }
                case "add category" -> {
                    addCategory(categoryService, scanner);
                    break;
                }
                case "delete category" -> {
                    deleteCategory(categoryService, scanner);
                    break;
                }
                case "delete user" -> {
                    deleteUser(userService, scanner);
                    break;
                }
                case "get total amount" -> {
                    break;
                }
                case "exit" -> {
                    System.out.println("Bye...");
                    System.exit(0);
                }
                default -> System.out.println("This command doesn't exist.");
            }
        }
    }

    private static void addCategory(CategoryService categoryService, Scanner scanner) {

        System.out.println("Please specify the category details: name");
        try {
            Category category = categoryService.build(scanner.nextLine());
            categoryService.addCategory(category);
        } catch (NumberFormatException e) {
            System.out.println("Invalid inputs for category creation. The category was not saved in the db.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Not enough inputs for category creation. The category was not saved in the db.");
        }
    }

    private static void addUser(UserService userService, Scanner scanner) {

        System.out.println("Please specify the user details: name/premium status(boolean)");
        try {
            User user = userService.build(scanner.nextLine());
            userService.addUser(user);
        } catch (NumberFormatException e) {
            System.out.println("Invalid inputs for user creation. The user was not saved in the db.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Not enough inputs for user creation. The category was not saved in the db.");
        }
    }
    private static void deleteCategory(CategoryService categoryService, Scanner scanner) {

        System.out.println("Please specify the category details: name");
        try {
            Category category = categoryService.build(scanner.nextLine());
            categoryService.deleteCategory(category);
        } catch (NumberFormatException e) {
            System.out.println("Invalid inputs for category deletion.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Not enough inputs for category deletion.");
        }
    }
    private static void deleteUser(UserService userService, Scanner scanner) {

        System.out.println("Please specify the user details: name");
        try {
            String name = scanner.nextLine();
            System.out.println(name);
            User user = new User(name);
            userService.deleteUser(user);
        } catch (NumberFormatException e) {
            System.out.println("Invalid inputs for user deletion.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Not enough inputs for user deletion.");
        }
    }
}
