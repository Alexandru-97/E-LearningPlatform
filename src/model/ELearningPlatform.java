package model;


import java.util.*;

public class ELearningPlatform {

    protected Category [] categories = new Category[100];
    protected Course [] courses = new Course [100];
    protected List<Teacher> teachers = new ArrayList<>();
    protected List<User> users = new ArrayList<>();

    public Category[] getCategories() {
        return categories;
    }

    public void setCategories(Category[] categories) {
        this.categories = categories;
    }

    public Course[] getCourses() {
        return courses;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
