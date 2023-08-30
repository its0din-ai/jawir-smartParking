package App;

public class Checkout {
    public void checkoutBanner() {
        System.out.println("=====================================");
        System.out.println("        _  ___  _ _ _  _  ___ \r\n" + //
                "       | || . || | | || || . \\\r\n" + //
                "      _| ||   || | | || ||   /\r\n" + //
                "      \\__/|_|_||__/_/ |_||_\\_\\\r\n");
        System.out.println("         Digital Ticketing");
    }

    public void calculateMobil(String masuk, String keluar, String platNomor) {
        Mobil mbl = new Mobil();
        int perjam = mbl.getPerjam();

        String[] masukSplit = masuk.split(" ");
        String[] keluarSplit = keluar.split(" ");

        int jamMasuk = Integer.parseInt(masukSplit[1].split(":")[0]);
        int jamKeluar = Integer.parseInt(keluarSplit[1].split(":")[0]);
        
        int harga = 0;
        if(jamMasuk == jamKeluar){
            harga += perjam;
        }else{
            harga += (jamKeluar - jamMasuk) * perjam;
        }

        checkoutBanner();
        System.out.println("-------------------------------------");
        System.out.println("[!] TNKB         : " + platNomor);
        System.out.println("[!] Waktu Masuk  : " + masuk);
        System.out.println("[!] Waktu Keluar : " + keluar);
        System.out.println("-------------------------------------");
        System.out.println("[*] Total Harga  : Rp " + harga + ",-");
        System.out.println("=====================================");
    }

    public void calculateMotor(String masuk, String keluar, String platNomor) {
        Motor mtr = new Motor();
        int perjam = mtr.getPerjam();

        String[] masukSplit = masuk.split(" ");
        String[] keluarSplit = keluar.split(" ");

        int jamMasuk = Integer.parseInt(masukSplit[1].split(":")[0]);
        int jamKeluar = Integer.parseInt(keluarSplit[1].split(":")[0]);
        
        int harga = 0;
        if(jamMasuk == jamKeluar){
            harga += perjam;
        }else{
            harga += (jamKeluar - jamMasuk) * perjam;
        }

        checkoutBanner();
        System.out.println("-------------------------------------");
        System.out.println("[!] TNKB         : " + platNomor);
        System.out.println("[!] Waktu Masuk  : " + masuk);
        System.out.println("[!] Waktu Keluar : " + keluar);
        System.out.println("-------------------------------------");
        System.out.println("[*] Total Harga  : Rp " + harga + ",-");
        System.out.println("=====================================");
    }
}
