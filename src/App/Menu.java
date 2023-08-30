package App;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import DB.JsonDatabase;

public class Menu {
    public void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
        }
    }

    private String timer() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String tnggl = date.format(formatter);
        return tnggl;
    }

    private void banner() {
        System.out.println("=========================");
        System.out.println("  _  ___  _ _ _  _  ___ \r\n" + //
                " | || . || | | || || . \\\r\n" + //
                "_| ||   || | | || ||   /\r\n" + //
                "\\__/|_|_||__/_/ |_||_\\_\\\r\n");
        System.out.println("  Smart Parking Systems");
        System.out.println("=========================");
    }

    public void mainMenu() {
        clearScreen();
        banner();
        System.out.println("1. Parkir");
        System.out.println("2. Checkout");
        System.out.println("3. Keluar");
        System.out.println("=========================");
        System.out.print("Masukkan Pilihan Anda : ");
    }

    public void menuParkir() {
        clearScreen();
        System.out.println("=========================");
        System.out.println("Menu Parkir");
        System.out.println("=========================");
        System.out.println("1. Mobil");
        System.out.println("2. Motor");
        System.out.println("=========================");
        System.out.print("Masukkan Pilihan Anda : ");
    }

    public void menuMobil() {
        Mobil mobil = new Mobil();
        List<Mobil> mobilList = new ArrayList<>();
        clearScreen();
        System.out.println("Isikan detail kendaraan:");
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Brand: ");
            String brand = input.nextLine();
            System.out.print("TNKB: ");
            String plat = input.nextLine();
            String waktuDatang = timer();
            String waktuKeluar = "";
            boolean masihParkir = true;
            String jenis = "Mobil";

            mobil.setBrand(brand);
            mobil.setPlat(plat);
            mobil.setWaktuDatang(waktuDatang);
            mobil.setWaktuKeluar(waktuKeluar);
            mobil.setMasihParkir(masihParkir);
            mobil.setJenis(jenis);
        }
        mobilList.add(mobil);
        JsonDatabase.writeDataMobil(mobilList);
    }

    public void menuMotor() {
        
        List<Motor> motorList = new ArrayList<>();
        clearScreen();
        System.out.println("Isikan detail kendaraan:");
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Brand: ");
            String brand = input.nextLine();
            System.out.print("TNKB: ");
            String plat = input.nextLine();
            String waktuDatang = timer();
            String waktuKeluar = "";
            boolean masihParkir = true;
            String jenis = "Motor";

            Motor motor = new Motor(brand, jenis, plat, waktuDatang, waktuKeluar, masihParkir);
            motorList.add(motor);
        }
        JsonDatabase.writeDataMotor(motorList);
    }

    public void menuCheckout() {
        clearScreen();
        System.out.println("=========================");
        System.out.println("Menu Checkout");
        System.out.println("=========================");
        System.out.println("1. Mobil");
        System.out.println("2. Motor");
        System.out.println("=========================");
        System.out.print("Masukkan Pilihan Anda : ");
    }

    public void menuCheckoutMobil() {
        clearScreen();
        String waktuKeluar = timer();
        String waktuMasuk = "";
        String platNomor = "";
        System.out.println("Isikan Tanda Nomor Kendaraan Bermotor:");
        List<Mobil> loadedMobilList = JsonDatabase.readDataMobil();
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("TNKB: ");
            String plat = input.nextLine();

            boolean dataKetemu = false;
            for (Mobil mobil : loadedMobilList) {
                if (mobil.getPlat().equals(plat)) {
                    dataKetemu = true;
                    if (mobil.getMasihParkir() == true) {
                        mobil.setWaktuKeluar(waktuKeluar);
                        mobil.setMasihParkir(false);
                        waktuMasuk = mobil.getWaktuDatang();
                        platNomor = mobil.getPlat();
                    } else {
                        System.out.println("Kendaraan sudah tidak parkir");
                        System.exit(0);
                    }
                    break;
                }
            }

            if (dataKetemu == false) {
                System.out.println("Data tidak ditemukan");
                System.exit(0);
            } else {
                JsonDatabase.updateDataMobil(loadedMobilList);
                Checkout harga = new Checkout();
                harga.calculateMobil(waktuMasuk, waktuKeluar, platNomor);
            }

        }
    }

    public void menuCheckoutMotor() {
        clearScreen();
        String waktuKeluar = timer();
        String waktuMasuk = "";
        String platNomor = "";
        System.out.println("Isikan Tanda Nomor Kendaraan Bermotor:");
        List<Motor> loadedMotorList = JsonDatabase.readDataMotor();
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("TNKB: ");
            String plat = input.nextLine();

            boolean dataKetemu = false;
            for (Motor motor : loadedMotorList) {
                if (motor.getPlat().equals(plat)) {
                    dataKetemu = true;
                    if (motor.getMasihParkir() == true) {
                        motor.setWaktuKeluar(waktuKeluar);
                        motor.setMasihParkir(false);
                        waktuMasuk = motor.getWaktuDatang();
                        platNomor = motor.getPlat();
                    } else {
                        System.out.println("Kendaraan sudah tidak parkir");
                        System.exit(0);
                    }
                    break;
                }
            }

            if (dataKetemu == false) {
                System.out.println("Data tidak ditemukan");
                System.exit(0);
            } else {
                JsonDatabase.updateDataMotor(loadedMotorList);
                Checkout harga = new Checkout();
                harga.calculateMotor(waktuMasuk, waktuKeluar, platNomor);
            }

        }
    }

}
