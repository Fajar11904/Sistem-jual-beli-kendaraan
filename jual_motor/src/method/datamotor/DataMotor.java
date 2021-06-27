package method.datamotor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class DataMotor {
public String kode_motor, nama_motor, satuan;
public int jumlah_stok, harga_kontrak, harga_beli;

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

public String getSatuan(){
 return satuan;
}
public void setSatuan(String satuan){
    this.satuan = satuan;    
}

public int getJmlstok(){
    return jumlah_stok;
}
public void setJmlstok(int jumlah_stok){
    this.jumlah_stok = jumlah_stok;
}

public int getHrgkontrak(){
    return harga_kontrak;
}
public void setHrgkontrak(int harga_kontrak){
    this.harga_kontrak = harga_kontrak;
}

public int getHrgbeli(){
    return harga_beli;
}
public void setHrgbeli(int harga_beli){
this.harga_beli = harga_beli;
}


}




   


