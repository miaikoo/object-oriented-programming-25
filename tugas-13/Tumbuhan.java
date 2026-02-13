public class Tumbuhan extends MakhlukHidup
{
    public Tumbuhan(String nama)
    {
        super(nama);
    }

    @Override
    public String caraBernafas()
    {
        return "Bernafas melalui stomata (mulut daun).";
    }

    @Override
    public String caraMakan()
    {
        return "Membuat makanan sendiri melalui Fotosintesis.";
    }
}