
public class ShapeContainer {
    private Shape[] shapes;
    private int numOfShapes;

    public ShapeContainer(){
        Shape[] shapes = new Shape[100];
        numOfShapes = 0;
    }

    public void add( Shape s ){
        shapes[numOfShapes] = s;
        numOfShapes ++;
    }


    public double getArea(){
        double sum = 0;
        for( Shape s: shapes){
            sum += s.getArea();
        }
        return sum;
    }

    public String toString(){
        String out = "";
        for( Shape s : shapes){
            if( s != null){
                out += s +"\n";
            }
        }
        return out;
    }
}
