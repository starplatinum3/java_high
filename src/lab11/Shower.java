package lab11;

import java.util.Arrays;
import java.util.Comparator;

public class Shower implements Runnable {
    Integer person[];
//两副牌
//    https://jingyan.baidu.com/article/425e69e69ee6f8be14fc1660.html
    @Override
    public void run() {

        System.out.println("personNum");
        System.out.println(personNum);
        Redfive.printCards(weights, person);


    }

    int []weights;

    public Integer[] getPerson() {
        return person;
    }

    public void setPerson(Integer[] person) {
        this.person = person;
    }

    public int[] getWeights() {
        return weights;
    }

    public void setWeights(int[] weights) {
        this.weights = weights;
    }

    public Shower(Integer[] p) {
        this.person = p;
    }

    public Shower() {
    }

    int personNum;

    public int getPersonNum() {
        return personNum;
    }

    public void setPersonNum(int personNum) {
        this.personNum = personNum;
    }
}
