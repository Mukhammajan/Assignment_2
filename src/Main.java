import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SportsClub club = new SportsClub();

        System.out.print("number of athletes: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("ID: ");
            int id = scanner.nextInt();

            System.out.print("Name: ");
            String name = scanner.next();

            System.out.print("Sport: ");
            String sport = scanner.next();

            System.out.print("Age: ");
            int age = scanner.nextInt();

            Athlete athlete = new Athlete(id, name, sport, age);
            club.addAthlete(athlete);
        }

        System.out.println("\nall players:");
        club.showAll();

        System.out.println("\nsortet by age ");
        club.sortByAge();
        club.showAll();

        System.out.print("\n for find input ID ");
        int searchId = scanner.nextInt();
        Athlete found = club.searchById(searchId);

        System.out.println(found != null ? found : "not foundet");

        System.out.print("\nsport name ");
        String filterSport = scanner.next();
        club.filterBySport(filterSport);
    }
}
