package lab13.sort;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class LoginClient {
    public static void main(String[] args) {
        try {
            //1.建立客户端socket连接，指定服务器位置及端口
            Socket socket =new Socket("localhost",8800);
            //2.得到socket读写流
            OutputStream os=socket.getOutputStream();
            PrintWriter pw=new PrintWriter(os);
            //输入流
            InputStream is=socket.getInputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            //3.利用流按照一定的操作，对socket进行读写操作
//            String info="InsertionSort [ 3.0 , 2.0 , -1]";
//            String info="InsertionSort [ 3.0 , 2.0 ]";
            String info="InsertionSort [ 3.0 , 2.0 , 421341.0 , 32131.54,  535624131.31 , 53252343.3 , 5421414.4 ]";
//            String info="用户名：Tom,用户密码：123456";
//            Scanner scanner=
            pw.write(info);
            pw.flush();
            socket.shutdownOutput();
            //接收服务器的相应
            String reply=null;
            while(!((reply=br.readLine())==null)){
                System.out.println("接收服务器的信息："+reply);
            }
            //4.关闭资源
            br.close();
            is.close();
            pw.close();
            os.close();
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//————————————————
//版权声明：本文为CSDN博主「qq7342272」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/qq7342272/article/details/9698413