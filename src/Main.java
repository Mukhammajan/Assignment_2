import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SportDAO dao = new SportDAO();

        try (Connection conn = DBConnection.getConnection();
             Scanner sc = new Scanner(System.in)) {

            System.out.println("Connected!");

            while (true) {
                System.out.println("""
                    1) INSERT sport
                    2) SELECT sports
                    3) UPDATE sport name
                    4) DELETE sport
                    0) Exit
                """);

                System.out.print("Choose: ");
                int c = sc.nextInt();

                if (c == 0) break;

                switch (c) {
                    case 1 -> {
                        System.out.print("Sport name: ");
                        String name = sc.next();
                        System.out.print("Category: ");
                        String cat = sc.next();
                        dao.insertSport(conn, name, cat);
                        System.out.println("Inserted!");
                    }
                    case 2 -> dao.showSports(conn);

                    case 3 -> {
                        System.out.print("Sport id: ");
                        int id = sc.nextInt();
                        System.out.print("New name: ");
                        String newName = sc.next();
                        System.out.println("Updated rows: " + dao.updateSportName(conn, id, newName));
                    }
                    case 4 -> {
                        System.out.print("Sport id: ");
                        int id = sc.nextInt();
                        System.out.println("Deleted rows: " + dao.deleteSport(conn, id));
                    }
                    default -> System.out.println("Wrong option!");
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
