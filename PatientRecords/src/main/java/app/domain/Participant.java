package app.domain;

public class Participant {

    private String name;
    private String age;
    private String height;
    private String weight;
    private String bloodPressure;

    public Participant(String name, String age, String height, String weight, String bloodPressure) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.bloodPressure = bloodPressure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    @Override
    public String toString() {
        return String.format(
                "Participant[name='%s', age='%s', height='%s', weight='%s']",
                name, age, height, weight);
    }
}
