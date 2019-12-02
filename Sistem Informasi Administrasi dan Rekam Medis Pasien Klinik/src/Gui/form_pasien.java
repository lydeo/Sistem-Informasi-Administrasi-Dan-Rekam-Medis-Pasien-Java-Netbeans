/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Main.KoneksiDatabase;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
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
public class form_pasien extends javax.swing.JFrame {

    /**
     * Creates new form form_periksa
     */
    public form_pasien() {
        initComponents();    
    }

    form_pasien(String no_rm) throws SQLException {
        initComponents();
        jButton1.hide();
        btn_update.hide();
        btn_edit.hide();        
        Connection kon = KoneksiDatabase.getConnection();
        try{
            String slct ="SELECT * FROM tb_pasien where no_rm='"+no_rm+"'";
            Statement st = kon.createStatement();
            ResultSet rs = st.executeQuery(slct);
            while(rs.next()){
                norm.setText(rs.getString(1));
                Nama.setText(rs.getString(2));
                JK.setSelectedItem(rs.getString(4));
                darah.setSelectedItem(rs.getString(5));
                Alamat.setText(rs.getString(7));
                Telepon.setText(rs.getString(8));
            }
        }
        catch (SQLException e){
                JOptionPane.showMessageDialog(null,"error :"+e.getMessage());
        }
        
        Object header[]={"No. RM","No. Periksa","Tanggal","Keluhan","Tekanan Darah"};
        DefaultTableModel data = new DefaultTableModel(null, header);
        tableRiwayat.setModel(data);
        try{
            String slct ="SELECT * FROM tb_riwayat where no_rm='"+no_rm+"'";
            Statement st = kon.createStatement();
            ResultSet rs = st.executeQuery(slct);
            while(rs.next()){
                String kolom1 = rs.getString(2);
                String kolom2 = rs.getString(1);
                String kolom3 = rs.getString(3);
                String kolom4 = rs.getString(8);
                String kolom5 = rs.getString(7);
                String kolom[] = {kolom1, kolom2, kolom3, kolom4, kolom5};
                data.addRow(kolom);
            }}
        catch (SQLException e){
            JOptionPane.showMessageDialog(null,"error :"+e.getMessage());
        }                
    }
    public void FilterHanyaAngka(java.awt.event.KeyEvent evt){
        char c = evt.getKeyChar();
        if (! ((Character.isDigit(c) ||
                (c == KeyEvent.VK_BACK_SPACE) ||
                (c == KeyEvent.VK_DELETE))
                )
            )
        {
            evt.consume();
        }
    }
    
