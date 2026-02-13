public class Buku
{
    private String id;
    private String judul;
    private String penulis;
    private int tahun;

    public Buku(String id, String judul, String penulis, int tahun)
    {
        this.id = id;
        this.judul = judul;
        this.penulis = penulis;
        this.tahun = tahun;
    }

    public String getId() { return id; }
    
    public String getJudul() { return judul; }
    public void setJudul(String judul) { this.judul = judul; }
    
    public String getPenulis() { return penulis; }
    public void setPenulis(String penulis) { this.penulis = penulis; }
    
    public int getTahun() { return tahun; }
    public void setTahun(int tahun) { this.tahun = tahun; }

    public String toString() {
        return "ID: " + id + " | " + judul + " (" + tahun + ") oleh " + penulis;
    }
}