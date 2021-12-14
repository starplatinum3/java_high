package lab13;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientCli {
  // IO streams
  DataOutputStream toServer = null;
  DataInputStream fromServer = null;

  void initUi(){

  }

  void readOne() throws IOException {
    Scanner scanner=new Scanner(System.in);
    double radius = scanner.nextDouble();



    // Send the radius to the server
    toServer.writeDouble(radius);
    toServer.flush();
    // Get area from the server
    double area = fromServer.readDouble();

    System.out.println("area");
    System.out.println(area);


//    tf.setOnAction(e -> {
//      try {
//        // Get the radius from the text field
//        double radius = Double.parseDouble(tf.getText().trim());
//
//        // Send the radius to the server
//        toServer.writeDouble(radius);
//        toServer.flush();
//
//        // Get area from the server
//        double area = fromServer.readDouble();
//
//        // Display to the text area
//        ta.appendText("Radius is " + radius + "\n");
//        ta.appendText("Area received from the server is "
//          + area + '\n');
//      }
//      catch (IOException ex) {
//        System.err.println(ex);
//      }
//    });

  }
  void init() throws IOException {

    try {
      // Create a socket to connect to the server
//      int port=8001;
      int port=8002;
//      int port=8000;
      Socket socket = new Socket("localhost", port);
      // Socket socket = new Socket("130.254.204.36", 8000);
      // Socket socket = new Socket("drake.Armstrong.edu", 8000);

      // Create an input stream to receive data from the server
      fromServer = new DataInputStream(socket.getInputStream());

      // Create an output stream to send data to the server
      toServer = new DataOutputStream(socket.getOutputStream());
    }
    catch (IOException ex) {
      System.out.println(ex.toString());
//      ta.appendText(ex.toString() + '\n');
    }

    while (true){
      readOne();
    }


  }

//
//  @Override // Override the start method in the Application class
//  public void start(Stage primaryStage) throws IOException {
//    // Panel p to hold the label and text field
//    BorderPane paneForTextField = new BorderPane();
//    paneForTextField.setPadding(new Insets(5, 5, 5, 5));
//    paneForTextField.setStyle("-fx-border-color: green");
//    paneForTextField.setLeft(new Label("Enter a radius: "));
//
//    TextField tf = new TextField();
//    tf.setAlignment(Pos.BOTTOM_RIGHT);
//    paneForTextField.setCenter(tf);
//
//    BorderPane mainPane = new BorderPane();
//    // Text area to display contents
//    TextArea ta = new TextArea();
//    mainPane.setCenter(new ScrollPane(ta));
//    mainPane.setTop(paneForTextField);
//
//    // Create a scene and place it in the stage
//    Scene scene = new Scene(mainPane, 450, 200);
//    primaryStage.setTitle("Client"); // Set the stage title
//    primaryStage.setScene(scene); // Place the scene in the stage
//    primaryStage.show(); // Display the stage
//
//    Scanner scanner=new Scanner(System.in);
//    double radius = scanner.nextDouble();
//    // Send the radius to the server
//    toServer.writeDouble(radius);
//    toServer.flush();
//    // Get area from the server
//    double area = fromServer.readDouble();
//
//    System.out.println("area");
//    System.out.println(area);
//
//
////    tf.setOnAction(e -> {
////      try {
////        // Get the radius from the text field
////        double radius = Double.parseDouble(tf.getText().trim());
////
////        // Send the radius to the server
////        toServer.writeDouble(radius);
////        toServer.flush();
////
////        // Get area from the server
////        double area = fromServer.readDouble();
////
////        // Display to the text area
////        ta.appendText("Radius is " + radius + "\n");
////        ta.appendText("Area received from the server is "
////          + area + '\n');
////      }
////      catch (IOException ex) {
////        System.err.println(ex);
////      }
////    });
//
//    try {
//      // Create a socket to connect to the server
//      Socket socket = new Socket("localhost", 8000);
//      // Socket socket = new Socket("130.254.204.36", 8000);
//      // Socket socket = new Socket("drake.Armstrong.edu", 8000);
//
//      // Create an input stream to receive data from the server
//      fromServer = new DataInputStream(socket.getInputStream());
//
//      // Create an output stream to send data to the server
//      toServer = new DataOutputStream(socket.getOutputStream());
//    }
//    catch (IOException ex) {
//      ta.appendText(ex.toString() + '\n');
//    }
//  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) throws IOException {
//    launch(args);
    ClientCli clientCli=new ClientCli();
    clientCli.init();
  }
}
