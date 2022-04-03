/**
 * Circle Class that has various functions.
 * And two variables radius and selected boolean.
 * Name: Anıl İlağa Date: 03.11.2021
 */
package shapes;

public class Circle extends Shape implements Selectable{
    private int radius;
    private boolean isSelected;

    /**
     * Constructor that takes a radius and sets it.
     * @param radius
     */
    public Circle( int radius ){
        this.radius = radius;
        isSelected = false;
    }

    /**
     * Returns the radius of the circle
     * @return radius
     */
    public int getRadius() { return radius; }

    /**
     * Sets the radius of the circle
     * @param radius
     */
    public void setRadius(int radius) { this.radius = radius; }

    /**
     * Calculates the area of the circle and returns.
     * @return Area
     */
    @Override
    public double getArea() { return Math.PI*radius*radius; }

    /**
     * Returns the x coordinates of the center point.
     * @return x
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     * Returns the y coordinates of the center point.
     * @return y
     */
    @Override
    public int getY() {
        return y;
    }

    /**
     * Sets the x and y coordinate of the circle.
     * @param x
     * @param y
     */
    @Override
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns true if the circle is selected false if not.
     * @return selected
     */
    @Override
    public boolean getSelected() {
        return isSelected;
    }

    /**
     * Sets the selected type of the circle.
     * @param b
     */
    @Override
    public void setSelected(boolean b) {
        isSelected = b;
    }

    /**
     * Takes 2 parameters x and y coordinates and returns the shape if points are inside the circle.
     * Returns true if the point is inside.
     * False if not
     *
     * @param x
     * @param y
     * @return
     */
    @Override
    public Shape contains(int x, int y) {

        if( Math.pow(radius,2) >= (Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2))){
            return this;
        }
        return null;
    }

    /**
     * String representation of the circle.
     * True if selected, false if not.
     * @return out
     */
    public String toString(){
        String out = "";
        out += getSelected();
        return out;
    }

}

/**
 * Selectable Interface that has 3 functions.
 */
interface Selectable {
    public boolean getSelected();
    public void setSelected(boolean b);
    public Shape contains(int x, int y);
}
