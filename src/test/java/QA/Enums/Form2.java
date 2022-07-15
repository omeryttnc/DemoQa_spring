package QA.Enums;

public enum Form2 {

    ;

    private String name;
    private String Lastname;
    private String password;

    Form2(String name, String lastname, String password) {
        this.name = name;
        Lastname = lastname;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return Lastname;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Form2{" +
                "name='" + name + '\'' +
                ", Lastname='" + Lastname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
