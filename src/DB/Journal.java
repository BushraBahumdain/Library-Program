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
public class Journal extends SourceProduct {

    FileWriter fw;
    BufferedWriter bw;
    public int Number_Of_actuel_copies;//done
    public int Number_Of_copies_existed;
    public String Classification_number;//
    public String Start_Date;//
    public String End_Date;//
    public int Pages;//
    int Parts;
    public String Label;//
    public String Label_type;//
    public String Type_of_relase;//
    public int Journal_ID;
    public String Publisher;//
    public int Publishing_Year;//
    public String city;//
    //database Variables
    String URL = "jdbc:mysql://localhost:3306/library";
    String USERNAME = "root"; // use your username of Mysql server
    String PASSWORD = "bushra"; // use your password of Mysql server
    Connection connection = null;
    PreparedStatement preparedStmt = null;
    ResultSet resultSet = null;
    String sqlQuery = "";

    public Journal() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement st = connection.createStatement();

        } catch (SQLException e) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DB_Connection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Journal(int Number_Of_actuel_copies, String Classification_number, String Start_Date, String End_Date, int Pages, String Label, String Label_type, String Type_of_relase, String Publisher, int Publishing_Year, String city,int Parts) {
        this.Number_Of_actuel_copies = Number_Of_actuel_copies;
        Number_Of_copies_existed = Number_Of_actuel_copies;
        this.Classification_number = Classification_number;
        this.Start_Date = Start_Date;
        this.End_Date = End_Date;
        this.Pages = Pages;
        this.Parts = Parts;
        this.Label = Label;
        this.Label_type = Label_type;
        this.Type_of_relase = Type_of_relase;
        this.Publisher = Publisher;
        this.Publishing_Year = Publishing_Year;
        this.city = city;
        try {
             Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement st = connection.createStatement();

        } catch (SQLException e) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DB_Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addJournal() {
        try {
            int puPlace = -1;
            if (this.Publisher != null) {
                puPlace = this.searchForpublishPlace(this.Publisher);
            } else {
                puPlace = 0;
            }
            Statement st = connection.createStatement();
            //Number_Of_actuel_copies, Classification_number, Start_Date, End_Date, Pages, Parts, Label, Label_type, Type_of_relase, Publisher, Publishing_Year
            st.executeUpdate("INSERT INTO journal (Number_Of_actuel_copies,Number_Of_copies_existed, Classification_number, Start_Date, End_Date, Pages, Label, Label_type, Type_of_relase, Publisher, Publishing_Year, Parts)"
                    + "values(" + this.Number_Of_actuel_copies + "," + this.Number_Of_copies_existed + ",'" + this.Classification_number + "','" + this.Start_Date + "','" + this.End_Date + "'," + this.Pages + ",'" + this.Label + "','" + this.Label_type + "','" + this.Type_of_relase + "'," + puPlace + "," + this.Publishing_Year +","+this.Parts + ")");

        } catch (SQLException ex) {
            Logger.getLogger(Journal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int searchForpublishPlace(String pu) {
        int pub_num = -1;

        try {
            Statement st = connection.createStatement();
            ResultSet r = st.executeQuery("select * from publisher where name like '%" + pu.trim() + "%'");

            if (!r.isBeforeFirst()) {
                System.out.println("NO DATA");
                int rn = (int) (Math.random() * ((9999 - 3000 + 1) + 3000));
                Statement st1 = connection.createStatement();
                st1.executeUpdate("INSERT INTO publisher" + " VALUES('" + pu + "'," + rn + ",'" + this.city + "')");
                pub_num = rn;
            } else if (r.next()) {
                int an = r.getInt("ID");
                pub_num = an;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pub_num;
    }
public void updateJournalRecord(int copies_existed, int Journal_id){
        
        try {
            
//Number_Of_actuel_copies, Number_Of_copies_existed, Print_Num, Pages, Label_type, Label, Classification_number, Book_ID, Author1, Author2, Author3, Riviser1, Riviser2, Riviser3, Trnaslator1, Trnaslator2, Trnaslator3, Publisher1, Publishing_Year
PreparedStatement update; 
update= connection.prepareStatement("update Journal set Number_Of_copies_existed = ? WHERE Journal_ID = ?");
update.setInt(1, copies_existed);
update.setInt(2, Journal_id);
update.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public int updateJournalRecord1(int actuel_copies, int ID) {
        
        
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
                update = connection.prepareStatement("UPDATE Journal SET Number_Of_copies_existed = ?, Number_Of_actuel_copies = ? WHERE Journal_ID = ?");
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
                    update = connection.prepareStatement("UPDATE Journal SET Number_Of_copies_existed = ?, Number_Of_actuel_copies = ? WHERE Journal_ID = ?");
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
                //System.out.println("you CAN NOT");
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
            st = connection.prepareStatement("select Number_Of_copies_existed, Number_Of_actuel_copies from Journal where Journal_ID =?");
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
public boolean searchjornalID(int journal_id){
    
        boolean id = false;
        try {
             Statement st = connection.createStatement();
            ResultSet r = st.executeQuery(" select Journal_id from journal where Journal_id ="+journal_id);

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
public String searchjournallabel(int id){
            String label = "";

        try {
            Statement st = connection.createStatement();
            ResultSet r = st.executeQuery("select * from Journal where Journal_id = " +id );
while(r.next()){
    String name=r.getString("label");
    label=name;
}

        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        return label;
}
    public void deleteJournalRecord(int Journal_id) {
        try {
            PreparedStatement delete = connection.prepareStatement("DELETE FROM Journal WHERE Journal_id = ?");
            delete.setInt(1, Journal_id);
            delete.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

     public String searchForAllJournal(){
          PreparedStatement search=null;
          String message="";
        try {
          
            search = connection.prepareStatement("select label, Journal_id, Classification_number, Number_Of_actuel_copies from Journal");
            ResultSet r=search.executeQuery();
            while(r.next())
            {//the reuslt will be in string bilder to retrive all book in book table 
              message=message+"\n"+"اسم الدورية : "+r.getString(1)+" \n "+"الرقم العام: "+r.getInt(2)+" \n "+"رقم التصنيف: "+r.getString(3)+" \n "+"عدد النسخ: "+r.getInt(4)+"\n ـــــــــــــــــــــــــــ";

            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //search.close();
        }
    return message;}

     public String serachForJournalUsingID1(int Journal_id){
         String message="";
         PreparedStatement search=null;
        try {
            //label, book_id,class,exited
            search = connection.prepareStatement("select label, Journal_id, Classification_number, Number_Of_actuel_copies, Number_Of_copies_existed from Journal where Journal_id ="+Journal_id);
            ResultSet r=search.executeQuery();
            while(r.next())
            {//the reuslt will be in string bilder to retrive all book in book table 
                String label = r.getString(1);
                this.Label = label;
                int id = r.getInt(2);
                this.Journal_ID =id;
               String clas = r.getString(3);
               this.Classification_number = clas;
               int actual = r.getInt(4);
               this.Number_Of_actuel_copies=actual;
               int existed = r.getInt(5);
               this.Number_Of_copies_existed=existed;
               message=message+"\n"+"اسم الدورية : "+r.getString(1)+" \n "+"الرقم العام: "+r.getInt(2)+" \n "+"رقم التصنيف: "+r.getString(3)+" \n "+"عدد النسخ: "+r.getInt(4)+"\n ـــــــــــــــــــــــــــ";
               System.out.println(message);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return message;}
    public String serachForJournalUsingClassification_number1(String Classification_number){
         PreparedStatement search=null;
         String message="";
        try {
            //label, book_id,class,exited
            search = connection.prepareStatement("select label, Journal_id, Classification_number, Number_Of_actuel_copies, Number_Of_copies_existed from Journal where Classification_number like '%"+Classification_number.trim()+"%'");
            ResultSet r=search.executeQuery();
            while(r.next())
            {//the reuslt will be in string bilder to retrive all book in book table 
                 String label = r.getString(1);
                this.Label = label;
                int id = r.getInt(2);
                this.Journal_ID =id;
               String clas = r.getString(3);
               this.Classification_number = clas;
               int actual = r.getInt(4);
               this.Number_Of_actuel_copies=actual;
               int existed = r.getInt(5);
               this.Number_Of_copies_existed=existed;
                
               message=message+"\n"+"اسم الدورية : "+r.getString(1)+" \n "+"الرقم العام: "+r.getInt(2)+" \n "+"رقم التصنيف: "+r.getString(3)+" \n "+"عدد النسخ: "+r.getInt(4)+"\nـــــــــــــــــــــــــــ ";;

            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return message;
    }

    public String serachForJournalUsingID(int Journal_id) {
        String message = null;
        PreparedStatement search = null;
        try {
            //label, book_id,class,exited
            search = connection.prepareStatement("select label, Journal_id, Classification_number, Number_Of_actuel_copies, Number_Of_copies_existed from Journal where Journal_id =" + Journal_id);
            ResultSet r = search.executeQuery();
            while (r.next()) {//the reuslt will be in string bilder to retrive all book in book table 
                String label = r.getString(1);
                this.Label = label;
                int id = r.getInt(2);
                this.Journal_ID = id;
                String clas = r.getString(3);
                this.Classification_number = clas;
                int actual = r.getInt(4);
                this.Number_Of_actuel_copies = actual;
                int existed = r.getInt(5);
                this.Number_Of_copies_existed = existed;
                message = message + "\n" + r.getString(1) + "  |  " + r.getInt(2) + "  |  " + r.getString(3) + "  |  " + r.getInt(4); //here you can get data, the '1' indicates column number based on your query
                System.out.println(message);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
    }

    public String serachForJournalUsingClassification_number(String Classification_number) {
        PreparedStatement search = null;
        String message = null;
        try {
            //label, book_id,class,exited
            search = connection.prepareStatement("select label, Journal_id, Classification_number, Number_Of_actuel_copies, Number_Of_copies_existed from Journal where Classification_number like '%" + Classification_number.trim() + "%'");
            ResultSet r = search.executeQuery();
            while (r.next()) {//the reuslt will be in string bilder to retrive all book in book table 
                String label = r.getString(1);
                this.Label = label;
                int id = r.getInt(2);
                this.Journal_ID = id;
                String clas = r.getString(3);
                this.Classification_number = clas;
                int actual = r.getInt(4);
                this.Number_Of_actuel_copies = actual;
                int existed = r.getInt(5);
                this.Number_Of_copies_existed = existed;

                message = message + "\n" + r.getString(1) + "  |  " + r.getInt(2) + "  |  " + r.getString(3) + "  |  " + r.getInt(4); //here you can get data, the '1' indicates column number based on your query

            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
    }

    public int getJournal_ID(String label) {
        int Journal_id = -1;
        try {
            Statement st = connection.createStatement();
            ResultSet r = st.executeQuery("select Journal_id from Journal where label like '%" + label.trim() + "%'");
            while (r.next()) {
                Journal_id = r.getInt("Journal_id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Journal_id;
    }

    public void printReport(String name) {

        try {
            // create file 
            //String name = f.getAbsolutePath();
            fw = new FileWriter(name);

            // open buffer writer
            bw = new BufferedWriter(fw);

            // variables to save r results 
            String string;
            String publisherName = "";
            int num = 0;

            // colomn lables 
            bw.write("أسم الدورية " + "\tالناشر" + "\tالرقم العام" + "\tرقم التصنيف" + "\tعدد النسخ" + "\t عدد النسخ المتبقية");
            bw.newLine();

            // retrive data
            PreparedStatement st = connection.prepareStatement("select Label ,Publisher ,Journal_ID ,Classification_number, Number_Of_actuel_copies, Number_Of_copies_existed from journal");
            ResultSet r = st.executeQuery();
            while (r.next()) {
                // journal name 
                string = r.getString(1);
                bw.write(string + "\t");

                num = r.getInt(2);
                if (num != 0) {
                    publisherName = getpublishName(num);
                }
                // print author name 
                bw.write(publisherName + "\t");
                // print book id 
                bw.write("J-" + r.getInt(3) + "\t");
                // print classification number
                bw.write(r.getString(4));
                // print book copies 
                bw.write("\t" + r.getInt(5));
                bw.write("\t" + r.getInt(6));
                bw.newLine();
            }

            bw.close();

        } catch (IOException ex) {
            Logger.getLogger(Journal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Journal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getpublishName(int id) {

        String pub = ""; // save auther name to send to bufferwriter

        try {

            PreparedStatement st = connection.prepareStatement("select name from publisher where ID =?");
            st.setInt(1, id);
            ResultSet r = st.executeQuery();
            while (r.next()) {
                pub = r.getString(1);
                //System.out.println(str+"while");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pub;

    }

}
