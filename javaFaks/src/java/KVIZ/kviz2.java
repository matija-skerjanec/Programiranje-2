package KVIZ;

import java.util.ArrayList;
import java.util.Arrays;

public class kviz2 {
    public static void main(String[] args) {
        //System.out.println(vsotaStevk("Matija5151"));
        //System.out.println(preveriRep("Danes je lep dan" , "dan"));
        int[]tabela = {1,2,3,4,5,6};
        rotiraj(tabela,1);
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

    static  int[] range(int a, int b, int c){
        int velikost = 0;
        int stevilo = 0;

        for (int x = a; x < b; x += c) {
            velikost++;
        }

        int[] tabela = new int[velikost];

        tabela[0] = a;
        int i = 0;
        for (int x = a; x < b; x += c) {
            tabela[i] = x;
            i++;
        }
        return tabela;
    }


    public static void rotiraj(int[] tabela, int k) {
        int n = tabela.length;
        if (n == 0) return;

        k = k % n;
        int[] nova = new int[n];

        for (int i = 0; i < n; i++) {
            int noviIndeks = (i - k + n) % n;
            nova[noviIndeks] = tabela[i];
        }

        for (int i = 0; i < n; i++) {
            tabela[i] = nova[i];
        }
    }


    }






}



















