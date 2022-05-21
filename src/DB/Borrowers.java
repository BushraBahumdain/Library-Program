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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;

/**
 *
 * @author dell
 */
public class Borrowers extends SourceProduct {

    public int ID;
    public int can_borrow;
    public String name;
    public String email;
    public String national_address;
    public String national_id;
    public int quantity;
    public int national_id_type;
    public int phone_number;
    public String address;
    public int type;

    String URL = "jdbc:mysql://localhost:3306/library";
    String USERNAME = "root"; // use your username of Mysql server
    String PASSWORD = "bushra"; // use your password of Mysql server
    Connection connection = null;
    PreparedStatement preparedStmt = null;
    ResultSet resultSet = null;
    String sqlQuery = "";

    public Borrowers() {
        connction();
    }

    public Borrowers(int ID, int can_borrow, String name, String email, String national_id, int quantity, int national_id_type, int phone_number, String address, int type) {

        this.ID = ID;
        this.can_borrow = can_borrow;
        this.name = name;
        this.email = email;
        // this.national_address = national_address;
        this.national_id = national_id;
        this.quantity = quantity;
        this.national_id_type = national_id_type;
        this.phone_number = phone_number;
        this.address = address;
        this.type = type;
        connction();
    }

    public Borrowers(int ID) {
        this.ID = ID;
        connction();
    }

    public int addNewBorrower() {
        int Bid = 0;

        if (this.ID != 0) {/////////////
            Bid = this.searchForBorrower(this.ID);

        }

        return Bid;
    }

