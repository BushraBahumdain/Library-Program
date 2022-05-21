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
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amani
 */
public class borrowed {

    public int Borro;
    public int Con;
    public String Date;
    public int ID;
    public int itm;
    public int day;
    public String State;

    String URL = "jdbc:mysql://localhost:3306/library";
    String USERNAME = "root"; // use your username of Mysql server
    String PASSWORD = "bushra"; // use your password of Mysql server
    Connection connection = null;
    PreparedStatement preparedStmt = null;
    ResultSet resultSet = null;
    String sqlQuery = "";

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

    public borrowed(int Borro, int Con, String Date, int ID, int itm, int day) {
        this.Borro = Borro;
        this.Con = Con;
        this.Date = Date;
        this.ID = ID;
        this.itm = itm;
        this.day = day;

    }

    public borrowed() {
        connction();
    }

    public int ViewBorrowed1(int item_ID, int borrower) {
        int i = 0;
        try {
            Statement stt = connection.createStatement();
            ResultSet r = stt.executeQuery("SELECT * FROM borrowing WHERE Borrower_ID = " + borrower + " and item = " + item_ID + "");
            if (!r.isBeforeFirst()) {
                System.out.println("NO DATA");
            } else if (r.next()) {
                int Borro = r.getInt("Borrower_ID");
                this.Borro = Borro;
                int Con = r.getInt("Borrower_Constraints");
                this.Con = Con;
                String Date = r.getString("Time_Of_Borrowing");
                this.Date = Date;
                int ID = r.getInt("Borrowing_ID");
                this.ID = ID;
                int itm = r.getInt("item");
                this.itm = itm;
                int day = r.getInt("dayes_of_borrowing");
                this.day = day;
                String State = r.getString("State");
                this.State = State;
                i = 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);

        }
        return i;
    }

    public int ViewBorrowed2(String item_class, int borrower) {
        int i = 0;
        try {
            Book book = new Book();
            book.serachForBookUsingClassification_number(item_class);
            System.out.println(book.book_ID);
            Statement stt = connection.createStatement();
            ResultSet r = stt.executeQuery("SELECT * FROM borrowing WHERE Borrower_ID = " + borrower + " and item = " + book.book_ID + "");
            if (!r.isBeforeFirst()) {
                System.out.println("NO DATA");
            } else if (r.next()) {
                int Borro = r.getInt("Borrower_ID");
                this.Borro = Borro;
                int Con = r.getInt("Borrower_Constraints");
                this.Con = Con;
                String Date = r.getString("Time_Of_Borrowing");
                this.Date = Date;
                int ID = r.getInt("Borrowing_ID");
                this.ID = ID;
                int itm = r.getInt("item");
                this.itm = itm;
                int day = r.getInt("dayes_of_borrowing");
                this.day = day;
                String State = r.getString("State");
                this.State = State;
                i = 1;

            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);

        }
        return i;
    }

    public String ViewBorrowed1_i(int item_ID) {
        String m = "";
        PreparedStatement search = null;
        try {
            borrower_type Bt = new borrower_type();
            Book book = new Book();
            book.serachForBookUsingID(item_ID);
            System.out.println(book.book_ID);
            Statement stt = connection.createStatement();
            search = connection.prepareStatement("SELECT * FROM borrowing WHERE item = " + book.book_ID + "");
            ResultSet r = search.executeQuery();
            if (!r.isBeforeFirst()) {
                System.out.println("NO DATA");
            }
            while (r.next()) {
                int Borro = r.getInt("Borrower_ID");
                this.Borro = Borro;
                int Con = r.getInt("Borrower_Constraints");
                this.Con = Con;
                String Date = r.getString("Time_Of_Borrowing");
                this.Date = Date;
                int ID = r.getInt("Borrowing_ID");
                this.ID = ID;
                int itm = r.getInt("item");
                this.itm = itm;
                int day = r.getInt("dayes_of_borrowing");
                this.day = day;
                String State = r.getString("State");
                this.State = State;
                Bt.search(Con);
                m += "\n" + Borro + "  --  " + "الرقم الجامعي او الوظيفي  \n" + Bt.type + "  --  " + " فئة المستعير \n" + ID + "  --  " + " رقم عملية الاعارة\n" + day + "  --  " + "مدة الاعارة بالايام\n " + itm + "  --  " + "الرقم العام للوعاء المستعار\n " + Date + "  --  " + " تاريخ الاستعارة\n" + State + "  --  " + " حالة الاعارة\n"+"________________________________________\n";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);

        }
        return m;
    }

