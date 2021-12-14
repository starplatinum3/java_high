package lab13;

import lab5book.MergeSort;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ClientCliSort {
  // IO streams
  DataOutputStream toServer = null;
  DataInputStream fromServer = null;

  void initUi(){

  }

  void readOne() throws IOException {
    Scanner scanner=new Scanner(System.in);
//    double radius = scanner.nextDouble();
    String cmd = scanner.next();

    List<Double>doubles1=new ArrayList<>();
    while (true){

//      int i = scanner.nextInt();
      double i = scanner.nextDouble();
      if(i==-1)break;
      doubles1.add( i);
    }
    double [] doubles=new double[doubles1.size()];
    int i=0;
    for (Double aDouble : doubles1) {
      doubles[i++]=aDouble;
    }

    String out="";
    out+=cmd+" ";
//    https://blog.csdn.net/xx326664162/article/details/51752701
//    if(cmd.equals("InsertionSort")){
//      InsertionSort.insertionSort(doubles);
//      out+="InsertionSort ";
//    }else if(cmd.equals("MergeSortSort")){
//      MergeSort.mergeSort(doubles);
//      out+="MergeSortSort ";
//    }
//    String out=""

    out+= Arrays.toString(doubles);

    System.out.println("out");
    System.out.println(out);


//    Exception in thread "main" java.net.SocketException: Software caused connection abort: socket write error

    double radius=0.1;
    // Send the radius to the server
//    toServer.writeDouble(radius);
//    toServer.writeChars(out);
    toServer.write(out.getBytes());
    toServer.flush();
    // Get area from the server
//    double area = fromServer.readDouble();
//
//    System.out.println("area");
//    System.out.println(area);


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
    String fromServerStr = fromServer.readUTF();
    System.out.println("fromServerStr");
    System.out.println(fromServerStr);

  }
  void init() throws IOException {

    try {
      // Create a socket to connect to the server
      int port=8001;
//      int port=8000;
      Socket socket = new Socket("localhost", port);
      // Socket socket = new Socket("130.254.204.36", 8000);
      // Socket socket = new Socket("drake.Armstrong.edu", 8000);

      System.out.println("port");
      System.out.println(port);
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
    ClientCliSort clientCli=new ClientCliSort();
    clientCli.init();
  }
}
