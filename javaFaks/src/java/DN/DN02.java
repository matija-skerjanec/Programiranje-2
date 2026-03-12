package DN;

public class DN02 {


    public static void main(String[] args) {
        if (args.length == 0) {
            return;
            }

            String besedilo = args[0];
            int dolzina = besedilo.length();
            int x = (int) Math.ceil(Math.sqrt(dolzina));
            int indeks = 0;

            for(int i = 0; i < x; i++){
                for(int b = 0; b < x; b++) {
                    if(indeks < dolzina){
                        System.out.print(besedilo.charAt(indeks));
                    }
                    else{
                        System.out.print(".");
                    }
                    indeks++;

                    if (b < x-1 ){
                        System.out.print(" ");
                    }
                }
                System.out.println();
             }
        }




    }


