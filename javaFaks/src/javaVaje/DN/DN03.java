package DN;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class DN03 {
    public static void main(String[] args)throws Exception {
        String fileName = args[0];
        int dolzinaGesla = Integer.parseInt(args[1]);
        int seed = Integer.parseInt(args[2]);

        Scanner sc = new Scanner(new File(fileName));
        ArrayList<String> besede = new ArrayList<>();
        int stBesed = Integer.parseInt(sc.nextLine());

        while(sc.hasNextLine()) {
            String v = sc.nextLine();
            besede.add(v);
        }
        sc.close();


        StringBuilder geslo = new StringBuilder();
        Random rnd = new Random(seed);

        for (int i = 0; i < dolzinaGesla; i++){
            String rndBeseda = besede.get(rnd.nextInt(stBesed));
            char rndCrka = rndBeseda.charAt(rnd.nextInt(rndBeseda.length()));
            geslo.append(rndCrka);
        }

        System.out.println(geslo);

    }
}
