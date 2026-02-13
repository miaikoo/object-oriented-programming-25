import java.util.ArrayList;
import java.util.Scanner;

public class Sistem {
    private ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
    private ArrayList<Dosen> daftarDosen = new ArrayList<>();
    private ArrayList<MataKuliah> daftarMataKuliah = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public Sistem() {
        inisialisasiData();
    }

    private void inisialisasiData() {
        Dosen dosen1 = new Dosen("198201012005011001", "Dr. Budi Hartono");
        Dosen dosen2 = new Dosen("199002032015042002", "Siti Aminah, M.Kom.");
        daftarDosen.add(dosen1);
        daftarDosen.add(dosen2);
        
        daftarMataKuliah.add(new MataKuliah("IF101", "Dasar Pemrograman", 3, dosen1));
        daftarMataKuliah.add(new MataKuliah("IF102", "Struktur Data", 3, dosen1));
        daftarMataKuliah.add(new MataKuliah("IF201", "Basis Data", 3, dosen2));
        
        daftarMahasiswa.add(new Mahasiswa("05111940000001", "Ahmad Fauzi"));
    }

    public void jalankan() {
        int pilihan;
        do {
            System.out.println("\n=== Sistem Pengambilan Mata Kuliah ===");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Mahasiswa Ambil Mata Kuliah");
            System.out.println("3. Lihat KRS Mahasiswa");
            System.out.println("4. Lihat Semua Mahasiswa");
            System.out.println("5. Lihat Semua Mata Kuliah");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1: tambahMahasiswa(); break;
                case 2: ambilMataKuliah(); break;
                case 3: lihatKRSMahasiswa(); break;
                case 4: lihatSemuaMahasiswa(); break;
                case 5: lihatSemuaMataKuliah(); break;
                case 6: System.out.println("Terima kasih! Keluar dari aplikasi."); break;
                default: System.out.println("Pilihan tidak valid, coba lagi.");
            }
        } while (pilihan != 6);
        scanner.close();
    }
    
    private void tambahMahasiswa() {
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();
        if (findMahasiswaByNim(nim) != null) {
            System.out.println("ERROR: Mahasiswa dengan NIM " + nim + " sudah ada.");
            return;
        }
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();
        daftarMahasiswa.add(new Mahasiswa(nim, nama));
        System.out.println("INFO: Mahasiswa berhasil ditambahkan!");
    }

    private void ambilMataKuliah() {
        System.out.print("Masukkan NIM mahasiswa: ");
        String nim = scanner.nextLine();
        Mahasiswa mhs = findMahasiswaByNim(nim);

        if (mhs == null) {
            System.out.println("ERROR: Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
            return;
        }

        System.out.println("\nDaftar Mata Kuliah Tersedia:");
        lihatSemuaMataKuliah();
        System.out.print("Masukkan kode mata kuliah yang akan diambil: ");
        String kodeMK = scanner.nextLine();
        MataKuliah mk = findMataKuliahByKode(kodeMK);

        if (mk == null) {
            System.out.println("ERROR: Mata kuliah dengan kode " + kodeMK + " tidak ditemukan.");
            return;
        }

        mhs.tambahMataKuliah(mk);
        System.out.println("INFO: " + mk.getNamaMK() + " berhasil ditambahkan ke KRS " + mhs.getNama());
    }

    private void lihatKRSMahasiswa() {
        System.out.print("Masukkan NIM mahasiswa: ");
        String nim = scanner.nextLine();
        Mahasiswa mhs = findMahasiswaByNim(nim);

        if (mhs == null) {
            System.out.println("ERROR: Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
        } else {
            mhs.lihatKRS();
        }
    }
    
    private void lihatSemuaMahasiswa() {
        System.out.println("\n--- Daftar Semua Mahasiswa ---");
        if (daftarMahasiswa.isEmpty()){
            System.out.println("Belum ada data mahasiswa.");
        } else {
            for (int i = 0; i < daftarMahasiswa.size(); i++) {
                System.out.println((i + 1) + ". " + daftarMahasiswa.get(i));
            }
        }
    }

    private void lihatSemuaMataKuliah() {
        System.out.println("\n--- Daftar Semua Mata Kuliah ---");
        if (daftarMataKuliah.isEmpty()){
            System.out.println("Belum ada data mata kuliah.");
        } else {
            for (int i = 0; i < daftarMataKuliah.size(); i++) {
                System.out.println((i + 1) + ". " + daftarMataKuliah.get(i));
            }
        }
    }

    private Mahasiswa findMahasiswaByNim(String nim) {
        for (Mahasiswa mhs : daftarMahasiswa) {
            if (mhs.getNim().equalsIgnoreCase(nim)) return mhs;
        }
        return null;
    }

    private MataKuliah findMataKuliahByKode(String kodeMK) {
        for (MataKuliah mk : daftarMataKuliah) {
            if (mk.getKodeMK().equalsIgnoreCase(kodeMK)) return mk;
        }
        return null;
    }
    
    public static void main(String[] args) {
        Sistem sistem = new Sistem();
        sistem.jalankan();
    }
}