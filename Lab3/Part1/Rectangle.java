public class Rectangle extends Shape implements Selectable{
    protected int width,height;
    protected boolean isSelected;

    public Rectangle( int width, int height){
        this.width = width;
        this.height = height;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean getSelected() {
        return isSelected;
    }

    @Override
    public void setSelected(boolean b) {
        isSelected = b;
    }

    @Override
    public boolean contains(int x, int y) {
        int leftX = getX();
        int topY = getY();

        if( x > leftX && leftX + width < x ){
            if( topY > y && y > topY - height){
                return true;
            }
        }
        return false;
    }

    @Override
    public double getArea() {
        return width*height;
    }

    public String toString(){
        String out = "Rectangle with sides( w / h ): " + width + " / " + height;
        out += " and it is selected: " + getSelected();
        return out;
    }
}