    public String ViewBorrowed2_i(String item_class) {
        String m = "";
        PreparedStatement search = null;
        try {
            borrower_type Bt = new borrower_type();
            Book book = new Book();
            book.serachForBookUsingClassification_number(item_class);
            System.out.println(book.book_ID);
            Statement stt = connection.createStatement();
            search = connection.prepareStatement("SELECT * FROM borrowing WHERE item = " + book.book_ID + "");
            ResultSet r = search.executeQuery();
            if (!r.isBeforeFirst()) {
                System.out.println("NO DATA");
            }
            while (r.next()) {
                int Borro = r.getInt("Borrower_ID");
                this.Borro = Borro;
                int Con = r.getInt("Borrower_Constraints");
                this.Con = Con;
                String Date = r.getString("Time_Of_Borrowing");
                this.Date = Date;
                int ID = r.getInt("Borrowing_ID");
                this.ID = ID;
                int itm = r.getInt("item");
                this.itm = itm;
                int day = r.getInt("dayes_of_borrowing");
                this.day = day;
                String State = r.getString("State");
                this.State = State;
                Bt.search(Con);
                m += "\n" + Borro + "  --  " + "الرقم الجامعي او الوظيفي  \n" + Bt.type + "  --  " + " فئة المستعير \n" + ID + "  --  " + " رقم عملية الاعارة\n" + day + "  --  " + "مدة الاعارة بالايام\n " + itm + "  --  " + "الرقم العام للوعاء المستعار\n " + Date + "  --  " + " تاريخ الاستعارة\n" + State + "  --  " + " حالة الاعارة\n"+"________________________________________\n";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);

        }
        return m;
    }

    public String ViewBorrowed_id(int id) {
        String m = "";
        PreparedStatement search = null;
        try {
            borrower_type Bt = new borrower_type();
            search = connection.prepareStatement("SELECT * FROM borrowing WHERE Borrower_ID = " + id + "");
            ResultSet r = search.executeQuery();
            if (!r.isBeforeFirst()) {
                System.out.println("NO DATA");
            }
            while (r.next()) {
                int Borro = r.getInt("Borrower_ID");
                this.Borro = Borro;
                int Con = r.getInt("Borrower_Constraints");
                this.Con = Con;
                String Date = r.getString("Time_Of_Borrowing");
                this.Date = Date;
                int ID = r.getInt("Borrowing_ID");
                this.ID = ID;
                int itm = r.getInt("item");
                this.itm = itm;
                int day = r.getInt("dayes_of_borrowing");
                this.day = day;
                String State = r.getString("State");
                this.State = State;

                Bt.search(Con);
                m += "\n" + Borro + "  --  " + "الرقم الجامعي او الوظيفي  \n" + Bt.type + "  --  " + " فئة المستعير \n" + ID + "  --  " + " رقم عملية الاعارة\n" + day + "  --  " + "مدة الاعارة بالايام\n " + itm + "  --  " + "الرقم العام للوعاء المستعار\n " + Date + "  --  " + " تاريخ الاستعارة\n" + State + "  --  " + " حالة الاعارة\n"+"________________________________________\n";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);

        }
        return m;
    }

    ////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////
    ////////////////////////////////JOURNAL////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////
    public int ViewBorrowed1_j(int item_ID, int borrower) {
        int i = 0;
        try {
            Statement stt = connection.createStatement();
            ResultSet r = stt.executeQuery("SELECT * FROM borrowing_j WHERE Borrower_ID = " + borrower + " and item = " + item_ID + "");
            if (!r.isBeforeFirst()) {
                System.out.println("NO DATA");
            } else if (r.next()) {
                int Borro = r.getInt("Borrower_ID");
                this.Borro = Borro;
                int Con = r.getInt("Borrower_Constraints");
                this.Con = Con;
                String Date = r.getString("Time_Of_Borrowing");
                this.Date = Date;
                int ID = r.getInt("Borrowing_ID");
                this.ID = ID;
                int itm = r.getInt("item");
                this.itm = itm;
                int day = r.getInt("dayes_of_borrowing");
                this.day = day;
                String State = r.getString("State");
                this.State = State;
                i = 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);

        }
        return i;
    }

