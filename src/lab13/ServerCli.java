package lab13;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ServerCli  {

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
//        int port=8001;
        int port=8002;
//        int port=8000;
//        C:\Users\iot421>netstat -ano |findstr 8001
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("port");
        System.out.println(port);
//        Platform.runLater(() ->
//                ta.appendText("Server started at " + new Date() + '\n'));

        System.out.println("Server started at " + new Date() + '\n');
        // Listen for a connection request
        Socket socket = serverSocket.accept();

        // Create data input and output streams
        DataInputStream inputFromClient = new DataInputStream(
                socket.getInputStream());
        DataOutputStream outputToClient = new DataOutputStream(
                socket.getOutputStream());

        while (true) {
          // Receive radius from the client
          double radius = inputFromClient.readDouble();

          // Compute area
          double area = radius * radius * Math.PI;

          // Send area back to the client
          outputToClient.writeDouble(area);

          System.out.println("area");
          System.out.println(area);
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
    ServerCli serverCli=new  ServerCli();
//    launch(args);
    serverCli.init();
  }
}
