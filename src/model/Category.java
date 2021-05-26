package model;

public class Category {

    private int id;
    private String Name;

    public Category() {

    }

    public Category(String name) {
        this.Name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
