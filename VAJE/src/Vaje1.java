

public class Vaje1 {
    public static void main(String[] args) {
        romb(2, 5);
    }

    static void pravokotnikStevilVrstice(int sirina, int visina) {
        for(int i = 1; i <= visina; ++i) {
            for(int j = 1; j < sirina; ++j) {
                System.out.print(i % 10);
            }

            System.out.println();
        }

    }

    static void pravokotnikStevilStolpci(int sirina, int visina) {
        for(int i = 1; i <= visina; ++i) {
            for(int j = 1; j <= sirina; ++j) {
                System.out.print(j % 10);
            }

            System.out.println();
        }

    }

    static void pravokotnik(int odmik, int sirina, int visina) {
        for(int x = 0; x < visina; ++x) {
            for(int i = 0; i < odmik; ++i) {
                System.out.print(" ");
            }

            for(int j = 1; j <= sirina; ++j) {
                System.out.print("x");
            }

            System.out.println();
        }

    }

    static void trikotnikStevilVrstice(int visina) {
        for(int i = 1; i <= visina; ++i) {
            for(int j = 0; j < i; ++j) {
                System.out.print(i);
            }

            System.out.println();
        }

    }

    static void trikotnikStevilStolpci(int visina) {
        for(int i = 1; i <= visina; ++i) {
            for(int j = 1; j <= i; ++j) {
                System.out.print(j);
            }

            System.out.println();
        }

    }

    static void trikotnikStevilVrsticeObrnjen(int visina) {
        for(int i = visina; i >= 0; --i) {
            for(int j = 0; j < i; ++j) {
                System.out.print(i);
            }

            System.out.println();
        }

    }

    static void trikotnikStevilStolpciObrnjen(int visina) {
        for(int i = visina; i >= 0; --i) {
            for(int j = 1; j <= i; ++j) {
                System.out.print(j);
            }

            System.out.println();
        }

    }

    static void trikotnikStevil(int visina) {
        for(int i = 1; i <= visina; ++i) {
            for(int j = 1; j < visina - i + 1; ++j) {
                System.out.print(" ");
            }

            for(int x = 1; x <= 2 * i - 1; ++x) {
                System.out.print(x);
            }

            System.out.println();
        }

    }

    static void trikotnik(int odmik, int visina) {
        for(int i = 1; i <= visina; ++i) {
            for(int j = 0; j < odmik + (visina - i); ++j) {
                System.out.print(" ");
            }

            for(int j = 0; j < 2 * i - 1; ++j) {
                System.out.print("*");
            }

            System.out.println();
        }

    }

    static void trikotnikObrnjen(int odmik, int visina) {
        for(int i = visina; i >= 0; --i) {
            for(int j = 0; j < odmik + (visina - i); ++j) {
                System.out.print(" ");
            }

            for(int j = 0; j < 2 * i - 1; ++j) {
                System.out.print("*");
            }

            System.out.println();
        }

    }

    static void romb(int odmik, int velikost) {
        trikotnik(odmik, velikost);
        trikotnikObrnjen(odmik + 1, velikost - 1);
    }
}
