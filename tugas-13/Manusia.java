public class Manusia extends MakhlukHidup
{
    public Manusia(String nama)
    {
        super(nama);
    }

    @Override
    public String caraBernafas()
    {
        return "Bernafas menggunakan Paru-paru.";
    }

    @Override
    public String caraMakan()
    {
        return "Memakan nasi dan lauk pauk (Omnivora).";
    }
}