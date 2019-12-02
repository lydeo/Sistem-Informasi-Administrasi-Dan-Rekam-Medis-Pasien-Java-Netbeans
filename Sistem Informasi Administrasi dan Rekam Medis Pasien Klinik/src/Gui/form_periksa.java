/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Main.KoneksiDatabase;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Deo
 */
public class form_periksa extends javax.swing.JFrame {
    String tanggal;

    /**
     * Creates new form form_periksa
     */
    public form_periksa() {
        initComponents();
    }

    form_periksa(String nama, String no_rm) throws SQLException {
        initComponents();
        Nama.setText(nama);
        norm.setText(no_rm);
        Tanggal tgl = new Tanggal();
        jLabel5.setText(tgl.getTanggal());
        selectTanggal();
        jLabel6.setVisible(false);
        jLabel5.setVisible(false);
        jLabel7.setVisible(false);
       
        
    }
    public class Tanggal{
        private String getTanggal() {          
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");          
        Date date = new Date();          
        return dateFormat.format(date);
    }
    }
    public void selectTanggal(){
        String hari;
        hari = jLabel5.getText().substring(8, 10);
        jLabel6.setText(hari);
    }
    public void generateIdP() throws SQLException{
        Connection kon = KoneksiDatabase.getConnection();
        Statement st;
        ResultSet rs;
        PreparedStatement ps;
        String sql;
        
       try {
            sql="select * from tb_antrian order by tanggal_periksa desc";
            st=kon.createStatement();
            rs=st.executeQuery(sql);
            if (rs.next()) {
                String tgl = rs.getString("tanggal_periksa").substring(8, 10);
                if (tgl.equals(jLabel6.getText())){
                    sql="select * from tb_antrian order by no_antrian desc";
                    st=kon.createStatement();
                    rs=st.executeQuery(sql);
                        if (rs.next()) {
                            String id = rs.getString("no_antrian").substring(0);
                            String AN = "" +(Integer.parseInt(id) + 1);
                            String Nol = "";
                        switch (AN.length()) {
                            case 1:
                                Nol = "00";
                                break;
                            case 2:
                                Nol = "0";
                                break;
                            case 3:
                                Nol = "";
                                break;
                            default:
                                break;
                        }
                            jLabel7.setText(Nol+AN);
                        }
                        else{
                            jLabel7.setText("001");
                        }
                        }
                else{
                    jLabel7.setText("001");
                }
                }
            else{
                    jLabel7.setText("001");
                }
       }         
             
                    
      catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
           }
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        norm = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Nama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Keluhan = new javax.swing.JTextArea();
        btn_submit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("FORM KELUHAN");

        jPanel1.setBackground(new java.awt.Color(56, 199, 203));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(61, 61, 61))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FORM KELUHAN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 1, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setText("No RM");

        norm.setEditable(false);
        norm.setBackground(new java.awt.Color(255, 255, 255));
        norm.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setText("Nama");

        Nama.setEditable(false);
        Nama.setBackground(new java.awt.Color(255, 255, 255));
        Nama.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setText("Tanggal");

        jDateChooser1.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser1PropertyChange(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setText("Keluhan");

        Keluhan.setColumns(20);
        Keluhan.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        Keluhan.setRows(5);
        Keluhan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                KeluhanKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(Keluhan);

        btn_submit.setBackground(new java.awt.Color(255, 255, 255));
        btn_submit.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_submit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/add.jpg"))); // NOI18N
        btn_submit.setText("SUBMIT");
        btn_submit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Nama)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(norm, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_submit, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(norm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_submit, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submitActionPerformed
        try {
            generateIdP();
            if ("".equals(Keluhan.getText())||jDateChooser1.getDate()==null){
                JOptionPane.showMessageDialog(rootPane, "Keluhan dan tanggal tidak bole kosong", "Error", 1);
            }
            else{
                try{
                    Connection kon = KoneksiDatabase.getConnection();
                    Statement st = kon.createStatement();
                    String input ="insert into tb_antrian (no_antrian, no_rm, nama, tanggal_periksa, keluhan) values ('"+jLabel7.getText()+"','"+norm.getText()+"','"+Nama.getText()+"', '"+tanggal+"', '"+Keluhan.getText()+"')";
                    st.executeUpdate(input);
                    JOptionPane.showMessageDialog(null,"Berhasil");
                    this.dispose();
                }
                
                catch (HeadlessException | SQLException e){
                    JOptionPane.showMessageDialog(null,"Error"+ e.getMessage());
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(form_periksa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btn_submitActionPerformed

    private void jDateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser1PropertyChange
        
        if (jDateChooser1.getDate()!=null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            tanggal = simpleDateFormat.format(jDateChooser1.getDate());
        }
    }//GEN-LAST:event_jDateChooser1PropertyChange

    private void KeluhanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KeluhanKeyTyped
        if ( Keluhan.getText().length() == 500 ) {
                evt.consume();
                
            }
    }//GEN-LAST:event_KeluhanKeyTyped

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
            java.util.logging.Logger.getLogger(form_periksa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_periksa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_periksa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_periksa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_periksa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Keluhan;
    private javax.swing.JTextField Nama;
    private javax.swing.JButton btn_submit;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField norm;
    // End of variables declaration//GEN-END:variables
}