import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {
    private Stok stok;
    private List<Minuman> menuMinuman;
    private List<Transaksi> logTransaksi;
    private Scanner scanner;

    public VendingMachine() {
        stok = new Stok();
        menuMinuman = new ArrayList<>();
        logTransaksi = new ArrayList<>();
        scanner = new Scanner(System.in);
        
        menuMinuman.add(new Espresso());
        menuMinuman.add(new Latte());
    }

    public void jalankan() {
        System.out.println("==============================================");
        System.out.println("=== SELAMAT DATANG DI VENDING COFFEE MACHINE ===");
        System.out.println("==============================================");
        
        while(true) {
            stok.tampilkanStok();
            tampilkanMenu();
            
            System.out.print("Pilihan Anda (1-" + menuMinuman.size() + "), atau 0 untuk keluar: ");
            int pilihan = scanner.nextInt();
            
            if (pilihan == 0) {
                System.out.println("Terima kasih telah menggunakan mesin kami.");
                break;
            }

            if (pilihan > 0 && pilihan <= menuMinuman.size()) {
                prosesPesanan(menuMinuman.get(pilihan - 1));
            } else {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
    
    private void tampilkanMenu() {
        System.out.println("Silakan pilih kopi yang Anda inginkan:");
        for (int i = 0; i < menuMinuman.size(); i++) {
            Minuman m = menuMinuman.get(i);
            System.out.println((i + 1) + ". " + m.getNama() + " (Mulai dari Rp " + m.getHargaDasar() + ")");
        }
    }

    private void prosesPesanan(Minuman minuman) {
        System.out.println("Anda memilih: " + minuman.getNama());
        
        // Pilih ukuran
        System.out.println("Silakan pilih ukuran:");
        Ukuran[] semuaUkuran = Ukuran.values();
        for (int i = 0; i < semuaUkuran.length; i++) {
            System.out.println((i + 1) + ". " + semuaUkuran[i].getNamaTampilan() + 
                               " (+ Rp " + semuaUkuran[i].getHargaTambahan() + ")");
        }
        System.out.print("Pilihan Anda (1-" + semuaUkuran.length + "): ");
        int pilihanUkuranInput = scanner.nextInt();

        // Validasi input ukuran
        if (pilihanUkuranInput < 1 || pilihanUkuranInput > semuaUkuran.length) {
            System.out.println("Pilihan ukuran tidak valid. Membatalkan pesanan.");
            return;
        }
        Ukuran ukuranPilihan = semuaUkuran[pilihanUkuranInput - 1];

        // Fetch resep
        Map<String, Integer> resepFinal = minuman.getResep(ukuranPilihan);
        if (resepFinal == null) {
            System.out.println("Mohon maaf, " + minuman.getNama() + " tidak tersedia dalam ukuran " + ukuranPilihan.getNamaTampilan());
            return;
        }

        // Cek stok
        if (!stok.cekKetersediaan(resepFinal)) {
            System.out.println("Mohon maaf, stok bahan untuk membuat " + minuman.getNama() + " ukuran " + ukuranPilihan.getNamaTampilan() + " tidak mencukupi.");
            return;
        }
        
        // Tambahan opsional
        System.out.print("- Tambah Gula? (harga +Rp 500) (y/n): ");
        boolean tambahGula = scanner.next().equalsIgnoreCase("y");
        
        System.out.print("- Tambah Susu? (harga +Rp 1500) (y/n): ");
        boolean tambahSusu = scanner.next().equalsIgnoreCase("y");
        
        int totalHarga = hitungTotalHarga(minuman, tambahGula, tambahSusu, ukuranPilihan);
        
        tampilkanRincian(minuman, ukuranPilihan, tambahGula, tambahSusu, totalHarga);

        System.out.print("Silakan masukkan uang Anda (contoh: 30000): ");
        int uangMasuk = scanner.nextInt();

        if (uangMasuk >= totalHarga) {
            int kembalian = uangMasuk - totalHarga;
            System.out.println("Pembayaran diterima. Kembalian Anda: Rp " + kembalian);
            
            buatMinuman(resepFinal, tambahGula, tambahSusu, ukuranPilihan);
            logTransaksi.add(new Transaksi(minuman.getNama() + " ("+ukuranPilihan.getNamaTampilan()+")", totalHarga));
            
            System.out.println(minuman.getNama() + " (" + ukuranPilihan.getNamaTampilan() + ") Anda telah siap! Silakan ambil di bawah.");
            System.out.println("Terima kasih!\n");
        } else {
            System.out.println("Pembayaran gagal. Uang yang Anda masukkan tidak cukup.");
        }
    }

    private int hitungTotalHarga(Minuman minuman, boolean gula, boolean susu, Ukuran ukuran) {
        int total = minuman.getHargaDasar() + ukuran.getHargaTambahan();
        if (gula) total += 500;
        if (susu) total += 1500;
        return total;
    }

    private void buatMinuman(Map<String, Integer> resep, boolean gula, boolean susu, Ukuran ukuran) {
        System.out.println("\nMesin sedang membuat pesanan Anda...");
        System.out.println("[--- Mengurangi stok (Ukuran " + ukuran.getNamaTampilan() + ") ---]");
        
        for (Map.Entry<String, Integer> entry : resep.entrySet()) {
            stok.kurangiBahan(entry.getKey(), entry.getValue());
            System.out.println("- " + entry.getKey() + ": " + entry.getValue());
        }
        
        if(gula) {
            stok.kurangiBahan("Gula", 10);
            System.out.println("- Gula: 10 gr");
        }
        if(susu) {
            stok.kurangiBahan("Susu", 50);
             System.out.println("- Susu: 50 ml");
        }
    }
    
    private void tampilkanRincian(Minuman minuman, Ukuran ukuran, boolean gula, boolean susu, int totalHarga){
        System.out.println("\n--- Rincian Pesanan ---");
        System.out.println("Minuman: " + minuman.getNama());
        System.out.println("Ukuran: " + ukuran.getNamaTampilan());
        System.out.println("-------------------------");
        System.out.println("Harga Dasar: Rp " + minuman.getHargaDasar());
        System.out.println("Harga Ukuran: + Rp " + ukuran.getHargaTambahan());
        if(gula) System.out.println("Tambahan Gula: + Rp 500");
        if(susu) System.out.println("Tambahan Susu: + Rp 1500");
        System.out.println("-------------------------");
        System.out.println("Total Harga: Rp " + totalHarga);
        System.out.println("-------------------------");
    }
}