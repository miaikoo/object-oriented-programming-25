import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProdukMenu {
    public record DataUkuran(String namaTampilan, int hargaTambahan, Map<String, Integer> resep) {}

    private final String nama;
    private final int hargaDasar;
    private final List<DataUkuran> daftarUkuran;

    public ProdukMenu(String nama, int hargaDasar) {
        this.nama = nama;
        this.hargaDasar = hargaDasar;
        this.daftarUkuran = new ArrayList<>();
    }

    public void tambahUkuran(String namaTampilan, int hargaTambahan, Map<String, Integer> resep) {
        this.daftarUkuran.add(new DataUkuran(namaTampilan, hargaTambahan, resep));
    }

    public String getNama() {
        return nama;
    }

    public int getHargaDasar() {
        return hargaDasar;
    }

    public List<DataUkuran> getDaftarUkuran() {
        return daftarUkuran;
    }
}