import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReturnBookDao {
    public static int delete(String bookcallno, int studentid) {
        int status = 0;
        try {
            Connection con = DB.getConnection();

            status = updateBook(bookcallno); // updating quantity and issue

            if (status > 0) {
                PreparedStatement ps = con.prepareStatement("DELETE FROM issuebooks WHERE bookcallno=? AND studentid=?");
                ps.setString(1, bookcallno);
                ps.setInt(2, studentid);
                status = ps.executeUpdate();
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static int updateBook(String bookcallno) {
        int status = 0;
        int quantity = 0, issued = 0;
        try {
            Connection con = DB.getConnection();

            PreparedStatement ps = con.prepareStatement("SELECT quantity, issued FROM books WHERE callno=?");
            ps.setString(1, bookcallno);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                quantity = rs.getInt("quantity");
                issued = rs.getInt("issued");
            }

            if (issued > 0) {
                PreparedStatement ps2 = con.prepareStatement("UPDATE books SET quantity=?, issued=? WHERE callno=?");
                ps2.setInt(1, quantity + 1);
                ps2.setInt(2, issued - 1);
                ps2.setString(3, bookcallno);

                status = ps2.executeUpdate();
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
}
