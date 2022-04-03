import javax.swing.*;
import java.awt.*;

public class Calculator {
    public static void main( String[] args ){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        CalculatorPanel panel = new CalculatorPanel();

        frame.getContentPane().add( panel );
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
}
