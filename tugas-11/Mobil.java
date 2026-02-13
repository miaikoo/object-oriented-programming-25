public class Mobil extends Vehicle
{
    private int jumlahRoda;

    public Mobil(String merk, String model, int tahunProduksi, int jumlahRoda)
    {
        super(merk, model, tahunProduksi);
        this.jumlahRoda = jumlahRoda;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " - Mobil, Roda: " + jumlahRoda;
    }
}
