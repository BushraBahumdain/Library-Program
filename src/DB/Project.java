/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
 * @author Ruba
 */
public class Project extends SourceProduct {

    FileWriter fw;
    BufferedWriter bw;
    public int Project_ID;
    public String Classification_number;
    public int Number_Of_copies_existed;
    public int Number_Of_actuel_copies;
    public String Judges;
    public String Relase_date;
    public int Pages;
    public String Label_Type;
    public String Label;
    public String Author;

    //database Variables
    String URL = "jdbc:mysql://localhost:3306/library";
    String USERNAME = "root"; // use your username of Mysql server
    String PASSWORD = "bushra"; // use your password of Mysql server
    Connection connection = null;
    PreparedStatement preparedStmt = null;
    ResultSet resultSet = null;
    String sqlQuery = "";

    public Project(String Classification_number, int Number_Of_actuel_copies, String Judges, String Relase_date, int Pages, String Label_Type, String Label, String Author) {
        this.Classification_number = Classification_number;
        Number_Of_copies_existed = Number_Of_actuel_copies;
        this.Number_Of_actuel_copies = Number_Of_actuel_copies;
        this.Judges = Judges;
        this.Relase_date = Relase_date;
        this.Pages = Pages;
        this.Label_Type = Label_Type;
        this.Label = Label;
        this.Author = Author;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement st = connection.createStatement();
//st.executeUpdate("INSERT INTO client"+" VALUES("+rn+","+this.phoneNum+",'"+this.name+"','"+this.email+"',"+this.licen+",'"+this.gender+"','"+this.password+"','"+this.userName+"')");

        } catch (SQLException e) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DB_Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Project() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement st = connection.createStatement();
//st.executeUpdate("INSERT INTO client"+" VALUES("+rn+","+this.phoneNum+",'"+this.name+"','"+this.email+"',"+this.licen+",'"+this.gender+"','"+this.password+"','"+this.userName+"')");

        } catch (SQLException e) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DB_Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addProject() {
        try {
            Statement st = connection.createStatement();
            int au1 = -1;
            if (this.Author != null) {
                au1 = this.searchForAuthor(this.Author);
            } else {
                au1 = 0;
            }
            st.executeUpdate("INSERT INTO project (Classification_number,Number_Of_copies_existed, Number_Of_actuel_copies, Judges, Relase_date, Pages, Label_Type, Label, Author)"
                    + "values('" + this.Classification_number + "'," + this.Number_Of_copies_existed + "," + this.Number_Of_actuel_copies + ",'" + this.Judges + "','" + this.Relase_date + "'," + this.Pages + ",'" + this.Label_Type + "','" + this.Label + "'," + au1 + ")");

//Project_ID, Classification_number, Number_Of_copies_existed, Number_Of_actuel _copies, Judges, Relase_date, Pages, Label_Type, Label, Author
        } catch (SQLException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int searchForAuthor(String a) {
        int author_num = -1;

        try {
            Statement stt = connection.createStatement();
            ResultSet r = stt.executeQuery("select * from author where name like '%" + a + "%'");

            //System.out.println(!r.isBeforeFirst());
            if (!r.isBeforeFirst()) {
                System.out.println("NO DATA");
                int rn = (int) (Math.random() * ((9999 - 3000 + 1) + 3000));
                Statement st1 = connection.createStatement();
                st1.executeUpdate("INSERT INTO author" + " VALUES(" + rn + ",'" + a + "')");
                author_num = rn;
            } else if (r.next()) {
                int an = r.getInt("ID");
                author_num = an;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

        return author_num;
    }
 public void updateProjectRecord(int copies_existed, int Project_id){
        
        try {
            
//Number_Of_actuel_copies, Number_Of_copies_existed, Print_Num, Pages, Label_type, Label, Classification_number, Book_ID, Author1, Author2, Author3, Riviser1, Riviser2, Riviser3, Trnaslator1, Trnaslator2, Trnaslator3, Publisher1, Publishing_Year
PreparedStatement update; 
update= connection.prepareStatement("update Project set Number_Of_copies_existed = ? WHERE Project_ID = ?");
update.setInt(1, copies_existed);
update.setInt(2, Project_id);
update.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public int updateProjectRecord1(int actuel_copies, int ID) {

        int num = 0;
        //0 for excting , 1 for actual
        int ActExt[] = getActExt(ID);
        // case 1: adding more copy 
        if (actuel_copies >= ActExt[1]) {
            num = actuel_copies - ActExt[1];
            ActExt[0] = ActExt[0] + num; // ext 
            ActExt[1] = actuel_copies; // act
            try {

                PreparedStatement update;
                update = connection.prepareStatement("UPDATE Project SET Number_Of_copies_existed = ?, Number_Of_actuel_copies = ? WHERE Project_id = ?");
                update.setInt(1, ActExt[0]);
                update.setInt(2, ActExt[1]);
                update.setInt(3, ID);
                update.executeUpdate();
                return 1; 

            } catch (SQLException ex) {
                Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (actuel_copies < ActExt[1]) {

            if (ActExt[0] == ActExt[1]) {
                try {

                    PreparedStatement update;
                    update = connection.prepareStatement("UPDATE Project SET Number_Of_copies_existed = ?, Number_Of_actuel_copies = ? WHERE Project_id = ?");
                    update.setInt(1, actuel_copies);
                    update.setInt(2, actuel_copies);
                    update.setInt(3, ID);
                    update.executeUpdate();
                            return 2;

                } catch (SQLException ex) {
                    Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                return 3; 
               // System.out.println("you CAN NOT");
            }
        } else {
            return 0;
            //System.out.println("some error occur ");
        }
        
        return 0;

    }
    public int[] getActExt(int id) {

        int n[] = new int[2];

        try {
            PreparedStatement st;
            st = connection.prepareStatement("select Number_Of_copies_existed, Number_Of_actuel_copies from Project where Project_id =?");
            st.setInt(1, id);
            ResultSet r = st.executeQuery();

            while (r.next()) {
                n[0] = r.getInt(1); // ext
                n[1] = r.getInt(2);// act
            }
            return n;
        } catch (SQLException ex) {
            Logger.getLogger(Messag.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
public boolean searchprojectID(int project_id){
    
        boolean id = false;
        try {
             Statement st = connection.createStatement();
            ResultSet r = st.executeQuery(" select project_id from project where Project_id ="+project_id);

            if (!r.isBeforeFirst()) {//the reuslt will be in string bilder to retrive all book in book table 
 id=false;
            }else{
                id=true;
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //search.close();
        }
        return id;
}
public String searchprojectlabel(int id){
            String label = "";

        try {
            Statement st = connection.createStatement();
            ResultSet r = st.executeQuery("select * from project where project_id = " +id );
while(r.next()){
    String name=r.getString("label");
    label=name;
}

        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        return label;
}
    public void deleteProjectRecord(int Project_id) {
        try {
            PreparedStatement delete = connection.prepareStatement("DELETE FROM Project WHERE Project_id = ?");
            delete.setInt(1, Project_id);
            delete.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String searchForAllProject() {
        PreparedStatement search = null;
        String message = "";
        try {

            search = connection.prepareStatement("select label, Project_id, Classification_number, Number_Of_actuel_copies from Project");
            ResultSet r = search.executeQuery();
            while (r.next()) {//the reuslt will be in string bilder to retrive all book in book table 

                message = message + "\n" + "اسم المشروع : " + r.getString(1) + " \n " + "الرقم العام: " + r.getInt(2) + " \n " + "رقم التصنيف: " + r.getString(3) + " \n " + "عدد النسخ: " + r.getInt(4)+"\nـــــــــــــــــــــــــــ";
                System.out.println(message);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //search.close();
        }
        return message;
    }

    public String serachForProjectUsingID1(int Project_id) {
        String message = "";
        PreparedStatement search = null;
        try {
            //label, book_id,class,exited
            search = connection.prepareStatement("select label, project_id, Classification_number, Number_Of_copies_existed, Number_Of_actuel_copies from Project where project_id =" + Project_id);
            ResultSet r = search.executeQuery();
            while (r.next()) {//the reuslt will be in string bilder to retrive all book in book table 
                String label = r.getString(1);
                this.Label = label;
                int id = r.getInt(2);
                this.Project_ID = id;
                String clas = r.getString(3);
                this.Classification_number = clas;
                int existed = r.getInt(4);
                this.Number_Of_copies_existed = existed;
                int actual = r.getInt(5);
                this.Number_Of_actuel_copies = actual;

                message = message + "\n" + "اسم المشروع : " + r.getString(1) + " \n " + "الرقم العام: " + r.getInt(2) + " \n " + "رقم التصنيف: " + r.getString(3) + " \n " + "عدد النسخ: " + r.getInt(4)+"\nـــــــــــــــــــــــــــ";
                System.out.println(message);

                //here you can get data, the '1' indicates column number based on your query
                System.out.println(message);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
    }

    public String serachForProjectUsingClassification_number1(String Classification_number) {
        PreparedStatement search = null;
        String message = "";
        try {
            //label, book_id,class,exited
            search = connection.prepareStatement("select label, Project_id, Classification_number, Number_Of_actuel_copies, Number_Of_copies_existed from Project where Classification_number like '%" + Classification_number.trim() + "%'");
            ResultSet r = search.executeQuery();
            while (r.next()) {//the reuslt will be in string bilder to retrive all book in book table 
                String label = r.getString(1);
                this.Label = label;
                int id = r.getInt(2);
                this.Project_ID = id;
                String clas = r.getString(3);
                this.Classification_number = clas;
                int existed = r.getInt(5);
                this.Number_Of_copies_existed = existed;
                int actual = r.getInt(4);
                this.Number_Of_actuel_copies = actual;

                message = message + "\n" + "اسم المشروع : " + r.getString(1) + " \n " + "الرقم العام: " + r.getInt(2) + " \n " + "رقم التصنيف: " + r.getString(3) + " \n " + "عدد النسخ: " + r.getInt(4)+"\nـــــــــــــــــــــــــــ";
                System.out.println(message);

                //here you can get data, the '1' indicates column number based on your query
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
    }
    public String serachForProjectUsingID(int Project_id) {
        String message = null;
        PreparedStatement search = null;
        try {
            //label, book_id,class,exited
            search = connection.prepareStatement("select label, project_id, Classification_number, Number_Of_copies_existed, Number_Of_actuel_copies from Project where project_id =" + Project_id);
            ResultSet r = search.executeQuery();
            while (r.next()) {//the reuslt will be in string bilder to retrive all book in book table 
                String label = r.getString(1);
                this.Label = label;
                int id = r.getInt(2);
                this.Project_ID = id;
                String clas = r.getString(3);
                this.Classification_number = clas;
                int existed = r.getInt(4);
                this.Number_Of_copies_existed = existed;
                int actual = r.getInt(5);
                this.Number_Of_actuel_copies = actual;

                message = message + "\n" + r.getString(1) + "  |  " + r.getInt(2) + "  |  " + r.getString(3) + "  |  " + r.getInt(4); //here you can get data, the '1' indicates column number based on your query
                System.out.println(message);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
    }

    public String serachForProjectUsingClassification_number(String Classification_number) {
        PreparedStatement search = null;
        String message = null;
        try {
            //label, book_id,class,exited
            search = connection.prepareStatement("select label, Project_id, Classification_number, Number_Of_actuel_copies, Number_Of_copies_existed from Project where Classification_number like '%" + Classification_number.trim() + "%'");
            ResultSet r = search.executeQuery();
            while (r.next()) {//the reuslt will be in string bilder to retrive all book in book table 
                String label = r.getString(1);
                this.Label = label;
                int id = r.getInt(2);
                this.Project_ID = id;
                String clas = r.getString(3);
                this.Classification_number = clas;
                int existed = r.getInt(5);
                this.Number_Of_copies_existed = existed;
                int actual = r.getInt(4);
                this.Number_Of_actuel_copies = actual;
                message = message + "\n" + r.getString(1) + "  |  " + r.getInt(2) + "  |  " + r.getString(3) + "  |  " + r.getInt(4); //here you can get data, the '1' indicates column number based on your query

            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
    }

    public int getProject_ID(String label) {
        int Journal_id = -1;
        try {
            Statement st = connection.createStatement();
            ResultSet r = st.executeQuery("select Project_id from Project where label like '%" + label.trim() + "%'");
            while (r.next()) {
                Journal_id = r.getInt("PRoject_id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Journal_id;
    }

    public void printReport(String name) {

        try {
            // create file 
            // String name = f.getAbsolutePath();
            fw = new FileWriter(name);

            // open buffer writer
            bw = new BufferedWriter(fw);

            // variables to save r results 
            String string;
            String author = "";
            int num = 0;

            // colomn lables 
            bw.write("أسم المشروع" + "\tالمؤلف" + "\tالرقم العام" + "\tرقم التصنيف" + "\tعدد النسخ" + "\t عدد النسخ المتبقية");
            bw.newLine();

            // retrive data
            PreparedStatement st = connection.prepareStatement("select Label ,Author ,Project_ID ,Classification_number, Number_Of_actuel_copies, Number_Of_copies_existed from project");
            ResultSet r = st.executeQuery();
            while (r.next()) {
                // book name 
                string = r.getString(1);
                bw.write(string + "\t");

                // save author name if there id not 0, becouse 0 means no one 
                // author name
                num = r.getInt(2);
                if (num != 0) {
                    author = getAuthours(num);
                }

                // print author name 
                bw.write(author + "\t");
                // print book id 
                bw.write("P-" + r.getInt(3) + "\t");
                // print classification number
                bw.write(r.getString(4));
                // print book copies 
                bw.write("\t" + r.getInt(5));
                bw.write("\t" + r.getInt(6));
                bw.newLine();
            }

            bw.close();

        } catch (IOException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getAuthours(int id) {

        String str = "";

        try {

            PreparedStatement st = connection.prepareStatement("select name from author where ID =?");
            st.setInt(1, id);
            ResultSet r = st.executeQuery();
            while (r.next()) {
                str = r.getString(1);
                //System.out.println(str+"while");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        }

        return str;

    }

}
