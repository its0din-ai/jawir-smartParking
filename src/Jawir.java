import App.*;
import java.util.Scanner;

public class Jawir {
    public static void main(String[] args) {
        Menu men = new Menu();
        men.mainMenu();
        try (Scanner input = new Scanner(System.in)) {
            int pilihan = input.nextInt();
            switch (pilihan) {
                case 1:
                    men.menuParkir();
                    int pilihanParkir = input.nextInt();
                    switch (pilihanParkir) {
                        case 1:
                            men.menuMobil();
                            break;
                        case 2:
                            men.menuMotor();
                            break;
                        default:
                            System.out.println("Pilihan tidak ada");
                    }
                    break;
                case 2:
                    men.menuCheckout();
                    int pilihanCheckout = input.nextInt();
                    switch (pilihanCheckout) {
                        case 1:
                            men.menuCheckoutMobil();
                            break;
                        case 2:
                            men.menuCheckoutMotor();
                            break;
                        default:
                            System.out.println("Pilihan tidak ada");
                    }
                    break;
                case 3:
                    men.clearScreen();
                    System.out.println("Terima kasih telah menggunakan layanan kami");
                    System.exit(0);
            }
        }
    }

}
