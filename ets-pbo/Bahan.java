public class Bahan {
    private String nama;
    private int jumlah;
    private String satuan;

    public Bahan(String nama, int jumlah, String satuan) {
        this.nama = nama;
        this.jumlah = jumlah;
        this.satuan = satuan;
    }

    public String getNama() {
        return nama;
    }

    public int getJumlah() {
        return jumlah;
    }
    
    public String getSatuan() {
        return satuan;
    }

    public void tambahJumlah(int jumlah) {
        this.jumlah += jumlah;
    }

    public void kurangiJumlah(int jumlah) {
        if (this.jumlah >= jumlah) {
            this.jumlah -= jumlah;
        }
    }
}