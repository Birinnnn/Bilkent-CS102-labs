public class Square extends Rectangle{
    private int side;

    public Square( int side ){
        super (side,side);
        this.side = side;
    }

    public String toString() {
        String description = "Square with length: " + side;
        return description;
    }
}
