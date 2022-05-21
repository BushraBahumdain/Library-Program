/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dell
 */
public class admin {

    public String name;
    public String password;
    public String type;

    String URL = "jdbc:mysql://localhost:3306/library";
    String USERNAME = "root"; // use your username of Mysql server
    String PASSWORD = "bushra"; // use your password of Mysql server
    Connection connection = null;
    PreparedStatement preparedStmt = null;
    ResultSet resultSet = null;
    String sqlQuery = "";

    public admin() {
        connction();
    }

    private void connction() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement st = connection.createStatement();

        } catch (SQLException e) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DB_Connection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int search(String id, String pass) {
        int i = 0;
        try {

            Statement stt = connection.createStatement();
            ResultSet r = stt.executeQuery("select * from Admin where Username like '%" + id + "%' and Password like '%" + pass + "%'");

            if (!r.isBeforeFirst()) {
                System.out.println("NO DATA");

            } else if (r.next()) {
                String name = r.getString("Username");
                this.name = name;
                String pas = r.getString("Password");
                this.password = pas;
                String type = r.getString("type");
                this.type = type;
                i=1;

            }

        } catch (SQLException ex) {
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;

    }
}
