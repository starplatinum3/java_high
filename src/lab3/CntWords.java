package lab3;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class CntWords {

    public static void main(String[] args) {
//        File file = new File();
       Set<String > set=new TreeSet<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            if(line.equals("****")){
                break;
            }
            String[] splits = line.split(" ");
            set.addAll(Arrays.asList(splits));
        }
        set.remove("");
        System.out.println("set");
        System.out.println(set);

    }
}


//    dgaudia  daiodha  diuahdi  guahdio  cat  dog  pig
//        ****
//        set
//        [cat, daiodha, dgaudia, diuahdi, dog, guahdio, pig]