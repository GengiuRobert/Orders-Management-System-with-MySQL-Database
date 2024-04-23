package Model;

/**
 * @Author: Gengiu Robert Constantin
 * @Since: Apr 20, 2024
 * Class where the client model is described
 */
public class Client {
    private int id;
    private String name;
    private String email;
    private int age;

    public Client() {
    }

    public Client(int id, String name, String email, int age) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Client(String name, String email, int age) {
        super();
        this.name = name;
        this.email = email;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }

}