    public int ViewBorrowed2_j(String item_class, int borrower) {
        int i = 0;
        try {
            Journal Journal = new Journal();
            Journal.serachForJournalUsingClassification_number(item_class);
            System.out.println(Journal.Journal_ID);
            Statement stt = connection.createStatement();
            ResultSet r = stt.executeQuery("SELECT * FROM borrowing_j WHERE Borrower_ID = " + borrower + " and item = " + Journal.Journal_ID + "");
            if (!r.isBeforeFirst()) {
                System.out.println("NO DATA");
            } else if (r.next()) {
                int Borro = r.getInt("Borrower_ID");
                this.Borro = Borro;
                int Con = r.getInt("Borrower_Constraints");
                this.Con = Con;
                String Date = r.getString("Time_Of_Borrowing");
                this.Date = Date;
                int ID = r.getInt("Borrowing_ID");
                this.ID = ID;
                int itm = r.getInt("item");
                this.itm = itm;
                int day = r.getInt("dayes_of_borrowing");
                this.day = day;
                String State = r.getString("State");
                this.State = State;
                i = 1;

            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);

        }
        return i;

    }

    public String ViewBorrowed1_ji(int item_ID) {
        String m = "";
        PreparedStatement search = null;
        try {
             borrower_type Bt = new borrower_type();
            Journal j = new Journal();
            j.serachForJournalUsingID(item_ID);
            System.out.println(j.Journal_ID);
            Statement stt = connection.createStatement();
            search = connection.prepareStatement("SELECT * FROM borrowing_j WHERE item = " + j.Journal_ID + "");
            ResultSet r = search.executeQuery();
            if (!r.isBeforeFirst()) {
                System.out.println("NO DATA");
            }
            while (r.next()) {
                int Borro = r.getInt("Borrower_ID");
                this.Borro = Borro;
                int Con = r.getInt("Borrower_Constraints");
                this.Con = Con;
                String Date = r.getString("Time_Of_Borrowing");
                this.Date = Date;
                int ID = r.getInt("Borrowing_ID");
                this.ID = ID;
                int itm = r.getInt("item");
                this.itm = itm;
                int day = r.getInt("dayes_of_borrowing");
                this.day = day;
                String State = r.getString("State");
                this.State = State;
                
 Bt.search(Con);
             m += "\n"+Borro+"  --  "+"الرقم الجامعي او الوظيفي  \n"+ Bt.type+"  --  "+" فئة المستعير \n"+ID+"  --  "+" رقم عملية الاعارة\n"+day+"  --  "+ "مدة الاعارة بالايام\n "+itm+"  --  "+"الرقم العام للوعاء المستعار\n "+Date+"  --  "+" تاريخ الاستعارة\n"+State+"  --  "+" حالة الاعارة\n"+"________________________________________\n";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);

        }
        return m;
    }

    public String ViewBorrowed2_ji(String item_class) {
        String m = "";
        PreparedStatement search = null;
        try {
             borrower_type Bt = new borrower_type();
            Journal j = new Journal();
            j.serachForJournalUsingClassification_number(item_class);
            System.out.println(j.Journal_ID);
            Statement stt = connection.createStatement();
            search = connection.prepareStatement("SELECT * FROM borrowing_j WHERE item = " + j.Journal_ID + "");
            ResultSet r = search.executeQuery();
            if (!r.isBeforeFirst()) {
                System.out.println("NO DATA");
            }
            while (r.next()) {
                int Borro = r.getInt("Borrower_ID");
                this.Borro = Borro;
                int Con = r.getInt("Borrower_Constraints");
                this.Con = Con;
                String Date = r.getString("Time_Of_Borrowing");
                this.Date = Date;
                int ID = r.getInt("Borrowing_ID");
                this.ID = ID;
                int itm = r.getInt("item");
                this.itm = itm;
                int day = r.getInt("dayes_of_borrowing");
                this.day = day;
                String State = r.getString("State");
                this.State = State;
                Bt.search(Con);
             m += "\n"+Borro+"  --  "+"الرقم الجامعي او الوظيفي  \n"+ Bt.type+"  --  "+" فئة المستعير \n"+ID+"  --  "+" رقم عملية الاعارة\n"+day+"  --  "+ "مدة الاعارة بالايام\n "+itm+"  --  "+"الرقم العام للوعاء المستعار\n "+Date+"  --  "+" تاريخ الاستعارة\n"+State+"  --  "+" حالة الاعارة\n"+"________________________________________\n";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);

        }
        return m;
    }

