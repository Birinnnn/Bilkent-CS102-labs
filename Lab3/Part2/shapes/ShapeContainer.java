package shapes;
import java.util.Arrays;

public class ShapeContainer {
    private Shape[] shapes = new Shape[100];
    private int numOfShapes;
    private boolean isSelectable;

    public ShapeContainer(){
        numOfShapes = 0;
    }

    public void add( Shape s ){
        shapes[numOfShapes] = s;
        numOfShapes++;
    }

    public double getArea(){
        double sum = 0;
        for( Shape s: shapes){
            sum += s.getArea();
        }
        return sum;
    }

    public int size(){
        return numOfShapes;
    }

    public int selectAllAt( int x, int y){
        int total = 0;
        for( int i = 0; i < numOfShapes; i++) {
            if (shapes[i] != null) {

                Selectable selectable = (Selectable) shapes[i];
                if( selectable.contains( x,y ) != null) {
                    ((Selectable) shapes[i]).setSelected(true);
                    total++;

                }
            }
        }
        return total;
    }

    public void removeSelected(){
        int removed = 0;
        for( int i = 0; i < numOfShapes; i++){
            if( ((Selectable)shapes[i]).getSelected() ){
                shapes[i] = null;
                removed ++;
            }
        }

        for( int i = 0; i < numOfShapes; i++){
            if( shapes[i] == null){
                for( int j = i+1; j < numOfShapes; j++){
                    if( shapes[j] != null){
                        shapes[i] = shapes[j];
                        shapes[j] = null;
                        j = numOfShapes + 1;
                    }
                }
            }
        }
        numOfShapes = numOfShapes - removed;
    }

    public Shape[] getShapes() {
        return shapes;
    }

    public String toString(){
        String out = "";
        //Returns information about all of the shapes in the container
        //ToDo
        return out;
    }
}
