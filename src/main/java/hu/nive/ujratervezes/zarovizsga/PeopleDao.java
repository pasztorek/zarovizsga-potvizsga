package hu.nive.ujratervezes.zarovizsga;

import org.mariadb.jdbc.MariaDbDataSource;
import java.sql.*;


public class PeopleDao {

    private MariaDbDataSource dataSource;


    public PeopleDao(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String findIpByName(String firstName, String lastName){
        String resultip="";

        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
            dataSource.setUser("employees");
            dataSource.setPassword("employees");
        }
        catch (SQLException se) {
            throw new IllegalStateException("Can not create data source", se);
        }

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT ip_address FROM people WHERE first_name = ? AND last_name = ?")) {

            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                resultip = rs.getString("ip_address");

            }

        } catch (SQLException se) {
            throw new IllegalStateException("Cannot select employees", se);
        }

         return resultip;
    }
}