    public String ViewBorrowed_jid(int id) {
        String m = "";
        PreparedStatement search = null;
        try {
            borrower_type Bt = new borrower_type();
            search = connection.prepareStatement("SELECT * FROM borrowing_j WHERE Borrower_ID = " + id + "");
            ResultSet r = search.executeQuery();
            if (!r.isBeforeFirst()) {
                System.out.println("NO DATA");
            }
            while (r.next()) {
                int Borro = r.getInt("Borrower_ID");
                this.Borro = Borro;
                int Con = r.getInt("Borrower_Constraints");
                this.Con = Con;
                String Date = r.getString("Time_Of_Borrowing");
                this.Date = Date;
                int ID = r.getInt("Borrowing_ID");
                this.ID = ID;
                int itm = r.getInt("item");
                this.itm = itm;
                int day = r.getInt("dayes_of_borrowing");
                this.day = day;
                String State = r.getString("State");
                this.State = State;
                Bt.search(Con);
             m += "\n"+Borro+"  --  "+"الرقم الجامعي او الوظيفي  \n"+ Bt.type+"  --  "+" فئة المستعير \n"+ID+"  --  "+" رقم عملية الاعارة\n"+day+"  --  "+ "مدة الاعارة بالايام\n "+itm+"  --  "+"الرقم العام للوعاء المستعار\n "+Date+"  --  "+" تاريخ الاستعارة\n"+State+"  --  "+" حالة الاعارة\n"+"________________________________________\n";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);

        }
        return m;
    }

    ////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////
    ////////////////////////////////Message////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////
    public int ViewBorrowed1_l(int item_ID, int borrower) {
        int i = 0;
        try {
            Statement stt = connection.createStatement();
            ResultSet r = stt.executeQuery("SELECT * FROM borrowing_l WHERE Borrower_ID = " + borrower + " and item = " + item_ID + "");
            if (!r.isBeforeFirst()) {
                System.out.println("NO DATA");
            } else if (r.next()) {
                int Borro = r.getInt("Borrower_ID");
                this.Borro = Borro;
                int Con = r.getInt("Borrower_Constraints");
                this.Con = Con;
                String Date = r.getString("Time_Of_Borrowing");
                this.Date = Date;
                int ID = r.getInt("Borrowing_ID");
                this.ID = ID;
                int itm = r.getInt("item");
                this.itm = itm;
                int day = r.getInt("dayes_of_borrowing");
                this.day = day;
                String State = r.getString("State");
                this.State = State;
                i = 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);

        }
        return i;
    }

    public int ViewBorrowed2_l(String item_class, int borrower) {
        int i = 0;
        try {
            Messag Messag = new Messag();
            Messag.serachForMsgUsingClassification_number(item_class);
            System.out.println(Messag.msg_id);
            Statement stt = connection.createStatement();
            ResultSet r = stt.executeQuery("SELECT * FROM borrowing_l WHERE Borrower_ID = " + borrower + " and item = " + Messag.msg_id + "");
            if (!r.isBeforeFirst()) {
                System.out.println("NO DATA");
            } else if (r.next()) {
                int Borro = r.getInt("Borrower_ID");
                this.Borro = Borro;
                int Con = r.getInt("Borrower_Constraints");
                this.Con = Con;
                String Date = r.getString("Time_Of_Borrowing");
                this.Date = Date;
                int ID = r.getInt("Borrowing_ID");
                this.ID = ID;
                int itm = r.getInt("item");
                this.itm = itm;
                int day = r.getInt("dayes_of_borrowing");
                this.day = day;
                String State = r.getString("State");
                this.State = State;
                i = 1;

            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);

        }
        return i;

    }

