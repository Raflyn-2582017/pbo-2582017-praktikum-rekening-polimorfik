public class RekeningPolimorfik {
    public static void main(String[] args) {
        Tabungan ari = new Tabungan(101, "Ari", 1_000_000, 2.5);
        Tabungan citra = new Tabungan(102, "Citra", 300_000, 2.0);
        Giro budi = new Giro(201, "Budi", 200_000, 500_000);

        Rekening[] semua = { ari, citra, budi };
        BerBunga[] berbunga = { ari, citra };

        System.out.println("=== REKENING AWAL ===");
        for (Rekening r : semua) {
            System.out.println(r);
            System.out.println("  " + r.getJenis());
        }

        System.out.println();
        System.out.println("=== BIAYA ADMIN ===");
         for (Rekening r : semua) {
            int biaya = r.potongBiayaAdmin();
            System.out.println(r.getNomor() + " Biaya admin : " + Rekening.rp(biaya));
        }

        System.out.println();
        System.out.println("=== BUNGA ===");
        for (BerBunga b : berbunga) {
            Rekening r = (Rekening) b;
            int hasil = b.tambahBunga();
            System.out.println(r.getNomor() + " Bunga : " + Rekening.rp(hasil));
        }

        System.out.println();
        System.out.println("=== REKENING AKHIR ===");
        int total = 0;
        for (Rekening r : semua) {
            System.out.println(r);
            System.out.println("  " + r.getJenis());
            total += r.getSaldo();
        }
        System.out.println();
        System.out.println("Total saldo bank : " + Rekening.rp(total));
    }
}
