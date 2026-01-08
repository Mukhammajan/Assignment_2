import java.util.*;

public class SportsClub {
    private List<Athlete> athletes = new ArrayList<>();

    public void addAthlete(Athlete athlete) {
        athletes.add(athlete);
    }


    public void filterBySport(String sport) {
        athletes.stream()
                .filter(a -> a.getSport().equalsIgnoreCase(sport))
                .forEach(System.out::println);
    }


    public Athlete searchById(int id) {
        for (Athlete a : athletes) {
            if (a.getId() == id) return a;
        }
        return null;
    }


    public void sortByAge() {
        athletes.sort(Comparator.comparingInt(Athlete::getAge));
    }

    public void showAll() {
        athletes.forEach(System.out::println);
    }
}