    public int searchForBorrower(int id) {
        int Bnum = 0;

        try {
            Statement stt = connection.createStatement();
            ResultSet r = stt.executeQuery("select * from borrowers where ID=" + id + "");

            if (!r.isBeforeFirst()) {
                System.out.println("adding in progress");

                Statement st1 = connection.createStatement();
                st1.executeUpdate("INSERT INTO borrowers(ID,can_Borrow,Bname,Email,National_ID,Quantity,National_ID_Type,phone_number,Address,type)values('" + ID + "','" + can_borrow + "','" + name + "','" + email + "','" + national_id + "','" + quantity + "','" + national_id_type + "','" + phone_number + "','" + address + "','" + type + "');");
                Bnum = 1;
            } else if (r.next()) {
                // Bnum = r.getInt("ID");
                // System.out.println("Borrower already exists with ID number "+Bnum);
                Bnum = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Bnum;
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

    public int edit(int ID, int can_borrow, String name, String email, String national_id, int quantity, int national_id_type, int phone_number, String address, int type) {
        int i = 0;
        try {
            Statement stt = connection.createStatement();
            ResultSet r = stt.executeQuery("select * from borrowers where ID=" + ID + "");

            if (!r.isBeforeFirst()) {
                System.out.println("NO DATA");
            } else {

                PreparedStatement update;
                update = connection.prepareStatement("update borrowers set can_Borrow= ? ,Bname=? , Email=?,National_ID=?,Quantity=?,National_ID_Type=?,phone_number=?,Address = ?,type=? WHERE ID = ?");
                update.setInt(1, can_borrow);
                update.setString(2, name);
                update.setString(3, email);
//update.setString(4, national_address);
                update.setString(4, national_id);
                update.setInt(5, quantity);
                update.setInt(6, national_id_type);
                update.setInt(7, phone_number);
                update.setString(8, address);
                update.setInt(9, type);
                update.setInt(10, ID);
                update.executeUpdate();
                System.out.println("Done");
                i = 1;
            }
        } catch (SQLException ex) {
            System.out.println("ERROR");
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;

    }

    public boolean search(int id) {
        boolean state = true;
        try {

            //  connction();
            int Bid = -1;
            if (this.ID != 0) {/////////////
                Statement stt = connection.createStatement();
                ResultSet r = stt.executeQuery("select * from borrowers where ID=" + id + "");

                if (!r.isBeforeFirst()) {
                    System.out.println("NO DATA");
                    state = false;
                } else if (r.next()) {
                    int an = r.getInt("ID");
                    this.ID = an;
                    int canB = r.getInt("can_Borrow");
                    this.can_borrow = canB;
                    String bname = r.getString("Bname");
                    System.out.println(bname);
                    this.name = bname;
                    String em = r.getString("Email");
                    this.email = em;
                    //String na = r.getString("National_Address");
                    // this.national_address = na;
                    String ni = r.getString("National_ID");
                    this.national_id = ni;
                    int q = r.getInt("Quantity");
                    this.quantity = q;
                    int nit = r.getInt("National_ID_Type");
                    this.national_id_type = nit;
                    int ph = r.getInt("phone_number");
                    this.phone_number = ph;
                    String ads = r.getString("Address");
                    this.address = ads;
                    int type = r.getInt("type");
                    this.type = type;

                    System.out.println(an + " " + canB + " " + bname + " " + em + /*" " +na+ */ " " + ni + " " + q + " " + nit + " " + ph + " " + ads + " " + type + " ");
                    Bid = an;
                }

            } else {
                Bid = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        return state;
    }

    public int deleteBorrower(int ID) {
        int i = 0;
        try {
            connction();
            int Bid = -1;
            if (this.ID != 0) {/////////////
                Statement stt = connection.createStatement();
                ResultSet r = stt.executeQuery("select * from borrowers where ID=" + ID + "");

                if (!r.isBeforeFirst()) {
                    System.out.println("No borrower found to be deleted");
                } else if (r.next()) {
                    PreparedStatement delete = connection.prepareStatement("DELETE FROM borrowers WHERE ID = ?");
                    delete.setInt(1, ID);
                    delete.executeUpdate();
                    System.out.println("deleting done");
                    i = 1;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
    // copy

    public void updateborrowed(int ID, int quantity) {

        try {

//Number_Of_actuel_copies, Number_Of_copies_existed, Print_Num, Pages, Label_type, Label, Classification_number, Book_ID, Author1, Author2, Author3, Riviser1, Riviser2, Riviser3, Trnaslator1, Trnaslator2, Trnaslator3, Publisher1, Publishing_Year
            PreparedStatement update;
            update = connection.prepareStatement("update Borrowers set Quantity = ? WHERE ID = ?");
            update.setInt(1, quantity);
            update.setInt(2, ID);
            update.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //  public 

    public int borrowing(Book book, Borrowers borrower, borrower_type borrower_type, int dayes) {
        int BorrowerID = borrower.ID;
        int itemID = book.book_ID;
        int Const_ID = borrower_type.ID;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        int i = 0;
        try {
            if (dayes > borrower_type.dayes) {
                System.out.println("dayes of boorowing is greater that the allowed dayes for this type");
            } else {
                int j = updatTabelsAfterborrowing(book, borrower, borrower_type);
                if (j == 0) {
                    System.out.println("adding in progress");
                    Statement st1 = connection.createStatement();
                    st1.executeUpdate("INSERT INTO borrowing(Borrower_ID,Borrower_Constraints,Time_Of_Borrowing,item,dayes_of_borrowing,State)values('" + BorrowerID + "','" + Const_ID + "','" + dtf.format(now) + "','" + itemID + "','" + dayes + "','" + "in progress" + "');");
                    i = 1;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        //  }
        return i;
    }

    public int updatTabelsAfterborrowing(Book book, Borrowers borrower, borrower_type borrower_type) {
        int i = 0;
        borrowed b = new borrowed();
        int k = b.ViewBorrowed1(book.book_ID, borrower.ID);
        if (book.Number_Of_copies_existed == 1) {
            System.out.println("Sorry you cant borrow this copy");
            i = 1;
        } else {

            if (borrower.quantity >= borrower_type.quantity) {
                System.out.println("Sorry you cant borrow this copy you are out of the aloowed llimit of borrowing which is " + borrower.quantity);
                i = 1;

            } else if (k == 1 && b.State.equalsIgnoreCase("in progress")) {

                System.out.println("you have already borrowed this book");
                i = 1;
            } else {
                int quant = borrower.quantity + 1;
                System.out.println(quant);
                borrower.updateborrowed(borrower.ID, quant);
                int copy = book.Number_Of_copies_existed - 1;
                System.out.println(copy);
                book.updateBookRecord(copy, book.book_ID);
            }
        }
        return i;
    }

    public int retrieve(int item, int borrower) {
        int i = 0;
        try {
            Statement stt = connection.createStatement();
            String s= "in progress";
           // ResultSet r = stt.executeQuery("SELECT * FROM borrowing WHERE Borrower_ID = " + borrower + " and item = " + item + "");
            preparedStmt = connection.prepareStatement("SELECT * FROM borrowing WHERE Borrower_ID=? and item=? and State=?");
            preparedStmt.setInt(1, borrower);
            preparedStmt.setInt(2, item);
            preparedStmt.setString(3, s);
            ResultSet r = preparedStmt.executeQuery();
           if (!r.isBeforeFirst()) {
                System.out.println("NO DATA");
            } else if (r.next()) {
                int Borro = r.getInt("Borrower_ID");
                int Con = r.getInt("Borrower_Constraints");
                String Date = r.getString("Time_Of_Borrowing");
                int ID = r.getInt("Borrowing_ID");
                int itm = r.getInt("item");
                int day = r.getInt("dayes_of_borrowing");
                System.out.println(Borro + " " + Con + " " + Date + " " + ID + " " + itm + " " + day);
                i = check(itm, Borro, Date, day, ID);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Borrowers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    public int check(int ID, int bor, String Date, int dayes, int Borrorwing) throws ParseException {
        int i = 0;
        Book book = new Book();
        book.serachForBookUsingID(ID);
        ///serachForBookUsingClassification_number
        Borrowers borrower = new Borrowers(bor);
        borrower.search(bor);
        System.out.println(borrower.name);
        // borrower_type borrower_type = new borrower_type();
        //borrower_type.search(borrower.type);
        //  Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(Date);  
        //     System.out.println(Date.toString());
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        //  int days = Days.daysBetween(date1, date2).getDays();

        LocalDate localDate1 = LocalDate.parse(Date, df);
        LocalDate localDate2 = LocalDate.parse(df.format(now), df);

        long days = Period.between(localDate1, localDate2).getDays();
        System.out.println(days + "dayes heheh");

        if (book.Number_Of_copies_existed < book.Number_Of_actuel_copies) {
            int copy = book.Number_Of_copies_existed + 1;
            System.out.println(copy);
            book.updateBookRecord(copy, book.book_ID);
            if (dayes < days) {
                System.out.println("LATE supposed to return the book " + dayes + "from " + Date);
                // maybe block the user
            }
            int quant = borrower.quantity - 1;
            System.out.println(quant + " h " + borrower.quantity);
            borrower.updateborrowed(borrower.ID, quant);
            borrower.updateborroweing(Borrorwing);
            i = 1;

        } else {
            System.out.println("all copies is existed in the library");
        }
        return i;
    }

    public void updateborroweing(int ID) {

        try {

//Number_Of_actuel_copies, Number_Of_copies_existed, Print_Num, Pages, Label_type, Label, Classification_number, Book_ID, Author1, Author2, Author3, Riviser1, Riviser2, Riviser3, Trnaslator1, Trnaslator2, Trnaslator3, Publisher1, Publishing_Year
            PreparedStatement update;
            update = connection.prepareStatement("update borrowing set State = ? WHERE Borrowing_ID = ?");
            update.setString(1, "Closed");
            update.setInt(2, ID);
            update.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////
    ////////////////////////////////JOURNAL////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////
    public int borrowing_J(Journal Journal, Borrowers borrower, borrower_type borrower_type, int dayes) {
        int BorrowerID = borrower.ID;
        int itemID = Journal.Journal_ID;
        int Const_ID = borrower_type.ID;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        int i = 0;
        try {
            if (dayes > borrower_type.dayes) {
                System.out.println("dayes of boorowing is grater that the allowed dyes for this type");
            } else {
                int j = updatTabelsAfterborrowing_J(Journal, borrower, borrower_type);
                if (j == 0) {
                    System.out.println("adding in progress");
                    Statement st1 = connection.createStatement();
                    st1.executeUpdate("INSERT INTO borrowing_j(Borrower_ID,Borrower_Constraints,Time_Of_Borrowing,dayes_of_borrowing,State,item)values('" + BorrowerID + "','" + Const_ID + "','" + dtf.format(now) + "','" + dayes + "','" + "in progress" + "','" + itemID + "');");
                    i = 1;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        //  }
        return i;
    }

    public int updatTabelsAfterborrowing_J(Journal Journal, Borrowers borrower, borrower_type borrower_type) {
        int i = 0;
        borrowed b = new borrowed();
        int k = b.ViewBorrowed1_j(Journal.Journal_ID, borrower.ID);
        if (Journal.Number_Of_copies_existed == 1) {
            System.out.println("Sorry you cant borrow this copy");
            i = 1;
        } else {

            if (borrower.quantity >= borrower_type.quantity) {
                System.out.println("Sorry you cant borrow this copy you are out of the aloowed llimit of borrowing which is " + borrower.quantity);
                i = 1;
            } else if (k == 1 && b.State.equalsIgnoreCase("in progress")) {

                System.out.println("you have already borrowed this book");
                i = 1;
            } else {
                int quant = borrower.quantity + 1;
                System.out.println(quant);
                borrower.updateborrowed(borrower.ID, quant);
                int copy = Journal.Number_Of_copies_existed - 1;
                System.out.println(copy);
                Journal.updateJournalRecord(copy, Journal.Journal_ID);
            }
        }
        return i;
    }

    public int retrieve_j(int item, int borrower) {
        int i = 0;
        try {
            Statement stt = connection.createStatement();
              String s= "in progress";
           // ResultSet r = stt.executeQuery("SELECT * FROM borrowing WHERE Borrower_ID = " + borrower + " and item = " + item + "");
            preparedStmt = connection.prepareStatement("SELECT * FROM borrowing_j WHERE Borrower_ID=? and item=? and State=?");
            preparedStmt.setInt(1, borrower);
            preparedStmt.setInt(2, item);
            preparedStmt.setString(3, s);
            ResultSet r = preparedStmt.executeQuery();
            if (!r.isBeforeFirst()) {
                System.out.println("NO DATA");
            } else if (r.next()) {
                int Borro = r.getInt("Borrower_ID");
                int Con = r.getInt("Borrower_Constraints");
                String Date = r.getString("Time_Of_Borrowing");
                int ID = r.getInt("Borrowing_ID");
                int itm = r.getInt("item");
                int day = r.getInt("dayes_of_borrowing");
                System.out.println(Borro + " " + Con + " " + Date + " " + ID + " " + itm + " " + day);
                i = check_j(itm, Borro, Date, day, ID);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Borrowers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    public int check_j(int ID, int bor, String Date, int dayes, int Borrorwing) throws ParseException {
        int i = 0;
        Journal Journal = new Journal();
        Journal.serachForJournalUsingID(ID);
        ///serachForBookUsingClassification_number
        Borrowers borrower = new Borrowers(bor);
        borrower.search(bor);
        System.out.println(borrower.name);
        // borrower_type borrower_type = new borrower_type();
        //borrower_type.search(borrower.type);
        //  Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(Date);  
        //     System.out.println(Date.toString());
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        //  int days = Days.daysBetween(date1, date2).getDays();

        LocalDate localDate1 = LocalDate.parse(Date, df);
        LocalDate localDate2 = LocalDate.parse(df.format(now), df);

        long days = Period.between(localDate1, localDate2).getDays();
        System.out.println(days + "dayes heheh");

        if (Journal.Number_Of_copies_existed < Journal.Number_Of_actuel_copies) {
            int copy = Journal.Number_Of_copies_existed + 1;
            System.out.println(copy);
            Journal.updateJournalRecord(copy, Journal.Journal_ID);
            if (dayes < days) {
                System.out.println("LATE supposed to return the book " + dayes + "from " + Date);
                // maybe block the user
            }
            int quant = borrower.quantity - 1;
            System.out.println(quant + " h " + borrower.quantity);
            borrower.updateborrowed(borrower.ID, quant);
            borrower.updateborroweing_j(Borrorwing);
            i = 1;

        } else {
            System.out.println("all copies is existed in the library");
        }
        return i;
    }

    public void updateborroweing_j(int ID) {

        try {

//Number_Of_actuel_copies, Number_Of_copies_existed, Print_Num, Pages, Label_type, Label, Classification_number, Book_ID, Author1, Author2, Author3, Riviser1, Riviser2, Riviser3, Trnaslator1, Trnaslator2, Trnaslator3, Publisher1, Publishing_Year
            PreparedStatement update;
            update = connection.prepareStatement("update borrowing_j set State = ? WHERE Borrowing_ID = ?");
            update.setString(1, "Closed");
            update.setInt(2, ID);
            update.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////
    ////////////////////////////////Message////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////
    public int borrowing_l(Messag msg, Borrowers borrower, borrower_type borrower_type, int dayes) {
        int BorrowerID = borrower.ID;
        int itemID = msg.msg_id;
        int Const_ID = borrower_type.ID;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        int i = 0;
        try {
            if (dayes > borrower_type.dayes) {
                System.out.println("dayes of boorowing is grater that the allowed dyes for this type");
            } else {
                int j = updatTabelsAfterborrowing_l(msg, borrower, borrower_type);
                if (j == 0) {
                    System.out.println("adding in progress");
                    Statement st1 = connection.createStatement();
                    st1.executeUpdate("INSERT INTO borrowing_l(Borrower_ID,Borrower_Constraints,Time_Of_Borrowing,dayes_of_borrowing,State,item)values('" + BorrowerID + "','" + Const_ID + "','" + dtf.format(now) + "','" + dayes + "','" + "in progress" + "','" + itemID + "');");
                    i = 1;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        //  }
        return i;
    }

    public int updatTabelsAfterborrowing_l(Messag msg, Borrowers borrower, borrower_type borrower_type) {
        int i = 0;
        borrowed b = new borrowed();
        int k = b.ViewBorrowed1_l(msg.msg_id, borrower.ID);
        if (msg.Number_Of_copies_existed == 1) {
            System.out.println("Sorry you cant borrow this copy");
            i = 1;
        } else {

            if (borrower.quantity >= borrower_type.quantity) {
                System.out.println("Sorry you cant borrow this copy you are out of the aloowed llimit of borrowing which is " + borrower.quantity);
                i = 1;
            } else if (k == 1 && b.State.equalsIgnoreCase("in progress")) {

                System.out.println("you have already borrowed this book");
                i = 1;
            } else {
                int quant = borrower.quantity + 1;
                System.out.println(quant);
                borrower.updateborrowed(borrower.ID, quant);
                int copy = msg.Number_Of_copies_existed - 1;
                System.out.println(copy);
                msg.updateMsgRecord(copy, msg.msg_id);
            }
        }
        return i;
    }

    public int retrieve_l(int item, int borrower) {
        int i = 0;
        try {
            Statement stt = connection.createStatement();
             String s= "in progress";
           // ResultSet r = stt.executeQuery("SELECT * FROM borrowing WHERE Borrower_ID = " + borrower + " and item = " + item + "");
            preparedStmt = connection.prepareStatement("SELECT * FROM borrowing_l WHERE Borrower_ID=? and item=? and State=?");
            preparedStmt.setInt(1, borrower);
            preparedStmt.setInt(2, item);
            preparedStmt.setString(3, s);
            ResultSet r = preparedStmt.executeQuery();
            if (!r.isBeforeFirst()) {
                System.out.println("NO DATA");
            } else if (r.next()) {
                int Borro = r.getInt("Borrower_ID");
                int Con = r.getInt("Borrower_Constraints");
                String Date = r.getString("Time_Of_Borrowing");
                int ID = r.getInt("Borrowing_ID");
                int itm = r.getInt("item");
                int day = r.getInt("dayes_of_borrowing");
                System.out.println(Borro + " " + Con + " " + Date + " " + ID + " " + itm + " " + day);
                i = check_l(itm, Borro, Date, day, ID);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Borrowers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    public int check_l(int ID, int bor, String Date, int dayes, int Borrorwing) throws ParseException {
        int i = 0;
        Messag msg = new Messag();
        msg.serachForMsgUsingID(ID);
        ///serachForBookUsingClassification_number
        Borrowers borrower = new Borrowers(bor);
        borrower.search(bor);
        System.out.println(borrower.name);
        // borrower_type borrower_type = new borrower_type();
        //borrower_type.search(borrower.type);
        //  Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(Date);  
        //     System.out.println(Date.toString());
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        //  int days = Days.daysBetween(date1, date2).getDays();

        LocalDate localDate1 = LocalDate.parse(Date, df);
        LocalDate localDate2 = LocalDate.parse(df.format(now), df);

        long days = Period.between(localDate1, localDate2).getDays();
        System.out.println(days + "dayes heheh");

        if (msg.Number_Of_copies_existed < msg.Number_Of_actuel_copies) {
            int copy = msg.Number_Of_copies_existed + 1;
            System.out.println(copy);
            msg.updateMsgRecord(copy, msg.msg_id);
            if (dayes < days) {
                System.out.println("LATE supposed to return the book " + dayes + "from " + Date);
                // maybe block the user
            }
            int quant = borrower.quantity - 1;
            System.out.println(quant + " h " + borrower.quantity);
            borrower.updateborrowed(borrower.ID, quant);
            borrower.updateborroweing_l(Borrorwing);
            i = 1;

        } else {
            System.out.println("all copies is existed in the library");
        }
        return i;

    }

    public void updateborroweing_l(int ID) {

        try {

//Number_Of_actuel_copies, Number_Of_copies_existed, Print_Num, Pages, Label_type, Label, Classification_number, Book_ID, Author1, Author2, Author3, Riviser1, Riviser2, Riviser3, Trnaslator1, Trnaslator2, Trnaslator3, Publisher1, Publishing_Year
            PreparedStatement update;
            update = connection.prepareStatement("update borrowing_l set State = ? WHERE Borrowing_ID = ?");
            update.setString(1, "Closed");
            update.setInt(2, ID);
            update.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////
    ////////////////////////////////Project////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////
    public int borrowing_p(Project Project, Borrowers borrower, borrower_type borrower_type, int dayes) {
        int BorrowerID = borrower.ID;
        int itemID = Project.Project_ID;
        int Const_ID = borrower_type.ID;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        int i = 0;
        try {
            if (dayes > borrower_type.dayes) {
                System.out.println("dayes of boorowing is grater that the allowed dyes for this type");
            } else {
                int j = updatTabelsAfterborrowing_p(Project, borrower, borrower_type);
                if (j == 0) {
                    System.out.println("adding in progress");
                    Statement st1 = connection.createStatement();
                    st1.executeUpdate("INSERT INTO borrowing_p(Borrower_ID,Borrower_Constraints,Time_Of_Borrowing,dayes_of_borrowing,State,item)values('" + BorrowerID + "','" + Const_ID + "','" + dtf.format(now) + "','" + dayes + "','" + "in progress" + "','" + itemID + "');");
                    i = 1;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        //  }
        return i;
    }

    public int updatTabelsAfterborrowing_p(Project Project, Borrowers borrower, borrower_type borrower_type) {
        int i = 0;
        borrowed b = new borrowed();
        int k = b.ViewBorrowed1_p(Project.Project_ID, borrower.ID);
        if (Project.Number_Of_copies_existed == 1) {
            System.out.println("Sorry you cant borrow this copy");
            i = 1;
        } else {

            if (borrower.quantity >= borrower_type.quantity) {
                System.out.println("Sorry you cant borrow this copy you are out of the aloowed llimit of borrowing which is " + borrower.quantity);
                i = 1;
            } else if (k == 1 && b.State.equalsIgnoreCase("in progress")) {

                System.out.println("you have already borrowed this book");
                i = 1;
            } else {
                int quant = borrower.quantity + 1;
                System.out.println(quant);
                borrower.updateborrowed(borrower.ID, quant);
                int copy = Project.Number_Of_copies_existed - 1;
                System.out.println(copy);
                Project.updateProjectRecord(copy, Project.Project_ID);
            }
        }
        return i;
    }

    public int retrieve_p(int item, int borrower) {
        int i = 0;
        try {
            Statement stt = connection.createStatement();
             String s= "in progress";
           // ResultSet r = stt.executeQuery("SELECT * FROM borrowing WHERE Borrower_ID = " + borrower + " and item = " + item + "");
            preparedStmt = connection.prepareStatement("SELECT * FROM borrowing_p WHERE Borrower_ID=? and item=? and State=?");
            preparedStmt.setInt(1, borrower);
            preparedStmt.setInt(2, item);
            preparedStmt.setString(3, s);
            ResultSet r = preparedStmt.executeQuery();
            if (!r.isBeforeFirst()) {
                System.out.println("NO DATA");
            } else if (r.next()) {
                int Borro = r.getInt("Borrower_ID");
                int Con = r.getInt("Borrower_Constraints");
                String Date = r.getString("Time_Of_Borrowing");
                int ID = r.getInt("Borrowing_ID");
                int itm = r.getInt("item");
                int day = r.getInt("dayes_of_borrowing");
                System.out.println(Borro + " " + Con + " " + Date + " " + ID + " " + itm + " " + day);
                i = check_p(itm, Borro, Date, day, ID);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Borrowers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    public int check_p(int ID, int bor, String Date, int dayes, int Borrorwing) throws ParseException {
        int i = 0;
        Project Project = new Project();
        Project.serachForProjectUsingID(ID);
        ///serachForBookUsingClassification_number
        Borrowers borrower = new Borrowers(bor);
        borrower.search(bor);
        System.out.println(borrower.name);
        // borrower_type borrower_type = new borrower_type();
        //borrower_type.search(borrower.type);
        //  Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(Date);  
        //     System.out.println(Date.toString());
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        //  int days = Days.daysBetween(date1, date2).getDays();

        LocalDate localDate1 = LocalDate.parse(Date, df);
        LocalDate localDate2 = LocalDate.parse(df.format(now), df);

        long days = Period.between(localDate1, localDate2).getDays();
        System.out.println(days + "dayes heheh");

        if (Project.Number_Of_copies_existed < Project.Number_Of_actuel_copies) {
            int copy = Project.Number_Of_copies_existed + 1;
            // System.out.println("hjhjhjhjhjhjjhj");
            System.out.println(copy);
            Project.updateProjectRecord(copy, Project.Project_ID);
            if (dayes < days) {
                System.out.println("LATE supposed to return the book " + dayes + "from " + Date);
                // maybe block the user
            }
            int quant = borrower.quantity - 1;
            System.out.println(quant + " h " + borrower.quantity);
            borrower.updateborrowed(borrower.ID, quant);
            borrower.updateborroweing_p(Borrorwing);
            i = 1;

        } else {
            System.out.println("all copies is existed in the library");
        }
        return i;
    }

    public void updateborroweing_p(int ID) {

        try {

//Number_Of_actuel_copies, Number_Of_copies_existed, Print_Num, Pages, Label_type, Label, Classification_number, Book_ID, Author1, Author2, Author3, Riviser1, Riviser2, Riviser3, Trnaslator1, Trnaslator2, Trnaslator3, Publisher1, Publishing_Year
            PreparedStatement update;
            update = connection.prepareStatement("update borrowing_p set State = ? WHERE Borrowing_ID = ?");
            update.setString(1, "Closed");
            update.setInt(2, ID);
            update.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Extra(int id) {
        try {
            Statement st1 = connection.createStatement();
            st1.executeUpdate("INSERT INTO extra(ID)values('" + id + "');");

        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int ExtraD() {
        int i = 0;
        try {

            Statement stt = connection.createStatement();
            ResultSet r = stt.executeQuery("select ID from extra");

            if (!r.isBeforeFirst()) {
                System.out.println("NO DATA");

            } else if (r.next()) {
                int an = r.getInt("ID");
                this.ID = an;
                i = 1;

            }

        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    public void ExtraDel(int ID) {
       
        try {

            PreparedStatement delete = connection.prepareStatement("DELETE FROM extra WHERE ID = ?");
            delete.setInt(1, ID);
            delete.executeUpdate();
            System.out.println("deleting done");

        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }

}
