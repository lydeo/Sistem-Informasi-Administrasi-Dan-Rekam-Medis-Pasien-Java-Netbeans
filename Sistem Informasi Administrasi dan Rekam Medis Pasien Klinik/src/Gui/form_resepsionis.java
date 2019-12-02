/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Main.KoneksiDatabase;
import java.awt.HeadlessException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
public class form_resepsionis extends javax.swing.JFrame {

    /**
     * Creates new form form_resepsionis
     */
    public form_resepsionis() {
        initComponents();
    }
    public form_resepsionis(String nama) {
        initComponents();      
        jLabel2.setText("Mr/Mrs " + nama);
        selectDataPasien();
        Tanggal tgl = new Tanggal();
        jLabel7.setText(tgl.getTanggal());
    }
    public class Tanggal{       //mengambil tanggal untuk keperluan generate id
        private String getTanggal() {          
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");          
        Date date = new Date();          
        return dateFormat.format(date);
    }
    }
    public void cariDataPasien() throws SQLException{
        scrollpane.show();        
        if ("".equals(Cari.getText())){
            JOptionPane.showMessageDialog(null,"Silahkan masukan No RM");
        }
        else{
            try{
                int baris = 0;
                String cari = Cari.getText();
                Object header[]={"No RM","Nama","Tanggal Lahir","Jenis Kelamin(L/P)","Gol Darah","Pekerjaan","Alamat","Telepon"};//membuat nama kolom tabel
                DefaultTableModel data = new DefaultTableModel(null, header);
                tablePasien.setModel(data);
                Connection kon = KoneksiDatabase.getConnection();
                String cariData ="SELECT * FROM tb_pasien where nama_pasien ='"+cari+"'";//perintah sql untuk select sesuai dengan nama pasien
                Statement st = kon.createStatement();
                ResultSet rs = st.executeQuery(cariData);
                    while(rs.next()){
                    baris =rs.getRow();
                    String kolom1 = rs.getString(1);
                    String kolom2 = rs.getString(2);
                    String kolom3 = rs.getString(3);
                    String kolom4 = rs.getString(4);
                    String kolom5 = rs.getString(5);
                    String kolom6 = rs.getString(6);
                    String kolom7 = rs.getString(7);
                    String kolom8 = rs.getString(8);
                    String kolom[] = {kolom1, kolom2, kolom3, kolom4, kolom5, kolom6, kolom7, kolom8};
                    data.addRow(kolom); //menampilkan hasil dari perintah sql ke tabel
                    }
                    if (baris==0){
                        JOptionPane.showMessageDialog(null,"Nama yang dimasukkan salah atau belum terdaftar");
                        selectDataPasien();
                    }                  
                }
            catch (SQLException ex){
                JOptionPane.showMessageDialog(null,"Nama yang dimasukkan salah atau belum terdaftar");                
        }        
            }
        }         
    public void selectDataPasien(){
        try{
            scrollpane.show();
            Object header[]={"No RM","Nama","Tanggal Lahir","Jenis Kelamin(L/P)","Gol Darah","Pekerjaan","Alamat",
                "Telepon"};//membuat nama kolom dari tabel
            DefaultTableModel data = new DefaultTableModel(null, header);
            tablePasien.setModel(data);
            Connection kon = KoneksiDatabase.getConnection();
            String slct ="SELECT * FROM tb_pasien order by nama_pasien";//perintah sql untuk select semua record pada tb_pasien
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
                    String kolom8 = rs.getString(8);
                    String kolom[] = {kolom1, kolom2, kolom3, kolom4, kolom5, kolom6, kolom7, kolom8};
                    data.addRow(kolom);//menambahkan hasil perintah sql kedalam tabel
                }}
            catch (SQLException e){
                JOptionPane.showMessageDialog(null,"error :"+e.getMessage());
            }       
        }
            catch (SQLException ex){
                Logger.getLogger(form_admin.class.getName()).log(Level.SEVERE,null, ex);
        }       
    }
    public void selectAntrian() throws SQLException{
        try{
            scrollpane.show();
            Object header[]={"No Antrian","No RM","Nama","Tanggal","Keluhan"};
            DefaultTableModel data = new DefaultTableModel(null, header);
            tablePasien.setModel(data);
            Connection kon = KoneksiDatabase.getConnection();
            String slct ="SELECT * FROM tb_antrian";
             try{
                Statement st = kon.createStatement();
                ResultSet rs = st.executeQuery(slct);
                while(rs.next()){
                    String kolom1 = rs.getString(1);
                    String kolom2 = rs.getString(2);
                    String kolom3 = rs.getString(3);
                    String kolom4 = rs.getString(4);
                    String kolom5 = rs.getString(5);
                    String kolom[] ={kolom1, kolom2, kolom3, kolom4, kolom5};
                    data.addRow(kolom);
                }
        }
             catch (SQLException e){
                JOptionPane.showMessageDialog(null,"error :"+e.getMessage());
    }
        }
        catch (SQLException ex){
                Logger.getLogger(form_admin.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    public void deleteData(){
        int row = tablePasien.getSelectedRow();        
        if (row==-1){
                JOptionPane.showMessageDialog(this,"Silahkan pilih record yang akan di hapus");
            }
        else{
        int Pilih = JOptionPane.showConfirmDialog(null,"Anda yakin ingin menghapus record ini?" ,"DELETE",JOptionPane.YES_NO_OPTION);
        if(Pilih == JOptionPane.YES_OPTION){
        if (pilihTable.getSelectedItem()=="Pasien"){
         try {
            Connection kon = KoneksiDatabase.getConnection();  
                 try{
                    Statement st = kon.createStatement();
                    String hapus = "Delete from tb_pasien where no_rm='"+tablePasien.getValueAt(row, 0).toString()+"'";
                    st.executeUpdate(hapus);
                    JOptionPane.showMessageDialog(this,"Record berhasil dihapus");
                    selectDataPasien();       
                }
                catch (HeadlessException | SQLException e){
                    JOptionPane.showMessageDialog(null,"error : "+e.getMessage());
                }                  
         }
            catch (SQLException ex) {
            Logger.getLogger(form_admin.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
        else{
            try {
            Connection kon = KoneksiDatabase.getConnection();
                 try{                   
                    Statement st = kon.createStatement();
                    String hapus = "Delete from tb_antrian where no_rm='"+tablePasien.getValueAt(row, 1).toString()+"'";
                    st.executeUpdate(hapus);
                    JOptionPane.showMessageDialog(this,"Record berhasil dihapus");
                    selectAntrian();         
                }
                catch (HeadlessException | SQLException e){
                    JOptionPane.showMessageDialog(null,"error : "+e.getMessage());
                }                  
         }
            catch (SQLException ex) {
            Logger.getLogger(form_admin.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
        }
        else if(Pilih == JOptionPane.NO_OPTION)
            JOptionPane.showMessageDialog(null, "OK");         
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

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        scrollpane = new javax.swing.JScrollPane();
        tablePasien = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btn_delete = new javax.swing.JButton();
        btn_input = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pilihTable = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        Cari = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btn_cari = new javax.swing.JButton();
        btn_cetak = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RECEPTIONIST PANEL");

        jPanel1.setBackground(new java.awt.Color(56, 199, 203));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setText("WELCOME TO RECEPTIONIST PANEL");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel2.setText("nama");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/logo123.jpg"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(136, 136, 136)
                                .addComponent(jLabel2)))
                        .addGap(319, 319, 319))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DAFTAR PASIEN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 1, 18))); // NOI18N

        scrollpane.setBackground(new java.awt.Color(204, 204, 204));
        scrollpane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tablePasien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablePasien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePasienMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tablePasienMouseEntered(evt);
            }
        });
        scrollpane.setViewportView(tablePasien);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jButton2.setText("REFRESH");
        jButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollpane)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(scrollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(56, 199, 203));

        btn_delete.setBackground(new java.awt.Color(255, 255, 255));
        btn_delete.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/del.jpg"))); // NOI18N
        btn_delete.setText("DELETE");
        btn_delete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_delete.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_input.setBackground(new java.awt.Color(255, 255, 255));
        btn_input.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btn_input.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/add.jpg"))); // NOI18N
        btn_input.setText("DAFTAR BARU");
        btn_input.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_input.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btn_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_input, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_input, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(249, 114, 33));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setText("Pilih Table :");

        pilihTable.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        pilihTable.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pasien", "Antrian Pasien" }));
        pilihTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihTableActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel4.setText("Cari data pasien  :");

        Cari.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        Cari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CariMouseClicked(evt);
            }
        });
        Cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel5.setText("(cari berdasarkan Nama)");

        btn_cari.setBackground(new java.awt.Color(255, 255, 255));
        btn_cari.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_cari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/cr.jpg"))); // NOI18N
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });

        btn_cetak.setBackground(new java.awt.Color(255, 255, 255));
        btn_cetak.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_cetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/prnt.jpg"))); // NOI18N
        btn_cetak.setText("CETAK");
        btn_cetak.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_cetak.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btn_cetak.setMaximumSize(new java.awt.Dimension(99, 37));
        btn_cetak.setMinimumSize(new java.awt.Dimension(99, 37));
        btn_cetak.setPreferredSize(new java.awt.Dimension(99, 37));
        btn_cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetakActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/out.jpg"))); // NOI18N
        jButton1.setText("LOGOUT");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(pilihTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(Cari, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_cetak, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(pilihTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(Cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_cetak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        form_login fa = new form_login();
        fa.show();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void pilihTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihTableActionPerformed
        if (pilihTable.getSelectedItem()== "Pasien"){
            selectDataPasien();
        Cari.setVisible(true);
        btn_cari.setVisible(true);
        jLabel4.setVisible(true);
        jLabel5.setVisible(true);
        btn_input.setVisible(true);
        btn_cetak.setVisible(true);
        }
        else{
        Cari.setVisible(false);
        btn_cari.setVisible(false);
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
        btn_input.setVisible(false);
        btn_cetak.setVisible(false);    
            try {
                selectAntrian();
            } catch (SQLException ex) {
                Logger.getLogger(form_resepsionis.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_pilihTableActionPerformed

    private void btn_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inputActionPerformed
        inputDataPasien idp = new inputDataPasien();
        idp.show();
    }//GEN-LAST:event_btn_inputActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        deleteData();       
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void tablePasienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePasienMouseClicked
       if (pilihTable.getSelectedItem()=="Pasien"){
        int row = tablePasien.getSelectedRow();
        String no_rm, nama, jk, gol, alamat, telepon;
        if (row !=-1){ 
            no_rm = tablePasien.getValueAt(row, 0).toString();
            nama = tablePasien.getValueAt(row, 1).toString();
            jk = tablePasien.getValueAt(row, 3).toString();
            gol = tablePasien.getValueAt(row, 4).toString();            
            alamat = tablePasien.getValueAt(row, 6).toString();
            telepon = tablePasien.getValueAt(row, 7).toString();
            form_pasien fp = new form_pasien(no_rm, nama, jk, gol, alamat, telepon);
            fp.show();
        }
        }          
    }//GEN-LAST:event_tablePasienMouseClicked

    private void CariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CariMouseClicked
        
    }//GEN-LAST:event_CariMouseClicked

    private void CariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CariActionPerformed

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        try {
            cariDataPasien();
        } catch (SQLException ex) {
            Logger.getLogger(form_resepsionis.class.getName()).log(Level.SEVERE, null, ex);
        }
        Cari.setText("");
    }//GEN-LAST:event_btn_cariActionPerformed

    private void btn_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetakActionPerformed
        if(pilihTable.getSelectedItem()=="Pasien"){            
            try{
            //File file = new File("src/laporan/laporanPasien.jrxml");
            InputStream file = getClass().getResourceAsStream("/laporan/laporanPasien.jrxml");
            JasperDesign jasperDesign = JRXmlLoader.load(file);
            JasperReport jasperReport= JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null,KoneksiDatabase.getConnection());          
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        else{
            btn_cetak.hide();
        }
    
    }//GEN-LAST:event_btn_cetakActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (pilihTable.getSelectedItem()=="Pasien"){
            selectDataPasien();
        }
        else if (pilihTable.getSelectedItem()=="Antrian Pasien"){
            try {
                selectAntrian();
            } catch (SQLException ex) {
                Logger.getLogger(form_resepsionis.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
      
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tablePasienMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePasienMouseEntered
 
    }//GEN-LAST:event_tablePasienMouseEntered

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
            java.util.logging.Logger.getLogger(form_resepsionis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_resepsionis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_resepsionis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_resepsionis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_resepsionis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Cari;
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_cetak;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_input;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
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
    private javax.swing.JTable tablePasien;
    // End of variables declaration//GEN-END:variables
}