    public String ViewBorrowed1_li(int item_ID) {
        String m = "";
        PreparedStatement search = null;
        try {
             borrower_type Bt = new borrower_type();
            Messag ms = new Messag();
            ms.serachForMsgUsingID(item_ID);
            System.out.println(ms.msg_id);
            Statement stt = connection.createStatement();
            search = connection.prepareStatement("SELECT * FROM borrowing_l WHERE item = " + ms.msg_id + "");
            ResultSet r = search.executeQuery();
            if (!r.isBeforeFirst()) {
                System.out.println("NO DATA");
            }
            while (r.next()) {
                int Borro = r.getInt("Borrower_ID");
                this.Borro = Borro;
                int Con = r.getInt("Borrower_Constraints");
                this.Con = Con;
                String Date = r.getString("Time_Of_Borrowing");
                this.Date = Date;
                int ID = r.getInt("Borrowing_ID");
                this.ID = ID;
                int itm = r.getInt("item");
                this.itm = itm;
                int day = r.getInt("dayes_of_borrowing");
                this.day = day;
                String State = r.getString("State");
                this.State = State;
                Bt.search(Con);
             m += "\n"+Borro+"  --  "+"الرقم الجامعي او الوظيفي  \n"+ Bt.type+"  --  "+" فئة المستعير \n"+ID+"  --  "+" رقم عملية الاعارة\n"+day+"  --  "+ "مدة الاعارة بالايام\n "+itm+"  --  "+"الرقم العام للوعاء المستعار\n "+Date+"  --  "+" تاريخ الاستعارة\n"+State+"  --  "+" حالة الاعارة\n"+"________________________________________\n";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);

        }
        return m;
    }

    public String ViewBorrowed2_li(String item_class) {
        String m = "";
        PreparedStatement search = null;
        try {
             borrower_type Bt = new borrower_type();
            Messag ms = new Messag();
            ms.serachForMsgUsingClassification_number(item_class);
            System.out.println(ms.msg_id);
            Statement stt = connection.createStatement();
            search = connection.prepareStatement("SELECT * FROM borrowing_l WHERE item = " + ms.msg_id + "");
            ResultSet r = search.executeQuery();
            if (!r.isBeforeFirst()) {
                System.out.println("NO DATA");
            }
            while (r.next()) {
                int Borro = r.getInt("Borrower_ID");
                this.Borro = Borro;
                int Con = r.getInt("Borrower_Constraints");
                this.Con = Con;
                String Date = r.getString("Time_Of_Borrowing");
                this.Date = Date;
                int ID = r.getInt("Borrowing_ID");
                this.ID = ID;
                int itm = r.getInt("item");
                this.itm = itm;
                int day = r.getInt("dayes_of_borrowing");
                this.day = day;
                String State = r.getString("State");
                this.State = State;
               
 Bt.search(Con);
             m += "\n"+Borro+"  --  "+"الرقم الجامعي او الوظيفي  \n"+ Bt.type+"  --  "+" فئة المستعير \n"+ID+"  --  "+" رقم عملية الاعارة\n"+day+"  --  "+ "مدة الاعارة بالايام\n "+itm+"  --  "+"الرقم العام للوعاء المستعار\n "+Date+"  --  "+" تاريخ الاستعارة\n"+State+"  --  "+" حالة الاعارة\n"+"________________________________________\n";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);

        }
        return m;
    }

