public class Tabungan extends Rekening implements BerBunga {
    private double bunga; // persen per bulan

    public Tabungan(int nomor, String pemilik, int saldo, double bunga) {
        super(nomor, pemilik, saldo);
        this.bunga = bunga;
    }

    @Override
    public double getBunga() { return bunga; }

    @Override
    public int tambahBunga() {
        int hasil = (int) (saldo * bunga / 100);
        saldo += hasil;
        return hasil;
    }

    @Override
    public int biayaAdminBulanan() {
        return saldo >= 1_000_000 ? 0 : 5_000;
    }

    @Override
    public String getJenis() {
        return "Tabungan, bunga " + String.format("%.2f", bunga) + " per bulan";
    }
}
