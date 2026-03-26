import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

// PROJEKTNA DOMAČA NALOGA MATIJA ŠKERJANEC
public class DN05 {

    public static void main(String[] args) {
        // PREVERI ČE STA ARGUMENTA 2 IN CE JE BRANJE
        if (args.length == 2 && "branje".equals(args[0])) {
            String imeDatoteke = args[1];
            String tipDatoteke;
            char[][] tabela = null;
            //POD POGOJEM DA JE PRVI ARGUMENT BRANJE ODPRE DATOTEKO IN PREBERE PRVO VRSTICO, CE JE UREJENO ZAŽENE UREJENO, DRUGACE PA NEUREJENO
            try {
                Scanner sc = new Scanner(new File(imeDatoteke));
                if (!sc.hasNextLine()) {
                    System.out.println("Napaka: nepravilen format datoteke.");
                    sc.close();
                    return;
                }
                tipDatoteke = sc.nextLine();
                sc.close();
            }catch (FileNotFoundException e) {
                System.out.println("Napaka: datoteka ne obstaja.");
                return;
            }
            try {
                if (tipDatoteke.equals("UREJENO")) {
                    tabela = preberiUrejenoDatoteko(imeDatoteke);
                }
                else if (tipDatoteke.equals("NEUREJENO")) {
                        tabela = preberiNeurejenoDatoteko(imeDatoteke);
                    }
                else {
                        System.out.println("Napaka: nepravilen format datoteke.");
                        return;
                }
            } catch (FileNotFoundException e) {
                System.out.println("Napaka: datoteka ne obstaja.");
                return;
            }
            if (tabela != null) {
                    izpisiTabelo(tabela);
            }
            return;
        }


        else if (args.length == 3 && "poravnaj".equals(args[0])) {
            String imeDatoteke = args[1];
            String tipDatoteke;
            char[][] tabela = null;
            try {
                Scanner sc = new Scanner(new File(imeDatoteke));
                if (!sc.hasNextLine()) {
                    System.out.println("Napaka: nepravilen format datoteke.");
                    sc.close();
                    return;
                }
                tipDatoteke = sc.nextLine();
                sc.close();
            }catch (FileNotFoundException e) {
                System.out.println("Napaka: datoteka ne obstaja.");
                return;
            }
            try {
                if (tipDatoteke.equals("UREJENO")) {
                    tabela = preberiUrejenoDatoteko(imeDatoteke);
                }
                else if (tipDatoteke.equals("NEUREJENO")) {
                    tabela = preberiNeurejenoDatoteko(imeDatoteke);
                }
                else {
                    System.out.println("Napaka: nepravilen format datoteke.");
                    return;
                }
            } catch (FileNotFoundException e) {
                System.out.println("Napaka: datoteka ne obstaja.");
                return;
            }
            if (tabela != null) {
                char[][] rezultat = poravnajVrstice(tabela, args[2]);
                if (rezultat != null) {
                    izpisiTabelo(rezultat);
                }
            }
            return;
        }
        System.out.println("Napaka: neustrezni argumenti.");
    }
    
    
    

