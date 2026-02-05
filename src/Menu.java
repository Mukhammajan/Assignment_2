import java.util.Scanner;

public class Menu {

    private final Scanner sc;

    public Menu(Scanner sc) {
        this.sc = sc;
    }

    public int chooseOption() {
        System.out.println("""
            =====================
              SPORT MANAGEMENT
            =====================
            1) INSERT sport
            2) SELECT sports
            3) UPDATE sport name
            4) DELETE sport
            0) Exit
            =====================
        """);
        System.out.print("Choose option: ");
        return sc.nextInt();
    }

    public String askSportName() {
        System.out.print("Sport name: ");
        return sc.next();
    }

    public String askCategory() {
        System.out.print("Category: ");
        return sc.next();
    }

    public int askId() {
        System.out.print("Sport id: ");
        return sc.nextInt();
    }

    public String askNewName() {
        System.out.print("New name: ");
        return sc.next();
    }
}
