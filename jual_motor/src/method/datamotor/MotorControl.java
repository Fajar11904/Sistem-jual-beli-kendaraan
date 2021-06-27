/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package method.datamotor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class MotorControl {
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;
    String sql=null;
    
public MotorControl() {
       try {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jual_motor","root","");
        st=con.createStatement();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"Koneksi Database gagal, Terjadi kesalahan pada : \n" + e);
    }
    
}

public List tampil() {
 List LogMotor = new ArrayList();
 sql="select kode_motor, nama_motor,satuan, jumlah_stok, harga_kontrak, harga_beli from tbdatamotor order by idmotor asc";
    try {
    rs = st.executeQuery(sql);
        while (rs.next()) {
        DataMotor Dm = new DataMotor();
        Dm.setKdmotor(rs.getString("kode_motor"));
        Dm.setNmmotor(rs.getString("nama_motor"));
        Dm.setSatuan(rs.getString("satuan"));
        Dm.setJmlstok(rs.getInt("jumlah_stok"));
        Dm.setHrgkontrak(rs.getInt("harga_kontrak"));
        Dm.setHrgbeli(rs.getInt("harga_beli"));
        LogMotor.add(Dm);
        
        
        }
    } catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Koneksi database gagal, Terjadi Kesalahan pada : \n" + e);
    }
    return LogMotor;
}

public int tambahmotor (DataMotor e){
    sql = "insert into tbdatamotor (kode_motor, nama_motor, satuan, jumlah_stok, harga_kontrak, harga_beli) values('"+e.getKdmotor()+"','"+e.getNmmotor()
    +"','"+e.getSatuan()+"','"+e.getJmlstok()+"','"+e.getHrgkontrak()+"','"+e.getHrgbeli()+"')";
    int hasil=0;
    try {
        hasil=st.executeUpdate(sql);
    } catch (Exception a) {
    JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Pada: \n"+ a);
    }
    return hasil;
}
public int editMotor(DataMotor e){
    sql="update tbdatamotor set nama_motor='"+e.getNmmotor()+"',satuan='"+e.getSatuan()
    +"',jumlah_stok='"+e.getJmlstok()+"',harga_kontrak='"+e.getHrgkontrak()+"' ,harga_beli='"+e.getHrgbeli()+
    "'where kode_motor='"+e.getKdmotor()+"'";
    int hasil=0;
    try {
        hasil=st.executeUpdate(sql);    
    } catch (Exception a) {
    JOptionPane.showMessageDialog(null,"Terjadi kesalahan pada : \n" + a);
    }
    return hasil;
}

public List cariMotor(String cari){
List logMotor = new ArrayList();
sql="select kode_motor, nama_motor, satuan, jumlah_stok, harga_kontrak, harga_beli from tbdatamotor where satuan "
+ "like '%"+cari+"%' or  nama_motor like '%"+cari+"%'";
    try {
        rs=st.executeQuery(sql);
        while (rs.next()) {
        DataMotor Dm=new DataMotor();
        Dm.setKdmotor(rs.getString("kode_motor"));
        Dm.setNmmotor(rs.getString("nama_motor"));
        Dm.setSatuan(rs.getString("satuan"));
        Dm.setJmlstok(rs.getInt("jumlah_stok"));
        Dm.setHrgkontrak(rs.getInt("harga_kontrak"));
        Dm.setHrgbeli(rs.getInt("harga_beli"));
        logMotor.add(Dm);
        }
    } catch (Exception a){
        JOptionPane.showMessageDialog(null,"Terjadi Kesalahan pada : \n" + a);
    }
    return logMotor;
}

public int deleteMotor(DataMotor e){
    sql="delete from database where kode_motor='"+e.getKdmotor()+"'";
    int hasil=0;
    try {
        hasil=st.executeUpdate(sql);
    } catch (Exception a) {
    JOptionPane.showMessageDialog(null, "Terjadi Kesalahan pada: \n" + a);
    }
    return hasil;
}

public int getJumlahmotor(){
    sql = "select count(*) as jumlah_motor " +  "from tbdatamotor";
    int jumlah;
    try {
    rs=st.executeQuery(sql);
    while(rs.next()){
    jumlah = rs.getInt("jumlah_motor");
    return jumlah;
    }
    } catch (Exception a) {
        JOptionPane.showMessageDialog(null, "Terjadi Kesalahan pada: \n" + a);
    }
    return 0;
}

public List tampilSatuan(){
    List logMotor = new ArrayList ();
    sql="select distinct(satuan) from tbdatamotor order by idmotor asc";
    try {
        rs=st.executeQuery(sql);
        while(rs.next()){
        DataMotor eb=new DataMotor();   
        eb.setSatuan(rs.getString("satuan"));
        logMotor.add(eb);
        }
    } catch (Exception a) {
     JOptionPane.showMessageDialog(null, "Terjadi Kesalahan pada: \n" + a);
    }
    return logMotor;
}
public  int updateStok(int stok,String Kdmotor){
   sql="Update tbdatamotor set jumlah_stok='"+stok+"' where kode_motor='"+Kdmotor+"'";
   int hasil = 0;
   try {
       hasil=st.executeUpdate(sql);
   } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"Terjadi Kesalahan Pada : \n" + e);
   }
   return hasil;
}
}
