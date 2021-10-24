package lab5book;

//import zucc.kinect.entity.RedPackage;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RedPackageUtil {

    public  static  int[] genLst(int size) {
        int[] list = new int[size];
        for (int i = 0; i < size; i++) {
            list[i] = (int) RedPackageUtil.random(-999999999, 999999999);
        }
        return list;
    }



    /**
     * @param allMoney 总金额
     * @param count    总条数
     * @param min      最小额
     * @param max      最大额
     * @return
     */

    public static List<Integer> randomAssign(int allMoney, int count, int min, int max) {
        List<Integer> list = new ArrayList<>();
//        钱 要全部分完吗
        if (allMoney < min * count || allMoney > max * count) {
            throw new RuntimeException("不可拆分");
        }
        int money = allMoney - count * min;//剩余可支配金额
        for (int i = 0; i < count; i++) {
            int one = random(money, count - i, min, max);//随机金额
            list.add(min + one);
            money = money - one;//剩余金额
        }
        Collections.shuffle(list);//随机打乱
        return list;
    }

    /**
     * @param money 剩余分配的金额
     * @param count 剩余份数
     * @return
     */
    public static Integer random(int money, int count, int min, int max) {
        if (count == 1) {//最后一份
            return money;
        }
        //可能存在的最小值
        int m = money - (max - min) * (count - 1);//假如其他都是最大值  若m>0  则随机值不能小于m,及最小值是m,最大值不能大于max-min
        int n = 0;//随机值
        if (m > 0) {// m至max-min之间
            n = max - min - m + 1;
        } else {
            if (money > max - min) {//0至 max-min之间
                m = 0;
                n = max - min + 1;
            } else { //0至money之间
                m = 0;
                n = money + 1;
            }
        }
        return new Random().nextInt(n) + m;
    }



    public static double random(double low, double up) {
        Random random1 = new Random();
        return random(random1, low, up);
//        return (up - low) * r.nextDouble() + x
    }

    /**
     * [ low, up)
     *
     * @param random
     * @param low
     * @param up
     * @return
     */
    public static double random(Random random, double low, double up) {
        return (up - low) * random.nextDouble() + low;
    }

    static void testRandom() {
        for (int i = 0; i < 10; i++) {
            int random = (int)random(new Random(), 30, 40);
            System.out.println(random);
        }
    }

//    public  static int random(Random random, int low, int up) {
//        return (up - low) * random.nextInt() + low;
//    }

//    int 的有问题啊
//    public  static int random( int low, int up) {
//        Random random1 = new Random();
//        return (up - low) * random1.nextInt() + low;
//    }

    void test2() {
        // remainSize 剩余的红包数量
        // remainMoney 剩余的钱
//        private int remainSize;
//        private BigDecimal remainMoney;

//        1000 元
//        BigDecimal bigDecimal = new BigDecimal(1000);
//        RedPackage redPackage = new RedPackage(1000, bigDecimal);
//
//        for (int i = 0; i < 10; i++) {
//            BigDecimal randomMoney = getRandomMoney(redPackage);
//            System.out.println("randomMoney");
//            System.out.println(randomMoney);
////
////            randomMoney
////            370173627.00
////            randomMoney
////            283884614998592.51
////            randomMoney
////            0.01000000000000000020816681711721685132943093776702880859375
////            randomMoney
////            0.01000000000000000020816681711721685132943093776702880859375
////            randomMoney
////            95100379526383830990.72
////            randomMoney
////            0.01000000000000000020816681711721685132943093776702880859375
////            randomMoney
////            258495753840484493134885.30
////            randomMoney
////            10808475459605407904236164223.62
////            randomMoney
////            0.01000000000000000020816681711721685132943093776702880859375
////            randomMoney
////            3398611739524905658885334811609435.02
//
//        }

//        for (int i = 5; i >0 ; i--) {
//            Integer integer=   random(1000,i,1,100);
//            System.out.println("integer");
//            System.out.println(integer);
//        }

//        Integer integer = random(1000, 5, 1, 100);
//        System.out.println("integer");
//        System.out.println(integer);

//        先判断 钱还够不够最大的那个，不够就不发了
//        够的话 就来个 最大和最小之间的随机数
//        300 * 5 >1000 才可以
//        Random random = new Random();
//        random.nextInt(100);
//        [0,100)
//        1+[0,100)


//        for (int i = 0; i < 10; i++) {
//            List<Integer> list = randomAssign(1000, 5, 1, 300);
////        [200, 200, 200, 200, 200]
//
//            System.out.println(list);
//        }


//        平分 的
//        [200, 200, 200, 200, 200]
//[200, 200, 200, 200, 200]
//[200, 200, 200, 200, 200]
//[200, 200, 200, 200, 200]
//[200, 200, 200, 200, 200]
//[200, 200, 200, 200, 200]
//[200, 200, 200, 200, 200]
//[200, 200, 200, 200, 200]
//[200, 200, 200, 200, 200]
//[200, 200, 200, 200, 200]

//
//        [266, 278, 187, 1, 268]
//[286, 66, 297, 56, 295]
//[262, 300, 285, 101, 52]
//[174, 118, 295, 282, 131]
//[151, 262, 280, 297, 10]
//[108, 39, 297, 274, 282]
//[143, 276, 212, 91, 278]
//[223, 296, 70, 145, 266]
//[292, 281, 91, 121, 215]
//[208, 197, 166, 213, 216]

//        for (int i = 0; i <10 ; i++) {
//            System.out.println(random(1,100));
//        }

    }

    void test3() {
        Random random1 = new Random();
        for (int i = 0; i < 10; i++) {
            int random = (int) random(random1, 1, 100);
            System.out.println(random);
//            System.out.println(random(1,100));
        }

//        38
//        36
//        39
//        39
//        39
//        30
//        33
//        34
//        30
//        36

    }

    public static void main(String[] args) {
        testRandom();

    }
}
