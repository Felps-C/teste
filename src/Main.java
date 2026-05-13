import db.DB;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = DB.getconnection();

            st = conn.createStatement();

            rs = st.executeQuery("select * from department");

            while (rs.next()){
                System.out.println(rs.getInt("Id"
                        )+ " - " +rs.getString("Name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            conn = DB.getconnection();

            st = conn.createStatement();

            rs = st.executeQuery("select * from seller");

            while (rs.next()){
                System.out.println(rs.getInt("Id")+ " - " +rs.getString("Name")+" - "+ rs.getString("Email")+ " - " + rs.getDate("BirthDate")+ " - "+ rs.getDouble("BaseSalary")+" - "+ rs.getInt("DepartmentId"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
            DB.closeConection();
        }
    }
}