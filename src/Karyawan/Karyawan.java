/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Karyawan;

/**
 *
 * @author adam
 */
public class Karyawan {

    private String nama;
    private double gaji;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getGaji() {
        return gaji;
    }

    public void setGaji(double gaji) {
        this.gaji = gaji;
    }
    
    public double bonusGaji() {
        double bonusGaji = gaji * 0.1; // Perhitungan rumus 10% dari gaji sesuai soal
        return bonusGaji;
    }

    public static void main(String[] args) {
        
        Karyawan karyawan = new Karyawan();
        karyawan.setNama("Andi");
        karyawan.setGaji(10000000);
        
        System.out.println("===========================");
        System.out.println("= Slip Gaji Bulan Agustus =");
        System.out.println("===========================");
        System.out.println(" ");
        System.out.println("Nama : " + karyawan.getNama());
        System.out.println("Gaji : Rp. " + karyawan.getGaji());
        System.out.println("Bonus : Rp. " + karyawan.bonusGaji());
    }

}
