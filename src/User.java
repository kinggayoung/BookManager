public class User {
    String name;
    int age;
    char gender;

    public User(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public Object getUser(){
        return name + ", " + age + ", " + gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }
}
