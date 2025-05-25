// MUH FADRIAN NAUFAL 050590589 (Tugas 2)
import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;
public class HitungGaji {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        NumberFormat formatter = NumberFormat.getInstance(new Locale("in","ID"));

        String golongan;
        int jamLembur;
        long gajiPokok = 0;
        double persentaseLembur = 0.0;

        System.out.println("   Program Hitung Gaji Karyawan   ");
        System.out.print("Masukkan Golongan Karyawan (A/B/C):  ");
        golongan = input.next().toUpperCase();

        System.out.print("Masukkan Total Jam Lembur:  ");
        jamLembur = input.nextInt();

        //logika golongan gaji pokok

        switch (golongan) {
            case "A":
                gajiPokok = 5000000;
                break;
            case "B":
                gajiPokok = 6500000;
                break;
            case "C":
                gajiPokok = 9500000;
                break;
            default:
                System.out.println("Golongan tidak valid. Silahkan Masukkan A,B, atau C :)");
                input.close();
                return;
        }

        //logika persentase lembur
        if (jamLembur == 1) {
            persentaseLembur = 0.30; // 30%
        } else if (jamLembur == 2) {
            persentaseLembur = 0.32; // 32%
        } else if (jamLembur == 3) {
            persentaseLembur = 0.34; // 34%
        } else if (jamLembur == 4) {
            persentaseLembur = 0.36; // 36%
        } else if (jamLembur >= 5) {
            persentaseLembur = 0.38; // 38%
        }

        //Perhitungan total gaji
        long gajiLembur = (long) (gajiPokok * persentaseLembur); // Hasilnya di-cast ke long
        long totalPenghasilan = gajiPokok + gajiLembur;

        //output
        System.out.println("\n--- Rincian Gaji ---");
        System.out.println("Gaji Pokok Anda (Golongan " + golongan + "): Rp " + formatter.format(gajiPokok));
        System.out.println("Gaji Lembur (" + jamLembur + " jam)        : Rp " + formatter.format(gajiLembur));
        System.out.println("------------------------------------------ +");
        System.out.println("Total Penghasilan Anda     : Rp " + formatter.format(totalPenghasilan));

        input.close();
    }
}