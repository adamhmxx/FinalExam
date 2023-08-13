/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExceptionCatch;

import java.util.Scanner;

/**
 *
 * @author adam
 */
public class ExceptionZeroDivide {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println("=========================================");
            System.out.println("= Selamat Datang Pada Operasi Pembagian =");
            System.out.println("=========================================");
            System.out.println(" ");
            System.out.print("Angka Pertama : ");
            double angkaPertama = scanner.nextDouble();
            System.out.print("Angka Kedua :");
            double angkaKedua = scanner.nextDouble();

            double result = angkaPertama / angkaKedua;
            System.out.println("Hasil Operasi Pembagian : " + result);
        } catch (ArithmeticException e) {
            System.out.println("Terjadi Masalah Saat Pembagian" + e.getMessage());
        } catch (java.util.InputMismatchException e) {
            System.out.println("Input Anda Tidak Valid! Silahkan Masukkan Angka");
        } finally {
            scanner.close();
        }
    }

}
