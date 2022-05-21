/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DB.Book;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author REEN
 */
public class AddBookOld extends javax.swing.JFrame {

    /**
     * Creates new form AddBook
     */
    public AddBookOld() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        Riviser = new javax.swing.JTextField();
        label = new javax.swing.JTextField();
        publisher = new javax.swing.JTextField();
        author = new javax.swing.JTextField();
        translator = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pages = new javax.swing.JTextField();
        print_num = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Classification_number = new javax.swing.JTextField();
        Label_type = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        publish_place = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        Publishing_Year = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        Number_Of_actuel_copies = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                formAncestorResized(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(187, 191, 202));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setText("تسجيل الخروج");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 10, 120, 40));

        Riviser.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(Riviser, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 420, 40));

        label.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 360, 40));

        publisher.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(publisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 480, 360, 40));

        author.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(author, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 290, 360, 40));

        translator.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(translator, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, 360, 40));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("* المؤلف (3 بحد أقصى )");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 260, 220, 30));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("*المترجم (3 بحد أقصى)");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 360, 200, 30));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setText("* الناشر ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 450, 80, 30));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setText("* المراجع (3 بحد أقصى)");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, 210, 30));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel6.setText("* عنوان الكتاب");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 160, 130, 30));

        pages.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        pages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagesActionPerformed(evt);
            }
        });
        jPanel1.add(pages, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 180, 40));

        print_num.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(print_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 100, 40));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setText("عدد الصفحات");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 120, 30));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel8.setText("* رقم الطبعه");
        jLabel8.setToolTipText("");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 100, 30));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel9.setText("* رقم التصنيف");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 120, 30));

        Classification_number.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(Classification_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 220, 40));

        Label_type.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(Label_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 180, 40));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel11.setText("نوع التصنيف");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 120, 30));

        publish_place.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(publish_place, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 480, 200, 40));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel12.setText(" مكان النشر");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 450, 110, 30));

        Publishing_Year.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(Publishing_Year, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, 200, 40));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel13.setText("سنة النشر");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 450, 90, 30));

        Number_Of_actuel_copies.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Number_Of_actuel_copies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Number_Of_actuel_copiesActionPerformed(evt);
            }
        });
        jPanel1.add(Number_Of_actuel_copies, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 100, 40));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel15.setText("* عدد النسخ");
        jLabel15.setToolTipText("");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 100, 30));

        jButton13.setBackground(new java.awt.Color(73, 84, 100));
        jButton13.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton13.setText("مسح الكل");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 580, 250, 60));

        jButton2.setBackground(new java.awt.Color(187, 191, 202));
        jButton2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jButton2.setText("البحث في المكتبة");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 140, 270, 60));

        jButton3.setBackground(new java.awt.Color(187, 191, 202));
        jButton3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jButton3.setText("بيانات المكتبة");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 210, 270, 60));

        jButton4.setBackground(new java.awt.Color(187, 191, 202));
        jButton4.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jButton4.setText("بيانات المستعيرين ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 280, 270, 60));

        jButton15.setBackground(new java.awt.Color(187, 191, 202));
        jButton15.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jButton15.setText(" الاعارة");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 350, 270, 60));

        jButton5.setBackground(new java.awt.Color(187, 191, 202));
        jButton5.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jButton5.setText("الاسترجاع");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 420, 270, 60));

        jButton6.setBackground(new java.awt.Color(187, 191, 202));
        jButton6.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jButton6.setText("البحث في بيانات الاعارة");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 490, 270, 60));

        jButton7.setBackground(new java.awt.Color(187, 191, 202));
        jButton7.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jButton7.setText("التقارير");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 560, 270, 60));

        jButton8.setBackground(new java.awt.Color(187, 191, 202));
        jButton8.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jButton8.setText("النسخ الاحتياطي");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 630, 270, 60));

        jButton17.setBackground(new java.awt.Color(187, 191, 202));
        jButton17.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jButton17.setText("اضافة الى المكتبة");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 70, 270, 60));

        jButton14.setBackground(new java.awt.Color(73, 84, 100));
        jButton14.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton14.setText("اضافة");
        jButton14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton14MouseClicked(evt);
            }
        });
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 580, 250, 60));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel14.setText("إضافة كتاب");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 190, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/insert_book - Copy.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int r = JOptionPane.showConfirmDialog(this, "هل تريد تسجيل الخروج؟", "تأكيد", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (r == JOptionPane.YES_OPTION) {
           
            new User().setVisible(true);
             this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
       
        new Search_inLibrary1().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
       
        new Library_info1().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        new SearchInBorrow_s_Info1().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        
        new make_a_barow().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
       
        new Recovry().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
       
        new SearchInBorrowInfo().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
       
        new report().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
       
        new BackUp().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
      
        new add().setVisible(true);
          this.dispose();
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton14MouseClicked
        // TODO add your handling code here:
        String au1 = null;
        String au2 = "";
        String au3 = "";
        String tr1 = "";
        String tr2 = "";
        String tr3 = "";
        String re1 = "";
        String re2 = "";
        String re3 = "";
        boolean check = true;
        boolean done = false;
        boolean c1 = false, c2 = false, c4 = false, c5 = false;
        Pattern pattern;
        Matcher match;
        boolean val;
        System.out.println(check);

        if (label.getText().trim().isEmpty() || this.Classification_number.getText().trim().isEmpty() || this.print_num.getText().trim().isEmpty()
                || this.author.getText().trim().isEmpty()  ||  this.translator.getText().trim().isEmpty()
                || this.Riviser.getText().trim().isEmpty() || this.publisher.getText().trim().isEmpty() || this.Number_Of_actuel_copies.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "            من فضلك !!         \n"
                    + " تحقق من ان جميع البيانات الضرورية معبأه");
            check = false;
            System.out.println(check);
        }
        //دخليهم جوا بعض لين يخلصون بعدين خلي الدن بترو عشان تزبط
        if (check == true) {

            done = false;
            System.out.println("heere");
            //======================
            if (pages.getText().trim().isEmpty()) {
                c1 = true;
            } else {
                pattern = Pattern.compile("[^0-9]");
                match = pattern.matcher(String.valueOf(pages.getText().trim()));

                val = match.find();
                if (val == true) {

                    JOptionPane.showMessageDialog(this, "يجب ادخال ارقام فقط في عدد الصفحات  ");
                } else {
                    c1 = true;
                }
            }
            //====================
            pattern = Pattern.compile("[^0-9]");
            match = pattern.matcher(String.valueOf(print_num.getText().trim()));

            val = match.find();
            if (val == true) {

                JOptionPane.showMessageDialog(this, "يجب ادخال ارقام فقط في رقم الطبعه  ");
            } else {
                c2 = true;
            }
            //=============
            
            //=============
            match = pattern.matcher(String.valueOf(Number_Of_actuel_copies.getText().trim()));

            val = match.find();
            if (val == true) {

                JOptionPane.showMessageDialog(this, "يجب ادخال ارقام فقط في عدد النسخ  ");
            } else {
                c4 = true;
            }
            //============
            if (Publishing_Year.getText().trim().isEmpty()) {
                c5 = true;
            } else {
                pattern = Pattern.compile("[^0-9]");
                match = pattern.matcher(String.valueOf(Publishing_Year.getText().trim()));

                val = match.find();
                if (val == true) {

                    JOptionPane.showMessageDialog(this, "يجب ادخال ارقام فقط في سنة النشر  ");
                } else {
                    c5 = true;
                }
            }
            if (c1 && c2 && c4 && c5 == true) {
                done = true;
            }
        }
        boolean b=true;
        if (done == true) {
            String[] authors = this.author.getText().split(",");
            if (authors.length == 1) {
                au1 = authors[0];
                au2 = null;
                au3 = null;
            } else if (authors.length == 2) {
                au1 = authors[0];
                au2 = authors[1];
                au3 = null;
            } else if (authors.length == 3) {
                au1 = authors[0];
                au2 = authors[1];
                au3 = authors[2];
            }else{
                b=false;
                 JOptionPane.showMessageDialog(this, "العدد الاقصى للمؤلفين هو 3  ");
            }
            //Translator
            String[] translator = this.translator.getText().split(",");
            if (translator.length == 1) {
                tr1 = translator[0];
                tr2 = null;
                tr3 = null;
            } else if (translator.length == 2) {
                tr1 = translator[0];
                tr2 = translator[1];
                tr3 = null;
            } else if (translator.length == 3) {
                tr1 = translator[0];
                tr2 = translator[1];
                tr3 = translator[2];
            }else{
                  b=false;
                 JOptionPane.showMessageDialog(this, "العدد الاقصى للمترجم هو 3  ");
            }
            //riviser
            String[] riviser = this.Riviser.getText().split(",");
            if (riviser.length == 1) {
                re1 = riviser[0];
                re2 = null;
                re3 = null;
            } else if (riviser.length == 2) {
                re1 = riviser[0];
                re2 = riviser[1];
                re3 = null;
            } else if (riviser.length == 3) {
                re1 = riviser[0];
                re2 = riviser[1];
                re3 = riviser[2];
            }else{
                  b=false;
                 JOptionPane.showMessageDialog(this, "العدد الاقصى للمراجع هو 3  ");
            }
            if(b==false){
                
            }else{
                
          
            if (this.Label_type.getText().trim().isEmpty()) {
                //System.out.println("TRUE1");
                this.Label_type.setText(null);
            }
            if (this.pages.getText().trim().isEmpty()) {
                // System.out.println("TRUE1");
                this.pages.setText("0");

            }
            if (this.publish_place.getText().trim().isEmpty()) {
                // System.out.println("TRUE1");
                this.publish_place.setText(null);
            }
            if (this.Publishing_Year.getText().trim().isEmpty()) {
                // System.out.println("TRUE1");
                this.Publishing_Year.setText("0");
            }
            if (this.translator.getText().trim().equalsIgnoreCase("0")) {
                this.translator.setText(null);
            }
            if (this.Riviser.getText().trim().equalsIgnoreCase("0")) {
                this.Riviser.setText(null);
            }
            int resutl = JOptionPane.showConfirmDialog(this, "هل انت متأكده من جميع البيانات \n ", "رسالة تحذيرية !!!", JOptionPane.YES_NO_OPTION);

            if (resutl == JOptionPane.YES_OPTION) {
                Book book = new Book(this.Classification_number.getText(), this.label.getText(), au1, au2, au3, tr1, tr2, tr3, re1, re2, re3,
                        Integer.parseInt(this.print_num.getText()), this.publisher.getText(), this.publish_place.getText(),
                         Integer.parseInt(this.Publishing_Year.getText()), Integer.parseInt(this.pages.getText()), this.Label_type.getText(),
                        Integer.parseInt(this.Number_Of_actuel_copies.getText()));
                book.addBookNEW();
                int book_id = book.getBook_ID(this.label.getText().trim());
                JOptionPane.showMessageDialog(this, "عنوان الكتاب :" + this.label.getText() + "\n"
                        + "الرقم العام: " + book_id);
               
            } else {
                

            }

        }}
    }//GEN-LAST:event_jButton14MouseClicked

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
       
        new AddBookOld().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void Number_Of_actuel_copiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Number_Of_actuel_copiesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Number_Of_actuel_copiesActionPerformed

    private void pagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pagesActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentResized

    private void formAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_formAncestorResized
        // TODO add your handling code here:
    }//GEN-LAST:event_formAncestorResized

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddBookOld.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddBookOld.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddBookOld.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddBookOld.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new AddBookOld().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Classification_number;
    private javax.swing.JTextField Label_type;
    private javax.swing.JTextField Number_Of_actuel_copies;
    private javax.swing.JTextField Publishing_Year;
    private javax.swing.JTextField Riviser;
    private javax.swing.JTextField author;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField label;
    private javax.swing.JTextField pages;
    private javax.swing.JTextField print_num;
    private javax.swing.JTextField publish_place;
    private javax.swing.JTextField publisher;
    private javax.swing.JTextField translator;
    // End of variables declaration//GEN-END:variables
}
