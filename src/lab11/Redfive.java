package lab11;


import java.util.*;

public class Redfive {

    void  pushKTo4(int row, List<Integer>  order){
//        for (int i = 12; i >=4 ; i--) {
        for (int i = 13; i >=4 ; i--) {
//            if(row*13+i==96){
//                System.out.println("find 96");
//            }
            int cardNum= row*13+i;
            if(cardNum==18){
                continue;
            }
//            order.add(row*13+i);
            order.add(cardNum);
        }
    }

    List<Integer>  orderPush(){
        List<Integer> order= new ArrayList<>();
        order.add(13*1+5); //红心5
        order.add(13*4 +2); //大王
        order.add(13*4 +1);
//        红心3, 是没有 设置order
        order.add(3); // 黑桃三
//        order.add(13*3+3); //梅花三
        order.add(13*2+3); //梅花三
        order.add(2 ); //黑桃2
        order.add(13*1+2 );  //其他2
        order.add(13*2+2 );
        order.add(13*3+2 );
//        没有3
        for(int i=0;i<4;i++){
            order.add(i*13+1);
//            1
//            push12To4(i,order);
            pushKTo4(i,order);
            if(i==1){
                order.add(i*13+3);
            }
        }
        order.add(42);
//        42 方块3 不存在
        return  order;
//
//        int[] order=new int[13*4+2+10];

    }

    int[] setWeight(  List<Integer> order){
        List<Card>cards=new ArrayList<>();
        int[] weights=new int[(13*4+2)*2+7];
//        weights 的idx 就是他的 牌的号码
//        order 里面的才是 weight 吧
//        for (int i = 1; i <=(13*4+2)*2 ; i++) {
//            weights[i]=i;
//            cards.add(new Card(i,i));
//        }
//        order 第一个 就是 权重 1的
//        System.out.println("order");
//        System.out.println(order);
        int weight=1;
        for (Integer num : order) {
//            num 是牌的 num
//            weights[num]=weight++;
//            System.out.println("weight");
//            System.out.println(weight);

//            if(weight==1){
//                System.out.println("num");
//                System.out.println(num);
//                System.out.println("num+13*4+2");
//                System.out.println(num+13*4+2);
//            }
//            if(num==18){
//                System.out.println("num==18");
//                System.out.println("weight");
//                System.out.println(weight);
//            }

            weights[num]=weight;
            weights[num+13*4+2]=weight;
//            1+54
//            System.out.println("num+13*4+2");
//            System.out.println(num+13*4+2);
//            不存在 42 吗
//            3*13+ 3
            if(num+13*4+2==96){
                System.out.println("find 96");
            }
//            cards.add(new Card(num,weight));
////            两副牌
//            cards.add(new Card(num+13*4+2,weight));
            weight++;
        }
        System.out.println("weights[18]");
        System.out.println(weights[18]);
        System.out.println("weights");
        System.out.println(Arrays.toString(weights));
        return weights;

    }

//    List<Card> setWeight(  List<Integer> order){
//        List<Card>cards=new ArrayList<>();
//        int[] weights=new int[(13*4+2)*2+7];
////        weights 的idx 就是他的 牌的号码
////        order 里面的才是 weight 吧
////        for (int i = 1; i <=(13*4+2)*2 ; i++) {
////            weights[i]=i;
////            cards.add(new Card(i,i));
////        }
////        order 第一个 就是 权重 1的
//        int weight=1;
//        for (Integer num : order) {
////            num 是牌的 num
////            weights[num]=weight++;
//            weights[num]=weight;
//            cards.add(new Card(num,weight));
////            两副牌
//            cards.add(new Card(num+13*4+2,weight));
//            weight++;
//        }
//        return cards;
//
//    }

