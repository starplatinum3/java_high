package lab13.login;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
 
public class LoginServer {
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
            }
            //给客户一个响应
            String reply = "welcome";
            pw.write(reply);
            pw.flush();
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