    public static char[][] preberiUrejenoDatoteko(String imeDatoteke) throws FileNotFoundException {

        //ODPREMO DATOTEKO IN PREBEREMO PRVO VRSTICO ČE JE UREJENO
        Scanner sc = new Scanner(new File(imeDatoteke));
        if (!sc.hasNextLine()) {
            System.out.println("Napaka: nepravilen format datoteke.");
            sc.close();
            return null;
        }
        String vrstica = sc.nextLine();
        if(!vrstica.equals("UREJENO")){
            System.out.println("Napaka: nepravilen format datoteke.");
            sc.close();
            return null;
        }
        // PREBEREMO DRUGO VRSTICO IN POGLEDAMO ČE IMA FORMAT int x int
        if (!sc.hasNextLine()) {
            System.out.println("Napaka: nepravilen format datoteke.");
            sc.close();
            return null;
        }
        vrstica = sc.nextLine();
        if(!vrstica.contains("x")){
            System.out.println("Napaka: nepravilen format datoteke.");
            sc.close();
            return null;
        }
        // VRSTICO RAZDELIMO NA 2 STEVILI
        String [] st = vrstica.split("x");
        int visina = 0;
        int sirina = 0;
        // PROBAMO PRETVORITI V INT IN PREVERIMO ALI STA STEVILKI POZITIVNI
        try {
            sirina = Integer.parseInt(st[0]);
            visina = Integer.parseInt(st[1]);
            if (visina <= 0 || sirina <= 0){
                System.out.println("Napaka: nepravilen format datoteke.");
                sc.close();
                return null;
            }// CE NE MOREMO PRETVORITI V INT VRNEMO NAPAKO
        } catch (NumberFormatException e){
            System.out.println("Napaka: nepravilen format datoteke.");
            sc.close();
            return null;
        }

        // USTVARIMO TABELO IN VANJO VNASAMO PODATKE DOKLER JIH LAHKO
        int stevecVrstic = 0;
        char[][] tabela = new char[visina][sirina];

        while(sc.hasNextLine()){
            if (stevecVrstic >= visina) {
                System.out.println("Napaka: nepravilne dimenzije strani.");
                sc.close();
                return null;
            }
            vrstica = sc.nextLine();

            // CE JE VRSTICA PREDOLGA VRNEMO NAPAKO
            if (vrstica.length() != sirina){
                System.out.println("Napaka: nepravilne dimenzije strani.");
                sc.close();
                return null;
            }

            // GREMO CEZ VRSTICO IN VNASAMO VSAK CHAR POSEBAJ V TABELO
            for (int i = 0; i < vrstica.length(); i++) {
                tabela[stevecVrstic][i] = vrstica.charAt(i);
            }
            stevecVrstic ++;

        }
        // CE SE PODANA VISINA IN STEVILO VRSTIC NE UJEMATA VRNEMO NAPAKO
        if(stevecVrstic!=visina){
            System.out.println("Napaka: nepravilne dimenzije strani.");
            sc.close();
            return null;
        }
        sc.close();
        return tabela;
    }



    public static char[][] preberiNeurejenoDatoteko(String imeDatoteke) throws FileNotFoundException {
        //ODPREMO DATOTEKO IN PREBEREMO PRVO VRSTICO ČE JE NEUREJENO
        Scanner sc = new Scanner(new File(imeDatoteke));
        if (!sc.hasNextLine()) {
            System.out.println("Napaka: nepravilen format datoteke.");
            sc.close();
            return null;
        }
        String vrstica = sc.nextLine();
        if(!vrstica.equals("NEUREJENO")){
            System.out.println("Napaka: nepravilen format datoteke.");
            sc.close();
            return null;
        }

        // PREBEREMO DRUGO VRSTICO IN POGLEDAMO ČE IMA FORMAT int x int
        if (!sc.hasNextLine()) {
            System.out.println("Napaka: nepravilen format datoteke.");
            sc.close();
            return null;
        }
        vrstica = sc.nextLine();
        if(!vrstica.contains("x")){
            System.out.println("Napaka: nepravilen format datoteke.");
            sc.close();
            return null;
        }

        // VRSTICO RAZDELIMO NA 2 STEVILI
        String [] st = vrstica.split("x");
        int visina = 0;
        int sirina = 0;

        // PROBAMO PRETVORITI V INT IN PREVERIMO ALI STA STEVILKI POZITIVNI
        try {
            sirina = Integer.parseInt(st[0]);
            visina = Integer.parseInt(st[1]);
            if (visina <= 0 || sirina <= 0){
                System.out.println("Napaka: nepravilen format datoteke.");
                sc.close();
                return null;
            }// CE NE MOREMO PRETVORITI V INT VRNEMO NAPAKO
        } catch (NumberFormatException e){
            System.out.println("Napaka: nepravilen format datoteke.");
            sc.close();
            return null;
        }

        // PREVERIMO DA IMA DATOTEKA RES NOVO VRSTICO
        if (!sc.hasNextLine()) {
            System.out.println("Napaka: nepravilen format datoteke.");
            sc.close();
            return null;
        }
        vrstica = sc.nextLine();


        char[][] tabela = new char[visina][sirina];
        for (int i = 0; i < visina; i++) {
            for (int j = 0; j < sirina; j++) {
                tabela[i][j] = '_';
            }
        }
        int stevec_vrstic = 0;
        int trenutnaSirina = 0;
        // V TABELO BESEDE SHRANIMO BESEDE IZ BESEDILA
        String [] besede = vrstica.split(" ");

        // GREMO ČEZ BESEDE
        for (int i = 0; i < besede.length; i++) {
            String trenutnaBeseda = besede[i];
            if (trenutnaBeseda.length() == 0) {
                continue;
            }
            if (trenutnaBeseda.length() > sirina) {
                System.out.println("Napaka: premajhne dimenzije strani.");
                sc.close();
                return null;
            }
            // ČE JE BESEDA PREDOLGA ZA V VRSTICO, GREMO V NASLEDNJO VRSTICO IN RESETIRAMO SIRINO
            if (trenutnaBeseda.length() + trenutnaSirina + (trenutnaSirina > 0 ? 1 : 0) > sirina ){
                stevec_vrstic ++;
                trenutnaSirina = 0;
                if (stevec_vrstic >= visina) {
                    System.out.println("Napaka: premajhne dimenzije strani.");
                    sc.close();
                    return null;
                }
            }
            if (trenutnaSirina > 0) {
                tabela[stevec_vrstic][trenutnaSirina] = '_';
                trenutnaSirina++;
            }
            // GREMO CEZ BESEDO IN VSAK CHAR DODAJAMO V TABELO.
            for (int j = 0; j < trenutnaBeseda.length() ; j++) {
                if(trenutnaSirina<sirina){
                tabela[stevec_vrstic][trenutnaSirina] = trenutnaBeseda.charAt(j);
                trenutnaSirina++;}
            }
        }
        sc.close();
        return tabela;
    }


