public class Main {
    public static void main( String[] args){

        char array[][] = createArray(97,97);
        printArray( array );
        System.out.println();
        drawFigure(array,0,0,97);
        printArray(array);
    }

    public static char[][] createArray(int row, int column){
        char[][] array = new char[row][column];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (i == 0 || i == array.length - 1) {
                    array[i][j]= '#';
                }
                else if( j == 0 || j == array[0].length-1){
                    array[i][j] = '#';
                }
                else{
                    array[i][j] = ' ';
                }
            }
        }
        return array;
    }

    public static void printArray(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }

    }
    public static void fillBox(char[][] array, int row, int column, char ch){
        if((row > 0 && row < array.length) && (column > 0 && column < array[0].length)) {
            if(array[row][column] != '#' && array[row][column] != ch) {
                array[row][column] = ch;
                if (row + 1 < array.length) {
                    fillBox(array, row+1, column, ch);
                }
                if (column + 1 < array[0].length) {
                    fillBox(array, row, column+1, ch);
                }
                if (column - 1 > 0) {
                    fillBox(array, row, column-1, ch);
                }
                if (row - 1 > 0) {
                    fillBox(array, row-1, column, ch);
                }
            }
        }
    }

    public static void drawFigure( char[][] square, int x, int y, int size ){
        if( size < 7 ){
            fillBox( square, x+1,y+1, '*');
        }
        else{
            for( int i = 0; i < size; i++){
                for( int j = 0; j < size;j++){
                    if( i == size/2){
                        square[i+x][j+y] = '#';
                    }
                    else if( j == size/2){
                        square[i+x][j+y] = '#';
                    }
                }
            }
            drawFigure(square,x,y,size/2);
            drawFigure(square,x+size/2,y+size/2,size/2);
            drawFigure(square,x+size/2,y,size/2);
            drawFigure(square,x,y+size/2,size/2);
        }
    }
}