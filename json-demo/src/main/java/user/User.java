package user;

public class User {
    String name;
    String email;
    boolean isDeveloper;
    int age;

    // new, see below!
    UserAddress userAddress;

    public User(String name, String email, boolean isDeveloper, int age, UserAddress userAddress) {
        this.name = name;
        this.email = email;
        this.isDeveloper = isDeveloper;
        this.age = age;
        this.userAddress = userAddress;
    }
}
