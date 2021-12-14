package lab13.sort;

import lab13.InsertionSort;
import lab5book.MergeSort;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LoginServer {
 static    String  parseArrStr(String  clientInputStr){
        String  arrStr="";
//          arrStr.substring(clientInputStr.length())
        if(clientInputStr.startsWith("InsertionSort ")){
            arrStr=clientInputStr.substring("InsertionSort ".length());
        }else if(clientInputStr.startsWith("MergeSortSort ")){
            arrStr=clientInputStr.substring("MergeSortSort ".length());
        }
        arrStr= arrStr.substring(1,arrStr.length()-1);
        String[] split = arrStr.split(",");
        System.out.println("split");
        System.out.println(Arrays.toString(split));
     List<Double> doubles = Arrays.stream(split).map(o -> {
         String trim = o.trim();

//         Double aDouble = Double.valueOf(trim);
         double v = Double.parseDouble(trim);
//         return Double.parseDouble(trim);
         return v;
     }).collect(Collectors.toList());

//     List<Double> doubles;
//     doubles
//     for (String s : split) {
//
//     }

     double [] doublesPrim=new double[doubles.size()];
     int i=0;
     for (Double aDouble : doubles) {
         doublesPrim[i++]=aDouble;
     }

     long useTime = 0;
     if(clientInputStr.startsWith("InsertionSort ")){
         long start = System.currentTimeMillis();
         InsertionSort.insertionSort(doublesPrim);
//         arrStr=clientInputStr.substring("InsertionSort ".length());
         long end = System.currentTimeMillis();
         useTime=end-start;
     }else if(clientInputStr.startsWith("MergeSortSort ")){
         long start = System.currentTimeMillis();
         MergeSort.mergeSort(doublesPrim);
         long end = System.currentTimeMillis();
         useTime=end-start;
//         arrStr=clientInputStr.substring("MergeSortSort ".length());
     }
//     doubles
//     InsertionSort.insertionSort(doublesPrim);
     String  reply="time : "+useTime+"ms "+ Arrays.toString(doublesPrim);
     return reply;

 }


    public static void main(String[] args) {
        try {
            //1.建立一个服务器Socket(ServerSocket)绑定指定端口
            ServerSocket serverSocket = new ServerSocket(8800);
            //2.使用accept()方法阻止等待监听，获得新连接
            Socket socket = serverSocket.accept();
            //3.获得输入流
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            //获得输出流
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            //4.读取用户输入信息
            String info = null;
            while (!((info = br.readLine()) == null)) {
                System.out.println("我是服务器，用户信息为：" + info);
                String reply = parseArrStr(info);
                pw.write(reply);
                pw.flush();
            }
            //给客户一个响应
//            String reply = "welcome";
//            pw.write(reply);
//            pw.flush();
            //5.关闭资源
            pw.close();
            os.close();
            br.close();
            is.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//————————————————
//版权声明：本文为CSDN博主「qq7342272」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/qq7342272/article/details/9698413