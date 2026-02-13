public abstract class MakhlukHidup
{
    protected String nama;

    public MakhlukHidup(String nama)
    {
        this.nama = nama;
    }

    public String getNama()
    {
        return nama;
    }

    public abstract String caraBernafas();
    public abstract String caraMakan();
}