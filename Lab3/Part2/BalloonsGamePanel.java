/**
 * BalloonGamePanel that creates a game panel and continues untill the user quits.
 * Name: Anıl İlağa Date: 03.11.2021
 */

import java.util.Random;
import shapes.ShapeContainer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BalloonsGamePanel extends JPanel {
    private ShapeContainer balloons;
    private Timer timer;
    private JLabel score;
    private int elapsedTime;
    private int points;
    private final int DELAY = 75;

    /**
     * Constructor that initializes the variables and creates 25 random balloons.
     */
    public BalloonsGamePanel(){
        balloons = new ShapeContainer();
        BalloonsListener listener = new BalloonsListener();
        TimerListener timerLis = new TimerListener();
        points = 0;
        elapsedTime = 0;
        addMouseListener( listener );
        score = new JLabel("Points: " + points);
        add( score );

        timer = new Timer(DELAY, timerLis);

        timer.start();


        for(int i = 0; i < 25; i++){
            Random r1 = new Random();
            Random r2 = new Random();
            int x = r1.nextInt(750);
            int y = r2.nextInt(550);
            Balloon b = new Balloon(x,y);
            balloons.add(b);
        }

        setBackground(Color.YELLOW);
        setPreferredSize( new Dimension(800,600));
    }

    /**
     * Restart method that is the copy of the constructor creates new game.
     */
    public void restart(){
        balloons = new ShapeContainer();
        BalloonsListener listener = new BalloonsListener();
        TimerListener timerLis = new TimerListener();
        points = 0;
        elapsedTime = 0;
        addMouseListener( listener );
        score.setText("Points: " + points );
        add( score );

        timer = new Timer(DELAY, timerLis);

        timer.start();


        for(int i = 0; i < 25; i++){
            Random r1 = new Random();
            Random r2 = new Random();
            int x = r1.nextInt(750);
            int y = r2.nextInt(550);
            Balloon b = new Balloon(x,y);
            balloons.add(b);
        }

        setBackground(Color.YELLOW);
        setPreferredSize( new Dimension(800,600));
    }

    /**
     * Draws all balloons according to draw function.
     * @param g
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.black);

        for( int i = 0; i< balloons.size(); i ++){
            if( balloons.getShapes()[i] != null) {
                ((Balloon)balloons.getShapes()[i]).draw(g);
            }
        }
    }

    /**
     * BalloonListener that gets x and y points of clicked point and removes the balloons if they are clicked.
     */
    private class BalloonsListener implements MouseListener {

        @Override
        public void mousePressed(MouseEvent e) {
            int test = 0;
            test = balloons.selectAllAt(e.getX(), e.getY());
            if( test > 1){
                points += test;
                score.setText("Points: " + points);
            }

            balloons.removeSelected();
            repaint();
        }

        @Override
        public void mouseClicked(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}
    }

    /**
     * TimerListener class that creates random balloons if there are less than 15 balloons.
     * And finishes the game after some time. Then asks the user to play again or quit.
     */
    private class TimerListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            for(int i = 0; i < balloons.size(); i++){
                ((Balloon)balloons.getShapes()[i]).grow();
            }
            balloons.removeSelected();

            if( balloons.size() <= 15 ){
                Random r1 = new Random();
                Random r2 = new Random();
                int x = r1.nextInt( 750 );
                int y = r2.nextInt( 550 );
                Balloon b = new Balloon( x,y );
                balloons.add( b );
            }
            elapsedTime ++;
            repaint();

            if( elapsedTime > 240 ){
                JOptionPane optionPane = new JOptionPane(this, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION,null,
                 new Object[] {}, null);
                timer.stop();
                int again = optionPane.showConfirmDialog(BalloonsGamePanel.this, "Play Again?", "Game Over", 0);
                if( again == 0){
                    restart();
                }
                else{
                    System.exit(0);
                }
            }
        }
    }
}
