/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UAS;
import java.util.ArrayList;
/**
 *
 * @author Lenovo
 */
public class Override implements Interfacess {
    // attribute
    ArrayList<Data> listdata = new ArrayList<>();
    
    
    // method tambah karyawan
    

    @java.lang.Override
    public void add(Data data){
        listdata.add(data);
    }
    
    // hapus karyawan
    boolean Terhapus = false;

    @java.lang.Override
    public void delete(String id ){
        for(int i = 0; i < listdata.size(); i++){
            if(listdata.get(i).IdK.equals(id)){
                listdata.remove(i);
                Terhapus = true;
                System.out.println("Berhasil");
                System.out.println("Karyawan tersebut sudah terhapus");
            }else{
                System.out.println("Kode karyawan tidak ada dalam data");
                System.out.println("Silahkan masukan kode yang lain");
            }
        }
    }
    
    // cari karyawan 
    boolean ditemukan = false;
    int index = 0;

    
    
    @java.lang.Override
    public void search(String kode){
        for(int i = 0; i < listdata.size(); i++){            
            if(listdata.get(i).IdK.equals(kode)){
                
                // mengambil index untuk menampilkan data
                index = i;
                ditemukan = true;
                
            }
        }
        
        // memanggil method print() jika data ditemukan
        if(ditemukan){
            listdata.get(index).print();
        }
        
    }
    
    
    
    
    // Method override print
    @java.lang.Override
    public void print(){
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("                                DATA KARYAWAN                                ");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("KODE       NAMA             GOL      USIA    STATUS NIKAH         JUMLAH ANAK");
        System.out.println("-----------------------------------------------------------------------------");
        
        
        //looping print data
        for(int i=0; i <listdata.size(); i++){
            String  Kode = listdata.get(i).IdK;
            String Nama = listdata.get(i).NamaK;
            String Gol = listdata.get(i).GolK;
            int Usia = listdata.get(i).Usia;
            String Status = "Belum Menikah";
            int JmlAnak = 0;
            if( listdata.get(i).StatusK == 1){
                Status = "Sudah Menikah";
                JmlAnak = listdata.get(i).BanyakAnak;
            }else if( listdata.get(i).StatusK == 0){
                Status = "Belum Menikah";
                JmlAnak = 0;
            }
            
            //menampilkan output dari data
            System.out.println("Kode   Nama   Gol  Usia  Status   JmlAnak");
        }
        
        System.out.println("-----------------------------------------------------------------------------");
        
        //menampilkan jumlah data karyawan dalam arraylist
        System.out.println("Jumlah Data : " + listdata.size());
    }
    
}
