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
public class Book extends SourceProduct {

    FileWriter fw;
    BufferedWriter bw;
    public String Classification_number;
    public String lable;//*
    public String author1;//* separate table , search before adding 
    public String author2;//*
    public String author3;//*
    public String translator1;//*
    public String translator2;//*
    public String translator3;//*
    public String reviser1;//*
    public String reviser2;//*
    public String reviser3;//*
    public int print;//*
    public String publisher1;//* with author table,  search before adding  
    public String publisher2;//*
    public String city;//*seperate table
    public int Publishing_Year;//*
    public int pages;//*
    public int book_ID;//*
    public String label_type;//*
    public int Number_Of_copies_existed;
    public int Number_Of_actuel_copies;
    //database Variables
    String URL = "jdbc:mysql://localhost:3306/library";
    String USERNAME = "root"; // use your username of Mysql server
    String PASSWORD = "bushra"; // use your password of Mysql server
    Connection connection = null;
    PreparedStatement preparedStmt = null;
    ResultSet resultSet = null;
    String sqlQuery = "";

    public Book() {
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

    public Book(String Classification_number, String lable, String author1, String author2, String author3, String translator1, String translator2, String translator3, String reviser1, String reviser2, String reviser3, int print, String publisher1, String city, int Publishing_Year, int pages, String label_type, int Number_Of_actuel_copies) {
        this.Classification_number = Classification_number;
        this.lable = lable;
        this.author1 = author1;
        this.author2 = author2;
        this.author3 = author3;
        this.translator1 = translator1;
        this.translator2 = translator2;
        this.translator3 = translator3;
        this.reviser1 = reviser1;
        this.reviser2 = reviser2;
        this.reviser3 = reviser3;
        this.print = print;
        this.publisher1 = publisher1;
        this.city = city;
        this.Publishing_Year = Publishing_Year;
        this.pages = pages;
        this.label_type = label_type;
        this.Number_Of_actuel_copies = Number_Of_actuel_copies;
          Number_Of_copies_existed= Number_Of_actuel_copies;
        //this.book_ID=book_ID+1;
        //int rn = (int) (Math.random() * ((3000 - 1 + 1) + 1));
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

    public void addBookNEW() {
        try {

            int au1 = -1, au2 = -1, au3 = -1;
            if (this.author1 != null) {
                au1 = this.searchForAuthor(this.author1);
            } else {
                au1 = 0;
            }
            if (this.author2 != null) {
                au2 = this.searchForAuthor(this.author2);
            } else {
                au2 = 0;
            }

            if (this.author3 != null) {
                au3 = this.searchForAuthor(this.author3);
            } else {
                au3 = 0;
            }
            //search for translators
            int tr1 = -1, tr2 = -1, tr3 = -1;
            if (this.translator1 != null) {
                tr1 = this.searchForAuthor(this.translator1);
            } else {
                tr1 = 0;
            }
            if (this.translator2 != null) {
                tr2 = this.searchForAuthor(this.translator2);
            } else {
                tr2 = 0;
            }
            if (this.translator3 != null) {
                tr3 = this.searchForAuthor(this.translator3);
            } else {
                tr3 = 0;
            }
            //search for reviser
            int re1 = -1, re2 = -1, re3 = -1;
            if (this.reviser1 != null) {
                re1 = this.searchForAuthor(this.reviser1);
            } else {
                re1 = 0;
            }
            if (this.reviser2 != null) {
                re2 = this.searchForAuthor(this.reviser2);
            } else {
                re2 = 0;
            }
            if (this.reviser3 != null) {
                re3 = this.searchForAuthor(this.reviser3);
            } else {
                re3 = 0;
            }
            int puPlace = -1;
            if (this.publisher1 != null) {
                puPlace = this.searchForpublishPlace(this.publisher1);
            } else {
                puPlace = 0;
            }
            Statement st = connection.createStatement();
            st.executeUpdate("INSERT INTO book(Number_Of_actuel_copies,Number_Of_copies_existed,Print_Num,Pages,Label_type,Label,Classification_number,Author1,Author2,Author3,Riviser1,Riviser2,Riviser3,Trnaslator1,Trnaslator2,Trnaslator3,Publisher1,Publishing_Year)values(" + this.Number_Of_actuel_copies + "," + this.Number_Of_copies_existed + ","+this.print + "," + pages + ",'" + this.label_type + "','" + this.lable + "','" + this.Classification_number + "'," + au1 + "," + au2 + "," + au3 + "," + re1 + "," + re2 + "," + re3 + "," + tr1 + "," + tr2 + "," + tr3 + "," + puPlace + "," + this.Publishing_Year + ")");
            // st.executeUpdate("INSERT INTO book(Number_Of_actuel _copies,Print_Num,Pages,Label_type,Label,Classification_number,Book_ID,Author1,Author2,Author3,Riviser1,Riviser2,Riviser3,Trnaslator1,Trnaslator2,Trnaslator3,Publisher1,Publishing_Year)values("+this.Number_Of_actuel_copies+","+this.print+","+pages+",'"+this.label_type+"','"+this.lable+"','"+this.Classification_number+"',"+au1+","+au2+","+au3+","+re1+","+re2+","+re3+","+ tr1+","+ tr2+","+ tr3+","+puPlace+","+this.Publishing_Year+")");

        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
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
 public void updateBookRecord(int copies_existed, int Book_ID){
        
        try {
            
//Number_Of_actuel_copies, Number_Of_copies_existed, Print_Num, Pages, Label_type, Label, Classification_number, Book_ID, Author1, Author2, Author3, Riviser1, Riviser2, Riviser3, Trnaslator1, Trnaslator2, Trnaslator3, Publisher1, Publishing_Year
PreparedStatement update; 
update= connection.prepareStatement("update book set Number_Of_copies_existed = ? WHERE Book_ID = ?");
update.setInt(1, copies_existed);
update.setInt(2, Book_ID);
update.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public int updateBookRecord1(int actuel_copies, int ID) {
        //int ret= 0; 
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
                update = connection.prepareStatement("UPDATE book SET Number_Of_copies_existed = ?, Number_Of_actuel_copies = ? WHERE Book_ID = ?");
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
                    update = connection.prepareStatement("UPDATE book SET Number_Of_copies_existed = ?, Number_Of_actuel_copies = ? WHERE Book_ID = ?");
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
           // System.out.println("some error occur ");
        }
        return 0;
    }
    
    public int[] getActExt(int id) {

        int n[] = new int[2];

        try {
            PreparedStatement st;
            st = connection.prepareStatement("select Number_Of_copies_existed, Number_Of_actuel_copies from book where Book_ID =?");
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
public boolean searchBookID(int book_id){
    
        boolean id = false;
        try {
             Statement st = connection.createStatement();
            ResultSet r = st.executeQuery(" select book_id from book where book_id ="+book_id);

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
public String searchbooklabel(int book_id){
            String label = "";

        try {
            Statement st = connection.createStatement();
            ResultSet r = st.executeQuery("select * from book where book_id = " + book_id );
while(r.next()){
    String name=r.getString("label");
    label=name;
}

        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        return label;
}
    public void deleteBookRecord(int book_id) {
        try {
            //          PreparedStatement st = connection.prepareStatement("DELETE FROM Table WHERE name = ?");
//        st.setString(1,name);
//        st.executeUpdate();
            PreparedStatement delete = connection.prepareStatement("DELETE FROM book WHERE book_id = ?");
            delete.setInt(1, book_id);
            delete.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String searchForAllBook() {
        PreparedStatement search = null;
        String message = "";
        try {

            search = connection.prepareStatement("select label, book_id, Classification_number, Number_Of_actuel_copies from book");
            ResultSet r = search.executeQuery();
            while (r.next()) {//the reuslt will be in string bilder to retrive all book in book table 
                message=message+"\n"+"اسم الكتاب: "+r.getString(1)+"  \n  "+"الرقم العام: "+r.getInt(2)+" \n "+"رقم التصنيف: "+r.getString(3)+"  \n   "+"عدد النسخ : "+r.getInt(4)+"\n ـــــــــــــــــــــــــــ";

            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //search.close();
        }
        return message;
    }

    public String serachForBookUsingID(int book_id) {
        String message = null;
        PreparedStatement search = null;
        try {
            //label, book_id,class,exited
            search = connection.prepareStatement("select label, book_id, Classification_number, Number_Of_actuel_copies,Number_Of_copies_existed from book where book_id =" + book_id);
            ResultSet r = search.executeQuery();
            while (r.next()) {//the reuslt will be in string bilder to retrive all book in book table 
                String label = r.getString(1);
                this.lable = label;
                int id = r.getInt(2);
                this.book_ID = id;
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

    public String serachForBookUsingClassification_number(String Classification_number) {
        PreparedStatement search = null;
        String message = null;
        try {
            //label, book_id,class,exited
            search = connection.prepareStatement("select label, book_id, Classification_number, Number_Of_actuel_copies,Number_Of_copies_existed from book where Classification_number like '%" + Classification_number + "%'");
            ResultSet r = search.executeQuery();
            while (r.next()) {//the reuslt will be in string bilder to retrive all book in book table 
                String label = r.getString(1);
                this.lable = label;
                int id = r.getInt(2);
                this.book_ID = id;
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
    
    public String serachForBookUsingID1(int book_id) {
        String message = "";
        PreparedStatement search = null;
        try {
            //label, book_id,class,exited
            search = connection.prepareStatement("select label, book_id, Classification_number, Number_Of_actuel_copies,Number_Of_copies_existed from book where book_id =" + book_id);
            ResultSet r = search.executeQuery();
            while (r.next()) {//the reuslt will be in string bilder to retrive all book in book table 
                String label = r.getString(1);
                this.lable = label;
                int id = r.getInt(2);
                this.book_ID = id;
                String clas = r.getString(3);
                this.Classification_number = clas;
                int actual = r.getInt(4);
                this.Number_Of_actuel_copies = actual;
                int existed = r.getInt(5);
                this.Number_Of_copies_existed = existed;
                message=message+"\n"+"اسم الكتاب: "+r.getString(1)+"  \n  "+"الرقم العام: "+r.getInt(2)+" \n "+"رقم التصنيف: "+r.getString(3)+"  \n   "+"عدد النسخ : "+r.getInt(4)+"\n ـــــــــــــــــــــــــــ";

            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
    }

    public String serachForBookUsingClassification_number1(String Classification_number) {
        PreparedStatement search = null;
        String message = "";
        try {
            //label, book_id,class,exited
            search = connection.prepareStatement("select label, book_id, Classification_number, Number_Of_actuel_copies,Number_Of_copies_existed from book where Classification_number like '%" + Classification_number + "%'");
            ResultSet r = search.executeQuery();
            while (r.next()) {//the reuslt will be in string bilder to retrive all book in book table 
                String label = r.getString(1);
                this.lable = label;
                int id = r.getInt(2);
                this.book_ID = id;
                String clas = r.getString(3);
                this.Classification_number = clas;
                int actual = r.getInt(4);
                this.Number_Of_actuel_copies = actual;
                int existed = r.getInt(5);
                this.Number_Of_copies_existed = existed;
                message=message+"\n"+"اسم الكتاب: "+r.getString(1)+"  \n  "+"الرقم العام: "+r.getInt(2)+" \n "+"رقم التصنيف: "+r.getString(3)+"  \n   "+"عدد النسخ : "+r.getInt(4)+"\n ـــــــــــــــــــــــــــ";

            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

        return message;
    }
    
    
    
    

    public int getBook_ID(String label) {
        int book_id = -1;
        try {
            Statement st = connection.createStatement();
            ResultSet r = st.executeQuery("select book_ID from book where label like '%" + label + "%'");
            while (r.next()) {
                book_id = r.getInt("Book_id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

        return book_id;
    }

    public void printReport(String name) {

        try {
            // create file 
            // String name = f.getAbsolutePath();
            fw = new FileWriter(name);
            System.out.println();
            // open buffer writer
            bw = new BufferedWriter(fw);

            // variables to save r results 
            String string;
            String author = "";
            int num, num2, num3 = 0;

            // colomn lables 
            bw.write("أسم الكتاب" + "\tالمؤلف" + "\tالرقم العام" + "\tرقم التصنيف" + "\tعدد النسخ" + "\t عدد النسخ المتبقية");
            bw.newLine();

            // retrive data
            PreparedStatement st = connection.prepareStatement("select Label ,Author1 ,Author2 ,Author3 ,book_ID ,Classification_number, Number_Of_actuel_copies, Number_Of_copies_existed from book");
            ResultSet r = st.executeQuery();
            while (r.next()) {
                // book name 
                string = r.getString(1);
                bw.write(string + "\t");

                // save all authors name if there id not 0, becouse 0 means no one 
                // author 1 name
                num = r.getInt(2);
                if (num != 0) {
                    author = getAuthours(num);
                }
                // author 2 name
                num = r.getInt(3);
                if (num != 0) {
                    author = author + ", " + getAuthours(num);
                }
                // author 3 name
                num = r.getInt(4);
                if (num != 0) {
                    author = author + ", " + getAuthours(num);
                }
                // print author name 
                bw.write(author + "\t");
                // print book id 
                bw.write("B-" + r.getInt(5) + "\t");
                // print classification number
                bw.write(r.getString(6));
                //bw.write(r.getString(6)+"\t");
                // num=r.getInt(7);
                //bw.write(num);
                // print book copies 
                //bw.write("");
                bw.write("\t" + r.getInt(7));
                bw.write("\t" + r.getInt(8));
                // bw.write("");
                bw.newLine();
            }

            bw.close();

        } catch (IOException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

        return str;

    }

}
