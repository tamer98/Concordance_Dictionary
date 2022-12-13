
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Main {
  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder();

    try (BufferedReader br = new BufferedReader(new FileReader("/Users/TamerAltaji/Desktop/Java-Workplace/DataStructureProject/src/output"))) {
      String line;
      while ((line = br.readLine()) != null) {
        sb.append(line);
        sb.append(System.lineSeparator());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    Font font = new Font("Segoe Script", Font.BOLD, 20);
    
    JFrame frame = new JFrame();
    frame.setSize(800,800);
    JTextArea textArea = new JTextArea(sb.toString());
    frame.add(textArea);
    
    textArea.setFont(font);
    textArea.setForeground(Color.WHITE);
    textArea.setBackground(Color.BLUE);
    //frame.pack();
    
    JScrollPane scrollPane = new JScrollPane(textArea);
    frame.add(scrollPane);
    
	frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}


//import java.awt.Dimension;
//import javax.swing.JFrame;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
//
//public class Main {
//  public static void main(String[] args) {
//    JFrame frame = new JFrame();
//    JTextArea textArea = new JTextArea("This is a long string that will require scrolling.");
//    JScrollPane scrollPane = new JScrollPane(textArea);
//
//    scrollPane.setPreferredSize(new Dimension(200, 100));
//    frame.add(scrollPane);
//    frame.pack();
//    frame.setVisible(true);
//  }
//}




//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.control.Label;
//import javafx.scene.layout.StackPane;
//import javafx.stage.Stage;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//
//public class Output extends Application {
//  public static void main(String[] args) {
//    launch(args);
//  }
//
//  @Override
//  public void start(Stage primaryStage) {
//    // Read the contents of the file
//    StringBuilder fileContents = new StringBuilder();
//    try (BufferedReader reader = new BufferedReader(new FileReader("output.txt"))) {
//      String line;
//      while ((line = reader.readLine()) != null) {
//        fileContents.append(line).append("\n");
//      }
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//
//    // Create a label to display the file contents
//    Label label = new Label(fileContents.toString());
//
//    // Create a StackPane to hold the label
//    StackPane root = new StackPane(label);
//
//    // Create a Scene to hold the StackPane
//    Scene scene = new Scene(root, 800, 600);
//
//    // Set the title of the window and show it
//    primaryStage.setTitle("File Display");
//    primaryStage.setScene(scene);
//    primaryStage.show();
//  }
//}
