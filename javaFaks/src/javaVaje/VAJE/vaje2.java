package VAJE;

public class vaje2 {
    public static void main(String[] args) {
        System.out.println(" n              n!            Stirling(n)      napaka (%)");
        System.out.println("----------------------------------------------------------\n");
        for(int i = 1;i<=20;i++) {
            double napaka = Math.abs(fakultetaL(i) - stirlingL(i)) / (double)fakultetaL(i) * 100;
            System.out.printf("%3d %19d %19d  %.7f",i,fakultetaL(i), stirlingL(i) , napaka);
            System.out.println();
        }
        System.out.println();
        System.out.println("  n         n!            Stirling(n)     napaka (%)");
        System.out.println("----------------------------------------------------\n");
        for (int i = 1; i<=100;i++){
            double napaka = Math.abs(fakultetaD(i) - stirlingD(i)) / (double)fakultetaD(i) * 100;
            System.out.printf("%3d %16.9E  %16.9E  %.7f",i,fakultetaD(i), stirlingD(i) , napaka);
            System.out.println();

        }

        System.out.println("  k    Math.PI             PI (Nilakantha)     razlika \n");
        System.out.println("-----------------------------------------------------------------\n");
        for (int i = 0; i<22; i++) {
            double razlika = Math.PI - izracunajPiNilakantha(i);
            System.out.printf("%3d %17.15f %17.15f %+18.15f", i ,Math.PI,izracunajPiNilakantha(i),razlika);
            System.out.println();
        }


    }
    static long fakultetaL(int n){
        long vsota = 1;
        for(int i=n;i>=1;i--){
            vsota = vsota * i;
        }
        return vsota;
    }

    static long stirlingL(int n){
        long st = Math.round(Math.sqrt(2*Math.PI*n)*(Math.pow((n/Math.E),n)));
        return st;
    }
    static double fakultetaD(int n){
        double vsota = 1;
        for(int i=n;i>=1;i--){
            vsota = vsota * i;
        }
        return vsota;
    }
    static double stirlingD(int n) {
        double st = (Math.sqrt(2 * Math.PI * n) * (Math.pow((n / Math.E), n)));
        return st;

    }

    public static double izracunajPiNilakantha(int k) {
        double pi = 3.0;
        double predznak = 1.0;
        int n = 2;

        for (int i = 0; i < k; i++) {
            pi += predznak * (4.0 / (n * (n + 1) * (n + 2)));
            predznak *= -1;
            n += 2;
        }

        return pi;

    }

}




