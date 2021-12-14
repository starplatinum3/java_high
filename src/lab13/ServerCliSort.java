package lab13;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Date;

public class ServerCliSort {


  void parseArrStr(String  clientInputStr){
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

  }
  void init(){
    // Text area for displaying contents
//    TextArea ta = new TextArea();

    // Create a scene and place it in the stage
//    Scene scene = new Scene(new ScrollPane(ta), 450, 200);
//    primaryStage.setTitle("Server"); // Set the stage title
//    primaryStage.setScene(scene); // Place the scene in the stage
//    primaryStage.show(); // Display the stage

    new Thread( () -> {
      try {
        // Create a server socket
        int port=8001;
//        int port=8000;
//        C:\Users\iot421>netstat -ano |findstr 8001
        ServerSocket serverSocket = new ServerSocket(port);
//        Platform.runLater(() ->
//                ta.appendText("Server started at " + new Date() + '\n'));

        System.out.println("Server started at " + new Date() + '\n');
        System.out.println("port: "+port);
        // Listen for a connection request
        Socket socket = serverSocket.accept();
//        Socket read string

        // Create data input and output streams
        DataInputStream inputFromClient = new DataInputStream(
                socket.getInputStream());
        DataOutputStream outputToClient = new DataOutputStream(
                socket.getOutputStream());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputFromClient));

        while (true) {
//          String clientInputStr = inputFromClient.readUTF();
//          readUTF 读不到 chars 吗
          String clientInputStr = bufferedReader.readLine();
//          double radius= inputFromClient.readDouble();
//          System.out.println("radius");
//          System.out.println(radius);

          // Receive radius from the client
//          double radius = inputFromClient.readDouble();
//
//          // Compute area
//          double area = radius * radius * Math.PI;

          // Send area back to the client
//          outputToClient.writeDouble(area);

//          String  arrStr="";
////          arrStr.substring(clientInputStr.length())
//          if(clientInputStr.startsWith("InsertionSort ")){
//            arrStr=clientInputStr.substring("InsertionSort ".length());
//          }else if(clientInputStr.startsWith("MergeSortSort ")){
//            arrStr=clientInputStr.substring("MergeSortSort ".length());
//          }
//          arrStr= arrStr.substring(1,arrStr.length()-1);


          System.out.println("clientInputStr");
          System.out.println(clientInputStr);
          parseArrStr(clientInputStr);
//          System.out.println("area");
//          System.out.println(area);

          outputToClient.writeChars("ok");

//
//          Platform.runLater(() -> {
//            ta.appendText("Radius received from client: "
//              + radius + '\n');
//            ta.appendText("Area is: " + area + '\n');
//          });
        }
      }
      catch(IOException ex) {
        ex.printStackTrace();
      }
    }).start();
  }

//
//  @Override // Override the start method in the Application class
//  public void start(Stage primaryStage) {
//    // Text area for displaying contents
//    TextArea ta = new TextArea();
//
//    // Create a scene and place it in the stage
//    Scene scene = new Scene(new ScrollPane(ta), 450, 200);
//    primaryStage.setTitle("Server"); // Set the stage title
//    primaryStage.setScene(scene); // Place the scene in the stage
//    primaryStage.show(); // Display the stage
//
//    new Thread( () -> {
//      try {
//        // Create a server socket
//        ServerSocket serverSocket = new ServerSocket(8000);
//        Platform.runLater(() ->
//          ta.appendText("Server started at " + new Date() + '\n'));
//
//        // Listen for a connection request
//        Socket socket = serverSocket.accept();
//
//        // Create data input and output streams
//        DataInputStream inputFromClient = new DataInputStream(
//          socket.getInputStream());
//        DataOutputStream outputToClient = new DataOutputStream(
//          socket.getOutputStream());
//
//        while (true) {
//          // Receive radius from the client
//          double radius = inputFromClient.readDouble();
//
//          // Compute area
//          double area = radius * radius * Math.PI;
//
//          // Send area back to the client
//          outputToClient.writeDouble(area);
//
//          System.out.println("area");
//          System.out.println(area);
////
////          Platform.runLater(() -> {
////            ta.appendText("Radius received from client: "
////              + radius + '\n');
////            ta.appendText("Area is: " + area + '\n');
////          });
//        }
//      }
//      catch(IOException ex) {
//        ex.printStackTrace();
//      }
//    }).start();
//  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    ServerCliSort serverCli=new ServerCliSort();
//    launch(args);
    serverCli.init();
  }
}
