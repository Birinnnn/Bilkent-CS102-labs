import java.util.Scanner;
public class PiCalculator {
    public static void main( String[] args){
        //variables
        Point center, corner;
        Rectangle square;
        Circle circle;
        Scanner sc = new Scanner( System.in );
        int trial,total,hit;
        boolean calculateAgain = true;

        //initializing variables
        center = new Point( 0,0);
        corner = new Point( -2, -2);
        square = new Rectangle( corner, 4,4);
        circle = new Circle(center, 2);

        do{//Works at least 1 time.
            System.out.print( "Welcome to Pi Calculator now enter the number of trials (0 to quit):  ");
            total = sc.nextInt();
            trial = total;
            hit = 0;

            if( total == 0 ){//Input is 0 don't calculate
                calculateAgain = false;
            }
            else if( total < 0 ){//Wrong input
                System.out.println("Input a positive integer please. Let's try again.");
            }

            for(;trial > 0; trial --){//Input is acceptable
                Point temp;
                temp = square.getRandomPoint();

                if( circle.contains( temp )){
                    hit ++;
                }
            }
            if( hit != 0) {
                System.out.println("Pi Number according to " + total + " trials:");
                System.out.println(4.0 * hit / total);
            }
        }while( calculateAgain );

    }
}
