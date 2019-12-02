/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Deo
 */
public class EntityPegawai {
    private String nama, alamat, nohp, uname, pwd, jabatan;
    private int idPegawai;
    public int getId(){
        return idPegawai;
    }
    public String getNama(){
        return nama;
    }
    public String getAlamat(){
        return alamat;
    }
    public String getNohp(){
        return nohp;
    }
    public String getUname(){
        return uname;
    }
    public String getPwd(){
        return pwd;
    }
    public String getJabatan(){
        return jabatan;
    }
    public void setId(int idPegawai){
        this.idPegawai = idPegawai;
    }
    public void setNama(String nama){
        this.nama = nama;
    }
    public void setAlamat(String alamat){
        this.alamat = alamat;
    }
    public void setNohp(String nohp){
        this.nohp = nohp;
    }
    public void setUname(String uname){
        this.uname = uname;
    }
    public void setPwd(String pwd){
        this.pwd = pwd;
    }
    public void setJabatan(String jabatan){
        this.jabatan = jabatan;
    }
}
