package KVIZ;

public class kviz2 {
    public static void main(String[] args) {
        System.out.println(vsotaStevk("Matija5151"));
        System.out.println(preveriRep("Danes je lep dan" , "dan"));
    }
    static int vsotaStevk(String str){
        int vsota = 0;
        for(int i = 0;i<str.length();i++){
            char stevka = str.charAt(i);
            if(Character.isDigit(stevka)){

                vsota+=stevka - '0';
            }
        }
        return vsota;
    }

    static boolean preveriRep(String a, String b) {
        if (a.length() >= b.length()) {
            String zadnjiDelA = a.substring(a.length() - b.length());
            if (zadnjiDelA.equalsIgnoreCase(b)) {
                return true;
            }
        }

        if (b.length() >= a.length()) {
            String zadnjiDelB = b.substring(b.length() - a.length());
            if (zadnjiDelB.equalsIgnoreCase(a)) {
                return true;
            }
        }

        return false;
    }


}