    String []color={"黑桃","红心","梅花","方块"};
//    List<Card>cards,
//List<Integer> order,
  public static   List<Card> printCards(   int[] weights, Integer[] person){
        List<Card>cards=new ArrayList<>();
//        int[] person;
//        List<Card>cards=new ArrayList<>();
//        int[] weights=new int[(13*4+2)*2+7];
//        weights 的idx 就是他的 牌的号码
//        for (Card card : cards) {
//
//        }
//        System.out.println("weights");
//        System.out.println(Arrays.toString(weights));
        for (int cardNum : person) {
            cards.add(new Card(cardNum,weights[cardNum]));
//            weights[cardNum];
        }
//        System.out.println("cards");
//        System.out.println(cards);
        cards.sort((o1,o2)->{
            return o1.weight-o2.weight;
        });
//        13*2==26

        System.out.println("cards");
        System.out.println(cards);

        for (Card card : cards) {
            System.out.print(card.getName()+",");
        }
//        Card{num=53, weight=3},
        System.out.println();
//        order 里面的才是 weight 吧
//        for (int i = 1; i <=(13*4+2)*2 ; i++) {
//            weights[i]=i;
//            cards.add(new Card(i,i));
//        }
//        order 第一个 就是 权重 1的
//        int weight=1;
//        for (Integer num : order) {
////            num 是牌的 num
////            weights[num]=weight++;
//            cards.add(new Card(num,weight));
////            两副牌
//            cards.add(new Card(num+13*4+2,weight));
//        }
        return cards;

    }


    boolean [] getOneCard(int i,int j, Integer[][] persons,
                    ArrayList<Integer> cards,boolean []taken){

        while (true){
            int index = (int) (Math.random() * (cards.size()));
            if(!taken[index]){
                taken[index]=true;
                persons[i][j] = cards.get(index);
                break;
            }

        }
        return taken;

    }

    Integer[][]  genCards(){
        ArrayList<Integer> cards = new ArrayList<>(108);
        boolean []taken=new boolean[108+8];
        for (int i = 1; i <= 108; i++) {
            cards.add(i);
            taken[i]=false;
        }
//        为什么要多线程 发牌不是一个一个发吗
        Integer[][] persons = new Integer[4][25];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 25; j++) {
//                1... 13
//                13*4+2
//                52+2  54
//                108 ... 100
//                100==4*25
//                3）系统能随机洗牌后模拟真实情况分别向4个玩家发牌，并剩下8张底牌
//                boolean[] taken = getOneCard(i, j, persons, cards, taken);
                taken=   getOneCard(i, j, persons, cards, taken);
//                int index = (int) (Math.random() * (cards.size()));
////                但是随机会随机到已经拿过的吧 而且size 不断在变小？
//                persons[i][j] = cards.get(index);
//                cards.remove(index);
            }
        }
        return persons;
    }


    public static void main(String[] args) {
//        Card{num=53, weight=3},
//        System.out.println("53/13");
//        System.out.println(53/13);
//        System.out.println("53%13");
//        System.out.println(53%13);
//        53/13
//        4
//        53%13
//        1
//        是 A 啊

//        System.out.println("61/13");
//        System.out.println(61/13);
//        System.out.println("61%13");
//        System.out.println(61%13);
//        61/13
//        4
//        61%13
//        9

//        文档：我的牌是梅花3 ,方块A ,红心K ,红心10 ...
//        链接：http://note.youdao.com/noteshare?id=431dbe6addb635c0dce6416d07b85677&sub=E4021010A5DA4E3D8D16C67575182CDE
        Redfive redfive = new Redfive();
        Integer[][] persons = redfive.genCards();
        List<Integer> order = redfive.orderPush();
//        System.out.println("order");
//        System.out.println(order);
        int[] weights = redfive.setWeight(order);
//        System.out.println("weights");
//        System.out.println(Arrays.toString(weights));
        int personIdx=0;
        for (Integer[] person : persons) {
//            System.out.println("person"+personIdx);
//            List<Card> cards = redfive.printCards(weights, person);

//            List<Card> cards = Redfive.printCards(weights, person);
//            System.out.println(cards);
//            线程的话 他必然是 混乱的输出啊
            Shower shower = new Shower();
            shower.setPerson(person);
            shower.setWeights(weights);
            shower.setPersonNum(personIdx);
//            shower.r
//            shower.run();
            new Thread(shower).start();
//            https://www.cnblogs.com/202116xi/p/14478960.html
            personIdx++;
//            List<Card> cards =
//                    System.out.println(cards);
        }


    }


}
