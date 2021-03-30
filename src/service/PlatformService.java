package service;

import model.*;

import java.util.Arrays;

public class PlatformService
{

    public void addUser(ELearningPlatform platform, User user)
    {
        int len = platform.getUsers().length;
        User [] aux = new User [len + 1];
        for (int i = 0; i < len; i++)
            aux[i] = platform.getUsers()[i];
        aux[len] = user;
        platform.setUsers(aux);
    }

    public void printUsers(ELearningPlatform platform)
    {
        for(User user: platform.getUsers())
        {
            if (user != null)
            {
                System.out.println(user.getName());
                if (user.isPremium() == true)
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

    public void addTeacher(ELearningPlatform platform, Teacher teacher)
    {
        int len = platform.getTeachers().length;
        Teacher [] aux = new Teacher [len + 1];
        for (int i = 0; i < len; i++)
            aux[i] = platform.getTeachers()[i];
        aux[len] = teacher;
        platform.setTeachers(aux);
    }

    public void addCategory(ELearningPlatform platform, Category category)
    {
        int len = platform.getCategories().length;
        Category [] aux = new Category [len + 1];
        for (int i = 0; i < len; i++)
            aux[i] = platform.getCategories()[i];
        aux[len] = category;
        platform.setCategories(aux);
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
