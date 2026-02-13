import java.util.Scanner;

public class Menu {
    private TechSupport support;
    private Scanner scanner;

    public Menu() {
        support = new TechSupport();
        scanner = new Scanner(System.in);
    }

    public void show() {
        int choice;

        do {
            System.out.println("\n=== Sistem Bantuan FRS ===");
            System.out.println("1. Kelas penuh");
            System.out.println("2. Prasyarat");
            System.out.println("3. Jadwal bentrok");
            System.out.println("4. SKS melebihi batas");
            System.out.println("5. NRP salah");
            System.out.println("6. IPK rendah");
            System.out.println("7. Kelas tidak tersedia");
            System.out.println("8. Kelas tersedia tidak penuh");
            System.out.println("9. Nama kelas tidak ditemukan");
            System.out.println("10. Sistem error");
            System.out.println("11. Mata kuliah sudah diambil");
            System.out.println("12. Masa FRS berakhir");
            System.out.println("13. Akses ditolak");
            System.out.println("14. Server sibuk");
            System.out.println("15. Belum bayar");
            System.out.println("16. Keluar");

            System.out.print("Pilih: ");
            choice = scanner.nextInt();

            if (choice == 16) {
                System.out.println("Keluar.");
                break;
            }

            System.out.println("\n>> " + support.solve(choice));

        } while (choice != 16);
    }
}
