/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UAS;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Lenovo
 */
public class Data {
    // atribute karyawan
    public String IdK,NamaK,AlamatK,TglK,GolK;
    
    //attribute untuk hitung usia karyawan
    private int Day,Mounth,Years;
    
     //attribute untuk cek status nikah,anak,umur
    boolean StatusTunjanganA = false,StatusTunjanganK = false,StatusTunjanganP = false;
    
    // attribute dipakai statusnya
    public int StatusK,BanyakAnak,Usia,TunjanganK,TunjanganP,TunjanganA,GajiT,Potongan,
            GajiA ,GajiP;
    
    
    // konstruktor
    public Data(String id, String nama, String alamat, String tgl, String golong, int status, int anak){
        this.IdK = id;
        this.NamaK = nama;
        this.AlamatK = alamat;
        this.TglK = tgl;
        this.GolK = golong;
        this.StatusK = status;
        this.BanyakAnak = anak;
        
        
        // hitung usia karyawan
        String Tgllahir =  this.TglK;
        String[] lahir = Tgllahir.split("-");
        Years = Integer.parseInt(lahir[0] );
        Mounth = Integer.parseInt(lahir[1] );
        Day = Integer.parseInt(lahir[2] );
        
        LocalDate from = LocalDate.of(Years, Mounth, Day);
        
        //mengambil tanggal saat ini
        LocalDate today = LocalDate.now();
        
        //hitung usia
        int Umur = Period.between(from, today).getYears();
        this.Usia = Umur;
        
        
        
        
        // Gaji pokok karyawan tergantung golongan
        switch (GolK) {
            case "a":
            case "A":
                GajiP = 5000000;
                break;
            case "b":
            case "B":
                GajiP = 6000000;
                break;
            case "c":
            case "C":
                GajiP = 7000000;
                break;
        }
        
        
        // tunjangan tambahan jika karyawan sudah menikah
        switch(StatusK ){
            case 1 : 
                this.TunjanganK = GajiP*10/100;
                this.StatusTunjanganK = true;
                break;
        }
        
        // tunjangan tambahan jika karyawan memiliki anak
        switch(StatusK){
            case 1 :
                if(BanyakAnak>0){
                    TunjanganA = BanyakAnak*GajiP*5/100;
                    StatusTunjanganA = true;
                }
                break;
        }
        
        
        
        // tunjangan tambahan jika umur karyawan lebih dari 30 tahun
        if(Usia>30){
            TunjanganP = GajiP*15/100;
            StatusTunjanganP = true;
            
        }

        
        
        
        // menentukan gaji kotor 
        GajiT = GajiP + TunjanganK + TunjanganP + TunjanganA;
        
        // pemotongan gaji
        Potongan = GajiT*25/1000;
        
        // gaji akhir setelah perhitungan
        GajiA = GajiT - Potongan;
        
    }

    Data(String Kode_Karyawan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    // output cari data
    public void print(){
        System.out.println("=========================================================");
        System.out.println("                  DATA PROFIL KARYAWAN                   ");
        System.out.println("---------------------------------------------------------");

        System.out.println("Kode Karyawan           : " + IdK);
        System.out.println("Nama Karyawan           : " + NamaK);
        System.out.println("Golongan                : " + GolK);
        System.out.println("Usia                    : " + Usia);

        // status menikah dan jumlah anak 
        switch( StatusK ){
            case 0 :
                System.out.println("Status Menikah          : Belum Menikah");
                System.out.println("---------------------------------------------------------");
                break;
            
            case 1 :
                System.out.println("Status Menikah          : Sudah Menikah");
                System.out.println("Jumlah Anak             : " + BanyakAnak);
                System.out.println("---------------------------------------------------------");
        }
        System.out.println("Gaji Pokok              : Rp" + GajiP);
        
        //pengecekan tunjangan
        if(StatusTunjanganA){
        String TunjanA = null;
            System.out.println("Tunjangan Anak          : Rp" + TunjanA); 
        }if(StatusTunjanganK){
            String TunjanK = null;
            System.out.println("Tunjangan Suami/Istri   : Rp" + TunjanK );
        }if(StatusTunjanganP){
            String TunjanP = null;
            System.out.println("Tunjangan Pegawai       : Rp" + TunjanP); 
        }
        System.out.println("--------------------------------------------------------- +");
        System.out.println("Gaji Kotor              : Rp" + GajiT);
        System.out.println("Potongan                : Rp" + Potongan);
        System.out.println("--------------------------------------------------------- -");
        System.out.println("Gaji Bersih             : Rp" + GajiA);
    }
}
