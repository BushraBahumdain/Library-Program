
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

public class Messag {
    
    // variables 
        FileWriter fw;
    BufferedWriter bw;
    public String lable; // 
    public String Classification_number;
    public int pages;//
    public String author1;//
    public String dept; 
    public String label_type;//
    public String judges; 
    public int Publishing_Year;
    public int msg_id;
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
    
    // constructors 
    public Messag() {
        
        try {
             
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement st = connection.createStatement();

        } catch (SQLException e) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DB_Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Messag(String lable, String Classification_number, int pages, String author1, String dept, String label_type, String judges, int Publishing_Year, int Number_Of_actuel_copies) {
        this.lable = lable;
        this.Classification_number = Classification_number;
        this.pages = pages;
        this.author1 = author1;
        this.dept = dept;
        this.label_type = label_type;
        this.judges = judges;
        this.Publishing_Year = Publishing_Year;
        this.Number_Of_actuel_copies = Number_Of_actuel_copies; 
         Number_Of_copies_existed=Number_Of_actuel_copies; 
        
        // open connection once it generated 
         try {
             
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement st = connection.createStatement();


} catch (SQLException e) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DB_Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
    // add msg method
    public void addMsg(){
        
        try {  
            
            // msg has one author
            int au1=-1;
            if(this.author1!=null){
                 au1=this.searchForAuthor(this.author1);
            }
            else { 
                au1=0;
            }
            
            // create sql statment
            Statement st = connection.createStatement();
              st.executeUpdate("INSERT INTO letters(Label, Pages, Judges, Label_type, Department, Publishing_Year, Classification_number, Number_Of_actuel_copies,Number_Of_copies_existed, Author)"
                    + "values('"+this.lable+"',"+this.pages+",'"+this.judges+"','"+this.label_type+"','"+this.dept+"',"+this.Publishing_Year+",'"+this.Classification_number+"',"+this.Number_Of_actuel_copies+","+this.Number_Of_copies_existed+","+au1+")");
                   // st.executeUpdate("INSERT INTO book(Number_Of_actuel _copies,Print_Num,Pages,Label_type,Label,Classification_number,Book_ID,Author1,Author2,Author3,Riviser1,Riviser2,Riviser3,Trnaslator1,Trnaslator2,Trnaslator3,Publisher1,Publishing_Year)values("+this.Number_Of_actuel_copies+","+this.print+","+pages+",'"+this.label_type+"','"+this.lable+"','"+this.Classification_number+"',"+au1+","+au2+","+au3+","+re1+","+re2+","+re3+","+ tr1+","+ tr2+","+ tr3+","+puPlace+","+this.Publishing_Year+")");
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // search author method
    public int searchForAuthor(String a) {
        
        int author_num = -1;
        try {
            Statement stt = connection.createStatement();
            ResultSet r = stt.executeQuery("select * from author where name like '%"+a+"%'");
            System.out.println(!r.isBeforeFirst());
            
            /// chek search result
            if (!r.isBeforeFirst()) {
                
                System.out.println("NO DATA");
                int rn = (int) (Math.random() * ((9999 - 3000 + 1) + 3000));
                Statement st1 = connection.createStatement();
                st1.executeUpdate("INSERT INTO author" + " VALUES(" + rn + ",'" + a + "')");
                author_num = rn;    
            } 
            else if (r.next()) {
                int an = r.getInt("ID");
                author_num = an;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // return result 
        return author_num;
    }
    
    // serching methods 
    // 1: with class-num
    public String serachForMsgUsingClassification_number(String Classification_number){
         String message=null;
        PreparedStatement search = null;
        try {
            //label, book_id,class,exited
            search = connection.prepareStatement("select label, ID, Classification_number, Number_Of_actuel_copies, Number_Of_copies_existed from letters where Classification_number like '%"+Classification_number+"%'");
            ResultSet r=search.executeQuery();
            while (r.next()) {
                //the reuslt will be in string bilder to retrive all book in book table 
                //here you can get data, the '1' indicates column number based on your query
                 String label = r.getString(1);
                this.lable = label;
                int id = r.getInt(2);
                this.msg_id =id;
               String clas = r.getString(3);
               this.Classification_number = clas;
               int actual = r.getInt(4);
               this.Number_Of_actuel_copies=actual;
               int existed = r.getInt(5);
               this.Number_Of_copies_existed=existed;
             message=message+"\n"+r.getString(1) + "  |  " + r.getInt(2) + "  |  " + r.getString(3) + "  |  " + r.getInt(4); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return message;
    }
 
    // 2: general id number 
    public String serachForMsgUsingID(int book_id){
       String message=null;
         PreparedStatement search=null;
        try {
            //label, book_id,class,exited
            search = connection.prepareStatement("select label, ID, Classification_number, Number_Of_actuel_copies, Number_Of_copies_existed from letters where ID ="+book_id);


ResultSet r=search.executeQuery();
            while(r.next())
            { 
                
                String label = r.getString(1);
                this.lable = label;
                int id = r.getInt(2);
                this.msg_id =id;
               String clas = r.getString(3);
               this.Classification_number = clas;
               int actual = r.getInt(4);
               this.Number_Of_actuel_copies=actual;
               int existed = r.getInt(5);
               this.Number_Of_copies_existed=existed;
                message=message+"\n"+r.getString(1)+"  |  "+r.getInt(2)+"  |  "+r.getString(3)+"  |  "+r.getInt(4); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return message;}
    
    // 3: all letters 
  public String searchForAllMsg(){
        String message="";
        PreparedStatement search=null;
        try {
            //label, book_id,class,exited
            search = connection.prepareStatement("select label, ID, Classification_number, Number_Of_actuel_copies, Number_Of_copies_existed from letters");
            ResultSet r=search.executeQuery();
            
          while(r.next())
            {//the reuslt w
                //the reuslt will be in string bilder to retrive all book in book table 
                //here you can get data, the '1' indicates column number based on your query
                message=message+"\n"+"اسم الرسالة : "+r.getString(1)+" \n "+"الرقم العام: "+r.getInt(2)+" \n "+"رقم التصنيف: "+r.getString(3)+" \n "+"عدد النسخ: "+r.getInt(4)+"\nـــــــــــــــــــــــــــ"; 
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //search.close();
        }
    return message;}
    
     public String serachForMsgUsingClassification_number1(String Classification_number){
         String message="";
        PreparedStatement search = null;
        try {
            //label, book_id,class,exited
            search = connection.prepareStatement("select label, ID, Classification_number, Number_Of_actuel_copies, Number_Of_copies_existed from letters where Classification_number like '%"+Classification_number+"%'");
            ResultSet r=search.executeQuery();
            while (r.next()) {
                //the reuslt will be in string bilder to retrive all book in book table 
                //here you can get data, the '1' indicates column number based on your query
                 String label = r.getString(1);
                this.lable = label;
                int id = r.getInt(2);
                this.msg_id =id;
               String clas = r.getString(3);
               this.Classification_number = clas;
               int actual = r.getInt(4);
               this.Number_Of_actuel_copies=actual;
               int existed = r.getInt(5);
               this.Number_Of_copies_existed=existed;
             message=message+"\n"+"اسم الرسالة : "+r.getString(1)+" \n "+"الرقم العام: "+r.getInt(2)+" \n "+"رقم التصنيف: "+r.getString(3)+" \n "+"عدد النسخ: "+r.getInt(4)+"\nـــــــــــــــــــــــــــ";; 
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return message;
    }
 
    // 2: general id number 
    public String serachForMsgUsingID1(int book_id){
       String message="";
         PreparedStatement search=null;
        try {
            //label, book_id,class,exited
            search = connection.prepareStatement("select label, ID, Classification_number, Number_Of_actuel_copies, Number_Of_copies_existed from letters where ID ="+book_id);


ResultSet r=search.executeQuery();
            while(r.next())
            { 
                
                String label = r.getString(1);
                this.lable = label;
                int id = r.getInt(2);
                this.msg_id =id;
               String clas = r.getString(3);
               this.Classification_number = clas;
               int actual = r.getInt(4);
               this.Number_Of_actuel_copies=actual;
               int existed = r.getInt(5);
               this.Number_Of_copies_existed=existed;
                message=message+"\n"+"اسم الرسالة : "+r.getString(1)+" \n "+"الرقم العام: "+r.getInt(2)+" \n "+"رقم التصنيف: "+r.getString(3)+" \n "+"عدد النسخ: "+r.getInt(4)+"\nـــــــــــــــــــــــــــ"; 
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return message;}
    
    
     public void updateMsgRecord(int copies_existed, int ID){
        
        try {
            
            PreparedStatement update;
            update = connection.prepareStatement("update letters set Number_Of_copies_existed = ? WHERE ID = ?");
            update.setInt(1, copies_existed);
            update.setInt(2, ID);
            update.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    // UPDATE method 
    public int updateMsgRecord1(int actuel_copies, int ID){
        
        
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
                update = connection.prepareStatement("UPDATE letters SET Number_Of_copies_existed = ?, Number_Of_actuel_copies = ? WHERE ID = ?");
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
                    update = connection.prepareStatement("UPDATE letters SET Number_Of_copies_existed = ?, Number_Of_actuel_copies = ? WHERE ID = ?");
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
                //System.out.println("tou CAN NOT");
            }
        } else {
            return 0;
           // System.out.println("som error occur ");
        }
        
        return 0;
    }
    
    public int[] getActExt(int id) {

        int n[] = new int[2];

        try {
            PreparedStatement st;
            st = connection.prepareStatement("select Number_Of_copies_existed, Number_Of_actuel_copies from letters where ID =?");
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

    // delete methos 
     public boolean searchletterID(int msg_id){
    
        boolean id = false;
        try {
             Statement st = connection.createStatement();
            ResultSet r = st.executeQuery(" select id from letters where id ="+msg_id);

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
public String searchletterlabel(int id){
            String label = "";

        try {
            Statement st = connection.createStatement();
            ResultSet r = st.executeQuery("select * from letters where id = " +id );
while(r.next()){
    String name=r.getString("label");
    label=name;
}

        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        return label;
}
    public void deleteBookRecord(int id){
        try {
            
            PreparedStatement delete = connection.prepareStatement("DELETE FROM letters WHERE ID = ?");
            delete.setInt(1, id);
            delete.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
  
    //ID
     public int getMsg_ID(String label){
        int msg=-1;
        try {
            Statement st = connection.createStatement();
            ResultSet r = st.executeQuery("select ID from letters where label like '%"+label+"%'");
            while(r.next()){
                msg=r.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    return msg;}
    

       public void printReport(String name){
       
        try {
            // create file 
           // String name = f.getAbsolutePath();
            fw = new FileWriter(name);  
            
            // open buffer writer
            bw = new BufferedWriter(fw); 
            
            // variables to save r results 
            String string;
            String author="";
            int num= 0; 
           
            // colomn lables 
            bw.write("أسم الرسالة"+"\tالمؤلف"+"\tالرقم العام"+"\tرقم التصنيف"+"\tعدد النسخ"+"\t عدد النسخ المتبقية");
            bw.newLine();
            
            // retrive data
            PreparedStatement st = connection.prepareStatement("select Label ,Author ,ID ,Classification_number, Number_Of_actuel_copies, Number_Of_copies_existed from letters");
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
                bw.write("L-" + r.getInt(3) + "\t");
                // print classification number
                bw.write(r.getString(4));
                // print book copies 
                bw.write("\t"+r.getInt(5));
                bw.write("\t"+r.getInt(6));
                bw.newLine();
            }
            
            bw.close();
        
        } catch (IOException ex) {
            Logger.getLogger(Messag.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Messag.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
    public String getAuthours(int id){
        
        String str="";
        
        try {
            
            PreparedStatement st = connection.prepareStatement("select name from author where ID =?");
            st.setInt(1, id); 
            ResultSet r = st.executeQuery();
            while(r.next()){
                str = r.getString(1);
                //System.out.println(str+"while");
            }
                       
            
               
        } catch (SQLException ex) { 
            Logger.getLogger(Messag.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return str; 
        
        
        
    }
    
    
    
}