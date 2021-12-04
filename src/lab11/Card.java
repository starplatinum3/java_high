package lab11;


import java.io.FileWriter;
import java.io.IOException;

public class Card {
    int num;
    int weight;
//    String[] color = {"", "黑桃", "红心", "梅花", "方块"};
    String[] color = { "黑桃", "红心", "梅花", "方块"};

    public String getName() {
//        13*5+2 )/13 ===5 ..2
//        (num/13)%4==1

//        if(num%53==0)return "小王";

        if(num%54==53)return "小王";
        if(num%54==0)return "大王";

        return getColor() + getNumber();

    }

    String getColor() {
        int code=(num-1)%54;
//        return color[((num-1) / 13) % 4];
        return color[(code/ 13) % 4];
//        return color[(num / 13) % 4];
    }

    String getNumber() {
        int code=num%54;
//        int code = num % 13;
        code%=13;
        if (code == 1) return "A";
        if (code == 11) return "J";
        if (code == 12) return "Q";
//        if (code == 13) return "K";
        if (code == 0) return "K";
        return code + "";
    }

    public static void main(String[] args) {
//
//        for (int i = 20; i < 40; i++) {
////            for (int i = 1; i < 11; i++) {
//            Card card = new Card(i,1);
//            String name = card.getName();
//            System.out.println("name");
//            System.out.println(name);
//        }
//
        StringBuilder csvStr= new StringBuilder();
//        for (int i=1;i<=13*4+2;i++){
        for (int i=1;i<=(13*4+2)*2;i++){
            Card card = new Card(i,1);
            String name = card.getName();
            csvStr.append(i).append(",").append(name).append("\n");
//            System.out.println("name");
//            System.out.println(name);
        }
        try(FileWriter fileWriter=new FileWriter("cards.csv")) {
            fileWriter.write(String.valueOf(csvStr));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String toString() {
        return "Card{" +
                "num=" + num +
                ", weight=" + weight +
                '}';
    }

    public Card(int num, int weight) {
        this.num = num;
        this.weight = weight;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
