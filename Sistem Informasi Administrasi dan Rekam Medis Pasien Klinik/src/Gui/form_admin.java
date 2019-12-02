/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Main.KoneksiDatabase;;
import java.awt.HeadlessException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;  
import java.text.DateFormat;  
import java.text.SimpleDateFormat;   
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Deo
 */
public class form_admin extends javax.swing.JFrame {
    /**
     * Creates new form form_admin
     */
    public form_admin() {
        initComponents();
        
    }    
    public form_admin(String nama) {
        initComponents();
        selectDataPegawai();
        Tanggal tgl = new Tanggal();
        jLabel6.setText(tgl.getTanggal());
        selectTanggal();
        jLabel2.setText(nama);
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
        String tahun;
        tahun = jLabel6.getText().substring(2, 4);
        jLabel7.setText(tahun);
    }
    public void selectDataPegawai(){
        try{                                        
            scrollpane.show();
            Object header[]={"Id Pegawai","Nama","Alamat","Telepon","Username","Password","Jabatan"};//membuat nama kolom tabel
            DefaultTableModel data = new DefaultTableModel(null, header);
            tabelPegawai.setModel(data);
            Connection kon = KoneksiDatabase.getConnection();
            String slct ="SELECT * FROM tb_pegawai order by nama_pegawai"; //perintah sql untuk select semua record pada tb_pegawai
            try{
                Statement st = kon.createStatement();
                ResultSet rs = st.executeQuery(slct);
                while(rs.next()){
                    String kolom1 = rs.getString(1);
                    String kolom2 = rs.getString(2);
                    String kolom3 = rs.getString(3);
                    String kolom4 = rs.getString(4);
                    String kolom5 = rs.getString(5);
                    String kolom6 = rs.getString(6);
                    String kolom7 = rs.getString(7);
                    String kolom[] = {kolom1, kolom2, kolom3, kolom4, kolom5, kolom6, kolom7};
                    data.addRow(kolom);//menambahkan hasil dari perintah sql kedalam tabel
                }}
            catch (SQLException e){
                JOptionPane.showMessageDialog(null,"error :"+e.getMessage());
            }  
        }
            catch (SQLException ex){
                Logger.getLogger(form_admin.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    public void selectDataDokter(){
        try{                                        
            scrollpane.show();
            Object header[]={"Id Dokter","Nama","Alamat","Telepon","Username","Password","Jadwal Praktek"};//membuat nama kolom tabel
            DefaultTableModel data = new DefaultTableModel(null, header);
            tabelPegawai.setModel(data);
            Connection kon = KoneksiDatabase.getConnection();
            String slct ="SELECT * FROM tb_dokter order by nama_dokter";//perintah sql untuk select semua record pada tb_dokter
            try{
                Statement st = kon.createStatement();
                ResultSet rs = st.executeQuery(slct);
                while(rs.next()){
                    String kolom1 = rs.getString(1);
                    String kolom2 = rs.getString(2);
                    String kolom3 = rs.getString(3);
                    String kolom4 = rs.getString(4);
                    String kolom5 = rs.getString(5);
                    String kolom6 = rs.getString(6);
                    String kolom7 = rs.getString(7);
                    String kolom[] = {kolom1, kolom2, kolom3, kolom4, kolom5, kolom6, kolom7};
                    data.addRow(kolom);//untuk menambahkan hasil dari perintah sql ke dalam tabel
                }}
            catch (SQLException e){
                JOptionPane.showMessageDialog(null,"error :"+e.getMessage());
            }
            
        }
            catch (SQLException ex){
                Logger.getLogger(form_admin.class.getName()).log(Level.SEVERE,null, ex);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pilihTable = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        scrollpane = new javax.swing.JScrollPane();
        tabelPegawai = new javax.swing.JTable();
        btn_refresh = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_input = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ADMINISTRATION PANEL");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(56, 199, 203));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setText("WELCOME TO ADMINISTRATION PANEL");
        jLabel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setText("nama");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/logo123.jpg"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setText("LOGIN AS");
        jLabel5.setToolTipText("");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(333, 333, 333))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(177, 177, 177))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addContainerGap())))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 3, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addComponent(jLabel7))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel3.setBackground(new java.awt.Color(249, 114, 33));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setText("Pilih Table :");

        pilihTable.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        pilihTable.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pegawai", "Dokter" }));
        pilihTable.setBorder(null);
        pilihTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihTableActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/prnt.jpg"))); // NOI18N
        jButton2.setText("CETAK");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/out.jpg"))); // NOI18N
        jButton1.setText("LOGOUT");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setMargin(new java.awt.Insets(2, 3, 2, 2));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pilihTable, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(pilihTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(954, 954, 954))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DAFTAR PEGAWAI/DOKTER", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 1, 18))); // NOI18N

        scrollpane.setBackground(new java.awt.Color(204, 204, 204));
        scrollpane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollpane.setFont(new java.awt.Font("Gabriola", 0, 14)); // NOI18N

        tabelPegawai.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tabelPegawai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelPegawai.setDoubleBuffered(true);
        tabelPegawai.setGridColor(new java.awt.Color(0, 0, 0));
        tabelPegawai.setName(""); // NOI18N
        tabelPegawai.setRowMargin(3);
        tabelPegawai.setUpdateSelectionOnSort(false);
        tabelPegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPegawaiMouseClicked(evt);
            }
        });
        scrollpane.setViewportView(tabelPegawai);
        tabelPegawai.getAccessibleContext().setAccessibleName("");
        tabelPegawai.getAccessibleContext().setAccessibleDescription("");

        btn_refresh.setBackground(new java.awt.Color(255, 255, 255));
        btn_refresh.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        btn_refresh.setText("REFRESH");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 1034, Short.MAX_VALUE)
                        .addComponent(btn_refresh))
                    .addComponent(scrollpane))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btn_refresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        jPanel4.setBackground(new java.awt.Color(56, 199, 203));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/del.jpg"))); // NOI18N
        jButton4.setText("DELETE");
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.setFocusable(false);
        jButton4.setIconTextGap(2);
        jButton4.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btn_edit.setBackground(new java.awt.Color(255, 255, 255));
        btn_edit.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/upd.jpg"))); // NOI18N
        btn_edit.setText("EDIT");
        btn_edit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_edit.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btn_edit.setMaximumSize(new java.awt.Dimension(105, 33));
        btn_edit.setMinimumSize(new java.awt.Dimension(105, 33));
        btn_edit.setPreferredSize(new java.awt.Dimension(105, 33));
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_input.setBackground(new java.awt.Color(255, 255, 255));
        btn_input.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btn_input.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/add.jpg"))); // NOI18N
        btn_input.setText("INPUT");
        btn_input.setToolTipText("");
        btn_input.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_input.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btn_input.setMaximumSize(new java.awt.Dimension(105, 33));
        btn_input.setMinimumSize(new java.awt.Dimension(105, 33));
        btn_input.setPreferredSize(new java.awt.Dimension(105, 33));
        btn_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(773, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_input, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_input, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        form_login fa = new form_login();
        fa.show();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inputActionPerformed
        try {
            String tahun;
            tahun = jLabel7.getText();//menyimpan tahun untuk keperluan generate id
            inputDataPegawai idp = new inputDataPegawai(tahun);//membuat constructor baru pada form inputDataPegawai
            idp.show();
        } catch (SQLException ex) {
            Logger.getLogger(form_admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_inputActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        int row = tabelPegawai.getSelectedRow();
        if (row == -1){
            JOptionPane.showMessageDialog(null,"Silahkan pilih record yang akan diedit");
        }
        else {          
        String id, r1, r2, r3, r4, r5, r6, item;
        id = tabelPegawai.getValueAt(row, 0).toString();//mengambil value dari baris yang dipilih
        r1 = tabelPegawai.getValueAt(row, 1).toString();
        r2 = tabelPegawai.getValueAt(row, 2).toString();
        r3 = tabelPegawai.getValueAt(row, 3).toString();
        r4 = tabelPegawai.getValueAt(row, 4).toString();
        r5 = tabelPegawai.getValueAt(row, 5).toString();
        r6 = tabelPegawai.getValueAt(row, 6).toString();
        item = (String) pilihTable.getSelectedItem();
        updateDataPegawai udp = new updateDataPegawai(id, r1, r2, r3, r4, r5, r6, item);//membuat constructor baru pada form updateDataPegawai
        udp.show(); 
            } 
    }//GEN-LAST:event_btn_editActionPerformed

    private void tabelPegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPegawaiMouseClicked
       
    }//GEN-LAST:event_tabelPegawaiMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int row = tabelPegawai.getSelectedRow();
            if (row==-1){
                JOptionPane.showMessageDialog(this,"Silahkan pilih record yang akan di hapus");
            }
            else{
        int Pilih = JOptionPane.showConfirmDialog(null,"Anda yakin ingin menghapus record ini?" ,"DELETE",JOptionPane.YES_NO_OPTION);
        if(Pilih == JOptionPane.YES_OPTION){
        String delItem = (String) pilihTable.getSelectedItem();
        if ("Pegawai".equals(delItem)){
            try {
            Connection kon = KoneksiDatabase.getConnection();
                try{                   
                    Statement st = kon.createStatement();
                    String hapus = "Delete from tb_pegawai where id_pegawai='"+tabelPegawai.getValueAt(row, 0).toString()+"'";//perintah sql untuk menghapus
                    st.executeUpdate(hapus);
                    selectDataPegawai();
                    JOptionPane.showMessageDialog(null, "Record Berhasil Dihapus");                    
                }
                catch (HeadlessException | SQLException e){
                    JOptionPane.showMessageDialog(null,"error : "+e.getMessage());
                }       
        } catch (SQLException ex) {
            Logger.getLogger(form_admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        else if("Dokter".equals(delItem)){
            try {
            Connection kon = KoneksiDatabase.getConnection();
                try{
                    Statement st = kon.createStatement();
                    String hapus = "Delete from tb_dokter where id_dokter='"+tabelPegawai.getValueAt(row, 0).toString()+"'";
                    st.executeUpdate(hapus);
                    JOptionPane.showMessageDialog(null, "Record Berhasil Dihapus");
                    selectDataDokter();
                }
                catch (HeadlessException | SQLException e){
                    JOptionPane.showMessageDialog(null,"error : "+e.getMessage());
                }    
        } catch (SQLException ex) {
            Logger.getLogger(form_admin.class.getName()).log(Level.SEVERE, null, ex);
        }         
        }
        }
     else if(Pilih == JOptionPane.NO_OPTION)
            JOptionPane.showMessageDialog(null, "OK");         
            }       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void pilihTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihTableActionPerformed
        if (pilihTable.getSelectedItem() == "Pegawai"){
            selectDataPegawai();

        }
        else if(pilihTable.getSelectedItem() == "Dokter"){
            selectDataDokter();
            
        }
        else{
            scrollpane.hide();
        }
    }//GEN-LAST:event_pilihTableActionPerformed

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        if (pilihTable.getSelectedItem()=="Pegawai"){
            selectDataPegawai();
        }
        else if (pilihTable.getSelectedItem()=="Dokter"){
            selectDataDokter();
        }
        else{
            scrollpane.hide();
        }
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (pilihTable.getSelectedItem()=="Pegawai"){
        try { 
            //File file = new File("src/laporan/laporanPegawai.jrxml");
            InputStream file = getClass().getResourceAsStream("/laporan/laporanPegawai.jrxml");
            JasperDesign jasperDesign = JRXmlLoader.load(file);
            JasperReport jasperReport= JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null,KoneksiDatabase.getConnection());
            
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        else{
            try{
            //File file = new File("src/laporan/laporanDokter.jrxml");
           InputStream file = getClass().getResourceAsStream("/laporan/laporanDokter.jrxml");
            JasperDesign jasperDesign = JRXmlLoader.load(file);
            JasperReport jasperReport= JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null,KoneksiDatabase.getConnection());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(form_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_input;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JComboBox<String> pilihTable;
    private javax.swing.JScrollPane scrollpane;
    private javax.swing.JTable tabelPegawai;
    // End of variables declaration//GEN-END:variables
}
