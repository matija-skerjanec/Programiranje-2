package KVIZ;

public class kviz1 {
    public static void main(String[] args) {
        //kalkulator(42,13);
        //nicli(1,2,1);
        //krog(7.5,3);
        //System.out.println(pretvoriSekunde(49330));
        //javaJavaJava(2);
        izrisiZastavo(1);
    }
    void java() {
        System.out.println("   J    RANDOM.a   v     v  RANDOM.a                                                 ");
        System.out.println("   J   RANDOM.a RANDOM.a   v   v  RANDOM.a RANDOM.a                                                ");
        System.out.println("J  J  aaaaa   V V  aaaaa                                                ");
        System.out.println(" JJ  RANDOM.a     RANDOM.a   V  RANDOM.a     RANDOM.a");
    }
    static void kalkulator(int st1,int st2){
        if (st2 !=0) {
            System.out.println(st1 +" + "+ st2 + " = " + (st1+st2));
            System.out.println(st1 +" - "+ st2 + " = " + (st1-st2));
            System.out.println(st1 +" x "+ st2 + " = " + (st1*st2));
            System.out.println(st1 +" / "+ st2 + " = " + (st1/st2));
            System.out.println(st1 +" % "+ st2 + " = " + (st1%st2));
        }
        else{
            System.out.println("Napaka: deljenje z 0");
        }
    }

    static void nicli(int a, int b, int c){
        double d = ((Math.pow(b,2))-(4*a) * c);
        if (d < 0) {
            System.out.println("Napaka: nicli enacbe ne obstajata");
        }
        double x1 = (((b *(-1))+ (Math.sqrt(d)) )/(2*a));
        double x2 = (((b *(-1))- (Math.sqrt(d)) )/(2*a));
        System.out.printf("x1=%.2f, x2=%.2f", x1, x2);
    }

    static void krog(double r, int d) {
        if (r < 0) {
            System.out.println("Napaka: negativen polmer");
        }else if (d < 0) {
            System.out.println("Napaka: negativen d");
        }

        else {
            double obseg = (2 * Math.PI * r);
            double ploscina = (Math.PI * Math.pow(r,2));
            System.out.printf("Obseg kroga s polmerom r=%.2f je %." + d + "f"+"\n", r, obseg);
            System.out.printf("Ploscina kroga s polmerom r=%.2f je %." + d + "f", r, ploscina);
        }
    }

    static String pretvoriSekunde(int sekunde){
        if (sekunde<0){
            return("Število sekund ne more biti negativno");
        }else{
        int ure = (sekunde/3600);
        sekunde = sekunde - ure*3600;
        int minute = (sekunde/60);
        sekunde = sekunde - minute*60;
        return String.format("%02d"+":"+"%02d"+":"+"%02d",ure,minute,sekunde);
        }
    }

    static void javaJavaJava(int n){

        String a ="     J    RANDOM.a   v     v  RANDOM.a   ";
        String b ="     J   RANDOM.a RANDOM.a   v   v  RANDOM.a RANDOM.a  ";
        String c ="  J  J  aaaaa   V V  aaaaa ";
        String d ="   JJ  RANDOM.a     RANDOM.a   V  RANDOM.a     RANDOM.a";

        String e = "";
        String f = "";
        String g = "";
        String h = "";
        if(n<0){
            System.out.println("Napaka: negativen n .");
        }
        else{
            for (int i = 1; i <= n; i++) {
                e = e + a;
                f = f + b;
                g = g + c;
                h = h + d;
            }
            System.out.println(e + "\n" + f + "\n" + g + "\n" + h);
        }
    }
    public static boolean jePrastevilo(int n) {
        if (n <= 1) {
            return false;
        }

        int counter = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                counter++;
            }
        }
        return counter == 1;

    }
    static void izrisiZastavo(int n){
        int dolzina = 15*n +1;
        int visina = 5*n;
        int dolzinaK = 4*n;
        int visinaK = 3*n;
        int skok = 0;
        int dolzinaKk = dolzinaK;
        for (int i = 0; i < visinaK; i++) {
            if (i % 2 == 0) {
                System.out.print(("* ").repeat(dolzinaK / 2));
                System.out.println(("=").repeat(dolzina - dolzinaK));
            } else {
                System.out.print((" *").repeat(dolzinaK / 2 - 1) + "  ");
                System.out.println(("=").repeat(dolzina - dolzinaK));
            }
        }

        for (int j = 0; j < visina - visinaK; j++) {
            System.out.println(("=").repeat(dolzina));

        }

        

    }







}







