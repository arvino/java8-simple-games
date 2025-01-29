import java.util.Random;
import java.util.Scanner;

public class TebakAngka {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int angkaBenar = random.nextInt(5) + 1; // Angka acak antara 1 - 5
        int tebakan;
        int percobaan = 0;

        System.out.println("Selamat datang di Game Tebak Angka!");
        System.out.println("Saya telah memilih angka antara 1 hingga 5.");
        System.out.println("Coba tebak angkanya!");

        do {
            System.out.print("Masukkan tebakan Anda: ");
            tebakan = scanner.nextInt();
            percobaan++;

            if (tebakan > angkaBenar) {
                System.out.println("Terlalu besar! Coba lagi.");
            } else if (tebakan < angkaBenar) {
                System.out.println("Terlalu kecil! Coba lagi.");
            } else {
                System.out.println("Selamat! Anda berhasil menebak angka " + angkaBenar + " dalam " + percobaan + " percobaan.");
            }
        } while (tebakan != angkaBenar);

        scanner.close();
    }
}
