public class DN04 {
    public static void main(String[] args) {
        String stevilo = args[0];
        String koncnaBeseda = "";

        for (int i = 0; i < stevilo.length(); i += 8) {
            String beseda = stevilo.substring(i, i + 8);
            int vrednost = Integer.parseInt(beseda, 2);
            koncnaBeseda += (char)vrednost;
        }
        System.out.println(koncnaBeseda);
    }
}