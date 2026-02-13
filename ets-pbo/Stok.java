import java.util.Map;
import java.util.HashMap;

public class Stok {
    private Map<String, Bahan> daftarBahan;

    public Stok() {
        daftarBahan = new HashMap<>();
        tambahBahan(new Bahan("Kopi", 200, "gr"));
        tambahBahan(new Bahan("Susu", 800, "ml"));
        tambahBahan(new Bahan("Gula", 200, "gr"));
        tambahBahan(new Bahan("Air", 1000, "ml"));
    }

    public void tambahBahan(Bahan bahan) {
        daftarBahan.put(bahan.getNama().toLowerCase(), bahan);
    }

    public void kurangiBahan(String nama, int jumlah) {
        Bahan bahan = daftarBahan.get(nama.toLowerCase());
        if (bahan != null) {
            bahan.kurangiJumlah(jumlah);
        }
    }

    public boolean cekKetersediaan(Map<String, Integer> resep) {
        for (Map.Entry<String, Integer> entry : resep.entrySet()) {
            String namaBahan = entry.getKey().toLowerCase();
            int butuh = entry.getValue();
            
            Bahan bahanDiStok = daftarBahan.get(namaBahan);
            if (bahanDiStok == null || bahanDiStok.getJumlah() < butuh) {
                System.out.println("Peringatan: Stok " + namaBahan + " tidak cukup.");
                return false;
            }
        }
        return true;
    }
    
    public void tampilkanStok() {
        System.out.println("\n--- Stok Bahan Saat Ini ---");
        for (Bahan bahan : daftarBahan.values()) {
            System.out.println("- " + bahan.getNama() + ": " + bahan.getJumlah() + " " + bahan.getSatuan());
            if (bahan.getJumlah() < 50) { 
                 System.out.println("  [PERINGATAN] Stok " + bahan.getNama() + " hampir habis! Harap isi ulang.");
            }
        }
        System.out.println("---------------------------\n");
    }
}