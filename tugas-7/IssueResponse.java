import java.util.ArrayList;

public class IssueResponse {

    private ArrayList<IssueDB> issueTable;

    public IssueResponse() {
        issueTable = new ArrayList<>();

        issueTable.add(new IssueDB(1, "Kelas penuh. Silakan cari kelas lain."));
        issueTable.add(new IssueDB(2, "Prasyarat belum terpenuhi. Harap ambil matkul prasyarat dahulu."));
        issueTable.add(new IssueDB(3, "Jadwal bentrok. Pilih kelas dengan waktu berbeda."));
        issueTable.add(new IssueDB(4, "SKS melebihi batas. Sesuaikan dengan IPK Anda."));
        issueTable.add(new IssueDB(5, "NRP salah. Periksa kembali format NRP."));
        issueTable.add(new IssueDB(6, "IPK rendah. Anda dibatasi jumlah SKS."));
        issueTable.add(new IssueDB(7, "Kelas tidak tersedia."));
        issueTable.add(new IssueDB(8, "Kelas tersedia dan tidak penuh. Anda bisa mengambilnya."));
        issueTable.add(new IssueDB(9, "Nama kelas tidak ditemukan."));
        issueTable.add(new IssueDB(10, "Sistem error. Coba lagi nanti."));
        issueTable.add(new IssueDB(11, "Mata kuliah sudah pernah diambil."));
        issueTable.add(new IssueDB(12, "Masa FRS berakhir."));
        issueTable.add(new IssueDB(13, "Akses ditolak."));
        issueTable.add(new IssueDB(14, "Server sibuk. Silakan tunggu."));
        issueTable.add(new IssueDB(15, "Belum bayar UKT."));
    }

    public String getResponse(int code) {
        for (IssueDB issue : issueTable) {
            if (issue.getCode() == code) {
                return issue.getMessage();
            }
        }
        return "Kode masalah tidak ditemukan.";
    }
}
