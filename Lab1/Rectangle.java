public class Rectangle {
    //variables
    private Point corner;
    private double width;
    private double height;

    //constructor
    public Rectangle(Point c, double width, double height){
        corner = c;
        this.width = width;
        this.height = height;
    }

    /**
     * Sets the x point.
     *
     * @param xVal the double value to set
     */
    public void setCorner(Point c){ corner = c; }

    /**
     * Sets the height of the rectangle.
     *
     * @param h the double value to set
     */
    public void setHeight(double h){ height = h; }

    /**
     * Sets the width of the rectangle.
     *
     * @param w the double value to set
     */
    public void setWidth(double w){ width = w; }

    /**
     * @return Bottom left corner coordinates of the rectangle.
     */
    public Point getCorner(){ return corner; }

    /**
     * @return width of the rectangle.
     */
    public double getWidth(){ return width; }

    /**
     * @return heigth of the rectangle.
     */
    public double getHeight(){ return height; }

    //Methods
    /**
     * This method checks whether a point is inside the rectangle or not.
     *
     * @param  point that user wants to check.
     * @return true if the point is inside the rectangle false if not.
     */
    public boolean contains(Point point){
        double pointX = point.getX();
        double pointY = point.getY();
        double cornerX = corner.getX();
        double cornerY = corner.getY();

        if( cornerX >= pointX || cornerX + width <= pointX ){ return false; }
        else if( cornerY >= pointY || cornerY + height <= pointY){ return false; }
        else{ return true; }
    }

    /**
     * This method generates a random point inside the rectangle.
     *
     * @return generated point which is inside the rectangle.
     */
    public Point getRandomPoint(){
        double ranX;
        double ranY;
        Point p = new Point( 0,0);
        boolean valid = false;

        while( !valid ){
            ranX = (Math.random() * (width)) + corner.getX();
            ranY = (Math.random() * (height)) + corner.getY();
            p.setX(ranX);
            p.setY(ranY);
            if ( this.contains( p )){
                valid = true;
                return p;
            }
        }
        return null;
    }

    public String toString(){
        String out = "Rectangle with left bottom corner: " + corner +
                     " width:" + width + " and height: " + height ;
        return out;
    }
}
