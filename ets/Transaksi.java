import java.util.Date;

public class Transaksi {
    private final Date waktu;
    private final String namaMinuman;
    private final int totalHarga;

    public Transaksi(String namaMinuman, int totalHarga) {
        this.waktu = new Date();
        this.namaMinuman = namaMinuman;
        this.totalHarga = totalHarga;
    }
    
    @Override
    public String toString() {
        return "Transaksi [Waktu=" + waktu + ", Minuman=" + namaMinuman + ", Harga=" + totalHarga + "]";
    }
}