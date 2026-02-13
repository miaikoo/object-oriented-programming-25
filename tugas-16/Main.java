import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Perpustakaan perpus = new Perpustakaan();
        Scanner scanner = new Scanner(System.in);
        boolean berjalan = true;

        while (berjalan) {
            System.out.println("\n=== MENU PERPUSTAKAAN ===");
            System.out.println("1. Tampilkan Semua Buku");
            System.out.println("2. Tambah Buku Baru");
            System.out.println("3. Edit Buku");
            System.out.println("4. Hapus Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    perpus.tampilkanBuku();
                    break;
                
                case 2:
                    System.out.print("Masukkan ID Unik: ");
                    String id = scanner.nextLine();
                    System.out.print("Masukkan Judul: ");
                    String judul = scanner.nextLine();
                    System.out.print("Masukkan Penulis: ");
                    String penulis = scanner.nextLine();
                    System.out.print("Masukkan Tahun: ");
                    int tahun = scanner.nextInt();
                    perpus.tambahBuku(id, judul, penulis, tahun);
                    break;

                case 3:
                    System.out.print("Masukkan ID Buku yang akan diedit: ");
                    String idEdit = scanner.nextLine();
                    System.out.print("Judul Baru: ");
                    String jBaru = scanner.nextLine();
                    System.out.print("Penulis Baru: ");
                    String pBaru = scanner.nextLine();
                    System.out.print("Tahun Baru: ");
                    int tBaru = scanner.nextInt();
                    perpus.updateBuku(idEdit, jBaru, pBaru, tBaru);
                    break;

                case 4:
                    System.out.print("Masukkan ID Buku yang akan dihapus: ");
                    String idHapus = scanner.nextLine();
                    perpus.hapusBuku(idHapus);
                    break;

                case 5:
                    berjalan = false;
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}