/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfac;
import Entity.EntityPegawai;
import java.sql.*;
import java.util.List;
/**
 *
 * @author Deo
 */
public interface InterfacePegawai{
    void insertPegawai (EntityPegawai pegawai) throws SQLException;
    void updatePegawai(Long id, EntityPegawai pegawai) throws SQLException;
    void deletePegawai (Long id) throws SQLException;
    public List getAll() throws SQLException;
}
