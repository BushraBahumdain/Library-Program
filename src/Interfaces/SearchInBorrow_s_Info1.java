/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DB.Borrowers;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author REEN
 */
public class SearchInBorrow_s_Info1 extends javax.swing.JFrame {

    /**
     * Creates new form SearchInBorrowInfo
     */
    FileWriter fw;
    BufferedWriter bw;
    static int bid=0;
    public SearchInBorrow_s_Info1() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton14 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        id = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton14.setBackground(new java.awt.Color(73, 84, 100));
        jButton14.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jButton14.setText("بحث");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 120, 40));

        jButton11.setBackground(new java.awt.Color(73, 84, 100));
        jButton11.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jButton11.setText("اضافة جديدة");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 550, 250, 60));

        id.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jPanel1.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, 360, 40));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel6.setText("ادخلي رقم المستعيرة");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 320, 170, 30));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel13.setText("بيانات المستعيرين");
        jLabel13.setToolTipText("");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 380, -1));

        jButton17.setBackground(new java.awt.Color(187, 191, 202));
        jButton17.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jButton17.setText("اضافة الى المكتبة");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 70, 270, 60));

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

        jButton1.setBackground(new java.awt.Color(187, 191, 202));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setText("تسجيل الخروج");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 10, 120, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/insert_book - Copy.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:

        
        new add_new_broower().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:

        if(id.getText().isEmpty()){
              JOptionPane.showMessageDialog(this, " الرجاء تعبئة حقل البحث ");
        }else{
         bid = Integer.parseInt(id.getText());
        Borrowers b = new Borrowers(bid);
        boolean check = b.search(b.ID);
        if (check) {
            b.Extra(b.ID);

             try {
                 new Show_Info().setVisible(true);
                  this.dispose();
             } catch (FileNotFoundException ex) {
                 Logger.getLogger(SearchInBorrow_s_Info1.class.getName()).log(Level.SEVERE, null, ex);
             }
        
           } else {
            JOptionPane.showMessageDialog(this, " رقم المستخدم غير موجود");
        }

        } 
        
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:

        new add().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton17ActionPerformed

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int r = JOptionPane.showConfirmDialog(this, "هل تريد تسجيل الخروج؟", "تأكيد", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (r == JOptionPane.YES_OPTION) {

            new User().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(SearchInBorrow_s_Info1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchInBorrow_s_Info1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchInBorrow_s_Info1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchInBorrow_s_Info1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchInBorrow_s_Info1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
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
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
