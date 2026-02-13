import java.util.Scanner;

public class RentalApp
{
    private Rental rental;
    private Scanner scanner;

    public RentalApp() {
        rental = new Rental();
        scanner = new Scanner(System.in);
    }

    public void run() {
        int pilihan = 0;

        do {
            System.out.println("\n=== Aplikasi Rental Kendaraan ===");
            System.out.println("1. Tambah Kendaraan");
            System.out.println("2. Lihat Daftar Kendaraan");
            System.out.println("3. Tambah Penyewa");
            System.out.println("4. Lihat Daftar Penyewa");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch(pilihan) {
                case 1:
                    tambahKendaraan();
                    break;
                case 2:
                    rental.tampilkanKendaraan();
                    break;
                case 3:
                    tambahPenyewa();
                    break;
                case 4:
                    rental.tampilkanPenyewa();
                    break;
                case 5:
                    System.out.println("Terima kasih, program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while(pilihan != 5);
    }

    private void tambahKendaraan() {
        System.out.println("\nPilih jenis kendaraan:");
        System.out.println("1. Mobil");
        System.out.println("2. Motor");
        System.out.println("3. Sepeda");
        System.out.print("Pilihan: ");
        int j = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Merk: ");
        String merk = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Tahun Produksi: ");
        int tahun = scanner.nextInt();
        scanner.nextLine();

        Vehicle v = null;

        if(j == 1) {
            System.out.print("Jumlah roda: ");
            int roda = scanner.nextInt();
            scanner.nextLine();
            v = new Mobil(merk, model, tahun, roda);
        }
        else if(j == 2) {
            System.out.print("Jumlah roda: ");
            int roda = scanner.nextInt();
            scanner.nextLine();
            v = new Motor(merk, model, tahun, roda);
        }
        else if(j == 3) {
            System.out.print("Jenis sepeda (misal: BMX, balap): ");
            String jenis = scanner.nextLine();
            v = new Sepeda(merk, model, tahun, jenis);
        }
        else {
            System.out.println("Jenis tidak valid!");
            return;
        }

        rental.tambahKendaraan(v);
        System.out.println("Kendaraan berhasil ditambahkan.");
    }

    private void tambahPenyewa() {
        if (rental.getDaftarKendaraan().isEmpty()) {
            System.out.println("Tidak ada kendaraan tersedia.");
            return;
        }

        System.out.print("Nama penyewa: ");
        String nama = scanner.nextLine();

        System.out.println("\nPilih kendaraan yang disewa:");
        for (int i = 0; i < rental.getDaftarKendaraan().size(); i++) {
            System.out.println((i+1) + ". " + rental.getDaftarKendaraan().get(i).getInfo());
        }

        System.out.print("Pilihan: ");
        int idx = scanner.nextInt();
        scanner.nextLine();

        if (idx < 1 || idx > rental.getDaftarKendaraan().size()) {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        Vehicle v = rental.getDaftarKendaraan().get(idx - 1);
        rental.tambahPenyewa(new Penyewa(nama, v));
        System.out.println("Penyewa berhasil ditambahkan.");
    }

    public static void main(String[] args) {
        new RentalApp().run();
    }
}