    form_pasien(String no_rm, String nama, String jk, String gol, String alamat, String telepon) {
        initComponents();
        btn_update.setVisible(false);
        norm.setText(no_rm);
        Nama.setText(nama);
        JK.setSelectedItem(jk);
        darah.setSelectedItem(gol);
        Alamat.setText(alamat);
        Telepon.setText(telepon); 
        selectRiwayat();
    }
    public void selectRiwayat(){
        try{
            Object header[]={"No. RM","No. Periksa","Tanggal","Keluhan","Tekanan Darah","Berat Badan(kg)","Tinggi(cm)"};
            DefaultTableModel data = new DefaultTableModel(null, header);
            tableRiwayat.setModel(data);
            Connection kon = KoneksiDatabase.getConnection();
            String slct ="SELECT * FROM tb_riwayat where no_rm='"+norm.getText()+"'";
            try{
                Statement st = kon.createStatement();
                ResultSet rs = st.executeQuery(slct);
                while(rs.next()){
                    String kolom1 = rs.getString(2);
                    String kolom2 = rs.getString(1);
                    String kolom3 = rs.getString(3);
                    String kolom4 = rs.getString(8);
                    String kolom5 = rs.getString(7);
                    String kolom6 = rs.getString(10);
                    String kolom7 = rs.getString(11);
                    String kolom[] = {kolom1, kolom2, kolom3, kolom4, kolom5, kolom6, kolom7};
                    data.addRow(kolom);
                }}
            catch (SQLException e){
                JOptionPane.showMessageDialog(null,"error :"+e.getMessage());
            }     
        }
            catch (SQLException ex){
                Logger.getLogger(form_admin.class.getName()).log(Level.SEVERE,null, ex);
        }       
    }
    public void updateData(){
        if (Nama.getText().equals("")||Alamat.getText().equals("")||Telepon.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Data tidak boleh kosong", "Error", 1);
        }
        else{
            Nama.setBackground(new java.awt.Color(56,199,203));
            Alamat.setBackground(new java.awt.Color(56,199,203));
            Telepon.setBackground(new java.awt.Color(56,199,203));
            btn_update.setVisible(false);
            try{
                Connection kon = KoneksiDatabase.getConnection();
                Statement st = kon.createStatement();
                String sql ="update tb_pasien set nama_pasien='"+Nama.getText()+"', alamat_pasien='"+Alamat.getText()+"',jenis_kelamin='"+JK.getSelectedItem()+"', gol_darah='"+darah.getSelectedItem()+"', telepon='"+Telepon.getText()+"' where no_rm ='"+norm.getText()+"'";
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"Data Pasien Berhasil Diupdate");                
            }
             catch (HeadlessException | SQLException e){
                JOptionPane.showMessageDialog(null,"error : "+e.getMessage());
            } 
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
        norm = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Nama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        gol = new javax.swing.JLabel();
        JK = new javax.swing.JComboBox<>();
        darah = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Telepon = new javax.swing.JTextField();
        btn_edit = new javax.swing.JButton();
        Alamat = new javax.swing.JTextField();
        btn_update = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRiwayat = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tindakan = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        diagnosa = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        resep = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        dokter = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btn_cetak = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PASIEN PANEL");

        jPanel1.setBackground(new java.awt.Color(56, 199, 203));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATA PASIEN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 1, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setText("No RM             :");

        norm.setEditable(false);
        norm.setBackground(new java.awt.Color(56, 199, 203));
        norm.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        norm.setBorder(null);
        norm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setText("Nama               :");

        Nama.setEditable(false);
        Nama.setBackground(new java.awt.Color(56, 199, 203));
        Nama.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        Nama.setBorder(null);
        Nama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NamaKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setText("Jenis Kelamin");

        gol.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        gol.setText("Gol Darah");

        JK.setBackground(new java.awt.Color(56, 199, 203));
        JK.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        JK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "L", "P" }));
        JK.setBorder(null);

        darah.setBackground(new java.awt.Color(56, 199, 203));
        darah.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        darah.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "AB", "B", "O" }));
        darah.setBorder(null);

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setText("Alamat         :");

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setText("Telepon      :");

        Telepon.setEditable(false);
        Telepon.setBackground(new java.awt.Color(56, 199, 203));
        Telepon.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        Telepon.setBorder(null);
        Telepon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TeleponKeyTyped(evt);
            }
        });

        btn_edit.setBackground(new java.awt.Color(255, 255, 255));
        btn_edit.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_edit.setText("EDIT");
        btn_edit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_edit.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        Alamat.setEditable(false);
        Alamat.setBackground(new java.awt.Color(56, 199, 203));
        Alamat.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        Alamat.setBorder(null);
        Alamat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AlamatKeyTyped(evt);
            }
        });

        btn_update.setBackground(new java.awt.Color(255, 255, 255));
        btn_update.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/upd.jpg"))); // NOI18N
        btn_update.setText("UPDATE");
        btn_update.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_update.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(norm, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nama, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gol)
                    .addComponent(jLabel3))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(darah, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JK, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(90, 90, 90)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Telepon, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(Alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(norm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(Alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gol)
                    .addComponent(darah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(JK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(Telepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_update, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "RIWAYAT PEMERIKSAAN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 1, 18))); // NOI18N

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 204));
        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        tableRiwayat.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        tableRiwayat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableRiwayat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableRiwayatMouseClicked(evt);
            }
        });
        tableRiwayat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableRiwayatKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tableRiwayat);

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel8.setText("TINDAKAN  :");

        tindakan.setEditable(false);
        tindakan.setColumns(20);
        tindakan.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tindakan.setRows(5);
        tindakan.setBorder(null);
        jScrollPane3.setViewportView(tindakan);

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel9.setText("DIAGNOSA  :");

        diagnosa.setEditable(false);
        diagnosa.setColumns(20);
        diagnosa.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        diagnosa.setRows(5);
        diagnosa.setBorder(null);
        jScrollPane4.setViewportView(diagnosa);

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel10.setText("RESEP         :");

        resep.setEditable(false);
        resep.setColumns(20);
        resep.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        resep.setRows(5);
        resep.setBorder(null);
        jScrollPane5.setViewportView(resep);

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel11.setText("DOKTER      :");

        dokter.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4)
                    .addComponent(dokter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dokter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(56, 199, 203));

        btn_cetak.setBackground(new java.awt.Color(255, 255, 255));
        btn_cetak.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_cetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/prnt.jpg"))); // NOI18N
        btn_cetak.setText("CETAK RIWAYAT");
        btn_cetak.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_cetak.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btn_cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetakActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/dok.jpg"))); // NOI18N
        jButton1.setText("PERIKSA");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_cetak, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cetak, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        btn_update.setVisible(true);
        
        Nama.setEditable(true);
        Nama.setBackground(new java.awt.Color(255, 255, 255));
        
        Alamat.setEditable(true);
        Alamat.setBackground(new java.awt.Color(255, 255, 255));
        Telepon.setEditable(true);
        Telepon.setBackground(new java.awt.Color(255, 255, 255));
        JK.setBackground(new java.awt.Color(255, 255, 255));
        darah.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
       updateData();
        
    }//GEN-LAST:event_btn_updateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String no_rm, nama;
            nama = Nama.getText();
            no_rm = norm.getText();
            form_periksa periksa = new form_periksa(nama, no_rm);
            periksa.show();
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(form_pasien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TeleponKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TeleponKeyTyped
       if ( Telepon.getText().length() == 12 ) {
                evt.consume();
                FilterHanyaAngka(evt);
            }
    }//GEN-LAST:event_TeleponKeyTyped

    private void NamaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NamaKeyTyped
        if ( Nama.getText().length() == 25 ) {
                evt.consume();
        }
    }//GEN-LAST:event_NamaKeyTyped

    private void AlamatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AlamatKeyTyped
        if ( Telepon.getText().length() == 40 ) {
                evt.consume();
                FilterHanyaAngka(evt);
            }
    }//GEN-LAST:event_AlamatKeyTyped

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked

    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void tableRiwayatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableRiwayatKeyPressed
        
    }//GEN-LAST:event_tableRiwayatKeyPressed

    private void tableRiwayatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableRiwayatMouseClicked
        int row = tableRiwayat.getSelectedRow();
        if (row!=-1){
            try{
                Connection kon = KoneksiDatabase.getConnection();
                String slct ="SELECT * FROM tb_riwayat where no_periksa='"+tableRiwayat.getValueAt(row, 1).toString()+"'";
                Statement st = kon.createStatement();
                ResultSet rs = st.executeQuery(slct);
                while(rs.next()){
                    tindakan.setText(rs.getString(4));
                    diagnosa.setText(rs.getString(5));
                    resep.setText(rs.getString(6));
                    dokter.setText(rs.getString(9));
                }
            } catch (SQLException ex) {
                Logger.getLogger(form_pasien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tableRiwayatMouseClicked

    private void btn_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetakActionPerformed
        btn_cetak.show();
            try{
            Map param = new HashMap();
            //File file = new File("src/laporan/laporanRiwayat.jrxml");
            InputStream file = getClass().getResourceAsStream("/laporan/laporanRiwayat.jrxml");
            param.put("nama", String.valueOf(Nama.getText()));
            param.put("gol", String.valueOf(darah.getSelectedItem()));
            param.put("norm", Integer.parseInt(norm.getText()));
            param.put("rm", String.valueOf(norm.getText()));
            
            JasperDesign jasperDesign = JRXmlLoader.load(file);
            JasperReport jasperReport= JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,param,KoneksiDatabase.getConnection());
            
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_cetakActionPerformed

    private void normActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_normActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_normActionPerformed

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
            java.util.logging.Logger.getLogger(form_pasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_pasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_pasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_pasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_pasien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Alamat;
    private javax.swing.JComboBox<String> JK;
    private javax.swing.JTextField Nama;
    private javax.swing.JTextField Telepon;
    private javax.swing.JButton btn_cetak;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> darah;
    private javax.swing.JTextArea diagnosa;
    private javax.swing.JLabel dokter;
    private javax.swing.JLabel gol;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField norm;
    private javax.swing.JTextArea resep;
    private javax.swing.JTable tableRiwayat;
    private javax.swing.JTextArea tindakan;
    // End of variables declaration//GEN-END:variables
}