    public static void izpisiTabelo(char[][] tabela) { // METODA IZPISE TABELO
        for (int i = 0; i < tabela.length; i++) {
            for (int j = 0; j < tabela[i].length; j++) {
                System.out.print(tabela[i][j]);
            }
            System.out.println();
        }
    }


    public static char[][] poravnajVrstice(char[][] tabela, String nacin) {
        char[][] novaTabela = new char[tabela.length][tabela[0].length];

        for (int i = 0; i < tabela.length; i++) {

            int stBesed = 0;
            int[] zacetki = new int[tabela[i].length];
            int[] dolzine = new int[tabela[i].length];
            int dolzinaBesed = 0;
            int j = 0;
            while (j < tabela[i].length) {
                if (tabela[i][j] == '_') {
                    j++;
                } else {
                    zacetki[stBesed] = j;
                    int zac = j;

                    while (j < tabela[i].length && tabela[i][j] != '_') {
                        j++;
                    }
                    dolzine[stBesed] = j - zac;
                    dolzinaBesed += dolzine[stBesed];
                    stBesed++;
                }
            }
            for (int k = 0; k < novaTabela[i].length; k++) {
                novaTabela[i][k] = '_';
            }
            if (stBesed == 0) continue;
            if (nacin.equals("levo")) {
                int poz = 0;
                for (int l = 0; l < stBesed; l++) {
                    for (int m = 0; m < dolzine[l]; m++) {
                        novaTabela[i][poz] = tabela[i][zacetki[l] + m];
                        poz++;
                    }
                    if (l != stBesed - 1)
                        poz++;

                }

            } else if (nacin.equals("desno")) {
                int dolzinaVrstice = dolzinaBesed + (stBesed - 1);
                int poz = tabela[i].length - dolzinaVrstice;
                for (int l = 0; l < stBesed; l++) {
                    for (int m = 0; m < dolzine[l]; m++) {
                        novaTabela[i][poz] = tabela[i][zacetki[l] + m];
                        poz++;
                    }
                    if (l != stBesed - 1)
                        poz++;

                }
            } else if (nacin.equals("sredina")) {
                int dolzinaVrstice = dolzinaBesed + (stBesed - 1);
                int prosto = tabela[i].length - dolzinaVrstice;
                int poz = prosto / 2;
                for (int l = 0; l < stBesed; l++) {
                    for (int m = 0; m < dolzine[l]; m++) {
                        novaTabela[i][poz] = tabela[i][zacetki[l] + m];
                        poz++;
                    }
                    if (l != stBesed - 1)
                        poz++;

                }
            } else if (nacin.equals("obojestransko")) {
                if (stBesed > 1) {
                    int prosto = tabela[i].length - dolzinaBesed;
                    int osnova = prosto / (stBesed - 1);
                    int ostanek = prosto % (stBesed - 1);
                    int poz = 0;
                    for (int l = 0; l < stBesed; l++) {
                        for (int m = 0; m < dolzine[l]; m++) {
                            novaTabela[i][poz] = tabela[i][zacetki[l] + m];
                            poz++;
                        }
                        if (l != stBesed - 1) {
                            int podcrtaji = osnova;
                            if (l < ostanek) {
                                podcrtaji++;
                            }
                            poz += podcrtaji;
                        }
                    }
                } else if (stBesed == 1) {
                    int poz = 0;
                    for (int l = 0; l < stBesed; l++) {
                        for (int m = 0; m < dolzine[l]; m++) {
                            novaTabela[i][poz] = tabela[i][zacetki[l] + m];
                            poz++;
                        }
                    }
                }
            }
        }
        return novaTabela;
    }




}
