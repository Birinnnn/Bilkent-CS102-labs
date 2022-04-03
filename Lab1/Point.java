public class Point {

    //variables
    private double x;
    private double y;

    //constructor
    public Point(double xVal, double yVal){
        x = xVal;
        y = yVal;
    }

    //Setters and Getters
    /**
     * Sets the x point.
     *
     * @param xVal the double value to set
     */
    public void setX(double xVal) {
        x = xVal;
    }

    /**
     * Sets the y point.
     *
     * @param yVal the double value to set
     */
    public void setY(double yVal) {
        y = yVal;
    }

    /**
     * @return current x value of the point
     */
    public double getX(){
        return x;
    }

    /**
     * @return current y value of the point
     */
    public double getY(){
        return y;
    }

    public String toString(){ return( "x: " + x +" y: " + y ); }
}
