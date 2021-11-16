package hb01_bi;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni";
        String user = "hbstudent";
        String pass = "hbstudent";

        try {
            Connection conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Done");

        } catch (Exception e) { e.printStackTrace(); }
    }
}
