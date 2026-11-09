public class Giro extends Rekening {
    private int batasOverdraft;

    public Giro(int nomor, String pemilik, int saldo, int batasOverdraft) {
        super(nomor, pemilik, saldo);
        this.batasOverdraft = batasOverdraft;
    }

    public int getBatasOverdraft() { return batasOverdraft; }

    @Override
    public boolean tarik(int jumlah) {
        if (jumlah > 0 && jumlah <= saldo + batasOverdraft) {
            saldo -= jumlah;
            return true;
        }
        return false;
    }

    @Override
    public int biayaAdminBulanan() {
        return 15_000;
    }

    @Override
    public String getJenis() {
        return "Giro, batas overdraft " + rp(batasOverdraft);
    }
}
