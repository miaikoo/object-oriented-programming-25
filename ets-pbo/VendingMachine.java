import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {
    private Stok stok;
    private List<ProdukMenu> daftarMenu;
    private List<Transaksi> logTransaksi;
    private Scanner scanner;

    public VendingMachine() {
        stok = new Stok();
        daftarMenu = new ArrayList<>();
        logTransaksi = new ArrayList<>();
        scanner = new Scanner(System.in);
        inisialisasiMenu();
    }
    
    private void inisialisasiMenu() {
        // Espresso
        ProdukMenu espresso = new ProdukMenu("Espresso", 10000);
        espresso.tambahUkuran("Small (Single)", 0, Map.of("Kopi", 15, "Air", 50));
        espresso.tambahUkuran("Medium (Doppio)", 3000, Map.of("Kopi", 30, "Air", 80));
        espresso.tambahUkuran("Large (Triple)", 5000, Map.of("Kopi", 45, "Air", 110));
        
        // Latte
        ProdukMenu latte = new ProdukMenu("Latte", 15000);
        latte.tambahUkuran("Small", 0, Map.of("Kopi", 15, "Susu", 150, "Air", 50));
        latte.tambahUkuran("Medium", 3000, Map.of("Kopi", 30, "Susu", 250, "Air", 60));
        latte.tambahUkuran("Large", 5000, Map.of("Kopi", 30, "Susu", 350, "Air", 75));
        
        daftarMenu.add(espresso);
        daftarMenu.add(latte);
    }

    public void jalankan() {
        System.out.println("==============================================");
        System.out.println("=== SELAMAT DATANG DI VENDING COFFEE MACHINE ===");
        System.out.println("==============================================");
        
        while(true) {
            stok.tampilkanStok();
            tampilkanMenu();
            
            System.out.print("Pilihan Anda (1-" + daftarMenu.size() + "), atau 0 untuk keluar: ");
            int pilihan = scanner.nextInt();
            
            if (pilihan == 0) {
                System.out.println("Terima kasih telah menggunakan mesin kami.");
                break;
            }

            if (pilihan > 0 && pilihan <= daftarMenu.size()) {
                prosesPesanan(daftarMenu.get(pilihan - 1));
            } else {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
    
    private void tampilkanMenu() {
        System.out.println("Silakan pilih kopi yang Anda inginkan:");
        for (int i = 0; i < daftarMenu.size(); i++) {
            ProdukMenu produk = daftarMenu.get(i);
            System.out.println((i + 1) + ". " + produk.getNama() + " (Mulai dari Rp " + produk.getHargaDasar() + ")");
        }
    }

    private void prosesPesanan(ProdukMenu produk) {
        System.out.println("Anda memilih: " + produk.getNama());
        
        // Memilih ukuran
        List<ProdukMenu.DataUkuran> daftarUkuran = produk.getDaftarUkuran();
        System.out.println("Silakan pilih ukuran:");
        for (int i = 0; i < daftarUkuran.size(); i++) {
            ProdukMenu.DataUkuran data = daftarUkuran.get(i);
            System.out.println((i + 1) + ". " + data.namaTampilan() + " (+ Rp " + data.hargaTambahan() + ")");
        }
        System.out.print("Pilihan Anda (1-" + daftarUkuran.size() + "): ");
        int pilihanUkuranInput = scanner.nextInt();

        if (pilihanUkuranInput < 1 || pilihanUkuranInput > daftarUkuran.size()) {
            System.out.println("Pilihan ukuran tidak valid. Membatalkan pesanan.");
            return;
        }
        ProdukMenu.DataUkuran ukuranPilihan = daftarUkuran.get(pilihanUkuranInput - 1);
        Map<String, Integer> resepFinal = ukuranPilihan.resep();
        
        // Cek stok
        if (!stok.cekKetersediaan(resepFinal)) {
            System.out.println("Mohon maaf, stok bahan untuk " + produk.getNama() + " ukuran " + ukuranPilihan.namaTampilan() + " tidak mencukupi.");
            return;
        }
        
        // Tambahan gula dan susu
        System.out.print("- Tambah Gula? (harga +Rp 500) (y/n): ");
        boolean tambahGula = scanner.next().equalsIgnoreCase("y");
        
        System.out.print("- Tambah Susu? (harga +Rp 1500) (y/n): ");
        boolean tambahSusu = scanner.next().equalsIgnoreCase("y");
        
        int totalHarga = hitungTotalHarga(produk, tambahGula, tambahSusu, ukuranPilihan);
        
        tampilkanRincian(produk, ukuranPilihan, tambahGula, tambahSusu, totalHarga);

        System.out.print("Silakan masukkan uang Anda: ");
        int uangMasuk = scanner.nextInt();

        if (uangMasuk >= totalHarga) {
            int kembalian = uangMasuk - totalHarga;
            System.out.println("Pembayaran diterima. Kembalian Anda: Rp " + kembalian);
            
            buatMinuman(resepFinal, tambahGula, tambahSusu, ukuranPilihan);
            logTransaksi.add(new Transaksi(produk.getNama() + " (" + ukuranPilihan.namaTampilan() + ")", totalHarga));
            
            System.out.println(produk.getNama() + " (" + ukuranPilihan.namaTampilan() + ") Anda telah siap!");
            System.out.println("Terima kasih!\n");
        } else {
            System.out.println("Pembayaran gagal. Uang yang Anda masukkan tidak cukup.");
        }
    }

    private int hitungTotalHarga(ProdukMenu produk, boolean gula, boolean susu, ProdukMenu.DataUkuran ukuran) {
        int total = produk.getHargaDasar() + ukuran.hargaTambahan();
        if (gula) total += 500;
        if (susu) total += 1500;
        return total;
    }

    private void buatMinuman(Map<String, Integer> resep, boolean gula, boolean susu, ProdukMenu.DataUkuran ukuran) {
        System.out.println("\nMesin sedang membuat pesanan Anda...");
        System.out.println("[--- Mengurangi stok (Ukuran " + ukuran.namaTampilan() + ") ---]");
        
        for (Map.Entry<String, Integer> entry : resep.entrySet()) {
            stok.kurangiBahan(entry.getKey(), entry.getValue());
            System.out.println("- " + entry.getKey() + ": " + entry.getValue());
        }
        
        if (gula) {
            stok.kurangiBahan("Gula", 10);
            System.out.println("- Gula: 10 gr");
        }
        if (susu) {
            stok.kurangiBahan("Susu", 50);
            System.out.println("- Susu: 50 ml");
        }
    }
    
    private void tampilkanRincian(ProdukMenu produk, ProdukMenu.DataUkuran ukuran, boolean gula, boolean susu, int totalHarga){
        System.out.println("\n--- Rincian Pesanan ---");
        System.out.println("Minuman: " + produk.getNama());
        System.out.println("Ukuran: " + ukuran.namaTampilan());
        System.out.println("-------------------------");
        System.out.println("Harga Dasar: Rp " + produk.getHargaDasar());
        System.out.println("Harga Ukuran: + Rp " + ukuran.hargaTambahan());
        if (gula) System.out.println("Tambahan Gula: + Rp 500");
        if (susu) System.out.println("Tambahan Susu: + Rp 1500");
        System.out.println("-------------------------");
        System.out.println("Total Harga: Rp " + totalHarga);
        System.out.println("-------------------------");
    }
}