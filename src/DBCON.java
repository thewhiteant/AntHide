import java.sql.*;

public class DBCON {
    void cmain() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
            conn = DriverManager.getConnection("jdbc:mysql://localhost/anthide","root", "");
            String quary = "SELECT `id`, `usename`, `password` FROM `logins` WHERE 1";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(quary);
            //Learning sql break
//            ResultSet rs = conn.

            while(rs.next()){
                System.out.println(rs.getString("usename")+" "+rs.getString("password"));
            }
            conn.close();
        }
        catch(Exception e) {
            System.out.print("Do not connect to DB - Error:"+e);
        }
    }
}