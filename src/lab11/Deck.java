package lab11;

import java.util.Random;

public class Deck {
    static String[] values = new String[]{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    static String[] suits = new String[]{"红桃", "黑桃", "方片", "梅花"};
    static int vl = values.length;
    static int sl = suits.length;
    static int dl = vl * sl;
    static String[] decks = new String[dl];

    public static String get(int s, int v) {
        return suits[s] + "-" + values[v];
    }

    public static void reset() {
        for (int i = 0, k = 0; i < vl; i++) {
            for (int j = 0; j < sl; j++) {
                decks[k++] = get(j, i);
            }
        }
    }

    public static void shuffle() {
        Random rdm = new Random();
        String s;
        for (int i = 0, j; i < dl; i++) {
            j = rdm.nextInt(dl);
            s = decks[j];
            decks[j] = decks[i];
            decks[i] = s;
        }
    }

    public static void drawCard(int i) {
        System.out.println(decks[i]);
    }

    public static void main(String[] args) {
        reset();
        for (int i = 0; i < dl; i++) {
            drawCard(i);
        }
        System.out.println("-------洗牌-------");
        shuffle();
        for (int i = 0; i < dl; i++) {
            drawCard(i);
        }
    }
}
    