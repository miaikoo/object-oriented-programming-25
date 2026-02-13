public class Vehicle
{
    private String merk;
    private String model;
    private int tahunProduksi;

    public Vehicle(String merk, String model, int tahunProduksi)
    {
        this.merk = merk;
        this.model = model;
        this.tahunProduksi = tahunProduksi;
    }

    public String getMerk() {
        return merk;
    }

    public String getModel() {
        return model;
    }

    public int getTahunProduksi() {
        return tahunProduksi;
    }

    public String getInfo() {
        return merk + " " + model + " (" + tahunProduksi + ")";
    }
}
