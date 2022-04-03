/**
 * Rectangle class that is a subclass of Shape class implements selectable.
 * Has 3 variables width,height and selected boolean.
 *
 * Name: Anıl İlağa Date: 03.11.2021
 */
package shapes;

public class Rectangle extends Shape implements Selectable{
    protected int width,height;
    protected boolean isSelected;

    /**
     * Constructor that sets the width and height.
     *
     * @param width
     * @param height
     */
    public Rectangle( int width, int height){
        this.width = width;
        this.height = height;
    }

    /**
     * Returns the coordinate of x.
     *
     * @return x
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     * Returns the coordinate of y.
     * @return y
     */
    @Override
    public int getY() {
        return y;
    }

    /**
     * Sets the x and y of the shape to given integers.
     * @param x
     * @param y
     */
    @Override
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns whether the shape is selected or not.
     * @return isSelected
     */
    @Override
    public boolean getSelected() {
        return isSelected;
    }

    /**
     * Sets the selected boolean to the given parameter b.
     * @param b
     */
    @Override
    public void setSelected(boolean b) {
        isSelected = b;
    }

    /**
     * Contains method that returns the shape if the coordinates are inside the shape.
     * Null if not.
     * @param x
     * @param y
     * @return Shape
     */
    @Override
    public Shape contains(int x, int y) {
        int leftX = getX();
        int topY = getY();

        if( x > leftX && leftX + width < x ){
            if( topY > y && y > topY - height){
                return this;
            }
        }
        return null;
    }

    /**
     * Calculates the area of the shape and returns the area.
     * @return Area
     */
    @Override
    public double getArea() {
        return width*height;
    }

    /**
     * String representation of the shape that returns it's selected type.
     * @return out
     */
    public String toString(){
        String out = "";
        out += getSelected();
        return out;
    }
}
