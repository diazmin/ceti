// package filosofos;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class Main
{
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
            {
                Frame frame = new Frame();
                frame.setTitle("Filósofos");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            });
    }
}