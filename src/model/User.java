package model;

public class User implements Comparable<User>{

    private int id;
    private String name;
    protected boolean isPremium;

    public User(String name, Boolean isPremium) {
        this.name = name;
        this.isPremium = isPremium;
    }
    public User(String name){
        this.name = name;
    }

    public User(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }


    @Override
    public int compareTo(User user)
    {
        if(this.name.charAt(0) > user.name.charAt(0))
        {
            return 1;
        }
        else if (this.name.charAt(0) == user.name.charAt(0))
        {
            return 0;
        }
        else
        {
            return -1;
        }
    }
}
