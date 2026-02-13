import java.util.ArrayList;

public class Perpustakaan
{
    private ArrayList<Buku> daftarBuku;

    public Perpustakaan()
    {
        daftarBuku = new ArrayList<>();
        daftarBuku.add(new Buku("B001", "Laskar Pelangi", "Andrea Hirata", 2005));
        daftarBuku.add(new Buku("B002", "Bumi Manusia", "Pramoedya A. Toer", 1980));
    }

    // 1. CREATE (Tambah)
    public void tambahBuku(String id, String judul, String penulis, int tahun)
    {
        Buku bukuBaru = new Buku(id, judul, penulis, tahun);
        daftarBuku.add(bukuBaru);
        System.out.println(">> Sukses: Buku berhasil ditambahkan.");
    }

    // 2. READ (Lihat Semua)
    public void tampilkanBuku()
    {
        if (daftarBuku.isEmpty()) {
            System.out.println(">> Info: Perpustakaan kosong.");
        } else {
            System.out.println("\n=== DAFTAR BUKU ===");
            for (Buku b : daftarBuku) {
                System.out.println(b); // Memanggil toString() otomatis
            }
        }
    }

    // 3. UPDATE (Edit berdasarkan ID)
    public void updateBuku(String id, String judulBaru, String penulisBaru, int tahunBaru)
    {
        Buku b = cariBuku(id);
        if (b != null) {
            b.setJudul(judulBaru);
            b.setPenulis(penulisBaru);
            b.setTahun(tahunBaru);
            System.out.println(">> Sukses: Data buku diperbarui.");
        } else {
            System.out.println(">> Error: ID Buku tidak ditemukan.");
        }
    }

    // 4. DELETE (Hapus berdasarkan ID)
    public void hapusBuku(String id)
    {
        Buku b = cariBuku(id);
        if (b != null) {
            daftarBuku.remove(b);
            System.out.println(">> Sukses: Buku berhasil dihapus.");
        } else {
            System.out.println(">> Error: ID Buku tidak ditemukan.");
        }
    }

    private Buku cariBuku(String id)
    {
        for (Buku b : daftarBuku) {
            if (b.getId().equals(id)) {
                return b;
            }
        }
        return null;
    }
}