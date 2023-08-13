/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Kendaraan;

import Kendaraan.Kendaraan;

/**
 *
 * @author adam
 */
public class Mobil extends Kendaraan {

    int jumlahPenumpang;

    public Mobil(String merk, int tahun, int jumlahPenumpang) {
        super(merk, tahun);
        this.jumlahPenumpang = jumlahPenumpang;
    }

    public int getJumlahPenumpang() {
        return jumlahPenumpang;
    }
    
    public void setJumlahPenumpang(int jumlahPenumpang){
        this.jumlahPenumpang = jumlahPenumpang;
    }
    
    public static void main(String[] args) {
        Mobil mobil = new Mobil("Toyota", 2020, 5);
        
        System.out.println("=================");
        System.out.println("= Rincian Mobil =");
        System.out.println("=================");
        System.out.println(" ");
        System.out.println("Merk : " + mobil.getMerk());
        System.out.println("Tahun : " + mobil.getTahun());
        System.out.println("Jumlah Penumpang :" + mobil.getJumlahPenumpang());
    }

}