    public String ViewBorrowed_lid(int id) {
        String m = "";
        PreparedStatement search = null;
        try {
             borrower_type Bt = new borrower_type();
            search = connection.prepareStatement("SELECT * FROM borrowing_l WHERE Borrower_ID = " + id + "");
            ResultSet r = search.executeQuery();
            if (!r.isBeforeFirst()) {
                System.out.println("NO DATA");
            }
            while (r.next()) {
                int Borro = r.getInt("Borrower_ID");
                this.Borro = Borro;
                int Con = r.getInt("Borrower_Constraints");
                this.Con = Con;
                String Date = r.getString("Time_Of_Borrowing");
                this.Date = Date;
                int ID = r.getInt("Borrowing_ID");
                this.ID = ID;
                int itm = r.getInt("item");
                this.itm = itm;
                int day = r.getInt("dayes_of_borrowing");
                this.day = day;
                String State = r.getString("State");
                this.State = State;
                

 Bt.search(Con);
             m += "\n"+Borro+"  --  "+"الرقم الجامعي او الوظيفي  \n"+ Bt.type+"  --  "+" فئة المستعير \n"+ID+"  --  "+" رقم عملية الاعارة\n"+day+"  --  "+ "مدة الاعارة بالايام\n "+itm+"  --  "+"الرقم العام للوعاء المستعار\n "+Date+"  --  "+" تاريخ الاستعارة\n"+State+"  --  "+" حالة الاعارة\n"+"________________________________________\n";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);

        }
        return m;
    }

    ////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////
    ////////////////////////////////Project////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////
    public int ViewBorrowed1_p(int item_ID, int borrower) {
        int i = 0;
        try {
            Statement stt = connection.createStatement();
            ResultSet r = stt.executeQuery("SELECT * FROM borrowing_p WHERE Borrower_ID = " + borrower + " and item = " + item_ID + "");
            if (!r.isBeforeFirst()) {
                System.out.println("NO DATA");
            } else if (r.next()) {
                int Borro = r.getInt("Borrower_ID");
                this.Borro = Borro;
                int Con = r.getInt("Borrower_Constraints");
                this.Con = Con;
                String Date = r.getString("Time_Of_Borrowing");
                this.Date = Date;
                int ID = r.getInt("Borrowing_ID");
                this.ID = ID;
                int itm = r.getInt("item");
                this.itm = itm;
                int day = r.getInt("dayes_of_borrowing");
                this.day = day;
                String State = r.getString("State");
                this.State = State;
                i = 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);

        }
        return i;
    }

    public int ViewBorrowed2_p(String item_class, int borrower) {
        int i = 0;
        try {
            Project Project = new Project();
            Project.serachForProjectUsingClassification_number(item_class);
            System.out.println(Project.Project_ID);
            Statement stt = connection.createStatement();
            ResultSet r = stt.executeQuery("SELECT * FROM borrowing_p WHERE Borrower_ID = " + borrower + " and item = " + Project.Project_ID + "");
            if (!r.isBeforeFirst()) {
                System.out.println("NO DATA");
            } else if (r.next()) {
                int Borro = r.getInt("Borrower_ID");
                this.Borro = Borro;
                int Con = r.getInt("Borrower_Constraints");
                this.Con = Con;
                String Date = r.getString("Time_Of_Borrowing");
                this.Date = Date;
                int ID = r.getInt("Borrowing_ID");
                this.ID = ID;
                int itm = r.getInt("item");
                this.itm = itm;
                int day = r.getInt("dayes_of_borrowing");
                this.day = day;
                String State = r.getString("State");
                this.State = State;
                i = 1;

            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);

        }
        return i;

    }

    public String ViewBorrowed1_pi(int item_ID) {
        String m = "";
        PreparedStatement search = null;
        try {
             borrower_type Bt = new borrower_type();
            Project pr = new Project();
            pr.serachForProjectUsingID(item_ID);
            System.out.println(pr);
            Statement stt = connection.createStatement();
            search = connection.prepareStatement("SELECT * FROM borrowing_p WHERE item = " + pr.Project_ID + "");
            ResultSet r = search.executeQuery();
            if (!r.isBeforeFirst()) {
                System.out.println("NO DATA");
            }
            while (r.next()) {
                int Borro = r.getInt("Borrower_ID");
                this.Borro = Borro;
                int Con = r.getInt("Borrower_Constraints");
                this.Con = Con;
                String Date = r.getString("Time_Of_Borrowing");
                this.Date = Date;
                int ID = r.getInt("Borrowing_ID");
                this.ID = ID;
                int itm = r.getInt("item");
                this.itm = itm;
                int day = r.getInt("dayes_of_borrowing");
                this.day = day;
                String State = r.getString("State");
                this.State = State;
                Bt.search(Con);
             m += "\n"+Borro+"  --  "+"الرقم الجامعي او الوظيفي  \n"+ Bt.type+"  --  "+" فئة المستعير \n"+ID+"  --  "+" رقم عملية الاعارة\n"+day+"  --  "+ "مدة الاعارة بالايام\n "+itm+"  --  "+"الرقم العام للوعاء المستعار\n "+Date+"  --  "+" تاريخ الاستعارة\n"+State+"  --  "+" حالة الاعارة\n"+"________________________________________\n";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);

        }
        return m;
    }

