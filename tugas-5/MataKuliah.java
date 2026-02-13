public class MataKuliah {
    private String kodeMK;
    private String namaMK;
    private int sks;
    private Dosen dosenPengampu;

    public MataKuliah(String kodeMK, String namaMK, int sks, Dosen dosenPengampu) {
        this.kodeMK = kodeMK;
        this.namaMK = namaMK;
        this.sks = sks;
        this.dosenPengampu = dosenPengampu;
    }

    public String getKodeMK() {
        return kodeMK;
    }

    public String getNamaMK() {
        return namaMK;
    }
    
    public Dosen getDosenPengampu(){
        return dosenPengampu;
    }

    @Override
    public String toString() {
        return "Kode: " + kodeMK + " | " + namaMK + " (" + sks + " SKS) | Dosen: " + dosenPengampu.getNama();
    }
}