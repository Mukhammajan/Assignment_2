import java.util.Objects;

public class Athlete extends Person {
    private String sport;
    private int age;

    public Athlete(int id, String name, String sport, int age) {
        super(id, name);
        this.sport = sport;
        this.age = age;
    }

    public String getSport() { return sport; }
    public int getAge() { return age; }

    @Override
    public String getRole() {
        return "Athlete";
    }


    @Override
    public String toString() {
        return "Athlete{id=" + getId() +
                ", name='" + getName() + '\'' +
                ", sport='" + sport + '\'' +
                ", age=" + age + '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Athlete)) return false;
        Athlete athlete = (Athlete) o;
        return getId() == athlete.getId();
    }

    // hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