    public String ViewBorrowed2_pi(String item_class) {
        String m = "";
        PreparedStatement search = null;
        try {
            Project pr = new Project();
            pr.serachForProjectUsingClassification_number(item_class);
            System.out.println(pr);
            Statement stt = connection.createStatement();
            borrower_type Bt = new borrower_type();

            search = connection.prepareStatement("SELECT * FROM borrowing_p WHERE item = " + pr.Project_ID + "");
            ResultSet r = search.executeQuery();
            if (!r.isBeforeFirst()) {
                System.out.println("NO DATA");
            }
            while (r.next()) {
                int Borro = r.getInt("Borrower_ID");
                this.Borro = Borro;
                int Con = r.getInt("Borrower_Constraints");
                this.Con = Con;
                Bt.search(Con);
                String Date = r.getString("Time_Of_Borrowing");
                this.Date = Date;
                int ID = r.getInt("Borrowing_ID");
                this.ID = ID;
                int itm = r.getInt("item");
                this.itm = itm;
                int day = r.getInt("dayes_of_borrowing");
                this.day = day;
                String State = r.getString("State");
                this.State = State;
                m += "\n" + Borro + "  --  " + "الرقم الجامعي او الوظيفي  \n" + Bt.type + "  --  " + " فئة المستعير \n" + ID + "  --  " + " رقم عملية الاعارة\n" + day + "  --  " + "مدة الاعارة بالايام\n " + itm + "  --  " + "الرقم العام للوعاء المستعار\n " + Date + "  --  " + " تاريخ الاستعارة\n" + State + "  --  " + " حالة الاعارة\n"+"________________________________________\n";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);

        }
        return m;
    }

    public String ViewBorrowed_pid(int id) {
        String m = "";
        PreparedStatement search = null;
        try {
            borrower_type Bt = new borrower_type();
            search = connection.prepareStatement("SELECT * FROM borrowing_p WHERE Borrower_ID = " + id + "");
            ResultSet r = search.executeQuery();
            if (!r.isBeforeFirst()) {
                System.out.println("NO DATA");
            }
            while (r.next()) {
                int Borro = r.getInt("Borrower_ID");
                this.Borro = Borro;
                int Con = r.getInt("Borrower_Constraints");
                this.Con = Con;
                String Date = r.getString("Time_Of_Borrowing");
                this.Date = Date;
                int ID = r.getInt("Borrowing_ID");
                this.ID = ID;
                int itm = r.getInt("item");
                this.itm = itm;
                int day = r.getInt("dayes_of_borrowing");
                this.day = day;
                String State = r.getString("State");
                this.State = State;
                Bt.search(Con);
                m += "\n" + Borro + "  --  " + "الرقم الجامعي او الوظيفي  \n" + Bt.type + "  --  " + " فئة المستعير \n" + ID + "  --  " + " رقم عملية الاعارة\n" + day + "  --  " + "مدة الاعارة بالايام\n " + itm + "  --  " + "الرقم العام للوعاء المستعار\n " + Date + "  --  " + " تاريخ الاستعارة\n" + State + "  --  " + " حالة الاعارة\n"+"________________________________________\n";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);

        }
        return m;
    }

