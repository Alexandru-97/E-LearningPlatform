package service;

import model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

public class PlatformService
{
    /*private NotificationService notificationService;
    public PlatformService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }*/

    private static final PlatformService SINGLETON = new PlatformService(NotificationService.getInstance());
    private PlatformService(NotificationService instance){}
    public static PlatformService getInstance()
    {
        return SINGLETON;
    }

    public void readUsers(ELearningPlatform platform)
    {
        try
        {
            BufferedReader reader = Files.newBufferedReader((Paths.get("resources/input/users.csv")));
            String line = "";
            while ((line = reader.readLine())!= null)
            {
                String[] data = line.split(",");
                User user = new User();
                user.setName(data[0]);
                user.setPremium(Boolean.parseBoolean(data[1]));
                PlatformService.getInstance().addUser(platform, user);
            }
        }
        catch (NoSuchFileException var4) {
            System.out.println("The file with the name resources/input/users.csv doesn't exist.");
        } catch (IOException var5) {
            PrintStream var10000 = System.out;
            Class var10001 = var5.getClass();
            var10000.println(var10001 + " " + var5.getMessage());
        }
    }

    public void addUser(ELearningPlatform platform, User user)
    {
        List<User> users = platform.getUsers();
        users.add(user);
        platform.setUsers(users);
        String message = "add user";
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        NotificationService.getInstance().sendNotification(new Notification(message, timeStamp));
    }

    public void printUsers(ELearningPlatform platform)
    {
        for(User user: platform.getUsers())
        {
            if (user != null)
            {
                System.out.println(user.getName());
                if (user.isPremium())
                {
                    System.out.println("Utilizatorul are cont premium");
                    // celelalte chestii de la premiumuser
                }
                else
                {
                    System.out.println("Utilizatorul nu are cont premium.");
                }
            }
        }
    }

    public void readTeachers(ELearningPlatform platform)
    {
        try
        {
            BufferedReader reader = Files.newBufferedReader((Paths.get("resources/input/teachers.csv")));
            String line = "";
            while ((line = reader.readLine())!= null)
            {
                String[] data = line.split(",");
                Teacher teacher = new Teacher();
                teacher.setName(data[0]);
                teacher.setEmployee(Boolean.parseBoolean(data[1]));
                PlatformService.getInstance().addTeacher(platform, teacher);

            }
        }
        catch (NoSuchFileException var4) {
            System.out.println("The file with the name resources/input/teachers.csv doesn't exist.");
        } catch (IOException var5) {
            PrintStream var10000 = System.out;
            Class var10001 = var5.getClass();
            var10000.println(var10001 + " " + var5.getMessage());
        }
    }


    public void addTeacher(ELearningPlatform platform, Teacher teacher)
    {
        List<Teacher> teachers = platform.getTeachers();
        teachers.add(teacher);
        platform.setTeachers(teachers);
        String message = "add teacher";
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        NotificationService.getInstance().sendNotification(new Notification(message, timeStamp));
    }

    public void printTeachers(ELearningPlatform platform)
    {
        for(Teacher teacher: platform.getTeachers())
        {
            if (teacher != null)
            {
                System.out.println(teacher.getName());
                if (teacher.isEmployee())
                {
                    System.out.println("Profesorul este angajat");

                }
                else
                {
                    System.out.println("Profesorul este contractor.");
                }
            }
        }
    }
    public void addCategory(ELearningPlatform platform, Category category)
    {
        int len = platform.getCategories().length;
        Category [] aux = new Category [len + 1];
        for (int i = 0; i < len; i++)
            aux[i] = platform.getCategories()[i];
        aux[len] = category;
        platform.setCategories(aux);
        String message = "add category";
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        NotificationService.getInstance().sendNotification(new Notification(message, timeStamp));
    }

    public void printCategories(ELearningPlatform platform)
    {
        for(Category category: platform.getCategories())
        {
            if (category != null)
            {
                System.out.println(category.getName());
            }
        }
    }

    public void addCourse(ELearningPlatform platform, Course course)
    {
        int len = platform.getCourses().length;
        Course [] aux = new Course [len + 1];
        for (int i = 0; i < len; i++)
            aux[i] = platform.getCourses()[i];
        aux[len] = course;
        platform.setCourses(aux);
        String message = "add course";
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        NotificationService.getInstance().sendNotification(new Notification(message, timeStamp));
    }

    public void printCourses(ELearningPlatform platform)
    {
        for(Course course: platform.getCourses())
        {
            if (course != null)
            {
                System.out.println(course.getName());
                System.out.println(course.getDuration() + " hours");

            }
        }
    }

    public void addQuiz(Course course, Quiz quiz)
    {
        int len = course.getQuizzes().length;
        Quiz [] aux = new Quiz [len + 1];
        for (int i = 0; i < len; i++)
            aux[i] = course.getQuizzes()[i];
        aux[len] = quiz;
        course.setQuizzes(aux);
        String message = "add quiz";
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        NotificationService.getInstance().sendNotification(new Notification(message, timeStamp));
    }

    public void printQuizzes(Course course)
    {
        for(Quiz quiz: course.getQuizzes())
        {
            if (quiz != null)
            {
                System.out.println(quiz.getSubject());
                System.out.println("Questions: \n" + Arrays.toString(quiz.getQuestions()));
                System.out.println("Answers: \n" + Arrays.toString(quiz.getAnswers()));

            }
        }
    }
}
