import javax.swing.*;

public class Lab03_Part2 {
    public static void main(String[] args){
        JFrame frame = new JFrame("Balloon Game");
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add( new BalloonsGamePanel());

        frame.pack();
        frame.setResizable( false );
        frame.setVisible(true);
    }
}