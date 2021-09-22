import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortUitls {

    public static <T> void sort(T[] array) {

    }

    //    https://blog.csdn.net/weixin_41438466/article/details/107770273
    public static void sort(List<Person> list) {
//        list.sort(Comparator.comparing(Person::getId));
        list.sort(Comparator.comparing(Person::getId).reversed());
    }

    public static void bubbleSort(List<Person> list) {
//        for (int i = 0; i <list.size() ; i++) {
//
//        }
//
        for (int i = 0; i < list.size() - 1; i++) {
            //第i趟比较
            for (int j = 0; j < list.size() - i - 1; j++) {
                //开始进行比较，如果arr[j]比arr[j+1]的值大，那就交换位置
//                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                if (list.get(j).compareTo(list.get(j + 1)) <0) {
//                    int temp=list[j];
//                    list[j]=list[j+1];
//                    list[j+1]=temp;

                    Person temp = list.get(j);
                    list.set(j, list.get(j + 1));
//                    .=list.get(j+1);
//                    list[j + 1] = temp;
                    list.set(j + 1, temp);
                }
            }

        }
//        list.sort(Comparator.comparing(Person::getId));
    }


    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
//        要当作 person
        for (int i = 0; i < 20; i++) {
            list.add(new Student("" + i, "" + i));
        }
//        sort(list);
        bubbleSort(list);
        System.out.println("students");
        System.out.println(list);
        List<Person> teachers = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            teachers.add(new Teacher("" + i, "" + i));
        }
//        sort(teachers);
        bubbleSort(teachers);

        System.out.println("teachers");
        System.out.println(teachers);
    }
}
