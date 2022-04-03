import java.lang.Math;
public class Circle {

    //variables
    private Point center;
    private double radius;

    //constructor
    public Circle( Point center, double radius ){
        this.center = center;
        this.radius = radius;
    }

    //Setters and Getters
    /**
     * @return Center point of the circle.
     */
    public Point getCenter(){ return center; }

    /**
     * @return Radius of the circle.
     */
    public double getRadius(){ return radius; }

    /**
     * Sets the radius.
     *
     * @param r the double value to set.
     */
    public void setRadius(double r){ radius = r; }

    /**
     * Sets the center point.
     *
     * @param p the point to set.
     */
    public void setCenter(Point p){ center = p; }

    //Methods
    /**
     * This method checks whether a point is inside the circle or not.
     *
     * @param  point that user wants to check.
     * @return true if the point is inside the circle false if not.
     */
    public boolean contains( Point point ){
        boolean check;
        check = Math.pow((point.getX() - center.getX()), 2) +
                Math.pow((point.getY() - center.getY()) ,2) < Math.pow(radius, 2);

        if( check ){
            return true;
        }
        return false;
    }

    public String toString(){
        String out = "A circle with radius: " + radius + " and center point: " + center;
        return out;
    }
}
