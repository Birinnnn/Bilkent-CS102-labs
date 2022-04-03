/**
 * Circle Class that has various functions.
 * And two variables radius and selected boolean.
 * Name: Anıl İlağa Date: 03.11.2021
 */
public class Circle extends Shape implements Selectable{
    private int radius;
    private boolean isSelected;

    /**
     * Constructor that takes a radius and sets it.
     * @param radius
     */
    public Circle( int radius ){
        this.radius = radius;
    }

    /**
     * Returns the radius of the circle
     * @return radius
     */
    @Override
    public double getArea() {
        return Math.PI*radius*radius;
    }

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
    public boolean contains(int x, int y) {
        int centerX = getX();
        int centerY = getY();

        if( Math.pow(radius,2) > (Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2))){
            return true;
        }
        return false;
    }

    /**
     * String representation of the circle.
     * True if selected, false if not.
     * @return out
     */
    public String toString(){
        String out = "Circle that is selected: ";
        out += getSelected() + " and radious: " + radius;

        return out;
    }
}
