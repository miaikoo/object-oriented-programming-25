import java.util.Map;
import java.util.HashMap;

public class Latte extends Minuman {
    public Latte() {
        this.nama = "Latte";
        this.hargaDasar = 15000; // Harga dasar untuk ukuran Small
        this.resepPerUkuran = new HashMap<>();

        // Resep untuk Ukuran SMALL (1 shot espresso)
        Map<String, Integer> resepSmall = new HashMap<>();
        resepSmall.put("Kopi", 15); // 15gr Kopi
        resepSmall.put("Susu", 150); // 150ml Susu
        resepSmall.put("Air", 50);  // 50ml Air
        resepPerUkuran.put(Ukuran.SMALL, resepSmall);

        // Resep untuk Ukuran MEDIUM (2 shot espresso, lebih banyak susu)
        Map<String, Integer> resepMedium = new HashMap<>();
        resepMedium.put("Kopi", 30); // 30gr Kopi (2 shot)
        resepMedium.put("Susu", 250); // 250ml Susu
        resepMedium.put("Air", 60);  // 60ml Air
        resepPerUkuran.put(Ukuran.MEDIUM, resepMedium);

        // Resep untuk Ukuran LARGE (2 shot espresso, susu paling banyak)
        Map<String, Integer> resepLarge = new HashMap<>();
        resepLarge.put("Kopi", 30); // Tetap 30gr Kopi (2 shot)
        resepLarge.put("Susu", 350); // 350ml Susu
        resepLarge.put("Air", 75);  // 75ml Air
        resepPerUkuran.put(Ukuran.LARGE, resepLarge);
    }
}