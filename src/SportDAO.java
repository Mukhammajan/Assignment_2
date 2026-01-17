import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SportDAO {


    public void insertSport(Connection conn, String name, String category) throws SQLException {
        String sql = "INSERT INTO sport(name, category) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, category);
            ps.executeUpdate();
        }
    }


    public void showSports(Connection conn) throws SQLException {
        String sql = "SELECT id, name, category FROM sport ORDER BY id";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n--- SPORTS ---");
            boolean any = false;

            while (rs.next()) {
                any = true;
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String category = rs.getString("category");

                System.out.printf("%d) %s | %s%n", id, name, category);
            }

            if (!any) {
                System.out.println("(empty)");
            }
        }
    }


    public int updateSportName(Connection conn, int id, String newName) throws SQLException {
        String sql = "UPDATE sport SET name = ? WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newName);
            ps.setInt(2, id);
            return ps.executeUpdate(); // қанша жол өзгерді
        }
    }


    public int deleteSport(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM sport WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate(); // қанша жол өшті
        }
    }
}
