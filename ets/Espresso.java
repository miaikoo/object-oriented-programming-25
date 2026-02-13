import java.util.Map;
import java.util.HashMap;

public class Espresso extends Minuman {
    public Espresso() {
        this.nama = "Espresso";
        this.hargaDasar = 10000; // Harga untuk ukuran Small (single shot)
        this.resepPerUkuran = new HashMap<>();

        // Resep untuk Ukuran SMALL (Single Shot)
        Map<String, Integer> resepSmall = new HashMap<>();
        resepSmall.put("Kopi", 15); // 15gr Kopi
        resepSmall.put("Air", 50);  // 50ml Air
        resepPerUkuran.put(Ukuran.SMALL, resepSmall);

        // Resep untuk Ukuran MEDIUM (Double Shot / Doppio)
        Map<String, Integer> resepMedium = new HashMap<>();
        resepMedium.put("Kopi", 30); // 30gr Kopi
        resepMedium.put("Air", 80);  // 80ml Air
        resepPerUkuran.put(Ukuran.MEDIUM, resepMedium);

        // Resep untuk Ukuran LARGE (Triple Shot)
        Map<String, Integer> resepLarge = new HashMap<>();
        resepLarge.put("Kopi", 45); // 45gr Kopi
        resepLarge.put("Air", 110); // 110ml Air
        resepPerUkuran.put(Ukuran.LARGE, resepLarge);
    }
}