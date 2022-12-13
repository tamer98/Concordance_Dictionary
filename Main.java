
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
    textArea.setFont(font);
    textArea.setForeground(Color.WHITE);
    textArea.setBackground(Color.BLUE);
    
    JScrollPane scrollPane = new JScrollPane(textArea);
	  
    frame.add(textArea);
    frame.add(scrollPane);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}
