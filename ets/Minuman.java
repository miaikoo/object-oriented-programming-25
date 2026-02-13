import java.util.Map;

public abstract class Minuman {
    protected String nama;
    protected int hargaDasar;
    // Resep sekarang adalah Map yang key-nya Ukuran, dan value-nya adalah resep itu sendiri
    protected Map<Ukuran, Map<String, Integer>> resepPerUkuran;

    public String getNama() {
        return nama;
    }

    public int getHargaDasar() {
        return hargaDasar;
    }

    /**
     * Mengambil resep spesifik berdasarkan ukuran yang diminta.
     * @param ukuran Ukuran minuman (SMALL, MEDIUM, LARGE)
     * @return Map resep untuk ukuran tersebut, atau null jika tidak tersedia.
     */
    public Map<String, Integer> getResep(Ukuran ukuran) {
        return resepPerUkuran.get(ukuran);
    }
}