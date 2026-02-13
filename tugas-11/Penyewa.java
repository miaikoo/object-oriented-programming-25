public class Penyewa
{
    private String nama;
    private Vehicle kendaraan;

    public Penyewa(String nama, Vehicle kendaraan)
    {
        this.nama = nama;
        this.kendaraan = kendaraan;
    }

    public String getNama() {
        return nama;
    }

    public Vehicle getKendaraan() {
        return kendaraan;
    }

    public String getInfoPenyewa() {
        return nama + " menyewa: " + kendaraan.getInfo();
    }
}
