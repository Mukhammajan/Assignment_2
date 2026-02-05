/*import java.sql.Connection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // DIP: интерфейс арқылы жұмыс
        SportRepository repo = new SportDAO();
        SportService service = new SportService(repo);

        try (Connection conn = DBConnection.getConnection();
             Scanner sc = new Scanner(System.in)) {

            System.out.println("Connected!");

            // SRP: UI бөлек
            Menu menu = new Menu(sc);

            while (true) {
                int choice = menu.chooseOption();
                if (choice == 0) {
                    System.out.println("Bye ");
                    break;
                }

                try {
                    switch (choice) {

                        case 1 -> {
                            service.add(
                                    conn,
                                    menu.askSportName(),
                                    menu.askCategory()
                            );
                            System.out.println("Inserted!");
                        }

                        case 2 -> {
                            service.list(conn);
                        }

                        case 3 -> {
                            int updated = service.rename(
                                    conn,
                                    menu.askId(),
                                    menu.askNewName()
                            );
                            System.out.println("Updated rows: " + updated);
                        }

                        case 4 -> {
                            int deleted = service.remove(
                                    conn,
                                    menu.askId()
                            );
                            System.out.println("Deleted rows: " + deleted);
                        }

                        default -> System.out.println("Wrong option!");
                    }

                } catch (Exception e) {
                    System.out.println("Operation error: " + e.getMessage());
                }
            }

        } catch (Exception e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }
}
*/