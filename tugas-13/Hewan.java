public class Hewan extends MakhlukHidup
{
    private String jenis;

    public Hewan(String nama, String jenis)
    {
        super(nama);
        this.jenis = jenis;
    }

    @Override
    public String caraBernafas()
    {
        return "Bernafas menyesuaikan habitat (misal: Insang/Paru-paru).";
    }

    @Override
    public String caraMakan()
    {
        return "Memakan daging atau tumbuhan (Karnivora/Herbivora).";
    }
}