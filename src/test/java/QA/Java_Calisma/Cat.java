package QA.Java_Calisma;

public class Cat extends Animal{
    private String litterPreference;

    public Cat(String litterPreference) {
        this.litterPreference = litterPreference;
    }

    public Cat() {

    }

    public String getLitterPreference() {
        return litterPreference;
    }

    public void setLitterPreference(String litterPreference) {
        this.litterPreference = litterPreference;
    }
}
