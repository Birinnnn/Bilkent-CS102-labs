public class ShapeTester {
    public static void main (String[] args){
        ShapeContainer container = new ShapeContainer();
        Rectangle r1 = new Rectangle( 3,5);
        Rectangle r2 = new Rectangle( 5, 8);
        Square s1 = new Square( 2);
        Circle c1 = new Circle( 5);
        container.add( r1 );
        container.add( r2 );
        container.add( s1 );
        container.add( c1 );
    }
}
