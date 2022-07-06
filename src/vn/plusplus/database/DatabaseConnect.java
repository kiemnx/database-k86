package vn.plusplus.database;

import java.sql.*;

public class DatabaseConnect {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/store_cms_plusplus", "root", "1234");
            //here forum_zclouds is database name, root is username and 1234 is password
            Statement stmt = con.createStatement();

            DatabaseConnect main = new DatabaseConnect();


            ResultSet rs = main.findLaptopByMakerAndPrice("ASUS", 5000000l, 30000000l, stmt);
            while (rs.next()){
                System.out.println(rs.getString("name") + ", " + rs.getString("maker") + ", " + rs.getLong("price"));
            }

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public ResultSet findLaptopByMakerAndPrice(String maker, Long fromPrice, Long toPrice, Statement statement){
        String querySQL = "SELECT * FROM laptop WHERE maker='"+maker+"' AND price BETWEEN "+fromPrice+" AND "+toPrice+";";
        System.out.println(querySQL);
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(querySQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
