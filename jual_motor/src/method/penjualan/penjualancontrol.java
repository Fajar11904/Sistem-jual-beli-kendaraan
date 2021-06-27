/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package method.penjualan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author HP
 */
public class penjualancontrol {
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;
    String sql=null;

public penjualancontrol(){
    try {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jual_motor","root","");
        st=con.createStatement();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"Koneksi Database gagal, Terjadi kesalahan pada : \n" + e);
    }
}

public List CekMotor(String Nonota, String Kdmotor){
List logDetailBeli = new ArrayList();
sql="select no_nota, kode_motor, nama_motor, harga_jual, jumlah_beli, total_bayar from tbpenjualan where no_nota='"+Nonota+"' and kode_motor='"+Kdmotor+"'";
    try {
        rs=st.executeQuery(sql);
        while (rs.next()) {
        DataPenjualan dp = new DataPenjualan();
        dp.setKdmotor(rs.getString("kode_motor"));
        dp.setNmmotor(rs.getString("nama_motor"));
        dp.setHrgjual(rs.getInt("harga_jual"));
        dp.setJmlbeli(rs.getInt("jumlah_beli"));
        dp.setTbayar(rs.getInt("total_bayar"));
        logDetailBeli.add(dp);
        }
    }catch (Exception e){
        JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Cek Barang : \n" + e);
    }
    return logDetailBeli;
}

public int tambahpenjualan(DataPenjualan a){
    sql="insert into tbpenjualan values('"+a.getNonota()+"','"+a.getKdmotor()+"','"+a.getNmmotor()+"''"+a.getHrgjual()+"','"+a.getJmlbeli()+"','"+a.getTbayar()+"')";
    int hasil = 0;
    try {
        hasil = st.executeUpdate(sql);
    } catch (Exception e){
        JOptionPane.showMessageDialog(null,"Terjadi Kesalahan Pada : \n" + e);
    }
    return hasil;
}

public List cariMotor(String cari){
List logCari = new ArrayList();
sql="select no_nota, kode_motor, nama_motor, harga_jual, jumlah_beli, total_bayar from tbpenjualan where no_nota like'%"+cari+"%' or nama_motor like'%"+cari+"'";
    try {
        rs=st.executeQuery(sql);
        while (rs.next()) {
        DataPenjualan dp = new DataPenjualan();
        dp.setKdmotor(rs.getString("kode_motor"));
        dp.setNmmotor(rs.getString("nama_motor"));
        dp.setHrgjual(rs.getInt("harga_jual"));
        dp.setJmlbeli(rs.getInt("jumlah_beli"));
        dp.setTbayar(rs.getInt("total_bayar"));
        logCari.add(dp);
        }
    }catch (Exception e){
        JOptionPane.showMessageDialog(null, "Terjadi Kesalahan: \n" + e);
    }
    return logCari;
}
}
