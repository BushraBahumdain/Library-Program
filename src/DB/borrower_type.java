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
 * @author amani
 */
public class borrower_type {

    public int ID;
    public String type;
    public int dayes;
    public int quantity;

    String URL = "jdbc:mysql://localhost:3306/library";
    String USERNAME = "root"; // use your username of Mysql server
    String PASSWORD = "bushra"; // use your password of Mysql server
    Connection connection = null;
    PreparedStatement preparedStmt = null;
    ResultSet resultSet = null;
    String sqlQuery = "";

    public borrower_type(int ID, String type, int dayes, int quantity) {
        this.ID = ID;
        this.type = type;
        this.dayes = dayes;
        this.quantity = quantity;
    }

    public borrower_type() {
    }

    public void search(int type) {
        try {
            connction();
            Statement stt = connection.createStatement();
            ResultSet r = stt.executeQuery("select * from borrowing_constraints where ID=" + type + "");
            if (!r.isBeforeFirst()) {
                System.out.println("Error123");
            } else if (r.next()) {
                int an = r.getInt("ID");
                this.ID = an;
                String typeS = r.getString("Borrower_Type");
                this.type = typeS;
                int dayes = r.getInt("Borrowing_Days");
                this.dayes = dayes;
                int qun = r.getInt("Borrowing_quantity");
                this.quantity = qun;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int edit(String Borrower_Type, int days, int id, int qnt) {
        int i = 0;
        try {
            connction();
            Statement stt = connection.createStatement();
             PreparedStatement update; 
            update= connection.prepareStatement("update borrowing_constraints set Borrower_Type=? , Borrowing_Days=?,Borrowing_quantity=? WHERE ID = ?");
          
                update.setString(1, Borrower_Type);
                update.setInt(2, days);
                update.setInt(3, qnt);
                update.setInt(4, id);
                update.executeUpdate();
                i = 1;
          
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;

    }
    
    
      public int add(String type, int dayes, int qnt) {
        int Bnum = 0;

        try {
            int i=search2(this.type);
            
            if (i==0) {
                System.out.println("adding in progress");
               
                Statement st1 = connection.createStatement();
                st1.executeUpdate("INSERT INTO borrowing_constraints(Borrower_Type,Borrowing_Days,Borrowing_quantity)values('" + type + "','" + dayes + "','" + qnt + "');");
                Bnum = 1;
            } else if (i==1) {
                Bnum = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Bnum;
    }
    

    public int search2(String type) {
        int i=0;
        try {
            connction();
            Statement stt = connection.createStatement();
            ResultSet r = stt.executeQuery("select * from borrowing_constraints where Borrower_Type like '%" + type + "%'");
            if (!r.isBeforeFirst()) {
                System.out.println("Error123");
                
            } else if (r.next()) {
                int an = r.getInt("ID");
                this.ID = an;
                String typeS = r.getString("Borrower_Type");
                this.type = typeS;
                int dayes = r.getInt("Borrowing_Days");
                this.dayes = dayes;
                int qun = r.getInt("Borrowing_quantity");
                this.quantity = qun;
                i=1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }return i;

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

    public String search3() {
        String message = "";
        PreparedStatement search = null;
        try {
            connction();
            search = connection.prepareStatement("select * from borrowing_constraints");
            ResultSet r = search.executeQuery();
            while (r.next()) {
                int an = r.getInt("ID");
                this.ID = an;
                String typeS = r.getString("Borrower_Type");
                this.type = typeS;
                int dayes = r.getInt("Borrowing_Days");
                this.dayes = dayes;
                int qun = r.getInt("Borrowing_quantity");
                this.quantity = qun;
                message = message + "\n" + type;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;

    }

}
