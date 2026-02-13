import java.util.ArrayList;

public class Rental
{
    private ArrayList<Vehicle> daftarKendaraan;
    private ArrayList<Penyewa> daftarPenyewa;

    public Rental()
    {
        daftarKendaraan = new ArrayList<>();
        daftarPenyewa = new ArrayList<>();
    }

    public void tambahKendaraan(Vehicle v) {
        daftarKendaraan.add(v);
    }

    public void tambahPenyewa(Penyewa p) {
        daftarPenyewa.add(p);
    }

    public void tampilkanKendaraan()
    {
        System.out.println("=== Daftar Kendaraan Tersedia ===");
        for (Vehicle v : daftarKendaraan) {
            System.out.println("- " + v.getInfo());
        }
    }

    public void tampilkanPenyewa()
    {
        System.out.println("=== Daftar Penyewa ===");
        for (Penyewa p : daftarPenyewa) {
            System.out.println("- " + p.getInfoPenyewa());
        }
    }
    
    public ArrayList<Vehicle> getDaftarKendaraan() 
    {
    return daftarKendaraan;
    }

}
