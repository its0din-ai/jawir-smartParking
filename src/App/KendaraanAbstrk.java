package App;

public abstract class KendaraanAbstrk {
    String jenis;
    String plat;
    String waktuDatang;
    String waktuKeluar;
    boolean masihParkir;

    abstract void setJenis(String jenis);
    abstract void setPlat(String plat);
    abstract void setWaktuDatang(String waktuDatang);
    abstract void setWaktuKeluar(String waktuKeluar);
    abstract void setMasihParkir(boolean masihParkir);

    abstract String getJenis();
    abstract String getPlat();
    abstract String getWaktuDatang();
    abstract String getWaktuKeluar();
    abstract boolean getMasihParkir();

    abstract void cetakInformasi();
}
