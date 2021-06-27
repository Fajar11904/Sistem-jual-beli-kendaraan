/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package method.penjualan;

/**
 *
 * @author HP
 */
public class DataPenjualan {
public String nomor_nota, kode_motor, nama_motor;

public String getNonota(){
    return nomor_nota;
}
public void setNonota(String nomor_nota){
        this.nomor_nota = nomor_nota;
}
public String getKdmotor(){
    return kode_motor;
}
public void setKdmotor(String kode_motor){
    this.kode_motor = kode_motor;
}
public String getNmmotor(){
    return nama_motor;
}
public void setNmmotor(String nama_motor){
    this.nama_motor = nama_motor;
}
  
int harga_jual, jumlah_beli, total_bayar;

public int getHrgjual(){
    return harga_jual;
}
public void setHrgjual(int harga_jual){
    this.harga_jual = harga_jual;
}

public int getJmlbeli(){
    return jumlah_beli;
}
public void setJmlbeli(int jumlah_beli){
    this.jumlah_beli = jumlah_beli;
}
public int getTbayar(){
    return total_bayar;
}
public void setTbayar(int total_bayar){
    this.total_bayar = total_bayar;
}

}
