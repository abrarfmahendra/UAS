/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UAS;
import java.util.Scanner;
/**
 *
 * @author Lenovo
 */
public class Main {

    /**
     * @param args the command line arguments
     */

    
    public static void main(String[] args) {
        Override dataK = new Override();
        
        //attribute pengecekan untuk looping
        boolean cekmenu = true;
        
        while( cekmenu ){    
            System.out.println("---- Menu Program ----");
            System.out.println("1.Tambah data");
            System.out.println("2.Hapus Data");
            System.out.println("3.Cari Data");
            System.out.println("4.Lihat Data");
            System.out.println("5.Exit");
            Scanner input = new Scanner( System.in );
            System.out.print("Menu Pilihan: ");
            int inp = input.nextInt();
            switch(inp){
                case 1 : 
                    boolean adddata = true;
                    while( adddata ){
                        System.out.println("");
                        System.out.println("-------------------------------------------");
                        System.out.println("               Menu Tambah Data            ");
                        System.out.println("-------------------------------------------");
                        String cb = input.nextLine();
                        
                        //input nama karyawan
                        System.out.print("Masukan Kode Karyawan             : ");
                        String Kode_Karyawan = input.nextLine();
                        
                        //input alamat karyawan
                        System.out.print("Masukan Nama Karyawan             : ");
                        String Nama_Karyawan = input.nextLine();
                        
                        //input alamat karyawan
                        System.out.print("Masukan Alamat                    : ");
                        String Alamat = input.nextLine();
                        
                        //input tanggal lagir karyawan
                        System.out.print("Masukan Tanggal Lahir (YYYY-MM-DD): ");
                        String Tanggal_Lahir = input.nextLine();
                        
                        //input golongan karyawan
                        System.out.print("Masukan Golongan (A/B/C): ");
                        String Golongan = input.nextLine();
                        System.out.println("");
                        
                        //input status karyawan sudah menikah atau belum
                        System.out.println("Masukan Status Menikah");
                        System.out.println("0.belum");
                        System.out.println("1.menikah");
                        System.out.print("Status Karyawan: ");
                        int StatusK = input.nextInt();
                        
                        //attribut untuk jumlah anak
                        int BanyakAnak;
                        if( StatusK == 1 ){
                            System.out.print("Jumlah Anak: ");
                                BanyakAnak = input.nextInt();
                        } else {
                            StatusK = 0;
                            BanyakAnak = 0;
                        }
                        

                        //data akan dimasukkan ke class Data
                        //dan nantinya akan di masukkan ke arraylist
                        Data karyawan = new Data(
                        Kode_Karyawan,
                        Nama_Karyawan,
                        Alamat,
                        Tanggal_Lahir,
                        Golongan,
                        StatusK,
                        BanyakAnak
                        );
                        
                        // data ditambahkan ke array list
                        dataK.add(karyawan);
                        
                        //input submenu
                        System.out.println("\n");
                        System.out.println("Submenu : ");
                        System.out.println("menu utama");
                        System.out.println("Tambah Data");
                        System.out.println("");
                        System.out.print("Menu Pilihan : ");
                        
                        //cek inputan submenu
                        int inpSub = input.nextInt();
                        if( inpSub == 1 ){
                            adddata = false;
                        }else if(inpSub != 2) {
                            System.out.println("pilihan Submenu anda tidak ada");
                            System.out.println("Silahkan Pilih yang lain");
                        }  
                    }
                    break;
                
                    
                case 2 : 
                    boolean inpHapus = true;
                    while( inpHapus ) {
                        System.out.println("");
                        System.out.println("-------------------------------------------");
                        System.out.println("                 Hapus Data                ");
                        System.out.println("-------------------------------------------");
                        String cb = input.nextLine();
                        
                        System.out.print("Silahkan masukan kode yang anda ingin hapus : ");
                        String kode_karyawan = input.nextLine();
                        
                        // menghapus data karyawan 
                        dataK.delete(kode_karyawan);
                        

                        //input submenu
                        System.out.println("Submenu : ");
                        System.out.println("Menu utama");
                        System.out.println("Hapus Data");
                        System.out.println("");
                        System.out.print("Menu Pilihan : ");
                        
                        //cek inputan submenu
                        int inpSub = input.nextInt();
                        if( inpSub == 1 ){
                            inpHapus = false;
                        } else if(inpSub != 2) {
                            System.out.println("pilihan sub menu tidak ada");
                            System.out.println("Silahkan Pilih yang lain");
                        }
                        
                    }
                    break;
                
                case 3 :                     
                    boolean menu_cari_data = true;
                    while( menu_cari_data ){
                        System.out.println("");
                        System.out.println("-------------------------------------------");
                        System.out.println("                 Cari Data                 ");
                        System.out.println("-------------------------------------------");
                        String cb = input.nextLine();
                        
                        System.out.print("Silahkan masukan kode karyawan yang ingin anda cari : ");
                        String inputID = input.nextLine();

                        // mencari ID karywan
                        dataK.search(inputID);

                        //input submenu
                        System.out.println("");
                        System.out.println("SubMenu : ");
                        System.out.println("Menu utama");
                        System.out.println("");
                        System.out.print("Menu Pilihan : ");
                        
                        int inpSub = input.nextInt();
                        if( inpSub == 1 ){
                            menu_cari_data = false;
                        } else{
                            System.out.println("pilihan Submenu anda tidak ada");
                            System.out.println("Silahkan Pilih yang lain");
                        }
                    }
                    break;
                
                case 4 : 
                    boolean perint = true;
                    while( perint ){
                        //menampilkan data karyawan
                        dataK.print();
                        
                        
                        //input Submenu
                        System.out.println("");
                        System.out.println("Pilih SubMenu : ");
                        System.out.println("Menu utama");
                        System.out.println("");
                        System.out.print("Menu Pilihan : ");

                        int inpSub = input.nextInt();
                        if( inpSub == 1 ){
                            perint = false;
                        } else {
                            System.out.println("pilihan Submenu anda tidak ada");
                            System.out.println("Silahkan Pilih yang lain");
                        }
                    }
                    break;

                    
                case 5 : 
                    System.exit(0);
                
                default: 
                    System.out.println("Pilihanmu tidak ada dalam daftar");
                    System.out.println("Silahkan Pilih yang lain");
                
            }   
            
        }
    }
    
}
