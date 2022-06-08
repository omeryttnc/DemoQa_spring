package QA.Enums;

public enum Form2 {
    A_FORMU("asdasd","asdasd","adass"),
    B_FORMU("assa","sad","dsdsGGGGGGGGGGGG"),
    C_FORMU("sds","sds","dsds");

    private final String name;
    private final String Lastname;
    private final String password;

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

    public static class enumMethod{
        public static void denememethod(Form2 form2){
            switch (form2){
                case A_FORMU:
                case B_FORMU:
                case C_FORMU:
                    System.out.println(form2.password);
                    break;
            }
        }

    }
}
