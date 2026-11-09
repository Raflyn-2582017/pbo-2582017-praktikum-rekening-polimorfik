public abstract class Rekening {
    protected int nomor;
    protected String pemilik;
    protected int saldo;

    public Rekening(int nomor, String pemilik, int saldo) {
        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldo;
    }

    public int getNomor() { return nomor; }
    public String getPemilik() { return pemilik; }
    public int getSaldo() { return saldo; }

    public void setor(int jumlah) {
        if (jumlah > 0) saldo += jumlah;
    }

    public boolean tarik(int jumlah) {
        if (jumlah > 0 && jumlah <= saldo) {
            saldo -= jumlah;
            return true;
        }
        return false;
    }

    // Setiap jenis rekening wajib menentukan biaya adminnya sendiri
    public abstract int biayaAdminBulanan();

    // Method konkret: kurangi saldo, kembalikan besar biaya
    public int potongBiayaAdmin() {
        int biaya = biayaAdminBulanan();
        saldo -= biaya;
        return biaya;
    }

    public abstract String getJenis();

    public static String rp(int n) {
        String s = String.format("%,d", Math.abs(n)).replace(',', '.');
        return (n < 0 ? "-Rp" : "Rp") + s;
    }

    @Override
    public String toString() {
        return nomor + " | " + pemilik + " | " + rp(saldo);
    }
}