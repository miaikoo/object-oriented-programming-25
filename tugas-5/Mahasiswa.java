import java.util.ArrayList;

public class Mahasiswa {
    private String nim;
    private String nama;
    private ArrayList<MataKuliah> mataKuliahDiambil;

    public Mahasiswa(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
        this.mataKuliahDiambil = new ArrayList<>();
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public void tambahMataKuliah(MataKuliah mk) {
        mataKuliahDiambil.add(mk);
    }
    
    public void lihatKRS() {
        System.out.println("\nKartu Rencana Studi (KRS) untuk " + nama + " (NIM: " + nim + "):");
        if (mataKuliahDiambil.isEmpty()) {
            System.out.println("Belum ada mata kuliah yang diambil.");
        } else {
            for (int i = 0; i < mataKuliahDiambil.size(); i++) {
                System.out.println((i + 1) + ". " + mataKuliahDiambil.get(i));
            }
        }
    }
    
    @Override
    public String toString() {
        return "NIM: " + nim + " | Nama: " + nama;
    }
}