package App;

public class Motor extends KendaraanAbstrk {
    // Variabel/Atribut yang hanya milik class Mobil
    final private int perjam = 5000;
    private String brand;

    // Constructor Default
    public Motor() {
    }

    // Constructor Overloading
    public Motor(String brand, String jenis, String plat, String waktuDatang, String waktuKeluar, boolean masihParkir) {
        this.brand = brand;
        this.jenis = jenis;
        this.plat = plat;
        this.waktuDatang = waktuDatang;
        this.waktuKeluar = waktuKeluar;
        this.masihParkir = masihParkir;
    }

    // Method yang hanya milik class Mobil
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return this.brand;
    }

    public int getPerjam(){
        return this.perjam;
    }

    // Overriding dari parent class KendaraanAbstrk
    @Override
    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    @Override
    public void setPlat(String plat) {
        this.plat = plat;
    }

    @Override
    public void setWaktuDatang(String waktuDatang) {
        this.waktuDatang = waktuDatang;
    }

    @Override
    public void setWaktuKeluar(String waktuKeluar) {
        this.waktuKeluar = waktuKeluar;
    }

    @Override
    public void setMasihParkir(boolean masihParkir) {
        this.masihParkir = masihParkir;
    }

    @Override
    public String getJenis() {
        return this.jenis;
    }

    @Override
    public String getPlat() {
        return this.plat;
    }

    @Override
    public String getWaktuDatang() {
        return this.waktuDatang;
    }

    @Override
    public String getWaktuKeluar() {
        return this.waktuKeluar;
    }

    @Override
    public boolean getMasihParkir() {
        return this.masihParkir;
    }

    @Override
    public void cetakInformasi() {
        System.out.println("Brand: " + this.brand + "\nJenis: " + this.jenis + "\nPlat: " + this.plat + "\nWaktu Datang: " + this.waktuDatang + "\nWaktu Keluar: " + this.waktuKeluar + "\nMasih Parkir: " + this.masihParkir);
    }
}