      public void printBorrowInfo_b(String name) {
        FileWriter f;
        BufferedWriter b;
        String in = "in progress";

        try {

            f = new FileWriter(name);
            b = new BufferedWriter(f);

            b.write("الرقم الجامعي للمستعيرة" + "\tالرقم العام للمصدر المعار" + "\tتاريخ الاعارة" + "\tعدد الايام للمستعيرة");
            b.newLine();

            //PreparedStatement search = null;
            //connction();
            PreparedStatement st = connection.prepareStatement("select Borrower_ID, item, Time_Of_Borrowing, dayes_of_borrowing from borrowing where State like '%" + in + "%'");
            ResultSet r = st.executeQuery();
            //int i = 1;
            while (r.next()) {
                b.write(r.getInt(1) + "\t");
                b.write("B-" + r.getInt(2) + "\t");
                b.write(r.getString(3));
                b.write("\t" + r.getInt(4));
                //System.out.println(r.getInt(i));
                //i++;
                b.newLine();

            }

            printBorrowInfo_J(f, b);
            //b.close();

        } catch (IOException ex) {
            Logger.getLogger(borrowed.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(borrowed.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void printBorrowInfo_J(FileWriter f, BufferedWriter b) {

        String in = "in progress";

        try {

            //f = new FileWriter(name);
            //b = new BufferedWriter(f);
            //b.write("الرقم الجامعي للمستعيرة" + "\tالرقم العام للمصدر المعار" + "\tتاريخ الاعارة" + "\tعدد الايام للمستعيرة");
            //b.newLine();
            //PreparedStatement search = null;
            //connction();
            PreparedStatement st = connection.prepareStatement("select Borrower_ID, item, Time_Of_Borrowing, dayes_of_borrowing from borrowing_j where State like '%" + in + "%'");
            ResultSet r = st.executeQuery();
            //int i = 1;
            while (r.next()) {
                b.write(r.getInt(1) + "\t");
                b.write("J-" + r.getInt(2) + "\t");
                b.write(r.getString(3));
                b.write("\t" + r.getInt(4));
                //System.out.println(r.getInt(i));
                //i++;
                b.newLine();

            }
            printBorrowInfo_L(f,b);
            //b.close();

        } catch (IOException ex) {
            Logger.getLogger(borrowed.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(borrowed.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }    
        
    
    
    

    public void printBorrowInfo_L(FileWriter f, BufferedWriter b) {
// borrowing_p
        String in = "in progress";

        try {

            //f = new FileWriter(name);
            //b = new BufferedWriter(f);
            //b.write("الرقم الجامعي للمستعيرة" + "\tالرقم العام للمصدر المعار" + "\tتاريخ الاعارة" + "\tعدد الايام للمستعيرة");
            //b.newLine();
            //PreparedStatement search = null;
            //connction();
            PreparedStatement st = connection.prepareStatement("select Borrower_ID, item, Time_Of_Borrowing, dayes_of_borrowing from borrowing_l where State like '%" + in + "%'");
            ResultSet r = st.executeQuery();
            //int i = 1;
            while (r.next()) {
                b.write(r.getInt(1) + "\t");
                b.write("L-" + r.getInt(2) + "\t");
                b.write(r.getString(3));
                b.write("\t" + r.getInt(4));
                //System.out.println(r.getInt(i));
                //i++;
                b.newLine();

            }

            b.close();

        } catch (SQLException ex) {
            Logger.getLogger(borrowed.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(borrowed.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void printBorrowInfo_P(FileWriter f, BufferedWriter b){
        
        String in = "in progress";

        try {

            //f = new FileWriter(name);
            //b = new BufferedWriter(f);
            //b.write("الرقم الجامعي للمستعيرة" + "\tالرقم العام للمصدر المعار" + "\tتاريخ الاعارة" + "\tعدد الايام للمستعيرة");
            //b.newLine();
            //PreparedStatement search = null;
            //connction();
            PreparedStatement st = connection.prepareStatement("select Borrower_ID, item, Time_Of_Borrowing, dayes_of_borrowing from borrowing_p where State like '%" + in + "%'");
            ResultSet r = st.executeQuery();
            //int i = 1;
            while (r.next()) {
                b.write(r.getInt(1) + "\t");
                b.write("P-" + r.getInt(2) + "\t");
                b.write(r.getString(3));
                b.write("\t" + r.getInt(4));
                //System.out.println(r.getInt(i));
                //i++;
                b.newLine();

            }
            //printBorrowInfo_L(f,b);
            b.close();
        
        
        
        
        
        
    }   catch (SQLException ex) {
            Logger.getLogger(borrowed.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(borrowed.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }   
    
}
