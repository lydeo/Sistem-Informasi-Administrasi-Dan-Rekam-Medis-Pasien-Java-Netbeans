/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implements;

import Entity.EntityPegawai;
import Interfac.InterfacePegawai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Deo
 */
public class ImplementPegawai implements InterfacePegawai{
    private Connection conn;
    private PreparedStatement st;
    
    public ImplementPegawai(Connection koneksiDb){
        this.conn = koneksiDb;
    }
    
    
    @Override
    public List getAll() throws SQLException {
        List Pegawai = new ArrayList();
        st = conn.prepareStatement("SELECT * from login");
        try (ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                EntityPegawai pegawai1 = new EntityPegawai();
                pegawai1.setId(rs.getInt(1));
                pegawai1.setNama(rs.getString(2));
                pegawai1.setAlamat(rs.getString(3));
                pegawai1.setNohp(rs.getString(4));
                pegawai1.setUname(rs.getString(5));
                pegawai1.setPwd(rs.getString(6));
                pegawai1.setJabatan(rs.getString(7));
                Pegawai.add(pegawai1);
            }
        }
        conn.commit();
        return Pegawai;
    }

    @Override
    public void insertPegawai(EntityPegawai pegawai) throws SQLException {
        st = conn.prepareStatement("INSERT INTO login (nama, alamat, hp, username, password, jabatan) VALUES (?,?,?,?,?,?)");
        st.setString(1, pegawai.getNama());
        st.setString(2, pegawai.getAlamat());
        st.setString(3, pegawai.getNohp());
        st.setString(4, pegawai.getUname());
        st.setString(5, pegawai.getPwd());
        st.setString(6, pegawai.getJabatan());
        st.executeUpdate();
        conn.commit();  
       
    }

    @Override
    public void updatePegawai(Long id, EntityPegawai pegawai) throws SQLException {
        st = conn.prepareStatement("UPDATE login SET nama=?,alamat=?,hp=?,username=?,password=?,jabatan=? WHERE id=?");
        st.setString(1, pegawai.getNama());
        st.setString(2, pegawai.getAlamat());
        st.setString(3, pegawai.getNohp());
        st.setString(4, pegawai.getUname());
        st.setString(5, pegawai.getPwd());
        st.setString(6, pegawai.getJabatan());
        st.setLong(7, id);
        st.executeUpdate();
        conn.commit();
    }

    @Override
    public void deletePegawai(Long id) throws SQLException {
        st = conn.prepareStatement("DELETE FROM login WHERE id =?");
        st.setLong(1, id);
        st.executeUpdate();
        st.close();
        conn.commit();
    }


}
