public enum Ukuran {
    SMALL("Small", 0),
    MEDIUM("Medium", 3000),
    LARGE("Large", 5000);

    private final String namaTampilan;
    private final int hargaTambahan;

    Ukuran(String namaTampilan, int hargaTambahan) {
        this.namaTampilan = namaTampilan;
        this.hargaTambahan = hargaTambahan;
    }

    public String getNamaTampilan() {
        return namaTampilan;
    }

    public int getHargaTambahan() {
        return hargaTambahan;
    }
}