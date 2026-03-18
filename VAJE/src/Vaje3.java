public class Vaje3 {
    public static void main(String[] args) {
        izpisi16bit((short)0b1111100111111001);
        izpisi16bit((short) 0b1111100111111000);
        izpisi16bit((short) 0b1110001001001111);
        izpisi16bit2(new short[] {(short)0b1111100011101000, (short)0b1111100111111010, (short)0b1111010001001111});
        System.out.println();
        izpisi16bit3("Programiranje");


    }
    public static void  izpisi16bit(short kodaZnaka){
        for (int i = 15; i >= 0 ; i--) {
            int maska = 1<<i;
            if((kodaZnaka & maska)!=0){
                System.out.print(Znaki.crnaPika);
            }

            else{
                System.out.print(Znaki.belaPika);
            }
            if(i%4==0){
                System.out.println();
            }
        }
        System.out.println();
    }


    public static void izpisi16bit2(short[] nizZnakov) {

        for (int vrstica = 0; vrstica < 4; vrstica++) {

            for (int i = 0; i < nizZnakov.length; i++) {

                for (int stolpec = 0; stolpec < 4; stolpec++) {

                    int bit = 15 - (vrstica * 4 + stolpec);
                    int maska = 1 << bit;

                    if ((nizZnakov[i] & maska) != 0) {
                        System.out.print(Znaki.crnaPika);
                    } else {
                        System.out.print(Znaki.belaPika);
                    }
                }


                System.out.print(Znaki.belaPika);
            }

            System.out.println();
        }
    }

    public static void izpisi16bit3(String niz){
        niz = niz.toUpperCase();
        short[] kode = new short[niz.length()];

        for (int i = 0; i < niz.length(); i++) {
            char crka = niz.charAt(i);
            int index = -1;

            for (int j = 0; j < Znaki.abeceda.length; j++) {
                if (crka == Znaki.abeceda[j]) {
                    index = j;
                    break;
                }
            }

            if (index != -1) {
                kode[i] = Znaki.kodeZnakov16bit[index];
            } else {
                kode[i] = Znaki.kodeZnakov16bit[Znaki.abeceda.length - 1];
            }
        }

        izpisi16bit2(kode);
    }

    static class Znaki{
         private static final char crnaPika = '\u2B1B'; // črn kvadratek
         private static final char belaPika = '\u2B1C'; // prazen (bel) kvadratek

         private static final char[] abeceda = {
                 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                 '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ' '};

         private static final short[] kodeZnakov16bit = {
                 (short) 0b1111100111111001, // A
                 (short) 0b1100101011011010, // B
                 (short) 0b1111100010001111, // C
                 (short) 0b1110100110011110, // D
                 (short) 0b1111111010001111, // E
                 (short) 0b1111100011101000, // F
                 (short) 0b1111100010111111, // G
                 (short) 0b1001100111111001, // H
                 (short) 0b1111010001001111, // I
                 (short) 0b1111000110011111, // J
                 (short) 0b1011110010101001, // K
                 (short) 0b1000100010001111, // L
                 (short) 0b1111101110011001, // M
                 (short) 0b1101101110011001, // N
                 (short) 0b1111100110011111, // O
                 (short) 0b1111100111111000,                // TODO: dodajte znak P
                 (short) 0b1111100110111111, // Q
                 (short) 0b1111100111111010, // R
                 (short) 0b1111100011110111, // S
                 (short) 0b1111010001000100, // T
                 (short) 0b1001100110011111, // U
                 (short) 0b1001100110010110, // V
                 (short) 0b1001100110111111, // W
                 (short) 0b1001011001101001, // X
                 (short) 0b1001100111110100, // Y
                 (short) 0b1111001001001111, // Z
                 (short) 0b0110100110010110, // 0
                 (short) 0b0110001000101111, // 1
                 (short) 0b1110001001001111,              // TODO: dodajte znak 2
                 (short) 0b1111011100011111, // 3
                 (short) 0b1000100111110001, // 4
                 (short) 0b1111100011110111, // 5
                 (short) 0b1000111110011111, // 6
                 (short) 0b1111000100010001, // 7
                 (short) 0b1110101111010111, // 8
                 (short) 0b1111100111110001, // 9
                  0                          // presledek
         };
    }
}
