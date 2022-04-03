/**
 * Balloon Class that extends Circle and has various functions like grow draw.
 * Name: Anıl İlağa Date: 03.11.2021
 */

import shapes.Circle;
import java.awt.*;

public class Balloon extends Circle implements Drawable {
    private int radius = 25;
    private final int INCREASE = 1;
    private final int MAX_RADIUS = 100;

    /**
     * Constructor that takes 2 parameters x,y coordinates and sets them.
     * @param x
     * @param y
     */
    public Balloon(int x, int y){
        super( 25 );
        setLocation(x, y);
    }

    /**
     * Draws an oval accordingly.
     * @param g
     */
    @Override
    public void draw(Graphics g) {
        g.drawOval(getX() - radius, getY() - radius, radius * 2,radius * 2);
    }

    /**
     * Lets the balloon grow according to some constants like INCREASE.
     * And blows when the radius becomes MAX_RADIUS.
     */
    public void grow(){
        radius = INCREASE + radius;
        super.setRadius( radius );
        if( radius == MAX_RADIUS){
            this.setSelected( true );
            this.radius = 0;
        }
    }

    /**
     * Returns radius of the circle
     * @return radius
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Set's the radius to the given parameter.
     * @param radius
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

}

/**
 * Drawable interface with draw function.
 */
interface Drawable {
    public void draw( Graphics g );
}
